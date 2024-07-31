package com.navatics.app.framework.p053e;

/* renamed from: com.navatics.app.framework.e.c */
/* loaded from: classes.dex */
public class MessageLoggerFactory {

    /* renamed from: a */
    private static MessageLoggerStrategy f4460a;

    /* renamed from: a */
    public static MessageLoggerStrategy m8420a() {
        if (f4460a == null) {
            synchronized (MessageLoggerFactory.class) {
                if (f4460a == null) {
                    f4460a = new C1795a();
                }
            }
        }
        return f4460a;
    }

    /* renamed from: b */
    public static MessageLogger m8419b() {
        return m8420a().mo8418a();
    }

    /* compiled from: MessageLoggerFactory.java */
    /* renamed from: com.navatics.app.framework.e.c$a */
    /* loaded from: classes.dex */
    public static class C1795a implements MessageLoggerStrategy {

        /* renamed from: a */
        MessageLogger f4461a;

        /* renamed from: b */
        MessageLogger f4462b;

        @Override // com.navatics.app.framework.p053e.MessageLoggerStrategy
        /* renamed from: a */
        public synchronized MessageLogger mo8418a() {
            if (this.f4462b == null) {
                this.f4462b = new FileLogger("firmware-update.log", 10485760L);
            }
            return this.f4462b;
        }

        @Override // com.navatics.app.framework.p053e.MessageLoggerStrategy
        /* renamed from: b */
        public void mo8417b() {
            MessageLogger messageLogger = this.f4461a;
            if (messageLogger != null) {
                messageLogger.mo8422a();
            }
            MessageLogger messageLogger2 = this.f4462b;
            if (messageLogger2 != null) {
                messageLogger2.mo8422a();
            }
        }
    }
}
