package com.hwfit.otg;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class USBHal {
    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
    private static USBHal mInstance;
    private Context mContext;
    private UsbManager mManager;

    /* renamed from: DG */
    private boolean f3445DG = true;
    private String TAG = "HW_Adaptor:[USBHal]";
    private UsbDevice mUsbDevice = null;
    private int mInterfaceCount = 0;
    private UsbDeviceConnection connection = null;
    private UsbInterface[] mInterfaceArray = new UsbInterface[5];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum InterfaceID {
        ArtosynComm,
        ArtosynVideo0,
        ArtosynVideo1,
        ArtosynCustomer
    }

    public static USBHal GetInstance() {
        if (mInstance == null) {
            mInstance = new USBHal();
        }
        return mInstance;
    }

    private USBHal() {
    }

    public void Init(Context context) {
        this.mContext = context;
        UsbDevicesInit();
    }

    private void UsbDevicesInit() {
        this.mManager = (UsbManager) this.mContext.getSystemService("usb");
        if (this.mManager == null) {
            return;
        }
        if (this.f3445DG) {
            String str = this.TAG;
            Log.v(str, "UsbManager：" + String.valueOf(this.mManager.toString()));
        }
        HashMap<String, UsbDevice> deviceList = this.mManager.getDeviceList();
        if (this.f3445DG) {
            String str2 = this.TAG;
            Log.i(str2, "usb设备：" + String.valueOf(deviceList.size()) + "\r\n");
        }
        ArrayList arrayList = new ArrayList();
        for (UsbDevice usbDevice : deviceList.values()) {
            arrayList.add(String.valueOf(usbDevice.getVendorId()));
            arrayList.add(String.valueOf(usbDevice.getProductId()));
            if (usbDevice.getVendorId() == 0 || usbDevice.getVendorId() == 1204 || usbDevice.getVendorId() == 2385 || usbDevice.getVendorId() == 1155 || usbDevice.getVendorId() == 43690) {
                this.mUsbDevice = usbDevice;
                if (this.f3445DG) {
                    Log.i(this.TAG, String.format("find device!,usb VID:0x%X,PID:0x%X \r\n", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId())));
                }
            } else if (this.f3445DG) {
                Log.i(this.TAG, String.format("not find device,usb VID:0x%X,PID:0x%X\r\n", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId())));
            }
        }
        findEndpotints();
    }

    private InterfaceID getInterfaceID(UsbInterface usbInterface) {
        return InterfaceID.values()[usbInterface.getId()];
    }

    private void findEndpotints() {
        UsbDevice usbDevice = this.mUsbDevice;
        if (usbDevice == null) {
            if (this.f3445DG) {
                Log.i(this.TAG, "[findEndpotints] not find usb dev\n");
                return;
            }
            return;
        }
        this.mInterfaceCount = usbDevice.getInterfaceCount();
        if (this.mInterfaceCount < 1) {
            String str = this.TAG;
            Log.e(str, "USB Interface Count is: [" + this.mInterfaceCount + "] - Open failed !!");
            return;
        }
        for (int i = 0; i < this.mInterfaceCount; i++) {
            if (this.mInterfaceArray == null) {
                this.mInterfaceArray = new UsbInterface[5];
            }
            this.mInterfaceArray[i] = this.mUsbDevice.getInterface(i);
        }
        if (this.mInterfaceArray[0] != null) {
            this.mManager.requestPermission(this.mUsbDevice, PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_USB_PERMISSION), 0));
            if (!this.mManager.hasPermission(this.mUsbDevice)) {
                Log.e(this.TAG, "usb permission err!\n");
                return;
            }
            this.connection = this.mManager.openDevice(this.mUsbDevice);
            if (this.connection == null) {
                return;
            }
            for (int i2 = 0; i2 < this.mInterfaceCount; i2++) {
                if (this.connection.claimInterface(this.mInterfaceArray[i2], true)) {
                    switch (getInterfaceID(this.mInterfaceArray[i2])) {
                        case ArtosynComm:
                            USBCmdHal.getInstance().init(this.connection, this.mInterfaceArray[i2]);
                            continue;
                        case ArtosynVideo0:
                            USBVideo0Hal.getInstance().init(this.connection, this.mInterfaceArray[i2]);
                            continue;
                        case ArtosynVideo1:
                            USBVideo1Hal.getInstance().init(this.connection, this.mInterfaceArray[i2]);
                            continue;
                        case ArtosynCustomer:
                            USBCustomerHal.getInstance().init(this.connection, this.mInterfaceArray[i2]);
                            continue;
                    }
                }
            }
        } else if (this.f3445DG) {
            Log.i(this.TAG, "not find interface!\r\n");
        }
    }

    public boolean USB_Ready() {
        return USBCustomerHal.getInstance().isOpen() && USBCustomerHal.getInstance().isOpen() && USBCustomerHal.getInstance().isOpen() && USBCustomerHal.getInstance().isOpen();
    }

    public void close() {
        this.mUsbDevice = null;
        this.mInterfaceArray = null;
        UsbDeviceConnection usbDeviceConnection = this.connection;
        if (usbDeviceConnection != null) {
            usbDeviceConnection.close();
            this.connection = null;
        }
        if (this.mManager != null) {
            this.mManager = null;
        }
    }

    public UsbDeviceConnection getConnection() {
        return this.connection;
    }
}
