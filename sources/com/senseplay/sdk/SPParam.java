package com.senseplay.sdk;

import android.content.Context;
import android.util.Log;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.config.SPFilePath;
import com.senseplay.sdk.model.vehicle.ParamData;
import com.senseplay.sdk.model.vehicle.ParamEnum;
import com.senseplay.sdk.model.vehicle.VehicleParamThread;

/* loaded from: classes2.dex */
public class SPParam {
    private static SPParam spParam;
    private final String modelPath;
    private ParamData paramData;
    private VehicleParamThread vehicleParam;
    private final String fileName = "parameter.ini";
    private final String dirPath = SPFilePath.path_senseplay + "/senseplay/";
    private final String path = SPFilePath.path_senseplay + "/senseplay/parameter.ini";

    public static SPParam getInstance() {
        if (spParam == null) {
            synchronized (SPParam.class) {
                if (spParam == null) {
                    spParam = new SPParam();
                }
            }
        }
        return spParam;
    }

    private SPParam() {
        StringBuilder sb = new StringBuilder();
        sb.append(SPFilePath.path_senseplay);
        sb.append("/senseplay/model.ini");
        this.modelPath = sb.toString();
        Context content = SPManager.getContent();
        this.paramData = new ParamData(content);
        content.getCacheDir();
    }

    public boolean load() {
        return this.paramData.load(this.path);
    }

    public boolean set(String str, String str2, String str3) {
        try {
            return this.paramData.set(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String get(String str, String str2) {
        try {
            return this.paramData.get(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void save(final MCallBack<Boolean> mCallBack) {
        boolean save = this.paramData.save(this.dirPath, "parameter.ini");
        Log.w("bool", "bool " + save);
        if (!save) {
            mCallBack.onResult(false);
            return;
        }
        Log.w("vehicleParam", "vehicleParam " + this.vehicleParam);
        if (this.vehicleParam == null) {
            this.vehicleParam = new VehicleParamThread();
            this.vehicleParam.setListener(this.path, new VehicleParamThread.VehicleParamListener() { // from class: com.senseplay.sdk.SPParam.1
                @Override // com.senseplay.sdk.model.vehicle.VehicleParamThread.VehicleParamListener
                public void succ() {
                    SPParam.this.release();
                    mCallBack.onResult(true);
                }

                @Override // com.senseplay.sdk.model.vehicle.VehicleParamThread.VehicleParamListener
                public void fail() {
                    SPParam.this.release();
                    mCallBack.onResult(false);
                }
            });
            this.vehicleParam.start();
        }
    }

    public void swithModel(ParamEnum paramEnum, final MCallBack<Boolean> mCallBack) {
        boolean open = this.paramData.open(this.modelPath, paramEnum);
        Log.w("bool", "bool " + open);
        if (!open) {
            mCallBack.onResult(false);
        } else if (this.vehicleParam == null) {
            this.vehicleParam = new VehicleParamThread();
            this.vehicleParam.setListener(this.modelPath, new VehicleParamThread.VehicleParamListener() { // from class: com.senseplay.sdk.SPParam.2
                @Override // com.senseplay.sdk.model.vehicle.VehicleParamThread.VehicleParamListener
                public void succ() {
                    SPParam.this.release();
                    mCallBack.onResult(true);
                }

                @Override // com.senseplay.sdk.model.vehicle.VehicleParamThread.VehicleParamListener
                public void fail() {
                    SPParam.this.release();
                    mCallBack.onResult(false);
                }
            });
            this.vehicleParam.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        VehicleParamThread vehicleParamThread = this.vehicleParam;
        if (vehicleParamThread != null) {
            vehicleParamThread.release();
            this.vehicleParam = null;
        }
    }
}
