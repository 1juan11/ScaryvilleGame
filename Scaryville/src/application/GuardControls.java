package application;

import java.util.Random;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GuardControls {
	AsylumMap maze;
	private int row;
	private int column;
	private MapPane mapPane;

	public GuardControls(AsylumMap maze, MapPane mapPane) {
		this.maze = maze;
		this.mapPane = mapPane;
		this.row = 1;
		this.column = 1;

	}

	public int getRow() {

		return row;
	}

	public int getColumn() {
		return column;
	}

	public void resetGaurd() {
		row = 1;
		column = 1;
	}

	public void getGaurdPosition() {
		row = getRow();
		column = getColumn();
	}

	public boolean validMove(int newRow, int newColumn) {
		return maze.getCell(newColumn, newRow) != 'W' && maze.getCell(newColumn, newRow) != 'L';
	}


	private void movesUp() {
		int newRow = row - 1;
		if (validMove(newRow, column)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			row = newRow;
			maze.getMyArray()[column][row].setEmptySpace('S');

		}
	}

	private void movesDown() {
		int newRow = row + 1;
		if (validMove(newRow, column)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			row = newRow;
			maze.getMyArray()[column][row].setEmptySpace('S');

		}
	}

	private void movesLeft() {
		int newColumn = column - 1;
		if (validMove(row, newColumn)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			column = newColumn;
			maze.getMyArray()[column][row].setEmptySpace('S');

		}
	}

	private void movesRight() {
		int newColumn = column + 1;
		if (validMove(row, newColumn)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			column = newColumn;
			maze.getMyArray()[column][row].setEmptySpace('S');

		}
	}

	public void handleKeyPresss(KeyEvent event) {

		if (event.getCode() == KeyCode.W) {
			System.out.println("W was pressed!");
			movesUp();
			updatedMazeWGaurd();
		}
		if (event.getCode() == KeyCode.S) {
			System.out.println("S was pressed!");
			movesDown();
			updatedMazeWGaurd();
		}
		if (event.getCode() == KeyCode.A) {
			System.out.println("A was pressed!");
			movesLeft();
			updatedMazeWGaurd();

		}
		if (event.getCode() == KeyCode.D) {
			System.out.println("D was pressed!");
			movesRight();
			updatedMazeWGaurd();
		} else if (event.getCode() == KeyCode.F10) {
            maze.generateMaze(new Random());
            mapPane.updateMaze();
            resetGaurd();
        }
		if(maze.getCell(18, 18) == 'S') {
        	mapPane.updateMaze();
        }
		mapPane.updateMaze();

	}

	public void updatedMazeWGaurd() {
		maze.printMaze();
	}

}
