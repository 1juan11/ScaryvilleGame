package application;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        AsylumMap asylumMap = new AsylumMap(20, 20);
        MapPane mapPane = new MapPane(asylumMap);
        GuardControls guardControls = new GuardControls(asylumMap, mapPane);
        


        VBox vbox = new VBox(mapPane, createResetButton(asylumMap, mapPane, guardControls));
        vbox.setSpacing(15);
        vbox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.getStyleClass().add("border-pane");
        root.setCenter(vbox);
        mapPane.updateMaze();
        Scene scene = new Scene(root, 640, 800);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        scene.setOnKeyPressed(guardControls::handleKeyPresss);


        primaryStage.setTitle("Scaryville");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createResetButton(AsylumMap asylumMap, MapPane mapPane,GuardControls guardControls) {
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
