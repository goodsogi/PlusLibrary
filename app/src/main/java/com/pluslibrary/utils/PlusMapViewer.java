package com.pluslibrary.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


/**
 * 구글지도 보기
 * 
 * @author jeff
 * 
 */
public class PlusMapViewer {
    public static final String GOOGLE_KEY = "AIzaSyDP6743YsU_u9Fe3ujzyI2ogZjEpv3febo";
    public static final String GET_GEO = "https://maps.googleapis.com/maps/api/geocode/xml?address="; //위도, 경도 검색
	private static Context mContext;

	public PlusMapViewer(Context context) {
		mContext = context;
	}

	public static void doIt(Context context, String latitude, String longitude) {
		Intent intent = new Intent(Intent.ACTION_VIEW,
				Uri.parse("geo:" + latitude + "," + longitude + "?q="
						+ latitude + "," + longitude + "(" + "" + ")"));
		intent.setComponent(new ComponentName("com.google.android.apps.maps",
				"com.google.android.maps.MapsActivity"));
		context.startActivity(intent);
	}

//	public void doIt(String address) {
//		try {
//			new PlusHttpClient((Activity) mContext, PlusMapViewer.this, false)
//					.execute(
//							GET_GEO,
//							ApiConstants.GET_GEO
//									+ URLEncoder.encode(address + "&key="
//											+ ApiConstants.GOOGLE_KEY, "UTF-8"),
//							new GeoParser());
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


}
