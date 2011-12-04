package com.TrackApp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.TrackApp.NumberPicker;

public class GearInformationActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gear_information);
		
		//Set up of Front Ring Select0r
		final NumberPicker frontRing = (NumberPicker)findViewById(R.id.FrontRing);
		frontRing.setRange(30, 65);
		frontRing.setCurrent(48);
		
		//Set up of Cog Selector
		final NumberPicker rearCog = (NumberPicker)findViewById(R.id.RearCog);
		rearCog.setRange(10,23);
		rearCog.setCurrent(14);	
		
		
		//Cadence Bar setup
		final SeekBar cadence_select= (SeekBar)findViewById(R.id.CadenceBar);
		cadence_select.setMax(200);
		cadence_select.setProgress(90);
		
		//Text views that will change based on input
		final TextView Gear_inches = (TextView)findViewById(R.id.Gear_Inch);
		final TextView cadence = (TextView)findViewById(R.id.Cadence);
		final TextView rollout = (TextView)findViewById(R.id.Rollout);
		final TextView speed = (TextView)findViewById(R.id.Speed);
		
		//Distance Times
		final List<TextView> Time_TextViews = new ArrayList<TextView>();
		final List<Integer> Distance = new ArrayList<Integer>();
		final TextView twohm = (TextView)findViewById(R.id.twohundredtime);
		Time_TextViews.add(twohm);
		Distance.add(200);
		final TextView twofiftym = (TextView)findViewById(R.id.twofiftymtime);
		Time_TextViews.add(twofiftym);
		Distance.add(250);
		final TextView threethirdythreem = (TextView)findViewById(R.id.threethirdythreemtime);
		Time_TextViews.add(threethirdythreem);
		Distance.add(333);
		final TextView fourhm = (TextView)findViewById(R.id.fourhundredmtime);
		Time_TextViews.add(fourhm);
		Distance.add(400);
		final TextView fivehm = (TextView)findViewById(R.id.fivehundredmtime);
		Time_TextViews.add(fivehm);
		Distance.add(500);
		final TextView onek = (TextView)findViewById(R.id.onektime);
		Time_TextViews.add(onek);
		Distance.add(1000);
		final TextView twok = (TextView)findViewById(R.id.twoktime);
		Time_TextViews.add(twok);
		Distance.add(2000);
		final TextView threek = (TextView)findViewById(R.id.threektime);
		Time_TextViews.add(threek);
		Distance.add(3000);
		final TextView fourk = (TextView)findViewById(R.id.fourktime);
		Time_TextViews.add(fourk);
		Distance.add(4000);
		
		
		//Listener for change to Front Ring Selector
		frontRing.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				//Change Gear Inches
				Gear_Inch_Calc from_Front = new Gear_Inch_Calc(newVal,rearCog.getCurrent());			
				CharSequence x;
				Double y= from_Front.getGearInches();
				x = (CharSequence) y.toString();
				Gear_inches.setText(x);
				
				//Change Rollout
				x = (CharSequence)((Double)from_Front.getDistanceTraveled()).toString();
				rollout.setText(x);
				
				//Change Speed
				double KPH_speed = from_Front.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				//Update Times
				Update_Times(Time_TextViews, Distance, from_Front, cadence_select.getProgress());

			}
		});
		
		//Listener for change to Cog Selector
		rearCog.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				//Change Gear Inches
				Gear_Inch_Calc from_Rear = new Gear_Inch_Calc(frontRing.getCurrent(),newVal);
				CharSequence x;
				Double y= from_Rear.getGearInches();
				x = (CharSequence) y.toString();
				Gear_inches.setText(x);
				
				//Change Rollout
				x = (CharSequence)((Double)from_Rear.getDistanceTraveled()).toString();
				rollout.setText(x);
				
				//Change Speed
				double KPH_speed = from_Rear.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				//Update Distance Times
				Update_Times(Time_TextViews, Distance, from_Rear, cadence_select.getProgress());
				
			}
		});
		
		//Lister of cadence bars
		cadence_select.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			//Unused function
			public void onStopTrackingTouch(SeekBar seekBar) {
				Gear_Inch_Calc gear = new Gear_Inch_Calc(frontRing.getCurrent(),rearCog.getCurrent());
				//Change Speed
				CharSequence x = (CharSequence)((Double)gear.KPH_Speed(seekBar.getProgress())).toString();
				speed.setText(x);
				
				//Update Times
				Update_Times(Time_TextViews, Distance, gear, seekBar.getProgress());
				
				
			}
			//Unused Function
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				//change Cadence label
				
				CharSequence x = (CharSequence)((Integer)progress).toString();
				cadence.setText(x);
				
				
			}
		});

				
		
	}
	
	//Abstraction to update times
	private void Update_Times(List<TextView> views, List<Integer> Distances, Gear_Inch_Calc gear, int cadence)
	{
		for(int i=0; i<views.size(); i++)
		{
			views.get(i).setText((CharSequence) gear.Pretty_Print(
					gear.Time_To_Complete(cadence, Distances.get(i))));
		}

	}
	
	

}

