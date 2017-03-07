package main;

public class Config {
	public static final int NUM_X_CELL = 100 ;
	public static final int NUM_GHOST_CELL = 3 ;
	public static final int NUM_RK_STEPS = 1 ;
	public static final double STOPPING_TIME = 2 ;
	public static final int MAX_TIME_ITER = 100000 ;
	public static final double MIN_X  = -1.0 ;
	public static final double MAX_X  = 1.0 ;
	public static final double ADVECTION_VEL = 1.0 ;
	public static final double COURANT_NUM = 0.8 ;
	public static final String basePath = "./out/" ;

}
