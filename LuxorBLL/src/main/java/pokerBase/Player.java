package pokerBase;

import java.util.UUID;
import javax.xml.bind.annotation.XmlElement;

public class Player {

	private UUID PlayerID;
	private String PlayerName;
	
	public Player()
	{
		
	}
	
	public Player(String strPlayerName)
	{
		PlayerID = UUID.randomUUID();
		this.PlayerName = strPlayerName;
		
	}

	@XmlElement
	public UUID getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(UUID playerID) {
		PlayerID = playerID;
	}

	@XmlElement
	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	
	
	
}
