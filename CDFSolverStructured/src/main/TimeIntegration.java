package main;

public class TimeIntegration {
	private TimeIntegration(){
	}
	public static void updateCellAverages(Cell[] cells, int rkStep, double dt){
		for (int i =Config.NUM_GHOST_CELL;
				i < Config.NUM_X_CELL + Config.NUM_GHOST_CELL; i++){
			cells[i].u[rkStep + 1] = cells[i].u[rkStep] + 
					dt / cells[i].dx * cells[i].totalFlux;
			
		}
	}
}
