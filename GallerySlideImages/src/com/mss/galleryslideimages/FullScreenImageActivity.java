package com.mss.galleryslideimages;

import java.util.ArrayList;

import com.mss.adapters.FullScreenImageAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class FullScreenImageActivity extends Activity {
	ViewPager mViewPager;
	String TAG = "fullscreen";
	ArrayList<Integer> mArrayList_images;
	FullScreenImageAdapter mFullScreenImageAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_image);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		/*
		 * 
		 * ViewPager: Its a layout manager that allows the user to flip left and
		 * right through pages of data.
		 * 
		 */
		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);
		mArrayList_images = new ArrayList<Integer>();
		mArrayList_images = i.getIntegerArrayListExtra("image_list");
		mFullScreenImageAdapter = new FullScreenImageAdapter(
				FullScreenImageActivity.this, mArrayList_images);
		/*
		 * 
		 * FullScreenAdapter is for inflating imageview to the viewPager to show images.
		 * 
		 */
		mViewPager.setAdapter(mFullScreenImageAdapter);
		mViewPager.setCurrentItem(position);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_screen_image, menu);
		return true;
	}

}
