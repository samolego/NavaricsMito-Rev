package com.navatics.p057cv.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import com.navatics.p057cv.p058a.NAVideoFrameYUV;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.navatics.cv.filters.VividXRenderView2 */
/* loaded from: classes.dex */
public class VividXRenderView2 extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: g */
    private static final String f5854g = "VividXRenderView2";

    /* renamed from: h */
    private static float[] f5855h = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: i */
    private static float[] f5856i = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: a */
    int f5857a;

    /* renamed from: b */
    Bitmap f5858b;

    /* renamed from: c */
    int f5859c;

    /* renamed from: d */
    int f5860d;

    /* renamed from: e */
    int f5861e;

    /* renamed from: f */
    VividXRender f5862f;

    public VividXRenderView2(Context context) {
        super(context);
        m6831a();
    }

    public VividXRenderView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6831a();
    }

    /* renamed from: a */
    private void m6831a() {
        setEGLContextClientVersion(3);
        setRenderer(this);
        setRenderMode(0);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f5858b = bitmap;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f5857a = m6827a("attribute vec4 vPosition;                  \nattribute vec2 vCoordinate;                \nvarying vec2 aCoordinate;                  \n\nvoid main(){                               \n   gl_Position=vPosition;                  \n   aCoordinate=vCoordinate;                \n}                                          \n", "uniform sampler2D vTexture;                        \nvarying vec2 aCoordinate;                          \n\nvoid main(){                                       \n    gl_FragColor=texture2D(vTexture,aCoordinate);  \n}                                                  \n");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f5859c = iArr[0];
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f5860d = i;
        this.f5861e = i2;
        this.f5862f = new VividXRender(i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Bitmap bitmap = this.f5858b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        m6830a(this.f5862f.m6824a(m6828a(NAVideoFrameYUV.m6850a(this.f5858b))));
    }

    /* renamed from: a */
    private void m6830a(int i) {
        GLES20.glUseProgram(this.f5857a);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f5860d, this.f5861e);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f5857a, "vTexture"), 0);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, (Buffer) m6826a(f5855h));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6826a(f5856i));
        GLES20.glDrawArrays(6, 0, 4);
    }

    /* renamed from: a */
    private int m6828a(NAVideoFrameYUV nAVideoFrameYUV) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f5859c);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        GLUtils.texImage2D(3553, 0, nAVideoFrameYUV.m6851a(), 0);
        return this.f5859c;
    }

    /* renamed from: a */
    private FloatBuffer m6826a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    private int m6827a(String str, String str2) {
        int m6829a = m6829a(35633, str);
        int m6829a2 = m6829a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, m6829a);
        GLES20.glAttachShader(glCreateProgram, m6829a2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glValidateProgram(glCreateProgram);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGetProgramiv(glCreateProgram, 35714, allocate);
        if (allocate.get() != 0) {
            return glCreateProgram;
        }
        String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
        throw new IllegalStateException("gl program validation failed : " + glGetProgramInfoLog);
    }

    /* renamed from: a */
    private int m6829a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }
}
