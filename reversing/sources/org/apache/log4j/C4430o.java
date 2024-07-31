package org.apache.log4j;

/* renamed from: org.apache.log4j.o */
/* loaded from: classes2.dex */
class PropertyConfigurator {

    /* renamed from: a */
    String f11253a;

    /* renamed from: b */
    String f11254b;

    public PropertyConfigurator(String str, String str2) {
        this.f11253a = str;
        this.f11254b = str2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f11253a);
        stringBuffer.append("=");
        stringBuffer.append(this.f11254b);
        return stringBuffer.toString();
    }
}
