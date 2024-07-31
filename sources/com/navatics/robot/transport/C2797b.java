package com.navatics.robot.transport;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.b */
/* loaded from: classes.dex */
public class AndroidMainThreadLooper implements Handler.Callback, IEventLooper {

    /* renamed from: a */
    private static final C3044k f6505a = C3044k.m1564a(AndroidMainThreadLooper.class);

    /* renamed from: b */
    private SparseArray<NvEventHandler> f6506b = new SparseArray<>();

    /* renamed from: d */
    private transient int f6508d = 0;

    /* renamed from: c */
    private Handler f6507c = new Handler(Looper.getMainLooper());

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public void mo6288a() throws InterruptedException {
    }

    @Override // com.navatics.robot.transport.IEventLooper
    public void start() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        NvEvent nvEvent = (NvEvent) message.obj;
        f6505a.mo1511a((Object) "NvEventLooper_DEBUG handleMessage 1");
        try {
            try {
                if (nvEvent.m6239c() != null) {
                    nvEvent.m6239c().mo6007a(nvEvent);
                } else {
                    NvEventHandler nvEventHandler = this.f6506b.get(nvEvent.f6562b);
                    if (nvEventHandler != null) {
                        nvEventHandler.mo6007a(nvEvent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } finally {
            this.f6508d--;
            nvEvent.m6245b();
            f6505a.mo1511a((Object) "NvEventLooper_DEBUG handleMessage 222222222222222");
        }
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public boolean mo6287a(@NonNull NvEvent nvEvent) {
        this.f6508d++;
        this.f6507c.obtainMessage(nvEvent.f6562b, nvEvent).sendToTarget();
        return true;
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public void mo6286a(Runnable runnable) {
        this.f6507c.post(runnable);
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: a */
    public void mo6285a(Runnable runnable, long j) {
        this.f6507c.postDelayed(runnable, j);
    }

    @Override // com.navatics.robot.transport.IEventLooper
    /* renamed from: b */
    public void mo6284b(Runnable runnable) {
        this.f6507c.removeCallbacks(runnable);
    }
}
