package com.senseplay.sdk.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPUsb;

/* loaded from: classes2.dex */
public class UsbActivity extends Activity {
    public static final String ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static final String USB_CONNECTED = "connected";
    private IntentFilter intentFilter;
    SPUsb spUsb;
    private TextView textView;
    private UsbManager usbManager;
    BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.senseplay.sdk.activity.UsbActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            UsbActivity usbActivity = UsbActivity.this;
            usbActivity.addText("action : " + action);
            if (((action.hashCode() == -494529457 && action.equals(UsbActivity.ACTION_USB_STATE)) ? (char) 0 : (char) 65535) != 0) {
                return;
            }
            if (UsbActivity.this.isFirst) {
                UsbActivity.this.isFirst = false;
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra(UsbActivity.USB_CONNECTED, false);
            UsbActivity usbActivity2 = UsbActivity.this;
            usbActivity2.addText("USB_CONNECTED :" + booleanExtra);
            if (booleanExtra) {
                if (UsbActivity.this.isTiming) {
                    return;
                }
                UsbActivity.this.startTimer();
                return;
            }
            UsbActivity.this.closeTimer();
            if (UsbActivity.this.spUsb != null) {
                UsbActivity.this.spUsb.release();
                UsbActivity.this.addText("release");
            }
        }
    };
    private boolean isFirst = true;
    private boolean isTiming = false;
    private int timeNum = 0;
    private Handler handler = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.senseplay.sdk.activity.UsbActivity.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            UsbActivity.this.isTiming = true;
            UsbActivity.access$508(UsbActivity.this);
            UsbActivity.this.tryConnect();
            return false;
        }
    });

    static /* synthetic */ int access$508(UsbActivity usbActivity) {
        int i = usbActivity.timeNum;
        usbActivity.timeNum = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.textView = new TextView(this);
        linearLayout.addView(this.textView);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
        this.usbManager = (UsbManager) getSystemService("usb");
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(ACTION_USB_STATE);
        registerReceiver(this.receiver, this.intentFilter);
        initUsb();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        unregisterReceiver(this.receiver);
        SPUsb sPUsb = this.spUsb;
        if (sPUsb != null) {
            sPUsb.release();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addText(String str) {
        TextView textView = this.textView;
        textView.setText(this.textView.getText().toString() + str + "\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        this.isTiming = true;
        this.timeNum = 0;
        this.handler.sendEmptyMessage(0);
        addText("startTimer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeTimer() {
        this.handler.removeMessages(0);
        this.isTiming = false;
        this.timeNum = 0;
        addText("closeTimer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryConnect() {
        UsbAccessory[] accessoryList = this.usbManager.getAccessoryList();
        if (accessoryList != null && accessoryList.length != 0) {
            closeTimer();
            addText("Accessory Found!!!");
            initUsb();
        } else if (this.timeNum > 3) {
            closeTimer();
        } else {
            this.handler.sendEmptyMessageDelayed(0, 1500L);
            addText("Accessory No Found!!!");
        }
    }

    private void initUsb() {
        if (this.spUsb == null) {
            this.spUsb = SPUsb.getInstance();
            this.spUsb.setUsbType(1);
        }
        this.spUsb.openUsb(new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.UsbActivity.3
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
                UsbActivity usbActivity = UsbActivity.this;
                usbActivity.addText(" usb open " + bool);
            }
        });
    }
}
