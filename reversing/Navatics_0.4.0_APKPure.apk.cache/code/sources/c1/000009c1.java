package butterknife.internal;

import android.view.View;

/* compiled from: DebouncingOnClickListener.java */
/* renamed from: butterknife.internal.a */
/* loaded from: classes.dex */
public abstract class AbstractViewOnClickListenerC0505a implements View.OnClickListener {

    /* renamed from: a */
    static boolean f139a = true;

    /* renamed from: b */
    private static final Runnable f140b = new Runnable() { // from class: butterknife.internal.a.1
        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnClickListenerC0505a.f139a = true;
        }
    };

    /* renamed from: a */
    public abstract void mo156a(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f139a) {
            f139a = false;
            view.post(f140b);
            mo156a(view);
        }
    }
}