package com.navatics.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.core.ScanBoxView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.yanzhenjie.sofia.Sofia;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ScanQRCodeActivity extends NvBaseActivity implements QRCodeView.InterfaceC0577a {

    /* renamed from: a */
    private static final C3044k f3866a = C3044k.m1564a(ScanQRCodeActivity.class);
    @BindView
    ZXingView zxView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.scan_qrcode_activity);
        ButterKnife.m12805a(this);
        Sofia.m3725a(this).mo3729b();
        this.zxView.setDelegate(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.zxView.m12759d();
        this.zxView.m12753i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.zxView.m12757e();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.zxView.m12750l();
        super.onDestroy();
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC0577a
    /* renamed from: a */
    public void mo9023a(String str) {
        C3044k c3044k = f3866a;
        c3044k.mo1500c((Object) ("onScanQRCodeSuccess:" + str));
        Intent intent = new Intent();
        intent.putExtra("qrcode", str);
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC0577a
    /* renamed from: a */
    public void mo9022a(boolean z) {
        String tipText = this.zxView.getScanBoxView().getTipText();
        if (z) {
            if (tipText.contains("\n环境过暗，请打开闪光灯")) {
                return;
            }
            ScanBoxView scanBoxView = this.zxView.getScanBoxView();
            scanBoxView.setTipText(tipText + "\n环境过暗，请打开闪光灯");
        } else if (tipText.contains("\n环境过暗，请打开闪光灯")) {
            this.zxView.getScanBoxView().setTipText(tipText.substring(0, tipText.indexOf("\n环境过暗，请打开闪光灯")));
        }
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC0577a
    /* renamed from: a */
    public void mo9024a() {
        f3866a.mo1504b((Object) "打开相机出错");
    }
}
