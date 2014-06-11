package br.com.imageflow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FavoritesFragment extends Fragment {
	
	private static FavoritesFragment fragment;
	
	public FavoritesFragment(){
		
	}
	
	public static Fragment getInstance(){
		if(fragment == null){
			fragment = new FavoritesFragment();
		}
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_image_flow, container,false);
		
		return rootView;
	}

}
