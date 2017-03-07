package main;

public class GhostCellUpdater {
	private GhostCellUpdater(){
	}
	public static void updateGhostCells(Cell[][] cells, int rkStep){
		// left and right side of the domain  
		for (int j = 0;  j<cells[0].length; j++ ){
			for (int ghostCell = 0; ghostCell < Config.NUM_GHOST_CELL; ghostCell++){
				cells[ghostCell][j].u[rkStep] 
						= cells[Config.NUM_X_CELL + ghostCell][j].u[rkStep];
			
				cells[Config.NUM_X_CELL +Config.NUM_GHOST_CELL+ ghostCell][j].u[rkStep] 
						= cells[Config.NUM_GHOST_CELL+ghostCell][j].u[rkStep];
			
			}
		}
		
		// bottom and top cells
		for (int i = 0;  i<cells.length;i++ ){
			for (int ghostCell = 0; ghostCell < Config.NUM_GHOST_CELL; ghostCell++){
				cells[i][ghostCell].u[rkStep] 
						= cells[i][Config.NUM_Y_CELL + ghostCell].u[rkStep];
			
				cells[i][Config.NUM_Y_CELL +Config.NUM_GHOST_CELL+ ghostCell].u[rkStep] 
						= cells[i][Config.NUM_GHOST_CELL+ghostCell].u[rkStep];
			
			}
		}
	}
}
