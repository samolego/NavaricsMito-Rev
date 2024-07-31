package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.lifecycle.k */
/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* renamed from: a */
    private InterfaceC0017a f70a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportFragment.java */
    /* renamed from: android.arch.lifecycle.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0017a {
        /* renamed from: a */
        void m12855a();

        /* renamed from: b */
        void m12854b();

        /* renamed from: c */
        void m12853c();
    }

    /* renamed from: a */
    public static void m12860a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m12858a(InterfaceC0017a interfaceC0017a) {
        if (interfaceC0017a != null) {
            interfaceC0017a.m12855a();
        }
    }

    /* renamed from: b */
    private void m12857b(InterfaceC0017a interfaceC0017a) {
        if (interfaceC0017a != null) {
            interfaceC0017a.m12854b();
        }
    }

    /* renamed from: c */
    private void m12856c(InterfaceC0017a interfaceC0017a) {
        if (interfaceC0017a != null) {
            interfaceC0017a.m12853c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m12858a(this.f70a);
        m12859a(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m12857b(this.f70a);
        m12859a(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m12856c(this.f70a);
        m12859a(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m12859a(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m12859a(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m12859a(Lifecycle.Event.ON_DESTROY);
        this.f70a = null;
    }

    /* renamed from: a */
    private void m12859a(Lifecycle.Event event) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).m12868a().m12885a(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).m12885a(event);
            }
        }
    }
}
