package com.navatics.miya.p060b;

import com.senseplay.sdk.tool.IniEditor;

/* renamed from: com.navatics.miya.b.f */
/* loaded from: classes.dex */
public class IntArray {

    /* renamed from: a */
    public int[] f6015a;

    /* renamed from: b */
    public int f6016b;

    /* renamed from: c */
    public boolean f6017c;

    public IntArray() {
        this(true, 16);
    }

    public IntArray(int i) {
        this(true, i);
    }

    public IntArray(boolean z, int i) {
        this.f6017c = z;
        this.f6015a = new int[i];
    }

    public int hashCode() {
        if (this.f6017c) {
            int[] iArr = this.f6015a;
            int i = this.f6016b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + iArr[i3];
            }
            return i2;
        }
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (this.f6017c && (obj instanceof IntArray)) {
            IntArray intArray = (IntArray) obj;
            if (intArray.f6017c && (i = this.f6016b) == intArray.f6016b) {
                int[] iArr = this.f6015a;
                int[] iArr2 = intArray.f6015a;
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.f6015a[i2] != intArray.f6015a[i2]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        if (this.f6016b == 0) {
            return "[]";
        }
        int[] iArr = this.f6015a;
        StringBuilder sb = new StringBuilder(32);
        sb.append(IniEditor.Section.HEADER_START);
        sb.append(iArr[0]);
        for (int i = 1; i < this.f6016b; i++) {
            sb.append(", ");
            sb.append(iArr[i]);
        }
        sb.append(IniEditor.Section.HEADER_END);
        return sb.toString();
    }
}
