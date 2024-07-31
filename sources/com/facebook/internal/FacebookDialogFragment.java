package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p008v4.app.DialogFragment;
import android.support.p008v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog;

/* loaded from: classes.dex */
public class FacebookDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Dialog f1886a;

    /* renamed from: a */
    public void m10818a(Dialog dialog) {
        this.f1886a = dialog;
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onCreate(Bundle bundle) {
        WebDialog m10708a;
        super.onCreate(bundle);
        if (this.f1886a == null) {
            FragmentActivity activity = getActivity();
            Bundle m10579d = NativeProtocol.m10579d(activity.getIntent());
            if (!m10579d.getBoolean("is_fallback", false)) {
                String string = m10579d.getString("action");
                Bundle bundle2 = m10579d.getBundle("params");
                if (Utility.m10530a(string)) {
                    Utility.m10505b("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                m10708a = new WebDialog.C0991a(activity, string, bundle2).m10433a(new WebDialog.InterfaceC0993c() { // from class: com.facebook.internal.FacebookDialogFragment.1
                    @Override // com.facebook.internal.WebDialog.InterfaceC0993c
                    /* renamed from: a */
                    public void mo10250a(Bundle bundle3, FacebookException facebookException) {
                        FacebookDialogFragment.this.m10816a(bundle3, facebookException);
                    }
                }).mo10247a();
            } else {
                String string2 = m10579d.getString("url");
                if (Utility.m10530a(string2)) {
                    Utility.m10505b("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                m10708a = FacebookWebFallbackDialog.m10708a(activity, string2, String.format("fb%s://bridge/", FacebookSdk.m10865l()));
                m10708a.setOnCompleteListener(new WebDialog.InterfaceC0993c() { // from class: com.facebook.internal.FacebookDialogFragment.2
                    @Override // com.facebook.internal.WebDialog.InterfaceC0993c
                    /* renamed from: a */
                    public void mo10250a(Bundle bundle3, FacebookException facebookException) {
                        FacebookDialogFragment.this.m10817a(bundle3);
                    }
                });
            }
            this.f1886a = m10708a;
        }
    }

    @Override // android.support.p008v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1886a == null) {
            m10816a((Bundle) null, (FacebookException) null);
            setShowsDialog(false);
        }
        return this.f1886a;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.f1886a;
        if (dialog instanceof WebDialog) {
            ((WebDialog) dialog).m10438e();
        }
    }

    @Override // android.support.p008v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.f1886a instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.f1886a).m10438e();
        }
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10816a(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.m10598a(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10817a(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
