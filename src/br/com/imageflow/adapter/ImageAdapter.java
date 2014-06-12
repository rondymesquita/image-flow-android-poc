package br.com.imageflow.adapter;

import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.imageflow.R;
import br.com.imageflow.application.ImageApplicationImpl;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
	
	private Context context;
	private String longPressItem;
	private List<String> list;
	private View longPresseItemView;
	
	public View getLongPresseItemView() {
		return longPresseItemView;
	}

	public ImageAdapter(Context context, List list) {
		this.context = context;
		this.list = list;
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

//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//
//		ImageView imageView;
//
////		if (convertView == null) {
//			imageView = new ImageView(mContext);
////			imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
//			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
////			imageView.setPadding(8, 8, 8, 8);
////		} else {
////			imageView = (ImageView) convertView;
////		}
//
//		String url = mURLImages[position];
//		Picasso.with(mContext).load(url).into(imageView);
//		return imageView;
//	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		
		if(convertView == null){
			view = new View(context);
			view = inflater.inflate(R.layout.row_grid, null);
			ImageView imageView = (ImageView) view.findViewById(R.id.image);
			TextView textView = (TextView) view.findViewById(R.id.text);
			
			String url = list.get(position);
			Picasso.with(context).load(url).into(imageView);
			textView.setText(url);
		}else{
			view = (View) convertView;
		}
		
		view.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				String text = ((TextView) v.findViewById(R.id.text)).getText().toString();
				longPressItem = text;
				longPresseItemView = v;
				showDialog(text);
				return false;
			}
		});
		
		return view;

	}
	
	private void showDialog(String message) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle("");
		dialog.setMessage("Adicionar aos favoritos?");
		dialog.setNegativeButton("Cancelar", null);
		dialog.setPositiveButton("OK", onOkPress);
		dialog.create().show();
		
	}

	OnClickListener onOkPress = new OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			ImageApplicationImpl application = ImageApplicationImpl.getInstance();
			application.add(longPressItem);
			notifyDataSetChanged();
			Toast.makeText(context, application.list().size(), Toast.LENGTH_SHORT).show();
		}
	};
	
	OnClickListener onCancelPress = new OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
		}
	};

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

}
