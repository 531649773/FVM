package main;

public class TimeStepCalculator {
	private TimeStepCalculator(){
	}
	public static double getTimeStep(Cell[] cells){
		return cells[0].dx / Math.abs(Config.ADVECTION_VEL) * Config.COURANT_NUM ;
	}
}
