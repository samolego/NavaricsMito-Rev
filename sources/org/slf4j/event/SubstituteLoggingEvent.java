package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* renamed from: org.slf4j.event.c */
/* loaded from: classes2.dex */
public class SubstituteLoggingEvent implements LoggingEvent {

    /* renamed from: a */
    Level f12541a;

    /* renamed from: b */
    Marker f12542b;

    /* renamed from: c */
    String f12543c;

    /* renamed from: d */
    SubstituteLogger f12544d;

    /* renamed from: e */
    String f12545e;

    /* renamed from: f */
    String f12546f;

    /* renamed from: g */
    Object[] f12547g;

    /* renamed from: h */
    long f12548h;

    /* renamed from: i */
    Throwable f12549i;

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: a */
    public Level mo239a() {
        return this.f12541a;
    }

    /* renamed from: a */
    public void m234a(Level level) {
        this.f12541a = level;
    }

    /* renamed from: a */
    public void m235a(Marker marker) {
        this.f12542b = marker;
    }

    /* renamed from: a */
    public void m237a(String str) {
        this.f12543c = str;
    }

    /* renamed from: g */
    public SubstituteLogger m224g() {
        return this.f12544d;
    }

    /* renamed from: a */
    public void m233a(SubstituteLogger substituteLogger) {
        this.f12544d = substituteLogger;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: b */
    public String mo231b() {
        return this.f12546f;
    }

    /* renamed from: b */
    public void m230b(String str) {
        this.f12546f = str;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: d */
    public Object[] mo227d() {
        return this.f12547g;
    }

    /* renamed from: a */
    public void m232a(Object[] objArr) {
        this.f12547g = objArr;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: e */
    public long mo226e() {
        return this.f12548h;
    }

    /* renamed from: a */
    public void m238a(long j) {
        this.f12548h = j;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: c */
    public String mo229c() {
        return this.f12545e;
    }

    /* renamed from: c */
    public void m228c(String str) {
        this.f12545e = str;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: f */
    public Throwable mo225f() {
        return this.f12549i;
    }

    /* renamed from: a */
    public void m236a(Throwable th) {
        this.f12549i = th;
    }
}
