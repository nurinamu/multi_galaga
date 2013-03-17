package org.gdg.suwon.galaga.model;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class EntityData {
	protected Entity entity;
	
	public EntityData(String kind, String keyName_){
		entity = new Entity(kind, keyName_);
	}
	
	public EntityData(Entity entity_){
		entity = entity_;
	}
	
	public Entity toEntity(){
		return entity;
	}
	
	public void validate(){
		DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();
		
		dataStoreService.put(entity);
	}
}
