package org.apache.ftpserver.util;

/* compiled from: RegularExpr.java */
/* renamed from: org.apache.ftpserver.util.d, reason: use source file name */
/* loaded from: classes2.dex */
public class RegularExpr {

    /* renamed from: a */
    private char[] f11186a;

    public RegularExpr(String str) {
        this.f11186a = str.toCharArray();
    }

    /* renamed from: a */
    public boolean m11213a(String str) {
        char[] cArr = this.f11186a;
        if (cArr.length == 1 && cArr[0] == '*') {
            return true;
        }
        return m11212a(str.toCharArray(), 0, 0);
    }

    /* renamed from: a */
    private boolean m11212a(char[] cArr, int i, int i2) {
        while (true) {
            char[] cArr2 = this.f11186a;
            if (i2 >= cArr2.length) {
                return i == cArr.length;
            }
            int i3 = i2 + 1;
            char c = cArr2[i2];
            if (c != '*') {
                if (c != '?') {
                    if (c == '[') {
                        if (i >= cArr.length) {
                            return false;
                        }
                        int i4 = i + 1;
                        char c2 = cArr[i];
                        boolean z = false;
                        boolean z2 = true;
                        boolean z3 = false;
                        char c3 = 0;
                        while (true) {
                            char[] cArr3 = this.f11186a;
                            if (i3 >= cArr3.length) {
                                return false;
                            }
                            int i5 = i3 + 1;
                            char c4 = cArr3[i3];
                            if (c4 == ']') {
                                if (z2) {
                                    z = true;
                                }
                                if (z3) {
                                    if (z) {
                                        return false;
                                    }
                                } else if (!z) {
                                    return false;
                                }
                                i = i4;
                                i2 = i5;
                            } else if (z) {
                                i3 = i5;
                            } else if (c4 == '^' && z2) {
                                i3 = i5;
                                z3 = true;
                            } else if (c4 == '-') {
                                char[] cArr4 = this.f11186a;
                                if (i5 >= cArr4.length) {
                                    return false;
                                }
                                i3 = i5 + 1;
                                char c5 = cArr4[i5];
                                boolean z4 = c2 >= c3 && c2 <= c5;
                                c3 = c5;
                                z = z4;
                                z2 = false;
                            } else {
                                z = c4 == c2;
                                c3 = c4;
                                i3 = i5;
                                z2 = false;
                            }
                        }
                    } else {
                        if (i >= cArr.length) {
                            return false;
                        }
                        int i6 = i + 1;
                        if (cArr[i] != c) {
                            return false;
                        }
                        i = i6;
                        i2 = i3;
                    }
                } else {
                    if (i >= cArr.length) {
                        return false;
                    }
                    i++;
                    i2 = i3;
                }
            } else {
                if (i3 >= cArr2.length) {
                    return true;
                }
                while (true) {
                    int i7 = i + 1;
                    if (m11212a(cArr, i, i3)) {
                        return true;
                    }
                    if (i7 >= cArr.length) {
                        return false;
                    }
                    i = i7;
                }
            }
        }
    }
}