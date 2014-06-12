package br.com.imageflow;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import br.com.imageflow.adapter.ImageAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class ImageFlowFragment extends Fragment {

	private static ImageFlowFragment fragment;

	private ArrayList<String> list = new ArrayList<String>();

	public ImageFlowFragment() {

	}

	public static Fragment getInstance() {
//		if (fragment == null)
			fragment = new ImageFlowFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-1663454.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-45245.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-184157.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-8701.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-982050.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-302813.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-343465.jpg");
		list.add("http://wallpapers.wallbase.cc/rozne/wallpaper-599766.jpg");

		View rootView = inflater.inflate(R.layout.fragment_image_flow,
				container, false);
		GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(getActivity(), list ));

		return rootView;
	}

}
