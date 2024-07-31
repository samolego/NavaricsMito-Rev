package org.apache.log4j.spi;

/* renamed from: org.apache.log4j.spi.c */
/* loaded from: classes2.dex */
public class DefaultRepositorySelector implements RepositorySelector {

    /* renamed from: a */
    final LoggerRepository f11285a;

    public DefaultRepositorySelector(LoggerRepository loggerRepository) {
        this.f11285a = loggerRepository;
    }

    @Override // org.apache.log4j.spi.RepositorySelector
    /* renamed from: a */
    public LoggerRepository mo1483a() {
        return this.f11285a;
    }
}
