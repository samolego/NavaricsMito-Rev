package com.navatics.app.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.R;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPKeyMap;
import com.senseplay.sdk.model.keymap.Category;
import com.senseplay.sdk.model.keymap.OpStyle;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class KeymapTestingActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final C3044k f5053a = C3044k.m1564a(KeymapTestingActivity.class);

    /* renamed from: lambda$6NLszqgUJ-gxsCbEIBEMK1VNPSM */
    public static /* synthetic */ void m13086lambda$6NLszqgUJgxsCbEIBEMK1VNPSM(KeymapTestingActivity keymapTestingActivity, Boolean bool) {
        keymapTestingActivity.m7464e(bool);
    }

    public static /* synthetic */ void lambda$AnSCmXcPNoF_rbnW8YyFNyjIjVY(KeymapTestingActivity keymapTestingActivity, Boolean bool) {
        keymapTestingActivity.m7465d(bool);
    }

    public static /* synthetic */ void lambda$HvJx4HbSZ4Be6GvwekbyKGi_Qss(KeymapTestingActivity keymapTestingActivity, Boolean bool) {
        keymapTestingActivity.m7467b(bool);
    }

    /* renamed from: lambda$eQyMkZmE62-dbukyPrNNMBvvvhg */
    public static /* synthetic */ void m13087lambda$eQyMkZmE62dbukyPrNNMBvvvhg(KeymapTestingActivity keymapTestingActivity, Boolean bool) {
        keymapTestingActivity.m7466c(bool);
    }

    /* renamed from: lambda$jIaFAmhnNf9H-stAqBgZHSBA6Fs */
    public static /* synthetic */ void m13088lambda$jIaFAmhnNf9HstAqBgZHSBA6Fs(KeymapTestingActivity keymapTestingActivity, Boolean bool) {
        keymapTestingActivity.m7468a(bool);
    }

    /* renamed from: lambda$pR4V-pvmm9QZ-Se2k2HiSQJkECw */
    public static /* synthetic */ void m13089lambda$pR4Vpvmm9QZSe2k2HiSQJkECw(KeymapTestingActivity keymapTestingActivity, Boolean bool) {
        keymapTestingActivity.m7463f(bool);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_keymap_activity);
        ButterKnife.m12805a(this);
    }

    @OnClick
    public void onBtnDownloadClicked(View view) {
        SPKeyMap.getInstance().init("STRCC1C118C0300154");
        Toast.makeText(this, "Download Success", 0).show();
    }

    @OnClick
    public void onBtnWriteClicked(View view) {
        SPKeyMap.getInstance().writeKeyMap(SPKeyMap.getInstance().getKeyMapJson(Category.MARINE, OpStyle.USA), new MCallBack() { // from class: com.navatics.app.settings.-$$Lambda$KeymapTestingActivity$6NLszqgUJ-gxsCbEIBEMK1VNPSM
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                KeymapTestingActivity.m13086lambda$6NLszqgUJgxsCbEIBEMK1VNPSM(KeymapTestingActivity.this, (Boolean) obj);
            }
        });
    }

    /* renamed from: e */
    public /* synthetic */ void m7464e(final Boolean bool) {
        C3044k c3044k = f5053a;
        c3044k.mo1500c((Object) ("write keymap result : " + bool));
        runOnUiThread(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$KeymapTestingActivity$pR4V-pvmm9QZ-Se2k2HiSQJkECw
            @Override // java.lang.Runnable
            public final void run() {
                KeymapTestingActivity.m13089lambda$pR4Vpvmm9QZSe2k2HiSQJkECw(KeymapTestingActivity.this, bool);
            }
        });
    }

    /* renamed from: f */
    public /* synthetic */ void m7463f(Boolean bool) {
        Toast.makeText(this, "Write : " + bool, 0).show();
    }

    @OnClick
    public void onBtnGetClicked(View view) {
        String keyMapJson = SPKeyMap.getInstance().getKeyMapJson(Category.MARINE, OpStyle.USA);
        C3044k c3044k = f5053a;
        c3044k.mo1511a((Object) ("keymap : " + keyMapJson));
    }

    @OnClick
    public void onBtnCorrectClicked(View view) {
        SPKeyMap.getInstance().writeKeyMap("2F00100e2e140b100100001101000016010000170100001200000013000000A3000000A8010000A9010000AA010000AB0100000a1202D0000000E4000000080121008A00000104080120008A000001030801E9008A000001010801E8008A0000010209020000911002F5F5000801260093000001100801AE007B000001010801AC007B00000103080127007B0000010009020000901002D3DB000801AD008F000001020801AF008F00000101", new MCallBack() { // from class: com.navatics.app.settings.-$$Lambda$KeymapTestingActivity$eQyMkZmE62-dbukyPrNNMBvvvhg
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                KeymapTestingActivity.m13087lambda$eQyMkZmE62dbukyPrNNMBvvvhg(KeymapTestingActivity.this, (Boolean) obj);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m7466c(final Boolean bool) {
        C3044k c3044k = f5053a;
        c3044k.mo1500c((Object) ("write keymap result : " + bool));
        runOnUiThread(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$KeymapTestingActivity$AnSCmXcPNoF_rbnW8YyFNyjIjVY
            @Override // java.lang.Runnable
            public final void run() {
                KeymapTestingActivity.lambda$AnSCmXcPNoF_rbnW8YyFNyjIjVY(KeymapTestingActivity.this, bool);
            }
        });
    }

    /* renamed from: d */
    public /* synthetic */ void m7465d(Boolean bool) {
        Toast.makeText(this, "Write : " + bool, 0).show();
    }

    @OnClick
    public void onBtnWrongClicked(View view) {
        SPKeyMap.getInstance().writeKeyMap("2F0030082e140b100000001101000016000000170000001201000013010000A3000000A8010000A9000000AA010000AB0000000a1202D0000000E40000000701AC009B0000000a020000960003D2E6E500070122009910000007012100D10000000701AE009A0000000701230070000000", new MCallBack() { // from class: com.navatics.app.settings.-$$Lambda$KeymapTestingActivity$jIaFAmhnNf9H-stAqBgZHSBA6Fs
            @Override // com.senseplay.mframe.client.MCallBack
            public final void onResult(Object obj) {
                KeymapTestingActivity.m13088lambda$jIaFAmhnNf9HstAqBgZHSBA6Fs(KeymapTestingActivity.this, (Boolean) obj);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7468a(final Boolean bool) {
        C3044k c3044k = f5053a;
        c3044k.mo1500c((Object) ("write keymap result : " + bool));
        runOnUiThread(new Runnable() { // from class: com.navatics.app.settings.-$$Lambda$KeymapTestingActivity$HvJx4HbSZ4Be6GvwekbyKGi_Qss
            @Override // java.lang.Runnable
            public final void run() {
                KeymapTestingActivity.lambda$HvJx4HbSZ4Be6GvwekbyKGi_Qss(KeymapTestingActivity.this, bool);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m7467b(Boolean bool) {
        Toast.makeText(this, "Write : " + bool, 0).show();
    }
}
