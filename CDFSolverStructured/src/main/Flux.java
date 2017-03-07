package main;

public class Flux {
	private Flux(){
	}
	public static void calculateFlux(Cell[] cells, int rkStep) {
		for(Cell cell: cells){
			cell.totalFlux = 0.0;
		}
		for (int interfaceIndex =Config.NUM_GHOST_CELL;
				interfaceIndex < Config.NUM_X_CELL + Config.NUM_GHOST_CELL + 1; interfaceIndex++){
			double leftValue = cells[interfaceIndex-1].uEast;
			double rightValue = cells[interfaceIndex].uWest;
			
			// Lax-Friedrichs scheme
			double flux = 0.5 * Config.ADVECTION_VEL * (leftValue + rightValue)
					- 0.5 * Math.abs(Config.ADVECTION_VEL) * (rightValue - leftValue) ;
			cells[interfaceIndex - 1].totalFlux -= flux;
			cells[interfaceIndex].totalFlux += flux;
		}
	}
}
	
