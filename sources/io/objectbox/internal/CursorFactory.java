package io.objectbox.internal;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import javax.annotation.Nullable;

@Internal
/* renamed from: io.objectbox.internal.a */
/* loaded from: classes2.dex */
public interface CursorFactory<T> {
    /* renamed from: a */
    Cursor<T> mo3318a(Transaction transaction, long j, @Nullable BoxStore boxStore);
}
