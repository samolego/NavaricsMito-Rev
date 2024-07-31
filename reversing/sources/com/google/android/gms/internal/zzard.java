package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public final class zzard {
    private final ByteBuffer bqu;

    /* loaded from: classes.dex */
    public static class zza extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zza(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 108(0x6c, float:1.51E-43)
                r0.<init>(r1)
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space (pos "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " limit "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = ")."
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzard.zza.<init>(int, int):void");
        }
    }

    private zzard(ByteBuffer byteBuffer) {
        this.bqu = byteBuffer;
        this.bqu.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzard(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r8 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zza(java.lang.CharSequence r6, byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzard.zza(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            zzb(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int zzag(int i, int i2) {
        return zzahl(i) + zzahi(i2);
    }

    public static int zzah(int i, int i2) {
        return zzahl(i) + zzahj(i2);
    }

    public static int zzahi(int i) {
        if (i >= 0) {
            return zzahn(i);
        }
        return 10;
    }

    public static int zzahj(int i) {
        return zzahn(zzahp(i));
    }

    public static int zzahl(int i) {
        return zzahn(zzarn.zzaj(i, 0));
    }

    public static int zzahn(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzahp(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzb(int i, double d) {
        return zzahl(i) + zzp(d);
    }

    public static int zzb(int i, zzark zzarkVar) {
        return (zzahl(i) * 2) + zzd(zzarkVar);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzahl(i) + zzbg(bArr);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            char c = charAt;
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i = (charAt >>> 6) | 960;
                } else if (charAt >= 55296 && 57343 >= charAt) {
                    int i3 = i2 + 1;
                    if (i3 != charSequence.length()) {
                        char charAt2 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt, charAt2)) {
                            int codePoint = Character.toCodePoint(charAt, charAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                            i2 = i3;
                            i2++;
                        } else {
                            i2 = i3;
                        }
                    }
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Unpaired surrogate at index ");
                    sb.append(i2 - 1);
                    throw new IllegalArgumentException(sb.toString());
                } else {
                    byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                    i = ((charAt >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) i);
                c = (charAt & '?') | 128;
            }
            byteBuffer.put((byte) c);
            i2++;
        }
    }

    public static zzard zzbe(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    public static int zzbg(byte[] bArr) {
        return zzahn(bArr.length) + bArr.length;
    }

    public static int zzc(int i, zzark zzarkVar) {
        return zzahl(i) + zze(zzarkVar);
    }

    public static zzard zzc(byte[] bArr, int i, int i2) {
        return new zzard(bArr, i, i2);
    }

    public static int zzd(int i, float f) {
        return zzahl(i) + zzl(f);
    }

    public static int zzd(zzark zzarkVar) {
        return zzarkVar.m9584db();
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += zza(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        long j = i2 + IjkMediaMeta.AV_CH_WIDE_RIGHT;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zzda(long j) {
        return zzdf(j);
    }

    public static int zzdb(long j) {
        return zzdf(j);
    }

    public static int zzdc(long j) {
        return 8;
    }

    public static int zzdd(long j) {
        return zzdf(zzdh(j));
    }

    public static int zzdf(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static long zzdh(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzdl(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzahl(i) + zzda(j);
    }

    public static int zze(zzark zzarkVar) {
        int m9584db = zzarkVar.m9584db();
        return zzahn(m9584db) + m9584db;
    }

    public static int zzf(int i, long j) {
        return zzahl(i) + zzdb(j);
    }

    public static int zzg(int i, long j) {
        return zzahl(i) + zzdc(j);
    }

    public static int zzh(int i, long j) {
        return zzahl(i) + zzdd(j);
    }

    public static int zzk(int i, boolean z) {
        return zzahl(i) + zzdl(z);
    }

    public static int zzl(float f) {
        return 4;
    }

    public static int zzp(double d) {
        return 8;
    }

    public static int zzs(int i, String str) {
        return zzahl(i) + zzuy(str);
    }

    public static int zzuy(String str) {
        int zzd = zzd(str);
        return zzahn(zzd) + zzd;
    }

    /* renamed from: cN */
    public int m9598cN() {
        return this.bqu.remaining();
    }

    /* renamed from: cO */
    public void m9597cO() {
        if (m9598cN() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzai(i, 1);
        zzo(d);
    }

    public void zza(int i, long j) throws IOException {
        zzai(i, 0);
        zzcw(j);
    }

    public void zza(int i, zzark zzarkVar) throws IOException {
        zzai(i, 2);
        zzc(zzarkVar);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzai(i, 2);
        zzbf(bArr);
    }

    public void zzae(int i, int i2) throws IOException {
        zzai(i, 0);
        zzahg(i2);
    }

    public void zzaf(int i, int i2) throws IOException {
        zzai(i, 0);
        zzahh(i2);
    }

    public void zzahg(int i) throws IOException {
        if (i >= 0) {
            zzahm(i);
        } else {
            zzde(i);
        }
    }

    public void zzahh(int i) throws IOException {
        zzahm(zzahp(i));
    }

    public void zzahk(int i) throws IOException {
        zzc((byte) i);
    }

    public void zzahm(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzahk((i & 127) | 128);
            i >>>= 7;
        }
        zzahk(i);
    }

    public void zzaho(int i) throws IOException {
        if (this.bqu.remaining() < 4) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.putInt(i);
    }

    public void zzai(int i, int i2) throws IOException {
        zzahm(zzarn.zzaj(i, i2));
    }

    public void zzb(int i, long j) throws IOException {
        zzai(i, 0);
        zzcx(j);
    }

    public void zzb(zzark zzarkVar) throws IOException {
        zzarkVar.zza(this);
    }

    public void zzbf(byte[] bArr) throws IOException {
        zzahm(bArr.length);
        zzbh(bArr);
    }

    public void zzbh(byte[] bArr) throws IOException {
        zzd(bArr, 0, bArr.length);
    }

    public void zzc(byte b) throws IOException {
        if (!this.bqu.hasRemaining()) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.put(b);
    }

    public void zzc(int i, float f) throws IOException {
        zzai(i, 5);
        zzk(f);
    }

    public void zzc(int i, long j) throws IOException {
        zzai(i, 1);
        zzcy(j);
    }

    public void zzc(zzark zzarkVar) throws IOException {
        zzahm(zzarkVar.m9585da());
        zzarkVar.zza(this);
    }

    public void zzcw(long j) throws IOException {
        zzde(j);
    }

    public void zzcx(long j) throws IOException {
        zzde(j);
    }

    public void zzcy(long j) throws IOException {
        zzdg(j);
    }

    public void zzcz(long j) throws IOException {
        zzde(zzdh(j));
    }

    public void zzd(int i, long j) throws IOException {
        zzai(i, 0);
        zzcz(j);
    }

    public void zzd(byte[] bArr, int i, int i2) throws IOException {
        if (this.bqu.remaining() < i2) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.put(bArr, i, i2);
    }

    public void zzde(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzahk((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzahk((int) j);
    }

    public void zzdg(long j) throws IOException {
        if (this.bqu.remaining() < 8) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.putLong(j);
    }

    public void zzdk(boolean z) throws IOException {
        zzahk(z ? 1 : 0);
    }

    public void zzj(int i, boolean z) throws IOException {
        zzai(i, 0);
        zzdk(z);
    }

    public void zzk(float f) throws IOException {
        zzaho(Float.floatToIntBits(f));
    }

    public void zzo(double d) throws IOException {
        zzdg(Double.doubleToLongBits(d));
    }

    public void zzr(int i, String str) throws IOException {
        zzai(i, 2);
        zzux(str);
    }

    public void zzux(String str) throws IOException {
        try {
            int zzahn = zzahn(str.length());
            if (zzahn != zzahn(str.length() * 3)) {
                zzahm(zzd(str));
                zza(str, this.bqu);
                return;
            }
            int position = this.bqu.position();
            if (this.bqu.remaining() < zzahn) {
                throw new zza(position + zzahn, this.bqu.limit());
            }
            this.bqu.position(position + zzahn);
            zza(str, this.bqu);
            int position2 = this.bqu.position();
            this.bqu.position(position);
            zzahm((position2 - position) - zzahn);
            this.bqu.position(position2);
        } catch (BufferOverflowException e) {
            zza zzaVar = new zza(this.bqu.position(), this.bqu.limit());
            zzaVar.initCause(e);
            throw zzaVar;
        }
    }
}
