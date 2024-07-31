package com.navatics.robot.transport;

/* compiled from: NvError.java */
/* renamed from: com.navatics.robot.transport.m */
/* loaded from: classes.dex */
public class NvError {

    /* renamed from: a */
    private int f6584a;

    /* renamed from: b */
    private String f6585b;

    /* renamed from: c */
    private Object f6586c;

    /* renamed from: a */
    public static String getType(int i) {
        if (i == 0) {
            return "SUCCESS";
        }
        switch (i) {
            case 48:
                return "ERR_IO";
            case 49:
                return "INVALID_PARAMS";
            case 50:
                return "RES_NOT_READY";
            case 51:
                return "NOT_OWNER";
            case 52:
                return "NOT_BOUND";
            case 53:
                return "MEM_NOT_ENOUGH";
            case 54:
                return "BUSY";
            case 55:
                return "TRANSACTION_ERROR";
            case 56:
                return "NOT_FOUND";
            default:
                switch (i) {
                    case 64:
                        return "GNDSTA_LOGIN_FAILED";
                    case 65:
                        return "CLEAR_UID_FAILED";
                    case 66:
                        return "NOT_AUTHED";
                    case 67:
                        return "RENDER_ERROR";
                    case 68:
                        return "TIMEOUT";
                    case 69:
                        return "BAD_NETWORK";
                    default:
                        return "UNKNOWN";
                }
        }
    }

    public NvError(int i) {
        this.f6584a = i;
    }

    public NvError(int i, String str) {
        this.f6584a = i;
        this.f6585b = str;
    }

    public NvError(int i, String str, Object obj) {
        this.f6584a = i;
        this.f6585b = str;
        this.f6586c = obj;
    }

    /* renamed from: a */
    public int m6630a() {
        return this.f6584a;
    }

    /* renamed from: b */
    public String m6632b() {
        return this.f6585b;
    }

    /* renamed from: c */
    public Object m6633c() {
        return this.f6586c;
    }

    /* renamed from: a */
    public void m6631a(Object obj) {
        this.f6586c = obj;
    }

    public String toString() {
        return "NvError{code=" + this.f6584a + ", msg='" + this.f6585b + "'}";
    }
}