package com.mss.galleryslideimages;

import java.util.ArrayList;

import com.mss.adapters.GridViewAdapter;
import com.mss.constants.ConstantData;
import com.mss.constants.Utills;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.GridView;

/**
 * 
 * @author Master Software Solutions
 * 
 */

public class MainActivity extends Activity {
	int columnWidth;
	GridView mGridView;
	Utills mUtills;
	ArrayList<Integer> mArrayList_images;
	GridViewAdapter mGridViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mGridView = (GridView) findViewById(R.id.grid_view);
		mArrayList_images = new ArrayList<Integer>();
		mArrayList_images.add(R.drawable.image1);
		mArrayList_images.add(R.drawable.image2);
		mArrayList_images.add(R.drawable.image3);
		mArrayList_images.add(R.drawable.image4);
		mArrayList_images.add(R.drawable.image5);
		mArrayList_images.add(R.drawable.image6);
		/*
		 * 
		 * arraylist contains the images which will be shown
		 */

		mUtills = new Utills(this);
		/*
		 * 
		 * Utills: This class will help to find the screen width
		 */

		initializeGridLayout();
		/*
		 * 
		 * initializeGridLayout(): This method makes the width of column of grid
		 * according to the device.
		 */
		mGridViewAdapter = new GridViewAdapter(getApplicationContext(),
				mArrayList_images, columnWidth);
		mGridView.setAdapter(mGridViewAdapter);
	}

	private void initializeGridLayout() {
		Resources r = getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				ConstantData.GRID_PADDING, r.getDisplayMetrics());
		/*
		 * 
		 * TypedValue: Container for a dynamically typed data value. Primarily
		 * used with Resources for holding resource values.
		 */

		columnWidth = (int) ((mUtills.getScreenWidth() - ((ConstantData.NUM_OF_COLUMNS + 1) * padding)) / ConstantData.NUM_OF_COLUMNS);

		mGridView.setNumColumns(ConstantData.NUM_OF_COLUMNS);
		mGridView.setColumnWidth(columnWidth);
		mGridView.setStretchMode(GridView.NO_STRETCH);
		mGridView.setPadding((int) padding, (int) padding, (int) padding,
				(int) padding);
		mGridView.setHorizontalSpacing((int) padding);
		mGridView.setVerticalSpacing((int) padding);
	}

}
