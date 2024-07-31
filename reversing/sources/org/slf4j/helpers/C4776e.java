package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.InterfaceC3153b;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* renamed from: org.slf4j.helpers.e */
/* loaded from: classes2.dex */
public class SubstituteLogger implements InterfaceC3153b {

    /* renamed from: a */
    private final String f12554a;

    /* renamed from: b */
    private volatile InterfaceC3153b f12555b;

    /* renamed from: c */
    private Boolean f12556c;

    /* renamed from: d */
    private Method f12557d;

    /* renamed from: e */
    private EventRecodingLogger f12558e;

    /* renamed from: f */
    private Queue<SubstituteLoggingEvent> f12559f;

    /* renamed from: g */
    private final boolean f12560g;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.f12554a = str;
        this.f12559f = queue;
        this.f12560g = z;
    }

    @Override // org.slf4j.InterfaceC3153b
    public String getName() {
        return this.f12554a;
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isTraceEnabled() {
        return m202a().isTraceEnabled();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str) {
        m202a().trace(str);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object obj) {
        m202a().trace(str, obj);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object obj, Object obj2) {
        m202a().trace(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object... objArr) {
        m202a().trace(str, objArr);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Throwable th) {
        m202a().trace(str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isDebugEnabled() {
        return m202a().isDebugEnabled();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str) {
        m202a().debug(str);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object obj) {
        m202a().debug(str, obj);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object obj, Object obj2) {
        m202a().debug(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object... objArr) {
        m202a().debug(str, objArr);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Throwable th) {
        m202a().debug(str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isInfoEnabled() {
        return m202a().isInfoEnabled();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str) {
        m202a().info(str);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object obj) {
        m202a().info(str, obj);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object obj, Object obj2) {
        m202a().info(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object... objArr) {
        m202a().info(str, objArr);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Throwable th) {
        m202a().info(str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isWarnEnabled() {
        return m202a().isWarnEnabled();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str) {
        m202a().warn(str);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object obj) {
        m202a().warn(str, obj);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object obj, Object obj2) {
        m202a().warn(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object... objArr) {
        m202a().warn(str, objArr);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Throwable th) {
        m202a().warn(str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isErrorEnabled() {
        return m202a().isErrorEnabled();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str) {
        m202a().error(str);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object obj) {
        m202a().error(str, obj);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object obj, Object obj2) {
        m202a().error(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object... objArr) {
        m202a().error(str, objArr);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Throwable th) {
        m202a().error(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f12554a.equals(((SubstituteLogger) obj).f12554a);
    }

    public int hashCode() {
        return this.f12554a.hashCode();
    }

    /* renamed from: a */
    InterfaceC3153b m202a() {
        if (this.f12555b != null) {
            return this.f12555b;
        }
        if (this.f12560g) {
            return NOPLogger.NOP_LOGGER;
        }
        return m196e();
    }

    /* renamed from: e */
    private InterfaceC3153b m196e() {
        if (this.f12558e == null) {
            this.f12558e = new EventRecodingLogger(this, this.f12559f);
        }
        return this.f12558e;
    }

    /* renamed from: a */
    public void m201a(InterfaceC3153b interfaceC3153b) {
        this.f12555b = interfaceC3153b;
    }

    /* renamed from: b */
    public boolean m199b() {
        Boolean bool = this.f12556c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f12557d = this.f12555b.getClass().getMethod("log", LoggingEvent.class);
            this.f12556c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f12556c = Boolean.FALSE;
        }
        return this.f12556c.booleanValue();
    }

    /* renamed from: a */
    public void m200a(LoggingEvent loggingEvent) {
        if (m199b()) {
            try {
                this.f12557d.invoke(this.f12555b, loggingEvent);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: c */
    public boolean m198c() {
        return this.f12555b == null;
    }

    /* renamed from: d */
    public boolean m197d() {
        return this.f12555b instanceof NOPLogger;
    }
}
