package com.navatics.robot.transport;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.senseplay.sdk.constant.SPWebConstant;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.w */
/* loaded from: classes.dex */
public class NvUsbManager {

    /* renamed from: a */
    private static final C3044k f6696a = C3044k.m1564a(NvUsbManager.class);

    /* renamed from: b */
    private static NvUsbManager f6697b;

    /* renamed from: c */
    private UsbDevice f6698c;

    /* renamed from: f */
    private InterfaceC2144a f6701f;

    /* renamed from: e */
    private List<InterfaceC2145b> f6700e = new ArrayList();

    /* renamed from: g */
    private BroadcastReceiver f6702g = new BroadcastReceiver() { // from class: com.navatics.robot.transport.w.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("usb_permission_acquired".equals(action)) {
                synchronized (this) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (intent.getBooleanExtra(SPWebConstant.Permission, false)) {
                        NvUsbManager.f6696a.mo1511a((Object) "permission granted.");
                        if (usbDevice != null && NvUsbManager.this.f6701f != null && NvUsbManager.this.f6701f.m5989a(usbDevice)) {
                            NvUsbManager.this.f6698c = usbDevice;
                            NvUsbManager.this.m5995c();
                        }
                    } else {
                        C3044k c3044k = NvUsbManager.f6696a;
                        c3044k.mo1511a((Object) ("permission denied for device " + usbDevice));
                        NvUsbManager.this.m5993d();
                    }
                }
            } else if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                NvUsbManager.f6696a.mo1511a((Object) "usb device attach.");
                UsbDevice usbDevice2 = (UsbDevice) intent.getParcelableExtra("device");
                if (NvUsbManager.this.f6701f != null && NvUsbManager.this.f6701f.m5988b(usbDevice2) && NvUsbManager.this.m6001a(usbDevice2) && NvUsbManager.this.f6701f.m5989a(usbDevice2)) {
                    NvUsbManager.this.f6698c = usbDevice2;
                    NvUsbManager.this.m5995c();
                }
            } else if ("android.hardware.usb.action.USB_ACCESSORY_DETACHED".equals(action)) {
                NvUsbManager.f6696a.mo1511a((Object) "usb device detached.");
                NvUsbManager.this.f6698c = null;
                NvUsbManager.this.m5991e();
                if (NvUsbManager.this.f6701f != null) {
                    NvUsbManager.this.f6701f.m5990a();
                }
            }
        }
    };

    /* renamed from: d */
    private PendingIntent f6699d = PendingIntent.getBroadcast(NvTransport.m6018a(), 1, new Intent("usb_permission_acquired"), 0);

    /* compiled from: NvUsbManager.java */
    /* renamed from: com.navatics.robot.transport.w$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2144a {
        /* renamed from: a */
        void m5990a();

        /* renamed from: a */
        boolean m5989a(UsbDevice usbDevice);

        /* renamed from: b */
        boolean m5988b(UsbDevice usbDevice);
    }

    /* compiled from: NvUsbManager.java */
    /* renamed from: com.navatics.robot.transport.w$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2145b {
        /* renamed from: a */
        void m5987a();

        /* renamed from: b */
        void m5986b();

        /* renamed from: c */
        void m5985c();
    }

    /* renamed from: a */
    public static void m6002a() {
        NvUsbManager nvUsbManager;
        BroadcastReceiver broadcastReceiver;
        Context m6018a = NvTransport.m6018a();
        if (m6018a == null || (nvUsbManager = f6697b) == null || (broadcastReceiver = nvUsbManager.f6702g) == null) {
            return;
        }
        m6018a.unregisterReceiver(broadcastReceiver);
    }

    private NvUsbManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6001a(UsbDevice usbDevice) {
        UsbManager usbManager = (UsbManager) NvTransport.m6018a().getSystemService("usb");
        if (usbManager == null) {
            throw new RuntimeException("wtf usbmanager is null?!");
        }
        if (usbManager.hasPermission(usbDevice)) {
            f6696a.mo1511a((Object) "already has permission.");
            return true;
        }
        f6696a.mo1511a((Object) "requesting permission...");
        usbManager.requestPermission(usbDevice, this.f6699d);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5995c() {
        for (InterfaceC2145b interfaceC2145b : this.f6700e) {
            interfaceC2145b.m5987a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5993d() {
        for (InterfaceC2145b interfaceC2145b : this.f6700e) {
            interfaceC2145b.m5986b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5991e() {
        for (InterfaceC2145b interfaceC2145b : this.f6700e) {
            interfaceC2145b.m5985c();
        }
    }
}
