package com.navatics.app.framework.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.FileObserver;
import android.preference.PreferenceManager;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.divelog.Photo;
import com.navatics.robot.utils.C2160n;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class PhotosProvider extends ContentProvider implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: f */
    private FileObserverC1844b f4771f;

    /* renamed from: g */
    private List<Photo> f4772g;

    /* renamed from: h */
    private final Object f4773h = new Object();

    /* renamed from: c */
    private static final C3044k f4768c = C3044k.m1564a(PhotosProvider.class);

    /* renamed from: a */
    public static final Uri f4766a = Uri.parse("content://com.navatics.app.media/photos");

    /* renamed from: b */
    public static final Uri f4767b = Uri.parse("content://com.navatics.app.media/photos/path");

    /* renamed from: d */
    private static final String[] f4769d = {"_id", C1843a.f4774a};

    /* renamed from: e */
    private static UriMatcher f4770e = m7911b();

    /* renamed from: com.navatics.app.framework.provider.PhotosProvider$a */
    /* loaded from: classes.dex */
    public static class C1843a implements BaseColumns {

        /* renamed from: a */
        public static String f4774a = "uri";
    }

    public static /* synthetic */ int lambda$J59ARAtcMZa25AGlQvLdkzEZr9w(File file, File file2) {
        return m7914a(file, file2);
    }

    public static /* synthetic */ boolean lambda$UIOFW6Qw9uTn6x1auKc3i7aud3I(File file) {
        return m7915a(file);
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

    /* renamed from: b */
    private static UriMatcher m7911b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.navatics.app.media", "/photos", 1);
        uriMatcher.addURI("com.navatics.app.media", "/photos/#", 2);
        uriMatcher.addURI("com.navatics.app.media", "/photos/path", 3);
        return uriMatcher;
    }

    /* renamed from: c */
    public void m7909c() {
        File file = new File(Settings.m8618a().m8609d());
        if (!file.exists()) {
            file.mkdirs();
            return;
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.navatics.app.framework.provider.-$$Lambda$PhotosProvider$UIOFW6Qw9uTn6x1auKc3i7aud3I
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return PhotosProvider.lambda$UIOFW6Qw9uTn6x1auKc3i7aud3I(file2);
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            ArrayList arrayList = new ArrayList();
            Arrays.sort(listFiles, new Comparator() { // from class: com.navatics.app.framework.provider.-$$Lambda$PhotosProvider$J59ARAtcMZa25AGlQvLdkzEZr9w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return PhotosProvider.lambda$J59ARAtcMZa25AGlQvLdkzEZr9w((File) obj, (File) obj2);
                }
            });
            for (File file2 : listFiles) {
                arrayList.add(new Photo(file2.getPath()));
            }
            m7913a(arrayList);
            return;
        }
        m7913a(new ArrayList());
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m7915a(File file) {
        String m5854a = C2160n.m5854a(file.getName());
        if (TextUtils.isEmpty(m5854a)) {
            return false;
        }
        return m5854a.equalsIgnoreCase("png") || m5854a.equalsIgnoreCase("jpg");
    }

    /* renamed from: a */
    public static /* synthetic */ int m7914a(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    /* renamed from: a */
    private void m7913a(List<Photo> list) {
        synchronized (this.f4773h) {
            this.f4772g = list;
        }
    }

    /* renamed from: a */
    private static String[] m7912a(String[] strArr) {
        if (strArr == null) {
            return f4769d;
        }
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        hashSet.add("_id");
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Settings.m8617a(getContext());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (!defaultSharedPreferences.getBoolean("key_first_start", false)) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        m7909c();
        this.f4771f = new FileObserverC1844b();
        this.f4771f.startWatching();
        return true;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("key_first_start".equals(str)) {
            if (sharedPreferences.getBoolean("key_first_start", false)) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
            }
            m7909c();
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        List<Photo> list;
        MatrixCursor matrixCursor = null;
        int i = 0;
        switch (f4770e.match(uri)) {
            case 1:
                matrixCursor = new MatrixCursor(m7912a(strArr));
                List<Photo> list2 = this.f4772g;
                if (list2 != null && list2.size() != 0) {
                    synchronized (this.f4773h) {
                        while (i < this.f4772g.size()) {
                            m7917a(matrixCursor, this.f4772g.get(i), i);
                            i++;
                        }
                    }
                    break;
                }
                break;
            case 2:
                int parseId = (int) ContentUris.parseId(uri);
                String[] m7912a = m7912a(strArr);
                ArrayList arrayList = new ArrayList();
                matrixCursor = new MatrixCursor(m7912a);
                List<Photo> list3 = this.f4772g;
                if (list3 != null && list3.size() != 0) {
                    synchronized (this.f4773h) {
                        Photo photo = this.f4772g.get(parseId);
                        int length = m7912a.length;
                        while (i < length) {
                            String str3 = m7912a[i];
                            if (str3.equals("_id")) {
                                arrayList.add(Integer.valueOf(parseId));
                            } else if (str3.equals(C1843a.f4774a)) {
                                arrayList.add(photo.m8433a());
                            }
                            i++;
                        }
                    }
                    matrixCursor.addRow(arrayList.toArray(new Object[arrayList.size()]));
                    break;
                }
                break;
            case 3:
                MatrixCursor matrixCursor2 = new MatrixCursor(m7912a(strArr));
                String str4 = strArr2 != null ? strArr2[0] : null;
                if (!C2160n.m5855a((CharSequence) str4) && (list = this.f4772g) != null && list.size() != 0) {
                    synchronized (this.f4773h) {
                        while (true) {
                            if (i < this.f4772g.size()) {
                                if (this.f4772g.get(i).m8433a().equals(str4)) {
                                    m7917a(matrixCursor2, this.f4772g.get(i), i);
                                } else {
                                    i++;
                                }
                            }
                        }
                    }
                }
                matrixCursor = matrixCursor2;
                break;
        }
        if (matrixCursor != null && getContext() != null) {
            matrixCursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return matrixCursor;
    }

    /* renamed from: a */
    private void m7917a(MatrixCursor matrixCursor, Photo photo, int i) {
        MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
        newRow.add("_id", Integer.valueOf(i));
        newRow.add(C1843a.f4774a, photo.m8433a());
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        switch (f4770e.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/com.navatics.app.media";
            case 2:
                return "vnd.android.cursor.item/com.navatics.app.media";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int i = 0;
        if (f4770e.match(uri) == 3) {
            String str2 = strArr == null ? null : strArr[0];
            if (!C2160n.m5855a((CharSequence) str2)) {
                synchronized (this.f4773h) {
                    Iterator<Photo> it = this.f4772g.iterator();
                    while (it.hasNext()) {
                        if (it.next().m8433a().equals(str2) && new File(str2).delete()) {
                            i++;
                            it.remove();
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: com.navatics.app.framework.provider.PhotosProvider$b */
    /* loaded from: classes.dex */
    class FileObserverC1844b extends FileObserver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        FileObserverC1844b() {
            super(Settings.m8618a().m8609d(), 960);
            PhotosProvider.this = r2;
        }

        /* renamed from: a */
        private boolean m7908a(String str) {
            String m5854a = C2160n.m5854a(str);
            return m5854a.endsWith("png") || m5854a.endsWith("jpg");
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, @Nullable String str) {
            if (C2160n.m5855a((CharSequence) str) || !m7908a(str)) {
                return;
            }
            PhotosProvider.f4768c.mo1511a((Object) "FileObserver onEvent");
            if ((i & 256) == 256) {
                PhotosProvider.f4768c.mo1511a((Object) "MyFileObserver event CREATE");
            } else if ((i & 512) == 512) {
                PhotosProvider.f4768c.mo1511a((Object) "MyFileObserver event DELETE");
            } else if ((i & 64) == 64) {
                PhotosProvider.f4768c.mo1511a((Object) "MyFileObserver event MOVED_FROM");
            } else if ((i & 128) == 128) {
                PhotosProvider.f4768c.mo1511a((Object) "MyFileObserver event MOVED_TO");
            } else {
                PhotosProvider.f4768c.mo1499d(String.format("unknown event : 0x%08x", Integer.valueOf(i)));
            }
            synchronized (PhotosProvider.this.f4773h) {
                PhotosProvider.this.m7909c();
            }
            if (PhotosProvider.this.getContext() != null) {
                PhotosProvider.this.getContext().getContentResolver().notifyChange(PhotosProvider.f4766a, null);
            }
        }
    }
}
