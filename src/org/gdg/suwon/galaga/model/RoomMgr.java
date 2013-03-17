package org.gdg.suwon.galaga.model;


public class RoomMgr {
	public static Room createNewRoom(String room_){
		Room retRoom = getRoom(room_);
		
		if(retRoom == null){
			retRoom = new Room(room_);
		}
		
		return retRoom;
	}
	
	public static Room getRoom(String room_){
		return null;
	}
}
