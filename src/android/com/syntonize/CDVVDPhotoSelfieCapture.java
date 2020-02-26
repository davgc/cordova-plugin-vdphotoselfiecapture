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

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;


import com.dasnano.vdphotoselfiecapture.VDPhotoSelfieCapture;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.ionic.starterSDK333.MainActivity;


public class CDVVDPhotoSelfieCapture extends CordovaPlugin {

    //VDSelfie mySelfie;

    //the view
    /*private class VDWebViewSelfie extends Activity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //setContentView(R.layout.your_layout);
            setContentView(null);

            if (!VDPhotoSelfieCapture.isStarted()) {
                Map<String, String> configuration = new HashMap<>();
                configuration.put("smartselfie", "NO");
                //VDPhotoSelfieCapture.start(mySelfie, cordova.getContext(), configuration);

            }
        }
    }

    //interface
    private class VDSelfie implements VDPhotoSelfieCapture.IVDPhotoSelfieCapture {

        @Override
        public void VDPhotoSelfieFinished(boolean finish) {
            // Do whatever you want when SDK is finished.
        }
        @Override
        public void VDPhotoSelfieAndFaceCaptured(ByteArrayInputStream  selfie, ByteArrayInputStream face) {
            // Do with ByteArrayInputStream as needed.
            // If the levelquality is set to "high" the byteArray is compressed at 85% and if it is set to "medium"
            //is compressed at 70%.
        }
        @Override
        public void VDPhotoSelfieAndFaceCapturedWithLiveDetection(ByteArrayInputStream selfieByteArray,
                                                                  ByteArrayInputStream faceByteArray) {
            // In case the configuration for "livephoto" is "YES", this is a picture of the person with a more
            //natural pose but with lower quality.
        }

    }*/


  private static final String TAG = "CDVVDPhotoSelfieCapture";

  //declare each plugin method
  private static final String START = "start";




  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

     Log.d(TAG, "Starting Selfie plugin");

      //mySelfie = new VDSelfie();

  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if(START.equals(action)) {
        this.start(callbackContext);
    }
    return true;
  }


  private void start(final CallbackContext callbackContext){
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

    //    String msg = "test";

    //   JSONObject jsonOut = new JSONObject();
    //   try{
    //       jsonOut.put("msg",msg);
    //   }catch (JSONException e){
    //       //
    //   }

    // if (sdkResult == OnspotaApi.SdkResult.Ok){
    //     this.callbackSuccess(callbackContext, jsonOut);
    // }else{
    //     this.callbackError(callbackContext, msg);
    // }

      //startActivity(new Intent(MainActivity.this, MyOtherActivity.class));


      //Intent intentSelfie = new Intent(cordova.getActivity().getBaseContext(), VDWebViewSelfie.class);
     // cordova.getActivity().startActivity(intentSelfie);


      final Intent i = new Intent(cordova.getActivity(), VDWebViewSelfie.class);
      cordova.getActivity().startActivity(i);

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
