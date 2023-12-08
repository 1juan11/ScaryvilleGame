package application;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage){
		AsylumMap asylumMap = new AsylumMap(20, 20);
		MapPane mapPane = new MapPane(asylumMap);
		GuardControls guardControls = new GuardControls(asylumMap, mapPane);


		BorderPane gui = new BorderPane();
		gui.getStyleClass().add("border-pane");
		gui.setCenter(mapPane);

		
		Label instructions = new Label("To move around use       \n \n             W\n "
				+ "         A S D \n\n");
		instructions.getStyleClass().add("instr-label");

		Label blank = new Label("                        ");
		Button resetButton = createResetButton(asylumMap, mapPane, guardControls);

		HBox bottomContainer = new HBox(instructions,blank, resetButton);
		bottomContainer.setAlignment(Pos.TOP_CENTER);
		gui.setBottom(bottomContainer);
		
		mapPane.updateMaze();
		Scene scene = new Scene(gui, 640, 800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		scene.setOnKeyPressed(guardControls::handleKeyPresss);

		primaryStage.setTitle("Scaryville");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Button createResetButton(AsylumMap asylumMap, MapPane mapPane, GuardControls guardControls) {
		Button resetButton = new Button("Reset");
		resetButton.getStyleClass().add("button-styled");

		resetButton.setOnMouseEntered(event -> {
			resetButton.getStyleClass().addAll("button-styled", "hover-styled");
		});

		resetButton.setOnMouseExited(event -> {
			resetButton.setStyle("");
		});

		resetButton.setOnAction(event -> {
			asylumMap.generateMaze(new Random());
			mapPane.updateMaze();
			guardControls.resetGaurd();
		});
		return resetButton;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
