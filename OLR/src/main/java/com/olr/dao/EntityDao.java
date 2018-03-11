package com.olr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.olr.model.Entity;
import com.olr.model.EntityBasic;
import com.olr.model.EntityDependency;
import com.olr.model.EntityProperty;

public class EntityDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	public int add(Entity entity) {	
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		int entityId = -1;
		
		List<Integer> eIds = new ArrayList<>();
		for(Entity e: entity.getComplexTypes()){
			eIds.add((Integer)session.save(new EntityBasic(e.getName())));
		}
		
		entityId = (Integer)session.save(new EntityBasic(entity.getName()));
		
		for(Integer id:eIds){
			session.save(new EntityDependency(entityId,id));
		}
		
		for(String propName:entity.getSimpleTypes()){
			session.save(new EntityProperty(entityId,propName));
		}
		
		tx.commit();
		session.close();
		
		return entityId;
	}
	
	public Entity get(int entityId) {	
		
		Session session = this.sessionFactory.openSession();
		
		EntityBasic basicInfo = (EntityBasic)session.get(EntityBasic.class, entityId);
		List<EntityProperty> props = session.createQuery("from EntityProperty ep where ep.entityId = "+entityId).list();
		List<EntityDependency> depIds = session.createQuery("from EntityDependency ed where ed.entityId = "+entityId).list();
		
		List<String> propNames = new ArrayList<>();
		for(EntityProperty ep:props){
			propNames.add(ep.getPropertyName());
		}
		
		List<Entity> depEntities = new ArrayList<>();
		Entity e = null;
		EntityBasic eb = null;
		for(EntityDependency ed:depIds){
			eb = (EntityBasic)session.get(EntityBasic.class, ed.getDepEntityId());
			e = new Entity(eb.getName(),null,null);
			e.setEntityId(ed.getDepEntityId());
			depEntities.add(e);
		}
		
		Entity entity = new Entity(basicInfo.getName(),propNames,depEntities);
		entity.setEntityId(entityId);
		session.close();
		
		return entity;
	}
	
}
