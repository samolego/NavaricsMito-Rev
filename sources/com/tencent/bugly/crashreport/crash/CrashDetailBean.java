package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C2503z;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };

    /* renamed from: A */
    public String f7327A;

    /* renamed from: B */
    public String f7328B;

    /* renamed from: C */
    public long f7329C;

    /* renamed from: D */
    public long f7330D;

    /* renamed from: E */
    public long f7331E;

    /* renamed from: F */
    public long f7332F;

    /* renamed from: G */
    public long f7333G;

    /* renamed from: H */
    public long f7334H;

    /* renamed from: I */
    public String f7335I;

    /* renamed from: J */
    public String f7336J;

    /* renamed from: K */
    public String f7337K;

    /* renamed from: L */
    public String f7338L;

    /* renamed from: M */
    public long f7339M;

    /* renamed from: N */
    public boolean f7340N;

    /* renamed from: O */
    public Map<String, String> f7341O;

    /* renamed from: P */
    public int f7342P;

    /* renamed from: Q */
    public int f7343Q;

    /* renamed from: R */
    public Map<String, String> f7344R;

    /* renamed from: S */
    public Map<String, String> f7345S;

    /* renamed from: T */
    public byte[] f7346T;

    /* renamed from: U */
    public String f7347U;

    /* renamed from: V */
    public String f7348V;

    /* renamed from: W */
    private String f7349W;

    /* renamed from: a */
    public long f7350a;

    /* renamed from: b */
    public int f7351b;

    /* renamed from: c */
    public String f7352c;

    /* renamed from: d */
    public boolean f7353d;

    /* renamed from: e */
    public String f7354e;

    /* renamed from: f */
    public String f7355f;

    /* renamed from: g */
    public String f7356g;

    /* renamed from: h */
    public Map<String, PlugInBean> f7357h;

    /* renamed from: i */
    public Map<String, PlugInBean> f7358i;

    /* renamed from: j */
    public boolean f7359j;

    /* renamed from: k */
    public boolean f7360k;

    /* renamed from: l */
    public int f7361l;

    /* renamed from: m */
    public String f7362m;

    /* renamed from: n */
    public String f7363n;

    /* renamed from: o */
    public String f7364o;

    /* renamed from: p */
    public String f7365p;

    /* renamed from: q */
    public String f7366q;

    /* renamed from: r */
    public long f7367r;

    /* renamed from: s */
    public String f7368s;

    /* renamed from: t */
    public int f7369t;

    /* renamed from: u */
    public String f7370u;

    /* renamed from: v */
    public String f7371v;

    /* renamed from: w */
    public String f7372w;

    /* renamed from: x */
    public String f7373x;

    /* renamed from: y */
    public byte[] f7374y;

    /* renamed from: z */
    public Map<String, String> f7375z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        int i;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null || this.f7367r - crashDetailBean2.f7367r > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }

    public CrashDetailBean() {
        this.f7350a = -1L;
        this.f7351b = 0;
        this.f7352c = UUID.randomUUID().toString();
        this.f7353d = false;
        this.f7354e = "";
        this.f7355f = "";
        this.f7356g = "";
        this.f7357h = null;
        this.f7358i = null;
        this.f7359j = false;
        this.f7360k = false;
        this.f7361l = 0;
        this.f7362m = "";
        this.f7363n = "";
        this.f7364o = "";
        this.f7365p = "";
        this.f7366q = "";
        this.f7367r = -1L;
        this.f7368s = null;
        this.f7369t = 0;
        this.f7370u = "";
        this.f7371v = "";
        this.f7372w = null;
        this.f7373x = null;
        this.f7374y = null;
        this.f7375z = null;
        this.f7327A = "";
        this.f7328B = "";
        this.f7329C = -1L;
        this.f7330D = -1L;
        this.f7331E = -1L;
        this.f7332F = -1L;
        this.f7333G = -1L;
        this.f7334H = -1L;
        this.f7335I = "";
        this.f7349W = "";
        this.f7336J = "";
        this.f7337K = "";
        this.f7338L = "";
        this.f7339M = -1L;
        this.f7340N = false;
        this.f7341O = null;
        this.f7342P = -1;
        this.f7343Q = -1;
        this.f7344R = null;
        this.f7345S = null;
        this.f7346T = null;
        this.f7347U = null;
        this.f7348V = null;
    }

    public CrashDetailBean(Parcel parcel) {
        this.f7350a = -1L;
        this.f7351b = 0;
        this.f7352c = UUID.randomUUID().toString();
        this.f7353d = false;
        this.f7354e = "";
        this.f7355f = "";
        this.f7356g = "";
        this.f7357h = null;
        this.f7358i = null;
        this.f7359j = false;
        this.f7360k = false;
        this.f7361l = 0;
        this.f7362m = "";
        this.f7363n = "";
        this.f7364o = "";
        this.f7365p = "";
        this.f7366q = "";
        this.f7367r = -1L;
        this.f7368s = null;
        this.f7369t = 0;
        this.f7370u = "";
        this.f7371v = "";
        this.f7372w = null;
        this.f7373x = null;
        this.f7374y = null;
        this.f7375z = null;
        this.f7327A = "";
        this.f7328B = "";
        this.f7329C = -1L;
        this.f7330D = -1L;
        this.f7331E = -1L;
        this.f7332F = -1L;
        this.f7333G = -1L;
        this.f7334H = -1L;
        this.f7335I = "";
        this.f7349W = "";
        this.f7336J = "";
        this.f7337K = "";
        this.f7338L = "";
        this.f7339M = -1L;
        this.f7340N = false;
        this.f7341O = null;
        this.f7342P = -1;
        this.f7343Q = -1;
        this.f7344R = null;
        this.f7345S = null;
        this.f7346T = null;
        this.f7347U = null;
        this.f7348V = null;
        this.f7351b = parcel.readInt();
        this.f7352c = parcel.readString();
        this.f7353d = parcel.readByte() == 1;
        this.f7354e = parcel.readString();
        this.f7355f = parcel.readString();
        this.f7356g = parcel.readString();
        this.f7359j = parcel.readByte() == 1;
        this.f7360k = parcel.readByte() == 1;
        this.f7361l = parcel.readInt();
        this.f7362m = parcel.readString();
        this.f7363n = parcel.readString();
        this.f7364o = parcel.readString();
        this.f7365p = parcel.readString();
        this.f7366q = parcel.readString();
        this.f7367r = parcel.readLong();
        this.f7368s = parcel.readString();
        this.f7369t = parcel.readInt();
        this.f7370u = parcel.readString();
        this.f7371v = parcel.readString();
        this.f7372w = parcel.readString();
        this.f7375z = C2503z.m5028b(parcel);
        this.f7327A = parcel.readString();
        this.f7328B = parcel.readString();
        this.f7329C = parcel.readLong();
        this.f7330D = parcel.readLong();
        this.f7331E = parcel.readLong();
        this.f7332F = parcel.readLong();
        this.f7333G = parcel.readLong();
        this.f7334H = parcel.readLong();
        this.f7335I = parcel.readString();
        this.f7349W = parcel.readString();
        this.f7336J = parcel.readString();
        this.f7337K = parcel.readString();
        this.f7338L = parcel.readString();
        this.f7339M = parcel.readLong();
        this.f7340N = parcel.readByte() == 1;
        this.f7341O = C2503z.m5028b(parcel);
        this.f7357h = C2503z.m5053a(parcel);
        this.f7358i = C2503z.m5053a(parcel);
        this.f7342P = parcel.readInt();
        this.f7343Q = parcel.readInt();
        this.f7344R = C2503z.m5028b(parcel);
        this.f7345S = C2503z.m5028b(parcel);
        this.f7346T = parcel.createByteArray();
        this.f7374y = parcel.createByteArray();
        this.f7347U = parcel.readString();
        this.f7348V = parcel.readString();
        this.f7373x = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7351b);
        parcel.writeString(this.f7352c);
        parcel.writeByte(this.f7353d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7354e);
        parcel.writeString(this.f7355f);
        parcel.writeString(this.f7356g);
        parcel.writeByte(this.f7359j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7360k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f7361l);
        parcel.writeString(this.f7362m);
        parcel.writeString(this.f7363n);
        parcel.writeString(this.f7364o);
        parcel.writeString(this.f7365p);
        parcel.writeString(this.f7366q);
        parcel.writeLong(this.f7367r);
        parcel.writeString(this.f7368s);
        parcel.writeInt(this.f7369t);
        parcel.writeString(this.f7370u);
        parcel.writeString(this.f7371v);
        parcel.writeString(this.f7372w);
        C2503z.m5027b(parcel, this.f7375z);
        parcel.writeString(this.f7327A);
        parcel.writeString(this.f7328B);
        parcel.writeLong(this.f7329C);
        parcel.writeLong(this.f7330D);
        parcel.writeLong(this.f7331E);
        parcel.writeLong(this.f7332F);
        parcel.writeLong(this.f7333G);
        parcel.writeLong(this.f7334H);
        parcel.writeString(this.f7335I);
        parcel.writeString(this.f7349W);
        parcel.writeString(this.f7336J);
        parcel.writeString(this.f7337K);
        parcel.writeString(this.f7338L);
        parcel.writeLong(this.f7339M);
        parcel.writeByte(this.f7340N ? (byte) 1 : (byte) 0);
        C2503z.m5027b(parcel, this.f7341O);
        C2503z.m5052a(parcel, this.f7357h);
        C2503z.m5052a(parcel, this.f7358i);
        parcel.writeInt(this.f7342P);
        parcel.writeInt(this.f7343Q);
        C2503z.m5027b(parcel, this.f7344R);
        C2503z.m5027b(parcel, this.f7345S);
        parcel.writeByteArray(this.f7346T);
        parcel.writeByteArray(this.f7374y);
        parcel.writeString(this.f7347U);
        parcel.writeString(this.f7348V);
        parcel.writeString(this.f7373x);
    }
}
