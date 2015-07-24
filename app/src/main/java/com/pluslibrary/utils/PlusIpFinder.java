package com.pluslibrary.utils;

import android.util.Log;

import org.apache.http.conn.util.InetAddressUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class PlusIpFinder {
	public static String doIt() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();

					String ipv4;
					// for getting IPV4 format
					if (!inetAddress.isLoopbackAddress()
							&& InetAddressUtils
									.isIPv4Address(ipv4 = inetAddress
											.getHostAddress())) {

						String ip = inetAddress.getHostAddress().toString();
						// return inetAddress.getHostAddress().toString();
						return ipv4;
					}
				}
			}
		} catch (Exception ex) {
			Log.e("IP Address", ex.toString());
		}
		return null;
	}
}
