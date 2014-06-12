package br.com.imageflow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import br.com.imageflow.adapter.ImageAdapter;
import br.com.imageflow.application.ImageApplicationImpl;

public class FavoritesFragment extends Fragment {

	private static FavoritesFragment fragment;
	private ImageAdapter imageAdapter;

	public FavoritesFragment() {

	}

	public static Fragment getInstance() {
		 if(fragment == null)
		fragment = new FavoritesFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_image_flow,
				container, false);
		GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
		ImageApplicationImpl application = ImageApplicationImpl.getInstance();
		
		if(!application.list().isEmpty()){
			imageAdapter = new ImageAdapter(getActivity(), application.list());
			gridView.setAdapter(imageAdapter);
		}

		return rootView;
	}

}
