package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.NativeProtocol;

/* renamed from: com.facebook.internal.f */
/* loaded from: classes.dex */
public class DialogPresenter {

    /* compiled from: DialogPresenter.java */
    /* renamed from: com.facebook.internal.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0950a {
        /* renamed from: a */
        Bundle mo9672a();

        /* renamed from: b */
        Bundle mo9671b();
    }

    /* renamed from: a */
    public static void m10735a(AppCall appCall) {
        m10732a(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    /* renamed from: a */
    public static void m10732a(AppCall appCall, FacebookException facebookException) {
        m10726b(appCall, facebookException);
    }

    /* renamed from: a */
    public static void m10734a(AppCall appCall, Activity activity) {
        activity.startActivityForResult(appCall.m10789b(), appCall.m10787d());
        appCall.m10786e();
    }

    /* renamed from: a */
    public static void m10730a(AppCall appCall, FragmentWrapper fragmentWrapper) {
        fragmentWrapper.m10647a(appCall.m10789b(), appCall.m10787d());
        appCall.m10786e();
    }

    /* renamed from: a */
    public static boolean m10728a(DialogFeature dialogFeature) {
        return m10725b(dialogFeature).m10568b() != -1;
    }

    /* renamed from: b */
    public static void m10726b(AppCall appCall, FacebookException facebookException) {
        if (facebookException == null) {
            return;
        }
        Validate.m10465b(FacebookSdk.m10869h());
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.m10869h(), FacebookActivity.class);
        intent.setAction(FacebookActivity.f1442a);
        NativeProtocol.m10597a(intent, appCall.m10788c().toString(), (String) null, NativeProtocol.m10605a(), NativeProtocol.m10595a(facebookException));
        appCall.m10791a(intent);
    }

    /* renamed from: a */
    public static void m10729a(AppCall appCall, String str, Bundle bundle) {
        Validate.m10465b(FacebookSdk.m10869h());
        Validate.m10471a(FacebookSdk.m10869h());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        NativeProtocol.m10597a(intent, appCall.m10788c().toString(), str, NativeProtocol.m10605a(), bundle2);
        intent.setClass(FacebookSdk.m10869h(), FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        appCall.m10791a(intent);
    }

    /* renamed from: a */
    public static void m10733a(AppCall appCall, Bundle bundle, DialogFeature dialogFeature) {
        Uri m10526a;
        Validate.m10465b(FacebookSdk.m10869h());
        Validate.m10471a(FacebookSdk.m10869h());
        String name = dialogFeature.name();
        Uri m10724c = m10724c(dialogFeature);
        if (m10724c == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + "'");
        }
        Bundle m10555a = ServerProtocol.m10555a(appCall.m10788c().toString(), NativeProtocol.m10605a(), bundle);
        if (m10555a == null) {
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        if (m10724c.isRelative()) {
            m10526a = Utility.m10526a(ServerProtocol.m10556a(), m10724c.toString(), m10555a);
        } else {
            m10526a = Utility.m10526a(m10724c.getAuthority(), m10724c.getPath(), m10555a);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", m10526a.toString());
        bundle2.putBoolean("is_fallback", true);
        Intent intent = new Intent();
        NativeProtocol.m10597a(intent, appCall.m10788c().toString(), dialogFeature.getAction(), NativeProtocol.m10605a(), bundle2);
        intent.setClass(FacebookSdk.m10869h(), FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        appCall.m10791a(intent);
    }

    /* renamed from: a */
    public static void m10731a(AppCall appCall, InterfaceC0950a interfaceC0950a, DialogFeature dialogFeature) {
        Bundle mo9671b;
        Context m10869h = FacebookSdk.m10869h();
        String action = dialogFeature.getAction();
        NativeProtocol.C0978f m10725b = m10725b(dialogFeature);
        int m10568b = m10725b.m10568b();
        if (m10568b == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        if (NativeProtocol.m10604a(m10568b)) {
            mo9671b = interfaceC0950a.mo9672a();
        } else {
            mo9671b = interfaceC0950a.mo9671b();
        }
        if (mo9671b == null) {
            mo9671b = new Bundle();
        }
        Intent m10601a = NativeProtocol.m10601a(m10869h, appCall.m10788c().toString(), action, m10725b, mo9671b);
        if (m10601a == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        appCall.m10791a(m10601a);
    }

    /* renamed from: c */
    private static Uri m10724c(DialogFeature dialogFeature) {
        String name = dialogFeature.name();
        FetchedAppSettings.C0957a m10691a = FetchedAppSettings.m10691a(FacebookSdk.m10865l(), dialogFeature.getAction(), name);
        if (m10691a != null) {
            return m10691a.m10674c();
        }
        return null;
    }

    /* renamed from: b */
    public static NativeProtocol.C0978f m10725b(DialogFeature dialogFeature) {
        String m10865l = FacebookSdk.m10865l();
        String action = dialogFeature.getAction();
        return NativeProtocol.m10592a(action, m10727a(m10865l, action, dialogFeature));
    }

    /* renamed from: a */
    private static int[] m10727a(String str, String str2, DialogFeature dialogFeature) {
        FetchedAppSettings.C0957a m10691a = FetchedAppSettings.m10691a(str, str2, dialogFeature.name());
        return m10691a != null ? m10691a.m10673d() : new int[]{dialogFeature.getMinVersion()};
    }
}
