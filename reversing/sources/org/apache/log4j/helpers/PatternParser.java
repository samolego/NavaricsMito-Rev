package org.apache.log4j.helpers;

import com.navatics.app.framework.user.Result;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.helpers.j */
/* loaded from: classes2.dex */
public class PatternParser {

    /* renamed from: i */
    static Class f11219i;

    /* renamed from: c */
    protected int f11222c;

    /* renamed from: d */
    protected int f11223d;

    /* renamed from: e */
    PatternConverter f11224e;

    /* renamed from: f */
    PatternConverter f11225f;

    /* renamed from: h */
    protected String f11227h;

    /* renamed from: b */
    protected StringBuffer f11221b = new StringBuffer(32);

    /* renamed from: g */
    protected FormattingInfo f11226g = new FormattingInfo();

    /* renamed from: a */
    int f11220a = 0;

    public PatternParser(String str) {
        this.f11227h = str;
        this.f11222c = str.length();
    }

    /* renamed from: b */
    private void m1576b(PatternConverter patternConverter) {
        if (this.f11224e == null) {
            this.f11225f = patternConverter;
            this.f11224e = patternConverter;
            return;
        }
        this.f11225f.f11215a = patternConverter;
        this.f11225f = patternConverter;
    }

    /* renamed from: a */
    protected String m1581a() {
        int indexOf;
        int i;
        int i2 = this.f11223d;
        if (i2 >= this.f11222c || this.f11227h.charAt(i2) != '{' || (indexOf = this.f11227h.indexOf(125, this.f11223d)) <= (i = this.f11223d)) {
            return null;
        }
        String substring = this.f11227h.substring(i + 1, indexOf);
        this.f11223d = indexOf + 1;
        return substring;
    }

    /* renamed from: b */
    protected int m1577b() {
        NumberFormatException e;
        int i;
        String m1581a = m1581a();
        if (m1581a == null) {
            return 0;
        }
        try {
            i = Integer.parseInt(m1581a);
            if (i <= 0) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Precision option (");
                    stringBuffer.append(m1581a);
                    stringBuffer.append(") isn't a positive integer.");
                    LogLog.m1597b(stringBuffer.toString());
                    return 0;
                } catch (NumberFormatException e2) {
                    e = e2;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Category option \"");
                    stringBuffer2.append(m1581a);
                    stringBuffer2.append("\" not a decimal integer.");
                    LogLog.m1596b(stringBuffer2.toString(), e);
                    return i;
                }
            }
            return i;
        } catch (NumberFormatException e3) {
            e = e3;
            i = 0;
        }
    }

    /* renamed from: c */
    public PatternConverter m1575c() {
        this.f11223d = 0;
        while (true) {
            int i = this.f11223d;
            if (i < this.f11222c) {
                String str = this.f11227h;
                this.f11223d = i + 1;
                char charAt = str.charAt(i);
                switch (this.f11220a) {
                    case 0:
                        int i2 = this.f11223d;
                        if (i2 != this.f11222c) {
                            if (charAt == '%') {
                                char charAt2 = this.f11227h.charAt(i2);
                                if (charAt2 == '%') {
                                    this.f11221b.append(charAt);
                                    this.f11223d++;
                                    break;
                                } else if (charAt2 == 'n') {
                                    this.f11221b.append(Layout.f11239a);
                                    this.f11223d++;
                                    break;
                                } else {
                                    if (this.f11221b.length() != 0) {
                                        m1576b(new C3040e(this.f11221b.toString()));
                                    }
                                    this.f11221b.setLength(0);
                                    this.f11221b.append(charAt);
                                    this.f11220a = 1;
                                    this.f11226g.m1606a();
                                    break;
                                }
                            } else {
                                this.f11221b.append(charAt);
                                break;
                            }
                        } else {
                            this.f11221b.append(charAt);
                            break;
                        }
                    case 1:
                        this.f11221b.append(charAt);
                        switch (charAt) {
                            case '-':
                                this.f11226g.f11196c = true;
                                continue;
                            case '.':
                                this.f11220a = 3;
                                continue;
                            default:
                                if (charAt >= '0' && charAt <= '9') {
                                    this.f11226g.f11194a = charAt - '0';
                                    this.f11220a = 4;
                                    break;
                                } else {
                                    m1580a(charAt);
                                    continue;
                                }
                        }
                    case 3:
                        this.f11221b.append(charAt);
                        if (charAt >= '0' && charAt <= '9') {
                            this.f11226g.f11195b = charAt - '0';
                            this.f11220a = 5;
                            break;
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Error occured in position ");
                            stringBuffer.append(this.f11223d);
                            stringBuffer.append(".\n Was expecting digit, instead got char \"");
                            stringBuffer.append(charAt);
                            stringBuffer.append("\".");
                            LogLog.m1597b(stringBuffer.toString());
                            this.f11220a = 0;
                            break;
                        }
                    case 4:
                        this.f11221b.append(charAt);
                        if (charAt >= '0' && charAt <= '9') {
                            FormattingInfo formattingInfo = this.f11226g;
                            formattingInfo.f11194a = (formattingInfo.f11194a * 10) + (charAt - '0');
                            break;
                        } else if (charAt == '.') {
                            this.f11220a = 3;
                            break;
                        } else {
                            m1580a(charAt);
                            break;
                        }
                    case 5:
                        this.f11221b.append(charAt);
                        if (charAt >= '0' && charAt <= '9') {
                            FormattingInfo formattingInfo2 = this.f11226g;
                            formattingInfo2.f11195b = (formattingInfo2.f11195b * 10) + (charAt - '0');
                            break;
                        } else {
                            m1580a(charAt);
                            this.f11220a = 0;
                            break;
                        }
                }
            } else {
                if (this.f11221b.length() != 0) {
                    m1576b(new C3040e(this.f11221b.toString()));
                }
                return this.f11224e;
            }
        }
    }

    /* renamed from: a */
    static Class m1579a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: a */
    protected void m1580a(char c) {
        PatternConverter c3038c;
        DateFormat dateFormat;
        switch (c) {
            case 'C':
                c3038c = new C3038c(this, this.f11226g, m1577b());
                this.f11221b.setLength(0);
                break;
            case 'F':
                c3038c = new C3041f(this, this.f11226g, 1004);
                this.f11221b.setLength(0);
                break;
            case 'L':
                c3038c = new C3041f(this, this.f11226g, 1003);
                this.f11221b.setLength(0);
                break;
            case 'M':
                c3038c = new C3041f(this, this.f11226g, 1001);
                this.f11221b.setLength(0);
                break;
            case 'X':
                C3042g c3042g = new C3042g(this.f11226g, m1581a());
                this.f11221b.setLength(0);
                c3038c = c3042g;
                break;
            case 'c':
                c3038c = new C3037b(this, this.f11226g, m1577b());
                this.f11221b.setLength(0);
                break;
            case 'd':
                String str = AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT;
                String m1581a = m1581a();
                if (m1581a != null) {
                    str = m1581a;
                }
                if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT)) {
                    dateFormat = new ISO8601DateFormat();
                } else if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.ABS_TIME_DATE_FORMAT)) {
                    dateFormat = new AbsoluteTimeDateFormat();
                } else if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT)) {
                    dateFormat = new DateTimeDateFormat();
                } else {
                    try {
                        dateFormat = new SimpleDateFormat(str);
                    } catch (IllegalArgumentException e) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Could not instantiate SimpleDateFormat with ");
                        stringBuffer.append(str);
                        LogLog.m1596b(stringBuffer.toString(), e);
                        Class cls = f11219i;
                        if (cls == null) {
                            cls = m1579a("java.text.DateFormat");
                            f11219i = cls;
                        }
                        dateFormat = (DateFormat) OptionConverter.m1590a("org.apache.log4j.helpers.ISO8601DateFormat", cls, (Object) null);
                    }
                }
                C3039d c3039d = new C3039d(this.f11226g, dateFormat);
                this.f11221b.setLength(0);
                c3038c = c3039d;
                break;
            case 'l':
                c3038c = new C3041f(this, this.f11226g, 1000);
                this.f11221b.setLength(0);
                break;
            case 'm':
                c3038c = new C3036a(this.f11226g, 2004);
                this.f11221b.setLength(0);
                break;
            case 'p':
                c3038c = new C3036a(this.f11226g, 2002);
                this.f11221b.setLength(0);
                break;
            case 'r':
                c3038c = new C3036a(this.f11226g, 2000);
                this.f11221b.setLength(0);
                break;
            case 't':
                c3038c = new C3036a(this.f11226g, Result.ERROR_CODE_KEY_2001);
                this.f11221b.setLength(0);
                break;
            case 'x':
                c3038c = new C3036a(this.f11226g, 2003);
                this.f11221b.setLength(0);
                break;
            default:
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Unexpected char [");
                stringBuffer2.append(c);
                stringBuffer2.append("] at position ");
                stringBuffer2.append(this.f11223d);
                stringBuffer2.append(" in conversion patterrn.");
                LogLog.m1597b(stringBuffer2.toString());
                c3038c = new C3040e(this.f11221b.toString());
                this.f11221b.setLength(0);
                break;
        }
        m1578a(c3038c);
    }

    /* renamed from: a */
    protected void m1578a(PatternConverter patternConverter) {
        this.f11221b.setLength(0);
        m1576b(patternConverter);
        this.f11220a = 0;
        this.f11226g.m1606a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$a */
    /* loaded from: classes2.dex */
    public static class C3036a extends PatternConverter {

        /* renamed from: f */
        int f11228f;

        C3036a(FormattingInfo formattingInfo, int i) {
            super(formattingInfo);
            this.f11228f = i;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public String mo1573a(LoggingEvent loggingEvent) {
            switch (this.f11228f) {
                case 2000:
                    return Long.toString(loggingEvent.timeStamp - LoggingEvent.getStartTime());
                case Result.ERROR_CODE_KEY_2001 /* 2001 */:
                    return loggingEvent.getThreadName();
                case 2002:
                    return loggingEvent.getLevel().toString();
                case 2003:
                    return loggingEvent.getNDC();
                case 2004:
                    return loggingEvent.getRenderedMessage();
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$e */
    /* loaded from: classes2.dex */
    public static class C3040e extends PatternConverter {

        /* renamed from: f */
        private String f11233f;

        C3040e(String str) {
            this.f11233f = str;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public final void mo1574a(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
            stringBuffer.append(this.f11233f);
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public String mo1573a(LoggingEvent loggingEvent) {
            return this.f11233f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$d */
    /* loaded from: classes2.dex */
    public static class C3039d extends PatternConverter {

        /* renamed from: f */
        private DateFormat f11231f;

        /* renamed from: g */
        private Date f11232g;

        C3039d(FormattingInfo formattingInfo, DateFormat dateFormat) {
            super(formattingInfo);
            this.f11232g = new Date();
            this.f11231f = dateFormat;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public String mo1573a(LoggingEvent loggingEvent) {
            this.f11232g.setTime(loggingEvent.timeStamp);
            try {
                return this.f11231f.format(this.f11232g);
            } catch (Exception e) {
                LogLog.m1596b("Error occured while converting date.", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$g */
    /* loaded from: classes2.dex */
    public static class C3042g extends PatternConverter {

        /* renamed from: f */
        private String f11236f;

        C3042g(FormattingInfo formattingInfo, String str) {
            super(formattingInfo);
            this.f11236f = str;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public String mo1573a(LoggingEvent loggingEvent) {
            String str = this.f11236f;
            if (str == null) {
                StringBuffer stringBuffer = new StringBuffer("{");
                Map properties = loggingEvent.getProperties();
                if (properties.size() > 0) {
                    Object[] array = properties.keySet().toArray();
                    Arrays.sort(array);
                    for (int i = 0; i < array.length; i++) {
                        stringBuffer.append('{');
                        stringBuffer.append(array[i]);
                        stringBuffer.append(',');
                        stringBuffer.append(properties.get(array[i]));
                        stringBuffer.append('}');
                    }
                }
                stringBuffer.append('}');
                return stringBuffer.toString();
            }
            Object mdc = loggingEvent.getMDC(str);
            if (mdc == null) {
                return null;
            }
            return mdc.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$f */
    /* loaded from: classes2.dex */
    public class C3041f extends PatternConverter {

        /* renamed from: f */
        int f11234f;

        /* renamed from: g */
        private final PatternParser f11235g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3041f(PatternParser patternParser, FormattingInfo formattingInfo, int i) {
            super(formattingInfo);
            this.f11235g = patternParser;
            this.f11234f = i;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public String mo1573a(LoggingEvent loggingEvent) {
            LocationInfo locationInformation = loggingEvent.getLocationInformation();
            switch (this.f11234f) {
                case 1000:
                    return locationInformation.fullInfo;
                case 1001:
                    return locationInformation.getMethodName();
                case 1002:
                default:
                    return null;
                case 1003:
                    return locationInformation.getLineNumber();
                case 1004:
                    return locationInformation.getFileName();
            }
        }
    }

    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$h */
    /* loaded from: classes2.dex */
    private static abstract class AbstractC3043h extends PatternConverter {

        /* renamed from: f */
        int f11237f;

        /* renamed from: b */
        abstract String mo1572b(LoggingEvent loggingEvent);

        AbstractC3043h(FormattingInfo formattingInfo, int i) {
            super(formattingInfo);
            this.f11237f = i;
        }

        @Override // org.apache.log4j.helpers.PatternConverter
        /* renamed from: a */
        public String mo1573a(LoggingEvent loggingEvent) {
            String mo1572b = mo1572b(loggingEvent);
            if (this.f11237f <= 0) {
                return mo1572b;
            }
            int length = mo1572b.length();
            int i = length - 1;
            for (int i2 = this.f11237f; i2 > 0; i2--) {
                i = mo1572b.lastIndexOf(46, i - 1);
                if (i == -1) {
                    return mo1572b;
                }
            }
            return mo1572b.substring(i + 1, length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$c */
    /* loaded from: classes2.dex */
    public class C3038c extends AbstractC3043h {

        /* renamed from: g */
        private final PatternParser f11230g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3038c(PatternParser patternParser, FormattingInfo formattingInfo, int i) {
            super(formattingInfo, i);
            this.f11230g = patternParser;
        }

        @Override // org.apache.log4j.helpers.PatternParser.AbstractC3043h
        /* renamed from: b */
        String mo1572b(LoggingEvent loggingEvent) {
            return loggingEvent.getLocationInformation().getClassName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PatternParser.java */
    /* renamed from: org.apache.log4j.helpers.j$b */
    /* loaded from: classes2.dex */
    public class C3037b extends AbstractC3043h {

        /* renamed from: g */
        private final PatternParser f11229g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3037b(PatternParser patternParser, FormattingInfo formattingInfo, int i) {
            super(formattingInfo, i);
            this.f11229g = patternParser;
        }

        @Override // org.apache.log4j.helpers.PatternParser.AbstractC3043h
        /* renamed from: b */
        String mo1572b(LoggingEvent loggingEvent) {
            return loggingEvent.getLoggerName();
        }
    }
}
