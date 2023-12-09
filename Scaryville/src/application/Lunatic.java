package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

public class Lunatic {
    private int row;
    private int column;
    private int movementSpeed = 1;
    private MapPane mapPane;
    private GuardControls guard;
    private AsylumMap maze;
    private Timeline lunaticTimeline;

    public Lunatic(MapPane mapPane, GuardControls guard, AsylumMap maze) {
        this.mapPane = mapPane;
        this.guard = guard;
        this.maze = maze;
        this.row = 18;
        this.column = 18;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void resetLunatic() {
        row = 18;
        column = 18;
    }

    public boolean validMove(int newRow, int newColumn) {
        return maze.getCell(newColumn, newRow) != 'W' && maze.getCell(newColumn, newRow) != 'S'
                && maze.getCell(newColumn, newRow) != 'E';
    }

    public boolean guardCaught() {
        return guard.getRow() == row && guard.getColumn() == column;
    }

    private int getDistanceToGuard() {
        return Math.abs(row - guard.getRow()) + Math.abs(column - guard.getColumn());
    }

    private boolean moveTowardsGuard() {
        int guardRow = guard.getRow();
        int guardColumn = guard.getColumn();

        if (row < guardRow && validMove(row + movementSpeed, column)) {
            movesDown();
            return true;
        } else if (row > guardRow && validMove(row - movementSpeed, column)) {
            movesUp();
            return true;
        } else if (column < guardColumn && validMove(row, column + movementSpeed)) {
            movesRight();
            return true;
        } else if (column > guardColumn && validMove(row, column - movementSpeed)) {
            movesLeft();
            return true;
        }

        return false;
    }

    private boolean moveRandomly() {
        int randomNum = new Random().nextInt(4);
        if (randomNum == 0) {
            movesDown();
            return true;
        } else if (randomNum == 1) {
            movesUp();
            return true;
        } else if (randomNum == 2) {
            movesRight();
            return true;
        } else if (randomNum == 3) {
            movesLeft();
            return true;
        }

        return false;
    }

    private void move() {
        if (getDistanceToGuard() <= 5) {
            if (!moveTowardsGuard()) {
                moveRandomly();
            }
        } else {
            moveRandomly();
        }

        mapPane.updateMaze();

        System.out.println("Lunatic: row = " + row + ", column = " + column);
        System.out.println("Guard: row = " + guard.getRow() + ", column = " + guard.getColumn());
    }

    private Timeline createTimeline() {
        double delay = 100;
        return new Timeline(
                new KeyFrame(Duration.millis(delay), event -> {
                    if (!guardCaught()) {
                        move();
                    } else {
                        lunaticTimeline.stop();
                        System.out.println("Lunatic caught the guard!");
                    }
                })
        );
    }

    public void search() {
        lunaticTimeline = createTimeline();
        lunaticTimeline.setCycleCount(Timeline.INDEFINITE);
        lunaticTimeline.play();
    }

    public void movesUp() {
        int newRow = row - movementSpeed;
        if (validMove(newRow, column)) {
            maze.getMyArray()[column][row].setEmptySpace(' ');
            row = newRow;
            maze.getMyArray()[column][row].setEmptySpace('L');
            mapPane.updateMaze();
        }
    }

    public void movesDown() {
        int newRow = row + movementSpeed;
        if (validMove(newRow, column)) {
            maze.getMyArray()[column][row].setEmptySpace(' ');
            row = newRow;
            maze.getMyArray()[column][row].setEmptySpace('L');
            mapPane.updateMaze();
        }
    }

    public void movesLeft() {
        int newColumn = column - movementSpeed;
        if (validMove(row, newColumn)) {
            maze.getMyArray()[column][row].setEmptySpace(' ');
            column = newColumn;
            maze.getMyArray()[column][row].setEmptySpace('L');
            mapPane.updateMaze();
        }
    }

    public void movesRight() {
        int newColumn = column + movementSpeed;
        if (validMove(row, newColumn)) {
            maze.getMyArray()[column][row].setEmptySpace(' ');
            column = newColumn;
            maze.getMyArray()[column][row].setEmptySpace('L');
            mapPane.updateMaze();
        }
    }
}
