package org.slf4j.impl;

import org.slf4j.p152a.MDCAdapter;

/* renamed from: org.slf4j.impl.d */
/* loaded from: classes2.dex */
public class StaticMDCBinder {

    /* renamed from: a */
    public static final StaticMDCBinder f12571a = new StaticMDCBinder();

    private StaticMDCBinder() {
    }

    /* renamed from: a */
    public static final StaticMDCBinder m175a() {
        return f12571a;
    }

    /* renamed from: b */
    public MDCAdapter m174b() {
        return new Log4jMDCAdapter();
    }
}
