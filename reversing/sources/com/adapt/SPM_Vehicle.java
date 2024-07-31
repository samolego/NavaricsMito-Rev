package com.adapt;

import android.util.Log;
import com.common.SP_REQUEST_REL;
import com.common.SP_Util;
import com.common.SP_VEHICLE_GEAR;
import com.common.VEHICLE_CONFIG_INFO;
import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SPM_Vehicle {
    private byte[] mReadConfigBuff = new byte[512];
    private byte[] mRequestEscVerBuff = new byte[128];
    private byte[] mRequestPwmDutyBuff = new byte[4];

    public int Steer(byte b) {
        return CppSDKConnectors.Steer(b);
    }

    public int Steer(byte b, short s) {
        return CppSDKConnectors.Steer2(b, s);
    }

    public int Steer(byte b, short s, byte b2) {
        return CppSDKConnectors.Steer3(b, s, b2);
    }

    public int Drive(byte b) {
        return CppSDKConnectors.Drive(b);
    }

    public int SetGear(byte b) {
        return CppSDKConnectors.SetGear(b);
    }

    public int ChangeGear(byte b) {
        return CppSDKConnectors.ChangeGear(b);
    }

    public int GetCurSpeed() {
        return CppSDKConnectors.GetCurSpeed();
    }

    public boolean GetSetSpeedRel() {
        return CppSDKConnectors.GetSetSpeedRel();
    }

    public int SetSpeed(float f) {
        return CppSDKConnectors.SetSpeed(f);
    }

    public boolean GetSetSteerRel() {
        return CppSDKConnectors.GetSetSteerRel();
    }

    public boolean GetDriveRel() {
        return CppSDKConnectors.GetDriveRel();
    }

    public boolean GetGearRel() {
        return CppSDKConnectors.GetGearRel();
    }

    public boolean GetChangeGearRel() {
        return CppSDKConnectors.GetChangeGearRel();
    }

    public SP_VEHICLE_GEAR GetMajorGear() {
        return SP_VEHICLE_GEAR.UNKNOWN.fill(CppSDKConnectors.GetMajorGear());
    }

    public int GetMinorGear() {
        return CppSDKConnectors.GetMinorGear();
    }

    public int GetThrottle() {
        return CppSDKConnectors.GetThrottle();
    }

    public int GetBrake() {
        return CppSDKConnectors.GetBrake();
    }

    public int GetMotorRotateSpeed() {
        return CppSDKConnectors.GetMotorRotateSpeed();
    }

    public short GetWarning() {
        return CppSDKConnectors.GetWarning();
    }

    public float GetSteerAngle() {
        return CppSDKConnectors.GetSteerAngle();
    }

    public int loadIniConfigFile(String str) {
        return CppSDKConnectors.loadInifile(str);
    }

    public int sendNextSingleConfigCmd() {
        return CppSDKConnectors.sendNextSingleConfigCmd();
    }

    public int sendCurtSingleConfigCmd() {
        return CppSDKConnectors.sendCurtSingleConfigCmd();
    }

    public int getConfigCmdWriteRel() {
        return CppSDKConnectors.getConfigCmdRel();
    }

    public int getCurConfigData(byte[] bArr) {
        return CppSDKConnectors.getCurConfigData(bArr);
    }

    public int saveCfgs() {
        return CppSDKConnectors.vehicleSaveCfgs();
    }

    public int readConfigInfo(byte b) {
        return CppSDKConnectors.readConfigInfo(b);
    }

    public void getReadConfigData(VEHICLE_CONFIG_INFO vehicle_config_info, SP_REQUEST_REL sp_request_rel) {
        if (vehicle_config_info == null || sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getReadConfigData(this.mReadConfigBuff, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        if (sp_request_rel.ERR_CODE == 0) {
            byte[] bArr = new byte[sp_request_rel.REL_LEN];
            for (int i = 0; i < sp_request_rel.REL_LEN; i++) {
                bArr[i] = this.mReadConfigBuff[i];
            }
            String[] split = new String(bArr).split(",");
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2[0].matches("ver")) {
                    vehicle_config_info.ver = split2[1];
                } else if (split2[0].matches("time")) {
                    vehicle_config_info.time = split2[1];
                } else if (split2[0].matches("sn")) {
                    vehicle_config_info.f1316sn = split2[1];
                } else if (split2[0].matches("crc32")) {
                    vehicle_config_info.crc = split2[1];
                }
            }
        }
    }

    public void requestEscVer() {
        CppSDKConnectors.requestEscVer();
    }

    public void requestEscLink() {
        CppSDKConnectors.requestEscLink();
    }

    public void requestEscErasure() {
        CppSDKConnectors.requestEscErasure();
    }

    public void requestEscDisconnect() {
        CppSDKConnectors.requestEscDisconnect();
    }

    public int sendEscNextSingleOtaData() {
        return CppSDKConnectors.sendEscNextSingleOtaData();
    }

    public int sendEscSurSingleOtaData() {
        return CppSDKConnectors.sendEscSurSingleOtaData();
    }

    public void getRequestEscVerRel(char[] cArr, SP_REQUEST_REL sp_request_rel) {
        if (cArr == null || sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.gerRequestEscVerRel(this.mRequestEscVerBuff, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        if (sp_request_rel.ERR_CODE == 0) {
            int min = Math.min(cArr.length, (int) sp_request_rel.REL_LEN);
            for (int i = 0; i < min; i++) {
                cArr[i] = (char) (this.mRequestEscVerBuff[i] & 255);
            }
        }
    }

    public void getRequestEscLinkRel(SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getRequestEscLinkRel(sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public void getRequestEscErasureRel(SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getRequestEscErasureRel(sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public void getRrequestEscDisconnectRel(SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getRrequestEscDisconnectRel(sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public int loadEscOtaFile(String str) {
        return CppSDKConnectors.loadEscOtaFile(str);
    }

    public void getEscOtaDataRel(SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getEscOtaDataRel(sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public int startMotorParamLearn() {
        return CppSDKConnectors.startMotorParamLearn();
    }

    public void getMotorParamLearnRel(SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getMotorParamLearnRel(sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public void SetAutomativeLighting(byte b, byte b2) {
        CppSDKConnectors.SetAutomativeLighting(b, b2);
        Log.v("LIGHT_", "fun: " + SP_Util.byte2str(b) + " des: " + SP_Util.byte2str(b2));
    }

    public int requestPwmDutyCycle() {
        return CppSDKConnectors.requestPwmDutyCycle();
    }

    public void getRequestPwmDutyCycleRel(SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.getRequestPwmDutyCycleRel(this.mRequestPwmDutyBuff, sp_request_rel.getBuff());
        int byteArrayToInt = SP_Util.byteArrayToInt(this.mRequestPwmDutyBuff, 0);
        sp_request_rel.fill(sp_request_rel.getBuff());
        sp_request_rel.Result = Integer.valueOf(byteArrayToInt);
    }
}
