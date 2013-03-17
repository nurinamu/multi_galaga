package org.gdg.suwon.galaga.model;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class Room extends EntityData{
	private static final String KEY_PLAYERS = "PLAYERS";
	private static final String KEY_STATE = "STATE";
	private static final String KEY_TITLE = "TITLE";
	
	private List<Key> players = new ArrayList<Key>();
	private RoomState state = RoomState.READY;
	private String title = "GDG_SUWON";	//FIXME : Temporary room's name until implementing list.
	
	public Room(String title_){
		super(Room.class.getSimpleName(), title_);
		
		entity.setProperty(KEY_PLAYERS, players);
		entity.setProperty(KEY_STATE, state);
		entity.setProperty(KEY_TITLE, title);
	}
	
	public Room(Entity entity_){
		super(entity_);
		
		players = (List<Key>)entity.getProperty(KEY_PLAYERS);
		state = (RoomState)entity.getProperty(KEY_STATE);
		title = (String)entity.getProperty(KEY_STATE);
		
	}
	
	public List<Player> getPlayers(){
		List<Player> retList = new ArrayList<Player>();
		
		Player playerObj = null;
		for(Key player : players){
			playerObj = PlayerMgr.getPlayer(player);
			if(playerObj != null){
				retList.add(playerObj);
			}
		}
		
		return retList;
	}
	
	public void addPlayer(Player newPlayer_){
		players.add(newPlayer_.toEntity().getKey());
	}
	
	public void setState(RoomState newState_){
		state = newState_;
	}
	
	public RoomState getState(){
		return state;
	}
}
