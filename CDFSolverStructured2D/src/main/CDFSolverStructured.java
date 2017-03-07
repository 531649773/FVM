package main;


public class CDFSolverStructured {
	public static void main(String[] args){
		Cell[][] cells = new Cell[Config.NUM_X_CELL + 2 * Config.NUM_GHOST_CELL][Config.NUM_Y_CELL + 2 * Config.NUM_GHOST_CELL] ;
		double dx = (Config.MAX_X - Config.MIN_X) / Config.NUM_X_CELL;
		double dy = (Config.MAX_Y - Config.MIN_Y) / Config.NUM_Y_CELL;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++){	
				cells[i][j] = new Cell();
				cells[i][j].dx = dx;
				cells[i][j].dy = dy;
				cells[i][j].cx = Config.MIN_X + dx * (i + 0.5 - Config.NUM_GHOST_CELL) ;
				cells[i][j].cy = Config.MIN_Y + dy * (j + 0.5 - Config.NUM_GHOST_CELL) ;
			}
		} 
		SolutionInitializer.initializeSolution(cells);
		
		double time = 0.0;
		SolutionFileWriter.writeSolutionFile(cells, time);
		boolean lastTimeStep = false ;
		
		for (int timeIter = 0; timeIter < Config.MAX_TIME_ITER; timeIter++){
			double dt = TimeStepCalculator.getTimeStep(cells) ;
			if(time + dt > Config.STOPPING_TIME) {
				dt = Config.STOPPING_TIME - time;
				lastTimeStep = true;
			}
			for (int rkStep = 0; rkStep < Config.NUM_RK_STEPS; rkStep++){
				GhostCellUpdater.updateGhostCells(cells, rkStep);
				VariableReconstructor.reconstructVariables(cells, rkStep);
				Flux.calculateFlux(cells,rkStep);
				TimeIntegration.updateCellAverages(cells, rkStep, dt);
			}
			
			VariableCopier.copyToZeroRKStep(cells);
			time += dt;
			if(lastTimeStep) {
				break;
			}
			if ((timeIter + 1) % 10 == 0){
				SolutionFileWriter.writeSolutionFile(cells, time);
			}
		}
		SolutionFileWriter.writeSolutionFile(cells, time);
		
	} 
	
	
}
