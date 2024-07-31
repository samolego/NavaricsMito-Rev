package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.app.FragmentManager;
import com.facebook.common.R;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

/* loaded from: classes.dex */
public class FacebookActivity extends FragmentActivity {

    /* renamed from: a */
    public static String f1442a = "PassThrough";

    /* renamed from: b */
    private static String f1443b = "SingleFragment";

    /* renamed from: c */
    private static final String f1444c = "com.facebook.FacebookActivity";

    /* renamed from: d */
    private Fragment f1445d;

    @Override // android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.m10885a()) {
            Utility.m10505b(f1444c, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.m10883a(getApplicationContext());
        }
        setContentView(R.layout.com_facebook_activity_layout);
        if (f1442a.equals(intent.getAction())) {
            m11427c();
        } else {
            this.f1445d = m11429a();
        }
    }

    /* renamed from: a */
    protected Fragment m11429a() {
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(f1443b);
        if (findFragmentByTag == null) {
            if ("FacebookDialogFragment".equals(intent.getAction())) {
                FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
                facebookDialogFragment.setRetainInstance(true);
                facebookDialogFragment.show(supportFragmentManager, f1443b);
                return facebookDialogFragment;
            } else if ("DeviceShareDialogFragment".equals(intent.getAction())) {
                DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.m10193a((ShareContent) intent.getParcelableExtra("content"));
                deviceShareDialogFragment.show(supportFragmentManager, f1443b);
                return deviceShareDialogFragment;
            } else {
                LoginFragment loginFragment = new LoginFragment();
                loginFragment.setRetainInstance(true);
                supportFragmentManager.beginTransaction().add(R.id.com_facebook_fragment_container, loginFragment, f1443b).commit();
                return loginFragment;
            }
        }
        return findFragmentByTag;
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.f1445d;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    /* renamed from: b */
    public Fragment m11428b() {
        return this.f1445d;
    }

    /* renamed from: c */
    private void m11427c() {
        setResult(0, NativeProtocol.m10598a(getIntent(), (Bundle) null, NativeProtocol.m10596a(NativeProtocol.m10579d(getIntent()))));
        finish();
    }
}
