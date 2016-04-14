package poker.app;

import java.io.IOException;

import base.Client;
import base.Main;
import base.NetworkConnection;
import base.Server;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import poker.app.view.ClientServerStartController;
import poker.app.view.PokerTableController;
import poker.app.view.RootLayoutController;
import pokerBase.Player;
import pokerBase.Table;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
		
	private RootLayoutController rootController = null;
	
    private boolean isServer = false;

    private TextArea messages = new TextArea();
    private NetworkConnection connection =  createClient();

    private Player player = new Player("Bob");
        
    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
    	//	INIT is executed by the Application framework FIRST
        connection.startConnection();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    	//	START is executed by the Application framework after INIT
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 1300, 500);

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Poker");

		// Set the application icon.
		// this.primaryStage.getIcons().add(new
		// Image(getClass().getResourceAsStream("/res/img/26.png")));

		this.primaryStage.setScene(scene);
		this.primaryStage.show();

		showClientServer();
		


    }
    
    public void showPoker()
    {
		initRootLayout();

		showPokerTable();
    }

	public void showClientServer() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ClientServerStart.fxml"));
			BorderPane ClientServerOverview = (BorderPane) loader.load();

			Scene scene = new Scene(ClientServerOverview);
			
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			ClientServerStartController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			// RootLayoutController controller = loader.getController();
			rootController = loader.getController();

			rootController.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showPokerTable() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PokerTable.fxml"));
			BorderPane pokerOverview = (BorderPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(pokerOverview);

			// Give the controller access to the main app.
			PokerTableController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }


    private Client createClient() {
        return new Client("127.0.0.1", 55555, data -> {
            Platform.runLater(() -> {
            	System.out.println("Data Receieved By Client " + data.toString() + "\n");
                //messages.appendText(data.toString() + "\n");
            });
        });
    }


    
	public void SendMessage(String message)
	{
		try {
			connection.send(message);
		} catch (Exception e) {
			System.out.println("Message failed to send");
			e.printStackTrace();
			messages.appendText("Failed to send\n");
		}
	}
	
	
	
	
}
