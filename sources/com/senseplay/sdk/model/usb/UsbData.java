package com.senseplay.sdk.model.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.activity.UsbActivity;
import com.senseplay.sdk.cache.DeviceLink;
import com.senseplay.sdk.constant.SPWebConstant;
import com.senseplay.sdk.log.SPDebug;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class UsbData {
    private static final String ACTION_USB_HOST_PERMISSION = "com.android.sdk.ACTION_USB_HOST_PERMISSION";
    private static final String ACTION_USB_PERMISSION = "com.android.sdk.USB_PERMISSION";
    private static final String ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
    private MCallBack<Boolean> callBack;
    private UsbManager usbManager;
    private MCallBack<Boolean> usbReceiver;
    private String TAG = "UsbData";
    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() { // from class: com.senseplay.sdk.model.usb.UsbData.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String str = UsbData.this.TAG;
            Log.d(str, "action " + action);
            if (UsbData.ACTION_USB_PERMISSION.equals(action)) {
                synchronized (this) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (!intent.getBooleanExtra(SPWebConstant.Permission, false)) {
                        String str2 = UsbData.this.TAG;
                        Log.d(str2, "permission denied for device " + usbDevice);
                        UsbData.this.callback(false);
                    } else if (usbDevice != null) {
                        Log.d(UsbData.this.TAG, "permission ok");
                        UsbData.this.callback(true);
                    }
                }
            } else if (UsbData.ACTION_USB_HOST_PERMISSION.equals(action)) {
                synchronized (this) {
                    UsbAccessory usbAccessory = (UsbAccessory) intent.getParcelableExtra("accessory");
                    if (!intent.getBooleanExtra(SPWebConstant.Permission, false)) {
                        String str3 = UsbData.this.TAG;
                        Log.d(str3, "permission denied for device " + usbAccessory);
                        UsbData.this.callback(false);
                    } else if (usbAccessory != null) {
                        Log.d(UsbData.this.TAG, "permission ok");
                        UsbData.this.callback(true);
                    }
                }
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                synchronized (this) {
                    UsbData.this.usbRelease();
                }
            } else if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                synchronized (this) {
                    UsbData.this.usbSucc();
                }
            } else if (action.equals("android.hardware.usb.action.USB_STATE")) {
                if (UsbData.this.isFirst) {
                    UsbData.this.isFirst = false;
                } else if (intent.getBooleanExtra(UsbActivity.USB_CONNECTED, false)) {
                    if (UsbData.this.isTiming) {
                        return;
                    }
                    UsbData.this.startTimer();
                } else {
                    UsbData.this.closeTimer();
                    UsbData.this.usbRelease();
                }
            }
        }
    };
    private boolean isTiming = false;
    private boolean isFirst = true;
    private Handler handler = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.senseplay.sdk.model.usb.UsbData.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            UsbData.this.isTiming = true;
            UsbData.this.tryConnect();
            return false;
        }
    });

    public void registerReceiver(Context context, int i, MCallBack<Boolean> mCallBack) {
        this.usbReceiver = mCallBack;
        IntentFilter intentFilter = new IntentFilter();
        if (i == 0) {
            intentFilter.addAction(ACTION_USB_PERMISSION);
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        } else if (1 == i) {
            intentFilter.addAction(ACTION_USB_HOST_PERMISSION);
            intentFilter.addAction("android.hardware.usb.action.USB_STATE");
            this.usbManager = (UsbManager) context.getSystemService("usb");
        }
        context.registerReceiver(this.mUsbReceiver, intentFilter);
    }

    public void unregisterReceiver(Context context) {
        try {
            context.unregisterReceiver(this.mUsbReceiver);
        } catch (Exception unused) {
        }
    }

    public UsbDevice initUsbDevice(UsbManager usbManager) {
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        String str = this.TAG;
        Log.i(str, "usb设备：" + String.valueOf(deviceList.size()));
        ArrayList arrayList = new ArrayList();
        UsbDevice usbDevice = null;
        for (UsbDevice usbDevice2 : deviceList.values()) {
            arrayList.add(String.valueOf(usbDevice2.getVendorId()));
            arrayList.add(String.valueOf(usbDevice2.getProductId()));
            if (usbDevice2.getVendorId() == 0 || usbDevice2.getVendorId() == 1204 || usbDevice2.getVendorId() == 2385 || usbDevice2.getVendorId() == 1155 || usbDevice2.getVendorId() == 43690) {
                Log.i(this.TAG, "找到设备");
                usbDevice = usbDevice2;
            }
        }
        return usbDevice;
    }

    public UsbAccessory initUsbHost(UsbManager usbManager) {
        UsbAccessory[] accessoryList = usbManager.getAccessoryList();
        if (accessoryList != null && accessoryList.length != 0) {
            UsbAccessory usbAccessory = accessoryList[0];
            Log.i(this.TAG, "找到 Accessory");
            return usbAccessory;
        }
        Log.e(this.TAG, "Accessory No Found!!!");
        return null;
    }

    public boolean hasPermission(UsbManager usbManager, UsbDevice usbDevice) {
        if (usbDevice == null) {
            Log.i(this.TAG, "没有找到设备");
            return false;
        } else if (usbManager.hasPermission(usbDevice)) {
            Log.e(this.TAG, "有权限");
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPermission(UsbManager usbManager, UsbAccessory usbAccessory) {
        if (usbAccessory == null) {
            Log.i(this.TAG, "没有找到设备");
            return false;
        } else if (usbManager.hasPermission(usbAccessory)) {
            Log.e(this.TAG, "有权限");
            return true;
        } else {
            return false;
        }
    }

    public void requestPermission(UsbManager usbManager, UsbDevice usbDevice, MCallBack<Boolean> mCallBack, Context context) {
        this.callBack = mCallBack;
        usbManager.requestPermission(usbDevice, PendingIntent.getBroadcast(context, 0, new Intent(ACTION_USB_PERMISSION), 0));
        Log.e(this.TAG, "请求权限");
    }

    public void requestPermission(UsbManager usbManager, UsbAccessory usbAccessory, MCallBack<Boolean> mCallBack, Context context) {
        this.callBack = mCallBack;
        usbManager.requestPermission(usbAccessory, PendingIntent.getBroadcast(context, 0, new Intent(ACTION_USB_HOST_PERMISSION), 0));
        Log.e(this.TAG, "请求权限");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callback(boolean z) {
        MCallBack<Boolean> mCallBack = this.callBack;
        if (mCallBack != null) {
            mCallBack.onResult(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void usbSucc() {
        MCallBack<Boolean> mCallBack = this.usbReceiver;
        if (mCallBack != null) {
            mCallBack.onResult(true);
        } else {
            Log.e("SPUsb", "usbReceiver is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void usbRelease() {
        DeviceLink.clearRcLinkDev();
        MCallBack<Boolean> mCallBack = this.usbReceiver;
        if (mCallBack != null) {
            mCallBack.onResult(false);
        } else {
            Log.e("SPUsb", "usbReceiver is null");
        }
        SPUsb.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        this.isTiming = true;
        this.handler.sendEmptyMessage(0);
        SPDebug.m5807w(this.TAG, "startTimer");
    }

    public void closeTimer() {
        this.handler.removeMessages(0);
        this.isTiming = false;
        SPDebug.m5807w(this.TAG, "closeTimer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void tryConnect() {
        if (this.usbManager == null) {
            return;
        }
        UsbAccessory[] accessoryList = this.usbManager.getAccessoryList();
        if (accessoryList != null && accessoryList.length != 0) {
            closeTimer();
            usbSucc();
            SPDebug.m5807w(this.TAG, "Accessory Found!!!");
        } else {
            this.handler.sendEmptyMessageDelayed(0, 1000L);
            SPDebug.m5807w(this.TAG, "Accessory No Found!!!");
        }
    }
}
