package com.senseplay.sdk.opengl;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.senseplay.sdk.video.VideoPlay;

/* loaded from: classes2.dex */
public class UnityJavaBridge {
    private static UnityJavaBridge unityJavaBridge;
    public VideoPlay videoPlay = null;
    public int[] videoIDs = {0, 0};
    public boolean isVideoStarted = false;
    private boolean videoInitSuccess = false;

    public Context getContext(Activity activity) {
        return activity;
    }

    public static UnityJavaBridge Instance() {
        if (unityJavaBridge == null) {
            synchronized (UnityJavaBridge.class) {
                if (unityJavaBridge == null) {
                    unityJavaBridge = new UnityJavaBridge();
                }
            }
        }
        return unityJavaBridge;
    }

    public String getTime() {
        return System.currentTimeMillis() + "";
    }

    public void startVideo() {
        int genGLTex;
        try {
            GLTool Instance = GLTool.Instance();
            if (Instance.getUnityEGL() && Instance.genProgram()) {
                Instance.initJavaGLEnv(Instance.mSharedEglContext, Instance.mSharedEglConfig);
                int i = 0;
                for (int i2 = 0; i2 < this.videoIDs.length; i2++) {
                    if (this.videoIDs[i2] == 0 && (genGLTex = Instance.genGLTex()) != 0) {
                        this.videoIDs[i2] = genGLTex;
                        i++;
                    }
                }
                if (i == this.videoIDs.length) {
                    if (this.videoPlay == null) {
                        this.videoPlay = new VideoPlay();
                    }
                    this.videoPlay.playAr(null);
                    this.isVideoStarted = true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void startVideoOffScreen() {
        int genGLTex;
        try {
            GLTool Instance = GLTool.Instance();
            if (!this.videoInitSuccess) {
                if (!Instance.getUnityEGL()) {
                    Log.e("unity", "getUnityEGL Failed");
                    return;
                } else if (!Instance.genProgram()) {
                    Log.e("unity", "genProgram Failed");
                    return;
                } else {
                    Instance.initJavaGLEnv(Instance.mSharedEglContext, Instance.mSharedEglConfig);
                    int i = 0;
                    for (int i2 = 0; i2 < this.videoIDs.length; i2++) {
                        if (this.videoIDs[i2] == 0 && (genGLTex = Instance.genGLTex()) != 0) {
                            this.videoIDs[i2] = genGLTex;
                            i++;
                        }
                    }
                    if (i != this.videoIDs.length) {
                        Log.e("unity", "gen Tex id Failed");
                        return;
                    }
                    Instance.setOESTex(this.videoIDs[0]);
                    Instance.createRGBTex(this.videoIDs[1], null, Instance.width, Instance.height);
                    Log.w("unity", "rgbtex created:" + Instance.width + "," + Instance.height + ",videoIDs:" + this.videoIDs[1]);
                    Instance.fbo = Instance.genFBO();
                    Instance.bindFBO(Instance.fbo, this.videoIDs[1]);
                    this.videoInitSuccess = true;
                }
            }
            this.videoPlay = new VideoPlay();
            Instance.sftex = null;
            Instance.surface = null;
            this.videoPlay.playAr(Instance.getSurface());
            this.isVideoStarted = true;
            Log.w("unity", "video is started");
        } catch (Exception e) {
            Log.e("unity", e.getMessage());
        }
    }

    public void renderToUnity() {
        if (this.isVideoStarted) {
            GLTool.Instance().renderToFBO();
        }
    }

    public void stop() {
        VideoPlay videoPlay = this.videoPlay;
        if (videoPlay != null) {
            videoPlay.stop();
            this.videoPlay = null;
        }
        this.isVideoStarted = false;
    }
}
