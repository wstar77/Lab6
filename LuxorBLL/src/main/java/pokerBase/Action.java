package pokerBase;

import pokerEnums.eAction;

import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Action implements Serializable {

	@XmlElement
	private eAction eAction;

	@XmlElement
	private Player ActPlayer;
	
	private int iPlayerPosition;
	
	public Action()
	{
		
	}
	public Action(eAction eAction, Player player) {
		super();
		this.eAction = eAction;
		this.ActPlayer = player;
	}


	public eAction getAction() {
		return eAction;
	}
	
	public void setAction(eAction action) {
		eAction = action;
	}
	public Player getPlayer() {
		return ActPlayer;
	}
	public void setPlayer(Player player) {
		this.ActPlayer = player;
	}
	public int getiPlayerPosition() {
		return iPlayerPosition;
	}
	public void setiPlayerPosition(int iPlayerPosition) {
		this.iPlayerPosition = iPlayerPosition;
	}

	
	
	
}
