package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() { // from class: com.facebook.share.model.GameRequestContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    };

    /* renamed from: a */
    private final String f2423a;

    /* renamed from: b */
    private final List<String> f2424b;

    /* renamed from: c */
    private final String f2425c;

    /* renamed from: d */
    private final String f2426d;

    /* renamed from: e */
    private final ActionType f2427e;

    /* renamed from: f */
    private final String f2428f;

    /* renamed from: g */
    private final Filters f2429g;

    /* renamed from: h */
    private final List<String> f2430h;

    /* loaded from: classes.dex */
    public enum ActionType {
        SEND,
        ASKFOR,
        TURN
    }

    /* loaded from: classes.dex */
    public enum Filters {
        APP_USERS,
        APP_NON_USERS
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    GameRequestContent(Parcel parcel) {
        this.f2423a = parcel.readString();
        this.f2424b = parcel.createStringArrayList();
        this.f2425c = parcel.readString();
        this.f2426d = parcel.readString();
        this.f2427e = (ActionType) parcel.readSerializable();
        this.f2428f = parcel.readString();
        this.f2429g = (Filters) parcel.readSerializable();
        this.f2430h = parcel.createStringArrayList();
        parcel.readStringList(this.f2430h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2423a);
        parcel.writeStringList(this.f2424b);
        parcel.writeString(this.f2425c);
        parcel.writeString(this.f2426d);
        parcel.writeSerializable(this.f2427e);
        parcel.writeString(this.f2428f);
        parcel.writeSerializable(this.f2429g);
        parcel.writeStringList(this.f2430h);
    }
}
