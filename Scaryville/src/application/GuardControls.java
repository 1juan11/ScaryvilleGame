package application;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GuardControls {
    AsylumMap maze;
    private int row;
    private int column;
    private MapPane mapPane;

    public GuardControls(AsylumMap maze) {
        this.maze = maze;
        this.row = 1;
        this.column = 1;
        
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
        return maze.getCell(newColumn, newRow) != 'W';
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
        if (validMove(newRow, column) == true) {
        	maze.getMyArray()[column][row].setEmptySpace(' ');
            row = newRow;
        	maze.getMyArray()[column][row].setEmptySpace('S');

        }
    }
    public void handleKeyPresss(KeyEvent event) {
        
        if(event.getCode() == KeyCode.W) {
        	System.out.println("W was pressed!");
        	movesUp();
        	updatedMazeWGaurd();
        	
        	
        }
        if(event.getCode() == KeyCode.S) {
        	System.out.println("S was pressed!");
        	movesDown();
        	updatedMazeWGaurd();
        }
    }
    public void updatedMazeWGaurd() {
    	maze.printMaze();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void validMoveToString(int newRow, int newColumn) {
        if (validMove(newRow, newColumn) == true) {
            System.out.println("Guard made a valid move.");
            mapPane.updateMaze();
        } else {
            System.out.println("Invalid Move!");
        }
    }
}
