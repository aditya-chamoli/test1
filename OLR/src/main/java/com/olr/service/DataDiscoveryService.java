package com.olr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olr.dao.EntityDao;
import com.olr.model.Entity;

@Service
public class DataDiscoveryService {
	
	@Autowired
	private EntityDao entityDao;
	
	public int addEntity(Entity entity){
		return entityDao.add(entity);
	}
	
	public Entity getEntity(int entityId){
		return entityDao.get(entityId);
	}

}
