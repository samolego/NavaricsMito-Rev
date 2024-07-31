package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.opencv.android.CameraGLSurfaceView;

@TargetApi(15)
/* renamed from: org.opencv.android.b */
/* loaded from: classes2.dex */
public abstract class CameraGLRendererBase implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {

    /* renamed from: B */
    private int f12449B;

    /* renamed from: C */
    private int f12450C;

    /* renamed from: D */
    private int f12451D;

    /* renamed from: E */
    private int f12452E;

    /* renamed from: F */
    private FloatBuffer f12453F;

    /* renamed from: G */
    private FloatBuffer f12454G;

    /* renamed from: H */
    private FloatBuffer f12455H;

    /* renamed from: j */
    protected SurfaceTexture f12465j;

    /* renamed from: p */
    protected CameraGLSurfaceView f12471p;

    /* renamed from: b */
    protected final String f12457b = "CameraGLRendererBase";

    /* renamed from: a */
    private final String f12456a = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}";

    /* renamed from: q */
    private final String f12472q = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";

    /* renamed from: r */
    private final String f12473r = "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";

    /* renamed from: s */
    private final float[] f12474s = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: t */
    private final float[] f12475t = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: u */
    private final float[] f12476u = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: v */
    private int[] f12477v = {0};

    /* renamed from: w */
    private int[] f12478w = {0};

    /* renamed from: x */
    private int[] f12479x = {0};

    /* renamed from: y */
    private int[] f12480y = {0};

    /* renamed from: z */
    private int f12481z = -1;

    /* renamed from: A */
    private int f12448A = -1;

    /* renamed from: c */
    protected int f12458c = -1;

    /* renamed from: d */
    protected int f12459d = -1;

    /* renamed from: e */
    protected int f12460e = -1;

    /* renamed from: f */
    protected int f12461f = -1;

    /* renamed from: g */
    protected int f12462g = -1;

    /* renamed from: h */
    protected int f12463h = -1;

    /* renamed from: i */
    protected int f12464i = -1;

    /* renamed from: k */
    protected boolean f12466k = false;

    /* renamed from: l */
    protected boolean f12467l = false;

    /* renamed from: m */
    protected boolean f12468m = false;

    /* renamed from: n */
    protected boolean f12469n = true;

    /* renamed from: o */
    protected boolean f12470o = false;

    /* renamed from: a */
    protected abstract void mo310a(int i);

    /* renamed from: b */
    protected abstract void mo309b(int i, int i2);

    /* renamed from: c */
    protected abstract void mo308c();

    public CameraGLRendererBase(CameraGLSurfaceView cameraGLSurfaceView) {
        this.f12471p = cameraGLSurfaceView;
        int length = (this.f12474s.length * 32) / 8;
        this.f12453F = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f12454G = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f12455H = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f12453F.put(this.f12474s).position(0);
        this.f12454G.put(this.f12475t).position(0);
        this.f12455H.put(this.f12476u).position(0);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f12468m = true;
        this.f12471p.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.f12467l) {
            synchronized (this) {
                if (this.f12468m) {
                    this.f12465j.updateTexImage();
                    this.f12468m = false;
                }
                GLES20.glClear(16384);
                CameraGLSurfaceView.InterfaceC3145a cameraTextureListener = this.f12471p.getCameraTextureListener();
                if (cameraTextureListener != null) {
                    m326a(this.f12477v[0], true, this.f12480y[0]);
                    if (cameraTextureListener.m365a(this.f12478w[0], this.f12479x[0], this.f12458c, this.f12459d)) {
                        m326a(this.f12479x[0], false, 0);
                    } else {
                        m326a(this.f12478w[0], false, 0);
                    }
                } else {
                    Log.d("CameraGLRendererBase", "texCamera(OES) -> screen");
                    m326a(this.f12477v[0], true, 0);
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.i("CameraGLRendererBase", "onSurfaceChanged(" + i + "x" + i2 + ")");
        this.f12466k = true;
        m317f();
        m320c(i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i("CameraGLRendererBase", "onSurfaceCreated");
        m314i();
    }

    /* renamed from: i */
    private void m314i() {
        String glGetString = GLES20.glGetString(7938);
        if (glGetString != null) {
            Log.i("CameraGLRendererBase", "OpenGL ES version: " + glGetString);
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.f12481z = m325a("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.f12449B = GLES20.glGetAttribLocation(this.f12481z, "vPosition");
        this.f12450C = GLES20.glGetAttribLocation(this.f12481z, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.f12449B);
        GLES20.glEnableVertexAttribArray(this.f12450C);
        this.f12448A = m325a("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.f12451D = GLES20.glGetAttribLocation(this.f12448A, "vPosition");
        this.f12452E = GLES20.glGetAttribLocation(this.f12448A, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.f12451D);
        GLES20.glEnableVertexAttribArray(this.f12452E);
    }

    /* renamed from: j */
    private void m313j() {
        Log.d("CameraGLRendererBase", "initSurfaceTexture");
        m312k();
        m324a(this.f12477v);
        this.f12465j = new SurfaceTexture(this.f12477v[0]);
        this.f12465j.setOnFrameAvailableListener(this);
    }

    /* renamed from: k */
    private void m312k() {
        Log.d("CameraGLRendererBase", "deleteSurfaceTexture");
        SurfaceTexture surfaceTexture = this.f12465j;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f12465j = null;
            m321b(this.f12477v);
        }
    }

    /* renamed from: a */
    private void m324a(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glTexParameteri(36197, 10241, 9728);
            GLES20.glTexParameteri(36197, 10240, 9728);
        }
    }

    /* renamed from: b */
    private static void m321b(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    /* renamed from: a */
    private static int m325a(String str, String str2) {
        Log.d("CameraGLRendererBase", "loadShader");
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile vertex shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile fragment shader:" + GLES20.glGetShaderInfoLog(glCreateShader2));
            GLES20.glDeleteShader(glCreateShader);
            GLES20.glDeleteShader(glCreateShader2);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not link shader program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            return 0;
        }
        GLES20.glValidateProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35715, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Shader program validation error: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        Log.d("CameraGLRendererBase", "Shader program is built OK");
        return glCreateProgram;
    }

    /* renamed from: l */
    private void m311l() {
        Log.d("CameraGLRendererBase", "deleteFBO(" + this.f12460e + "x" + this.f12461f + ")");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, this.f12480y, 0);
        m321b(this.f12478w);
        m321b(this.f12479x);
        this.f12461f = 0;
        this.f12460e = 0;
    }

    /* renamed from: a */
    private void m327a(int i, int i2) {
        Log.d("CameraGLRendererBase", "initFBO(" + i + "x" + i2 + ")");
        m311l();
        GLES20.glGenTextures(1, this.f12479x, 0);
        GLES20.glBindTexture(3553, this.f12479x[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenTextures(1, this.f12478w, 0);
        GLES20.glBindTexture(3553, this.f12478w[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenFramebuffers(1, this.f12480y, 0);
        GLES20.glBindFramebuffer(36160, this.f12480y[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f12478w[0], 0);
        Log.d("CameraGLRendererBase", "initFBO error status: " + GLES20.glGetError());
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            Log.e("CameraGLRendererBase", "initFBO failed, status: " + glCheckFramebufferStatus);
        }
        this.f12460e = i;
        this.f12461f = i2;
    }

    /* renamed from: a */
    private void m326a(int i, boolean z, int i2) {
        GLES20.glBindFramebuffer(36160, i2);
        if (i2 == 0) {
            GLES20.glViewport(0, 0, this.f12471p.getWidth(), this.f12471p.getHeight());
        } else {
            GLES20.glViewport(0, 0, this.f12460e, this.f12461f);
        }
        GLES20.glClear(16384);
        if (z) {
            GLES20.glUseProgram(this.f12481z);
            GLES20.glVertexAttribPointer(this.f12449B, 2, 5126, false, 8, (Buffer) this.f12453F);
            GLES20.glVertexAttribPointer(this.f12450C, 2, 5126, false, 8, (Buffer) this.f12454G);
        } else {
            GLES20.glUseProgram(this.f12448A);
            GLES20.glVertexAttribPointer(this.f12451D, 2, 5126, false, 8, (Buffer) this.f12453F);
            GLES20.glVertexAttribPointer(this.f12452E, 2, 5126, false, 8, (Buffer) this.f12455H);
        }
        GLES20.glActiveTexture(33984);
        if (z) {
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f12481z, "sTexture"), 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f12448A, "sTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    /* renamed from: d */
    public synchronized void m319d() {
        Log.d("CameraGLRendererBase", "enableView");
        this.f12469n = true;
        m317f();
    }

    /* renamed from: e */
    public synchronized void m318e() {
        Log.d("CameraGLRendererBase", "disableView");
        this.f12469n = false;
        m317f();
    }

    /* renamed from: f */
    protected void m317f() {
        Log.d("CameraGLRendererBase", "updateState");
        Log.d("CameraGLRendererBase", "mEnabled=" + this.f12469n + ", mHaveSurface=" + this.f12466k);
        boolean z = this.f12469n && this.f12466k && this.f12471p.getVisibility() == 0;
        if (z == this.f12470o) {
            Log.d("CameraGLRendererBase", "keeping State unchanged");
        } else if (z) {
            mo328a();
        } else {
            mo323b();
        }
        Log.d("CameraGLRendererBase", "updateState end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo328a() {
        Log.d("CameraGLRendererBase", "doStart");
        m313j();
        mo310a(this.f12464i);
        this.f12470o = true;
        if (this.f12458c > 0 && this.f12459d > 0) {
            m320c(this.f12458c, this.f12459d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo323b() {
        Log.d("CameraGLRendererBase", "doStop");
        synchronized (this) {
            this.f12468m = false;
            this.f12470o = false;
            this.f12467l = false;
            mo308c();
            m312k();
        }
        CameraGLSurfaceView.InterfaceC3145a cameraTextureListener = this.f12471p.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.m367a();
        }
    }

    /* renamed from: c */
    protected void m320c(int i, int i2) {
        synchronized (this) {
            this.f12467l = false;
            this.f12458c = i;
            this.f12459d = i2;
            mo309b(i, i2);
            m327a(this.f12458c, this.f12459d);
            this.f12467l = true;
        }
        CameraGLSurfaceView.InterfaceC3145a cameraTextureListener = this.f12471p.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.m366a(this.f12458c, this.f12459d);
        }
    }

    /* renamed from: b */
    public void m322b(int i) {
        m318e();
        this.f12464i = i;
        m319d();
    }

    /* renamed from: g */
    public void m316g() {
        Log.i("CameraGLRendererBase", "onResume");
    }

    /* renamed from: h */
    public void m315h() {
        Log.i("CameraGLRendererBase", "onPause");
        this.f12466k = false;
        m317f();
        this.f12459d = -1;
        this.f12458c = -1;
    }
}
