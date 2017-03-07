package main;

public class VariableCopier {
	private VariableCopier(){
	}
	public static void copyToZeroRKStep(Cell[] cells){
		for (int i  = Config.NUM_GHOST_CELL; i < Config.NUM_X_CELL + Config.NUM_GHOST_CELL ; i++) {
			cells[i].u[0] = cells[i].u[Config.NUM_RK_STEPS] ;
		}
	}
}
