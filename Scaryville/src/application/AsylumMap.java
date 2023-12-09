package application;

import java.util.Random;

public class AsylumMap {

	private Coordinate[][] asylumMaze;
	private int rows;
	private int columns;

	public AsylumMap(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.asylumMaze = new Coordinate[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				asylumMaze[j][i] = new Coordinate();
			}
		}
		generateMaze(new Random());
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public char getCell(int row, int column) {
		return asylumMaze[row][column].getEmptySpace();
	}

	public void generateMaze(Random random) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Coordinate currentCoordinate = asylumMaze[j][i];
				
				int randomNum = random.nextInt(5);

				if (i == 1 && j == 1) {
					System.out.print("S ");
					currentCoordinate.setEmptySpace('S');
				} else if (i == rows - 1 && j == columns - 2) {
					System.out.print("E ");
					currentCoordinate.setEmptySpace('E');
				} else if(i == 18 && j == 18){
					System.out.print("L ");
					currentCoordinate.setEmptySpace('L');
					
				}else if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1 || randomNum == 0) {
					System.out.print("W ");
					currentCoordinate.setEmptySpace('W');
					
				}else {
					currentCoordinate.setEmptySpace(' ');
					System.out.print("  ");
				}
			}
			System.out.println("");
			
		}
		System.out.println("\n\nPrints matrix\n");
		printMaze();
	}

	public Coordinate[][] getMyArray() {
		return asylumMaze;
	}

	public void printMaze() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				char cellChar = asylumMaze[j][i].getEmptySpace();
				System.out.print(cellChar);
			}
			System.out.println("");
		}

	}

}
