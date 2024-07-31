package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    public abstract boolean mo10255a(LoginClient.Request request);

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    public boolean mo10269a(int i, int i2, Intent intent) {
        LoginClient.Result m10266a;
        LoginClient.Request m10323c = this.f2205b.m10323c();
        if (intent == null) {
            m10266a = LoginClient.Result.m10291a(m10323c, "Operation canceled");
        } else if (i2 == 0) {
            m10266a = m10264b(m10323c, intent);
        } else if (i2 != -1) {
            m10266a = LoginClient.Result.m10290a(m10323c, "Unexpected resultCode from authorization.", null);
        } else {
            m10266a = m10266a(m10323c, intent);
        }
        if (m10266a != null) {
            this.f2205b.m10332a(m10266a);
            return true;
        }
        this.f2205b.m10314i();
        return true;
    }

    /* renamed from: a */
    private LoginClient.Result m10266a(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String m10267a = m10267a(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        String m10265b = m10265b(extras);
        String string = extras.getString("e2e");
        if (!Utility.m10530a(string)) {
            m10271b(string);
        }
        if (m10267a == null && obj == null && m10265b == null) {
            try {
                return LoginClient.Result.m10292a(request, m10273a(request.m10305a(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.m10301d()));
            } catch (FacebookException e) {
                return LoginClient.Result.m10290a(request, null, e.getMessage());
            }
        } else if (ServerProtocol.f2054a.contains(m10267a)) {
            return null;
        } else {
            if (ServerProtocol.f2055b.contains(m10267a)) {
                return LoginClient.Result.m10291a(request, (String) null);
            }
            return LoginClient.Result.m10289a(request, m10267a, m10265b, obj);
        }
    }

    /* renamed from: b */
    private LoginClient.Result m10264b(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String m10267a = m10267a(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        if ("CONNECTION_FAILURE".equals(obj)) {
            return LoginClient.Result.m10289a(request, m10267a, m10265b(extras), obj);
        }
        return LoginClient.Result.m10291a(request, m10267a);
    }

    /* renamed from: a */
    private String m10267a(Bundle bundle) {
        String string = bundle.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
        return string == null ? bundle.getString("error_type") : string;
    }

    /* renamed from: b */
    private String m10265b(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString("error_description") : string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m10268a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.f2205b.m10336a().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
