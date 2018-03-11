package com.olr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Entity_Properties_Info")
public class EntityProperty {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="entity_id")
	int entityId;
	
	@Column(name="prop_name")
	String propertyName;
	
	public EntityProperty(){
		
	}
	
	public EntityProperty(int entityId,String propertyName){
		this.entityId = entityId;
		this.propertyName = propertyName;
	}
	
	public int getEntityId() {
		return entityId;
	}
	
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
