package org.apache.ftpserver.p099a.p100a.p101a;

/* compiled from: ListArgument.java */
/* renamed from: org.apache.ftpserver.a.a.a.e, reason: use source file name */
/* loaded from: classes2.dex */
public class ListArgument {

    /* renamed from: a */
    private final String f10907a;

    /* renamed from: b */
    private final String f10908b;

    /* renamed from: c */
    private final char[] f10909c;

    public ListArgument(String str, String str2, char[] cArr) {
        this.f10907a = str;
        this.f10908b = str2;
        if (cArr == null) {
            this.f10909c = new char[0];
        } else {
            this.f10909c = (char[]) cArr.clone();
        }
    }

    /* renamed from: a */
    public String m10850a() {
        return this.f10908b;
    }

    /* renamed from: a */
    public boolean m10851a(char c) {
        int i = 0;
        while (true) {
            char[] cArr = this.f10909c;
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
    public String m10852b() {
        return this.f10907a;
    }
}