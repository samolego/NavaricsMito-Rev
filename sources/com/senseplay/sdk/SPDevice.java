package com.senseplay.sdk;

import com.adapt.SPM_Device;
import com.adapt.SPM_Manager;
import com.common.DEV_STATUS;
import com.common.SPCD_INFO;
import com.common.SP_BATTERY_INFO;
import com.common.SP_BATTERY_STATUS;
import com.common.SP_REQUEST_REL;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.cache.DeviceLink;
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
import com.senseplay.sdk.tool.SPUtilTool;

/* loaded from: classes2.dex */
public class SPDevice {
    public static String curSn;
    private static SPDevice spDevice;
    private final String tag = SPDevice.class.getSimpleName();
    private boolean isLogin = true;
    BatteryInfo info = new BatteryInfo();
    private SPM_Device spm_device = SPM_Manager.GetInstance().GetDevice();
    private DeviceHttp deviceHttp = new DeviceHttp(SPManager.getContent());
    private ErrorMsg errorMsg = ErrorMsg.getInstance();

    public static SPDevice getInstance() {
        if (spDevice == null) {
            synchronized (SPDevice.class) {
                if (spDevice == null) {
                    spDevice = new SPDevice();
                }
            }
        }
        return spDevice;
    }

    private SPDevice() {
    }

    public void getDevInfo(final MCallBack<DeviceInfo> mCallBack) {
        this.spm_device.RequestInfo();
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                SPCD_INFO spcd_info = new SPCD_INFO();
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPDevice.this.spm_device.GetInfoRel(spcd_info, sp_request_rel);
                mCallBack.onResult(DeviceData.toDeviceInfo(spcd_info, sp_request_rel));
            }
        }, 700);
    }

    public void getStatusInfo(final MCallBack<DEV_STATUS> mCallBack) {
        this.spm_device.RequestStatusInfo();
        HandleOpe.postReadDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.2
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                DEV_STATUS dev_status = new DEV_STATUS();
                SPDevice.this.spm_device.GetStatusInfoRel(dev_status, new SP_REQUEST_REL());
                mCallBack.onResult(dev_status);
            }
        });
    }

    public BatteryInfo getBatteryInfo() {
        SP_BATTERY_INFO GetBatteryInfo = this.spm_device.GetBatteryInfo();
        if (GetBatteryInfo != null) {
            this.info.setCapacity(GetBatteryInfo.Capacity);
            this.info.setNumCells(GetBatteryInfo.NumCells);
        }
        return this.info;
    }

    public BatteryStatus getBatteryStatus() {
        BatteryStatus batteryStatus = new BatteryStatus();
        SP_BATTERY_STATUS GetBatteryStatus = this.spm_device.GetBatteryStatus();
        if (GetBatteryStatus != null) {
            if (GetBatteryStatus.State != null) {
                batteryStatus.setState(GetBatteryStatus.State.value());
                batteryStatus.setStateDesc(GetBatteryStatus.State.toString());
            }
            batteryStatus.setEnergyLevel(GetBatteryStatus.EnergyLevel);
        }
        return batteryStatus;
    }

    public void verifyUid(String str, final MCallBack<DeviceUser> mCallBack) {
        SPDebug.m5816d("verifyUid device uid:" + str);
        this.spm_device.RequestUidVerify(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.3
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                DeviceUser deviceUser = new DeviceUser();
                int GetUidVerifyRel = SPDevice.this.spm_device.GetUidVerifyRel();
                if (GetUidVerifyRel != 0 && GetUidVerifyRel != 12) {
                    deviceUser.setCode(GetUidVerifyRel);
                    deviceUser.setErrorMsg(SPDevice.this.errorMsg.getMsgStr(GetUidVerifyRel));
                    if (GetUidVerifyRel != 5 && GetUidVerifyRel != -1) {
                        deviceUser.setBind(true);
                    }
                } else {
                    deviceUser.setCode(0);
                    SPDevice.this.isLogin = true;
                    deviceUser.setBind(true);
                    deviceUser.setOwner(true);
                }
                SPDebug.m5816d("verifyUid device result code :" + deviceUser.getCode() + " isBind:" + deviceUser.isBind() + " isOwner:" + deviceUser.isOwner());
                mCallBack.onResult(deviceUser);
            }
        });
    }

    public void bindDevice(final String str, final String str2, String str3, String str4, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("bindDevice uid:" + str + " sn:" + str2 + " access_token:" + str3 + " verify_code:" + str4);
        if (DeviceLink.isNotRcLinkDev()) {
            noLink(mCallBack);
        } else {
            this.deviceHttp.bindDevice(str2, str3, str4, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.SPDevice.4
                @Override // com.senseplay.mframe.client.MCallBack
                public void onResult(CallBackMsg callBackMsg) {
                    if (callBackMsg == null) {
                        mCallBack.onResult(SPDevice.this.errorMsg.noHttp());
                    } else if (callBackMsg.getCode() == 0) {
                        SPDevice.this.setUid(str, str2, mCallBack);
                    } else {
                        mCallBack.onResult(callBackMsg);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(String str, String str2, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_device.ChangeUid(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()), Hex16.decodeHex(Hex16.encodeHexStr(str2.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.5
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPDevice.this.errorMsg.getMsg(SPDevice.this.spm_device.GetUidChangeRel());
                SPDebug.m5816d("bindDevice result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void unBindDevice(final String str, String str2, String str3, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("unBindDevice uid:" + str + " sn: " + str2 + " access_token: " + str3);
        if (!this.isLogin) {
            noLogin(mCallBack);
        } else if (DeviceLink.isNotRcLinkDev()) {
            noLink(mCallBack);
        } else {
            this.deviceHttp.unBindDevice(str2, str3, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.SPDevice.6
                @Override // com.senseplay.mframe.client.MCallBack
                public void onResult(CallBackMsg callBackMsg) {
                    if (callBackMsg == null) {
                        mCallBack.onResult(SPDevice.this.errorMsg.httpError());
                    } else if (callBackMsg.getCode() != 0) {
                        mCallBack.onResult(callBackMsg);
                    } else {
                        SPDebug.m5816d("unBindDevice http result code:" + callBackMsg.getCode() + " erormsg: " + callBackMsg.getMessage());
                        SPDevice.this.deleteUid(str, mCallBack);
                    }
                }
            });
        }
    }

    public void deleteUid(String str, final MCallBack<CallBackMsg> mCallBack) {
        this.spm_device.EraseUid(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.7
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPDevice.this.errorMsg.getMsg(SPDevice.this.spm_device.GetEraseUidRel());
                SPDebug.m5816d("deleteUid result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void setAccessCode(String str, String str2, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("setAccessCode uid:" + str + " access_code: " + str2);
        byte[] decodeHex = Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray());
        this.spm_device.ChangeAcCode(Hex16.decodeHex(Hex16.encodeHexStr(str2.getBytes()).toCharArray()), decodeHex);
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.8
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                CallBackMsg msg = SPDevice.this.errorMsg.getMsg(SPDevice.this.spm_device.GetChangeAcCodeRel());
                SPDebug.m5816d("setAccessCode result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void verifyAccessCode(String str, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("verifyAccessCode access_code: " + str);
        this.spm_device.RequestAcVerify(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
        HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.9
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                int GetAcVerifyRel = SPDevice.this.spm_device.GetAcVerifyRel();
                if (GetAcVerifyRel == 0) {
                    SPDevice.this.isLogin = true;
                }
                CallBackMsg msg = SPDevice.this.errorMsg.getMsg(GetAcVerifyRel);
                SPDebug.m5816d("setAccessCode result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                mCallBack.onResult(msg);
            }
        });
    }

    public void delAuthAccessCode(String str, String str2, final MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("delAuthAccessCode uid:" + str);
        if (!this.isLogin) {
            noLogin(mCallBack);
        } else if (SPUtilTool.isNull(curSn) || !curSn.equals(str2)) {
            mCallBack.onResult(this.errorMsg.noLink());
        } else {
            this.spm_device.EraseAcCode(Hex16.decodeHex(Hex16.encodeHexStr(str.getBytes()).toCharArray()));
            HandleOpe.postWriteDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPDevice.10
                @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
                public void run() {
                    CallBackMsg msg = SPDevice.this.errorMsg.getMsg(SPDevice.this.spm_device.GetEraseAcCodeRel());
                    SPDebug.m5816d("setAccessCode result code:" + msg.getCode() + " erormsg: " + msg.getMessage());
                    MCallBack mCallBack2 = mCallBack;
                    if (mCallBack2 != null) {
                        mCallBack2.onResult(msg);
                    }
                }
            });
        }
    }

    public boolean disConnect() {
        return this.spm_device.RfDisconnect() == 0;
    }

    private void noLogin(MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("no login");
        mCallBack.onResult(this.errorMsg.noLoginMsg());
    }

    private void noLink(MCallBack<CallBackMsg> mCallBack) {
        SPDebug.m5816d("no link device");
        mCallBack.onResult(this.errorMsg.noLink());
    }

    public void release() {
        curSn = "";
        this.isLogin = false;
        this.spm_device = null;
    }
}
