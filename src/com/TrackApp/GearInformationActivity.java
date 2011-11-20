package com.TrackApp;

import android.app.Activity;
import android.os.Bundle;
import com.TrackApp.NumberPicker;

import android.view.View;
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
		frontRing.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				Gear_Inch_Calc from_Front = new Gear_Inch_Calc(newVal,rearCog.getCurrent());
				
				CharSequence x;
				Double y= from_Front.Calc_inches();
				x = (CharSequence) y.toString();
				Gear_inches.setText(x);				
			}
		});
		
		rearCog.setOnChangeListener(new NumberPicker.OnChangedListener() {

			public void onChanged(NumberPicker picker, int oldVal, int newVal) {
				
				Gear_Inch_Calc from_Rear = new Gear_Inch_Calc(frontRing.getCurrent(),newVal);
				CharSequence x;
				Double y= from_Rear.Calc_inches();
				x = (CharSequence) y.toString();
				Gear_inches.setText(x);				
			}
		});
		

				
		
	}
}

