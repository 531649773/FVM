package main;

public class VariableCopier {
	private VariableCopier(){
	}
	public static void copyToZeroRKStep(Cell[][] cells){
		for (int i  = Config.NUM_GHOST_CELL; i < Config.NUM_X_CELL + Config.NUM_GHOST_CELL ; i++) {
			for (int j  = Config.NUM_GHOST_CELL; j < Config.NUM_Y_CELL + Config.NUM_GHOST_CELL ; j++) {
				cells[i][j].u[0] = cells[i][j].u[Config.NUM_RK_STEPS] ;
			}
		}
	}
}
