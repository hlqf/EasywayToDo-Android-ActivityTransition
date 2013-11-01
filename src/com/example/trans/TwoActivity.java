package com.example.trans;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TwoActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.two, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
			sendBackIntent();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		Button backButton = (Button) findViewById(R.id.btn_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendBackIntent();
			}
		});

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("SecondActivity", "Destoried");
	}

	protected void sendBackIntent() {
		Intent it = new Intent();
		Bundle bd = new Bundle(); 
		bd.putString("toShow", "I'm a textString back from TwoActivity");
		it.putExtras(bd);
		
		TwoActivity.this.setResult(1, it);
		TwoActivity.this.finish();
	}

}
