package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.slf4j.helpers.c */
/* loaded from: classes2.dex */
public class NOPLoggerFactory implements ILoggerFactory {
    @Override // org.slf4j.ILoggerFactory
    /* renamed from: a */
    public InterfaceC3153b mo181a(String str) {
        return NOPLogger.NOP_LOGGER;
    }
}
