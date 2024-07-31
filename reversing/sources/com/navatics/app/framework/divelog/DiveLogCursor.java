package com.navatics.app.framework.divelog;

import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.framework.divelog.DiveLog_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

/* loaded from: classes.dex */
public final class DiveLogCursor extends Cursor<DiveLog> {

    /* renamed from: i */
    private static final DiveLog_.C1777a f4335i = DiveLog_.__ID_GETTER;

    /* renamed from: j */
    private static final int f4336j = DiveLog_.email.f9437id;

    /* renamed from: k */
    private static final int f4337k = DiveLog_.place.f9437id;

    /* renamed from: l */
    private static final int f4338l = DiveLog_.date.f9437id;

    /* renamed from: m */
    private static final int f4339m = DiveLog_.longitude.f9437id;

    /* renamed from: n */
    private static final int f4340n = DiveLog_.latitude.f9437id;

    /* renamed from: o */
    private static final int f4341o = DiveLog_.weather.f9437id;

    /* renamed from: p */
    private static final int f4342p = DiveLog_.startTime.f9437id;

    /* renamed from: q */
    private static final int f4343q = DiveLog_.endTime.f9437id;

    /* renamed from: r */
    private static final int f4344r = DiveLog_.averageDepth.f9437id;

    /* renamed from: s */
    private static final int f4345s = DiveLog_.temperature.f9437id;

    /* renamed from: t */
    private static final int f4346t = DiveLog_.comment.f9437id;

    /* renamed from: u */
    private static final int f4347u = DiveLog_.uploaded.f9437id;

    /* renamed from: v */
    private static final int f4348v = DiveLog_.status.f9437id;

    /* renamed from: w */
    private static final int f4349w = DiveLog_.maxDepth.f9437id;

    /* renamed from: x */
    private static final int f4350x = DiveLog_.minDepth.f9437id;

    /* renamed from: y */
    private static final int f4351y = DiveLog_.maxTemp.f9437id;

    /* renamed from: z */
    private static final int f4352z = DiveLog_.minTemp.f9437id;

    /* renamed from: A */
    private static final int f4334A = DiveLog_.fakeDelete.f9437id;

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.DiveLogCursor$a */
    /* loaded from: classes.dex */
    static final class C1771a implements CursorFactory<DiveLog> {
        @Override // io.objectbox.internal.CursorFactory
        /* renamed from: a */
        public Cursor<DiveLog> mo3318a(Transaction transaction, long j, BoxStore boxStore) {
            return new DiveLogCursor(transaction, j, boxStore);
        }
    }

    public DiveLogCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, DiveLog_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final long mo3451b(DiveLog diveLog) {
        return f4335i.mo3317a(diveLog);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final long mo3456a(DiveLog diveLog) {
        String str = diveLog.email;
        int i = str != null ? f4336j : 0;
        String str2 = diveLog.place;
        int i2 = str2 != null ? f4337k : 0;
        String str3 = diveLog.longitude;
        int i3 = str3 != null ? f4339m : 0;
        String str4 = diveLog.latitude;
        collect400000(this.f9431d, 0L, 1, i, str, i2, str2, i3, str3, str4 != null ? f4340n : 0, str4);
        String str5 = diveLog.weather;
        int i4 = str5 != null ? f4341o : 0;
        String str6 = diveLog.comment;
        int i5 = str6 != null ? f4346t : 0;
        Date date = diveLog.date;
        int i6 = date != null ? f4338l : 0;
        collect313311(this.f9431d, 0L, 0, i4, str5, i5, str6, 0, null, 0, null, f4342p, diveLog.startTime, f4343q, diveLog.endTime, i6, i6 != 0 ? date.getTime() : 0L, f4344r, diveLog.averageDepth, f4345s, diveLog.temperature, f4348v, diveLog.status, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        long collect313311 = collect313311(this.f9431d, diveLog.f4332id, 2, 0, null, 0, null, 0, null, 0, null, f4349w, diveLog.maxDepth, f4350x, diveLog.minDepth, f4351y, diveLog.maxTemp, f4352z, diveLog.minTemp, f4347u, diveLog.uploaded ? 1 : 0, f4334A, diveLog.fakeDelete ? 1 : 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        diveLog.f4332id = collect313311;
        m8511c(diveLog);
        m3454a(diveLog.entries, DiveLogEntry.class);
        return collect313311;
    }

    /* renamed from: c */
    private void m8511c(DiveLog diveLog) {
        diveLog.__boxStore = this.f9433f;
    }
}
