package cn.bingoogolapple.qrcode.core;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: cn.bingoogolapple.qrcode.core.c */
/* loaded from: classes.dex */
public class ProcessDataTask extends AsyncTask<Void, Void, ScanResult> {

    /* renamed from: g */
    private static long f249g;

    /* renamed from: a */
    private Camera f250a;

    /* renamed from: b */
    private byte[] f251b;

    /* renamed from: c */
    private boolean f252c;

    /* renamed from: d */
    private String f253d;

    /* renamed from: e */
    private Bitmap f254e;

    /* renamed from: f */
    private WeakReference<QRCodeView> f255f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessDataTask(Camera camera, byte[] bArr, QRCodeView qRCodeView, boolean z) {
        this.f250a = camera;
        this.f251b = bArr;
        this.f255f = new WeakReference<>(qRCodeView);
        this.f252c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ProcessDataTask m12701a() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m12697b() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f255f.clear();
        this.f254e = null;
        this.f251b = null;
    }

    /* renamed from: a */
    private ScanResult m12700a(QRCodeView qRCodeView) {
        Exception e;
        int i;
        int i2;
        byte[] bArr = this.f251b;
        if (bArr == null) {
            return null;
        }
        try {
            Camera.Size previewSize = this.f250a.getParameters().getPreviewSize();
            i2 = previewSize.width;
            try {
                i = previewSize.height;
                try {
                    if (this.f252c) {
                        bArr = new byte[this.f251b.length];
                        for (int i3 = 0; i3 < i; i3++) {
                            for (int i4 = 0; i4 < i2; i4++) {
                                bArr[(((i4 * i) + i) - i3) - 1] = this.f251b[(i3 * i2) + i4];
                            }
                        }
                    } else {
                        i2 = i;
                        i = i2;
                    }
                    try {
                        return qRCodeView.mo12692a(bArr, i, i2, false);
                    } catch (Exception e2) {
                        e = e2;
                        int i5 = i2;
                        i2 = i;
                        i = i5;
                        e.printStackTrace();
                        if (i2 == 0 || i == 0) {
                            return null;
                        }
                        try {
                            BGAQRCodeUtil.m12723a("识别失败重试");
                            return qRCodeView.mo12692a(bArr, i2, i, true);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Exception e5) {
                e = e5;
                i = 0;
            }
        } catch (Exception e6) {
            e = e6;
            i = 0;
            i2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ScanResult doInBackground(Void... voidArr) {
        QRCodeView qRCodeView = this.f255f.get();
        if (qRCodeView == null) {
            return null;
        }
        String str = this.f253d;
        if (str != null) {
            return qRCodeView.mo12695a(BGAQRCodeUtil.m12715c(str));
        }
        Bitmap bitmap = this.f254e;
        if (bitmap != null) {
            ScanResult mo12695a = qRCodeView.mo12695a(bitmap);
            this.f254e = null;
            return mo12695a;
        }
        if (BGAQRCodeUtil.m12730a()) {
            BGAQRCodeUtil.m12723a("两次任务执行的时间间隔：" + (System.currentTimeMillis() - f249g));
            f249g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ScanResult m12700a = m12700a(qRCodeView);
        if (BGAQRCodeUtil.m12730a()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (m12700a != null && !TextUtils.isEmpty(m12700a.f256a)) {
                BGAQRCodeUtil.m12723a("识别成功时间为：" + currentTimeMillis2);
            } else {
                BGAQRCodeUtil.m12717b("识别失败时间为：" + currentTimeMillis2);
            }
        }
        return m12700a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ScanResult scanResult) {
        QRCodeView qRCodeView = this.f255f.get();
        if (qRCodeView == null) {
            return;
        }
        if (this.f253d != null || this.f254e != null) {
            this.f254e = null;
            qRCodeView.m12762b(scanResult);
            return;
        }
        qRCodeView.m12768a(scanResult);
    }
}
