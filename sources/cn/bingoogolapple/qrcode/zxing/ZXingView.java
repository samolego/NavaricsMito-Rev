package cn.bingoogolapple.qrcode.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.core.ScanResult;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.Map;

/* loaded from: classes.dex */
public class ZXingView extends QRCodeView {

    /* renamed from: j */
    private MultiFormatReader f257j;

    /* renamed from: k */
    private Map<DecodeHintType, Object> f258k;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    /* renamed from: a */
    protected void mo12696a() {
        this.f257j = new MultiFormatReader();
        if (this.f170i == BarcodeType.ONE_DIMENSION) {
            this.f257j.setHints(QRCodeDecoder.f260b);
        } else if (this.f170i == BarcodeType.TWO_DIMENSION) {
            this.f257j.setHints(QRCodeDecoder.f261c);
        } else if (this.f170i == BarcodeType.ONLY_QR_CODE) {
            this.f257j.setHints(QRCodeDecoder.f262d);
        } else if (this.f170i == BarcodeType.ONLY_CODE_128) {
            this.f257j.setHints(QRCodeDecoder.f263e);
        } else if (this.f170i == BarcodeType.ONLY_EAN_13) {
            this.f257j.setHints(QRCodeDecoder.f264f);
        } else if (this.f170i == BarcodeType.HIGH_FREQUENCY) {
            this.f257j.setHints(QRCodeDecoder.f265g);
        } else if (this.f170i == BarcodeType.CUSTOM) {
            this.f257j.setHints(this.f258k);
        } else {
            this.f257j.setHints(QRCodeDecoder.f259a);
        }
    }

    /* renamed from: a */
    public void m12694a(BarcodeType barcodeType, Map<DecodeHintType, Object> map) {
        Map<DecodeHintType, Object> map2;
        this.f170i = barcodeType;
        this.f258k = map;
        if (this.f170i == BarcodeType.CUSTOM && ((map2 = this.f258k) == null || map2.isEmpty())) {
            throw new RuntimeException("barcodeType 为 BarcodeType.CUSTOM 时 hintMap 不能为空");
        }
        mo12696a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    /* renamed from: a */
    public ScanResult mo12695a(Bitmap bitmap) {
        return new ScanResult(QRCodeDecoder.m12691a(bitmap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.bingoogolapple.qrcode.core.ScanResult mo12692a(byte[] r15, int r16, int r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bingoogolapple.qrcode.zxing.ZXingView.mo12692a(byte[], int, int, boolean):cn.bingoogolapple.qrcode.core.d");
    }

    /* renamed from: a */
    private boolean m12693a(BarcodeFormat barcodeFormat) {
        return m12746p() && barcodeFormat == BarcodeFormat.QR_CODE;
    }
}
