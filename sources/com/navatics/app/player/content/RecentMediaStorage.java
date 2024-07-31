package com.navatics.app.player.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.p008v4.content.AsyncTaskLoader;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class RecentMediaStorage {

    /* renamed from: a */
    public static final String[] f4883a = {"id as _id", "id", "url", "name", "last_access"};

    /* renamed from: b */
    private Context f4884b;

    public RecentMediaStorage(Context context) {
        this.f4884b = context.getApplicationContext();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.navatics.app.player.content.RecentMediaStorage$1] */
    /* renamed from: a */
    public void m7648a(String str) {
        new AsyncTask<String, Void, Void>() { // from class: com.navatics.app.player.content.RecentMediaStorage.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Void doInBackground(String... strArr) {
                RecentMediaStorage.this.m7646b(strArr[0]);
                return null;
            }
        }.execute(str);
    }

    /* renamed from: b */
    public void m7646b(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("id");
        contentValues.put("url", str);
        contentValues.put("last_access", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("name", m7645c(str));
        m7649a(contentValues);
    }

    /* renamed from: a */
    public void m7649a(ContentValues contentValues) {
        new C1862a(this.f4884b).getWritableDatabase().replace("RecentMedia", null, contentValues);
    }

    /* renamed from: c */
    public static String m7645c(String str) {
        return m7647a(str, "");
    }

    /* renamed from: a */
    public static String m7647a(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(47);
        String substring = lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : null;
        return TextUtils.isEmpty(substring) ? str2 : substring;
    }

    /* renamed from: com.navatics.app.player.content.RecentMediaStorage$a */
    /* loaded from: classes.dex */
    public static class C1862a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public C1862a(Context context) {
            super(context, "RecentMedia.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS RecentMedia (id INTEGER PRIMARY KEY AUTOINCREMENT, url VARCHAR UNIQUE, name VARCHAR, last_access INTEGER) ");
        }
    }

    /* loaded from: classes.dex */
    public static class CursorLoader extends AsyncTaskLoader<Cursor> {
        @Override // android.support.p008v4.content.AsyncTaskLoader
        /* renamed from: a */
        public Cursor loadInBackground() {
            return new C1862a(getContext()).getReadableDatabase().query("RecentMedia", RecentMediaStorage.f4883a, null, null, null, null, "last_access DESC", "100");
        }

        @Override // android.support.p008v4.content.Loader
        protected void onStartLoading() {
            forceLoad();
        }
    }
}
