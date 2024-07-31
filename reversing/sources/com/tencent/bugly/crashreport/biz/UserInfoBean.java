package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C2503z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i) {
            return new UserInfoBean[i];
        }
    };

    /* renamed from: a */
    public long f7152a;

    /* renamed from: b */
    public int f7153b;

    /* renamed from: c */
    public String f7154c;

    /* renamed from: d */
    public String f7155d;

    /* renamed from: e */
    public long f7156e;

    /* renamed from: f */
    public long f7157f;

    /* renamed from: g */
    public long f7158g;

    /* renamed from: h */
    public long f7159h;

    /* renamed from: i */
    public long f7160i;

    /* renamed from: j */
    public String f7161j;

    /* renamed from: k */
    public long f7162k;

    /* renamed from: l */
    public boolean f7163l;

    /* renamed from: m */
    public String f7164m;

    /* renamed from: n */
    public String f7165n;

    /* renamed from: o */
    public int f7166o;

    /* renamed from: p */
    public int f7167p;

    /* renamed from: q */
    public int f7168q;

    /* renamed from: r */
    public Map<String, String> f7169r;

    /* renamed from: s */
    public Map<String, String> f7170s;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserInfoBean() {
        this.f7162k = 0L;
        this.f7163l = false;
        this.f7164m = "unknown";
        this.f7167p = -1;
        this.f7168q = -1;
        this.f7169r = null;
        this.f7170s = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.f7162k = 0L;
        this.f7163l = false;
        this.f7164m = "unknown";
        this.f7167p = -1;
        this.f7168q = -1;
        this.f7169r = null;
        this.f7170s = null;
        this.f7153b = parcel.readInt();
        this.f7154c = parcel.readString();
        this.f7155d = parcel.readString();
        this.f7156e = parcel.readLong();
        this.f7157f = parcel.readLong();
        this.f7158g = parcel.readLong();
        this.f7159h = parcel.readLong();
        this.f7160i = parcel.readLong();
        this.f7161j = parcel.readString();
        this.f7162k = parcel.readLong();
        this.f7163l = parcel.readByte() == 1;
        this.f7164m = parcel.readString();
        this.f7167p = parcel.readInt();
        this.f7168q = parcel.readInt();
        this.f7169r = C2503z.m5028b(parcel);
        this.f7170s = C2503z.m5028b(parcel);
        this.f7165n = parcel.readString();
        this.f7166o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7153b);
        parcel.writeString(this.f7154c);
        parcel.writeString(this.f7155d);
        parcel.writeLong(this.f7156e);
        parcel.writeLong(this.f7157f);
        parcel.writeLong(this.f7158g);
        parcel.writeLong(this.f7159h);
        parcel.writeLong(this.f7160i);
        parcel.writeString(this.f7161j);
        parcel.writeLong(this.f7162k);
        parcel.writeByte(this.f7163l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7164m);
        parcel.writeInt(this.f7167p);
        parcel.writeInt(this.f7168q);
        C2503z.m5027b(parcel, this.f7169r);
        C2503z.m5027b(parcel, this.f7170s);
        parcel.writeString(this.f7165n);
        parcel.writeInt(this.f7166o);
    }
}
