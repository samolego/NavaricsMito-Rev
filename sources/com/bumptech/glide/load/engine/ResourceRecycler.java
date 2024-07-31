package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.C0791i;

/* renamed from: com.bumptech.glide.load.engine.v */
/* loaded from: classes.dex */
class ResourceRecycler {

    /* renamed from: a */
    private boolean f995a;

    /* renamed from: b */
    private final Handler f996b = new Handler(Looper.getMainLooper(), new C0736a());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m12024a(Resource<?> resource) {
        C0791i.m11575a();
        if (this.f995a) {
            this.f996b.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.f995a = true;
        resource.mo11851f();
        this.f995a = false;
    }

    /* compiled from: ResourceRecycler.java */
    /* renamed from: com.bumptech.glide.load.engine.v$a */
    /* loaded from: classes.dex */
    private static final class C0736a implements Handler.Callback {
        C0736a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).mo11851f();
                return true;
            }
            return false;
        }
    }
}
