package com.navatics.robot.transport;

/* loaded from: classes.dex */
public class NvException extends RuntimeException {
    private NvError error;

    public NvException(NvError nvError) {
        super(nvError.m6632b());
        this.error = nvError;
    }

    public NvException(String str, NvError nvError) {
        super(str);
        this.error = nvError;
    }

    public NvException(String str, Throwable th, NvError nvError) {
        super(str, th);
        this.error = nvError;
    }

    public NvException(Throwable th, NvError nvError) {
        super(th);
        this.error = nvError;
    }

    public NvError getError() {
        return this.error;
    }
}