package br.com.imageflow.adapter;

import java.util.Random;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mURLImages.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// public View getView(int position, View convertView, ViewGroup parent) {
	// ImageView imageView;
	// if (convertView == null) { // if it's not recycled, initialize some
	// attributes imageView = new ImageView(mContext);
	// imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
	// imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	// imageView.setPadding(8, 8, 8, 8);
	// } else {
	// imageView = (ImageView) convertView;
	// }
	//
	// imageView.setImageResource(mThumbIds[position]);
	// return imageView;
	// }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView;

//		if (convertView == null) {
			imageView = new ImageView(mContext);
//			imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//			imageView.setPadding(8, 8, 8, 8);
//		} else {
//			imageView = (ImageView) convertView;
//		}

		String url = mURLImages[position];
		Picasso.with(mContext).load(url).into(imageView);
		return imageView;
	}

	public static int generateRandom(int min, int max) {
		Random random = new Random();
		int value = min + random.nextInt(max - min + 1);
		return value;
	}

	private String[] mURLImages = {
			"http://wallpapers.wallbase.cc/rozne/wallpaper-1663454.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-45245.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-184157.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-8701.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-982050.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-302813.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-343465.jpg",
			"http://wallpapers.wallbase.cc/rozne/wallpaper-599766.jpg" };

	// references to our images
	private Integer[] mThumbIds = { R.drawable.btn_plus, R.drawable.btn_plus,
			R.drawable.btn_plus, R.drawable.btn_plus, R.drawable.btn_plus,
			R.drawable.btn_plus, R.drawable.btn_plus

	};
}
