package com.senseplay.sdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.SPDevice;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.SPRc;
import com.senseplay.sdk.SPSearch;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.SPVehicle;
import com.senseplay.sdk.cache.DeviceSearchListener;
import com.senseplay.sdk.model.device.DeviceInfo;
import com.senseplay.sdk.video.VideoPlay;

/* loaded from: classes2.dex */
public class HostActivity extends Activity {
    SurfaceView mVideo0Surface;
    SPUsb spUsb;
    SPVehicle spVehicle;
    TextView txt_dev;
    TextView txt_info;
    TextView txt_sn;
    VideoPlay videoPlay;

    /* renamed from: id */
    String f6826id = "";

    /* renamed from: sn */
    String f6827sn = "";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2189R.layout.host_activity);
        SPManager.getInstance().init(this);
        initView();
        initUsb();
        SPSearch.getInstance().directLinkState(new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.HostActivity.1
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
                Log.w("HostActivity", "linkStateChg: " + bool);
            }
        });
    }

    private void initView() {
        this.mVideo0Surface = (SurfaceView) findViewById(C2189R.C2191id.video0_surface);
        this.txt_sn = (TextView) findViewById(C2189R.C2191id.txt_sn);
        this.txt_dev = (TextView) findViewById(C2189R.C2191id.txt_dev);
        this.txt_info = (TextView) findViewById(C2189R.C2191id.txt_info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initUsb() {
        if (this.spUsb == null) {
            this.spUsb = SPUsb.getInstance();
            this.spUsb.setUsbType(0);
            this.spUsb.registerUsbReceiver(this, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.HostActivity.2
                @Override // com.senseplay.mframe.client.MCallBack
                public void onResult(Boolean bool) {
                    Log.w("HostActivity", "ffffff: " + bool);
                    if (bool.booleanValue()) {
                        HostActivity.this.initUsb();
                    }
                    HostActivity hostActivity = HostActivity.this;
                    Toast.makeText(hostActivity, "usb: " + bool, 0).show();
                }
            });
        }
        this.spUsb.openUsb(new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.HostActivity.3
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
                if (bool.booleanValue()) {
                    HostActivity.this.initVideoPlay();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideoPlay() {
        if (this.spUsb.checkUsb() && this.videoPlay == null) {
            this.videoPlay = new VideoPlay();
            this.videoPlay.play(this.mVideo0Surface.getHolder().getSurface());
        }
    }

    public void toSearch(View view) {
        SPSearch.getInstance().deviceSearch(new DeviceSearchListener() { // from class: com.senseplay.sdk.activity.HostActivity.4
            @Override // com.senseplay.sdk.cache.DeviceSearchListener
            public void search(DeviceInfo deviceInfo) {
                Log.w("HostActivity", "sn: " + deviceInfo.getSerialNo() + "  id: " + deviceInfo.getLinkID());
                HostActivity.this.f6827sn = deviceInfo.getSerialNo();
                HostActivity.this.f6826id = deviceInfo.getLinkID();
                HostActivity.this.txt_sn.setText(HostActivity.this.f6827sn);
            }

            @Override // com.senseplay.sdk.cache.DeviceSearchListener
            public void finish() {
                Log.w("HostActivity", "finish");
            }
        });
    }

    public void toLink(View view) {
        SPSearch.getInstance().deviceLink(this.f6826id, this.f6827sn, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.HostActivity.5
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
                Log.w("HostActivity", "aBoolean: " + bool);
            }
        });
    }

    public void toGetRc(View view) {
        this.txt_info.setText("");
        SPRc.getInstance().getRcInfo(new MCallBack<DeviceInfo>() { // from class: com.senseplay.sdk.activity.HostActivity.6
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(DeviceInfo deviceInfo) {
                if (deviceInfo != null) {
                    TextView textView = HostActivity.this.txt_info;
                    textView.setText("\nrcSN: " + deviceInfo.getSerialNo() + "\nVersion: " + deviceInfo.getVersion() + "\nCategory: " + deviceInfo.getCategory() + "\nManufactureDate: " + deviceInfo.getManufactureDate() + "\nManufacturerID: " + deviceInfo.getManufacturerID() + "\nModelID: " + deviceInfo.getModelID() + "\nFirmwareVersion: " + deviceInfo.getFirmwareVersion() + "\nHardwareVersion: " + deviceInfo.getHardwareVersion() + "\nFirmwareVersionStr: " + deviceInfo.getFirmwareVersionStr() + "\nHardwareVersionStr: " + deviceInfo.getHardwareVersionStr());
                    return;
                }
                HostActivity.this.txt_info.setText("读取失败");
            }
        });
    }

    public void toGetDev(View view) {
        this.txt_info.setText("");
        SPDevice.getInstance().getDevInfo(new MCallBack<DeviceInfo>() { // from class: com.senseplay.sdk.activity.HostActivity.7
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(DeviceInfo deviceInfo) {
                if (deviceInfo != null) {
                    TextView textView = HostActivity.this.txt_info;
                    textView.setText("\ndevSN: " + deviceInfo.getSerialNo() + "\nVersion: " + deviceInfo.getVersion() + "\nCategory: " + deviceInfo.getCategory() + "\nManufactureDate: " + deviceInfo.getManufactureDate() + "\nManufacturerID: " + deviceInfo.getManufacturerID() + "\nModelID: " + deviceInfo.getModelID() + "\nFirmwareVersion: " + deviceInfo.getFirmwareVersion() + "\nHardwareVersion: " + deviceInfo.getHardwareVersion() + "\nFirmwareVersionStr: " + deviceInfo.getFirmwareVersionStr() + "\nHardwareVersionStr: " + deviceInfo.getHardwareVersionStr());
                    return;
                }
                HostActivity.this.txt_info.setText("读取失败");
            }
        });
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeUsb();
        finish();
    }

    private void closeUsb() {
        VideoPlay videoPlay = this.videoPlay;
        if (videoPlay != null) {
            videoPlay.stop();
            this.videoPlay = null;
        }
        SPUsb sPUsb = this.spUsb;
        if (sPUsb != null) {
            sPUsb.unregisterUsbReceiver(this);
            this.spUsb.release();
        }
        SPManager.exit();
    }
}
