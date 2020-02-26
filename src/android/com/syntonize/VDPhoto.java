package com.syntonize;

import com.dasnano.vdphotoselfiecapture.VDPhotoSelfieCapture;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by David on 26/02/2020.
 */


public class VDPhoto extends VDPhotoSelfieCapture implements VDPhotoSelfieCapture.IVDPhotoSelfieCapture {


    public VDPhoto(){
        //
    }

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


