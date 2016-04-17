package pokerBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Table implements Serializable {
	
	@XmlElement
	private UUID TableID;
	
	@XmlElement
	private HashMap HashMapPlayer = new HashMap<UUID, Player>();
	
	public Table()
	{
		TableID = UUID.randomUUID();
	}
	public Table AddPlayerToTable(Player p)
	{
		HashMapPlayer.put(p.getPlayerID(), p);
		return this;
	}
	public Table RemovePlayerFromTable(Player p)
	{
		HashMapPlayer.remove(p.getPlayerID());
		return this;
	}
	public HashMap getHashPlayers() {
		return HashMapPlayer;
	}
}
