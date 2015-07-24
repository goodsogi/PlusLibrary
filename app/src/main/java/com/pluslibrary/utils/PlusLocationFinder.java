package com.pluslibrary.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.pluslibrary.R;


/**
 * 현재 위치 가져오기
 * 
 * @author jeff
 * 
 */
public class PlusLocationFinder implements android.location.LocationListener  {

    public static final int REQUEST_LOCATION_AGREEMENT = 3;
    private Activity mActivity;
	private LocationManager mLocationManager;
	private String mProvider;
	private String mApiUrl;

	public PlusLocationFinder(Activity activity, String apiUrl) {
		mActivity = activity;
		mApiUrl = apiUrl;

	}
	
	
	public boolean doIt() {
		if(canGetLocation()) {
			getCurrentLocation();
			return true;
		} else {
			moveToSetting();
			return false;
		}
	}

	public boolean canGetLocation() {
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(mActivity);
		if (status != ConnectionResult.SUCCESS)
			return false;

		mLocationManager = (LocationManager) mActivity
				.getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		mProvider = mLocationManager.getBestProvider(criteria, true);

		if (mProvider == null
				|| mProvider.equals(LocationManager.PASSIVE_PROVIDER))
			return false;

		// 구글 플레이 서비스를 사용할 수 있고 설정에서 위치 정보 액세스가 on된 경우
		return true;

	}

	/**
	 * 위치 정보 액세스 설정으로 이동
	 */

	public void moveToSetting() {

		new AlertDialog.Builder(mActivity)
				.setTitle("알림")
				.setMessage("위치서비스를 사용하기 위해서 설정에서 on 시키세요")
				.setNeutralButton("확",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                mActivity
                                        .startActivityForResult(
                                                new Intent(
                                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                                                REQUEST_LOCATION_AGREEMENT);
                            }
                        })
				.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                    }
                }).show();

	}

	/**
	 * 현재 위치 가져오기
	 */
	public void getCurrentLocation() {
		// TODO Auto-generated method stub
		// mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
		// 1000, 10, this);
		// 네트워크 제공자가 제공하는 위치. GPS를 사용하면 변경 필요!!
		mLocationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 1000, 10, this);

	}

	@Override
	public void onLocationChanged(final Location location) {

		mLocationManager.removeUpdates(this);
		//서버 등록 !!
		

		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

	


}
