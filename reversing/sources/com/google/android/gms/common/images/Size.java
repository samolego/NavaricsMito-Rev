package com.google.android.gms.common.images;

/* loaded from: classes.dex */
public final class Size {
    private final int zzajw;
    private final int zzajx;

    public Size(int i, int i2) {
        this.zzajw = i;
        this.zzajx = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zzhp(str);
                }
            }
            throw zzhp(str);
        }
        throw new IllegalArgumentException("string must not be null");
    }

    private static NumberFormatException zzhp(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zzajw == size.zzajw && this.zzajx == size.zzajx;
        }
        return false;
    }

    public int getHeight() {
        return this.zzajx;
    }

    public int getWidth() {
        return this.zzajw;
    }

    public int hashCode() {
        int i = this.zzajx;
        int i2 = this.zzajw;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        int i = this.zzajw;
        int i2 = this.zzajx;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
