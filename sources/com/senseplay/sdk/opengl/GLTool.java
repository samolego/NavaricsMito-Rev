package com.senseplay.sdk.opengl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class GLTool implements SurfaceTexture.OnFrameAvailableListener {
    private static GLTool glTool;
    public int fbo;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private int mProgram;
    public volatile EGLConfig mSharedEglConfig;
    public volatile EGLContext mSharedEglContext;
    private FloatBuffer mTexBuffer;
    private int mTextureLocation;
    private FloatBuffer mVerBuffer;
    private int mVertexLocation;
    public SurfaceTexture sftex;
    public Surface surface;
    GLUpdateThread updateThread;
    public ByteBuffer uv_buf;
    public ByteBuffer y_buf;
    private int glVersion = 5;
    public int width = 1280;
    public int height = 720;
    public int blockHeight = 0;
    public boolean isResChanged = false;
    public final ExecutorService mJavaThread = Executors.newSingleThreadExecutor();
    private float[] verCrood = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    private float[] texCrood = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    public static GLTool Instance() {
        if (glTool == null) {
            synchronized (GLTool.class) {
                if (glTool == null) {
                    glTool = new GLTool();
                }
            }
        }
        return glTool;
    }

    public void setCommon(int i, int i2, int i3) {
        this.glVersion = i;
        this.width = i2;
        this.height = i3;
    }

    public boolean getUnityEGL() {
        this.mSharedEglContext = EGL14.eglGetCurrentContext();
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglGetConfigs(EGL14.eglGetCurrentDisplay(), eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            Log.e("unity", "eglGetConfigs failed");
            return false;
        }
        this.mSharedEglConfig = eGLConfigArr[0];
        return true;
    }

    public void initJavaGLEnv(final EGLContext eGLContext, final EGLConfig eGLConfig) {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.1
            @Override // java.lang.Runnable
            public void run() {
                GLTool.this.mEglDisplay = EGL14.eglGetDisplay(0);
                if (GLTool.this.mEglDisplay == EGL14.EGL_NO_DISPLAY) {
                    Log.e("unity", "unable to get EGL14 display");
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(GLTool.this.mEglDisplay, iArr, 0, iArr, 1)) {
                    GLTool.this.mEglDisplay = null;
                    Log.e("unity", "unable to initialize EGL14");
                }
                int i = GLTool.this.glVersion == 5 ? 2 : 3;
                Log.w("unity", "OpenGL版本:" + i + "");
                GLTool gLTool = GLTool.this;
                gLTool.mEglContext = EGL14.eglCreateContext(gLTool.mEglDisplay, eGLConfig, eGLContext, new int[]{12440, i, 12344}, 0);
                if (GLTool.this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                    Log.e("unity", "no EGL CONTEXT");
                }
                GLTool gLTool2 = GLTool.this;
                gLTool2.mEglSurface = EGL14.eglCreatePbufferSurface(gLTool2.mEglDisplay, GLTool.this.mSharedEglConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
                if (GLTool.this.mEglSurface == EGL14.EGL_NO_SURFACE) {
                    Log.e("unity", "create egl pb surface failed");
                }
                if (!EGL14.eglMakeCurrent(GLTool.this.mEglDisplay, GLTool.this.mEglSurface, GLTool.this.mEglSurface, GLTool.this.mEglContext)) {
                    Log.e("unity", "eglMakeCurrent failed");
                }
                GLES20.glFlush();
                Log.w("unity", "GL Init Finished");
            }
        });
    }

    public boolean genProgram() {
        this.mProgram = GLES20.glCreateProgram();
        GLShader.applyShader(this.glVersion, 35633, GLShader.VERTEX_SHADER_STRING(), this.mProgram);
        GLShader.applyShader(this.glVersion, 35632, GLShader.FRAGMENT_SHADER_STRING(), this.mProgram);
        GLES20.glLinkProgram(this.mProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(this.mProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("unity", "Could not link program:" + GLES20.glGetProgramInfoLog(this.mProgram));
            return false;
        }
        GLES20.glUseProgram(this.mProgram);
        this.mVertexLocation = GLES20.glGetAttribLocation(this.mProgram, "in_pos");
        this.mTextureLocation = GLES20.glGetAttribLocation(this.mProgram, "in_tc");
        Log.w("unity", "program has created");
        return true;
    }

    public int genGLTex() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("unity", "genTex failed");
            return 0;
        }
        Log.w("unity", "allocate texid:" + iArr[0]);
        return iArr[0];
    }

    public void createAlpha8Tex(final int i, final ByteBuffer byteBuffer, final int i2, final int i3, final boolean z) {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.2
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(z ? 33985 : 33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glTexImage2D(3553, 0, z ? 6410 : 6409, i2, i3, 0, z ? 6410 : 6409, 5121, byteBuffer);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
            }
        });
    }

    public void updateAlpha8Tex(final int i, final ByteBuffer byteBuffer, final int i2, final int i3, final boolean z) {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(z ? 33985 : 33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, z ? 6410 : 6409, 5121, byteBuffer);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
            }
        });
    }

    public void createRGBTex(final int i, final ByteBuffer byteBuffer, final int i2, final int i3) {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.4
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glTexImage2D(3553, 0, 6407, i2, i3, 0, 6407, 5121, byteBuffer);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
            }
        });
    }

    public void setOESTex(final int i) {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.5
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, i);
                GLES20.glTexParameteri(36197, 10241, 9729);
                GLES20.glTexParameteri(36197, 10240, 9729);
                GLES20.glTexParameteri(36197, 10242, 33071);
                GLES20.glTexParameteri(36197, 10243, 33071);
            }
        });
    }

    public int genFBO() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        Log.w("unity", "fbo generate:" + iArr[0]);
        return iArr[0];
    }

    public void bindFBO(final int i, final int i2) {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.6
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glBindFramebuffer(36160, i);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
                    Log.e("unity", "bind fbo error");
                }
                GLES20.glBindFramebuffer(36160, 0);
            }
        });
    }

    public void renderToFBO() {
        this.mJavaThread.execute(new Runnable() { // from class: com.senseplay.sdk.opengl.GLTool.7
            @Override // java.lang.Runnable
            public void run() {
                if (GLTool.this.getSftex() != null) {
                    GLTool.this.getSftex().updateTexImage();
                }
                UnityJavaBridge Instance = UnityJavaBridge.Instance();
                GLES20.glBindFramebuffer(36160, GLTool.this.fbo);
                GLES20.glUseProgram(GLTool.this.mProgram);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, Instance.videoIDs[0]);
                GLES20.glUniform1i(GLES20.glGetUniformLocation(GLTool.this.mProgram, "s_texture"), 0);
                GLES20.glViewport(0, 0, GLTool.this.width, GLTool.this.height);
                GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glEnableVertexAttribArray(GLTool.this.mVertexLocation);
                GLTool.this.getVerBuffer().put(GLTool.this.verCrood);
                GLTool.this.getVerBuffer().position(0);
                GLES20.glVertexAttribPointer(GLTool.this.mVertexLocation, 2, 5126, false, 0, (Buffer) GLTool.this.getVerBuffer());
                GLES20.glEnableVertexAttribArray(GLTool.this.mTextureLocation);
                GLTool.this.getTexBuffer().put(GLTool.this.texCrood);
                GLTool.this.getTexBuffer().position(0);
                GLES20.glVertexAttribPointer(GLTool.this.mTextureLocation, 2, 5126, false, 0, (Buffer) GLTool.this.getTexBuffer());
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(GLTool.this.mVertexLocation);
                GLES20.glDisableVertexAttribArray(GLTool.this.mTextureLocation);
                GLES20.glFinish();
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glClear(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatBuffer getVerBuffer() {
        if (this.mVerBuffer == null) {
            this.mVerBuffer = ByteBuffer.allocateDirect(this.verCrood.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        return this.mVerBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatBuffer getTexBuffer() {
        if (this.mTexBuffer == null) {
            this.mTexBuffer = ByteBuffer.allocateDirect(this.texCrood.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        return this.mTexBuffer;
    }

    public boolean checkResChanged(ByteBuffer byteBuffer) {
        if (this.width * this.height * 1.5d != byteBuffer.remaining()) {
            this.height = (int) Math.sqrt((byteBuffer.remaining() * 9) / 24);
            this.width = (this.height * 16) / 9;
            int i = this.width;
            if (i % 32 != 0) {
                this.width = (i / 32) * 32;
                int remaining = (int) (byteBuffer.remaining() / 1.5d);
                int i2 = this.width;
                int i3 = remaining / i2;
                this.blockHeight = i3 - ((i2 * 9) / 16);
                this.height = i3 - this.blockHeight;
            }
            Log.w("unity", "ResChanged: Width = " + this.width + " -- Height = " + this.height);
            this.isResChanged = true;
            this.y_buf = ByteBuffer.allocate(this.width * this.height);
            this.uv_buf = ByteBuffer.allocate((this.width * this.height) / 2);
            return true;
        }
        return false;
    }

    public SurfaceTexture getSftex() {
        if (this.sftex == null) {
            this.sftex = new SurfaceTexture(UnityJavaBridge.Instance().videoIDs[0]);
            this.sftex.setOnFrameAvailableListener(this);
            this.sftex.setDefaultBufferSize(this.width, this.height);
            Log.w("unity", "SurfaceTexture is :" + Instance().width + "," + Instance().height + "+ id =" + UnityJavaBridge.Instance().videoIDs[0]);
        }
        return this.sftex;
    }

    public Surface getSurface() {
        if (this.surface == null) {
            this.surface = new Surface(getSftex());
            Log.w("unity", "Surface is null,create!");
        }
        return this.surface;
    }
}
