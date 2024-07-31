package com.navatics.robot.transport;

/* renamed from: com.navatics.robot.transport.m */
/* loaded from: classes.dex */
public class NvError {

    /* renamed from: a */
    private int f6555a;

    /* renamed from: b */
    private String f6556b;

    /* renamed from: c */
    private Object f6557c;

    /* renamed from: a */
    public static String m6265a(int i) {
        if (i != 0) {
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
        return "SUCCESS";
    }

    public NvError(int i) {
        this.f6555a = i;
    }

    public NvError(int i, String str) {
        this.f6555a = i;
        this.f6556b = str;
    }

    public NvError(int i, String str, Object obj) {
        this.f6555a = i;
        this.f6556b = str;
        this.f6557c = obj;
    }

    /* renamed from: a */
    public int m6266a() {
        return this.f6555a;
    }

    /* renamed from: b */
    public String m6263b() {
        return this.f6556b;
    }

    /* renamed from: c */
    public Object m6262c() {
        return this.f6557c;
    }

    /* renamed from: a */
    public void m6264a(Object obj) {
        this.f6557c = obj;
    }

    public String toString() {
        return "NvError{code=" + this.f6555a + ", msg='" + this.f6556b + "'}";
    }
}
