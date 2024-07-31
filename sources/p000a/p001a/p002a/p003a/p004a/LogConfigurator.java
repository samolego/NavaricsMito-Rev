package p000a.p001a.p002a.p003a.p004a;

import android.support.p008v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import org.apache.log4j.Appender;
import org.apache.log4j.C3044k;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.LogLog;

/* renamed from: a.a.a.a.a.b */
/* loaded from: classes.dex */
public class LogConfigurator {

    /* renamed from: a */
    private Level f1a = Level.DEBUG;

    /* renamed from: b */
    private String f2b = "%d - [%p::%c::%C] - %m%n";

    /* renamed from: c */
    private String f3c = "%m%n";

    /* renamed from: d */
    private String f4d = "android-log4j.log";

    /* renamed from: e */
    private int f5e = 5;

    /* renamed from: f */
    private long f6f = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;

    /* renamed from: g */
    private boolean f7g = true;

    /* renamed from: h */
    private boolean f8h = true;

    /* renamed from: i */
    private boolean f9i = true;

    /* renamed from: j */
    private boolean f10j = true;

    /* renamed from: k */
    private boolean f11k = false;

    /* renamed from: a */
    public void m12952a() {
        C3044k m1561j = C3044k.m1561j();
        if (m12933k()) {
            LogManager.m1568a().mo1486e();
        }
        LogLog.m1598a(m12932l());
        if (m12935i()) {
            m12931m();
        }
        if (m12934j()) {
            m12930n();
        }
        m1561j.mo1482a(m12946b());
    }

    /* renamed from: a */
    public void m12949a(String str, Level level) {
        C3044k.m1563b(str).mo1482a(level);
    }

    /* renamed from: m */
    private void m12931m() {
        C3044k m1561j = C3044k.m1561j();
        try {
            RollingFileAppender rollingFileAppender = new RollingFileAppender(new PatternLayout(m12943c()), m12939e());
            rollingFileAppender.m1531a(m12938f());
            rollingFileAppender.m1530a(m12937g());
            rollingFileAppender.m1474a(m12936h());
            m1561j.mo1508a((Appender) rollingFileAppender);
        } catch (IOException e) {
            throw new RuntimeException("Exception configuring log system", e);
        }
    }

    /* renamed from: n */
    private void m12930n() {
        C3044k.m1561j().mo1508a((Appender) new LogCatAppender(new PatternLayout(m12940d())));
    }

    /* renamed from: b */
    public Level m12946b() {
        return this.f1a;
    }

    /* renamed from: a */
    public void m12948a(Level level) {
        this.f1a = level;
    }

    /* renamed from: c */
    public String m12943c() {
        return this.f2b;
    }

    /* renamed from: a */
    public void m12950a(String str) {
        this.f2b = str;
    }

    /* renamed from: d */
    public String m12940d() {
        return this.f3c;
    }

    /* renamed from: b */
    public void m12945b(String str) {
        this.f3c = str;
    }

    /* renamed from: e */
    public String m12939e() {
        return this.f4d;
    }

    /* renamed from: c */
    public void m12942c(String str) {
        this.f4d = str;
    }

    /* renamed from: f */
    public int m12938f() {
        return this.f5e;
    }

    /* renamed from: g */
    public long m12937g() {
        return this.f6f;
    }

    /* renamed from: a */
    public void m12951a(long j) {
        this.f6f = j;
    }

    /* renamed from: h */
    public boolean m12936h() {
        return this.f7g;
    }

    /* renamed from: a */
    public void m12947a(boolean z) {
        this.f7g = z;
    }

    /* renamed from: i */
    public boolean m12935i() {
        return this.f9i;
    }

    /* renamed from: b */
    public void m12944b(boolean z) {
        this.f9i = z;
    }

    /* renamed from: j */
    public boolean m12934j() {
        return this.f8h;
    }

    /* renamed from: c */
    public void m12941c(boolean z) {
        this.f8h = z;
    }

    /* renamed from: k */
    public boolean m12933k() {
        return this.f10j;
    }

    /* renamed from: l */
    public boolean m12932l() {
        return this.f11k;
    }
}
