package com.TrackApp;


import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.TrackApp.NumberPicker;
import com.TrackApp.Gear_Inch_Calc;

public class GearComparisonActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gear_comparison);
		
		//Set up of Front Ring Select0r
		final NumberPicker frontRing1 = (NumberPicker)findViewById(R.id.FrontRing1);
		frontRing1.setRange(30, 65);
		frontRing1.setCurrent(48);
		
		//Set up of Cog Selector
		final NumberPicker rearCog1 = (NumberPicker)findViewById(R.id.RearCog1);
		rearCog1.setRange(10,23);
		rearCog1.setCurrent(14);	
		
		//Set up of Front Ring Select0r
		final NumberPicker frontRing2 = (NumberPicker)findViewById(R.id.FrontRing2);
		frontRing2.setRange(30, 65);
		frontRing2.setCurrent(48);
		
		//Set up of Cog Selector
		final NumberPicker rearCog2 = (NumberPicker)findViewById(R.id.RearCog2);
		rearCog2.setRange(10,23);
		rearCog2.setCurrent(14);	
		
		//Cadence
		final SeekBar cadence= (SeekBar)findViewById(R.id.GCCadenceBar);
		cadence.setMax(200);
		cadence.setProgress(90);
		
		//TextViews
		final TextView cadence_label = (TextView)findViewById(R.id.Cadence);
		final TextView gearinch1 = (TextView)findViewById(R.id.GearInchOne);
		final TextView gearinch2 = (TextView)findViewById(R.id.GearInchTwo);
		final TextView rollout1 = (TextView)findViewById(R.id.Rollout_one);
		final TextView rollout2 = (TextView)findViewById(R.id.Rollout_two);

		//Listener for change to Front Ring Selector
		frontRing1.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				//Change Gear Inches
				Gear_Inch_Calc from_Front = new Gear_Inch_Calc(newVal,rearCog1.getCurrent());			
				CharSequence x;
				Double y= from_Front.getGearInches();
				x = (CharSequence) y.toString();
				gearinch1.setText(x);
				
				//Change Rollout
				x = (CharSequence)((Double)from_Front.getDistanceTraveled()).toString();
				rollout1.setText(x);
/*				
				//Change Speed
				double KPH_speed = from_Front.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				//Update Times
				Update_Times(Time_TextViews, Distance, from_Front, cadence_select.getProgress());
*/
			}
		});
				
		//Listener for change to Cog Selector
		rearCog1.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				//Change Gear Inches
				Gear_Inch_Calc from_Rear = new Gear_Inch_Calc(frontRing1.getCurrent(),newVal);
				CharSequence x;
				Double y= from_Rear.getGearInches();
				x = (CharSequence) y.toString();
				gearinch1.setText(x);
				
				//Change Rollout
				x = (CharSequence)((Double)from_Rear.getDistanceTraveled()).toString();
				rollout1.setText(x);
				/*
				//Change Speed
				double KPH_speed = from_Rear.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				//Update Distance Times
				Update_Times(Time_TextViews, Distance, from_Rear, cadence_select.getProgress());
				*/
			}
		});		
		
		frontRing2.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				//Change Gear Inches
				Gear_Inch_Calc from_Front = new Gear_Inch_Calc(newVal,rearCog2.getCurrent());			
				CharSequence x;
				Double y= from_Front.getGearInches();
				x = (CharSequence) y.toString();
				gearinch2.setText(x);
				
				//Change Rollout
				x = (CharSequence)((Double)from_Front.getDistanceTraveled()).toString();
				rollout2.setText(x);
				/*
				//Change Speed
				double KPH_speed = from_Front.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				//Update Times
				Update_Times(Time_TextViews, Distance, from_Front, cadence_select.getProgress());
				*/
			}
		});
				
		//Listener for change to Cog Selector
		rearCog2.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				//Change Gear Inches
				Gear_Inch_Calc from_Rear = new Gear_Inch_Calc(frontRing2.getCurrent(),newVal);
				CharSequence x;
				Double y= from_Rear.getGearInches();
				x = (CharSequence) y.toString();
				gearinch2.setText(x);
				
				//Change Rollout
				x = (CharSequence)((Double)from_Rear.getDistanceTraveled()).toString();
				rollout2.setText(x);
				/*
				//Change Speed
				double KPH_speed = from_Rear.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				//Update Distance Times
				Update_Times(Time_TextViews, Distance, from_Rear, cadence_select.getProgress());
				*/
			}
		});	
		
		cadence.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				CharSequence x = ((Integer)progress).toString();
				cadence_label.setText(x);
			}
		});
	}
	
}
