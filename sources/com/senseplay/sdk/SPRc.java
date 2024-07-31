package com.senseplay.sdk;

import android.util.Log;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.common.SPRC_INFO;
import com.common.SP_BATTERY_INFO;
import com.common.SP_BATTERY_STATUS;
import com.common.SP_REQUEST_REL;
import com.common.VIBRATION_DATA;
import com.common.VIBRATION_MOTOR_TYPE;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.device.BatteryInfo;
import com.senseplay.sdk.model.device.BatteryStatus;
import com.senseplay.sdk.model.device.DeviceData;
import com.senseplay.sdk.model.device.DeviceHttp;
import com.senseplay.sdk.model.device.DeviceInfo;
import com.senseplay.sdk.model.device.DeviceUser;
import com.senseplay.sdk.tool.ErrorMsg;
import com.senseplay.sdk.tool.HandleOpe;
import com.senseplay.sdk.tool.Hex16;

/* loaded from: classes2.dex */
public class SPRc {
    private static SPRc spRc;
    private final String tag = SPRc.class.getSimpleName();
    private boolean isLogin = true;
    BatteryStatus status = new BatteryStatus();
    SP_BATTERY_STATUS sp_battery_status = new SP_BATTERY_STATUS();
    private ErrorMsg errorMsg = ErrorMsg.getInstance();
    private SPM_Rc spm_rc = SPM_Manager.GetInstance().GetRc();
    private DeviceHttp deviceHttp = new DeviceHttp(SPManager.getContent());

    public static SPRc getInstance() {
        if (spRc == null) {
            synchronized (SPRc.class) {
                if (spRc == null) {
                    spRc = new SPRc();
                }
            }
        }
        return spRc;
    }

    private SPRc() {
        setRcCommond(true);
    }

    public void getRcInfo(final MCallBack<DeviceInfo> mCallBack) {
        Log.d("RequestInfo", "RequestInfo:");
        this.spm_rc.RequestInfo();
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                SPRC_INFO sprc_info = new SPRC_INFO();
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPRc.this.spm_rc.GetInfoRel(sprc_info, sp_request_rel);
                mCallBack.onResult(DeviceData.toRcInfo(sprc_info, sp_request_rel));
            }
        }, 500);
    }

    public BatteryInfo getBatteryInfo() {
        BatteryInfo batteryInfo = new BatteryInfo();
        SP_BATTERY_INFO GetBatteryInfo = this.spm_rc.GetBatteryInfo();
        if (GetBatteryInfo != null) {
            batteryInfo.setCapacity(GetBatteryInfo.Capacity);
            batteryInfo.setNumCells(GetBatteryInfo.NumCells);
        }
        return batteryInfo;
    }

    public BatteryStatus getBatteryStatus() {
        this.spm_rc.GetBatteryStatus(this.sp_battery_status);
        if (this.sp_battery_status.State != null) {
            this.status.setState(this.sp_battery_status.State.value());
            this.status.setStateDesc(this.sp_battery_status.State.toString());
        }
        this.status.setEnergyLevel(this.sp_battery_status.EnergyLevel);
        return this.status;
    }

    public void setVibrationWave(int i, int i2, int i3) {
        setVibration(VIBRATION_MOTOR_TYPE.VIBRATION_MOTOR_WAVEFORM_DRIVE, i, i2, i3);
    }

    public void setVibrationFile(int i, int i2, int i3) {
        setVibration(VIBRATION_MOTOR_TYPE.VIBRATION_MOTOR_FILE_DRIVE, i, i2, i3);
    }

    private void setVibration(VIBRATION_MOTOR_TYPE vibration_motor_type, int i, int i2, int i3) {
        VIBRATION_DATA vibration_data = new VIBRATION_DATA();
        vibration_data.Type = vibration_motor_type;
        vibration_data.MotorID = (byte) i;
        int i4 = i2 <= 100 ? i2 : 100;
        if (i4 < 0) {
            i4 = 0;
        }
        vibration_data.Strength = (byte) i4;
        vibration_data.Duration = i3;
        vibration_data.NeedAck = false;
        this.spm_rc.StartVibration(vibration_data);
    }

    public void setRcCommond(boolean z) {
        this.spm_rc.EnRfCommunication(z);
    }

    public void verifyUid(String str, final MCallBack<DeviceUser> mCallBack) {
        SPDebug.m5816d("verifyUid rc uid:" + str);
        this.spm_rc.RequestUidVerify(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.2
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                DeviceUser deviceUser = new DeviceUser();
                byte GetUidVerifyRel = SPRc.this.spm_rc.GetUidVerifyRel();
                if (GetUidVerifyRel != 0 && GetUidVerifyRel != 12) {
                    deviceUser.setCode(GetUidVerifyRel);
                    deviceUser.setErrorMsg(SPRc.this.errorMsg.getMsgStr(GetUidVerifyRel));
                    if (GetUidVerifyRel != 5 && GetUidVerifyRel != -1) {
                        deviceUser.setBind(true);
                    }
                } else {
                    deviceUser.setCode(0);
                    SPRc.this.isLogin = true;
                    deviceUser.setBind(true);
                    deviceUser.setOwner(true);
                }
                SPDebug.m5816d("verifyUid rc result code :" + deviceUser.getCode() + " isBind:" + deviceUser.isBind() + " isOwner:" + deviceUser.isOwner());
                mCallBack.onResult(deviceUser);
            }
        });
    }

    public void bindRc(final String str, final String str2, String str3, String str4, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("bindRc uid:" + str + " sn:" + str2 + " access_token:" + str3 + " verify_code:" + str4);
        this.deviceHttp.bindDevice(str2, str3, str4, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.SPRc.3
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(CallBackMsg callBackMsg) {
                if (callBackMsg == null) {
                    mCallBack.onResult(SPRc.this.errorMsg.noHttp());
                } else if (callBackMsg.getCode() == 0) {
                    SPRc.this.setUid(str, str2, mCallBack);
                } else {
                    mCallBack.onResult(callBackMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(String str, String str2, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_rc.ChangeUid(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()), Hex16.decodeHex(Hex16.encodeHexStr(str2.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.4
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPRc.this.errorMsg.getMsg(SPRc.this.spm_rc.ChangeUidRel());
                SPDebug.m5816d("bindRc result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void unBindRc(final String str, String str2, String str3, final MCallBack<CallBackMsg> mCallBack) {
        if (!this.isLogin) {
            noLogin(mCallBack);
            return;
        }
        SPDebug.m5816d("unBindRc uid:" + str + " sn: " + str2 + " access_token: " + str3);
        this.deviceHttp.unBindDevice(str2, str3, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.SPRc.5
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(CallBackMsg callBackMsg) {
                if (callBackMsg == null) {
                    mCallBack.onResult(SPRc.this.errorMsg.httpError());
                } else if (callBackMsg.getCode() != 0) {
                    mCallBack.onResult(callBackMsg);
                } else {
                    SPDebug.m5816d("unBindRc http result code:" + callBackMsg.getCode() + " erormsg: " + callBackMsg.getMessage());
                    SPRc.this.deleteUid(str, mCallBack);
                }
            }
        });
    }

    public void deleteUid(String str, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_rc.EraseUid(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.6
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPRc.this.errorMsg.getMsg(SPRc.this.spm_rc.GetEraseRel());
                SPDebug.m5816d("deleteUid result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void setAccessCode(String str, String str2, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("setAccessCode uid:" + str + " access_code: " + str2);
        byte[] decodeHex = Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray());
        this.spm_rc.ChangeAcCode(Hex16.decodeHex(Hex16.encodeHexStr(str2.getBytes()).toCharArray()), decodeHex);
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.7
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPRc.this.errorMsg.getMsg(SPRc.this.spm_rc.GetChangeAcCodeRel());
                SPDebug.m5816d("setAccessCode result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void verifyAccessCode(String str, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("setAccessCode access_code: " + str);
        this.spm_rc.RequestAcVerify(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.8
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                byte GetAcVerityRel = SPRc.this.spm_rc.GetAcVerityRel();
                if (GetAcVerityRel == 0) {
                    SPRc.this.isLogin = true;
                }
                CallBackMsg msg = SPRc.this.errorMsg.getMsg(GetAcVerityRel);
                SPDebug.m5816d("setAccessCode result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void delAuthAccessCode(String str, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("delAuthAccessCode uid:" + str);
        if (!this.isLogin) {
            noLogin(mCallBack);
            return;
        }
        this.spm_rc.EraseAcCode(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPRc.9
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPRc.this.errorMsg.getMsg(SPRc.this.spm_rc.GetEraseAcCodeRel());
                SPDebug.m5816d("delAuthAccessCode result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                MCallBack mCallBack2 = mCallBack;
                if (mCallBack2 != null) {
                    mCallBack2.onResult(msg);
                }
            }
        });
    }

    private void noLogin(MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("no login");
        mCallBack.onResult(this.errorMsg.noLoginMsg());
    }

    public void release() {
        this.isLogin = false;
        spRc = null;
    }
}
