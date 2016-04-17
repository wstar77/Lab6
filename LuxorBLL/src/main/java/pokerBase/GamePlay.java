package pokerBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class GamePlay implements Serializable   {

	private UUID GameID;
	private int MaxNbrOfPlayers;
	private int NbrOfCards;
	private int NbrOfJokers;
	private ArrayList<Card> WildCards = new ArrayList<Card>();
	
	private ArrayList<Player> GamePlayers = new ArrayList<Player>();
	private ArrayList<GamePlayPlayerHand> GamePlayerHand = new ArrayList<GamePlayPlayerHand>();
	private ArrayList<GamePlayPlayerHand> GameCommonHand = new ArrayList<GamePlayPlayerHand>();
	private Rule rle;
	private Deck GameDeck = null;
	
	public GamePlay(Rule rle)
	{
		this.setGameID(UUID.randomUUID());
		this.setNbrOfCards(rle.GetPlayerNumberOfCards());
		this.setMaxNbrOfPlayers(rle.GetMaxNumberOfPlayers());
		this.setNbrOfJokers(rle.GetNumberOfJokers());
		this.setWildCards(rle.GetRuleCards());
		this.rle = rle;
	}

	public UUID getGameID() {
		return GameID;
	}

	public void setGameID(UUID gameID) {
		GameID = gameID;
	}

	public int getMaxNbrOfPlayers() {
		return MaxNbrOfPlayers;
	}

	public void setMaxNbrOfPlayers(int maxNbrOfPlayers) {
		MaxNbrOfPlayers = maxNbrOfPlayers;
	}

	public int getNbrOfCards() {
		return NbrOfCards;
	}

	public void setNbrOfCards(int nbrOfCards) {
		NbrOfCards = nbrOfCards;
	}

	public int getNbrOfJokers() {
		return NbrOfJokers;
	}

	public void setNbrOfJokers(int nbrOfJokers) {
		NbrOfJokers = nbrOfJokers;
	}

	public ArrayList<Card> getWildCards() {
		return WildCards;
	}

	public void setWildCards(ArrayList<Card> wildCards) {
		WildCards = wildCards;
	}

	public Rule getRule()
	{
		return this.rle;
	}
	public ArrayList<Player> getGamePlayers() {
		return GamePlayers;
	}

	public void setGamePlayers(ArrayList<Player> gamePlayers) {
		GamePlayers = gamePlayers;
	}
	
	public void addPlayerToGame(Player p)
	{
		GamePlayers.add(p);
	}

	public Deck getGameDeck() {
		return GameDeck;
	}

	public void setGameDeck(Deck gameDeck) {
		GameDeck = gameDeck;
	}
	
	public void addGamePlayPlayerHand(GamePlayPlayerHand GPPH)
	{
		GamePlayerHand.add(GPPH);
	}
	
	public void addGamePlayCommonHand(GamePlayPlayerHand GPCH)
	{
		GameCommonHand.add(GPCH);
	}

	public GamePlayPlayerHand FindCommonHand(GamePlay gme)
	{
		GamePlayPlayerHand GPCH = null;
		for (GamePlayPlayerHand GPPH: GameCommonHand)
		{
			if (GPPH.getGame().getGameID() == gme.getGameID())
			{
				GPCH = GPPH;
			}
		}		
		return GPCH;
	}
	
/*	public GamePlayPlayerHand FindPlayerGame(GamePlay gme, Player p)
	{
		GamePlayPlayerHand GPPHReturn = null;
		
	
		for (GamePlayPlayerHand GPPH: GamePlayerHand)
		{
			if (p.getiPlayerPosition() == GPPH.getPlayer().getiPlayerPosition())
			{
				GPPHReturn = GPPH;
			}
		}
		return GPPHReturn;
	}*/
	
	
}
