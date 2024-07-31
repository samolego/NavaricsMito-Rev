package com.senseplay.sdk.video;

import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.opengl.GLTool;
import com.senseplay.sdk.opengl.UnityJavaBridge;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class VideoOpengl {
    public static void openGl(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            SPDebug.m5807w("outputBuffer", "outputBuffer is null");
            return;
        }
        UnityJavaBridge Instance = UnityJavaBridge.Instance();
        GLTool Instance2 = GLTool.Instance();
        if (Instance.isVideoStarted && byteBuffer.hasRemaining()) {
            VideoPlayerThread.bufferSize = byteBuffer.remaining();
            Instance2.checkResChanged(byteBuffer);
            int i = Instance2.width * Instance2.height;
            int i2 = (int) (i * 1.5d);
            if (i2 > i) {
                byteBuffer.position(0);
                byteBuffer.limit(i);
                Instance2.createAlpha8Tex(Instance.videoIDs[0], byteBuffer.slice(), Instance2.width, Instance2.height, false);
                byteBuffer.position(i);
                byteBuffer.limit(i2);
                Instance2.createAlpha8Tex(Instance.videoIDs[1], byteBuffer.slice(), Instance2.width / 2, Instance2.height / 2, true);
            }
        }
    }
}
