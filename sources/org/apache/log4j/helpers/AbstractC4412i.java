package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.helpers.i */
/* loaded from: classes2.dex */
public abstract class PatternConverter {

    /* renamed from: e */
    static String[] f11214e = {" ", "  ", "    ", "        ", "                ", "                                "};

    /* renamed from: a */
    public PatternConverter f11215a;

    /* renamed from: b */
    int f11216b;

    /* renamed from: c */
    int f11217c;

    /* renamed from: d */
    boolean f11218d;

    /* renamed from: a */
    protected abstract String mo1573a(LoggingEvent loggingEvent);

    /* JADX INFO: Access modifiers changed from: protected */
    public PatternConverter() {
        this.f11216b = -1;
        this.f11217c = Integer.MAX_VALUE;
        this.f11218d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PatternConverter(FormattingInfo formattingInfo) {
        this.f11216b = -1;
        this.f11217c = Integer.MAX_VALUE;
        this.f11218d = false;
        this.f11216b = formattingInfo.f11194a;
        this.f11217c = formattingInfo.f11195b;
        this.f11218d = formattingInfo.f11196c;
    }

    /* renamed from: a */
    public void mo1574a(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        String mo1573a = mo1573a(loggingEvent);
        if (mo1573a == null) {
            int i = this.f11216b;
            if (i > 0) {
                m1582a(stringBuffer, i);
                return;
            }
            return;
        }
        int length = mo1573a.length();
        int i2 = this.f11217c;
        if (length > i2) {
            stringBuffer.append(mo1573a.substring(length - i2));
            return;
        }
        int i3 = this.f11216b;
        if (length < i3) {
            if (this.f11218d) {
                stringBuffer.append(mo1573a);
                m1582a(stringBuffer, this.f11216b - length);
                return;
            }
            m1582a(stringBuffer, i3 - length);
            stringBuffer.append(mo1573a);
            return;
        }
        stringBuffer.append(mo1573a);
    }

    /* renamed from: a */
    public void m1582a(StringBuffer stringBuffer, int i) {
        while (i >= 32) {
            stringBuffer.append(f11214e[5]);
            i -= 32;
        }
        for (int i2 = 4; i2 >= 0; i2--) {
            if (((1 << i2) & i) != 0) {
                stringBuffer.append(f11214e[i2]);
            }
        }
    }
}
