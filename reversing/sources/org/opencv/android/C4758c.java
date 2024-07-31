package org.opencv.android;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.util.Log;

@TargetApi(15)
/* renamed from: org.opencv.android.c */
/* loaded from: classes2.dex */
public class CameraRenderer extends CameraGLRendererBase {

    /* renamed from: a */
    private Camera f12482a;

    /* renamed from: q */
    private boolean f12483q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraRenderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.f12483q = false;
    }

    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: c */
    protected synchronized void mo308c() {
        Log.i("CameraRenderer", "closeCamera");
        if (this.f12482a != null) {
            this.f12482a.stopPreview();
            this.f12483q = false;
            this.f12482a.release();
            this.f12482a = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0142 A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0019, B:10:0x003b, B:12:0x003f, B:15:0x0044, B:17:0x004a, B:18:0x0065, B:24:0x0094, B:21:0x006e, B:54:0x013e, B:56:0x0142, B:59:0x014b, B:61:0x0157, B:63:0x015f, B:64:0x0164, B:65:0x0169, B:68:0x0172, B:9:0x0021, B:25:0x0097, B:27:0x009b, B:29:0x00a5, B:30:0x00b1, B:32:0x00b7, B:35:0x00c0, B:46:0x00e7, B:48:0x00f1, B:49:0x00f9, B:50:0x0114, B:53:0x011c, B:36:0x00c3, B:38:0x00c7, B:39:0x00d3, B:41:0x00d9, B:44:0x00e2), top: B:80:0x0001, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014b A[Catch: all -> 0x018e, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0019, B:10:0x003b, B:12:0x003f, B:15:0x0044, B:17:0x004a, B:18:0x0065, B:24:0x0094, B:21:0x006e, B:54:0x013e, B:56:0x0142, B:59:0x014b, B:61:0x0157, B:63:0x015f, B:64:0x0164, B:65:0x0169, B:68:0x0172, B:9:0x0021, B:25:0x0097, B:27:0x009b, B:29:0x00a5, B:30:0x00b1, B:32:0x00b7, B:35:0x00c0, B:46:0x00e7, B:48:0x00f1, B:49:0x00f9, B:50:0x0114, B:53:0x011c, B:36:0x00c3, B:38:0x00c7, B:39:0x00d3, B:41:0x00d9, B:44:0x00e2), top: B:80:0x0001, inners: #0, #1, #2, #4 }] */
    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized void mo310a(int r7) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.CameraRenderer.mo310a(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0102 A[Catch: all -> 0x0126, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x0029, B:9:0x0032, B:11:0x0036, B:13:0x003a, B:14:0x003c, B:16:0x0040, B:18:0x0044, B:19:0x0046, B:21:0x0056, B:22:0x0060, B:24:0x0066, B:29:0x0096, B:35:0x00b1, B:37:0x00fe, B:39:0x0102, B:40:0x0109, B:36:0x00d0, B:41:0x0110), top: B:47:0x0007 }] */
    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void mo309b(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.CameraRenderer.mo309b(int, int):void");
    }
}
