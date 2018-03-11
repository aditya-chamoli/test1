package com.olr.model;

import java.util.List;

public class Entity {
	private int entityId;
	private String name;
	private List<String> simpleTypes;
	private List<Entity> complexTypes;
	
	public Entity(String name, List<String> simpleTypes, List<Entity> complexTypes) {
		this.name = name;
		this.simpleTypes = simpleTypes;
		this.complexTypes = complexTypes;
	}
	
	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSimpleTypes() {
		return simpleTypes;
	}
	public void setSimpleTypes(List<String> simpleTypes) {
		this.simpleTypes = simpleTypes;
	}
	public List<Entity> getComplexTypes() {
		return complexTypes;
	}
	public void setComplexTypes(List<Entity> complexTypes) {
		this.complexTypes = complexTypes;
	}
	
	
}
