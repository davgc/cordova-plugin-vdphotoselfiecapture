package com.syntonize;

import android.app.Activity;
import android.os.Bundle;

import com.dasnano.vdphotoselfiecapture.VDPhotoSelfieCapture;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import io.ionic.starterSDK333.R;

/**
 * Created by David on 26/02/2020.
 */

public class VDWebViewSelfie extends Activity  {

    IVDPhotoSelfieCapture myPhoto = new IVDPhotoSelfieCapture(){
         @Override
        public void VDPhotoSelfieFinished(boolean fin) {
            // Do whatever you want when SDK is finished.
        }
        @Override
        public void VDPhotoSelfieAndFaceCaptured(ByteArrayInputStream  selfie, ByteArrayInputStream face) {
            // Do with ByteArrayInputStream as needed.
            // If the levelquality is set to "high" the byteArray is compressed at 85% and if it is set to "medium"
        // is compressed at 70%.
        }
        @Override
        public void VDPhotoSelfieAndFaceCapturedWithLiveDetection(ByteArrayInputStream selfieByteArray,
                                                                ByteArrayInputStream faceByteArray) {
            // In case the configuration for "livephoto" is "YES", this is a picture of the person with a more
        // natural pose but with lower quality.
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_selfie);
        // Start SDK.
        if (!VDPhotoSelfieCapture.isStarted()) {
            Map<String, String> configuration = new HashMap<>();
            configuration.put("smartselfie", "NO");
            VDPhotoSelfieCapture.start(myPhoto, getApplicationContext(), configuration);
        }
    }



}
