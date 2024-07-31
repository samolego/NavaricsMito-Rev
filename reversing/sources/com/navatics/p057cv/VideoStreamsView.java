package com.navatics.p057cv;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.navatics.cv.VideoStreamsView */
/* loaded from: classes.dex */
public class VideoStreamsView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: f */
    private static final FloatBuffer f5793f = m6856a(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* renamed from: g */
    private static final FloatBuffer f5794g = m6856a(new float[]{0.6f, 0.9f, 0.6f, 0.6f, 0.9f, 0.9f, 0.9f, 0.6f});

    /* renamed from: h */
    private static final FloatBuffer f5795h = m6856a(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});

    /* renamed from: a */
    private Point f5796a;

    /* renamed from: b */
    private int[][] f5797b;

    /* renamed from: c */
    private int f5798c;

    /* renamed from: d */
    private long f5799d;

    /* renamed from: e */
    private long f5800e;

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f5796a.x, this.f5796a.y);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        m6859a();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        long j;
        GLES20.glClear(16384);
        m6855a(this.f5797b[1], f5793f);
        m6855a(this.f5797b[0], f5794g);
        this.f5800e++;
        long nanoTime = System.nanoTime();
        if (this.f5799d == -1 || nanoTime - j > 1.0E9d) {
            Log.d("VideoStreamsView", "Rendered FPS: " + (this.f5800e / ((nanoTime - this.f5799d) / 1.0E9d)));
            this.f5799d = nanoTime;
            this.f5800e = 1L;
        }
        m6859a();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int glCreateProgram = GLES20.glCreateProgram();
        m6858a(35633, "varying vec2 interp_tc;\n\nattribute vec4 in_pos;\nattribute vec2 in_tc;\n\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n", glCreateProgram);
        m6858a(35632, "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - .5;\n  float v = texture2D(v_tex, interp_tc).r - .5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n", glCreateProgram);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        iArr[0] = 0;
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        m6857a(iArr[0] == 1, GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(glCreateProgram, "y_tex"), 0);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(glCreateProgram, "u_tex"), 1);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(glCreateProgram, "v_tex"), 2);
        this.f5798c = GLES20.glGetAttribLocation(glCreateProgram, "in_pos");
        int glGetAttribLocation = GLES20.glGetAttribLocation(glCreateProgram, "in_tc");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) f5795h);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        m6859a();
    }

    /* renamed from: a */
    private static FloatBuffer m6856a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.flip();
        return asFloatBuffer;
    }

    /* renamed from: a */
    private void m6855a(int[] iArr, FloatBuffer floatBuffer) {
        for (int i = 0; i < 3; i++) {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, iArr[i]);
        }
        GLES20.glVertexAttribPointer(this.f5798c, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f5798c);
        GLES20.glDrawArrays(5, 0, 4);
        m6859a();
    }

    /* renamed from: a */
    private static void m6858a(int i, String str, int i2) {
        int[] iArr = {0};
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        boolean z = iArr[0] == 1;
        m6857a(z, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i2, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        m6859a();
    }

    /* renamed from: a */
    private static void m6857a(boolean z, String str) {
        if (!z) {
            throw new RuntimeException(str);
        }
    }

    /* renamed from: a */
    private static void m6859a() {
        int glGetError = GLES20.glGetError();
        boolean z = glGetError == 0;
        m6857a(z, "GLES20 error: " + glGetError);
    }
}
