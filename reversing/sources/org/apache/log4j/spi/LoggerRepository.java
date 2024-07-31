package org.apache.log4j.spi;

import org.apache.log4j.Appender;
import org.apache.log4j.C3044k;
import org.apache.log4j.Category;
import org.apache.log4j.Level;

/* renamed from: org.apache.log4j.spi.h */
/* loaded from: classes2.dex */
public interface LoggerRepository {
    /* renamed from: a */
    Level mo1494a();

    /* renamed from: a */
    C3044k mo1492a(String str);

    /* renamed from: a */
    C3044k mo1491a(String str, LoggerFactory loggerFactory);

    /* renamed from: a */
    void mo1490a(Level level);

    /* renamed from: a */
    void mo1489a(Category category);

    /* renamed from: a */
    void mo1488a(Category category, Appender appender);

    /* renamed from: a */
    boolean mo1493a(int i);

    /* renamed from: d */
    C3044k mo1487d();

    /* renamed from: e */
    void mo1486e();
}
