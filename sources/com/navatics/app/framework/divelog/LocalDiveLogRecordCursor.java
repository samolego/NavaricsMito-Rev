package com.navatics.app.framework.divelog;

import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.framework.divelog.LocalDiveLogRecord_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;

/* loaded from: classes.dex */
public final class LocalDiveLogRecordCursor extends Cursor<LocalDiveLogRecord> {

    /* renamed from: i */
    private static final LocalDiveLogRecord_.C1782a f4398i = LocalDiveLogRecord_.__ID_GETTER;

    /* renamed from: j */
    private static final int f4399j = LocalDiveLogRecord_.email.f9437id;

    /* renamed from: k */
    private static final int f4400k = LocalDiveLogRecord_.startTime.f9437id;

    /* renamed from: l */
    private static final int f4401l = LocalDiveLogRecord_.version.f9437id;

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.LocalDiveLogRecordCursor$a */
    /* loaded from: classes.dex */
    static final class C1779a implements CursorFactory<LocalDiveLogRecord> {
        @Override // io.objectbox.internal.CursorFactory
        /* renamed from: a */
        public Cursor<LocalDiveLogRecord> mo3318a(Transaction transaction, long j, BoxStore boxStore) {
            return new LocalDiveLogRecordCursor(transaction, j, boxStore);
        }
    }

    public LocalDiveLogRecordCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, LocalDiveLogRecord_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final long mo3451b(LocalDiveLogRecord localDiveLogRecord) {
        return f4398i.mo3317a(localDiveLogRecord);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final long mo3456a(LocalDiveLogRecord localDiveLogRecord) {
        String str = localDiveLogRecord.email;
        int i = str != null ? f4399j : 0;
        String str2 = localDiveLogRecord.startTime;
        long collect313311 = collect313311(this.f9431d, localDiveLogRecord.f4396id, 3, i, str, str2 != null ? f4400k : 0, str2, 0, null, 0, null, f4401l, localDiveLogRecord.version, 0, 0L, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        localDiveLogRecord.f4396id = collect313311;
        m8491c(localDiveLogRecord);
        m3454a(localDiveLogRecord.entries, Command.class);
        return collect313311;
    }

    /* renamed from: c */
    private void m8491c(LocalDiveLogRecord localDiveLogRecord) {
        localDiveLogRecord.__boxStore = this.f9433f;
    }
}
