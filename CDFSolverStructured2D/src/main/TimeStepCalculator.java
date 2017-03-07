package main;

public class TimeStepCalculator {
	private TimeStepCalculator(){
	}
	public static double getTimeStep(Cell[][] cells){
		double dt1 = cells[0][0].dx / Math.abs(Config.ADVECTION_VEL_X) ;
		double dt2 = cells[0][0].dy / Math.abs(Config.ADVECTION_VEL_Y) ;
		double dt = 1.0/(1.0 / dt1 + 1.0 / dt2) ;
		return dt * Config.COURANT_NUM ;
	}
}
