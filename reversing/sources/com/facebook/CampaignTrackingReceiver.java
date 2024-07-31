package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsLogger;

/* loaded from: classes.dex */
public final class CampaignTrackingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra == null || !stringExtra.startsWith("fb")) {
            return;
        }
        AppEventsLogger.m11288a(intent.getStringExtra("referrer"));
    }
}
