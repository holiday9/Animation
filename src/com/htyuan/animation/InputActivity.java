package com.htyuan.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class InputActivity extends Activity {
	private View mPanelView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_input);

		mPanelView = findViewById(R.id.root);

		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						View view = findViewById(R.id.edit_text1);
						setTranlateAnimation(mPanelView, view);
					}
				});
	}

	private void setTranlateAnimation(View rootView, View anchorView) {
		AnimationSet animationSet = new AnimationSet(true);
		
		{
			TranslateAnimation animationDelay = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
					Animation.ABSOLUTE, 0, Animation.ABSOLUTE,
					0);
			animationDelay.setDuration(2000);
			animationDelay.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					Log.d("temp", "animation1 finish");
				}
			});
			animationSet.addAnimation(animationDelay);
		}
		
		{
			TranslateAnimation animation2 = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
					Animation.ABSOLUTE, 0, Animation.ABSOLUTE,
					-anchorView.getMeasuredHeight());
			animation2.setDuration(1000);
			animation2.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					Intent intent = new Intent(InputActivity.this,
							InputActivity2.class);
					startActivity(intent);
					
					Log.d("temp", "animation2 finish");
				}
			});
			animationSet.addAnimation(animation2);
		}

		rootView.startAnimation(animationSet);
	}
	
	protected void onPause() {
//		mPanelView.clearAnimation();
		
		super.onPause();
	}
}
