package com.navatics.app.framework.divelog;

import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.framework.divelog.Command_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.relation.ToOne;
import java.io.Closeable;
import java.util.Date;

/* loaded from: classes.dex */
public final class CommandCursor extends Cursor<Command> {

    /* renamed from: i */
    private static final Command_.C1767a f4322i = Command_.__ID_GETTER;

    /* renamed from: j */
    private static final int f4323j = Command_.command.f9437id;

    /* renamed from: k */
    private static final int f4324k = Command_.startTime.f9437id;

    /* renamed from: l */
    private static final int f4325l = Command_.detailIndex.f9437id;

    /* renamed from: m */
    private static final int f4326m = Command_.version.f9437id;

    /* renamed from: n */
    private static final int f4327n = Command_.createTime.f9437id;

    /* renamed from: o */
    private static final int f4328o = Command_.json.f9437id;

    /* renamed from: p */
    private static final int f4329p = Command_.filedName.f9437id;

    /* renamed from: q */
    private static final int f4330q = Command_.parentId.f9437id;

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.CommandCursor$a */
    /* loaded from: classes.dex */
    static final class C1765a implements CursorFactory<Command> {
        @Override // io.objectbox.internal.CursorFactory
        /* renamed from: a */
        public Cursor<Command> mo3318a(Transaction transaction, long j, BoxStore boxStore) {
            return new CommandCursor(transaction, j, boxStore);
        }
    }

    public CommandCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, Command_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final long mo3451b(Command command) {
        return f4322i.mo3317a(command);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.objectbox.Cursor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final long mo3456a(Command command) {
        ToOne<LocalDiveLogRecord> toOne = command.parent;
        if (toOne != 0 && toOne.internalRequiresPutTarget()) {
            Closeable a = m3457a(LocalDiveLogRecord.class);
            try {
                toOne.internalPutTarget(a);
            } finally {
                a.close();
            }
        }
        String m8529b = command.m8529b();
        int i = m8529b != null ? f4323j : 0;
        String m8527c = command.m8527c();
        int i2 = m8527c != null ? f4324k : 0;
        String m8525d = command.m8525d();
        int i3 = m8525d != null ? f4325l : 0;
        String m8520g = command.m8520g();
        collect400000(this.f9431d, 0L, 1, i, m8529b, i2, m8527c, i3, m8525d, m8520g != null ? f4328o : 0, m8520g);
        String m8519h = command.m8519h();
        int i4 = m8519h != null ? f4329p : 0;
        Date m8521f = command.m8521f();
        int i5 = m8521f != null ? f4327n : 0;
        long collect313311 = collect313311(this.f9431d, command.f4321id, 2, i4, m8519h, 0, null, 0, null, 0, null, f4330q, command.parent.getTargetId(), i5, i5 != 0 ? m8521f.getTime() : 0L, f4326m, command.m8523e(), 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        command.f4321id = collect313311;
        m8516c(command);
        return collect313311;
    }

    /* renamed from: c */
    private void m8516c(Command command) {
        command.__boxStore = this.f9433f;
    }
}
