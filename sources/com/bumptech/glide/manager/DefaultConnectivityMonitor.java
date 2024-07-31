package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.manager.e */
/* loaded from: classes.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: a */
    final ConnectivityMonitor.InterfaceC0769a f1160a;

    /* renamed from: b */
    boolean f1161b;

    /* renamed from: c */
    private final Context f1162c;

    /* renamed from: d */
    private boolean f1163d;

    /* renamed from: e */
    private final BroadcastReceiver f1164e = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.f1161b;
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            defaultConnectivityMonitor.f1161b = defaultConnectivityMonitor.m11796a(context);
            if (z != DefaultConnectivityMonitor.this.f1161b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.f1161b);
                }
                DefaultConnectivityMonitor.this.f1160a.mo11798a(DefaultConnectivityMonitor.this.f1161b);
            }
        }
    };

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: e */
    public void mo11692e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultConnectivityMonitor(@NonNull Context context, @NonNull ConnectivityMonitor.InterfaceC0769a interfaceC0769a) {
        this.f1162c = context.getApplicationContext();
        this.f1160a = interfaceC0769a;
    }

    /* renamed from: a */
    private void m11797a() {
        if (this.f1163d) {
            return;
        }
        this.f1161b = m11796a(this.f1162c);
        try {
            this.f1162c.registerReceiver(this.f1164e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f1163d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    /* renamed from: b */
    private void m11795b() {
        if (this.f1163d) {
            this.f1162c.unregisterReceiver(this.f1164e);
            this.f1163d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    boolean m11796a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.m11580a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: c */
    public void mo11695c() {
        m11797a();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: d */
    public void mo11693d() {
        m11795b();
    }
}
