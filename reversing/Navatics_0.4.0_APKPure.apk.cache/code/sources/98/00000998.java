package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.util.SparseIntArray;

/* compiled from: VersionedParcelParcel.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.versionedparcelable.b, reason: use source file name */
/* loaded from: classes.dex */
class VersionedParcelParcel extends VersionedParcel {

    /* renamed from: a */
    private final SparseIntArray f125a;

    /* renamed from: b */
    private final Parcel f126b;

    /* renamed from: c */
    private final int f127c;

    /* renamed from: d */
    private final int f128d;

    /* renamed from: e */
    private final String f129e;

    /* renamed from: f */
    private int f130f;

    /* renamed from: g */
    private int f131g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    VersionedParcelParcel(Parcel parcel, int i, int i2, String str) {
        this.f125a = new SparseIntArray();
        this.f130f = -1;
        this.f131g = 0;
        this.f126b = parcel;
        this.f127c = i;
        this.f128d = i2;
        this.f131g = this.f127c;
        this.f129e = str;
    }

    /* renamed from: d */
    private int m150d(int i) {
        int readInt;
        do {
            int i2 = this.f131g;
            if (i2 >= this.f128d) {
                return -1;
            }
            this.f126b.setDataPosition(i2);
            int readInt2 = this.f126b.readInt();
            readInt = this.f126b.readInt();
            this.f131g += readInt2;
        } while (readInt != i);
        return this.f126b.dataPosition();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: b */
    public boolean mo141b(int i) {
        int m150d = m150d(i);
        if (m150d == -1) {
            return false;
        }
        this.f126b.setDataPosition(m150d);
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: c */
    public void mo144c(int i) {
        mo140b();
        this.f130f = i;
        this.f125a.put(i, this.f126b.dataPosition());
        mo126a(0);
        mo126a(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: b */
    public void mo140b() {
        int i = this.f130f;
        if (i >= 0) {
            int i2 = this.f125a.get(i);
            int dataPosition = this.f126b.dataPosition();
            this.f126b.setDataPosition(i2);
            this.f126b.writeInt(dataPosition - i2);
            this.f126b.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: c */
    protected VersionedParcel mo143c() {
        Parcel parcel = this.f126b;
        int dataPosition = parcel.dataPosition();
        int i = this.f131g;
        if (i == this.f127c) {
            i = this.f128d;
        }
        return new VersionedParcelParcel(parcel, dataPosition, i, this.f129e + "  ");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo134a(byte[] bArr) {
        if (bArr != null) {
            this.f126b.writeInt(bArr.length);
            this.f126b.writeByteArray(bArr);
        } else {
            this.f126b.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo126a(int i) {
        this.f126b.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo131a(String str) {
        this.f126b.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo128a(Parcelable parcelable) {
        this.f126b.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: d */
    public int mo145d() {
        return this.f126b.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: e */
    public String mo146e() {
        return this.f126b.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: f */
    public byte[] mo147f() {
        int readInt = this.f126b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f126b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: g */
    public <T extends Parcelable> T mo148g() {
        return (T) this.f126b.readParcelable(getClass().getClassLoader());
    }
}