package com.navatics.app.player.content;

import android.database.AbstractCursor;
import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.navatics.app.player.content.a */
/* loaded from: classes.dex */
public class PathCursor extends AbstractCursor {

    /* renamed from: a */
    public static final String[] f4886a = {"_id", "file_name", "file_path", "is_directory", "is_video"};

    /* renamed from: b */
    public static Comparator<C1864a> f4887b = new Comparator<C1864a>() { // from class: com.navatics.app.player.content.a.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C1864a c1864a, C1864a c1864a2) {
            if (!c1864a.f4891b || c1864a2.f4891b) {
                if (c1864a.f4891b || !c1864a2.f4891b) {
                    return c1864a.f4890a.getName().compareToIgnoreCase(c1864a2.f4890a.getName());
                }
                return 1;
            }
            return -1;
        }
    };

    /* renamed from: d */
    private static Set<String> f4888d = new TreeSet(String.CASE_INSENSITIVE_ORDER);

    /* renamed from: c */
    private List<C1864a> f4889c = new ArrayList();

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return Utils.DOUBLE_EPSILON;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return 0.0f;
    }

    static {
        f4888d.add("flv");
        f4888d.add("mp4");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathCursor(File file, File[] fileArr) {
        if (file.getParent() != null) {
            C1864a c1864a = new C1864a(new File(file, ".."));
            c1864a.f4891b = true;
            this.f4889c.add(c1864a);
        }
        if (fileArr != null) {
            for (File file2 : fileArr) {
                this.f4889c.add(new C1864a(file2));
            }
            Collections.sort(this.f4889c, f4887b);
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.f4889c.size();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return f4886a;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        switch (i) {
            case 1:
                return this.f4889c.get(getPosition()).f4890a.getName();
            case 2:
                return this.f4889c.get(getPosition()).f4890a.toString();
            default:
                return null;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        return (short) getLong(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        return (int) getLong(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        if (i != 0) {
            switch (i) {
                case 3:
                    return this.f4889c.get(getPosition()).f4891b ? 1L : 0L;
                case 4:
                    return this.f4889c.get(getPosition()).f4892c ? 1L : 0L;
                default:
                    return 0L;
            }
        }
        return getPosition();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return this.f4889c == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PathCursor.java */
    /* renamed from: com.navatics.app.player.content.a$a */
    /* loaded from: classes.dex */
    public class C1864a {

        /* renamed from: a */
        public File f4890a;

        /* renamed from: b */
        public boolean f4891b;

        /* renamed from: c */
        public boolean f4892c;

        public C1864a(File file) {
            int lastIndexOf;
            this.f4890a = file;
            this.f4891b = file.isDirectory();
            String name = file.getName();
            if (TextUtils.isEmpty(name) || (lastIndexOf = name.lastIndexOf(46)) < 0) {
                return;
            }
            String substring = name.substring(lastIndexOf + 1);
            if (TextUtils.isEmpty(substring) || !PathCursor.f4888d.contains(substring)) {
                return;
            }
            this.f4892c = true;
        }
    }
}
