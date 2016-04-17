package pokerBase;

import java.io.Serializable;
import java.util.UUID;
import javax.xml.bind.annotation.XmlElement;

public class Player implements Serializable  {

	@XmlElement
	private UUID PlayerID;
	
	@XmlElement
	private String PlayerName;
	
	@XmlElement
	private int iPlayerPosition;
	
	public Player()
	{
		
	}
	public Player(String strPlayerName)
	{
		PlayerID = UUID.randomUUID();
		this.PlayerName = strPlayerName;
		this.iPlayerPosition = iPlayerPosition;
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
	@XmlElement
	public int getiPlayerPosition() {
		return iPlayerPosition;
	}
	public void setiPlayerPosition(int iPlayerPosition) {
		this.iPlayerPosition = iPlayerPosition;
	}	
}
