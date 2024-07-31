package com.tencent.p075mm.opensdk.diffdev.p077a;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.g */
/* loaded from: classes2.dex */
public enum EnumC2515g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    
    private int code;

    EnumC2515g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
