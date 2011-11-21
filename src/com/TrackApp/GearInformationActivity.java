package com.TrackApp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import com.TrackApp.NumberPicker;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class GearInformationActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gear_information);
		final NumberPicker frontRing = (NumberPicker)findViewById(R.id.FrontRing);
		final NumberPicker rearCog = (NumberPicker)findViewById(R.id.RearCog);
		frontRing.setRange(30, 65);
		frontRing.setCurrent(48);
		rearCog.setRange(10,23);
		rearCog.setCurrent(14);	
		final TextView Gear_inches = (TextView)findViewById(R.id.Gear_Inch);
		final SeekBar cadence_select= (SeekBar)findViewById(R.id.CadenceBar);
		final TextView cadence = (TextView)findViewById(R.id.Cadence);
		final TextView rollout = (TextView)findViewById(R.id.Rollout);
		final TextView speed = (TextView)findViewById(R.id.Speed);
		
		//Distance Times
		final TextView twohm = (TextView)findViewById(R.id.twohundredtime);
		final TextView twofiftym = (TextView)findViewById(R.id.twofiftymtime);
		final TextView threethirdythreem = (TextView)findViewById(R.id.threethirdythreemtime);
		final TextView fourhm = (TextView)findViewById(R.id.fourhundredmtime);
		final TextView fivehm = (TextView)findViewById(R.id.fivehundredmtime);
		final TextView onek = (TextView)findViewById(R.id.onektime);
		final TextView twok = (TextView)findViewById(R.id.twoktime);
		final TextView threek = (TextView)findViewById(R.id.threektime);
		final TextView fourk = (TextView)findViewById(R.id.fourktime);
		
		cadence_select.setMax(200);
		cadence_select.setProgress(90);
		frontRing.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				Gear_Inch_Calc from_Front = new Gear_Inch_Calc(newVal,rearCog.getCurrent());			
				CharSequence x;
				Double y= from_Front.getGearInches();
				x = (CharSequence) y.toString();
				Gear_inches.setText(x);
				x = (CharSequence)((Double)from_Front.getDistanceTraveled()).toString();
				rollout.setText(x);
				double KPH_speed = from_Front.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				twohm.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 200)));
				twofiftym.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 250)));
				threethirdythreem.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 333)));
				fourhm.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 400)));
				fivehm.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 500)));
				onek.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 1000)));
				twok.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 2000)));
				threek.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 3000)));
				fourk.setText((CharSequence)from_Front.Pretty_Print(
						from_Front.Time_To_Complete(cadence_select.getProgress(), 4000)));
			}
		});
		
		rearCog.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				
				Gear_Inch_Calc from_Rear = new Gear_Inch_Calc(frontRing.getCurrent(),newVal);
				CharSequence x;
				Double y= from_Rear.getGearInches();
				x = (CharSequence) y.toString();
				Gear_inches.setText(x);
				x = (CharSequence)((Double)from_Rear.getDistanceTraveled()).toString();
				rollout.setText(x);
				double KPH_speed = from_Rear.KPH_Speed(cadence_select.getProgress());
				x  =(CharSequence)((Double)KPH_speed).toString();
				speed.setText(x);
				
				twohm.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 200)));
				twofiftym.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 250)));
				threethirdythreem.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 333)));
				fourhm.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 400)));
				fivehm.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 500)));
				onek.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 1000)));
				twok.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 2000)));
				threek.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 3000)));
				fourk.setText((CharSequence)from_Rear.Pretty_Print(
						from_Rear.Time_To_Complete(cadence_select.getProgress(), 4000)));
				
			}
		});
		
		cadence_select.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				Gear_Inch_Calc gear = new Gear_Inch_Calc(frontRing.getCurrent(),rearCog.getCurrent());
				CharSequence x = (CharSequence)((Integer)progress).toString();
				cadence.setText(x);
				x = (CharSequence)((Double)gear.KPH_Speed(progress)).toString();
				speed.setText(x);
				
				twohm.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 200)));
				twofiftym.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 250)));
				threethirdythreem.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 333)));
				fourhm.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 400)));
				fivehm.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 500)));
				onek.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 1000)));
				twok.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 2000)));
				threek.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 3000)));
				fourk.setText((CharSequence)gear.Pretty_Print(
						gear.Time_To_Complete(progress, 4000)));
				
			}
		});

				
		
	}

}

