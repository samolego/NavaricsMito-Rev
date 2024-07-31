package com.navatics.app.activities.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.widget.DivelogSeekbar;

/* loaded from: classes.dex */
public class TestNewDivelogUIActivity extends NvBaseActivity {
    @BindView
    DivelogSeekbar divelogSeekbar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_new_divelog_ui_activity);
        ButterKnife.m12805a(this);
        this.divelogSeekbar.setIndicatorProgress(60);
    }
}
