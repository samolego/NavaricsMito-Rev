package com.navatics.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.p011v7.app.AppCompatActivity;
import android.support.p011v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.core.ScanBoxView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.navatics.app.R;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TestScanActivity extends AppCompatActivity implements QRCodeView.InterfaceC0577a {

    /* renamed from: a */
    private static final String f3917a = "TestScanActivity";

    /* renamed from: b */
    private ZXingView f3918b;

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_scan);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f3918b = (ZXingView) findViewById(R.id.zxingview);
        this.f3918b.setDelegate(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f3918b.m12759d();
        this.f3918b.m12753i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f3918b.m12757e();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f3918b.m12750l();
        super.onDestroy();
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC0577a
    /* renamed from: a */
    public void mo9023a(String str) {
        String str2 = f3917a;
        Log.i(str2, "result:" + str);
        this.f3918b.m12756f();
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC0577a
    /* renamed from: a */
    public void mo9022a(boolean z) {
        String tipText = this.f3918b.getScanBoxView().getTipText();
        if (z) {
            if (tipText.contains("\n环境过暗，请打开闪光灯")) {
                return;
            }
            ScanBoxView scanBoxView = this.f3918b.getScanBoxView();
            scanBoxView.setTipText(tipText + "\n环境过暗，请打开闪光灯");
        } else if (tipText.contains("\n环境过暗，请打开闪光灯")) {
            this.f3918b.getScanBoxView().setTipText(tipText.substring(0, tipText.indexOf("\n环境过暗，请打开闪光灯")));
        }
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC0577a
    /* renamed from: a */
    public void mo9024a() {
        Log.e(f3917a, "打开相机出错");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close_flashlight) {
            this.f3918b.m12751k();
        } else if (id == R.id.hidden_scan_rect) {
            this.f3918b.m12761c();
        } else if (id == R.id.open_flashlight) {
            this.f3918b.m12752j();
        } else if (id == R.id.show_scan_rect) {
            this.f3918b.m12764b();
        } else {
            switch (id) {
                case R.id.decode_full_screen_area /* 2131296449 */:
                    this.f3918b.getScanBoxView().setOnlyDecodeScanBoxArea(false);
                    return;
                case R.id.decode_scan_box_area /* 2131296450 */:
                    this.f3918b.getScanBoxView().setOnlyDecodeScanBoxArea(true);
                    return;
                default:
                    switch (id) {
                        case R.id.scan_all /* 2131296785 */:
                            this.f3918b.m12748n();
                            this.f3918b.m12694a(BarcodeType.ALL, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_code128 /* 2131296786 */:
                            this.f3918b.m12749m();
                            this.f3918b.m12694a(BarcodeType.ONLY_CODE_128, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_custom /* 2131296787 */:
                            this.f3918b.m12748n();
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(BarcodeFormat.QR_CODE);
                            arrayList.add(BarcodeFormat.UPC_A);
                            arrayList.add(BarcodeFormat.EAN_13);
                            arrayList.add(BarcodeFormat.CODE_128);
                            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) arrayList);
                            enumMap.put((EnumMap) DecodeHintType.TRY_HARDER, (DecodeHintType) Boolean.TRUE);
                            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) "utf-8");
                            this.f3918b.m12694a(BarcodeType.CUSTOM, enumMap);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_ean13 /* 2131296788 */:
                            this.f3918b.m12749m();
                            this.f3918b.m12694a(BarcodeType.ONLY_EAN_13, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_high_frequency /* 2131296789 */:
                            this.f3918b.m12748n();
                            this.f3918b.m12694a(BarcodeType.HIGH_FREQUENCY, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_one_dimension /* 2131296790 */:
                            this.f3918b.m12749m();
                            this.f3918b.m12694a(BarcodeType.ONE_DIMENSION, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_qr_code /* 2131296791 */:
                            this.f3918b.m12748n();
                            this.f3918b.m12694a(BarcodeType.ONLY_QR_CODE, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        case R.id.scan_two_dimension /* 2131296792 */:
                            this.f3918b.m12748n();
                            this.f3918b.m12694a(BarcodeType.TWO_DIMENSION, (Map<DecodeHintType, Object>) null);
                            this.f3918b.m12753i();
                            return;
                        default:
                            switch (id) {
                                case R.id.start_preview /* 2131296856 */:
                                    this.f3918b.m12759d();
                                    return;
                                case R.id.start_spot /* 2131296857 */:
                                    this.f3918b.m12756f();
                                    return;
                                case R.id.start_spot_showrect /* 2131296858 */:
                                    this.f3918b.m12753i();
                                    return;
                                default:
                                    switch (id) {
                                        case R.id.stop_preview /* 2131296861 */:
                                            this.f3918b.m12757e();
                                            return;
                                        case R.id.stop_spot /* 2131296862 */:
                                            this.f3918b.m12755g();
                                            return;
                                        case R.id.stop_spot_hiddenrect /* 2131296863 */:
                                            this.f3918b.m12754h();
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f3918b.m12753i();
    }
}
