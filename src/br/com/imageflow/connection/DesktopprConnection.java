package br.com.imageflow.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;

public class DesktopprConnection {
	
	class Wallpaper{
		private Integer id;
		private Image image;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}
		
		
	}
	
	class Image{
		private String url;
		private String thumb;
		private String preview;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getThumb() {
			return thumb;
		}
		public void setThumb(String thumb) {
			this.thumb = thumb;
		}
		public String getPreview() {
			return preview;
		}
		public void setPreview(String preview) {
			this.preview = preview;
		}
		
	}

	public static String URL = "https://api.desktoppr.co";
	public static String RONDY_TOKEN = "ZfXsTzHM6ZhcyWwyZp-F";
	
	public static String doConnection(String uri) throws IOException {
		
		URL urlConnection = new URL(uri);

		HttpsURLConnection connection = (HttpsURLConnection) urlConnection.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String input;
		
		StringBuilder result = new StringBuilder();
		while ((input = br.readLine()) != null) {
			result.append(input);
		}
		br.close();

		return new String(result);
	}
	
	public static String auth(String token) throws IOException {
		return doConnection(URL+"/1/user/whoami?auth_token="+token);
	}
	
	public static String getUserInfo(String username) throws IOException{
		return doConnection(URL+"/1/users/"+username);
	}
	
	public static String sayHelloToServer() throws IOException{
		return doConnection(URL+"?callback=hello");
	}
	
	public static String getAllWallpapers() throws IOException{
		return doConnection(URL+"/1/wallpapers");
	}
	
	public static String getRandomWallpaper() throws IOException{
		return doConnection(URL+"/1/wallpapers/random");
	}
	

}
