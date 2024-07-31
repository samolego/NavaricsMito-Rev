package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.theartofdev.edmodo.cropper.CropImageView;

/* loaded from: classes2.dex */
public class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new Parcelable.Creator<CropImageOptions>() { // from class: com.theartofdev.edmodo.cropper.CropImageOptions.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CropImageOptions createFromParcel(Parcel parcel) {
            return new CropImageOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CropImageOptions[] newArray(int i) {
            return new CropImageOptions[i];
        }
    };

    /* renamed from: A */
    public int f8193A;

    /* renamed from: B */
    public int f8194B;

    /* renamed from: C */
    public int f8195C;

    /* renamed from: D */
    public CharSequence f8196D;

    /* renamed from: E */
    public int f8197E;

    /* renamed from: F */
    public Uri f8198F;

    /* renamed from: G */
    public Bitmap.CompressFormat f8199G;

    /* renamed from: H */
    public int f8200H;

    /* renamed from: I */
    public int f8201I;

    /* renamed from: J */
    public int f8202J;

    /* renamed from: K */
    public CropImageView.RequestSizeOptions f8203K;

    /* renamed from: L */
    public boolean f8204L;

    /* renamed from: M */
    public Rect f8205M;

    /* renamed from: N */
    public int f8206N;

    /* renamed from: O */
    public boolean f8207O;

    /* renamed from: P */
    public boolean f8208P;

    /* renamed from: Q */
    public boolean f8209Q;

    /* renamed from: R */
    public int f8210R;

    /* renamed from: S */
    public boolean f8211S;

    /* renamed from: T */
    public boolean f8212T;

    /* renamed from: U */
    public CharSequence f8213U;

    /* renamed from: V */
    public int f8214V;

    /* renamed from: a */
    public CropImageView.CropShape f8215a;

    /* renamed from: b */
    public float f8216b;

    /* renamed from: c */
    public float f8217c;

    /* renamed from: d */
    public CropImageView.Guidelines f8218d;

    /* renamed from: e */
    public CropImageView.ScaleType f8219e;

    /* renamed from: f */
    public boolean f8220f;

    /* renamed from: g */
    public boolean f8221g;

    /* renamed from: h */
    public boolean f8222h;

    /* renamed from: i */
    public boolean f8223i;

    /* renamed from: j */
    public int f8224j;

    /* renamed from: k */
    public float f8225k;

    /* renamed from: l */
    public boolean f8226l;

    /* renamed from: m */
    public int f8227m;

    /* renamed from: n */
    public int f8228n;

    /* renamed from: o */
    public float f8229o;

    /* renamed from: p */
    public int f8230p;

    /* renamed from: q */
    public float f8231q;

    /* renamed from: r */
    public float f8232r;

    /* renamed from: s */
    public float f8233s;

    /* renamed from: t */
    public int f8234t;

    /* renamed from: u */
    public float f8235u;

    /* renamed from: v */
    public int f8236v;

    /* renamed from: w */
    public int f8237w;

    /* renamed from: x */
    public int f8238x;

    /* renamed from: y */
    public int f8239y;

    /* renamed from: z */
    public int f8240z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CropImageOptions() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f8215a = CropImageView.CropShape.RECTANGLE;
        this.f8216b = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f8217c = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f8218d = CropImageView.Guidelines.ON_TOUCH;
        this.f8219e = CropImageView.ScaleType.FIT_CENTER;
        this.f8220f = true;
        this.f8221g = true;
        this.f8222h = true;
        this.f8223i = false;
        this.f8224j = 4;
        this.f8225k = 0.1f;
        this.f8226l = false;
        this.f8227m = 1;
        this.f8228n = 1;
        this.f8229o = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f8230p = Color.argb(170, 255, 255, 255);
        this.f8231q = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.f8232r = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.f8233s = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.f8234t = -1;
        this.f8235u = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f8236v = Color.argb(170, 255, 255, 255);
        this.f8237w = Color.argb(119, 0, 0, 0);
        this.f8238x = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f8239y = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f8240z = 40;
        this.f8193A = 40;
        this.f8194B = 99999;
        this.f8195C = 99999;
        this.f8196D = "";
        this.f8197E = 0;
        this.f8198F = Uri.EMPTY;
        this.f8199G = Bitmap.CompressFormat.JPEG;
        this.f8200H = 90;
        this.f8201I = 0;
        this.f8202J = 0;
        this.f8203K = CropImageView.RequestSizeOptions.NONE;
        this.f8204L = false;
        this.f8205M = null;
        this.f8206N = -1;
        this.f8207O = true;
        this.f8208P = true;
        this.f8209Q = false;
        this.f8210R = 90;
        this.f8211S = false;
        this.f8212T = false;
        this.f8213U = null;
        this.f8214V = 0;
    }

    protected CropImageOptions(Parcel parcel) {
        this.f8215a = CropImageView.CropShape.values()[parcel.readInt()];
        this.f8216b = parcel.readFloat();
        this.f8217c = parcel.readFloat();
        this.f8218d = CropImageView.Guidelines.values()[parcel.readInt()];
        this.f8219e = CropImageView.ScaleType.values()[parcel.readInt()];
        this.f8220f = parcel.readByte() != 0;
        this.f8221g = parcel.readByte() != 0;
        this.f8222h = parcel.readByte() != 0;
        this.f8223i = parcel.readByte() != 0;
        this.f8224j = parcel.readInt();
        this.f8225k = parcel.readFloat();
        this.f8226l = parcel.readByte() != 0;
        this.f8227m = parcel.readInt();
        this.f8228n = parcel.readInt();
        this.f8229o = parcel.readFloat();
        this.f8230p = parcel.readInt();
        this.f8231q = parcel.readFloat();
        this.f8232r = parcel.readFloat();
        this.f8233s = parcel.readFloat();
        this.f8234t = parcel.readInt();
        this.f8235u = parcel.readFloat();
        this.f8236v = parcel.readInt();
        this.f8237w = parcel.readInt();
        this.f8238x = parcel.readInt();
        this.f8239y = parcel.readInt();
        this.f8240z = parcel.readInt();
        this.f8193A = parcel.readInt();
        this.f8194B = parcel.readInt();
        this.f8195C = parcel.readInt();
        this.f8196D = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f8197E = parcel.readInt();
        this.f8198F = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f8199G = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.f8200H = parcel.readInt();
        this.f8201I = parcel.readInt();
        this.f8202J = parcel.readInt();
        this.f8203K = CropImageView.RequestSizeOptions.values()[parcel.readInt()];
        this.f8204L = parcel.readByte() != 0;
        this.f8205M = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.f8206N = parcel.readInt();
        this.f8207O = parcel.readByte() != 0;
        this.f8208P = parcel.readByte() != 0;
        this.f8209Q = parcel.readByte() != 0;
        this.f8210R = parcel.readInt();
        this.f8211S = parcel.readByte() != 0;
        this.f8212T = parcel.readByte() != 0;
        this.f8213U = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f8214V = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8215a.ordinal());
        parcel.writeFloat(this.f8216b);
        parcel.writeFloat(this.f8217c);
        parcel.writeInt(this.f8218d.ordinal());
        parcel.writeInt(this.f8219e.ordinal());
        parcel.writeByte(this.f8220f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8221g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8222h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8223i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f8224j);
        parcel.writeFloat(this.f8225k);
        parcel.writeByte(this.f8226l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f8227m);
        parcel.writeInt(this.f8228n);
        parcel.writeFloat(this.f8229o);
        parcel.writeInt(this.f8230p);
        parcel.writeFloat(this.f8231q);
        parcel.writeFloat(this.f8232r);
        parcel.writeFloat(this.f8233s);
        parcel.writeInt(this.f8234t);
        parcel.writeFloat(this.f8235u);
        parcel.writeInt(this.f8236v);
        parcel.writeInt(this.f8237w);
        parcel.writeInt(this.f8238x);
        parcel.writeInt(this.f8239y);
        parcel.writeInt(this.f8240z);
        parcel.writeInt(this.f8193A);
        parcel.writeInt(this.f8194B);
        parcel.writeInt(this.f8195C);
        TextUtils.writeToParcel(this.f8196D, parcel, i);
        parcel.writeInt(this.f8197E);
        parcel.writeParcelable(this.f8198F, i);
        parcel.writeString(this.f8199G.name());
        parcel.writeInt(this.f8200H);
        parcel.writeInt(this.f8201I);
        parcel.writeInt(this.f8202J);
        parcel.writeInt(this.f8203K.ordinal());
        parcel.writeInt(this.f8204L ? 1 : 0);
        parcel.writeParcelable(this.f8205M, i);
        parcel.writeInt(this.f8206N);
        parcel.writeByte(this.f8207O ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8208P ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8209Q ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f8210R);
        parcel.writeByte(this.f8211S ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8212T ? (byte) 1 : (byte) 0);
        TextUtils.writeToParcel(this.f8213U, parcel, i);
        parcel.writeInt(this.f8214V);
    }

    /* renamed from: a */
    public void m4719a() {
        if (this.f8224j < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        }
        if (this.f8217c < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
        float f = this.f8225k;
        if (f < 0.0f || f >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
        }
        if (this.f8227m <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f8228n <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f8229o < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
        }
        if (this.f8231q < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
        }
        if (this.f8235u < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
        }
        if (this.f8239y < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
        }
        int i = this.f8240z;
        if (i < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
        }
        int i2 = this.f8193A;
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
        }
        if (this.f8194B < i) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
        }
        if (this.f8195C < i2) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
        }
        if (this.f8201I < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
        }
        if (this.f8202J < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
        }
        int i3 = this.f8210R;
        if (i3 < 0 || i3 > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
        }
    }
}
