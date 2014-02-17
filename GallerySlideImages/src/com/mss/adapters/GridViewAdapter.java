package com.mss.adapters;

import java.util.ArrayList;

import com.mss.galleryslideimages.FullScreenImageActivity;

import android.content.Context;
import android.content.Intent; 
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;  

public class GridViewAdapter extends BaseAdapter {

	Context mContext;
	ArrayList<Integer> mArrayList_images;
	int imageWidth;

	public GridViewAdapter(Context applicationContext,
			ArrayList<Integer> mArrayList_images, int columnWidth) {
		this.mContext = applicationContext;
		this.mArrayList_images = mArrayList_images;
		this.imageWidth = columnWidth;
	}

	@Override
	public int getCount() { 
		return mArrayList_images.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mArrayList_images.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub

		ImageView mImageView;
		if (arg1 == null) {
			mImageView = new ImageView(mContext);
		} else {
			mImageView = (ImageView) arg1;
		}
		mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		mImageView.setLayoutParams(new GridView.LayoutParams(imageWidth,
				imageWidth));
		mImageView.setBackgroundResource(mArrayList_images.get(arg0));
		mImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View mView) { 
				Intent mIntent = new Intent(mContext,
						FullScreenImageActivity.class);
				mIntent.putExtra("position", arg0);
				mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				mIntent.putIntegerArrayListExtra("image_list",
						mArrayList_images);
				mContext.startActivity(mIntent);
			}
		});
		return mImageView;
	}

}
