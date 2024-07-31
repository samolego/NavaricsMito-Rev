package org.apache.log4j.spi;

import org.apache.log4j.C3044k;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.LogLog;

/* renamed from: org.apache.log4j.spi.n */
/* loaded from: classes2.dex */
public final class RootLogger extends C3044k {
    public RootLogger(Level level) {
        super("root");
        mo1482a(level);
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public final void mo1482a(Level level) {
        if (level == null) {
            LogLog.m1596b("You have tried to set a null level to root.", new Throwable());
        } else {
            this.f11159b = level;
        }
    }
}
