package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a */
    public final String f7200a;

    /* renamed from: b */
    public final String f7201b;

    /* renamed from: c */
    public final String f7202c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f7200a = str;
        this.f7201b = str2;
        this.f7202c = str3;
    }

    public String toString() {
        return "plid:" + this.f7200a + " plV:" + this.f7201b + " plUUID:" + this.f7202c;
    }

    public PlugInBean(Parcel parcel) {
        this.f7200a = parcel.readString();
        this.f7201b = parcel.readString();
        this.f7202c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7200a);
        parcel.writeString(this.f7201b);
        parcel.writeString(this.f7202c);
    }
}
