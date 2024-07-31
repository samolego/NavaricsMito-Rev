package com.senseplay.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.senseplay.sdk.activity.UsbActivity;

/* loaded from: classes2.dex */
public class UsbStateReceiver extends BroadcastReceiver {
    private final String USB_STATE = UsbActivity.ACTION_USB_STATE;
    private long mReceivedUsbStateTime = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
