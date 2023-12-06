package application;

public class Coordinate {

    private int rows;
    private int columns;

    private char emptySpace = ' ';
    private char wall = 'W';
    private char startingPoint = 'S';
    private char exit = 'E';

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public char getEmptySpace() {
        return emptySpace;
    }

    public void setEmptySpace(char emptySpace) {
        this.emptySpace = emptySpace;
    }

    public char getWall() {
        return wall;
    }

    public void setWall(char wall) {
        this.wall = wall;
    }

    public char getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(char startingPoint) {
        this.startingPoint = startingPoint;
    }

    public char getExit() {
        return exit;
    }

    public void setExit(char exit) {
        this.exit = exit;
    }
}
