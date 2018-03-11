package com.olr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Entity_Dependency_Info")
public class EntityDependency {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="entity_id")
	int entityId;
	
	@Column(name="dep_entity_id")
	int depEntityId;
	
	public EntityDependency(){
		
	}
	
	public EntityDependency(int entityId,int depEntityId){
		this.entityId = entityId;
		this.depEntityId = depEntityId;
	}
	
	public int getEntityId() {
		return entityId;
	}
	
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	
	public int getDepEntityId() {
		return depEntityId;
	}
	
	public void setDepEntityId(int depEntityId) {
		this.depEntityId = depEntityId;
	}
	
	
}
