package com.example.aimhustermap;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.aimhustermap.R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengUpdateAgent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SettingActivity extends Activity {

	TextView feedback, trouble, navigate, about;
	Button exit;
	Button backButton;
	 ManagerApp app;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
	    app = (ManagerApp)this.getApplication();
	        app.addActivity(this);
		setContentView(R.layout.setting);
		
		feedback = (TextView)findViewById(R.id.feedback);
		trouble  = (TextView)findViewById(R.id.trouble);
		navigate = (TextView)findViewById(R.id.navigate);
		about    = (TextView)findViewById(R.id.about);
		exit     = (Button)findViewById(R.id.exit);
		backButton =(Button)findViewById(R.id.back_setting);
		
		feedback.setOnClickListener(new ClickFeedback());
		trouble.setOnClickListener(new ClickTrouble());
		navigate.setOnClickListener(new ClickNavigate());
		about.setOnClickListener(new ClickAbout());
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SettingActivity.this.finish();
			}
		});
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			        app.finishAll();
			}
		});
		

	}
	

	class ClickFeedback implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			FeedbackAgent agent = new FeedbackAgent(SettingActivity.this);
			agent.startFeedbackActivity();
			agent.sync();
			
		}
		
	}
	
	class ClickTrouble implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, TroubleActivity.class);
			SettingActivity.this.startActivity(intent);
			
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		}
		
	}
	
	class ClickNavigate implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, NavigateActivity.class);
			SettingActivity.this.startActivity(intent);
			
		}
		
	}
	
	class ClickAbout implements OnClickListener{	

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, AboutActivity.class);
			SettingActivity.this.startActivity(intent);
		}
		
	}
	
	
	
	public void onResume() {
	    super.onResume();
	    MobclickAgent.onPause(this);
	}
	public void onPause() {
	    super.onPause();
	    MobclickAgent.onPause(this);
	}
	
}



