package com.tencent.p075mm.opensdk.diffdev.p077a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p075mm.opensdk.diffdev.OAuthListener;
import com.tencent.p075mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
/* loaded from: classes2.dex */
public final class C2507a implements IDiffDevOAuth {

    /* renamed from: Z */
    private AsyncTaskC2510d f7791Z;
    private Handler handler = null;

    /* renamed from: Y */
    private List<OAuthListener> f7790Y = new ArrayList();

    /* renamed from: aa */
    private OAuthListener f7792aa = new C2508b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ AsyncTaskC2510d m5011c(C2507a c2507a) {
        c2507a.f7791Z = null;
        return null;
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth
    public final void addListener(OAuthListener oAuthListener) {
        if (this.f7790Y.contains(oAuthListener)) {
            return;
        }
        this.f7790Y.add(oAuthListener);
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.m4999i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.m5001d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f7791Z != null) {
            Log.m5001d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        this.f7791Z = new AsyncTaskC2510d(str, str2, str3, str4, str5, this.f7792aa);
        AsyncTaskC2510d asyncTaskC2510d = this.f7791Z;
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTaskC2510d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            asyncTaskC2510d.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth
    public final void detach() {
        Log.m4999i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f7790Y.clear();
        stopAuth();
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeAllListeners() {
        this.f7790Y.clear();
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeListener(OAuthListener oAuthListener) {
        this.f7790Y.remove(oAuthListener);
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean stopAuth() {
        boolean z;
        Log.m4999i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            z = this.f7791Z == null ? true : this.f7791Z.m5010q();
        } catch (Exception e) {
            Log.m4997w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z = false;
        }
        this.f7791Z = null;
        return z;
    }
}
