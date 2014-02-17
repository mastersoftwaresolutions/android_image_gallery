package com.mss.constants;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Utills {
Activity mActivity;
	public Utills(Activity mActivity) {
		this.mActivity=mActivity;
	}

	public int getScreenWidth() {
		DisplayMetrics metrics=new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width=metrics.widthPixels;
		return width;   
	}
}
