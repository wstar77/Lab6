package base;

import java.io.IOException;

import base.view.ClientServerStartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main  extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public static void main(String[] args) {
        launch(args);
    }
	
    @Override
    public void start(Stage primaryStage) throws Exception {

    	//	START is executed by the Application framework after INIT
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 1300, 500);

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Poker");

		this.primaryStage.setScene(scene);
		this.primaryStage.show();

		showClientServer();

    }
    
	public void showClientServer() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/ClientServerStart.fxml"));
			BorderPane pokerOverview = (BorderPane) loader.load();

			Scene scene = new Scene(pokerOverview);
			
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			ClientServerStartController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
