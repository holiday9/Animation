package com.htyuan.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class InputActivity2 extends Activity {
	private View mPanelView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_input);

		mPanelView = findViewById(R.id.root);
		
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setTranlateAnimation(mPanelView);
			}
		});
	}

	private void setTranlateAnimation(View panel) {
		View view = findViewById(R.id.edit_text1);
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0,
				Animation.RELATIVE_TO_SELF, 0,
				Animation.ABSOLUTE, 0,
				Animation.ABSOLUTE, -view.getMeasuredHeight());
		animation.setDuration(1000);
		animationSet.addAnimation(animation);
		panel.startAnimation(animationSet);
	}
}
