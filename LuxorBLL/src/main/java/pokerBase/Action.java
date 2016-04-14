package pokerBase;

import pokerEnums.eAction;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Action {

	@XmlElement
	private eAction Action;

	@XmlElement
	private Player ActPlayer;
	
	public Action()
	{
		
	}
	public Action(eAction action, Player player) {
		super();
		Action = action;
		this.ActPlayer = player;
	}


	public eAction getAction() {
		return Action;
	}
	
	public void setAction(eAction action) {
		Action = action;
	}
	public Player getPlayer() {
		return ActPlayer;
	}
	public void setPlayer(Player player) {
		this.ActPlayer = player;
	}

	
	
	
}
