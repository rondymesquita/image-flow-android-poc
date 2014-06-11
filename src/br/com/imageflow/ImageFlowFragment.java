package br.com.imageflow;

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
	
	public ImageFlowFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_image_flow, container,false);
		
//		ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
//		String url = "http://bestipadwallpapershd.com/wp-content/uploads/sites/5/2013/07/colored-pencils-textures-ipad-wallpaper-hd-500x500.jpg";
//		Picasso.with(getActivity()).load(url).into(imageView);
		
		GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(getActivity()));
		
		return rootView;
	}

	public static Fragment getInstance() {
		if(fragment == null)
			fragment = new ImageFlowFragment();
		return fragment;
	}
}
