package com.navatics.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ActivationCodeInputActivity extends StatusBarLightActivity {
    @BindView
    Button btnOK;
    @BindView
    EditText etInputCode;
    @BindView
    ImageView ivBack;

    public static /* synthetic */ void lambda$5ADwBr8vopasfnrNdJawosTrF40(ActivationCodeInputActivity activationCodeInputActivity, View view) {
        activationCodeInputActivity.m9490a(view);
    }

    /* renamed from: lambda$dQnc76_gUld5OcWVpwbq-4762l4 */
    public static /* synthetic */ void m12967lambda$dQnc76_gUld5OcWVpwbq4762l4(ActivationCodeInputActivity activationCodeInputActivity, View view) {
        activationCodeInputActivity.m9489b(view);
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_input_ac);
        ButterKnife.m12805a(this);
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$ActivationCodeInputActivity$dQnc76_gUld5OcWVpwbq-4762l4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivationCodeInputActivity.m12967lambda$dQnc76_gUld5OcWVpwbq4762l4(ActivationCodeInputActivity.this, view);
            }
        });
        this.btnOK.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$ActivationCodeInputActivity$5ADwBr8vopasfnrNdJawosTrF40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivationCodeInputActivity.lambda$5ADwBr8vopasfnrNdJawosTrF40(ActivationCodeInputActivity.this, view);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m9489b(View view) {
        finish();
    }

    /* renamed from: a */
    public /* synthetic */ void m9490a(View view) {
        Intent intent = new Intent();
        intent.putExtra("qrcode", this.etInputCode.getText().toString());
        setResult(-1, intent);
        finish();
    }
}
