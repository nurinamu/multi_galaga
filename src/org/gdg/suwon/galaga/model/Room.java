package org.gdg.suwon.galaga.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<Player> players = new ArrayList<Player>();
	private RoomState state = RoomState.READY;
	private String title = null;
	
	public Room(){
		
	}
	
	public List<Player> getPlayers(){
		return null;
	}
	
	public void addPlayer(Player newPlayer_){
		players.add(newPlayer_);
	}
	
	public void setState(RoomState newState_){
		state = newState_;
	}
	
	public RoomState getState(){
		return state;
	}
}
