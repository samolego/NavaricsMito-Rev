package com.navatics.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.R;
import com.navatics.app.widget.NvNumberPicker;

/* loaded from: classes.dex */
public class TestNumberPickerActivity extends AppCompatActivity {
    @BindView
    Button btn1;
    @BindView
    Button btn2;
    @BindView
    NvNumberPicker testPicker;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_number_picker_activity);
        ButterKnife.m12805a(this);
    }

    @OnClick
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1 /* 2131296314 */:
                this.testPicker.m7199a();
                return;
            case R.id.btn2 /* 2131296315 */:
                this.testPicker.m7189b();
                return;
            default:
                return;
        }
    }
}
