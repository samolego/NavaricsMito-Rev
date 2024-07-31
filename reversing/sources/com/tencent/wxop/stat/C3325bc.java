package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.wxop.stat.common.C2575r;
import com.tencent.wxop.stat.common.StatLogger;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.bc */
/* loaded from: classes2.dex */
public class C2555bc extends SQLiteOpenHelper {

    /* renamed from: a */
    private String f8004a;

    /* renamed from: b */
    private Context f8005b;

    public C2555bc(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
        StatLogger statLogger;
        this.f8004a = "";
        this.f8005b = null;
        this.f8004a = str;
        this.f8005b = context.getApplicationContext();
        if (StatConfig.isDebugEnable()) {
            statLogger = C2546au.f7967h;
            statLogger.m4877i("SQLiteOpenHelper " + this.f8004a);
        }
    }

    /* renamed from: a */
    private void m4883a(SQLiteDatabase sQLiteDatabase) {
        StatLogger statLogger;
        Cursor cursor = null;
        String str = null;
        try {
            Cursor query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", C2575r.m4785b(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                th = th;
                cursor = query;
                try {
                    statLogger = C2546au.f7967h;
                    statLogger.m4878e(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    Cursor cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: b */
    private void m4882b(SQLiteDatabase sQLiteDatabase) {
        StatLogger statLogger;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("events", null, null, null, null, null, null);
            ArrayList<C2556bd> arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(new C2556bd(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (C2556bd c2556bd : arrayList) {
                contentValues.put("content", C2575r.m4785b(c2556bd.f8007b));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(c2556bd.f8006a)});
            }
        } catch (Throwable th) {
            try {
                statLogger = C2546au.f7967h;
                statLogger.m4878e(th);
                if (cursor != null) {
                    cursor.close();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StatLogger statLogger;
        statLogger = C2546au.f7967h;
        statLogger.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m4883a(sQLiteDatabase);
            m4882b(sQLiteDatabase);
        }
        if (i == 2) {
            m4883a(sQLiteDatabase);
            m4882b(sQLiteDatabase);
        }
    }
}
