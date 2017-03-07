package main;

public class Flux {
	private Flux(){
	}
	public static void calculateFlux(Cell[][] cells, int rkStep) {
		for(Cell[] cellRow: cells){
			for(Cell cell: cellRow){
				cell.totalFlux = 0.0;
			}
		}
		
		double dx = cells[0][0].dx;
		double dy = cells[0][0].dy;
		
		//Flux calculation for all vertical edges
		for (int j = Config.NUM_GHOST_CELL; j<Config.NUM_Y_CELL+Config.NUM_GHOST_CELL; j++){
			for (int verticalInterfaceIndex =Config.NUM_GHOST_CELL;
					verticalInterfaceIndex < Config.NUM_X_CELL + Config.NUM_GHOST_CELL + 1; verticalInterfaceIndex++){
				double leftValue = cells[verticalInterfaceIndex-1][j].uEast;
				double rightValue = cells[verticalInterfaceIndex][j].uWest;
			
				// Lax-Friedrichs scheme
				double flux = 0.5 * Config.ADVECTION_VEL_X * (leftValue + rightValue)
						- 0.5 * Math.abs(Config.ADVECTION_VEL_X) * (rightValue - leftValue) ;
				flux *= dy ;
				cells[verticalInterfaceIndex - 1][j].totalFlux -= flux;
				cells[verticalInterfaceIndex][j].totalFlux += flux;
			}
		}
		//Flux calculation for all horizontal edges
		for (int i = Config.NUM_GHOST_CELL; i<Config.NUM_X_CELL+Config.NUM_GHOST_CELL; i++){
			for (int horizontalInterfaceIndex =Config.NUM_GHOST_CELL;
					horizontalInterfaceIndex < Config.NUM_Y_CELL + Config.NUM_GHOST_CELL + 1; horizontalInterfaceIndex++){
				double leftValue = cells[i][horizontalInterfaceIndex-1].uNorth;
				double rightValue = cells[i][horizontalInterfaceIndex].uSouth;
			
				// Lax-Friedrichs scheme
				double flux = 0.5 * Config.ADVECTION_VEL_Y * (leftValue + rightValue)
						- 0.5 * Math.abs(Config.ADVECTION_VEL_Y) * (rightValue - leftValue) ;
				flux *= dx ;
				cells[i][horizontalInterfaceIndex - 1].totalFlux -= flux;
				cells[i][horizontalInterfaceIndex].totalFlux += flux;
			}
		}
		
	}
}
	
