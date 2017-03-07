package main;

public class Config {
	public static final int NUM_X_CELL = 60 ;
	public static final int NUM_Y_CELL = 80 ;
	public static final int NUM_GHOST_CELL = 4 ;
	public static final int NUM_RK_STEPS = 3 ;
	public static final double STOPPING_TIME = 3.0 ;
	public static final int MAX_TIME_ITER = 100000 ;
	public static final double MIN_X  = -1.0 ;
	public static final double MAX_X  = 1.0 ;
	public static final double MIN_Y  = -1.0 ;
	public static final double MAX_Y  = 1.0 ;
	public static final double ADVECTION_VEL_X = 1.0 ;
	public static final double ADVECTION_VEL_Y = 1.0 ;
	public static final double COURANT_NUM = 1.0 ;
	//public static final ReconstructionTypes RECONST_TYPE = ReconstructionTypes.FIRST_ORDER;
	public static final String basePath = "./out/" ;

}
