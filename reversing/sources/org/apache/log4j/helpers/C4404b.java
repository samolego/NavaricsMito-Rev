package org.apache.log4j.helpers;

import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

/* renamed from: org.apache.log4j.helpers.b */
/* loaded from: classes2.dex */
public class CountingQuietWriter extends QuietWriter {

    /* renamed from: a */
    protected long f11193a;

    public CountingQuietWriter(Writer writer, ErrorHandler errorHandler) {
        super(writer, errorHandler);
    }

    @Override // org.apache.log4j.helpers.QuietWriter, java.io.Writer
    public void write(String str) {
        try {
            this.out.write(str);
            this.f11193a += str.length();
        } catch (IOException e) {
            this.f11238b.mo1521a("Write failure.", e, 1);
        }
    }

    /* renamed from: a */
    public long m1608a() {
        return this.f11193a;
    }

    /* renamed from: a */
    public void m1607a(long j) {
        this.f11193a = j;
    }
}
