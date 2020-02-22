/**
 */
package com.syntonize;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class CDVVDPhotoSelfieCapture extends CordovaPlugin {
  private static final String TAG = "CDVVDPhotoSelfieCapture";

  //declare each plugin method
  private static final String START = "start";



  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    // Log.d(TAG, "Starting OnSpota plugin");
    // OnSpotaSDK = new OnspotaApi(this.cordova.getContext());

  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if(START.equals(action)) {
        this.initTracker(callbackContext, args.getString(0));
    }
    return true;
  }


  private void initTracker(final CallbackContext callbackContext, final String appID){
    //   OnspotaApi.SdkResult sdkResult = OnSpotaSDK.start(appID);
    //   String msg = "";
    //   if (sdkResult == OnspotaApi.SdkResult.Ok) {
    //       // SDK was started.
    //       msg = "OnSpota SDK started with ID:" + appID;
    //   }
    //   else if (sdkResult == OnspotaApi.SdkResult.AndroidVersionNotSupported) {
    //       Log.w(TAG,"OnSpota SDK doesn't support current android os");
    //       msg = "OnSpota SDK doesn't support current android os";
    //   }
    //   else if (sdkResult == OnspotaApi.SdkResult.FailedToFind3rdPartyLib) {
    //       Log.e(TAG,"Critical error: OnSpota SDK Failed to find at least one of its required dependencies.");
    //       msg = "Critical error: OnSpota SDK Failed to find at least one of its required dependencies.";
    //   }
    //   else if (sdkResult == OnspotaApi.SdkResult.Failed) {
    //       Log.e(TAG,"OnSpota SDK Failed to start.");
    //       msg = "OnSpota SDK Failed to start.";
    //   }

        msg = "test";

      JSONObject jsonOut = new JSONObject();
      try{
          jsonOut.put("msg",msg);
      }catch (JSONException e){
          //
      }

    if (sdkResult == OnspotaApi.SdkResult.Ok){
        this.callbackSuccess(callbackContext, jsonOut);
    }else{
        this.callbackError(callbackContext, msg);
    }
  }

  

    // @Override
    public void onResume(Boolean multitask) {
        super.onResume(multitask);

        // cordova.getContext().registerReceiver(mEventReceiver, new IntentFilter(cordova.getContext().getString(com.onspota.sdk.R.string.intent_search)));
    }
    // @Override
    public void onPause(Boolean multitask) {
        super.onPause(multitask);
        // cordova.getContext().unregisterReceiver(mEventReceiver);
    }




    private static void callbackSuccess(CallbackContext callbackContext, JSONObject jsonObject) {
        if (jsonObject == null) // in case there are no data
            jsonObject = new JSONObject();

        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jsonObject);
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
    }

    private static void callbackError(CallbackContext callbackContext, JSONObject jsonObject) {
        if (jsonObject == null) // in case there are no data
            jsonObject = new JSONObject();

        PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, jsonObject);
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
    }

    private static void callbackError(CallbackContext callbackContext, String str) {
        PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, str);
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
    }

    @Override
    public void onDestroy() {
        //
    }


}
