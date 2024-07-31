package com.google.android.gms.internal;

import com.common.AUTOMATIVE_LIGHT;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzarc {
    private int bql;
    private int bqm;
    private int bqn;
    private int bqo;
    private int bqp;
    private int bqr;
    private final byte[] buffer;
    private int bqq = Integer.MAX_VALUE;
    private int bqs = 64;
    private int bqt = 67108864;

    private zzarc(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bql = i;
        this.bqm = i2 + i;
        this.bqo = i;
    }

    /* renamed from: cJ */
    private void m9606cJ() {
        this.bqm += this.bqn;
        int i = this.bqm;
        int i2 = this.bqq;
        if (i <= i2) {
            this.bqn = 0;
            return;
        }
        this.bqn = i - i2;
        this.bqm = i - this.bqn;
    }

    public static int zzahb(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static zzarc zzb(byte[] bArr, int i, int i2) {
        return new zzarc(bArr, i, i2);
    }

    public static zzarc zzbd(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static long zzcv(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* renamed from: cA */
    public int m9615cA() throws IOException {
        return m9610cF();
    }

    /* renamed from: cB */
    public long m9614cB() throws IOException {
        return m9607cI();
    }

    /* renamed from: cC */
    public boolean m9613cC() throws IOException {
        return m9610cF() != 0;
    }

    /* renamed from: cD */
    public int m9612cD() throws IOException {
        return zzahb(m9610cF());
    }

    /* renamed from: cE */
    public long m9611cE() throws IOException {
        return zzcv(m9609cG());
    }

    /* renamed from: cF */
    public int m9610cF() throws IOException {
        int i;
        byte m9603cM = m9603cM();
        if (m9603cM >= 0) {
            return m9603cM;
        }
        int i2 = m9603cM & Byte.MAX_VALUE;
        byte m9603cM2 = m9603cM();
        if (m9603cM2 >= 0) {
            i = m9603cM2 << 7;
        } else {
            i2 |= (m9603cM2 & Byte.MAX_VALUE) << 7;
            byte m9603cM3 = m9603cM();
            if (m9603cM3 >= 0) {
                i = m9603cM3 << 14;
            } else {
                i2 |= (m9603cM3 & Byte.MAX_VALUE) << 14;
                byte m9603cM4 = m9603cM();
                if (m9603cM4 < 0) {
                    int i3 = i2 | ((m9603cM4 & Byte.MAX_VALUE) << 21);
                    byte m9603cM5 = m9603cM();
                    int i4 = i3 | (m9603cM5 << 28);
                    if (m9603cM5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (m9603cM() >= 0) {
                                return i4;
                            }
                        }
                        throw zzarj.m9591cV();
                    }
                    return i4;
                }
                i = m9603cM4 << 21;
            }
        }
        return i2 | i;
    }

    /* renamed from: cG */
    public long m9609cG() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m9603cM = m9603cM();
            j |= (m9603cM & Byte.MAX_VALUE) << i;
            if ((m9603cM & AUTOMATIVE_LIGHT.OVERTURN) == 0) {
                return j;
            }
        }
        throw zzarj.m9591cV();
    }

    /* renamed from: cH */
    public int m9608cH() throws IOException {
        return (m9603cM() & 255) | ((m9603cM() & 255) << 8) | ((m9603cM() & 255) << 16) | ((m9603cM() & 255) << 24);
    }

    /* renamed from: cI */
    public long m9607cI() throws IOException {
        byte m9603cM = m9603cM();
        byte m9603cM2 = m9603cM();
        return ((m9603cM2 & 255) << 8) | (m9603cM & 255) | ((m9603cM() & 255) << 16) | ((m9603cM() & 255) << 24) | ((m9603cM() & 255) << 32) | ((m9603cM() & 255) << 40) | ((m9603cM() & 255) << 48) | ((m9603cM() & 255) << 56);
    }

    /* renamed from: cK */
    public int m9605cK() {
        int i = this.bqq;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.bqo;
    }

    /* renamed from: cL */
    public boolean m9604cL() {
        return this.bqo == this.bqm;
    }

    /* renamed from: cM */
    public byte m9603cM() throws IOException {
        int i = this.bqo;
        if (i != this.bqm) {
            byte[] bArr = this.buffer;
            this.bqo = i + 1;
            return bArr[i];
        }
        throw zzarj.m9593cT();
    }

    /* renamed from: cw */
    public int m9602cw() throws IOException {
        if (m9604cL()) {
            this.bqp = 0;
            return 0;
        }
        this.bqp = m9610cF();
        int i = this.bqp;
        if (i != 0) {
            return i;
        }
        throw zzarj.m9590cW();
    }

    /* renamed from: cx */
    public void m9601cx() throws IOException {
        int m9602cw;
        do {
            m9602cw = m9602cw();
            if (m9602cw == 0) {
                return;
            }
        } while (zzaha(m9602cw));
    }

    /* renamed from: cy */
    public long m9600cy() throws IOException {
        return m9609cG();
    }

    /* renamed from: cz */
    public long m9599cz() throws IOException {
        return m9609cG();
    }

    public int getPosition() {
        return this.bqo - this.bql;
    }

    public byte[] readBytes() throws IOException {
        int m9610cF = m9610cF();
        if (m9610cF >= 0) {
            if (m9610cF == 0) {
                return zzarn.bqM;
            }
            int i = this.bqm;
            int i2 = this.bqo;
            if (m9610cF <= i - i2) {
                byte[] bArr = new byte[m9610cF];
                System.arraycopy(this.buffer, i2, bArr, 0, m9610cF);
                this.bqo += m9610cF;
                return bArr;
            }
            throw zzarj.m9593cT();
        }
        throw zzarj.m9592cU();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(m9607cI());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(m9608cH());
    }

    public String readString() throws IOException {
        int m9610cF = m9610cF();
        if (m9610cF >= 0) {
            int i = this.bqm;
            int i2 = this.bqo;
            if (m9610cF <= i - i2) {
                String str = new String(this.buffer, i2, m9610cF, zzari.UTF_8);
                this.bqo += m9610cF;
                return str;
            }
            throw zzarj.m9593cT();
        }
        throw zzarj.m9592cU();
    }

    public void zza(zzark zzarkVar) throws IOException {
        int m9610cF = m9610cF();
        if (this.bqr >= this.bqs) {
            throw zzarj.m9587cZ();
        }
        int zzahc = zzahc(m9610cF);
        this.bqr++;
        zzarkVar.zzb(this);
        zzagz(0);
        this.bqr--;
        zzahd(zzahc);
    }

    public void zza(zzark zzarkVar, int i) throws IOException {
        int i2 = this.bqr;
        if (i2 >= this.bqs) {
            throw zzarj.m9587cZ();
        }
        this.bqr = i2 + 1;
        zzarkVar.zzb(this);
        zzagz(zzarn.zzaj(i, 4));
        this.bqr--;
    }

    public byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzarn.bqM;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.bql + i, bArr, 0, i2);
        return bArr;
    }

    public void zzagz(int i) throws zzarj {
        if (this.bqp != i) {
            throw zzarj.m9589cX();
        }
    }

    public boolean zzaha(int i) throws IOException {
        switch (zzarn.zzaht(i)) {
            case 0:
                m9615cA();
                return true;
            case 1:
                m9607cI();
                return true;
            case 2:
                zzahf(m9610cF());
                return true;
            case 3:
                m9601cx();
                zzagz(zzarn.zzaj(zzarn.zzahu(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m9608cH();
                return true;
            default:
                throw zzarj.m9588cY();
        }
    }

    public int zzahc(int i) throws zzarj {
        if (i >= 0) {
            int i2 = i + this.bqo;
            int i3 = this.bqq;
            if (i2 <= i3) {
                this.bqq = i2;
                m9606cJ();
                return i3;
            }
            throw zzarj.m9593cT();
        }
        throw zzarj.m9592cU();
    }

    public void zzahd(int i) {
        this.bqq = i;
        m9606cJ();
    }

    public void zzahe(int i) {
        int i2 = this.bqo;
        int i3 = this.bql;
        if (i <= i2 - i3) {
            if (i >= 0) {
                this.bqo = i3 + i;
                return;
            }
            StringBuilder sb = new StringBuilder(24);
            sb.append("Bad position ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        int i4 = i2 - i3;
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("Position ");
        sb2.append(i);
        sb2.append(" is beyond current ");
        sb2.append(i4);
        throw new IllegalArgumentException(sb2.toString());
    }

    public void zzahf(int i) throws IOException {
        if (i < 0) {
            throw zzarj.m9592cU();
        }
        int i2 = this.bqo;
        int i3 = i2 + i;
        int i4 = this.bqq;
        if (i3 > i4) {
            zzahf(i4 - i2);
            throw zzarj.m9593cT();
        } else if (i > this.bqm - i2) {
            throw zzarj.m9593cT();
        } else {
            this.bqo = i2 + i;
        }
    }
}
