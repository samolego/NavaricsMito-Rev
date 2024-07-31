package com.navatics.app.recevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.navatics.app.framework.p053e.MessageLoggerFactory;

/* loaded from: classes.dex */
public class SystemKeyReceiver extends BroadcastReceiver {

    /* renamed from: a */
    final String f5008a = "reason";

    /* renamed from: b */
    final String f5009b = "recentapps";

    /* renamed from: c */
    final String f5010c = "homekey";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || (stringExtra = intent.getStringExtra("reason")) == null) {
            return;
        }
        if (stringExtra.equals("homekey")) {
            MessageLoggerFactory.m8420a().mo8417b();
        } else if (stringExtra.equals("recentapps")) {
            MessageLoggerFactory.m8420a().mo8417b();
        }
    }
}
