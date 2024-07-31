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

/* compiled from: PathCursor.java */
/* renamed from: com.navatics.app.player.content.a, reason: use source file name */
/* loaded from: classes.dex */
public class PathCursor extends AbstractCursor {

    /* renamed from: a */
    public static final String[] f4908a = {"_id", "file_name", "file_path", "is_directory", "is_video"};

    /* renamed from: b */
    public static Comparator<a> f4909b = new Comparator<a>() { // from class: com.navatics.app.player.content.a.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            if (aVar.f4913b && !aVar2.f4913b) {
                return -1;
            }
            if (aVar.f4913b || !aVar2.f4913b) {
                return aVar.f4912a.getName().compareToIgnoreCase(aVar2.f4912a.getName());
            }
            return 1;
        }
    };

    /* renamed from: d */
    private static Set<String> f4910d = new TreeSet(String.CASE_INSENSITIVE_ORDER);

    /* renamed from: c */
    private List<a> f4911c = new ArrayList();

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return Utils.DOUBLE_EPSILON;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return 0.0f;
    }

    static {
        f4910d.add("flv");
        f4910d.add("mp4");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathCursor(File file, File[] fileArr) {
        if (file.getParent() != null) {
            a aVar = new a(new File(file, ".."));
            aVar.f4913b = true;
            this.f4911c.add(aVar);
        }
        if (fileArr != null) {
            for (File file2 : fileArr) {
                this.f4911c.add(new a(file2));
            }
            Collections.sort(this.f4911c, f4909b);
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.f4911c.size();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return f4908a;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        switch (i) {
            case 1:
                return this.f4911c.get(getPosition()).f4912a.getName();
            case 2:
                return this.f4911c.get(getPosition()).f4912a.toString();
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
        if (i == 0) {
            return getPosition();
        }
        switch (i) {
            case 3:
                return this.f4911c.get(getPosition()).f4913b ? 1L : 0L;
            case 4:
                return this.f4911c.get(getPosition()).f4914c ? 1L : 0L;
            default:
                return 0L;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return this.f4911c == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PathCursor.java */
    /* renamed from: com.navatics.app.player.content.a$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        public File f4912a;

        /* renamed from: b */
        public boolean f4913b;

        /* renamed from: c */
        public boolean f4914c;

        public a(File file) {
            int lastIndexOf;
            this.f4912a = file;
            this.f4913b = file.isDirectory();
            String name = file.getName();
            if (TextUtils.isEmpty(name) || (lastIndexOf = name.lastIndexOf(46)) < 0) {
                return;
            }
            String substring = name.substring(lastIndexOf + 1);
            if (TextUtils.isEmpty(substring) || !PathCursor.f4910d.contains(substring)) {
                return;
            }
            this.f4914c = true;
        }
    }
}