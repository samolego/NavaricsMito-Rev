package org.apache.log4j;

import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.p */
/* loaded from: classes2.dex */
public class PatternLayout extends Layout {

    /* renamed from: c */
    protected final int f11255c;

    /* renamed from: d */
    protected final int f11256d;

    /* renamed from: e */
    private StringBuffer f11257e;

    /* renamed from: f */
    private String f11258f;

    /* renamed from: g */
    private PatternConverter f11259g;

    @Override // org.apache.log4j.Layout
    /* renamed from: c */
    public boolean mo1544c() {
        return true;
    }

    @Override // org.apache.log4j.spi.OptionHandler
    /* renamed from: e */
    public void mo1470e() {
    }

    public PatternLayout() {
        this("%m%n");
    }

    public PatternLayout(String str) {
        this.f11255c = 256;
        this.f11256d = 1024;
        this.f11257e = new StringBuffer(256);
        this.f11258f = str;
        this.f11259g = m1546a(str == null ? "%m%n" : str).m1575c();
    }

    /* renamed from: a */
    protected PatternParser m1546a(String str) {
        return new PatternParser(str);
    }

    @Override // org.apache.log4j.Layout
    /* renamed from: a */
    public String mo1545a(LoggingEvent loggingEvent) {
        if (this.f11257e.capacity() > 1024) {
            this.f11257e = new StringBuffer(256);
        } else {
            this.f11257e.setLength(0);
        }
        for (PatternConverter patternConverter = this.f11259g; patternConverter != null; patternConverter = patternConverter.f11215a) {
            patternConverter.mo1574a(this.f11257e, loggingEvent);
        }
        return this.f11257e.toString();
    }
}
