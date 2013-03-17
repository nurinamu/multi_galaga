package org.gdg.suwon.galaga;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gdg.suwon.galaga.model.Player;
import org.gdg.suwon.galaga.model.Room;
import org.gdg.suwon.galaga.model.RoomMgr;

public class EnterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userId = req.getParameter("id");
		Room room = RoomMgr.getRoom("gdgSuwon");
		List<Player> players = room.getPlayers();
		String roomToken = room.getToken();
		Boolean samePlayer = false;
		for(Player player : players){
			if(player.getId().equals(userId)){
				//send error.
				resp.getWriter().write("{status : fail, msg: duplicate id, id:"+null+", token:"+roomToken+"}");
				samePlayer = true;
				break;
			}else{
				samePlayer = false;
			}
		}
		if(!samePlayer){
			//send success
			resp.getWriter().write("{status : success, msg :"+null+", id:"+userId+", token:"+roomToken+"}");
		}
	}
}
