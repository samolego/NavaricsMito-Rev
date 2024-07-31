package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p008v4.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;

/* loaded from: classes.dex */
public class CustomTabMainActivity extends Activity {

    /* renamed from: a */
    public static final String f1435a = CustomTabMainActivity.class.getSimpleName() + ".extra_params";

    /* renamed from: b */
    public static final String f1436b = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";

    /* renamed from: c */
    public static final String f1437c = CustomTabMainActivity.class.getSimpleName() + ".extra_url";

    /* renamed from: d */
    public static final String f1438d = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";

    /* renamed from: e */
    private boolean f1439e = true;

    /* renamed from: f */
    private BroadcastReceiver f1440f;

    /* renamed from: a */
    public static final String m11431a() {
        return "fb" + FacebookSdk.m10865l() + "://authorize";
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.f1431a.equals(getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(f1435a);
            new CustomTab("oauth", bundleExtra).m10736a(this, getIntent().getStringExtra(f1436b));
            this.f1439e = false;
            this.f1440f = new BroadcastReceiver() { // from class: com.facebook.CustomTabMainActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.f1438d);
                    intent2.putExtra(CustomTabMainActivity.f1437c, intent.getStringExtra(CustomTabMainActivity.f1437c));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(this.f1440f, new IntentFilter(CustomTabActivity.f1431a));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (f1438d.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.f1432b));
            m11430a(-1, intent);
        } else if (CustomTabActivity.f1431a.equals(intent.getAction())) {
            m11430a(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f1439e) {
            m11430a(0, null);
        }
        this.f1439e = true;
    }

    /* renamed from: a */
    private void m11430a(int i, Intent intent) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f1440f);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }
}
