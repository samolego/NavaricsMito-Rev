package io.objectbox.exception;

/* loaded from: classes2.dex */
public class DbMaxReadersExceededException extends DbException {
    public DbMaxReadersExceededException(String str) {
        super(str);
    }

    public DbMaxReadersExceededException(String str, int i) {
        super(str, i);
    }
}