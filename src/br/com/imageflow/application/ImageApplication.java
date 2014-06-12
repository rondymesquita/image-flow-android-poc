package br.com.imageflow.application;

import java.util.List;

public interface ImageApplication {
	
	void getImage(String url);
	public String getRandomImage();
	void add(String url);
	public List<String> list();

}
