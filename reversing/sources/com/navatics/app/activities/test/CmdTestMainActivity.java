package com.navatics.app.activities.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class CmdTestMainActivity extends AppCompatActivity {
    @BindView
    Button btnDataTest;
    @BindView
    Button btnRecvTest;

    /* renamed from: lambda$-iNL669sIRC6DkXcGJXOZh1jZmY */
    public static /* synthetic */ void m13039lambda$iNL669sIRC6DkXcGJXOZh1jZmY(CmdTestMainActivity cmdTestMainActivity, View view) {
        cmdTestMainActivity.m8849b(view);
    }

    /* renamed from: lambda$YS1dAeaK-Y_U8jvo-2j7mjp5STo */
    public static /* synthetic */ void m13040lambda$YS1dAeaKY_U8jvo2j7mjp5STo(CmdTestMainActivity cmdTestMainActivity, View view) {
        cmdTestMainActivity.m8850a(view);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cmd_test_main_activity);
        ButterKnife.m12805a(this);
        this.btnRecvTest.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestMainActivity$-iNL669sIRC6DkXcGJXOZh1jZmY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CmdTestMainActivity.m13039lambda$iNL669sIRC6DkXcGJXOZh1jZmY(CmdTestMainActivity.this, view);
            }
        });
        this.btnDataTest.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestMainActivity$YS1dAeaK-Y_U8jvo-2j7mjp5STo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CmdTestMainActivity.m13040lambda$YS1dAeaKY_U8jvo2j7mjp5STo(CmdTestMainActivity.this, view);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m8849b(View view) {
        startActivity(new Intent(this, CmdTestActivity.class));
    }

    /* renamed from: a */
    public /* synthetic */ void m8850a(View view) {
        startActivity(new Intent(this, CmdDetailTestActivity.class));
    }
}
