package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() { // from class: com.facebook.share.model.GameRequestContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    };

    /* renamed from: a */
    private final String f2431a;

    /* renamed from: b */
    private final List<String> f2432b;

    /* renamed from: c */
    private final String f2433c;

    /* renamed from: d */
    private final String f2434d;

    /* renamed from: e */
    private final ActionType f2435e;

    /* renamed from: f */
    private final String f2436f;

    /* renamed from: g */
    private final Filters f2437g;

    /* renamed from: h */
    private final List<String> f2438h;

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
        this.f2431a = parcel.readString();
        this.f2432b = parcel.createStringArrayList();
        this.f2433c = parcel.readString();
        this.f2434d = parcel.readString();
        this.f2435e = (ActionType) parcel.readSerializable();
        this.f2436f = parcel.readString();
        this.f2437g = (Filters) parcel.readSerializable();
        this.f2438h = parcel.createStringArrayList();
        parcel.readStringList(this.f2438h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2431a);
        parcel.writeStringList(this.f2432b);
        parcel.writeString(this.f2433c);
        parcel.writeString(this.f2434d);
        parcel.writeSerializable(this.f2435e);
        parcel.writeString(this.f2436f);
        parcel.writeSerializable(this.f2437g);
        parcel.writeStringList(this.f2438h);
    }
}