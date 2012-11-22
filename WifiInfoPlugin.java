package org.apache.cordova.plugin;


import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class WifiInfoPlugin extends CordovaPlugin { 

	@Override 
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		
		Context context = cordova.getActivity().getApplicationContext();
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("BSSID", wifiInfo.getBSSID());
			obj.put("HiddenSSID", wifiInfo.getHiddenSSID());
			obj.put("SSID", wifiInfo.getSSID());
			obj.put("MacAddress", wifiInfo.getMacAddress());
			obj.put("IpAddress", wifiInfo.getIpAddress());
			obj.put("NetworkId", wifiInfo.getNetworkId());
			obj.put("RSSI", wifiInfo.getRssi());
			obj.put("LinkSpeed", wifiInfo.getLinkSpeed());
			
		} catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error("JSON Exception");
		}
		callbackContext.success(obj);
		return true;
	}
}
