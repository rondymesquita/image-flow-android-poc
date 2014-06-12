package br.com.imageflow.application;

import java.util.ArrayList;

public class ImageApplicationImpl implements ImageApplication{

	private static ArrayList<String> list;
	public static ImageApplicationImpl application;
	
	public static ImageApplicationImpl getInstance(){
		if(application == null){
			application = new ImageApplicationImpl();
			list = new ArrayList<String>();
		}
		
		return application;
	}
	
	@Override
	public void getImage(String url) {
		
	}

	@Override
	public String getRandomImage() {
		return null;
	}

	@Override
	public void add(String url) {
		list.add(url);
	}

	@Override
	public ArrayList<String> list() {
		return list;
	}
	

}
