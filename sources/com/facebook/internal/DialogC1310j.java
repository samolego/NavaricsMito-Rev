package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.j */
/* loaded from: classes.dex */
public class FacebookWebFallbackDialog extends WebDialog {

    /* renamed from: a */
    private static final String f1955a = "com.facebook.internal.j";

    /* renamed from: b */
    private boolean f1956b;

    /* renamed from: a */
    public static FacebookWebFallbackDialog m10708a(Context context, String str, String str2) {
        WebDialog.m10455a(context);
        return new FacebookWebFallbackDialog(context, str, str2);
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        m10443b(str2);
    }

    @Override // com.facebook.internal.WebDialog
    /* renamed from: a */
    protected Bundle mo10448a(String str) {
        Bundle m10490d = Utility.m10490d(Uri.parse(str).getQuery());
        String string = m10490d.getString("bridge_args");
        m10490d.remove("bridge_args");
        if (!Utility.m10530a(string)) {
            try {
                m10490d.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.m10739a(new JSONObject(string)));
            } catch (JSONException e) {
                Utility.m10525a(f1955a, "Unable to parse bridge_args JSON", e);
            }
        }
        String string2 = m10490d.getString("method_results");
        m10490d.remove("method_results");
        if (!Utility.m10530a(string2)) {
            if (Utility.m10530a(string2)) {
                string2 = "{}";
            }
            try {
                m10490d.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.m10739a(new JSONObject(string2)));
            } catch (JSONException e2) {
                Utility.m10525a(f1955a, "Unable to parse bridge_args JSON", e2);
            }
        }
        m10490d.remove("version");
        m10490d.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.m10605a());
        return m10490d;
    }

    @Override // com.facebook.internal.WebDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        WebView d = m10440d();
        if (!m10442c() || m10446b() || d == null || !d.isShown()) {
            super.cancel();
        } else if (this.f1956b) {
        } else {
            this.f1956b = true;
            d.loadUrl("javascript:(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.internal.j.1
                @Override // java.lang.Runnable
                public void run() {
                    FacebookWebFallbackDialog.super.cancel();
                }
            }, 1500L);
        }
    }
}
