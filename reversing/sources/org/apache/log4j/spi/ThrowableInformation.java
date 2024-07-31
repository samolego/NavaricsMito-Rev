package org.apache.log4j.spi;

import java.io.Serializable;
import org.apache.log4j.Category;
import org.apache.log4j.DefaultThrowableRenderer;

/* loaded from: classes2.dex */
public class ThrowableInformation implements Serializable {
    static final long serialVersionUID = -4748765566864322735L;

    /* renamed from: a */
    private transient Throwable f11283a;

    /* renamed from: b */
    private transient Category f11284b;
    private String[] rep;

    public ThrowableInformation(Throwable th) {
        this.f11283a = th;
    }

    public ThrowableInformation(Throwable th, Category category) {
        this.f11283a = th;
        this.f11284b = category;
    }

    public ThrowableInformation(String[] strArr) {
        if (strArr != null) {
            this.rep = (String[]) strArr.clone();
        }
    }

    public Throwable getThrowable() {
        return this.f11283a;
    }

    public synchronized String[] getThrowableStrRep() {
        if (this.rep == null) {
            ThrowableRenderer throwableRenderer = null;
            if (this.f11284b != null) {
                LoggerRepository m1632d = this.f11284b.m1632d();
                if (m1632d instanceof ThrowableRendererSupport) {
                    throwableRenderer = ((ThrowableRendererSupport) m1632d).mo1479f();
                }
            }
            if (throwableRenderer == null) {
                this.rep = DefaultThrowableRenderer.m1619b(this.f11283a);
            } else {
                this.rep = throwableRenderer.mo1481a(this.f11283a);
            }
        }
        return (String[]) this.rep.clone();
    }
}
