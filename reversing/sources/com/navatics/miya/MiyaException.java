package com.navatics.miya;

/* loaded from: classes.dex */
public class MiyaException extends RuntimeException {
    private StringBuffer trace;

    public MiyaException() {
    }

    public MiyaException(String str, Throwable th) {
        super(str, th);
    }

    public MiyaException(String str) {
        super(str);
    }

    public MiyaException(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.trace == null) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        stringBuffer.append(super.getMessage());
        if (stringBuffer.length() > 0) {
            stringBuffer.append('\n');
        }
        stringBuffer.append("Serialization trace:");
        stringBuffer.append(this.trace);
        return stringBuffer.toString();
    }

    public void addTrace(String str) {
        if (str == null) {
            throw new IllegalArgumentException("info cannot be null.");
        }
        if (this.trace == null) {
            this.trace = new StringBuffer(512);
        }
        this.trace.append('\n');
        this.trace.append(str);
    }
}
