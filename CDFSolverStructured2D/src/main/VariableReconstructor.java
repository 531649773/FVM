package main;

public class VariableReconstructor {
	private VariableReconstructor(){
	}
	public static void reconstructVariables(Cell[][] cells, int rkStep){
		for (int i = Config.NUM_GHOST_CELL - 1; 
				i < Config.NUM_X_CELL+Config.NUM_GHOST_CELL +1; i++){
			for (int j = Config.NUM_GHOST_CELL - 1 ; 
					j < Config.NUM_Y_CELL+Config.NUM_GHOST_CELL +1; j++){
				cells[i][j].uWest = cells[i][j].u[rkStep];
				cells[i][j].uEast = cells[i][j].u[rkStep];
				cells[i][j].uSouth = cells[i][j].u[rkStep];
				cells[i][j].uNorth = cells[i][j].u[rkStep];
			}
		}
	}
}
