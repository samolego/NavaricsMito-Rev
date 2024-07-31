package com.navatics.app.framework.user;

/* compiled from: NvUserEvent.java */
/* renamed from: com.navatics.app.framework.user.a, reason: use source file name */
/* loaded from: classes.dex */
public class NvUserEvent {

    /* renamed from: a */
    NvUser user;

    /* renamed from: b */
    int id;

    /* renamed from: c */
    String f4863c;

    /* renamed from: d */
    UserServiceException serviceException;

    public NvUserEvent(int id, NvUser nvUser) {
        this.user = nvUser;
        this.id = id;
    }

    public NvUserEvent(int id, String str) {
        this.f4863c = str;
        this.id = id;
    }

    public NvUserEvent(int i, UserServiceException userServiceException) {
        this.id = i;
        this.serviceException = userServiceException;
    }

    /* renamed from: a */
    public NvUser getUser() {
        return this.user;
    }

    /* renamed from: b */
    public int getId() {
        return this.id;
    }

    /* renamed from: c */
    public UserServiceException getServiceException() {
        return this.serviceException;
    }
}