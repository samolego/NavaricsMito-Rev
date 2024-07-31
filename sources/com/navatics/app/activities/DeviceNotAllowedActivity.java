package com.navatics.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class DeviceNotAllowedActivity extends AppCompatActivity {
    @BindView
    TextView tvNote;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_not_allowed);
        ButterKnife.m12805a(this);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        String string = extras.getString("key_note", null);
        if (TextUtils.isEmpty(string)) {
            finish();
        } else {
            this.tvNote.setText(string);
        }
    }
}
