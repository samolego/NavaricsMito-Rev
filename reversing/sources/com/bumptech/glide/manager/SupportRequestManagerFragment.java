package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: a */
    private final ActivityFragmentLifecycle f1150a;

    /* renamed from: b */
    private final RequestManagerTreeNode f1151b;

    /* renamed from: c */
    private final Set<SupportRequestManagerFragment> f1152c;
    @Nullable

    /* renamed from: d */
    private SupportRequestManagerFragment f1153d;
    @Nullable

    /* renamed from: e */
    private RequestManager f1154e;
    @Nullable

    /* renamed from: f */
    private Fragment f1155f;

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f1151b = new C0768a();
        this.f1152c = new HashSet();
        this.f1150a = activityFragmentLifecycle;
    }

    /* renamed from: a */
    public void m11808a(@Nullable RequestManager requestManager) {
        this.f1154e = requestManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public ActivityFragmentLifecycle m11811a() {
        return this.f1150a;
    }

    @Nullable
    /* renamed from: b */
    public RequestManager m11806b() {
        return this.f1154e;
    }

    @NonNull
    /* renamed from: c */
    public RequestManagerTreeNode m11804c() {
        return this.f1151b;
    }

    /* renamed from: a */
    private void m11807a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f1152c.add(supportRequestManagerFragment);
    }

    /* renamed from: b */
    private void m11805b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f1152c.remove(supportRequestManagerFragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11810a(@Nullable Fragment fragment) {
        this.f1155f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m11809a(fragment.getActivity());
    }

    @Nullable
    /* renamed from: d */
    private Fragment m11803d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f1155f;
    }

    /* renamed from: a */
    private void m11809a(@NonNull FragmentActivity fragmentActivity) {
        m11802e();
        this.f1153d = Glide.m12523a((Context) fragmentActivity).m12507g().m11772b(fragmentActivity);
        if (equals(this.f1153d)) {
            return;
        }
        this.f1153d.m11807a(this);
    }

    /* renamed from: e */
    private void m11802e() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f1153d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.m11805b(this);
            this.f1153d = null;
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            m11809a(getActivity());
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1155f = null;
        m11802e();
    }

    @Override // android.support.p008v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1150a.m11801a();
    }

    @Override // android.support.p008v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1150a.m11800b();
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f1150a.m11799c();
        m11802e();
    }

    @Override // android.support.p008v4.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m11803d() + "}";
    }

    /* renamed from: com.bumptech.glide.manager.SupportRequestManagerFragment$a */
    /* loaded from: classes.dex */
    private class C0768a implements RequestManagerTreeNode {
        C0768a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }
}
