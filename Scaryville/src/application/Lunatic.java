package application;

import java.util.Random;

public class Lunatic {
	private int row;
	private int column;
	private int movementSpeed = 1;
	private MapPane mapPane;
	private GuardControls guard;
	private AsylumMap maze;
	

	public Lunatic(MapPane mapPane, GuardControls guard, AsylumMap maze) {
		this.mapPane = mapPane;
		this.guard = guard;
		this.maze = maze;
		this.row = 18;
		this.column = 18;

	}

	public boolean validMove(int newRow, int newColumn) {
		return maze.getCell(newColumn, newRow) != 'W' && maze.getCell(newColumn, newRow) != 'S'
				&& maze.getCell(newColumn, newRow) != 'E';
	}
	public boolean guardCuaght() {
		return false;
	}

	public boolean guardInSameRow() {
		return guard.getRow() == row;
	}

	public boolean guardInSameColumn() {
		return guard.getColumn() == column;

	}

	public void search(Random random) {

			int randomNum = random.nextInt(4);
			if (randomNum == 1) {
				movesDown(random);
				mapPane.updateMaze();
			}
			if (randomNum == 2) {
				movesLeft(random);
				mapPane.updateMaze();
			}
			if(randomNum == 3) {
				movesRight(random);
				mapPane.updateMaze();
			}
			if(randomNum == 4) {
				movesUp(random);
				mapPane.updateMaze();
			}
	}

	public void movesUp(Random random) {
		
			int newRow = row - movementSpeed;
			if (guardInSameColumn() && validMove(newRow, column)) {
				maze.getMyArray()[column][row].setEmptySpace(' ');
				row = newRow;
				maze.getMyArray()[column][row].setEmptySpace('L');
				mapPane.updateMaze();
			} else {
				search(random);
			}

	}

	public void movesDown(Random random) {
		int newRow = row + movementSpeed;
		if (guardInSameColumn() && validMove(newRow, column)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			row = newRow;
			maze.getMyArray()[column][row].setEmptySpace('L');
			mapPane.updateMaze();
		} else {
			search(random);
		}
	}

	public void movesLeft(Random random) {
		int newColumn = column - movementSpeed;
		if (guardInSameColumn() && validMove(row, newColumn)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			column = newColumn;
			maze.getMyArray()[column][row].setEmptySpace('L');
		}else {
			search(random);
		}
	}

	public void movesRight(Random random) {
		int newColumn = column + movementSpeed;
		if (guardInSameColumn() && validMove(row, newColumn)) {
			maze.getMyArray()[column][row].setEmptySpace(' ');
			column = newColumn;
			maze.getMyArray()[column][row].setEmptySpace('L');

		}else {
			search(random);
		}
	}
	
	public void lunaticMovement(Random random) {
		while(guardCuaght() == false) {
			movesUp(random);
		}
	}

}
