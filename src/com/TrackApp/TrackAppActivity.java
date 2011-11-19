package com.TrackApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class TrackAppActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageButton gearcomparisonButton = (ImageButton)findViewById(R.id.Gear_Info_Button);
        gearcomparisonButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(
						TrackAppActivity.this,
						GearInformationActivity.class
						);
				startActivity(intent);
				
			}
		});
    }
}