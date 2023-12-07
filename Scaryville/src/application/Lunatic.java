package application;

public class Lunatic {
	private int row;
	private int column;
	private MapPane mapPane;
	private GuardControls guard;
	
	
	public Lunatic(MapPane mapPane,GuardControls guard ) {
		this.mapPane = mapPane;
		this.guard = guard;
		
	}
	
	public boolean caughtGuard() {
		return guard.guardCuaght(guard.getColumn(), guard.getRow());
		
	}
	public boolean nodesInSameRow() {
		return true;
	}
	public void movesUP(){
		
	}
	public void movesDown(){
		
	}
	public void movesLeft(){
		
	}
	public void movesRight(){
		
	}
	
	
	

}
