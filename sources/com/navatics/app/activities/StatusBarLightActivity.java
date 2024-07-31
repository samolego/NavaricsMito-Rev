package com.navatics.app.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.navatics.app.NvBaseActivity;

/* loaded from: classes.dex */
public abstract class StatusBarLightActivity extends NvBaseActivity {
    /* renamed from: e_ */
    protected int mo9030e_() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
            getWindow().setStatusBarColor(mo9030e_());
        }
    }
}
