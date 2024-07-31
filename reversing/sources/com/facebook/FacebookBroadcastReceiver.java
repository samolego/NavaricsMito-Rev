package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;

/* loaded from: classes.dex */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    protected void m11426a(String str, String str2, Bundle bundle) {
    }

    /* renamed from: b */
    protected void m11425b(String str, String str2, Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String stringExtra2 = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        if (stringExtra == null || stringExtra2 == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (NativeProtocol.m10577e(intent)) {
            m11425b(stringExtra, stringExtra2, extras);
        } else {
            m11426a(stringExtra, stringExtra2, extras);
        }
    }
}
