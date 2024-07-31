package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.p008v4.app.NotificationCompat;
import com.tencent.wxop.stat.common.C2558a;
import com.tencent.wxop.stat.common.C2562e;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2575r;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.AbstractC2582e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.tencent.wxop.stat.au */
/* loaded from: classes2.dex */
public class C2546au {

    /* renamed from: h */
    private static StatLogger f7967h = C2569l.m4837b();

    /* renamed from: i */
    private static Context f7968i = null;

    /* renamed from: j */
    private static C2546au f7969j = null;

    /* renamed from: c */
    private C2555bc f7972c;

    /* renamed from: d */
    private C2555bc f7973d;

    /* renamed from: e */
    private C2562e f7974e;

    /* renamed from: f */
    private String f7975f;

    /* renamed from: g */
    private String f7976g;

    /* renamed from: l */
    private ConcurrentHashMap<AbstractC2582e, String> f7978l;

    /* renamed from: a */
    volatile int f7970a = 0;

    /* renamed from: b */
    C2558a f7971b = null;

    /* renamed from: k */
    private int f7977k = 0;

    /* renamed from: m */
    private boolean f7979m = false;

    /* renamed from: n */
    private HashMap<String, String> f7980n = new HashMap<>();

    private C2546au(Context context) {
        this.f7972c = null;
        this.f7973d = null;
        this.f7974e = null;
        this.f7975f = "";
        this.f7976g = "";
        this.f7978l = null;
        try {
            this.f7974e = new C2562e();
            f7968i = context.getApplicationContext();
            this.f7978l = new ConcurrentHashMap<>();
            this.f7975f = C2569l.m4814p(context);
            this.f7976g = "pri_" + C2569l.m4814p(context);
            this.f7972c = new C2555bc(f7968i, this.f7975f);
            this.f7973d = new C2555bc(f7968i, this.f7976g);
            m4901a(true);
            m4901a(false);
            m4888f();
            m4898b(f7968i);
            m4891d();
            m4884j();
        } catch (Throwable th) {
            f7967h.m4878e(th);
        }
    }

    /* renamed from: a */
    public static C2546au m4916a(Context context) {
        if (f7969j == null) {
            synchronized (C2546au.class) {
                if (f7969j == null) {
                    f7969j = new C2546au(context);
                }
            }
        }
        return f7969j;
    }

    /* renamed from: a */
    private String m4906a(List<C2556bd> list) {
        StringBuilder sb = new StringBuilder(list.size() * 3);
        sb.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (C2556bd c2556bd : list) {
            sb.append(c2556bd.f8006a);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    private synchronized void m4917a(int i, boolean z) {
        try {
            if (this.f7970a > 0 && i > 0 && !StatServiceImpl.m4973a()) {
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = f7967h;
                    statLogger.m4877i("Load " + this.f7970a + " unsent events");
                }
                ArrayList arrayList = new ArrayList(i);
                m4895b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger2 = f7967h;
                        statLogger2.m4877i("Peek " + arrayList.size() + " unsent events.");
                    }
                    m4905a(arrayList, 2, z);
                    C2592i.m4751b(f7968i).m4750b(arrayList, new C2553ba(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            f7967h.m4878e(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m4909a(com.tencent.wxop.stat.event.AbstractC2582e r8, com.tencent.wxop.stat.InterfaceC2591h r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.C2546au.m4909a(com.tencent.wxop.stat.event.e, com.tencent.wxop.stat.h, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4905a(List<C2556bd> list, int i, boolean z) {
        SQLiteDatabase m4892c;
        String str;
        if (list.size() == 0) {
            return;
        }
        int m4894b = m4894b(z);
        SQLiteDatabase sQLiteDatabase = null;
        r1 = null;
        String str2 = null;
        try {
            m4892c = m4892c(z);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (i == 2) {
                str = "update events set status=" + i + ", send_count=send_count+1  where " + m4906a(list);
            } else {
                str = "update events set status=" + i + " where " + m4906a(list);
                if (this.f7977k % 3 == 0) {
                    str2 = "delete from events where send_count>" + m4894b;
                }
                this.f7977k++;
            }
            if (StatConfig.isDebugEnable()) {
                f7967h.m4877i("update sql:" + str);
            }
            m4892c.beginTransaction();
            m4892c.execSQL(str);
            if (str2 != null) {
                f7967h.m4877i("update for delete sql:" + str2);
                m4892c.execSQL(str2);
                m4888f();
            }
            m4892c.setTransactionSuccessful();
            if (m4892c != null) {
                m4892c.endTransaction();
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = m4892c;
            f7967h.m4878e(th);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4903a(List<C2556bd> list, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (list.size() == 0) {
            return;
        }
        if (StatConfig.isDebugEnable()) {
            f7967h.m4877i("Delete " + list.size() + " events, important:" + z);
        }
        StringBuilder sb = new StringBuilder(list.size() * 3);
        sb.append("event_id in (");
        int i = 0;
        int size = list.size();
        for (C2556bd c2556bd : list) {
            sb.append(c2556bd.f8006a);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append(")");
        try {
            sQLiteDatabase = m4892c(z);
            try {
                sQLiteDatabase.beginTransaction();
                int delete = sQLiteDatabase.delete("events", sb.toString(), null);
                if (StatConfig.isDebugEnable()) {
                    f7967h.m4877i("delete " + size + " event " + sb.toString() + ", success delete:" + delete);
                }
                this.f7970a -= delete;
                sQLiteDatabase.setTransactionSuccessful();
                m4888f();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th2) {
                th = th2;
                f7967h.m4878e(th);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th = th3;
        }
    }

    /* renamed from: a */
    private void m4901a(boolean z) {
        try {
            SQLiteDatabase m4892c = m4892c(z);
            m4892c.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 1);
            int update = m4892c.update("events", contentValues, "status=?", new String[]{Long.toString(2L)});
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = f7967h;
                statLogger.m4877i("update " + update + " unsent events.");
            }
            m4892c.setTransactionSuccessful();
            if (m4892c != null) {
                m4892c.endTransaction();
            }
        } catch (Throwable th) {
            f7967h.m4878e(th);
        }
    }

    /* renamed from: b */
    private int m4894b(boolean z) {
        return !z ? StatConfig.getMaxSendRetryCount() : StatConfig.getMaxImportantDataSendRetryCount();
    }

    /* renamed from: b */
    public static C2546au m4900b() {
        return f7969j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4899b(int i, boolean z) {
        if (i == -1) {
            i = !z ? m4887g() : m4886h();
        }
        if (i > 0) {
            int sendPeriodMinutes = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
            if (i > sendPeriodMinutes && sendPeriodMinutes > 0) {
                i = sendPeriodMinutes;
            }
            int m4989a = StatConfig.m4989a();
            int i2 = i / m4989a;
            int i3 = i % m4989a;
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = f7967h;
                statLogger.m4877i("sentStoreEventsByDb sendNumbers=" + i + ",important=" + z + ",maxSendNumPerFor1Period=" + sendPeriodMinutes + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                m4917a(m4989a, z);
            }
            if (i3 > 0) {
                m4917a(i3, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m4897b(AbstractC2582e abstractC2582e, InterfaceC2591h interfaceC2591h, boolean z, boolean z2) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (StatConfig.f7870m > 0 && !z && !z2) {
                if (StatConfig.f7870m > 0) {
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger = f7967h;
                        statLogger.m4877i("cacheEventsInMemory.size():" + this.f7978l.size() + ",numEventsCachedInMemory:" + StatConfig.f7870m + ",numStoredEvents:" + this.f7970a);
                        StatLogger statLogger2 = f7967h;
                        StringBuilder sb = new StringBuilder("cache event:");
                        sb.append(abstractC2582e.m4766g());
                        statLogger2.m4877i(sb.toString());
                    }
                    this.f7978l.put(abstractC2582e, "");
                    if (this.f7978l.size() >= StatConfig.f7870m) {
                        m4885i();
                    }
                    if (interfaceC2591h != null) {
                        if (this.f7978l.size() > 0) {
                            m4885i();
                        }
                        interfaceC2591h.mo4749a();
                    }
                }
            }
            m4909a(abstractC2582e, interfaceC2591h, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m4896b(C2589f c2589f) {
        boolean z;
        long insert;
        Cursor cursor = null;
        try {
            String m4762a = c2589f.m4762a();
            String m4840a = C2569l.m4840a(m4762a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", c2589f.f8138b.toString());
            contentValues.put("md5sum", m4840a);
            c2589f.f8139c = m4840a;
            contentValues.put("version", Integer.valueOf(c2589f.f8140d));
            Cursor query = this.f7972c.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (true) {
                try {
                    if (!query.moveToNext()) {
                        z = false;
                        break;
                    } else if (query.getInt(0) == c2589f.f8137a) {
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    f7967h.m4878e(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                    try {
                        this.f7972c.getWritableDatabase().endTransaction();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
            this.f7972c.getWritableDatabase().beginTransaction();
            if (true == z) {
                insert = this.f7972c.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(c2589f.f8137a)});
            } else {
                contentValues.put(IjkMediaMeta.IJKM_KEY_TYPE, Integer.valueOf(c2589f.f8137a));
                insert = this.f7972c.getWritableDatabase().insert("config", null, contentValues);
            }
            if (insert == -1) {
                f7967h.m4879e("Failed to store cfg:" + m4762a);
            } else {
                f7967h.m4880d("Sucessed to store cfg:" + m4762a);
            }
            this.f7972c.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.f7972c.getWritableDatabase().endTransaction();
            } catch (Exception unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    private void m4895b(List<C2556bd> list, int i, boolean z) {
        Cursor cursor = null;
        try {
            cursor = m4890d(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
            while (cursor.moveToNext()) {
                long j = cursor.getLong(0);
                String string = cursor.getString(1);
                if (!StatConfig.f7864g) {
                    string = C2575r.m4788a(string);
                }
                String str = string;
                int i2 = cursor.getInt(2);
                int i3 = cursor.getInt(3);
                C2556bd c2556bd = new C2556bd(j, str, i2, i3);
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = f7967h;
                    statLogger.m4877i("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + cursor.getLong(4));
                }
                list.add(c2556bd);
            }
        } catch (Throwable th) {
            try {
                f7967h.m4878e(th);
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

    /* renamed from: c */
    private SQLiteDatabase m4892c(boolean z) {
        return (!z ? this.f7972c : this.f7973d).getWritableDatabase();
    }

    /* renamed from: d */
    private SQLiteDatabase m4890d(boolean z) {
        return (!z ? this.f7972c : this.f7973d).getReadableDatabase();
    }

    /* renamed from: f */
    private void m4888f() {
        this.f7970a = m4887g() + m4886h();
    }

    /* renamed from: g */
    private int m4887g() {
        return (int) DatabaseUtils.queryNumEntries(this.f7972c.getReadableDatabase(), "events");
    }

    /* renamed from: h */
    private int m4886h() {
        return (int) DatabaseUtils.queryNumEntries(this.f7973d.getReadableDatabase(), "events");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x00ce
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4885i() {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.C2546au.m4885i():void");
    }

    /* renamed from: j */
    private void m4884j() {
        Cursor cursor = null;
        try {
            cursor = this.f7972c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                this.f7980n.put(cursor.getString(0), cursor.getString(1));
            }
        } catch (Throwable th) {
            try {
                f7967h.m4878e(th);
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

    /* renamed from: a */
    public int m4919a() {
        return this.f7970a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4918a(int i) {
        this.f7974e.m4865a(new RunnableC2554bb(this, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4908a(AbstractC2582e abstractC2582e, InterfaceC2591h interfaceC2591h, boolean z, boolean z2) {
        C2562e c2562e = this.f7974e;
        if (c2562e != null) {
            c2562e.m4865a(new RunnableC2550ay(this, abstractC2582e, interfaceC2591h, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4907a(C2589f c2589f) {
        if (c2589f == null) {
            return;
        }
        this.f7974e.m4865a(new RunnableC2551az(this, c2589f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4904a(List<C2556bd> list, int i, boolean z, boolean z2) {
        C2562e c2562e = this.f7974e;
        if (c2562e != null) {
            c2562e.m4865a(new RunnableC2547av(this, list, i, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4902a(List<C2556bd> list, boolean z, boolean z2) {
        C2562e c2562e = this.f7974e;
        if (c2562e != null) {
            c2562e.m4865a(new RunnableC2548aw(this, list, z, z2));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: b */
    public synchronized com.tencent.wxop.stat.common.C2558a m4898b(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.C2546au.m4898b(android.content.Context):com.tencent.wxop.stat.common.a");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m4893c() {
        if (StatConfig.isEnableStatService()) {
            try {
                this.f7974e.m4865a(new RunnableC2549ax(this));
            } catch (Throwable th) {
                f7967h.m4878e(th);
            }
        }
    }

    /* renamed from: d */
    void m4891d() {
        Cursor cursor = null;
        try {
            cursor = this.f7972c.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                int i = cursor.getInt(0);
                String string = cursor.getString(1);
                String string2 = cursor.getString(2);
                int i2 = cursor.getInt(3);
                C2589f c2589f = new C2589f(i);
                c2589f.f8137a = i;
                c2589f.f8138b = new JSONObject(string);
                c2589f.f8139c = string2;
                c2589f.f8140d = i2;
                StatConfig.m4985a(f7968i, c2589f);
            }
        } catch (Throwable th) {
            try {
                f7967h.m4878e(th);
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
}
