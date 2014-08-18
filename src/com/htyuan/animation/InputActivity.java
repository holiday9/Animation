package com.htyuan.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class InputActivity extends Activity {
	private View mPanelView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_input);

		mPanelView = findViewById(R.id.panel1);
		setTranlateAnimation(mPanelView);
	}

	private void setTranlateAnimation(View panel) {
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0, 
				Animation.RELATIVE_TO_SELF, 0,
				Animation.RELATIVE_TO_SELF, 1, 
				Animation.RELATIVE_TO_SELF, 0);
		animation.setDuration(2000);
		animationSet.addAnimation(animation);
		panel.startAnimation(animationSet);
	}
}
