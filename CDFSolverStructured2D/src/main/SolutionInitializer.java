package main;

public class SolutionInitializer {
	private SolutionInitializer() {		
	}
	public static void initializeSolution(Cell[][] cells){
		int rkStep = 0 ;
		for (Cell[] cellRow : cells){
			for (Cell cell: cellRow){
				if(cell.cx > -0.25 && cell.cx < 0.25 && cell.cy > -0.25 && cell.cy < 0.25){
					cell.u[rkStep] = 1.0 ;
				} else {
					cell.u[rkStep] = 0.0 ;
				}
			
			}
		}
		
	}
}
