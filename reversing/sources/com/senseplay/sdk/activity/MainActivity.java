package com.senseplay.sdk.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.model.usb.UsbData;

/* loaded from: classes2.dex */
public class MainActivity extends Activity {
    UsbData usbData;
    private boolean curBool = false;
    private UsbStateReceiver receiver = new UsbStateReceiver();
    private final String USB_STATE = UsbActivity.ACTION_USB_STATE;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2189R.layout.sp_activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UsbActivity.ACTION_USB_STATE);
        registerReceiver(this.receiver, intentFilter);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.receiver);
    }

    /* loaded from: classes2.dex */
    public class UsbStateReceiver extends BroadcastReceiver {
        private Handler myHandler = new Handler() { // from class: com.senseplay.sdk.activity.MainActivity.UsbStateReceiver.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };

        public UsbStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (!intent.getAction().equals(UsbActivity.ACTION_USB_STATE) || MainActivity.this.curBool == (z = intent.getExtras().getBoolean(UsbActivity.USB_CONNECTED))) {
                return;
            }
            MainActivity.this.curBool = z;
            if (z) {
                Toast.makeText(context, "bool =" + z + "", 0).show();
                return;
            }
            Toast.makeText(context, "bool =" + z + "", 0).show();
        }
    }
}
