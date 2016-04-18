package poker.app.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exceptions.DeckException;
import netgame.common.Hub;
import pokerBase.Action;
import pokerBase.Card;
import pokerBase.Deck;
import pokerBase.GamePlay;
import pokerBase.GamePlayPlayerHand;
import pokerBase.Player;
import pokerBase.Rule;
import pokerBase.Table;
import pokerEnums.eAction;
import pokerEnums.eGame;
import pokerEnums.eGameState;

public class PokerHub extends Hub {

	private Table HubPokerTable = new Table();
	private GamePlay HubGamePlay;
	private int iDealNbr = 0;
	//private PokerGameState state;
	private eGameState eGameState;

	public PokerHub(int port) throws IOException {
		super(port);
	}

	protected void playerConnected(int playerID) {

		if (playerID == 2) {
			shutdownServerSocket();
		}
	}

	protected void playerDisconnected(int playerID) {
		shutDownHub();
	}

	protected void messageReceived(int playerID, Object message) {

		if (message instanceof Action) {
			Action act = (Action) message;
			switch (act.getAction()) {
			case GameState:
				sendToAll(HubPokerTable);
				break;
			case TableState:
				resetOutput();
				sendToAll(HubPokerTable);
			case Sit:
				resetOutput();
				act.getPlayer().setiPlayerPosition(act.getiPlayerPosition());
				HubPokerTable.AddPlayerToTable(act.getPlayer());				
				sendToAll(HubPokerTable);				
				break;
			case Leave:
				resetOutput();
				HubPokerTable.RemovePlayerFromTable(act.getPlayer());
				sendToAll(HubPokerTable);				
				break;
				
			case StartGame:
				System.out.println("Starting Game!");
				// Get the Rule
				Rule r = new Rule(eGame.FiveStud);
				// Start the new Game
				HubGamePlay = new GamePlay(r);

				// Add the seated players to the game
				Iterator it = HubPokerTable.getHashPlayers().entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					HubGamePlay.addPlayerToGame((Player) pair.getValue());
					
					GamePlayPlayerHand GPPH = new GamePlayPlayerHand(HubGamePlay,(Player) pair.getValue());
					HubGamePlay.addGamePlayPlayerHand(GPPH);					
				}

				// Create the deck
				HubGamePlay.setGameDeck(new Deck());
				iDealNbr = 0;
				
				sendToAll(HubGamePlay);
				break;
			case Deal:
				
				int iCardstoDraw[] = HubGamePlay.getRule().getiCardsToDraw();
				int iDrawCount = iCardstoDraw[iDealNbr];

				for (int i = 0; i<iDrawCount; i++)
				{
					try {
						Card c = HubGamePlay.getGameDeck().Draw();
					} catch (DeckException e) {
						e.printStackTrace();
					}
				}

				break;
			}
		}

		System.out.println("Message Received by Hub");
	}


}