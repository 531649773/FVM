package main;

public class VariableReconstructor {
	private VariableReconstructor(){
	}
	public static void reconstructVariables(Cell[] cells, int rkStep){
		for (int i = Config.NUM_GHOST_CELL - 1; 
				i < Config.NUM_X_CELL+Config.NUM_GHOST_CELL +1; i++){
			cells[i].uWest = cells[i].u[rkStep];
			cells[i].uEast = cells[i].u[rkStep];
		}
	}
}
