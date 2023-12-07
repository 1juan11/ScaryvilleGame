package application;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MapPane extends BorderPane {

	private AsylumMap maze;

	public MapPane(AsylumMap maze) {
		this.maze = maze;

		generateBoard();		
	}

	public void updateMaze() {
		((GridPane) getCenter()).getChildren().clear();
		generateBoard();

	}
	

	public void generateBoard() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		
		for (int i = 0; i < maze.getRows(); i++) {
			for (int j = 0; j < maze.getColumns(); j++) {
				char cellChar = maze.getCell(i, j);

				Label label = new Label(String.valueOf(cellChar));

				label.setMinSize(32, 32);
				label.setStyle("-fx-border-width: 0.4;");
				if (cellChar == 'S') {
					label.getStyleClass().add("guard-label");
				}
				if (cellChar == 'E') {
					label.getStyleClass().add("end-label");
				}
				if (cellChar == 'W') {
					label.getStyleClass().add("wall-label");
				}
				if (cellChar == ' ') {
					label.getStyleClass().add("default-label");
				}
				if(cellChar == 'L') {
					label.getStyleClass().add("lunatic-label");
				}
				gridPane.add(label, i, j);
			}
		}


		setCenter(gridPane);
	}

}
