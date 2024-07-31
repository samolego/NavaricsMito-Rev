package org.apache.ftpserver.p110a.p111a.p112a;

/* renamed from: org.apache.ftpserver.a.a.a.e */
/* loaded from: classes2.dex */
public class ListArgument {

    /* renamed from: a */
    private final String f10866a;

    /* renamed from: b */
    private final String f10867b;

    /* renamed from: c */
    private final char[] f10868c;

    public ListArgument(String str, String str2, char[] cArr) {
        this.f10866a = str;
        this.f10867b = str2;
        if (cArr == null) {
            this.f10868c = new char[0];
        } else {
            this.f10868c = (char[]) cArr.clone();
        }
    }

    /* renamed from: a */
    public String m1988a() {
        return this.f10867b;
    }

    /* renamed from: a */
    public boolean m1987a(char c) {
        int i = 0;
        while (true) {
            char[] cArr = this.f10868c;
            if (i >= cArr.length) {
                return false;
            }
            if (c == cArr[i]) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: b */
    public String m1986b() {
        return this.f10866a;
    }
}
