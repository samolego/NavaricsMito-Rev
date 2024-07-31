package com.navatics.miya.util;

import com.senseplay.sdk.tool.IniEditor;

/* compiled from: IntArray.java */
/* renamed from: com.navatics.miya.b.f, reason: use source file name */
/* loaded from: classes.dex */
public class IntArray {

    /* renamed from: a */
    public int[] f6040a;

    /* renamed from: b */
    public int f6041b;

    /* renamed from: c */
    public boolean f6042c;

    public IntArray() {
        this(true, 16);
    }

    public IntArray(int i) {
        this(true, i);
    }

    public IntArray(boolean z, int i) {
        this.f6042c = z;
        this.f6040a = new int[i];
    }

    public int hashCode() {
        if (!this.f6042c) {
            return super.hashCode();
        }
        int[] iArr = this.f6040a;
        int i = this.f6041b;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    public boolean equals(Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (!this.f6042c || !(obj instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray) obj;
        if (!intArray.f6042c || (i = this.f6041b) != intArray.f6041b) {
            return false;
        }
        int[] iArr = this.f6040a;
        int[] iArr2 = intArray.f6040a;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f6040a[i2] != intArray.f6040a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f6041b == 0) {
            return "[]";
        }
        int[] iArr = this.f6040a;
        StringBuilder sb = new StringBuilder(32);
        sb.append(IniEditor.Section.HEADER_START);
        sb.append(iArr[0]);
        for (int i = 1; i < this.f6041b; i++) {
            sb.append(", ");
            sb.append(iArr[i]);
        }
        sb.append(IniEditor.Section.HEADER_END);
        return sb.toString();
    }
}