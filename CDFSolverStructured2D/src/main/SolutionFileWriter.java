package main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SolutionFileWriter {
	private static int fileCounter = 0 ;
	private SolutionFileWriter(){
	}
	
	static void writeSolutionFile(Cell[][] cells, double time){
		int rkStep = 0 ; 
		File file = new File(Config.basePath, String.format("Solution%04d.dat", fileCounter));
		try{
			try(FileWriter fileWriter = new FileWriter(file)){
				fileWriter.write("NumXCells:" + Config.NUM_X_CELL + "\n");
				fileWriter.write("NumYCells:" + Config.NUM_Y_CELL + "\n");
				fileWriter.write("NumGhostCells:" + Config.NUM_GHOST_CELL + "\n");
				fileWriter.write("time:" +time+'\n');
				for (Cell[] cellRow : cells){
					for (Cell cell: cellRow){
						fileWriter.write(String.format("%20.15f %20.15f %20.15f\n", cell.cx,cell.cy,cell.u[rkStep]));
					}
				}
			}
		} catch (IOException ex){
			System.out.println("Unable to write solution file.");
			System.out.println(ex.getMessage());
		}
		fileCounter++;
	}

}
