package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zze();

    /* renamed from: zV */
    private static final zza f2713zV = new zza(new String[0], null) { // from class: com.google.android.gms.common.data.DataHolder.1
        @Override // com.google.android.gms.common.data.DataHolder.zza
        public zza zza(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        @Override // com.google.android.gms.common.data.DataHolder.zza
        public zza zzb(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    boolean mClosed;
    private final int mVersionCode;

    /* renamed from: rR */
    private final int f2714rR;

    /* renamed from: zO */
    private final String[] f2715zO;

    /* renamed from: zP */
    Bundle f2716zP;

    /* renamed from: zQ */
    private final CursorWindow[] f2717zQ;

    /* renamed from: zR */
    private final Bundle f2718zR;

    /* renamed from: zS */
    int[] f2719zS;

    /* renamed from: zT */
    int f2720zT;

    /* renamed from: zU */
    private boolean f2721zU;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: Aa */
        private String f2722Aa;

        /* renamed from: zO */
        private final String[] f2723zO;

        /* renamed from: zW */
        private final ArrayList<HashMap<String, Object>> f2724zW;

        /* renamed from: zX */
        private final String f2725zX;

        /* renamed from: zY */
        private final HashMap<Object, Integer> f2726zY;

        /* renamed from: zZ */
        private boolean f2727zZ;

        private zza(String[] strArr, String str) {
            this.f2723zO = (String[]) zzac.zzy(strArr);
            this.f2724zW = new ArrayList<>();
            this.f2725zX = str;
            this.f2726zY = new HashMap<>();
            this.f2727zZ = false;
            this.f2722Aa = null;
        }

        private int zzc(HashMap<String, Object> hashMap) {
            Object obj;
            String str = this.f2725zX;
            if (str == null || (obj = hashMap.get(str)) == null) {
                return -1;
            }
            Integer num = this.f2726zY.get(obj);
            if (num == null) {
                this.f2726zY.put(obj, Integer.valueOf(this.f2724zW.size()));
                return -1;
            }
            return num.intValue();
        }

        public zza zza(ContentValues contentValues) {
            com.google.android.gms.common.internal.zzc.zzu(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zzb(hashMap);
        }

        public zza zzb(HashMap<String, Object> hashMap) {
            com.google.android.gms.common.internal.zzc.zzu(hashMap);
            int zzc = zzc(hashMap);
            if (zzc == -1) {
                this.f2724zW.add(hashMap);
            } else {
                this.f2724zW.remove(zzc);
                this.f2724zW.add(zzc, hashMap);
            }
            this.f2727zZ = false;
            return this;
        }

        public DataHolder zzgd(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.f2721zU = true;
        this.mVersionCode = i;
        this.f2715zO = strArr;
        this.f2717zQ = cursorWindowArr;
        this.f2714rR = i2;
        this.f2718zR = bundle;
    }

    private DataHolder(zza zzaVar, int i, Bundle bundle) {
        this(zzaVar.f2723zO, zza(zzaVar, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.f2721zU = true;
        this.mVersionCode = 1;
        this.f2715zO = (String[]) zzac.zzy(strArr);
        this.f2717zQ = (CursorWindow[]) zzac.zzy(cursorWindowArr);
        this.f2714rR = i;
        this.f2718zR = bundle;
        zzate();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(f2713zV, i, bundle);
    }

    private static CursorWindow[] zza(zza zzaVar, int i) {
        long j;
        if (zzaVar.f2723zO.length == 0) {
            return new CursorWindow[0];
        }
        List subList = (i < 0 || i >= zzaVar.f2724zW.size()) ? zzaVar.f2724zW : zzaVar.f2724zW.subList(0, i);
        int size = subList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(zzaVar.f2723zO.length);
        CursorWindow cursorWindow2 = cursorWindow;
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i2);
                    sb.append(")");
                    Log.d("DataHolder", sb.toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(zzaVar.f2723zO.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) subList.get(i2);
                boolean z2 = true;
                for (int i3 = 0; i3 < zzaVar.f2723zO.length && z2; i3++) {
                    String str = zzaVar.f2723zO[i3];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z2 = cursorWindow2.putNull(i2, i3);
                    } else if (obj instanceof String) {
                        z2 = cursorWindow2.putString((String) obj, i2, i3);
                    } else {
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow2.putLong(((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            j = ((Boolean) obj).booleanValue() ? 1L : 0L;
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow2.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else if (!(obj instanceof Float)) {
                            String valueOf = String.valueOf(obj);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length());
                            sb2.append("Unsupported object for column ");
                            sb2.append(str);
                            sb2.append(": ");
                            sb2.append(valueOf);
                            throw new IllegalArgumentException(sb2.toString());
                        } else {
                            z2 = cursorWindow2.putDouble(((Float) obj).floatValue(), i2, i3);
                        }
                        z2 = cursorWindow2.putLong(j, i2, i3);
                    }
                }
                if (z2) {
                    z = false;
                } else if (z) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i2);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(zzaVar.f2723zO.length);
                    arrayList.add(cursorWindow2);
                    i2--;
                    z = true;
                }
                i2++;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ((CursorWindow) arrayList.get(i4)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static zza zzc(String[] strArr) {
        return new zza(strArr, null);
    }

    public static DataHolder zzgc(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzi(String str, int i) {
        Bundle bundle = this.f2716zP;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else {
            if (i < 0 || i >= this.f2720zT) {
                throw new CursorIndexOutOfBoundsException(i, this.f2720zT);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.f2717zQ.length; i++) {
                    this.f2717zQ[i].close();
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f2721zU && this.f2717zQ.length > 0 && !isClosed()) {
                close();
                String valueOf = String.valueOf(toString());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(valueOf);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.f2720zT;
    }

    public int getStatusCode() {
        return this.f2714rR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzi(str, i);
        this.f2717zQ[i2].copyStringToBuffer(i, this.f2716zP.getInt(str), charArrayBuffer);
    }

    public Bundle zzasz() {
        return this.f2718zR;
    }

    public void zzate() {
        this.f2716zP = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.f2715zO;
            if (i2 >= strArr.length) {
                break;
            }
            this.f2716zP.putInt(strArr[i2], i2);
            i2++;
        }
        this.f2719zS = new int[this.f2717zQ.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f2717zQ;
            if (i >= cursorWindowArr.length) {
                this.f2720zT = i3;
                return;
            }
            this.f2719zS[i] = i3;
            i3 += this.f2717zQ[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] zzatf() {
        return this.f2715zO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CursorWindow[] zzatg() {
        return this.f2717zQ;
    }

    public long zzb(String str, int i, int i2) {
        zzi(str, i);
        return this.f2717zQ[i2].getLong(i, this.f2716zP.getInt(str));
    }

    public int zzc(String str, int i, int i2) {
        zzi(str, i);
        return this.f2717zQ[i2].getInt(i, this.f2716zP.getInt(str));
    }

    public String zzd(String str, int i, int i2) {
        zzi(str, i);
        return this.f2717zQ[i2].getString(i, this.f2716zP.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzi(str, i);
        return Long.valueOf(this.f2717zQ[i2].getLong(i, this.f2716zP.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzi(str, i);
        return this.f2717zQ[i2].getFloat(i, this.f2716zP.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzi(str, i);
        return this.f2717zQ[i2].getBlob(i, this.f2716zP.getInt(str));
    }

    public int zzgb(int i) {
        int i2 = 0;
        zzac.zzbr(i >= 0 && i < this.f2720zT);
        while (true) {
            int[] iArr = this.f2719zS;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f2719zS.length ? i2 - 1 : i2;
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzhm(String str) {
        return this.f2716zP.containsKey(str);
    }

    public boolean zzi(String str, int i, int i2) {
        zzi(str, i);
        return this.f2717zQ[i2].isNull(i, this.f2716zP.getInt(str));
    }
}
