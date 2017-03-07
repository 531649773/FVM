package main;

public class GhostCellUpdater {
	private GhostCellUpdater(){
	}
	public static void updateGhostCells(Cell[] cells, int rkStep){
		for (int ghostCell = 0; ghostCell < Config.NUM_GHOST_CELL; ghostCell++){
			cells[ghostCell].u[rkStep] 
					= cells[Config.NUM_X_CELL + ghostCell].u[rkStep];
			
			cells[Config.NUM_X_CELL +Config.NUM_GHOST_CELL+ ghostCell].u[rkStep] 
					= cells[Config.NUM_GHOST_CELL+ghostCell].u[rkStep];
			
			
		}
	}
}
