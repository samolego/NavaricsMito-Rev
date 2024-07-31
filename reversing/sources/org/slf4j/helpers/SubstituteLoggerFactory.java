package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.InterfaceC3153b;
import org.slf4j.event.SubstituteLoggingEvent;

/* renamed from: org.slf4j.helpers.f */
/* loaded from: classes2.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {

    /* renamed from: a */
    boolean f12561a = false;

    /* renamed from: b */
    final Map<String, SubstituteLogger> f12562b = new HashMap();

    /* renamed from: c */
    final LinkedBlockingQueue<SubstituteLoggingEvent> f12563c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    /* renamed from: a */
    public synchronized InterfaceC3153b mo181a(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = this.f12562b.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.f12563c, this.f12561a);
            this.f12562b.put(str, substituteLogger);
        }
        return substituteLogger;
    }

    /* renamed from: a */
    public List<SubstituteLogger> m195a() {
        return new ArrayList(this.f12562b.values());
    }

    /* renamed from: b */
    public LinkedBlockingQueue<SubstituteLoggingEvent> m194b() {
        return this.f12563c;
    }

    /* renamed from: c */
    public void m193c() {
        this.f12561a = true;
    }

    /* renamed from: d */
    public void m192d() {
        this.f12562b.clear();
        this.f12563c.clear();
    }
}
