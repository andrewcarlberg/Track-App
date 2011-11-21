package com.TrackApp;

import java.math.BigDecimal;

public class Gear_Inch_Calc{
	
	protected static int FrontRing;
	protected static int Cog;
	protected static int Effective_wheel_size = 27;
	protected static Double Gear_Inches;
	protected static Double Distance_Traveled;
	private double KM_Factor = 0.62137;
	
	Gear_Inch_Calc(int frontRing, int cog)
	{
		
		FrontRing = frontRing;
		Cog = cog;	
		Calc_inches();
		Calc_distance();
	}

	
	private void Calc_inches() {
		// TODO Auto-generated method stub
		Gear_Inches = round((double)FrontRing/(double)Cog * Effective_wheel_size,2);
	}
	
	public double getGearInches()
	{
		return Gear_Inches;
	}
	
	private void Calc_distance()
	{
		Distance_Traveled = round(Gear_Inches*Math.PI*0.0254,2);
	}
	
	public double getDistanceTraveled()
	{
		return Distance_Traveled;
	}
	
	private double Calc_distance_English()
	{
		Distance_Traveled = Gear_Inches*Math.PI;
		return Distance_Traveled;
	}
	
	private static double round(double d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(d);
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.doubleValue();
	}
	
	protected double Time_To_Complete(int cadence, double distance)
	{
		double time = distance/(KPH_Speed(cadence)*1000.0/3600.0);
		return round(time,2);
	}

	public String Pretty_Print(double time_in_seconds)
	{
		//mm:ss:th
		String Time;
		if((int)time_in_seconds/60>0)
		{
			int minutes = (int)time_in_seconds/60;
			Time = ((Integer)minutes).toString();
			time_in_seconds = round(time_in_seconds - minutes*60,2);
		}
		else
			Time="00";
		if (time_in_seconds <10)
			Time = Time +":0"+((Double)time_in_seconds).toString();
		else
			Time = Time +":"+((Double)time_in_seconds).toString();
		
		return Time;
		
		
	}
	
	protected double KPH_Speed(int cadence)
	{
		return round(Calc_distance_English()*((double)cadence)*60.0/12.0/5280.0/KM_Factor,2);
	}
	
	protected double MPH_Speed(int cadence)
	{
		return round(Calc_distance_English()*((double)cadence)*60.0/12.0/5280.0,2);
	}
}

