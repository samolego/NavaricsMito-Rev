package com.navatics.p057cv.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import com.navatics.p057cv.p058a.CGSize;
import com.navatics.p057cv.p058a.FBOStruct;
import com.navatics.p057cv.p058a.NAVideoFrameYUV;
import com.navatics.xlog.WLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.navatics.cv.filters.VividXRenderView */
/* loaded from: classes.dex */
public class VividXRenderView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: M */
    private static final String f5811M = "VividXRenderView";

    /* renamed from: N */
    private static final float[] f5812N = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: O */
    private static final float[] f5813O = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: P */
    private static float[] f5814P = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: Q */
    private static float[] f5815Q = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: A */
    int f5816A;

    /* renamed from: B */
    int f5817B;

    /* renamed from: C */
    int f5818C;

    /* renamed from: D */
    int f5819D;

    /* renamed from: E */
    int f5820E;

    /* renamed from: F */
    int f5821F;

    /* renamed from: G */
    int f5822G;

    /* renamed from: H */
    int f5823H;

    /* renamed from: I */
    int f5824I;

    /* renamed from: J */
    Bitmap f5825J;

    /* renamed from: K */
    int f5826K;

    /* renamed from: L */
    int f5827L;

    /* renamed from: a */
    CGSize f5828a;

    /* renamed from: b */
    int f5829b;

    /* renamed from: c */
    int f5830c;

    /* renamed from: d */
    int f5831d;

    /* renamed from: e */
    int f5832e;

    /* renamed from: f */
    int f5833f;

    /* renamed from: g */
    int f5834g;

    /* renamed from: h */
    int f5835h;

    /* renamed from: i */
    int f5836i;

    /* renamed from: j */
    int f5837j;

    /* renamed from: k */
    int f5838k;

    /* renamed from: l */
    int f5839l;

    /* renamed from: m */
    int f5840m;

    /* renamed from: n */
    int f5841n;

    /* renamed from: o */
    int f5842o;

    /* renamed from: p */
    int[] f5843p;

    /* renamed from: q */
    int f5844q;

    /* renamed from: r */
    int f5845r;

    /* renamed from: s */
    int f5846s;

    /* renamed from: t */
    int f5847t;

    /* renamed from: u */
    int[] f5848u;

    /* renamed from: v */
    int f5849v;

    /* renamed from: w */
    int f5850w;

    /* renamed from: x */
    int f5851x;

    /* renamed from: y */
    int f5852y;

    /* renamed from: z */
    int f5853z;

    public VividXRenderView(Context context) {
        super(context);
        this.f5843p = new int[3];
        this.f5848u = new int[3];
        m6849a();
    }

    public VividXRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5843p = new int[3];
        this.f5848u = new int[3];
        m6849a();
    }

    /* renamed from: a */
    private void m6849a() {
        setEGLContextClientVersion(3);
        setRenderer(this);
        setRenderMode(0);
    }

    /* renamed from: a */
    private String m6839a(String str) {
        String replaceAll = str.replaceAll("yuv2rgbFunctionString", "    vec3 delyuv = vec3(0.0/255.0, -128.0/255.0, -128.0/255.0);\n    mat3 invert_rgb = mat3(1.0, 0.0,    1.402,\n                     1.0, -0.34414, -0.71414,\n                     1.0, 1.772,  0.0);\n    vec3 yuv2rgb(vec3 yuv){\n        yuv += delyuv;\n        return yuv * invert_rgb;\n    }").replaceAll("rgb2labFunctionString", "         vec3 rgb2xyz(vec3 c) {\n         vec3 tmp;\n         tmp.x = (c.r > 0.04045) ? pow((c.r + 0.055) / 1.055, 2.4) : c.r / 12.92;\n         tmp.y = (c.g > 0.04045) ? pow((c.g + 0.055) / 1.055, 2.4) : c.g / 12.92;\n         tmp.z = (c.b > 0.04045) ? pow((c.b + 0.055) / 1.055, 2.4) : c.b / 12.92;\n         return 100.0 * tmp *\n             mat3(0.4124, 0.3576, 0.1805,\n                   0.2126, 0.7152, 0.0722,\n                   0.0193, 0.1192, 0.9505);\n     }\n\n     vec3 xyz2lab(vec3 c) {\n         vec3 n = c / vec3(95.047, 100, 108.883);\n         vec3 v;\n         v.x = (n.x > 0.008856) ? pow(n.x, 1.0 / 3.0) : (7.787 * n.x) + (16.0 / 116.0);\n         v.y = (n.y > 0.008856) ? pow(n.y, 1.0 / 3.0) : (7.787 * n.y) + (16.0 / 116.0);\n         v.z = (n.z > 0.008856) ? pow(n.z, 1.0 / 3.0) : (7.787 * n.z) + (16.0 / 116.0);\n         return vec3((116.0 * v.y) - 16.0, 500.0 * (v.x - v.y), 200.0 * (v.y - v.z));\n     }\n     vec3 rgb2lab(vec3 c) {\n         vec3 lab = xyz2lab(rgb2xyz(c));\n         return vec3(lab.x / 100.0, 0.5 + 0.5 * (lab.y / 127.0), 0.5 + 0.5 * (lab.z / 127.0));\n     }").replaceAll("lab2rgbFunctionString", "     vec3 lab2xyz(vec3 c) {\n         float fy = (c.x + 16.0) / 116.0;\n         float fx = c.y / 500.0 + fy;\n         float fz = fy - c.z / 200.0;\n         return vec3(\n              95.047 * ((fx > 0.206897) ? fx * fx * fx : (fx - 16.0 / 116.0) / 7.787),\n             100.000 * ((fy > 0.206897) ? fy * fy * fy : (fy - 16.0 / 116.0) / 7.787),\n             108.883 * ((fz > 0.206897) ? fz * fz * fz : (fz - 16.0 / 116.0) / 7.787)\n        );\n     }\n\n     vec3 xyz2rgb(vec3 c) {\n         vec3 v =  c / 100.0 * mat3(\n                                    3.2406, -1.5372, -0.4986,\n                                    -0.9689, 1.8758, 0.0415,\n                                    0.0557, -0.2040, 1.0570\n                                    );\n         vec3 r;\n         r.x = (v.r > 0.0031308) ? ((1.055 * pow(v.r, (1.0 / 2.4))) - 0.055) : 12.92 * v.r;\n         r.y = (v.g > 0.0031308) ? ((1.055 * pow(v.g, (1.0 / 2.4))) - 0.055) : 12.92 * v.g;\n         r.z = (v.b > 0.0031308) ? ((1.055 * pow(v.b, (1.0 / 2.4))) - 0.055) : 12.92 * v.b;\n         return r;\n     }\n\n     vec3 lab2rgb(vec3 c) {\n         return xyz2rgb(lab2xyz(vec3(100.0 * c.x, 2.0 * 127.0 * (c.y - 0.5), 2.0 * 127.0 * (c.z - 0.5))));\n     }");
        String str2 = f5811M;
        WLog.m5840w(str2, "\n" + replaceAll);
        return replaceAll;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f5825J = bitmap;
        this.f5829b = bitmap.getWidth();
        this.f5830c = bitmap.getHeight();
        this.f5828a = CGSize.m6852a(this.f5829b, this.f5830c);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        m6842a(this.f5828a);
        GLES20.glBindFramebuffer(36160, this.f5831d);
        this.f5844q = m6838a("    attribute vec4 position;\n    attribute vec2 texcoord;\n\n    uniform float texelWidth;\n    uniform float texelHeight;\n \n    varying float texelW;\n    varying float texelH;\n    varying vec2 upperLeftInputTextureCoordinate;\n    varying vec2 upperRightInputTextureCoordinate;\n    varying vec2 lowerLeftInputTextureCoordinate;\n    varying vec2 lowerRightInputTextureCoordinate;\n\n    void main()\n    {\n        gl_Position = position;\n        texelW = texelWidth;\n        texelH = texelHeight;\n        upperLeftInputTextureCoordinate = texcoord.xy + vec2(-texelWidth, -texelHeight);\n        upperRightInputTextureCoordinate = texcoord.xy + vec2(texelWidth, -texelHeight);\n        lowerLeftInputTextureCoordinate = texcoord.xy + vec2(-texelWidth, texelHeight);\n        lowerRightInputTextureCoordinate = texcoord.xy + vec2(texelWidth, texelHeight);\n    }", "precision highp float;\n\n    uniform sampler2D inputImageTexture;\n    \n    uniform int step; //0/other\n    \n    varying float texelW;\n    varying float texelH;\n    varying highp vec2 upperLeftInputTextureCoordinate;\n    varying highp vec2 upperRightInputTextureCoordinate;\n    varying highp vec2 lowerLeftInputTextureCoordinate;\n    varying highp vec2 lowerRightInputTextureCoordinate;\n\n    void main()\n    {\n        if (step > 0)\n        {\n            vec4 sum_rgba = vec4(0.0, 0.0, 0.0, 0.0);\n            float count = 0.0;\n            for (float x = texelW * 0.5; x < 1.0; x+=texelW)\n            {\n                for (float y = texelH * 0.5; y < 1.0; y+=texelH)\n                {\n                    vec4 rgba = texture2D(inputImageTexture, vec2(x, y));\n                    sum_rgba = sum_rgba + rgba;\n                    count += 1.0;\n                }\n            }\n            gl_FragColor = sum_rgba/count;//vec4(count/255.0, 0.0, 0.0, 0.0);\n        }\n        else\n        {\n            highp vec4 upperLeftColor = texture2D(inputImageTexture, upperLeftInputTextureCoordinate);\n            highp vec4 upperRightColor = texture2D(inputImageTexture, upperRightInputTextureCoordinate);\n            highp vec4 lowerLeftColor = texture2D(inputImageTexture, lowerLeftInputTextureCoordinate);\n            highp vec4 lowerRightColor = texture2D(inputImageTexture, lowerRightInputTextureCoordinate);\n\n            gl_FragColor = 0.25 * (upperLeftColor + upperRightColor + lowerLeftColor + lowerRightColor);\n        }\n    }");
        this.f5845r = m6838a(" attribute vec4 position;\n attribute vec2 texcoord;\n varying vec2 v_texcoord;\n void main()\n {\n     gl_Position = position;\n     v_texcoord = texcoord.xy;\n }", "    precision highp float;\n\n    uniform sampler2D inputImageTexture;\n    varying vec2 v_texcoord;\n    \n    uniform float texelWidth;   //  (1.0/width)\n    uniform float texelHeight;  // (1.0/height)\n    uniform int direction;      //0/1\n    uniform float stepSize;     // 当前方向的步长\n    \n    float unitSize = 16.0;\n    void main()\n    {\n        float n = (direction > 0 ? v_texcoord.x : v_texcoord.y)/stepSize - 0.5;\n        n = fract(n) > 0.5 ? ceil(n) : floor(n);\n        \n        float m;\n        int model = 1; //1:求最大值 0:求最小值\n        if (mod(n, 2.0) == 0.0)\n        {\n            model = 0; //求最小值\n            m = unitSize * n * 0.5;\n        }\n        else\n        {\n            m = unitSize * (n-1.0)*0.5;\n        }\n\n        vec2 point = v_texcoord;\n        float texelSize = direction > 0 ? texelWidth : texelHeight;\n        \n        float start = 0.5 * texelSize + m * texelSize;\n        point.x = direction > 0 ? start : point.x;\n        point.y = direction > 0 ? point.y : start;\n        vec3 rgb = texture2D(inputImageTexture, point).rgb;\n    \n        float maxSize = 1.0 - texelSize * 0.5;\n        for(float i = 1.0; i < unitSize; i=i+1.0)\n        {\n            point.x = direction > 0 ? min(start + texelSize * i, maxSize) : point.x;\n            point.y = direction > 0 ? point.y : min(start + texelSize * i, maxSize);\n            rgb = model == 0 ? min(rgb, texture2D(inputImageTexture, point).rgb) : max(rgb, texture2D(inputImageTexture, point).rgb);\n        }\n        gl_FragColor = vec4(rgb, 1.0);\n        \n    }");
        this.f5846s = m6838a(" attribute vec4 position;\n attribute vec2 texcoord;\n varying vec2 v_texcoord;\n void main()\n {\n     gl_Position = position;\n     v_texcoord = texcoord.xy;\n }", m6839a("    precision highp float;\n    varying vec2 v_texcoord;\n    uniform sampler2D s_texture_y;\n    uniform sampler2D s_texture_u;\n    uniform sampler2D s_texture_v;\n    uniform sampler2D s_texture;\n    uniform sampler2D avg_texture;\n    uniform sampler2D rgbThresholdTexture;\n    uniform sampler2D labThresholdTexture;\n    uniform int step;\n \n    yuv2rgbFunctionString\n    rgb2labFunctionString\n    lab2rgbFunctionString\n \n    void main()\n    {\n        vec3 color_rgb = texture2D(s_texture, v_texcoord).rgb;\n        vec3 avg = texture2D(avg_texture, vec2(0.25, 0.25)).rgb;\n        vec3 max_rgb = texture2D(rgbThresholdTexture, vec2(0.75, 0.75)).rgb;\n        vec3 min_rgb = texture2D(rgbThresholdTexture, vec2(0.25, 0.25)).rgb;\n        max_rgb = max_rgb * 2.0; min_rgb = min_rgb * 2.0;\n        float l_min = texture2D(labThresholdTexture, vec2(0.25, 0.25)).r;\n        float l_max = texture2D(labThresholdTexture, vec2(0.75, 0.75)).r;\n        \n        if (step == 0)\n        {\n            //0.YUV -> RGB\n            vec3 yuv;\n            yuv.x = texture2D(s_texture_y, v_texcoord).r;\n            yuv.y = texture2D(s_texture_u, v_texcoord).r;\n            yuv.z = texture2D(s_texture_v, v_texcoord).r;\n            vec3 color_rgb = yuv2rgb(yuv);\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else if (step == 1)\n        {\n            //1.红色补偿\n            color_rgb.x = color_rgb.x + 1.0 * (avg[1] - avg[0]) * (1.0 - color_rgb.x) * color_rgb.y;\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else if (step == 2)\n        {\n            //2.灰度图均衡化 *0.5\n            float avg_illumination = (avg[0] + avg[1] + avg[2])/3.0;\n            vec3 rgb_factor = vec3(avg_illumination/avg[0], avg_illumination/avg[1], avg_illumination/avg[2]);\n            color_rgb.x = color_rgb.x * rgb_factor[0];\n            color_rgb.y = color_rgb.y * rgb_factor[1];\n            color_rgb.z = color_rgb.z * rgb_factor[2];\n            gl_FragColor = vec4(color_rgb * 0.5, 1.0);\n        }\n        else if (step == 3)\n        {\n            //3.在灰度图上进行颜色校正后转为LAB颜色空间 *2.0\n            mat3 threshold = mat3(min_rgb[0], 1.0/max_rgb[0], 0.0,\n                                  min_rgb[1], 1.0/max_rgb[1], 0.0,\n                                  min_rgb[2], 1.0/max_rgb[2], 0.0\n                                  );\n            color_rgb.x = (color_rgb.x * 2.0 - threshold[0][0])*threshold[0][1];\n            color_rgb.y = (color_rgb.y * 2.0 - threshold[1][0])*threshold[1][1];\n            color_rgb.z = (color_rgb.z * 2.0 - threshold[2][0])*threshold[2][1];\n            vec3 color_lab = rgb2lab(color_rgb);\n            gl_FragColor = vec4(color_lab, 1.0);\n        }\n        else if (step == 4)\n        {\n            //4.亮度修正\n            vec3 color_lab = color_rgb;\n            float l_factor = 0.9/(l_max - l_min);\n            color_lab.x = (color_lab.x - l_min) * l_factor;\n            color_rgb = lab2rgb(color_lab);\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else if (step == 5)\n        {\n            //2.灰度图均衡化\n            float avg_illumination = (avg[0] + avg[1] + avg[2])/3.0;\n            vec3 rgb_factor = vec3(avg_illumination/avg[0], avg_illumination/avg[1], avg_illumination/avg[2]);\n            color_rgb.x = color_rgb.x * rgb_factor[0];\n            color_rgb.y = color_rgb.y * rgb_factor[1];\n            color_rgb.z = color_rgb.z * rgb_factor[2];\n            //3.在灰度图上进行颜色校正后转为LAB颜色空间\n            mat3 threshold = mat3(min_rgb[0], 1.0/max_rgb[0], 0.0,\n                                  min_rgb[1], 1.0/max_rgb[1], 0.0,\n                                  min_rgb[2], 1.0/max_rgb[2], 0.0\n                                  );\n            color_rgb.x = (color_rgb.x - threshold[0][0])*threshold[0][1];\n            color_rgb.y = (color_rgb.y - threshold[1][0])*threshold[1][1];\n            color_rgb.z = (color_rgb.z - threshold[2][0])*threshold[2][1];\n            vec3 color_lab = rgb2lab(color_rgb);\n            //4.亮度修正\n            float l_factor = 0.9/(l_max - l_min);\n            color_lab.x = (color_lab.x - l_min) * l_factor;\n            color_rgb = lab2rgb(color_lab);\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else\n        {\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n    }"));
        this.f5847t = m6838a("attribute vec4 vPosition;                  \nattribute vec2 vCoordinate;                \nvarying vec2 aCoordinate;                  \n\nvoid main(){                               \n   gl_Position=vPosition;                  \n   aCoordinate=vCoordinate;                \n}                                          \n", "uniform sampler2D vTexture;                        \nvarying vec2 aCoordinate;                          \n\nvoid main(){                                       \n    gl_FragColor=texture2D(vTexture,aCoordinate);  \n}                                                  \n");
        getLocation();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f5826K = i;
        this.f5827L = i2;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Bitmap bitmap = this.f5825J;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        NAVideoFrameYUV m6850a = NAVideoFrameYUV.m6850a(this.f5825J);
        long currentTimeMillis = System.currentTimeMillis();
        int m6840a = m6840a(m6850a, false);
        String str = f5811M;
        WLog.m5844i(str, "cost " + (System.currentTimeMillis() - currentTimeMillis));
        m6845a(m6840a, (Bitmap) null);
    }

    /* renamed from: a */
    private String m6848a(byte b) {
        return String.format(" %02x", Byte.valueOf(b));
    }

    /* renamed from: a */
    private void m6846a(int i, int i2, int i3) {
        GLES20.glBindFramebuffer(36160, i);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * i3 * 4);
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, allocateDirect);
        WLog.m5848e(f5811M, "glError : " + GLU.gluErrorString(GLES20.glGetError()));
        String str = "\n";
        for (int i4 = 0; i4 < i3; i4++) {
            String str2 = "[";
            for (int i5 = 0; i5 < i2; i5++) {
                String str3 = "(";
                for (int i6 = 0; i6 < 4; i6++) {
                    str3 = str3 + m6848a(allocateDirect.get());
                }
                str2 = str2 + str3 + "),";
            }
            str = str + str2 + "]\n";
        }
        WLog.m5844i(f5811M, str);
    }

    /* renamed from: a */
    private void m6845a(int i, Bitmap bitmap) {
        GLES20.glUseProgram(this.f5847t);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f5826K, this.f5827L);
        GLES20.glClearColor(1.0f, 1.0f, 0.6f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33984);
        if (bitmap != null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
        } else {
            GLES20.glBindTexture(3553, i);
        }
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        if (bitmap != null) {
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f5847t, "vTexture"), 0);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, (Buffer) m6837a(f5814P));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5815Q));
        GLES20.glDrawArrays(6, 0, 4);
    }

    /* renamed from: a */
    private int m6841a(NAVideoFrameYUV nAVideoFrameYUV) {
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glBindTexture(3553, this.f5832e);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        GLUtils.texImage2D(3553, 0, nAVideoFrameYUV.m6851a(), 0);
        return this.f5832e;
    }

    /* renamed from: a */
    private FloatBuffer m6837a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    private void m6842a(CGSize cGSize) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5831d = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5832e = iArr[0];
        GLES20.glBindTexture(3553, this.f5832e);
        GLES20.glTexImage2D(3553, 0, 6408, cGSize.f5802a, cGSize.f5803b, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5832e, 0);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5833f = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5833f);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5834g = iArr[0];
        GLES20.glBindTexture(3553, this.f5834g);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5834g, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5835h = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5835h);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5836i = iArr[0];
        GLES20.glBindTexture(3553, this.f5836i);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5836i, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5837j = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5837j);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5838k = iArr[0];
        GLES20.glBindTexture(3553, this.f5838k);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5838k, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5839l = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5839l);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5840m = iArr[0];
        GLES20.glBindTexture(3553, this.f5840m);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5840m, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5841n = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5841n);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5842o = iArr[0];
        GLES20.glBindTexture(3553, this.f5842o);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5842o, 0);
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            throw new IllegalStateException("failed to make complete framebuffer object " + glCheckFramebufferStatus);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
    }

    /* renamed from: a */
    private int m6838a(String str, String str2) {
        int m6843a = m6843a(35633, str);
        int m6843a2 = m6843a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, m6843a);
        GLES20.glAttachShader(glCreateProgram, m6843a2);
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
    private int m6843a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    void getLocation() {
        this.f5848u[0] = GLES20.glGetUniformLocation(this.f5846s, "s_texture_y");
        this.f5848u[1] = GLES20.glGetUniformLocation(this.f5846s, "s_texture_u");
        this.f5848u[2] = GLES20.glGetUniformLocation(this.f5846s, "s_texture_v");
        this.f5849v = GLES20.glGetUniformLocation(this.f5846s, "s_texture");
        this.f5850w = GLES20.glGetUniformLocation(this.f5846s, "avg_texture");
        this.f5851x = GLES20.glGetUniformLocation(this.f5846s, "rgbThresholdTexture");
        this.f5852y = GLES20.glGetUniformLocation(this.f5846s, "labThresholdTexture");
        this.f5853z = GLES20.glGetUniformLocation(this.f5846s, "step");
        this.f5816A = GLES20.glGetUniformLocation(this.f5844q, "inputImageTexture");
        this.f5817B = GLES20.glGetUniformLocation(this.f5844q, "texelWidth");
        this.f5818C = GLES20.glGetUniformLocation(this.f5844q, "texelHeight");
        this.f5819D = GLES20.glGetUniformLocation(this.f5844q, "step");
        this.f5820E = GLES20.glGetUniformLocation(this.f5845r, "inputImageTexture");
        this.f5821F = GLES20.glGetUniformLocation(this.f5845r, "texelWidth");
        this.f5822G = GLES20.glGetUniformLocation(this.f5845r, "texelHeight");
        this.f5823H = GLES20.glGetUniformLocation(this.f5845r, "direction");
        this.f5824I = GLES20.glGetUniformLocation(this.f5845r, "stepSize");
    }

    /* renamed from: a */
    int m6840a(NAVideoFrameYUV nAVideoFrameYUV, boolean z) {
        if (this.f5829b != nAVideoFrameYUV.f5808a || this.f5830c != nAVideoFrameYUV.f5809b) {
            this.f5828a = CGSize.m6852a(nAVideoFrameYUV.f5808a, nAVideoFrameYUV.f5809b);
        }
        int m6841a = m6841a(nAVideoFrameYUV);
        FBOStruct fBOStruct = new FBOStruct();
        fBOStruct.f5806c = 2;
        fBOStruct.f5807d = 2;
        fBOStruct.f5804a = this.f5833f;
        fBOStruct.f5805b = this.f5834g;
        m6844a(m6841a, fBOStruct);
        int m6836b = m6836b(m6841a, fBOStruct.f5805b);
        m6846a(this.f5831d, 10, 10);
        m6844a(m6836b, fBOStruct);
        if (z) {
            return m6847a(m6836b, fBOStruct.f5805b);
        }
        int m6834c = m6834c(m6836b, fBOStruct.f5805b);
        fBOStruct.f5804a = this.f5835h;
        fBOStruct.f5805b = this.f5836i;
        m6835b(m6834c, fBOStruct);
        int m6833d = m6833d(m6834c, fBOStruct.f5805b);
        fBOStruct.f5804a = this.f5837j;
        fBOStruct.f5805b = this.f5838k;
        m6835b(m6833d, fBOStruct);
        return m6832e(m6833d, fBOStruct.f5805b);
    }

    /* renamed from: a */
    int m6847a(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glUseProgram(this.f5846s);
        GLES20.glViewport(0, 0, this.f5829b, this.f5830c);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5849v, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5850w, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f5836i);
        GLES20.glUniform1i(this.f5851x, 2);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f5838k);
        GLES20.glUniform1i(this.f5852y, 3);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5853z, 5);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5832e;
    }

    /* renamed from: b */
    int m6836b(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glUseProgram(this.f5846s);
        GLES20.glViewport(0, 0, this.f5829b, this.f5830c);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5849v, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5850w, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5853z, 1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5832e;
    }

    /* renamed from: c */
    int m6834c(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glUseProgram(this.f5846s);
        GLES20.glViewport(0, 0, this.f5829b, this.f5830c);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5849v, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5850w, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5853z, 2);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5832e;
    }

    /* renamed from: d */
    int m6833d(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glUseProgram(this.f5846s);
        GLES20.glViewport(0, 0, this.f5829b, this.f5830c);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5849v, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5851x, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5853z, 3);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5832e;
    }

    /* renamed from: e */
    int m6832e(int i, int i2) {
        GLES20.glUseProgram(this.f5846s);
        GLES20.glBindFramebuffer(36160, this.f5831d);
        GLES20.glViewport(0, 0, this.f5829b, this.f5830c);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5851x, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5852y, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5853z, 4);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5832e;
    }

    /* renamed from: a */
    void m6844a(int i, FBOStruct fBOStruct) {
        GLES20.glUseProgram(this.f5844q);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        CGSize m6852a = CGSize.m6852a(this.f5829b, this.f5830c);
        int min = (int) Math.min(Math.floor(Math.log(m6852a.f5802a) / Math.log(4.0d)), Math.floor(Math.log(m6852a.f5803b) / Math.log(4.0d)));
        int i2 = i;
        CGSize cGSize = m6852a;
        int i3 = 0;
        while (i3 < min) {
            double d = i3 + 1.0d;
            CGSize m6853a = CGSize.m6853a(Math.floor(m6852a.f5802a / Math.pow(4.0d, d)), Math.floor(m6852a.f5803b / Math.pow(4.0d, d)));
            if (m6853a.f5803b < 2.0d || m6853a.f5802a < 2.0d) {
                break;
            }
            FBOStruct fBOStruct2 = new FBOStruct();
            if (i3 % 2 == 0) {
                fBOStruct2.f5804a = this.f5841n;
                fBOStruct2.f5805b = this.f5842o;
            } else {
                fBOStruct2.f5804a = this.f5839l;
                fBOStruct2.f5805b = this.f5840m;
            }
            GLES20.glBindTexture(3553, fBOStruct2.f5805b);
            GLES20.glTexImage2D(3553, 0, 6408, m6853a.f5802a, m6853a.f5803b, 0, 6408, 5121, null);
            GLES20.glBindFramebuffer(36160, fBOStruct2.f5804a);
            GLES20.glViewport(0, 0, m6853a.f5802a, m6853a.f5803b);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.f5816A, 0);
            GLES20.glUniform1i(this.f5819D, 0);
            GLES20.glUniform1f(this.f5817B, 1.0f / cGSize.f5802a);
            GLES20.glUniform1f(this.f5818C, 1.0f / cGSize.f5803b);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            i2 = fBOStruct2.f5805b;
            i3++;
            cGSize = m6853a;
        }
        CGSize m6852a2 = CGSize.m6852a(2, 2);
        GLES20.glBindFramebuffer(36160, fBOStruct.f5804a);
        GLES20.glViewport(0, 0, m6852a2.f5802a, m6852a2.f5803b);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5816A, 0);
        GLES20.glUniform1i(this.f5819D, 1);
        GLES20.glUniform1f(this.f5817B, 1.0f / cGSize.f5802a);
        GLES20.glUniform1f(this.f5818C, 1.0f / cGSize.f5803b);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    /* renamed from: b */
    void m6835b(int i, FBOStruct fBOStruct) {
        int i2 = this.f5829b;
        int i3 = this.f5830c;
        GLES20.glUseProgram(this.f5845r);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6837a(f5812N));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6837a(f5813O));
        int i4 = 0;
        GLES20.glEnableVertexAttribArray(0);
        int i5 = 1;
        GLES20.glEnableVertexAttribArray(1);
        int i6 = i;
        int i7 = i3;
        while (i7 != 2) {
            int max = Math.max((((int) Math.floor(i7 / 16)) * 2) + (i7 % 16 > 0 ? 2 : 0), 2);
            FBOStruct fBOStruct2 = new FBOStruct();
            int i8 = this.f5840m;
            if (i6 == i8) {
                fBOStruct2.f5804a = this.f5841n;
                fBOStruct2.f5805b = this.f5842o;
            } else {
                fBOStruct2.f5804a = this.f5839l;
                fBOStruct2.f5805b = i8;
            }
            GLES20.glBindFramebuffer(36160, fBOStruct2.f5804a);
            GLES20.glBindTexture(3553, fBOStruct2.f5805b);
            GLES20.glTexImage2D(3553, 0, 6408, i2, max, 0, 6408, 5121, null);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glEnable(2884);
            GLES20.glCullFace(1029);
            GLES20.glDisable(2929);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glViewport(0, 0, i2, max);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i6);
            GLES20.glUniform1i(this.f5820E, 0);
            GLES20.glUniform1f(this.f5821F, 1.0f / i2);
            GLES20.glUniform1f(this.f5822G, 1.0f / i7);
            GLES20.glUniform1i(this.f5823H, 0);
            GLES20.glUniform1f(this.f5824I, 1.0f / max);
            GLES20.glDrawArrays(5, 0, 4);
            i6 = fBOStruct2.f5805b;
            GLES20.glFlush();
            i7 = max;
            i4 = 0;
            i5 = 1;
        }
        int i9 = i6;
        while (i2 != 2) {
            int max2 = Math.max((((int) Math.floor(i2 / 16)) * 2) + (i2 % 16 > 0 ? 2 : 0), 2);
            FBOStruct fBOStruct3 = new FBOStruct();
            int i10 = this.f5840m;
            if (i9 == i10) {
                fBOStruct3.f5804a = this.f5841n;
                fBOStruct3.f5805b = this.f5842o;
            } else {
                fBOStruct3.f5804a = this.f5839l;
                fBOStruct3.f5805b = i10;
            }
            FBOStruct fBOStruct4 = max2 == 2 ? fBOStruct : fBOStruct3;
            GLES20.glBindFramebuffer(36160, fBOStruct4.f5804a);
            GLES20.glBindTexture(3553, fBOStruct4.f5805b);
            GLES20.glTexImage2D(3553, 0, 6408, max2, i7, 0, 6408, 5121, null);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glEnable(2884);
            GLES20.glCullFace(1029);
            GLES20.glDisable(2929);
            GLES20.glPixelStorei(3317, i5);
            GLES20.glViewport(i4, i4, max2, i7);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i9);
            GLES20.glUniform1i(this.f5820E, i4);
            GLES20.glUniform1f(this.f5821F, 1.0f / i2);
            GLES20.glUniform1f(this.f5822G, 1.0f / i7);
            GLES20.glUniform1i(this.f5823H, i5);
            GLES20.glUniform1f(this.f5824I, 1.0f / max2);
            GLES20.glDrawArrays(5, i4, 4);
            i9 = fBOStruct4.f5805b;
            GLES20.glFlush();
            i2 = max2;
        }
    }
}
