package com.navatics.app.framework.user;

/* renamed from: com.navatics.app.framework.user.a */
/* loaded from: classes.dex */
public class NvUserEvent {

    /* renamed from: a */
    NvUser f4839a;

    /* renamed from: b */
    int f4840b;

    /* renamed from: c */
    String f4841c;

    /* renamed from: d */
    UserServiceException f4842d;

    public NvUserEvent(int i, NvUser nvUser) {
        this.f4839a = nvUser;
        this.f4840b = i;
    }

    public NvUserEvent(int i, String str) {
        this.f4841c = str;
        this.f4840b = i;
    }

    public NvUserEvent(int i, UserServiceException userServiceException) {
        this.f4840b = i;
        this.f4842d = userServiceException;
    }

    /* renamed from: a */
    public NvUser m7778a() {
        return this.f4839a;
    }

    /* renamed from: b */
    public int m7777b() {
        return this.f4840b;
    }

    /* renamed from: c */
    public UserServiceException m7776c() {
        return this.f4842d;
    }
}
