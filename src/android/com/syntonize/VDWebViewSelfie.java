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

    VDPhoto myPhoto = new VDPhoto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_selfie);
        // Start SDK.
        if (!VDPhotoSelfieCapture.isStarted()) {
            Map<String, String> configuration = new HashMap<>();
            configuration.put("smartselfie", "NO");
            VDPhotoSelfieCapture.start((VDPhotoSelfieCapture.IVDPhotoSelfieCapture)myPhoto, getApplicationContext(), configuration);
        }
    }



}
