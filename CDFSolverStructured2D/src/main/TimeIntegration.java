package main;

public class TimeIntegration {
	private TimeIntegration(){
	}
	public static void updateCellAverages(Cell[][] cells, int rkStep, double dt){
		double area = cells[0][0].dx * cells[0][0].dy;
		for (int i =Config.NUM_GHOST_CELL; i < Config.NUM_X_CELL + Config.NUM_GHOST_CELL; i++){
			for (int j =Config.NUM_GHOST_CELL; j < Config.NUM_Y_CELL + Config.NUM_GHOST_CELL; j++){
				cells[i][j].u[rkStep + 1] = cells[i][j].u[rkStep] + dt / area * cells[i][j].totalFlux;
			}
			
		}
	}
}
