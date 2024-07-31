package com.senseplay.sdk;

import com.adapt.SPM_Device;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.adapt.SPM_Vehicle;
import com.common.SP_GPS_INFO;
import com.common.SP_IMU_DATA;
import com.common.SP_REQUEST_REL;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.model.gps.GpsInfo;
import com.senseplay.sdk.model.gps.IMUData;
import com.senseplay.sdk.model.vehicle.KeyData;
import com.senseplay.sdk.model.vehicle.VehicleGear;
import com.senseplay.sdk.model.vehicle.VehicleInfo;
import com.senseplay.sdk.tool.HandleOpe;
import com.senseplay.sdk.tool.SPDataTool;
import com.senseplay.sdk.tool.SPUtilTool;

/* loaded from: classes2.dex */
public class SPVehicle {
    private static SPVehicle spVehicle;
    private VehicleInfo vehicleInfo = new VehicleInfo();
    private GpsInfo gpsInfo = new GpsInfo();
    private IMUData imuData = new IMUData();
    private KeyData keyData = new KeyData();
    private SPM_Vehicle spm_vehicle = SPM_Manager.GetInstance().GetDevice().GetVehicle();
    private SPM_Device spm_device = SPM_Manager.GetInstance().GetDevice();
    private SPM_Rc spm_rc = SPM_Manager.GetInstance().GetRc();

    public static SPVehicle getInstance() {
        if (spVehicle == null) {
            synchronized (SPVehicle.class) {
                if (spVehicle == null) {
                    spVehicle = new SPVehicle();
                }
            }
        }
        return spVehicle;
    }

    private SPVehicle() {
    }

    public VehicleInfo getVehicleInfo() {
        if (this.vehicleInfo == null) {
            this.vehicleInfo = new VehicleInfo();
        }
        this.vehicleInfo.setCurSpeed(this.spm_vehicle.GetCurSpeed());
        if (this.spm_vehicle.GetMajorGear() != null) {
            this.vehicleInfo.setMajorGear(this.spm_vehicle.GetMajorGear().toString());
        }
        this.vehicleInfo.setMinorGear(this.spm_vehicle.GetMinorGear());
        this.vehicleInfo.setSteerAngle(this.spm_vehicle.GetSteerAngle());
        this.vehicleInfo.setThrottle(this.spm_vehicle.GetThrottle());
        this.vehicleInfo.setBrake(this.spm_vehicle.GetBrake());
        this.vehicleInfo.setMotorRotateSpeed(this.spm_vehicle.GetMotorRotateSpeed());
        this.vehicleInfo.setWarning(this.spm_vehicle.GetWarning());
        return this.vehicleInfo;
    }

    public GpsInfo getGpsInfo() {
        if (this.gpsInfo == null) {
            this.gpsInfo = new GpsInfo();
        }
        SP_GPS_INFO GetGpsInfo = this.spm_device.GetGpsInfo();
        this.gpsInfo.setDiscoveredSatelliteCnt(GetGpsInfo.DiscoveredSatelliteCnt);
        this.gpsInfo.setDeterminationSatelliteCnt(GetGpsInfo.DeterminationSatelliteCnt);
        this.gpsInfo.setLatitude(GetGpsInfo.Latitude);
        this.gpsInfo.setLongitude(GetGpsInfo.Longitude);
        this.gpsInfo.setSpeed(GetGpsInfo.Speed);
        this.gpsInfo.setAltitude(GetGpsInfo.Altitude);
        return this.gpsInfo;
    }

    public IMUData getImuInfo() {
        if (this.imuData == null) {
            this.imuData = new IMUData();
        }
        SP_IMU_DATA GetIMUState = this.spm_device.GetIMUState();
        this.imuData.setQuaternionQ0(GetIMUState.QuaternionQ0);
        this.imuData.setQuaternionQ1(GetIMUState.QuaternionQ1);
        this.imuData.setQuaternionQ2(GetIMUState.QuaternionQ2);
        this.imuData.setQuaternionQ3(GetIMUState.QuaternionQ3);
        this.imuData.setEulerianAngles_P(GetIMUState.EulerianAngles_P);
        this.imuData.setEulerianAngles_Y(GetIMUState.EulerianAngles_Y);
        this.imuData.setEulerianAngles_R(GetIMUState.EulerianAngles_R);
        return this.imuData;
    }

    public KeyData getKeyData() {
        if (this.keyData == null) {
            this.keyData = new KeyData();
        }
        if (this.spm_rc.GetFireRel() == 0) {
            this.keyData.setFire(1);
        }
        if (this.spm_rc.GetSwitchWeaponRel() == 0) {
            this.keyData.setSwitch_weapon(1);
        }
        return this.keyData;
    }

    public void steer(int i) {
        if (i < -127) {
            i = -127;
        } else if (i > 127) {
            i = 127;
        }
        this.spm_vehicle.Steer(SPDataTool.intToByte(i));
    }

    public void steer(int i, int i2) {
        if (i2 < -32767) {
            i2 = -32767;
        } else if (i2 > 32767) {
            i2 = 32767;
        }
        this.spm_vehicle.Steer((byte) i, (short) i2);
    }

    public void steer(int i, int i2, int i3) {
        if (i2 < -32767) {
            i2 = -32767;
        } else if (i2 > 32767) {
            i2 = 32767;
        }
        this.spm_vehicle.Steer((byte) i, (short) i2, (byte) i3);
    }

    public void drive(int i) {
        if (i < -128) {
            i = -128;
        } else if (i > 127) {
            i = 127;
        }
        this.spm_vehicle.Drive(SPDataTool.intToByte(i));
    }

    public void setGear(String str) {
        this.spm_vehicle.SetGear((byte) VehicleGear.getGearIndex(str));
    }

    public void setLight(int i, int i2) {
        this.spm_vehicle.SetAutomativeLighting((byte) i, (byte) i2);
    }

    public void getPwmDutyCycle(final MCallBack<Integer> mCallBack) {
        this.spm_vehicle.requestPwmDutyCycle();
        HandleOpe.postReadDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPVehicle.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                SP_REQUEST_REL sp_request_rel = new SP_REQUEST_REL();
                SPVehicle.this.spm_vehicle.getRequestPwmDutyCycleRel(sp_request_rel);
                mCallBack.onResult(Integer.valueOf((sp_request_rel.ERR_CODE != 0 || sp_request_rel.Result == null) ? 0 : SPUtilTool.toInteger(sp_request_rel.Result)));
            }
        });
    }

    public void release() {
        spVehicle = null;
    }
}
