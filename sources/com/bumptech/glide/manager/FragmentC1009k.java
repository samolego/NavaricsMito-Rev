package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* renamed from: com.bumptech.glide.manager.k */
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a */
    private final ActivityFragmentLifecycle f1166a;

    /* renamed from: b */
    private final RequestManagerTreeNode f1167b;

    /* renamed from: c */
    private final Set<RequestManagerFragment> f1168c;
    @Nullable

    /* renamed from: d */
    private RequestManager f1169d;
    @Nullable

    /* renamed from: e */
    private RequestManagerFragment f1170e;
    @Nullable

    /* renamed from: f */
    private Fragment f1171f;

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f1167b = new C0771a();
        this.f1168c = new HashSet();
        this.f1166a = activityFragmentLifecycle;
    }

    /* renamed from: a */
    public void m11788a(@Nullable RequestManager requestManager) {
        this.f1169d = requestManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public ActivityFragmentLifecycle m11791a() {
        return this.f1166a;
    }

    @Nullable
    /* renamed from: b */
    public RequestManager m11786b() {
        return this.f1169d;
    }

    @NonNull
    /* renamed from: c */
    public RequestManagerTreeNode m11784c() {
        return this.f1167b;
    }

    /* renamed from: a */
    private void m11787a(RequestManagerFragment requestManagerFragment) {
        this.f1168c.add(requestManagerFragment);
    }

    /* renamed from: b */
    private void m11785b(RequestManagerFragment requestManagerFragment) {
        this.f1168c.remove(requestManagerFragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11789a(@Nullable Fragment fragment) {
        this.f1171f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m11790a(fragment.getActivity());
    }

    @TargetApi(17)
    @Nullable
    /* renamed from: d */
    private Fragment m11783d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f1171f;
    }

    /* renamed from: a */
    private void m11790a(@NonNull Activity activity) {
        m11782e();
        this.f1170e = Glide.m12523a(activity).m12507g().m11774b(activity);
        if (equals(this.f1170e)) {
            return;
        }
        this.f1170e.m11787a(this);
    }

    /* renamed from: e */
    private void m11782e() {
        RequestManagerFragment requestManagerFragment = this.f1170e;
        if (requestManagerFragment != null) {
            requestManagerFragment.m11785b(this);
            this.f1170e = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m11790a(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        m11782e();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1166a.m11801a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1166a.m11800b();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f1166a.m11799c();
        m11782e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m11783d() + "}";
    }

    /* compiled from: RequestManagerFragment.java */
    /* renamed from: com.bumptech.glide.manager.k$a */
    /* loaded from: classes.dex */
    private class C0771a implements RequestManagerTreeNode {
        C0771a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }
}
