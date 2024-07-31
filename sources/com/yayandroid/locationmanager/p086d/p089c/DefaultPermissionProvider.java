package com.yayandroid.locationmanager.p086d.p089c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p085c.DialogListener;
import com.yayandroid.locationmanager.p086d.p087a.DialogProvider;

/* renamed from: com.yayandroid.locationmanager.d.c.a */
/* loaded from: classes2.dex */
public class DefaultPermissionProvider extends PermissionProvider implements DialogListener {

    /* renamed from: a */
    private PermissionCompatSource f9396a;

    public DefaultPermissionProvider(String[] strArr, @Nullable DialogProvider dialogProvider) {
        super(strArr, dialogProvider);
    }

    @Override // com.yayandroid.locationmanager.p086d.p089c.PermissionProvider
    /* renamed from: c */
    public boolean mo3500c() {
        if (m3504k() == null) {
            LogUtils.m3638b("Cannot ask for permissions, because DefaultPermissionProvider doesn't contain an Activity instance.");
            return false;
        } else if (m3519d()) {
            m3507h().m3606a(this);
            m3507h().mo3605a(m3504k()).show();
            return true;
        } else {
            m3518e();
            return true;
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p089c.PermissionProvider
    /* renamed from: a */
    public void mo3501a(int i, String[] strArr, @NonNull int[] iArr) {
        if (i == 23) {
            int length = strArr.length;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] != 0) {
                    z = true;
                }
            }
            if (z) {
                LogUtils.m3638b("User denied some of required permissions, task will be aborted!");
                if (m3506i() != null) {
                    m3506i().mo3608h();
                    return;
                }
                return;
            }
            LogUtils.m3638b("We got all required permission!");
            if (m3506i() != null) {
                m3506i().mo3609g();
            }
        }
    }

    @Override // com.yayandroid.locationmanager.p085c.DialogListener
    /* renamed from: a */
    public void mo3521a() {
        m3518e();
    }

    @Override // com.yayandroid.locationmanager.p085c.DialogListener
    /* renamed from: f_ */
    public void mo3516f_() {
        LogUtils.m3638b("User didn't even let us to ask for permission!");
        if (m3506i() != null) {
            m3506i().mo3608h();
        }
    }

    /* renamed from: d */
    boolean m3519d() {
        boolean z = false;
        for (String str : m3508g()) {
            z = z || m3520a(str);
        }
        LogUtils.m3638b("Should show rationale dialog for required permissions: " + z);
        return (!z || m3504k() == null || m3507h() == null) ? false : true;
    }

    /* renamed from: a */
    boolean m3520a(String str) {
        if (m3503l() != null) {
            return m3517f().m3513a(m3503l(), str);
        }
        if (m3504k() != null) {
            return m3517f().m3515a(m3504k(), str);
        }
        return false;
    }

    /* renamed from: e */
    void m3518e() {
        LogUtils.m3638b("Asking for Runtime Permissions...");
        if (m3503l() != null) {
            m3517f().m3512a(m3503l(), m3508g(), 23);
        } else if (m3504k() != null) {
            m3517f().m3514a(m3504k(), m3508g(), 23);
        } else {
            LogUtils.m3640a("Something went wrong requesting for permissions.");
            if (m3506i() != null) {
                m3506i().mo3608h();
            }
        }
    }

    /* renamed from: f */
    protected PermissionCompatSource m3517f() {
        if (this.f9396a == null) {
            this.f9396a = new PermissionCompatSource();
        }
        return this.f9396a;
    }
}
