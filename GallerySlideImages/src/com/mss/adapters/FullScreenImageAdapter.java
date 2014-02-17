package com.mss.adapters;

import java.util.ArrayList;
 
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager; 
import android.view.View; 
import android.widget.ImageView;

public class FullScreenImageAdapter extends PagerAdapter {

	Activity mActivity;
	ArrayList<Integer> mArrayList_images;

	public FullScreenImageAdapter(Activity mActivity,
			ArrayList<Integer> mArrayList_images) {
		this.mActivity = mActivity;
		this.mArrayList_images = mArrayList_images;
	}

	@Override
	public int getCount() { 
		return mArrayList_images.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) { 
		return arg0 == ((ImageView) arg1);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		ImageView mImageView = new ImageView(mActivity);
		mImageView.setBackgroundResource(mArrayList_images.get(position));
		((ViewPager) container).addView(mImageView, 0);
		return mImageView;
	}

	@Override
	public void destroyItem(View container, int position, Object object) { 
		((ViewPager) container).removeView((ImageView) object);
	}

}
