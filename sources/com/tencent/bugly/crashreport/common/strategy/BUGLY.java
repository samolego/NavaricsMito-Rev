package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C2503z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i) {
            return new StrategyBean[i];
        }
    };

    /* renamed from: a */
    public static String f7286a = "http://rqd.uu.qq.com/rqd/sync";

    /* renamed from: b */
    public static String f7287b = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public static String f7288c = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: d */
    public static String f7289d;

    /* renamed from: e */
    public long f7290e;

    /* renamed from: f */
    public long f7291f;

    /* renamed from: g */
    public boolean f7292g;

    /* renamed from: h */
    public boolean f7293h;

    /* renamed from: i */
    public boolean f7294i;

    /* renamed from: j */
    public boolean f7295j;

    /* renamed from: k */
    public boolean f7296k;

    /* renamed from: l */
    public boolean f7297l;

    /* renamed from: m */
    public boolean f7298m;

    /* renamed from: n */
    public boolean f7299n;

    /* renamed from: o */
    public boolean f7300o;

    /* renamed from: p */
    public long f7301p;

    /* renamed from: q */
    public long f7302q;

    /* renamed from: r */
    public String f7303r;

    /* renamed from: s */
    public String f7304s;

    /* renamed from: t */
    public String f7305t;

    /* renamed from: u */
    public String f7306u;

    /* renamed from: v */
    public Map<String, String> f7307v;

    /* renamed from: w */
    public int f7308w;

    /* renamed from: x */
    public long f7309x;

    /* renamed from: y */
    public long f7310y;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.f7290e = -1L;
        this.f7291f = -1L;
        this.f7292g = true;
        this.f7293h = true;
        this.f7294i = true;
        this.f7295j = true;
        this.f7296k = false;
        this.f7297l = true;
        this.f7298m = true;
        this.f7299n = true;
        this.f7300o = true;
        this.f7302q = 30000L;
        this.f7303r = f7287b;
        this.f7304s = f7288c;
        this.f7305t = f7286a;
        this.f7308w = 10;
        this.f7309x = 300000L;
        this.f7310y = -1L;
        this.f7291f = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L");
        sb.append("@)");
        f7289d = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K");
        sb.append("@!");
        this.f7306u = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.f7290e = -1L;
        this.f7291f = -1L;
        boolean z = true;
        this.f7292g = true;
        this.f7293h = true;
        this.f7294i = true;
        this.f7295j = true;
        this.f7296k = false;
        this.f7297l = true;
        this.f7298m = true;
        this.f7299n = true;
        this.f7300o = true;
        this.f7302q = 30000L;
        this.f7303r = f7287b;
        this.f7304s = f7288c;
        this.f7305t = f7286a;
        this.f7308w = 10;
        this.f7309x = 300000L;
        this.f7310y = -1L;
        try {
            f7289d = "S(@L@L@)";
            this.f7291f = parcel.readLong();
            this.f7292g = parcel.readByte() == 1;
            this.f7293h = parcel.readByte() == 1;
            this.f7294i = parcel.readByte() == 1;
            this.f7303r = parcel.readString();
            this.f7304s = parcel.readString();
            this.f7306u = parcel.readString();
            this.f7307v = C2503z.m5028b(parcel);
            this.f7295j = parcel.readByte() == 1;
            this.f7296k = parcel.readByte() == 1;
            this.f7299n = parcel.readByte() == 1;
            this.f7300o = parcel.readByte() == 1;
            this.f7302q = parcel.readLong();
            this.f7297l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f7298m = z;
            this.f7301p = parcel.readLong();
            this.f7308w = parcel.readInt();
            this.f7309x = parcel.readLong();
            this.f7310y = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7291f);
        parcel.writeByte(this.f7292g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7293h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7294i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7303r);
        parcel.writeString(this.f7304s);
        parcel.writeString(this.f7306u);
        C2503z.m5027b(parcel, this.f7307v);
        parcel.writeByte(this.f7295j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7296k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7299n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7300o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f7302q);
        parcel.writeByte(this.f7297l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7298m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f7301p);
        parcel.writeInt(this.f7308w);
        parcel.writeLong(this.f7309x);
        parcel.writeLong(this.f7310y);
    }
}
