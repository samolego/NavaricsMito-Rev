package com.adapt;

import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SPM_Camera {

    /* loaded from: classes.dex */
    enum LENSE_TYPE {
        FarForcus,
        WideAngle
    }

    /* loaded from: classes.dex */
    enum SHUTTER_TYPE {
        GLOBAL,
        ROLLING
    }

    /* loaded from: classes.dex */
    enum VIDEO_RECORD_TYPE {
        OTA,
        ONBOARD,
        OTA_AND_ONBOARD
    }

    void AutoFocus() {
    }

    int GetVideoStorageSize() {
        return 0;
    }

    void SetAuto() {
    }

    boolean SetLens(LENSE_TYPE lense_type) {
        return false;
    }

    void SetVideoRecordType(VIDEO_RECORD_TYPE video_record_type) {
    }

    public void TakePhoto(byte b, short s) {
    }

    void VideoStart(int i) {
    }

    void VideoStop() {
    }

    public int SetStreaming(byte[] bArr) {
        return CppSDKConnectors.SetStreaming(bArr);
    }

    public boolean GetStreamingResult() {
        return CppSDKConnectors.GetStreamingResult();
    }

    public int RequestCamCount() {
        return CppSDKConnectors.RequestCamCount();
    }

    public int GetCamCount() {
        return CppSDKConnectors.GetCamCount();
    }

    public int RequestStatus(byte b) {
        return CppSDKConnectors.RequestStatus(b);
    }

    public int RequestAttribute(byte b) {
        return CppSDKConnectors.RequestAttribute(b);
    }

    public int TakePhoto(byte b, byte b2, byte b3) {
        return CppSDKConnectors.TakePhoto(b, b2, b3);
    }
}