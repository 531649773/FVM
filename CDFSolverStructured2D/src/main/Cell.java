package main;

public class Cell {
	public double[] u = new double[Config.NUM_RK_STEPS + 1] ;
	public double uWest, uEast, uSouth, uNorth ;
	public double cx ;
	public double cy ;
	public double dx ;
	public double dy ;
	public double totalFlux;
}
