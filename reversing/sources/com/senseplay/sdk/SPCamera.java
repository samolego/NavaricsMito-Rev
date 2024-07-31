package com.senseplay.sdk;

import com.adapt.SPM_Camera;
import com.adapt.SPM_Device;
import com.adapt.SPM_Manager;
import com.common.CAM_ATTRIBUTE;
import com.common.SP_REQUEST_REL;
import com.common.WhiteBalance;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.tool.HandleOpe;

/* loaded from: classes2.dex */
public class SPCamera {
    public static final int CAMERA1 = 0;
    public static final int CAMERA2 = 1;
    public static final int CAMERA_HD = 1;
    public static final int CAMERA_HS = 2;
    private static SPCamera spCamera;
    private byte[] camera1 = {1, 1};
    private byte[] camera2 = {1, 2};
    private byte[] camera3 = {2, 1, 2};
    private SPM_Camera spm_camera = SPM_Manager.GetInstance().GetCamera();
    private SPM_Device spm_device = SPM_Manager.GetInstance().GetDevice();

    public static SPCamera getInstance() {
        if (spCamera == null) {
            synchronized (SPCamera.class) {
                if (spCamera == null) {
                    spCamera = new SPCamera();
                }
            }
        }
        return spCamera;
    }

    private SPCamera() {
    }

    public void switchCamera(int i, final MCallBack<Boolean> mCallBack) {
        if (i == 0) {
            this.spm_camera.SetStreaming(this.camera1);
        } else {
            this.spm_camera.SetStreaming(this.camera2);
        }
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPCamera.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                mCallBack.onResult(Boolean.valueOf(SPCamera.this.spm_camera.GetStreamingResult()));
            }
        });
    }

    public void setCameraAttr(int i, final MCallBack<Boolean> mCallBack) {
        try {
            CAM_ATTRIBUTE cam_attribute = new CAM_ATTRIBUTE();
            if (i == 1) {
                cam_attribute.setParam(1920, 1080, 30, WhiteBalance.Auto);
            } else if (i == 2) {
                cam_attribute.setParam(1280, 720, 50, WhiteBalance.Auto);
            }
            this.spm_device.setCamAttribute(cam_attribute);
            HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPCamera.2
                @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
                public void run() {
                    SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                    SPCamera.this.spm_device.setCamAttributeRel(sp_request_rel);
                    mCallBack.onResult(Boolean.valueOf(sp_request_rel.ERR_CODE == 0));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        spCamera = null;
    }
}
