package com.senseplay.sdk.model.dev;

import android.content.Context;
import com.adapt.SPM_Device;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.tool.ErrorMsg;
import com.senseplay.sdk.tool.HandleOpe;
import com.senseplay.sdk.tool.Hex16;

/* loaded from: classes2.dex */
public class DevManager {
    private static DevManager devManager;
    private DevHttp devHttp;
    private ErrorMsg errorMsg = ErrorMsg.getInstance();
    private SPM_Rc spm_rc = SPM_Manager.GetInstance().GetRc();
    private SPM_Device spm_device = SPM_Manager.GetInstance().GetDevice();

    public static DevManager getInstance(Context context) {
        if (devManager == null) {
            synchronized (DevManager.class) {
                if (devManager == null) {
                    devManager = new DevManager(context);
                }
            }
        }
        return devManager;
    }

    private DevManager(Context context) {
        this.devHttp = new DevHttp(context);
    }

    public void getBind(String str, MCallBack<SnBind> mCallBack) {
        this.devHttp.getBind(str, mCallBack);
    }

    public void unBindRc(String str, final String str2, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_rc.EraseUid(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.model.dev.DevManager.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                int GetEraseRel = DevManager.this.spm_rc.GetEraseRel();
                if (GetEraseRel == 0 || GetEraseRel == 5) {
                    DevManager.this.delUidHttp(str2, mCallBack);
                } else {
                    mCallBack.onResult(DevManager.this.errorMsg.getMsg(GetEraseRel));
                }
            }
        });
    }

    public void unBindDev(String str, final String str2, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_device.EraseUid(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.model.dev.DevManager.2
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                int GetEraseUidRel = DevManager.this.spm_device.GetEraseUidRel();
                if (GetEraseUidRel == 0 || GetEraseUidRel == 5) {
                    DevManager.this.delUidHttp(str2, mCallBack);
                } else {
                    mCallBack.onResult(DevManager.this.errorMsg.getMsg(GetEraseUidRel));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delUidHttp(String str, final MCallBack<CallBackMsg> mCallBack) {
        this.devHttp.unBind(str, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.model.dev.DevManager.3
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(CallBackMsg callBackMsg) {
                if (callBackMsg == null) {
                    mCallBack.onResult(DevManager.this.errorMsg.httpError());
                } else {
                    mCallBack.onResult(callBackMsg);
                }
            }
        });
    }
}
