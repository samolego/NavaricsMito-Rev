package com.google.android.gms.internal;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class zzaoh {
    /* renamed from: aQ */
    public Number mo9661aQ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: aR */
    public String mo9660aR() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: aS */
    public boolean m9668aS() {
        return this instanceof zzaoe;
    }

    /* renamed from: aT */
    public boolean m9667aT() {
        return this instanceof zzaok;
    }

    /* renamed from: aU */
    public boolean m9666aU() {
        return this instanceof zzaon;
    }

    /* renamed from: aV */
    public boolean m9665aV() {
        return this instanceof zzaoj;
    }

    /* renamed from: aW */
    public zzaok m9664aW() {
        if (m9667aT()) {
            return (zzaok) this;
        }
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
        sb.append("Not a JSON Object: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: aX */
    public zzaoe m9663aX() {
        if (m9668aS()) {
            return (zzaoe) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    /* renamed from: aY */
    public zzaon m9662aY() {
        if (m9666aU()) {
            return (zzaon) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    /* renamed from: aZ */
    Boolean mo9659aZ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzaqa zzaqaVar = new zzaqa(stringWriter);
            zzaqaVar.setLenient(true);
            zzapi.zzb(this, zzaqaVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
