package com.TrackApp;

import java.math.BigDecimal;

public class Gear_Inch_Calc{
	
	protected static int FrontRing;
	protected static int Cog;
	protected static int Effective_wheel_size = 27;
	protected static Double Gear_Inches;
	protected static Double Distance_Traveled;
	private double KM_Factor = 0.62137;
	
	//Constructor:  Sets values of the ring and cog and 
	//then calculates the distance and the inches
	Gear_Inch_Calc(int frontRing, int cog)
	{
		
		FrontRing = frontRing;
		Cog = cog;	
		Calc_inches();
		Calc_distance();
	}

	//Calculates gear inches based on Effective wheel size
	private void Calc_inches() {
		// TODO Auto-generated method stub
		Gear_Inches = round((double)FrontRing/(double)Cog * Effective_wheel_size,2);
	}
	
	//returns gear inches
	public double getGearInches()
	{
		return Gear_Inches;
	}
	
	//calculates the rollout of a bike in metric
	private void Calc_distance()
	{
		Distance_Traveled = round(Gear_Inches*Math.PI*0.0254,2);
	}
	
	//returns rollout
	public double getDistanceTraveled()
	{
		return Distance_Traveled;
	}
	
	//Calculates rollout in English units
	private double Calc_distance_English()
	{
		Distance_Traveled = Gear_Inches*Math.PI;
		return Distance_Traveled;
	}
	
	//rounding function  Thanks StackOverflow!
	private static double round(double d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(d);
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.doubleValue();
	}
	
	//calculates the time to complete a distance in seconds
	protected double Time_To_Complete(int cadence, double distance)
	{
		if (cadence == 0)
			cadence++;
		double time = distance/(KPH_Speed(cadence)*1000.0/3600.0);
		return round(time,2);
	}

	//returns seconds into a Pretty Print
	public String Pretty_Print(double time_in_seconds)
	{
		//mm:ss:th
		String Time;
		if((int)time_in_seconds/60>0)
		{
			int minutes = (int)time_in_seconds/60;
			if(minutes>9)
			{
				Time = ((Integer)minutes).toString();
			}
			else
			{
				Time = "0"+((Integer)minutes).toString();
			}
			time_in_seconds = round(time_in_seconds - minutes*60,2);
		}
		else
			Time="00";
		
		if (time_in_seconds <10)
			Time = Time +":0"+((Double)time_in_seconds).toString();
		else
			Time = Time +":"+((Double)time_in_seconds).toString();
		
		if(Time.length()==7)
			Time+="0";
		
		return Time;
		
		
	}
	
	//calcs KPH speed
	protected double KPH_Speed(int cadence)
	{
		return round(Calc_distance_English()*((double)cadence)*60.0/12.0/5280.0/KM_Factor,2);
	}
	
	//calcs a MPH Speed
	protected double MPH_Speed(int cadence)
	{
		return round(Calc_distance_English()*((double)cadence)*60.0/12.0/5280.0,2);
	}
}

