package p000a.p001a.p002a.p003a.p004a;

import android.util.Log;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: a.a.a.a.a.a */
/* loaded from: classes.dex */
public class LogCatAppender extends AppenderSkeleton {

    /* renamed from: a */
    protected Layout f0a;

    @Override // org.apache.log4j.Appender
    /* renamed from: a */
    public void mo1478a() {
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: b */
    public boolean mo1473b() {
        return true;
    }

    public LogCatAppender(Layout layout, Layout layout2) {
        this.f0a = layout2;
        mo1644a(layout);
    }

    public LogCatAppender(Layout layout) {
        this(layout, new PatternLayout("%c"));
    }

    public LogCatAppender() {
        this(new PatternLayout("%m%n"));
    }

    @Override // org.apache.log4j.AppenderSkeleton
    /* renamed from: a */
    protected void mo1476a(LoggingEvent loggingEvent) {
        int i = loggingEvent.getLevel().toInt();
        if (i == 5000) {
            if (loggingEvent.getThrowableInformation() != null) {
                Log.v(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
            } else {
                Log.v(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent));
            }
        } else if (i == 10000) {
            if (loggingEvent.getThrowableInformation() != null) {
                Log.d(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
            } else {
                Log.d(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent));
            }
        } else if (i == 20000) {
            if (loggingEvent.getThrowableInformation() != null) {
                Log.i(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
            } else {
                Log.i(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent));
            }
        } else if (i == 30000) {
            if (loggingEvent.getThrowableInformation() != null) {
                Log.w(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
            } else {
                Log.w(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent));
            }
        } else if (i == 40000) {
            if (loggingEvent.getThrowableInformation() != null) {
                Log.e(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
            } else {
                Log.e(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent));
            }
        } else if (i != 50000) {
        } else {
            if (loggingEvent.getThrowableInformation() != null) {
                Log.wtf(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
            } else {
                Log.wtf(m12953c().mo1545a(loggingEvent), m1639f().mo1545a(loggingEvent));
            }
        }
    }

    /* renamed from: c */
    public Layout m12953c() {
        return this.f0a;
    }
}
