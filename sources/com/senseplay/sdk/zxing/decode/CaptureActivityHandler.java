package com.senseplay.sdk.zxing.decode;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.zxing.CaptureActivity;
import com.senseplay.sdk.zxing.camera.CameraManager;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class CaptureActivityHandler extends Handler {
    private static final String TAG = "CaptureActivityHandler";
    private final CaptureActivity activity;
    private final CameraManager cameraManager;
    private final DecodeThread decodeThread;
    private State state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, String str, CameraManager cameraManager) {
        this.activity = captureActivity;
        this.decodeThread = new DecodeThread(captureActivity, collection, str);
        this.decodeThread.start();
        this.state = State.SUCCESS;
        this.cameraManager = cameraManager;
        cameraManager.startPreview();
        restartPreviewAndDecode();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == C2189R.C2191id.restart_preview) {
            restartPreviewAndDecode();
        } else if (i == C2189R.C2191id.decode_succeeded) {
            this.state = State.SUCCESS;
            message.getData();
            this.activity.handleDecode((Result) message.obj);
        } else if (i == C2189R.C2191id.decode_failed) {
            this.state = State.PREVIEW;
            this.cameraManager.requestPreviewFrame(this.decodeThread.getHandler(), C2189R.C2191id.decode);
        } else if (i == C2189R.C2191id.return_scan_result) {
            this.activity.setResult(-1, (Intent) message.obj);
            this.activity.finish();
        }
    }

    public void quitSynchronously() {
        this.state = State.DONE;
        this.cameraManager.stopPreview();
        Message.obtain(this.decodeThread.getHandler(), C2189R.C2191id.quit).sendToTarget();
        try {
            this.decodeThread.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(C2189R.C2191id.decode_succeeded);
        removeMessages(C2189R.C2191id.decode_failed);
    }

    private void restartPreviewAndDecode() {
        if (this.state == State.SUCCESS) {
            this.state = State.PREVIEW;
            this.cameraManager.requestPreviewFrame(this.decodeThread.getHandler(), C2189R.C2191id.decode);
        }
    }
}
