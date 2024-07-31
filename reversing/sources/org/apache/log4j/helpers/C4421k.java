package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

/* renamed from: org.apache.log4j.helpers.k */
/* loaded from: classes2.dex */
public class QuietWriter extends FilterWriter {

    /* renamed from: b */
    protected ErrorHandler f11238b;

    public QuietWriter(Writer writer, ErrorHandler errorHandler) {
        super(writer);
        m1571a(errorHandler);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            try {
                this.out.write(str);
            } catch (Exception e) {
                ErrorHandler errorHandler = this.f11238b;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Failed to write [");
                stringBuffer.append(str);
                stringBuffer.append("].");
                errorHandler.mo1521a(stringBuffer.toString(), e, 1);
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            this.out.flush();
        } catch (Exception e) {
            this.f11238b.mo1521a("Failed to flush writer,", e, 2);
        }
    }

    /* renamed from: a */
    public void m1571a(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            throw new IllegalArgumentException("Attempted to set null ErrorHandler.");
        }
        this.f11238b = errorHandler;
    }
}
