package com.senseplay.sdk.opengl;

import android.opengl.GLES10;
import android.opengl.GLES20;

/* loaded from: classes2.dex */
public class GLShader {
    public static final String FRAGMENT_SHADER_STRING() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {\n  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}\n";
    }

    public static final String VERTEX_SHADER_STRING() {
        return "attribute vec4 in_pos;\nattribute vec2 in_tc;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = in_pos;\n    textureCoordinate = in_tc;\n}\n";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void applyShader(int i, int i2, String str, int i3) throws RuntimeException {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            throw new RuntimeException("Create shader failed, err=" + GLES10.glGetError());
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glDeleteShader(glCreateShader);
            throw new RuntimeException("Compile shader failed, err=" + GLES10.glGetError());
        }
        GLES20.glAttachShader(i3, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
    }
}
