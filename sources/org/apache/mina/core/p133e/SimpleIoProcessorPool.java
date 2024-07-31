package org.apache.mina.core.p133e;

import java.lang.reflect.Constructor;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.e.m */
/* loaded from: classes2.dex */
public class SimpleIoProcessorPool<S extends AbstractIoSession> implements IoProcessor<S> {

    /* renamed from: a */
    private static final InterfaceC3153b f11434a = C3154c.m262a(SimpleIoProcessorPool.class);

    /* renamed from: b */
    private static final int f11435b = Runtime.getRuntime().availableProcessors() + 1;

    /* renamed from: c */
    private static final AttributeKey f11436c = new AttributeKey(SimpleIoProcessorPool.class, "processor");

    /* renamed from: d */
    private final IoProcessor<S>[] f11437d;

    /* renamed from: e */
    private final Executor f11438e;

    /* renamed from: f */
    private final boolean f11439f;

    /* renamed from: g */
    private final Object f11440g;

    /* renamed from: h */
    private volatile boolean f11441h;

    /* renamed from: i */
    private volatile boolean f11442i;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: a */
    public /* synthetic */ void mo1028a(IoSession ioSession) {
        m1159c((SimpleIoProcessorPool<S>) ((AbstractIoSession) ioSession));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1027a(IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        m1161a((SimpleIoProcessorPool<S>) ((AbstractIoSession) ioSession), interfaceC3088b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo1025b(IoSession ioSession) {
        m1160b((SimpleIoProcessorPool<S>) ((AbstractIoSession) ioSession));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: c */
    public /* synthetic */ void mo1024c(IoSession ioSession) {
        m1162a((SimpleIoProcessorPool<S>) ((AbstractIoSession) ioSession));
    }

    public SimpleIoProcessorPool(Class<? extends IoProcessor<S>> cls) {
        this(cls, null, f11435b, null);
    }

    public SimpleIoProcessorPool(Class<? extends IoProcessor<S>> cls, int i) {
        this(cls, null, i, null);
    }

    public SimpleIoProcessorPool(Class<? extends IoProcessor<S>> cls, Executor executor, int i, SelectorProvider selectorProvider) {
        boolean z;
        this.f11440g = new Object();
        if (cls == null) {
            throw new IllegalArgumentException("processorType");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("size: " + i + " (expected: positive integer)");
        }
        this.f11439f = executor == null;
        if (this.f11439f) {
            this.f11438e = Executors.newCachedThreadPool();
            ((ThreadPoolExecutor) this.f11438e).setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        } else {
            this.f11438e = executor;
        }
        this.f11437d = new IoProcessor[i];
        Constructor<? extends IoProcessor<S>> constructor = null;
        try {
            try {
                try {
                    try {
                        try {
                            constructor = cls.getConstructor(ExecutorService.class);
                            this.f11437d[0] = constructor.newInstance(this.f11438e);
                            z = true;
                        } catch (RuntimeException e) {
                            f11434a.error("Cannot create an IoProcessor :{}", e.getMessage());
                            throw e;
                        } catch (Exception e2) {
                            String str = "Failed to create a new instance of " + cls.getName() + ":" + e2.getMessage();
                            f11434a.error(str, (Throwable) e2);
                            throw new RuntimeIoException(str, e2);
                        }
                    } catch (NoSuchMethodException unused) {
                        constructor = cls.getConstructor(new Class[0]);
                        try {
                            this.f11437d[0] = constructor.newInstance(new Object[0]);
                            z = false;
                        } catch (NoSuchMethodException unused2) {
                            z = false;
                        }
                    }
                } catch (NoSuchMethodException unused3) {
                    if (selectorProvider == null) {
                        constructor = cls.getConstructor(Executor.class);
                        this.f11437d[0] = constructor.newInstance(this.f11438e);
                    } else {
                        constructor = cls.getConstructor(Executor.class, SelectorProvider.class);
                        this.f11437d[0] = constructor.newInstance(this.f11438e, selectorProvider);
                    }
                    z = true;
                }
            } catch (NoSuchMethodException unused4) {
                z = true;
            }
            if (constructor == null) {
                String str2 = String.valueOf(cls) + " must have a public constructor with one " + ExecutorService.class.getSimpleName() + " parameter, a public constructor with one " + Executor.class.getSimpleName() + " parameter or a public default constructor.";
                f11434a.error(str2);
                throw new IllegalArgumentException(str2);
            }
            for (int i2 = 1; i2 < this.f11437d.length; i2++) {
                if (!z) {
                    this.f11437d[i2] = constructor.newInstance(new Object[0]);
                } else if (selectorProvider == null) {
                    try {
                        this.f11437d[i2] = constructor.newInstance(this.f11438e);
                    } catch (Exception unused5) {
                    }
                } else {
                    this.f11437d[i2] = constructor.newInstance(this.f11438e, selectorProvider);
                }
            }
        } catch (Throwable th) {
            mo1026b();
            throw th;
        }
    }

    /* renamed from: a */
    public final void m1162a(S s) {
        m1158d(s).mo1024c(s);
    }

    /* renamed from: b */
    public final void m1160b(S s) {
        m1158d(s).mo1025b(s);
    }

    /* renamed from: a */
    public final void m1161a(S s, InterfaceC3088b interfaceC3088b) {
        m1158d(s).mo1027a(s, interfaceC3088b);
    }

    /* renamed from: c */
    public final void m1159c(S s) {
        m1158d(s).mo1028a(s);
    }

    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: a */
    public boolean mo1029a() {
        return this.f11441h;
    }

    @Override // org.apache.mina.core.p133e.IoProcessor
    /* renamed from: b */
    public final void mo1026b() {
        IoProcessor<S>[] ioProcessorArr;
        if (this.f11442i) {
            return;
        }
        synchronized (this.f11440g) {
            if (!this.f11441h) {
                this.f11441h = true;
                for (IoProcessor<S> ioProcessor : this.f11437d) {
                    if (ioProcessor != null && !ioProcessor.mo1029a()) {
                        try {
                            ioProcessor.mo1026b();
                        } catch (Exception e) {
                            f11434a.warn("Failed to dispose the {} IoProcessor.", ioProcessor.getClass().getSimpleName(), e);
                        }
                    }
                }
                if (this.f11439f) {
                    ((ExecutorService) this.f11438e).shutdown();
                }
            }
            Arrays.fill(this.f11437d, (Object) null);
            this.f11442i = true;
        }
    }

    /* renamed from: d */
    private IoProcessor<S> m1158d(S s) {
        IoProcessor<S> ioProcessor = (IoProcessor) s.mo1009b(f11436c);
        if (ioProcessor == null) {
            if (this.f11442i || this.f11441h) {
                throw new IllegalStateException("A disposed processor cannot be accessed.");
            }
            ioProcessor = this.f11437d[Math.abs((int) s.mo999g()) % this.f11437d.length];
            if (ioProcessor == null) {
                throw new IllegalStateException("A disposed processor cannot be accessed.");
            }
            s.mo1005c(f11436c, ioProcessor);
        }
        return ioProcessor;
    }
}
