package org.gdg.suwon.galaga.model;

import com.google.appengine.api.datastore.Entity;


public class Player extends EntityData {
	
	private String id;
	
	private String state = PlayerState.IDLE;
	
	private Long score = (long)0;
	
	public Player(String id_){
		super(Player.class.getSimpleName(), id_);
		id = id_;
		entity.setProperty("ID", id);
		entity.setProperty("STATE", state);
		entity.setProperty("SCORE",score);
	}
	
	public Player(Entity entity_){
		super(entity_);
		id = (String)entity.getProperty("ID");
		state = (String)entity.getProperty("STATE");
		score = (Long)entity.getProperty("SCORE");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	
}
