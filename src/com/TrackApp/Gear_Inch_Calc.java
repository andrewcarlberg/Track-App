package com.TrackApp;

import java.math.BigDecimal;

public class Gear_Inch_Calc{
	
	protected static int FrontRing;
	protected static int Cog;
	protected static int Effective_wheel_size = 27;
	protected static Double Gear_Inches;
	protected static Double Distance_Traveled;
	
	Gear_Inch_Calc(int frontRing, int cog)
	{
		
		FrontRing = frontRing;
		Cog = cog;	
	}

	protected Double Calc_inches() {
		// TODO Auto-generated method stub
		Gear_Inches = (double)FrontRing/(double)Cog * Effective_wheel_size;
		return round(Gear_Inches,2);
	}
	
	protected Double Calc_distance()
	{
		Distance_Traveled = Gear_Inches*Math.PI;
		return Distance_Traveled;
	}
	
	private static double round(double d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(d);
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.doubleValue();
	}
}

