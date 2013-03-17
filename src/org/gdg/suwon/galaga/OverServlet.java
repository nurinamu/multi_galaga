package org.gdg.suwon.galaga;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gdg.suwon.galaga.model.Player;
import org.gdg.suwon.galaga.model.PlayerState;
import org.gdg.suwon.galaga.model.Room;
import org.gdg.suwon.galaga.model.RoomMgr;
import org.gdg.suwon.galaga.model.RoomState;

public class OverServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userId = req.getParameter("id");
		Room room = RoomMgr.getRoom("gdgSuwon");
		List<Player> players = room.getPlayers();
		Boolean sentSuccess = false;
		Boolean allEnd = false;
		Integer countEnd = 0;
		
		for(Player player : players){
			if(player.getId().equals(userId)){
				//change status into END
				player.setState(PlayerState.END);
				resp.getWriter().write("{status : success}");
				sentSuccess = true;
				continue;
			}else{
				if(player.getState() != PlayerState.END){
					break;
				}else{
					countEnd++;
					if(countEnd == players.size()){
						RoomMgr.getRoom("gdgSuwon").setState(RoomState.END);
						resp.getWriter().write("{status : Game End}");
					}
				}
			}
		}
	}


}
