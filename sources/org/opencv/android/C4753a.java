package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
/* renamed from: org.opencv.android.a */
/* loaded from: classes2.dex */
public class Camera2Renderer extends CameraGLRendererBase {

    /* renamed from: a */
    protected final String f12436a;

    /* renamed from: q */
    private CameraDevice f12437q;

    /* renamed from: r */
    private CameraCaptureSession f12438r;

    /* renamed from: s */
    private CaptureRequest.Builder f12439s;

    /* renamed from: t */
    private String f12440t;

    /* renamed from: u */
    private Size f12441u;

    /* renamed from: v */
    private HandlerThread f12442v;

    /* renamed from: w */
    private Handler f12443w;

    /* renamed from: x */
    private Semaphore f12444x;

    /* renamed from: y */
    private final CameraDevice.StateCallback f12445y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2Renderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.f12436a = "Camera2Renderer";
        this.f12441u = new Size(-1, -1);
        this.f12444x = new Semaphore(1);
        this.f12445y = new CameraDevice.StateCallback() { // from class: org.opencv.android.a.1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                Camera2Renderer.this.f12437q = cameraDevice;
                Camera2Renderer.this.f12444x.release();
                Camera2Renderer.this.m331i();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                cameraDevice.close();
                Camera2Renderer.this.f12437q = null;
                Camera2Renderer.this.f12444x.release();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i) {
                cameraDevice.close();
                Camera2Renderer.this.f12437q = null;
                Camera2Renderer.this.f12444x.release();
            }
        };
    }

    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: a */
    protected void mo328a() {
        Log.d("Camera2Renderer", "doStart");
        m330j();
        super.mo328a();
    }

    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: b */
    protected void mo323b() {
        Log.d("Camera2Renderer", "doStop");
        super.mo323b();
        m329k();
    }

    /* renamed from: a */
    boolean m339a(int i, int i2) {
        Size[] outputSizes;
        Log.i("Camera2Renderer", "cacPreviewSize: " + i + "x" + i2);
        if (this.f12440t == null) {
            Log.e("Camera2Renderer", "Camera isn't initialized!");
            return false;
        }
        try {
            float f = i / i2;
            int i3 = 0;
            int i4 = 0;
            for (Size size : ((StreamConfigurationMap) ((CameraManager) this.f12471p.getContext().getSystemService("camera")).getCameraCharacteristics(this.f12440t).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                Log.d("Camera2Renderer", "trying size: " + width + "x" + height);
                if (i >= width && i2 >= height && i3 <= width && i4 <= height && Math.abs(f - (width / height)) < 0.2d) {
                    i4 = height;
                    i3 = width;
                }
            }
            Log.i("Camera2Renderer", "best size: " + i3 + "x" + i4);
            if (i3 != 0 && i4 != 0 && (this.f12441u.getWidth() != i3 || this.f12441u.getHeight() != i4)) {
                this.f12441u = new Size(i3, i4);
                return true;
            }
            return false;
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "cacPreviewSize - Camera Access Exception");
            return false;
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "cacPreviewSize - Illegal Argument Exception");
            return false;
        } catch (SecurityException unused3) {
            Log.e("Camera2Renderer", "cacPreviewSize - Security Exception");
            return false;
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: a */
    protected void mo310a(int i) {
        Log.i("Camera2Renderer", "openCamera");
        CameraManager cameraManager = (CameraManager) this.f12471p.getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("Camera2Renderer", "Error: camera isn't detected.");
                return;
            }
            if (i == -1) {
                this.f12440t = cameraIdList[0];
            } else {
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if ((i == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (i == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                        this.f12440t = str;
                        break;
                    }
                }
            }
            if (this.f12440t != null) {
                if (!this.f12444x.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                    throw new RuntimeException("Time out waiting to lock camera opening.");
                }
                Log.i("Camera2Renderer", "Opening camera: " + this.f12440t);
                cameraManager.openCamera(this.f12440t, this.f12445y, this.f12443w);
            }
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "OpenCamera - Camera Access Exception");
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "OpenCamera - Illegal Argument Exception");
        } catch (InterruptedException unused3) {
            Log.e("Camera2Renderer", "OpenCamera - Interrupted Exception");
        } catch (SecurityException unused4) {
            Log.e("Camera2Renderer", "OpenCamera - Security Exception");
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: c */
    protected void mo308c() {
        Log.i("Camera2Renderer", "closeCamera");
        try {
            try {
                this.f12444x.acquire();
                if (this.f12438r != null) {
                    this.f12438r.close();
                    this.f12438r = null;
                }
                if (this.f12437q != null) {
                    this.f12437q.close();
                    this.f12437q = null;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
            }
        } finally {
            this.f12444x.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m331i() {
        int width = this.f12441u.getWidth();
        int height = this.f12441u.getHeight();
        Log.i("Camera2Renderer", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0) {
            if (height < 0) {
                return;
            }
            try {
                this.f12444x.acquire();
                if (this.f12437q == null) {
                    this.f12444x.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: camera isn't opened");
                } else if (this.f12438r != null) {
                    this.f12444x.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: mCaptureSession is already started");
                } else if (this.f12465j == null) {
                    this.f12444x.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: preview SurfaceTexture is null");
                } else {
                    this.f12465j.setDefaultBufferSize(width, height);
                    Surface surface = new Surface(this.f12465j);
                    this.f12439s = this.f12437q.createCaptureRequest(1);
                    this.f12439s.addTarget(surface);
                    this.f12437q.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() { // from class: org.opencv.android.a.2
                        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            Camera2Renderer.this.f12438r = cameraCaptureSession;
                            try {
                                Camera2Renderer.this.f12439s.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                Camera2Renderer.this.f12439s.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                Camera2Renderer.this.f12438r.setRepeatingRequest(Camera2Renderer.this.f12439s.build(), null, Camera2Renderer.this.f12443w);
                                Log.i("Camera2Renderer", "CameraPreviewSession has been started");
                            } catch (CameraAccessException unused) {
                                Log.e("Camera2Renderer", "createCaptureSession failed");
                            }
                            Camera2Renderer.this.f12444x.release();
                        }

                        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Log.e("Camera2Renderer", "createCameraPreviewSession failed");
                            Camera2Renderer.this.f12444x.release();
                        }
                    }, this.f12443w);
                }
            } catch (CameraAccessException unused) {
                Log.e("Camera2Renderer", "createCameraPreviewSession");
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while createCameraPreviewSession", e);
            }
        }
    }

    /* renamed from: j */
    private void m330j() {
        Log.i("Camera2Renderer", "startBackgroundThread");
        m329k();
        this.f12442v = new HandlerThread("CameraBackground");
        this.f12442v.start();
        this.f12443w = new Handler(this.f12442v.getLooper());
    }

    /* renamed from: k */
    private void m329k() {
        Log.i("Camera2Renderer", "stopBackgroundThread");
        HandlerThread handlerThread = this.f12442v;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        try {
            this.f12442v.join();
            this.f12442v = null;
            this.f12443w = null;
        } catch (InterruptedException unused) {
            Log.e("Camera2Renderer", "stopBackgroundThread");
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    /* renamed from: b */
    protected void mo309b(int i, int i2) {
        Log.i("Camera2Renderer", "setCameraPreviewSize(" + i + "x" + i2 + ")");
        if (this.f12462g > 0 && this.f12462g < i) {
            i = this.f12462g;
        }
        if (this.f12463h > 0 && this.f12463h < i2) {
            i2 = this.f12463h;
        }
        try {
            this.f12444x.acquire();
            boolean m339a = m339a(i, i2);
            this.f12458c = this.f12441u.getWidth();
            this.f12459d = this.f12441u.getHeight();
            if (!m339a) {
                this.f12444x.release();
                return;
            }
            if (this.f12438r != null) {
                Log.d("Camera2Renderer", "closing existing previewSession");
                this.f12438r.close();
                this.f12438r = null;
            }
            this.f12444x.release();
            m331i();
        } catch (InterruptedException e) {
            this.f12444x.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }
}
