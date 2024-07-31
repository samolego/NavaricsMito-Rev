package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.C2419a;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyStrategy {

    /* renamed from: a */
    private String f7123a;

    /* renamed from: b */
    private String f7124b;

    /* renamed from: c */
    private String f7125c;

    /* renamed from: d */
    private long f7126d;

    /* renamed from: e */
    private String f7127e;

    /* renamed from: f */
    private String f7128f;

    /* renamed from: g */
    private boolean f7129g = true;

    /* renamed from: h */
    private boolean f7130h = true;

    /* renamed from: i */
    private boolean f7131i = true;

    /* renamed from: j */
    private Class<?> f7132j = null;

    /* renamed from: k */
    private boolean f7133k = true;

    /* renamed from: l */
    private boolean f7134l = true;

    /* renamed from: m */
    private boolean f7135m = true;

    /* renamed from: n */
    private boolean f7136n = false;

    /* renamed from: o */
    private C2402a f7137o;

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f7133k = z;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.f7136n = z;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.f7135m = z;
        return this;
    }

    public synchronized boolean isUploadProcess() {
        return this.f7135m;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f7133k;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f7136n;
    }

    public boolean isReplaceOldChannel() {
        return this.f7134l;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f7134l = z;
    }

    public synchronized String getAppVersion() {
        if (this.f7123a == null) {
            return C2419a.m5470b().f7264j;
        }
        return this.f7123a;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f7123a = str;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f7132j = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f7132j;
    }

    public synchronized String getAppChannel() {
        if (this.f7124b == null) {
            return C2419a.m5470b().f7266l;
        }
        return this.f7124b;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f7124b = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        if (this.f7125c == null) {
            return C2419a.m5470b().f7257c;
        }
        return this.f7125c;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f7125c = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f7126d;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f7126d = j;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f7127e;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f7127e = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.f7128f;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f7128f = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f7129g;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f7129g = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f7131i = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f7131i;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f7130h;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f7130h = z;
        return this;
    }

    public synchronized C2402a getCrashHandleCallback() {
        return this.f7137o;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C2402a c2402a) {
        this.f7137o = c2402a;
        return this;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.BuglyStrategy$a */
    /* loaded from: classes2.dex */
    public static class C2402a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }
}
