package com.senseplay.sdk;

import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.model.cloud.BindDevice;
import com.senseplay.sdk.model.cloud.CloudHttp;
import java.util.List;

/* loaded from: classes2.dex */
public class SPCloud {
    private static SPCloud spCloud;
    private CloudHttp cloudHttp = new CloudHttp(SPManager.getContent());

    public static SPCloud getInstance() {
        if (spCloud == null) {
            synchronized (SPCloud.class) {
                if (spCloud == null) {
                    spCloud = new SPCloud();
                }
            }
        }
        return spCloud;
    }

    private SPCloud() {
    }

    public void getDevIno(String str, String str2, MCallBack<BindDevice> mCallBack) {
        this.cloudHttp.getDevIno(str, str2, mCallBack);
    }

    public void uptDevIno(String str, String str2, String str3, MCallBack<CallBackMsg> mCallBack) {
        this.cloudHttp.uptDevIno(str, str2, str3, mCallBack);
    }

    public void refreshAccCode(String str, String str2, MCallBack<String> mCallBack) {
        this.cloudHttp.refreshAccCode(str, str2, mCallBack);
    }

    public void getBindList(String str, MCallBack<List<BindDevice>> mCallBack) {
        this.cloudHttp.getBindList(SPManager.getClientId(), str, mCallBack);
    }
}
