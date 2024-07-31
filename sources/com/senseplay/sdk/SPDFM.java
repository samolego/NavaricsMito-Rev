package com.senseplay.sdk;

import android.os.Handler;
import android.util.Log;
import com.adapt.SPM_Dfm;
import com.adapt.SPM_Manager;
import com.common.SP_REQUEST_REL;
import com.common.SP_Util;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.model.dfm.DFMEnum;
import com.senseplay.sdk.model.dfm.DFMFlag;
import com.senseplay.sdk.model.dfm.DFMTool;
import com.senseplay.sdk.tool.ErrorMsg;
import com.senseplay.sdk.tool.HandleOpe;
import com.senseplay.sdk.tool.SPUtilTool;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes2.dex */
public class SPDFM {
    private static SPDFM spdfm;
    private int read_time = IjkMediaCodecInfo.RANK_SECURE;
    private int write_time = 400;
    private int tempFlag = -99;
    private SPM_Dfm spm_dfm = SPM_Manager.GetInstance().GetDfm();
    private ErrorMsg errorMsg = ErrorMsg.getInstance();

    public static SPDFM getInstance() {
        if (spdfm == null) {
            synchronized (SPDFM.class) {
                if (spdfm == null) {
                    spdfm = new SPDFM();
                }
            }
        }
        return spdfm;
    }

    private SPDFM() {
    }

    public void mfiState(final MCallBack<Boolean> mCallBack) {
        this.spm_dfm.requestMfiState();
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDFM.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                byte[] bArr = new byte[1];
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPDFM.this.spm_dfm.GetRequestMfiStateRel(bArr, sp_request_rel);
                Log.w("DFMTool", "mfiState: " + ((int) sp_request_rel.ERR_CODE));
                Log.w("DFMTool", "mfiState VAL: " + ((int) bArr[0]));
                if (sp_request_rel.ERR_CODE == 0) {
                    if (bArr[0] != 0) {
                        mCallBack.onResult(true);
                    } else {
                        mCallBack.onResult(false);
                    }
                }
                mCallBack.onResult(false);
            }
        }, 1000);
    }

    public void readChipID(final MCallBack<String> mCallBack) {
        this.spm_dfm.RequestCid();
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDFM.2
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                byte[] bArr = new byte[7];
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPDFM.this.spm_dfm.GetRequestCidRel(bArr, sp_request_rel);
                mCallBack.onResult(sp_request_rel.ERR_CODE == 0 ? SP_Util.byte2str(bArr) : "");
            }
        }, this.read_time);
    }

    public void writeChipID(byte[] bArr, final MCallBack<CallBackMsg> mCallBack) {
        if (bArr == null || bArr.length != 7) {
            mCallBack.onResult(this.errorMsg.newMsg(-1, "bytes length is wrong"));
            return;
        }
        this.spm_dfm.WriteChipID(bArr);
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDFM.3
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                mCallBack.onResult(SPDFM.this.errorMsg.newMsg(SPDFM.this.spm_dfm.GetCidWriteRel(), ""));
            }
        }, this.read_time);
    }

    public void getSN(final MCallBack<String> mCallBack) {
        this.spm_dfm.RequestSn();
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDFM.4
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                byte[] bArr = new byte[18];
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPDFM.this.spm_dfm.GetRequestSnRel(bArr, sp_request_rel);
                mCallBack.onResult(sp_request_rel.ERR_CODE == 0 ? SPUtilTool.asciiToString(bArr) : "");
            }
        }, this.read_time);
    }

    public void readFlag(final MCallBack<DFMFlag> mCallBack) {
        this.spm_dfm.RequestFlag();
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDFM.5
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                byte[] bArr = new byte[4];
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPDFM.this.spm_dfm.GetRequestFlagRel(bArr, sp_request_rel);
                Log.w("DFMTool", "ERR_CODE: " + ((int) sp_request_rel.ERR_CODE));
                if (sp_request_rel.ERR_CODE == 0) {
                    SPDFM.this.tempFlag = DFMTool.byteArrayToInt(bArr, 0);
                }
                mCallBack.onResult(DFMTool.readFlag(SPDFM.this.tempFlag));
            }
        }, this.read_time);
    }

    public void writeFlag(DFMEnum dFMEnum, int i, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_dfm.WriteFlag(DFMTool.writeFlag(this.tempFlag, dFMEnum, i));
        Log.w("DFMTools", "WriteFlag: " + System.currentTimeMillis());
        new Handler().postDelayed(new Runnable() { // from class: com.senseplay.sdk.SPDFM.6
            @Override // java.lang.Runnable
            public void run() {
                int GetWriteFlagRel = SPDFM.this.spm_dfm.GetWriteFlagRel();
                Log.w("DFMTools", "code: " + GetWriteFlagRel + " ack: " + System.currentTimeMillis());
                mCallBack.onResult(SPDFM.this.errorMsg.newMsg(GetWriteFlagRel, ""));
            }
        }, (long) this.write_time);
    }
}
