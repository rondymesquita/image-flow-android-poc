package br.com.utils;

import android.content.Context;
import android.widget.Toast;

public class ViewUtils {
	
	public static void showToast(Context ctx,String text){
		Toast.makeText(ctx, text, 200).show();
	}

}
