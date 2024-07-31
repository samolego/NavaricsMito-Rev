package com.facebook.internal;

import android.app.Activity;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.internal.g */
/* loaded from: classes.dex */
public abstract class FacebookDialogBase<CONTENT, RESULT> {

    /* renamed from: a */
    protected static final Object f1940a = new Object();

    /* renamed from: b */
    private final Activity f1941b;

    /* renamed from: c */
    private final FragmentWrapper f1942c;

    /* renamed from: d */
    private List<FacebookDialogBase<CONTENT, RESULT>.AbstractC0951a> f1943d;

    /* renamed from: e */
    private int f1944e;

    /* renamed from: a */
    protected abstract void mo9685a(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    /* renamed from: c */
    protected abstract List<FacebookDialogBase<CONTENT, RESULT>.AbstractC0951a> mo9680c();

    /* renamed from: d */
    protected abstract AppCall mo9678d();

    /* JADX INFO: Access modifiers changed from: protected */
    public FacebookDialogBase(Activity activity, int i) {
        Validate.m10469a(activity, "activity");
        this.f1941b = activity;
        this.f1942c = null;
        this.f1944e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FacebookDialogBase(FragmentWrapper fragmentWrapper, int i) {
        Validate.m10469a(fragmentWrapper, "fragmentWrapper");
        this.f1942c = fragmentWrapper;
        this.f1941b = null;
        this.f1944e = i;
        if (fragmentWrapper.m10645c() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    /* renamed from: a */
    public final void m10721a(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        mo9685a((CallbackManagerImpl) callbackManager, (FacebookCallback) facebookCallback);
    }

    /* renamed from: a */
    public int m10723a() {
        return this.f1944e;
    }

    /* renamed from: a */
    public boolean m10720a(CONTENT content) {
        return mo10203a((FacebookDialogBase<CONTENT, RESULT>) content, f1940a);
    }

    /* renamed from: a */
    protected boolean mo10203a(CONTENT content, Object obj) {
        boolean z = obj == f1940a;
        for (FacebookDialogBase<CONTENT, RESULT>.AbstractC0951a abstractC0951a : m10717e()) {
            if (z || Utility.m10533a(abstractC0951a.mo9691a(), obj)) {
                if (abstractC0951a.mo9673a(content, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo10070b(CONTENT content) {
        mo10201b(content, f1940a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10201b(CONTENT content, Object obj) {
        AppCall m10718c = m10718c(content, obj);
        if (m10718c != null) {
            FragmentWrapper fragmentWrapper = this.f1942c;
            if (fragmentWrapper != null) {
                DialogPresenter.m10730a(m10718c, fragmentWrapper);
                return;
            } else {
                DialogPresenter.m10734a(m10718c, this.f1941b);
                return;
            }
        }
        Log.e("FacebookDialog", "No code path should ever result in a null appCall");
        if (FacebookSdk.m10874d()) {
            throw new IllegalStateException("No code path should ever result in a null appCall");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Activity m10719b() {
        Activity activity = this.f1941b;
        if (activity != null) {
            return activity;
        }
        FragmentWrapper fragmentWrapper = this.f1942c;
        if (fragmentWrapper != null) {
            return fragmentWrapper.m10645c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10722a(android.content.Intent r3, int r4) {
        /*
            r2 = this;
            android.app.Activity r0 = r2.f1941b
            if (r0 == 0) goto L8
            r0.startActivityForResult(r3, r4)
            goto L2d
        L8:
            com.facebook.internal.n r0 = r2.f1942c
            if (r0 == 0) goto L32
            android.app.Fragment r0 = r0.m10648a()
            if (r0 == 0) goto L1c
            com.facebook.internal.n r0 = r2.f1942c
            android.app.Fragment r0 = r0.m10648a()
            r0.startActivityForResult(r3, r4)
            goto L2d
        L1c:
            com.facebook.internal.n r0 = r2.f1942c
            android.support.v4.app.Fragment r0 = r0.m10646b()
            if (r0 == 0) goto L2f
            com.facebook.internal.n r0 = r2.f1942c
            android.support.v4.app.Fragment r0 = r0.m10646b()
            r0.startActivityForResult(r3, r4)
        L2d:
            r3 = 0
            goto L34
        L2f:
            java.lang.String r3 = "Failed to find Activity or Fragment to startActivityForResult "
            goto L34
        L32:
            java.lang.String r3 = "Failed to find Activity or Fragment to startActivityForResult "
        L34:
            if (r3 == 0) goto L44
            com.facebook.LoggingBehavior r4 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r0 = 6
            java.lang.Class r1 = r2.getClass()
            java.lang.String r1 = r1.getName()
            com.facebook.internal.Logger.m10636a(r4, r0, r1, r3)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.m10722a(android.content.Intent, int):void");
    }

    /* renamed from: c */
    private AppCall m10718c(CONTENT content, Object obj) {
        boolean z = obj == f1940a;
        AppCall appCall = null;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.AbstractC0951a> it = m10717e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FacebookDialogBase<CONTENT, RESULT>.AbstractC0951a next = it.next();
            if (z || Utility.m10533a(next.mo9691a(), obj)) {
                if (next.mo9673a(content, true)) {
                    try {
                        appCall = next.mo9674a(content);
                        break;
                    } catch (FacebookException e) {
                        appCall = mo9678d();
                        DialogPresenter.m10732a(appCall, e);
                    }
                }
            }
        }
        if (appCall == null) {
            AppCall mo9678d = mo9678d();
            DialogPresenter.m10735a(mo9678d);
            return mo9678d;
        }
        return appCall;
    }

    /* renamed from: e */
    private List<FacebookDialogBase<CONTENT, RESULT>.AbstractC0951a> m10717e() {
        if (this.f1943d == null) {
            this.f1943d = mo9680c();
        }
        return this.f1943d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: FacebookDialogBase.java */
    /* renamed from: com.facebook.internal.g$a */
    /* loaded from: classes.dex */
    public abstract class AbstractC0951a {
        /* renamed from: a */
        public abstract AppCall mo9674a(CONTENT content);

        /* renamed from: a */
        public abstract boolean mo9673a(CONTENT content, boolean z);

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC0951a() {
        }

        /* renamed from: a */
        public Object mo9691a() {
            return FacebookDialogBase.f1940a;
        }
    }
}
