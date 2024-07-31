package com.navatics.app.developer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p008v4.app.FragmentTransaction;
import android.support.p011v7.app.AppCompatActivity;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class DeveloperSettingActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.developer_setting_activity);
        if (bundle == null) {
            DeveloperSettingFragment developerSettingFragment = new DeveloperSettingFragment();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.developerSettingFragment, developerSettingFragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
