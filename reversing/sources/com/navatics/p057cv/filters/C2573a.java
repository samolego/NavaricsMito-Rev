package com.navatics.p057cv.filters;

import android.opengl.GLES20;
import com.navatics.p057cv.p058a.CGSize;
import com.navatics.p057cv.p058a.FBOStruct;
import com.navatics.xlog.WLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* renamed from: com.navatics.cv.filters.a */
/* loaded from: classes.dex */
public class VividXRender {

    /* renamed from: c */
    private static final String f5863c = "a";

    /* renamed from: d */
    private static final float[] f5864d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: e */
    private static final float[] f5865e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: f */
    private static float[] f5866f = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: g */
    private static float[] f5867g = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: A */
    private int f5868A;

    /* renamed from: C */
    private int f5870C;

    /* renamed from: D */
    private int f5871D;

    /* renamed from: E */
    private int f5872E;

    /* renamed from: F */
    private int f5873F;

    /* renamed from: G */
    private int f5874G;

    /* renamed from: H */
    private int f5875H;

    /* renamed from: I */
    private int f5876I;

    /* renamed from: J */
    private int f5877J;

    /* renamed from: K */
    private int f5878K;

    /* renamed from: L */
    private int f5879L;

    /* renamed from: M */
    private int f5880M;

    /* renamed from: N */
    private int f5881N;

    /* renamed from: O */
    private int f5882O;

    /* renamed from: P */
    private int f5883P;

    /* renamed from: Q */
    private int f5884Q;

    /* renamed from: R */
    private int f5885R;

    /* renamed from: a */
    int f5887a;

    /* renamed from: b */
    int f5888b;

    /* renamed from: h */
    private CGSize f5889h;

    /* renamed from: i */
    private int f5890i;

    /* renamed from: j */
    private int f5891j;

    /* renamed from: k */
    private int f5892k;

    /* renamed from: l */
    private int f5893l;

    /* renamed from: m */
    private int f5894m;

    /* renamed from: n */
    private int f5895n;

    /* renamed from: o */
    private int f5896o;

    /* renamed from: p */
    private int f5897p;

    /* renamed from: q */
    private int f5898q;

    /* renamed from: r */
    private int f5899r;

    /* renamed from: s */
    private int f5900s;

    /* renamed from: t */
    private int f5901t;

    /* renamed from: u */
    private int f5902u;

    /* renamed from: v */
    private int f5903v;

    /* renamed from: x */
    private int f5905x;

    /* renamed from: y */
    private int f5906y;

    /* renamed from: z */
    private int f5907z;

    /* renamed from: w */
    private int[] f5904w = new int[3];

    /* renamed from: B */
    private int[] f5869B = new int[3];

    /* renamed from: S */
    private boolean f5886S = true;

    public VividXRender(int i, int i2) {
        this.f5884Q = i;
        this.f5885R = i2;
        this.f5890i = i;
        this.f5891j = i2;
        this.f5889h = CGSize.m6852a(this.f5890i, this.f5891j);
        m6819a(this.f5889h);
        GLES20.glBindFramebuffer(36160, this.f5892k);
        this.f5905x = m6817a("    attribute vec4 position;\n    attribute vec2 texcoord;\n\n    uniform float texelWidth;\n    uniform float texelHeight;\n \n    varying float texelW;\n    varying float texelH;\n    varying vec2 upperLeftInputTextureCoordinate;\n    varying vec2 upperRightInputTextureCoordinate;\n    varying vec2 lowerLeftInputTextureCoordinate;\n    varying vec2 lowerRightInputTextureCoordinate;\n\n    void main()\n    {\n        gl_Position = position;\n        texelW = texelWidth;\n        texelH = texelHeight;\n        upperLeftInputTextureCoordinate = texcoord.xy + vec2(-texelWidth, -texelHeight);\n        upperRightInputTextureCoordinate = texcoord.xy + vec2(texelWidth, -texelHeight);\n        lowerLeftInputTextureCoordinate = texcoord.xy + vec2(-texelWidth, texelHeight);\n        lowerRightInputTextureCoordinate = texcoord.xy + vec2(texelWidth, texelHeight);\n    }", "precision highp float;\n\n    uniform sampler2D inputImageTexture;\n    \n    uniform int step; //0/other\n    \n    varying float texelW;\n    varying float texelH;\n    varying highp vec2 upperLeftInputTextureCoordinate;\n    varying highp vec2 upperRightInputTextureCoordinate;\n    varying highp vec2 lowerLeftInputTextureCoordinate;\n    varying highp vec2 lowerRightInputTextureCoordinate;\n\n    void main()\n    {\n        if (step > 0)\n        {\n            vec4 sum_rgba = vec4(0.0, 0.0, 0.0, 0.0);\n            float count = 0.0;\n            for (float x = texelW * 0.5; x < 1.0; x+=texelW)\n            {\n                for (float y = texelH * 0.5; y < 1.0; y+=texelH)\n                {\n                    vec4 rgba = texture2D(inputImageTexture, vec2(x, y));\n                    sum_rgba = sum_rgba + rgba;\n                    count += 1.0;\n                }\n            }\n            gl_FragColor = sum_rgba/count;//vec4(count/255.0, 0.0, 0.0, 0.0);\n        }\n        else\n        {\n            highp vec4 upperLeftColor = texture2D(inputImageTexture, upperLeftInputTextureCoordinate);\n            highp vec4 upperRightColor = texture2D(inputImageTexture, upperRightInputTextureCoordinate);\n            highp vec4 lowerLeftColor = texture2D(inputImageTexture, lowerLeftInputTextureCoordinate);\n            highp vec4 lowerRightColor = texture2D(inputImageTexture, lowerRightInputTextureCoordinate);\n\n            gl_FragColor = 0.25 * (upperLeftColor + upperRightColor + lowerLeftColor + lowerRightColor);\n        }\n    }");
        this.f5906y = m6817a(" attribute vec4 position;\n attribute vec2 texcoord;\n varying vec2 v_texcoord;\n void main()\n {\n     gl_Position = position;\n     v_texcoord = texcoord.xy;\n }", "    precision highp float;\n\n    uniform sampler2D inputImageTexture;\n    varying vec2 v_texcoord;\n    \n    uniform float texelWidth;   //  (1.0/width)\n    uniform float texelHeight;  // (1.0/height)\n    uniform int direction;      //0/1\n    uniform float stepSize;     // 当前方向的步长\n    \n    float unitSize = 16.0;\n    void main()\n    {\n        float n = (direction > 0 ? v_texcoord.x : v_texcoord.y)/stepSize - 0.5;\n        n = fract(n) > 0.5 ? ceil(n) : floor(n);\n        \n        float m;\n        int model = 1; //1:求最大值 0:求最小值\n        if (mod(n, 2.0) == 0.0)\n        {\n            model = 0; //求最小值\n            m = unitSize * n * 0.5;\n        }\n        else\n        {\n            m = unitSize * (n-1.0)*0.5;\n        }\n\n        vec2 point = v_texcoord;\n        float texelSize = direction > 0 ? texelWidth : texelHeight;\n        \n        float start = 0.5 * texelSize + m * texelSize;\n        point.x = direction > 0 ? start : point.x;\n        point.y = direction > 0 ? point.y : start;\n        vec3 rgb = texture2D(inputImageTexture, point).rgb;\n    \n        float maxSize = 1.0 - texelSize * 0.5;\n        for(float i = 1.0; i < unitSize; i=i+1.0)\n        {\n            point.x = direction > 0 ? min(start + texelSize * i, maxSize) : point.x;\n            point.y = direction > 0 ? point.y : min(start + texelSize * i, maxSize);\n            rgb = model == 0 ? min(rgb, texture2D(inputImageTexture, point).rgb) : max(rgb, texture2D(inputImageTexture, point).rgb);\n        }\n        gl_FragColor = vec4(rgb, 1.0);\n        \n    }");
        this.f5907z = m6817a(" attribute vec4 position;\n attribute vec2 texcoord;\n varying vec2 v_texcoord;\n void main()\n {\n     gl_Position = position;\n     v_texcoord = texcoord.xy;\n }", m6818a("    precision highp float;\n    varying vec2 v_texcoord;\n    uniform sampler2D s_texture_y;\n    uniform sampler2D s_texture_u;\n    uniform sampler2D s_texture_v;\n    uniform sampler2D s_texture;\n    uniform sampler2D avg_texture;\n    uniform sampler2D rgbThresholdTexture;\n    uniform sampler2D labThresholdTexture;\n    uniform int step;\n \n    yuv2rgbFunctionString\n    rgb2labFunctionString\n    lab2rgbFunctionString\n \n    void main()\n    {\n        vec3 color_rgb = texture2D(s_texture, v_texcoord).rgb;\n        vec3 avg = texture2D(avg_texture, vec2(0.25, 0.25)).rgb;\n        vec3 max_rgb = texture2D(rgbThresholdTexture, vec2(0.75, 0.75)).rgb;\n        vec3 min_rgb = texture2D(rgbThresholdTexture, vec2(0.25, 0.25)).rgb;\n        max_rgb = max_rgb * 2.0; min_rgb = min_rgb * 2.0;\n        float l_min = texture2D(labThresholdTexture, vec2(0.25, 0.25)).r;\n        float l_max = texture2D(labThresholdTexture, vec2(0.75, 0.75)).r;\n        \n        if (step == 0)\n        {\n            //0.YUV -> RGB\n            vec3 yuv;\n            yuv.x = texture2D(s_texture_y, v_texcoord).r;\n            yuv.y = texture2D(s_texture_u, v_texcoord).r;\n            yuv.z = texture2D(s_texture_v, v_texcoord).r;\n            vec3 color_rgb = yuv2rgb(yuv);\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else if (step == 1)\n        {\n            //1.红色补偿\n            color_rgb.x = color_rgb.x + 1.0 * (avg[1] - avg[0]) * (1.0 - color_rgb.x) * color_rgb.y;\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else if (step == 2)\n        {\n            //2.灰度图均衡化 *0.5\n            float avg_illumination = (avg[0] + avg[1] + avg[2])/3.0;\n            vec3 rgb_factor = vec3(avg_illumination/avg[0], avg_illumination/avg[1], avg_illumination/avg[2]);\n            color_rgb.x = color_rgb.x * rgb_factor[0];\n            color_rgb.y = color_rgb.y * rgb_factor[1];\n            color_rgb.z = color_rgb.z * rgb_factor[2];\n            gl_FragColor = vec4(color_rgb * 0.5, 1.0);\n        }\n        else if (step == 3)\n        {\n            //3.在灰度图上进行颜色校正后转为LAB颜色空间 *2.0\n            mat3 threshold = mat3(min_rgb[0], 1.0/max_rgb[0], 0.0,\n                                  min_rgb[1], 1.0/max_rgb[1], 0.0,\n                                  min_rgb[2], 1.0/max_rgb[2], 0.0\n                                  );\n            color_rgb.x = (color_rgb.x * 2.0 - threshold[0][0])*threshold[0][1];\n            color_rgb.y = (color_rgb.y * 2.0 - threshold[1][0])*threshold[1][1];\n            color_rgb.z = (color_rgb.z * 2.0 - threshold[2][0])*threshold[2][1];\n            vec3 color_lab = rgb2lab(color_rgb);\n            gl_FragColor = vec4(color_lab, 1.0);\n        }\n        else if (step == 4)\n        {\n            //4.亮度修正\n            vec3 color_lab = color_rgb;\n            float l_factor = 0.9/(l_max - l_min);\n            color_lab.x = (color_lab.x - l_min) * l_factor;\n            color_rgb = lab2rgb(color_lab);\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else if (step == 5)\n        {\n            //2.灰度图均衡化\n            float avg_illumination = (avg[0] + avg[1] + avg[2])/3.0;\n            vec3 rgb_factor = vec3(avg_illumination/avg[0], avg_illumination/avg[1], avg_illumination/avg[2]);\n            color_rgb.x = color_rgb.x * rgb_factor[0];\n            color_rgb.y = color_rgb.y * rgb_factor[1];\n            color_rgb.z = color_rgb.z * rgb_factor[2];\n            //3.在灰度图上进行颜色校正后转为LAB颜色空间\n            mat3 threshold = mat3(min_rgb[0], 1.0/max_rgb[0], 0.0,\n                                  min_rgb[1], 1.0/max_rgb[1], 0.0,\n                                  min_rgb[2], 1.0/max_rgb[2], 0.0\n                                  );\n            color_rgb.x = (color_rgb.x - threshold[0][0])*threshold[0][1];\n            color_rgb.y = (color_rgb.y - threshold[1][0])*threshold[1][1];\n            color_rgb.z = (color_rgb.z - threshold[2][0])*threshold[2][1];\n            vec3 color_lab = rgb2lab(color_rgb);\n            //4.亮度修正\n            float l_factor = 0.9/(l_max - l_min);\n            color_lab.x = (color_lab.x - l_min) * l_factor;\n            color_rgb = lab2rgb(color_lab);\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n        else\n        {\n            gl_FragColor = vec4(color_rgb, 1.0);\n        }\n    }"));
        this.f5868A = m6817a("attribute vec4 vPosition;                  \nattribute vec2 vCoordinate;                \nvarying   vec2 aCoordinate;                \n\nvoid main(){                               \n   gl_Position=vPosition;                  \n   aCoordinate=vCoordinate;                \n}                                          \n", "uniform sampler2D vTexture;                        \nvarying vec2 aCoordinate;                          \n\nvoid main(){                                       \n    gl_FragColor=texture2D(vTexture,aCoordinate);  \n}                                                  \n");
        this.f5887a = m6817a("attribute vec4 vPosition;                  \nattribute vec2 vCoordinate;                \nvarying   vec2 aCoordinate;                \n\nvoid main(){                               \n   gl_Position=vPosition;                  \n   aCoordinate=vCoordinate;                \n}                                          \n", "#extension GL_OES_EGL_image_external : require                 \nprecision mediump float;                                       \nvarying vec2 aCoordinate;                                      \nuniform samplerExternalOES inputImageTexture;                  \n \nvoid main() {                                                  \n  gl_FragColor = texture2D( inputImageTexture, aCoordinate );  \n}");
        m6825a();
    }

    /* renamed from: a */
    public int m6824a(int i) {
        return m6820a(i, false);
    }

    /* renamed from: a */
    private String m6818a(String str) {
        String replaceAll = str.replaceAll("yuv2rgbFunctionString", "    vec3 delyuv = vec3(0.0/255.0, -128.0/255.0, -128.0/255.0);\n    mat3 invert_rgb = mat3(1.0, 0.0,    1.402,\n                     1.0, -0.34414, -0.71414,\n                     1.0, 1.772,  0.0);\n    vec3 yuv2rgb(vec3 yuv){\n        yuv += delyuv;\n        return yuv * invert_rgb;\n    }").replaceAll("rgb2labFunctionString", "         vec3 rgb2xyz(vec3 c) {\n         vec3 tmp;\n         tmp.x = (c.r > 0.04045) ? pow((c.r + 0.055) / 1.055, 2.4) : c.r / 12.92;\n         tmp.y = (c.g > 0.04045) ? pow((c.g + 0.055) / 1.055, 2.4) : c.g / 12.92;\n         tmp.z = (c.b > 0.04045) ? pow((c.b + 0.055) / 1.055, 2.4) : c.b / 12.92;\n         return 100.0 * tmp *\n             mat3(0.4124, 0.3576, 0.1805,\n                   0.2126, 0.7152, 0.0722,\n                   0.0193, 0.1192, 0.9505);\n     }\n\n     vec3 xyz2lab(vec3 c) {\n         vec3 n = c / vec3(95.047, 100, 108.883);\n         vec3 v;\n         v.x = (n.x > 0.008856) ? pow(n.x, 1.0 / 3.0) : (7.787 * n.x) + (16.0 / 116.0);\n         v.y = (n.y > 0.008856) ? pow(n.y, 1.0 / 3.0) : (7.787 * n.y) + (16.0 / 116.0);\n         v.z = (n.z > 0.008856) ? pow(n.z, 1.0 / 3.0) : (7.787 * n.z) + (16.0 / 116.0);\n         return vec3((116.0 * v.y) - 16.0, 500.0 * (v.x - v.y), 200.0 * (v.y - v.z));\n     }\n     vec3 rgb2lab(vec3 c) {\n         vec3 lab = xyz2lab(rgb2xyz(c));\n         return vec3(lab.x / 100.0, 0.5 + 0.5 * (lab.y / 127.0), 0.5 + 0.5 * (lab.z / 127.0));\n     }").replaceAll("lab2rgbFunctionString", "     vec3 lab2xyz(vec3 c) {\n         float fy = (c.x + 16.0) / 116.0;\n         float fx = c.y / 500.0 + fy;\n         float fz = fy - c.z / 200.0;\n         return vec3(\n              95.047 * ((fx > 0.206897) ? fx * fx * fx : (fx - 16.0 / 116.0) / 7.787),\n             100.000 * ((fy > 0.206897) ? fy * fy * fy : (fy - 16.0 / 116.0) / 7.787),\n             108.883 * ((fz > 0.206897) ? fz * fz * fz : (fz - 16.0 / 116.0) / 7.787)\n        );\n     }\n\n     vec3 xyz2rgb(vec3 c) {\n         vec3 v =  c / 100.0 * mat3(\n                                    3.2406, -1.5372, -0.4986,\n                                    -0.9689, 1.8758, 0.0415,\n                                    0.0557, -0.2040, 1.0570\n                                    );\n         vec3 r;\n         r.x = (v.r > 0.0031308) ? ((1.055 * pow(v.r, (1.0 / 2.4))) - 0.055) : 12.92 * v.r;\n         r.y = (v.g > 0.0031308) ? ((1.055 * pow(v.g, (1.0 / 2.4))) - 0.055) : 12.92 * v.g;\n         r.z = (v.b > 0.0031308) ? ((1.055 * pow(v.b, (1.0 / 2.4))) - 0.055) : 12.92 * v.b;\n         return r;\n     }\n\n     vec3 lab2rgb(vec3 c) {\n         return xyz2rgb(lab2xyz(vec3(100.0 * c.x, 2.0 * 127.0 * (c.y - 0.5), 2.0 * 127.0 * (c.z - 0.5))));\n     }");
        String str2 = f5863c;
        WLog.m5840w(str2, "\n" + replaceAll);
        return replaceAll;
    }

    /* renamed from: a */
    private FloatBuffer m6816a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    private void m6819a(CGSize cGSize) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5892k = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5892k);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5893l = iArr[0];
        GLES20.glBindTexture(3553, this.f5893l);
        GLES20.glTexImage2D(3553, 0, 6408, cGSize.f5802a, cGSize.f5803b, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5893l, 0);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5894m = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5894m);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5895n = iArr[0];
        GLES20.glBindTexture(3553, this.f5895n);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5895n, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5896o = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5896o);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5897p = iArr[0];
        GLES20.glBindTexture(3553, this.f5897p);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5897p, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5898q = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5898q);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5899r = iArr[0];
        GLES20.glBindTexture(3553, this.f5899r);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5899r, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5900s = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5900s);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5901t = iArr[0];
        GLES20.glBindTexture(3553, this.f5901t);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5901t, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f5902u = iArr[0];
        GLES20.glBindFramebuffer(36160, this.f5902u);
        GLES20.glGenTextures(1, iArr, 0);
        this.f5903v = iArr[0];
        GLES20.glBindTexture(3553, this.f5903v);
        GLES20.glTexImage2D(3553, 0, 6408, 2, 2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5903v, 0);
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            throw new IllegalStateException("failed to make complete framebuffer object " + glCheckFramebufferStatus);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
    }

    /* renamed from: a */
    private int m6817a(String str, String str2) {
        int m6821a = m6821a(35633, str);
        int m6821a2 = m6821a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, m6821a);
        GLES20.glAttachShader(glCreateProgram, m6821a2);
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
    private int m6821a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* renamed from: a */
    void m6825a() {
        this.f5869B[0] = GLES20.glGetUniformLocation(this.f5907z, "s_texture_y");
        this.f5869B[1] = GLES20.glGetUniformLocation(this.f5907z, "s_texture_u");
        this.f5869B[2] = GLES20.glGetUniformLocation(this.f5907z, "s_texture_v");
        this.f5870C = GLES20.glGetUniformLocation(this.f5907z, "s_texture");
        this.f5871D = GLES20.glGetUniformLocation(this.f5907z, "avg_texture");
        this.f5872E = GLES20.glGetUniformLocation(this.f5907z, "rgbThresholdTexture");
        this.f5873F = GLES20.glGetUniformLocation(this.f5907z, "labThresholdTexture");
        this.f5874G = GLES20.glGetUniformLocation(this.f5907z, "step");
        this.f5875H = GLES20.glGetUniformLocation(this.f5905x, "inputImageTexture");
        this.f5876I = GLES20.glGetUniformLocation(this.f5905x, "texelWidth");
        this.f5877J = GLES20.glGetUniformLocation(this.f5905x, "texelHeight");
        this.f5878K = GLES20.glGetUniformLocation(this.f5905x, "step");
        this.f5879L = GLES20.glGetUniformLocation(this.f5906y, "inputImageTexture");
        this.f5880M = GLES20.glGetUniformLocation(this.f5906y, "texelWidth");
        this.f5881N = GLES20.glGetUniformLocation(this.f5906y, "texelHeight");
        this.f5882O = GLES20.glGetUniformLocation(this.f5906y, "direction");
        this.f5883P = GLES20.glGetUniformLocation(this.f5906y, "stepSize");
        this.f5888b = GLES20.glGetUniformLocation(this.f5887a, "inputImageTexture");
    }

    /* renamed from: a */
    int m6820a(int i, boolean z) {
        FBOStruct fBOStruct = new FBOStruct();
        fBOStruct.f5806c = 2;
        fBOStruct.f5807d = 2;
        fBOStruct.f5804a = this.f5894m;
        fBOStruct.f5805b = this.f5895n;
        m6822a(i, fBOStruct);
        int m6815b = m6815b(i, fBOStruct.f5805b);
        m6822a(m6815b, fBOStruct);
        if (z) {
            return m6823a(m6815b, fBOStruct.f5805b);
        }
        int m6813c = m6813c(m6815b, fBOStruct.f5805b);
        fBOStruct.f5804a = this.f5896o;
        fBOStruct.f5805b = this.f5897p;
        m6814b(m6813c, fBOStruct);
        int m6812d = m6812d(m6813c, fBOStruct.f5805b);
        fBOStruct.f5804a = this.f5898q;
        fBOStruct.f5805b = this.f5899r;
        m6814b(m6812d, fBOStruct);
        return m6811e(m6812d, fBOStruct.f5805b);
    }

    /* renamed from: a */
    int m6823a(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5892k);
        GLES20.glUseProgram(this.f5907z);
        GLES20.glViewport(0, 0, this.f5890i, this.f5891j);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5870C, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5871D, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f5897p);
        GLES20.glUniform1i(this.f5872E, 2);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f5899r);
        GLES20.glUniform1i(this.f5873F, 3);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5874G, 5);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5893l;
    }

    /* renamed from: b */
    int m6815b(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5892k);
        GLES20.glUseProgram(this.f5907z);
        GLES20.glViewport(0, 0, this.f5890i, this.f5891j);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5870C, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5871D, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5874G, 1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5893l;
    }

    /* renamed from: c */
    int m6813c(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5892k);
        GLES20.glUseProgram(this.f5907z);
        GLES20.glViewport(0, 0, this.f5890i, this.f5891j);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5870C, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5871D, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5874G, 2);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5893l;
    }

    /* renamed from: d */
    int m6812d(int i, int i2) {
        GLES20.glBindFramebuffer(36160, this.f5892k);
        GLES20.glUseProgram(this.f5907z);
        GLES20.glViewport(0, 0, this.f5890i, this.f5891j);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5870C, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5872E, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5874G, 3);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5893l;
    }

    /* renamed from: e */
    int m6811e(int i, int i2) {
        GLES20.glUseProgram(this.f5907z);
        GLES20.glBindFramebuffer(36160, this.f5892k);
        GLES20.glViewport(0, 0, this.f5890i, this.f5891j);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        GLES20.glDisable(2929);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.f5872E, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.f5873F, 1);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glUniform1i(this.f5874G, 4);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
        return this.f5893l;
    }

    /* renamed from: a */
    void m6822a(int i, FBOStruct fBOStruct) {
        GLES20.glUseProgram(this.f5905x);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        CGSize m6852a = CGSize.m6852a(this.f5890i, this.f5891j);
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
                fBOStruct2.f5804a = this.f5902u;
                fBOStruct2.f5805b = this.f5903v;
            } else {
                fBOStruct2.f5804a = this.f5900s;
                fBOStruct2.f5805b = this.f5901t;
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
            GLES20.glUniform1i(this.f5875H, 0);
            GLES20.glUniform1i(this.f5878K, 0);
            GLES20.glUniform1f(this.f5876I, 1.0f / cGSize.f5802a);
            GLES20.glUniform1f(this.f5877J, 1.0f / cGSize.f5803b);
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
        GLES20.glUniform1i(this.f5875H, 0);
        GLES20.glUniform1i(this.f5878K, 1);
        GLES20.glUniform1f(this.f5876I, 1.0f / cGSize.f5802a);
        GLES20.glUniform1f(this.f5877J, 1.0f / cGSize.f5803b);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    /* renamed from: b */
    void m6814b(int i, FBOStruct fBOStruct) {
        int i2 = this.f5890i;
        int i3 = this.f5891j;
        GLES20.glUseProgram(this.f5906y);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) m6816a(f5864d));
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) m6816a(f5865e));
        int i4 = 0;
        GLES20.glEnableVertexAttribArray(0);
        int i5 = 1;
        GLES20.glEnableVertexAttribArray(1);
        int i6 = i;
        int i7 = i3;
        while (i7 != 2) {
            int max = Math.max((((int) Math.floor(i7 / 16)) * 2) + (i7 % 16 > 0 ? 2 : 0), 2);
            FBOStruct fBOStruct2 = new FBOStruct();
            int i8 = this.f5901t;
            if (i6 == i8) {
                fBOStruct2.f5804a = this.f5902u;
                fBOStruct2.f5805b = this.f5903v;
            } else {
                fBOStruct2.f5804a = this.f5900s;
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
            GLES20.glUniform1i(this.f5879L, 0);
            GLES20.glUniform1f(this.f5880M, 1.0f / i2);
            GLES20.glUniform1f(this.f5881N, 1.0f / i7);
            GLES20.glUniform1i(this.f5882O, 0);
            GLES20.glUniform1f(this.f5883P, 1.0f / max);
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
            int i10 = this.f5901t;
            if (i9 == i10) {
                fBOStruct3.f5804a = this.f5902u;
                fBOStruct3.f5805b = this.f5903v;
            } else {
                fBOStruct3.f5804a = this.f5900s;
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
            GLES20.glUniform1i(this.f5879L, i4);
            GLES20.glUniform1f(this.f5880M, 1.0f / i2);
            GLES20.glUniform1f(this.f5881N, 1.0f / i7);
            GLES20.glUniform1i(this.f5882O, i5);
            GLES20.glUniform1f(this.f5883P, 1.0f / max2);
            GLES20.glDrawArrays(5, i4, 4);
            i9 = fBOStruct4.f5805b;
            GLES20.glFlush();
            i2 = max2;
        }
    }
}
