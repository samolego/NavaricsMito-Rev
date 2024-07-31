package com.navatics.robot.utils;

import java.io.IOException;
import java.util.concurrent.PriorityBlockingQueue;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.utils.c */
/* loaded from: classes2.dex */
public abstract class CargoThread extends Thread {

    /* renamed from: a */
    private static final C3044k f6756a = C3044k.m1564a(CargoThread.class);

    /* renamed from: b */
    private PriorityBlockingQueue<CargoMsg> f6757b = new PriorityBlockingQueue<>(100);

    /* renamed from: c */
    private boolean f6758c;

    /* renamed from: a */
    protected void mo5901a() {
    }

    /* renamed from: a */
    protected abstract void mo5898a(CargoMsg cargoMsg) throws Exception;

    /* renamed from: b */
    protected void mo5896b() {
    }

    /* renamed from: a */
    public void m5900a(int i) throws IOException {
        this.f6757b.put(CargoMsg.m5908a(i));
    }

    /* renamed from: a */
    public void m5899a(int i, Object obj) throws IOException {
        this.f6757b.put(CargoMsg.m5907a(i, obj));
    }

    /* renamed from: a */
    public void m5897a(Object obj) throws IOException {
        this.f6757b.put(CargoMsg.m5905a(obj));
    }

    /* renamed from: c */
    public void m5895c() {
        this.f6758c = true;
        interrupt();
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        mo5896b();
        while (true) {
            if (this.f6758c && this.f6757b.isEmpty()) {
                break;
            }
            try {
                mo5898a(this.f6757b.take());
            } catch (InterruptedException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mo5901a();
    }
}
