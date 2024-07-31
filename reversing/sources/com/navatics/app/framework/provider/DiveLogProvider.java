package com.navatics.app.framework.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.divelog.DiveLog;
import io.objectbox.android.AndroidScheduler;
import io.objectbox.p092b.DataObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class DiveLogProvider extends ContentProvider {

    /* renamed from: e */
    private List<DiveLog> f4758e;

    /* renamed from: f */
    private final Object f4759f = new Object();

    /* renamed from: b */
    private static final C3044k f4755b = C3044k.m1564a(DiveLogProvider.class);

    /* renamed from: a */
    public static final Uri f4754a = Uri.parse("content://com.navatics.app.divelog/divelog");

    /* renamed from: c */
    private static final String[] f4756c = {"_id", C1842a.f4760a, C1842a.f4761b, C1842a.f4762c, C1842a.f4763d, C1842a.f4764e, C1842a.f4765f};

    /* renamed from: d */
    private static UriMatcher f4757d = m7923a();

    /* renamed from: com.navatics.app.framework.provider.DiveLogProvider$a */
    /* loaded from: classes.dex */
    public static class C1842a implements BaseColumns {

        /* renamed from: a */
        public static String f4760a = "date";

        /* renamed from: b */
        public static String f4761b = "start_time";

        /* renamed from: c */
        public static String f4762c = "end_time";

        /* renamed from: d */
        public static String f4763d = "max_depth";

        /* renamed from: e */
        public static String f4764e = "average_depth";

        /* renamed from: f */
        public static String f4765f = "air_visibility";
    }

    /* renamed from: lambda$XUAkAvz--pzsR_ELA38sy8S2aEY */
    public static /* synthetic */ void m13072lambda$XUAkAvzpzsR_ELA38sy8S2aEY(DiveLogProvider diveLogProvider, List list) {
        diveLogProvider.m7920a(list);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    /* renamed from: a */
    private static UriMatcher m7923a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.navatics.app.divelog", "/divelog", 1);
        uriMatcher.addURI("com.navatics.app.divelog", "/divelog/#", 2);
        return uriMatcher;
    }

    /* renamed from: a */
    public void m7920a(List<DiveLog> list) {
        C3044k c3044k = f4755b;
        c3044k.mo1500c((Object) ("!!! assignNewDiveLog !!!, Count = " + list.size()));
        synchronized (this.f4759f) {
            this.f4758e = list;
        }
        if (getContext() != null) {
            getContext().getContentResolver().notifyChange(f4754a, null);
        }
    }

    /* renamed from: a */
    private static String[] m7919a(String[] strArr) {
        if (strArr == null) {
            return f4756c;
        }
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        hashSet.add("_id");
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Settings.m8617a(getContext());
        Navatics.m7933f().m3474d(DiveLog.class).m3416e().m3288b().m3299f().m3362a(AndroidScheduler.m3382a()).m3363a(new DataObserver() { // from class: com.navatics.app.framework.provider.-$$Lambda$DiveLogProvider$XUAkAvz--pzsR_ELA38sy8S2aEY
            @Override // io.objectbox.p092b.DataObserver
            public final void onData(Object obj) {
                DiveLogProvider.m13072lambda$XUAkAvzpzsR_ELA38sy8S2aEY(DiveLogProvider.this, (List) obj);
            }
        });
        return true;
    }

    /* renamed from: a */
    private DiveLog m7922a(int i) {
        DiveLog diveLog;
        synchronized (this.f4759f) {
            diveLog = null;
            for (DiveLog diveLog2 : this.f4758e) {
                if (diveLog2.getId() == i) {
                    diveLog = diveLog2;
                }
            }
        }
        return diveLog;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        MatrixCursor matrixCursor;
        switch (f4757d.match(uri)) {
            case 1:
                matrixCursor = new MatrixCursor(m7919a(strArr));
                if (TextUtils.isEmpty(str)) {
                    synchronized (this.f4759f) {
                        for (DiveLog diveLog : this.f4758e) {
                            m7921a(matrixCursor, diveLog);
                        }
                    }
                    break;
                }
                break;
            case 2:
                int parseId = (int) ContentUris.parseId(uri);
                String[] m7919a = m7919a(strArr);
                ArrayList arrayList = new ArrayList();
                matrixCursor = new MatrixCursor(m7919a);
                synchronized (this.f4759f) {
                    DiveLog m7922a = m7922a(parseId);
                    if (m7922a != null) {
                        for (String str3 : m7919a) {
                            if (str3.equals("_id")) {
                                arrayList.add(Integer.valueOf(parseId));
                            } else if (str3.equals(C1842a.f4760a)) {
                                arrayList.add(m7922a.getDate());
                            } else if (str3.equals(C1842a.f4761b)) {
                                arrayList.add(Long.valueOf(m7922a.getStartTime()));
                            } else if (str3.equals(C1842a.f4762c)) {
                                arrayList.add(Long.valueOf(m7922a.getEndTime()));
                            } else if (str3.equals(C1842a.f4763d)) {
                                arrayList.add(Integer.valueOf(m7922a.getMaxDepth()));
                            } else if (str3.equals(C1842a.f4764e)) {
                                arrayList.add(Integer.valueOf(m7922a.getAverageDepth()));
                            }
                        }
                        matrixCursor.addRow(arrayList.toArray(new Object[arrayList.size()]));
                        break;
                    } else {
                        return matrixCursor;
                    }
                }
            default:
                matrixCursor = null;
                break;
        }
        if (matrixCursor != null && getContext() != null) {
            matrixCursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return matrixCursor;
    }

    /* renamed from: a */
    private void m7921a(MatrixCursor matrixCursor, DiveLog diveLog) {
        MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
        newRow.add("_id", Long.valueOf(diveLog.getId()));
        newRow.add(C1842a.f4760a, diveLog.getDate());
        newRow.add(C1842a.f4761b, Long.valueOf(diveLog.getStartTime()));
        newRow.add(C1842a.f4762c, Long.valueOf(diveLog.getEndTime()));
        newRow.add(C1842a.f4763d, Integer.valueOf(diveLog.getMaxDepth()));
        newRow.add(C1842a.f4764e, Integer.valueOf(diveLog.getAverageDepth()));
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        switch (f4757d.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/com.navatics.app.divelog";
            case 2:
                return "vnd.android.cursor.item/com.navatics.app.divelog";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        DiveLog m7922a;
        if (f4757d.match(uri) == 2 && (m7922a = m7922a((int) ContentUris.parseId(uri))) != null) {
            m7922a.delete();
            return 0;
        }
        return 0;
    }
}
