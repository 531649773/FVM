package main;

public class Cell {
	public double[] u = new double[Config.NUM_RK_STEPS + 1] ;
	public double uWest, uEast ;
	public double cx ;
	public double dx ;
	public double totalFlux;
}
