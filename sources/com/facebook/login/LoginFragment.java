package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.R;
import com.facebook.login.LoginClient;

/* loaded from: classes.dex */
public class LoginFragment extends Fragment {

    /* renamed from: a */
    private String f2198a;

    /* renamed from: b */
    private LoginClient f2199b;

    /* renamed from: c */
    private LoginClient.Request f2200c;

    @Override // android.support.p008v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2199b = (LoginClient) bundle.getParcelable("loginClient");
            this.f2199b.m10334a(this);
        } else {
            this.f2199b = m10286a();
        }
        this.f2199b.setOnCompletedListener(new LoginClient.InterfaceC1018b() { // from class: com.facebook.login.LoginFragment.1
            @Override // com.facebook.login.LoginClient.InterfaceC1018b
            /* renamed from: a */
            public void mo10280a(LoginClient.Result result) {
                LoginFragment.this.m10284a(result);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        m10285a(activity);
        Intent intent = activity.getIntent();
        if (intent == null || (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) == null) {
            return;
        }
        this.f2200c = (LoginClient.Request) bundleExtra.getParcelable("request");
    }

    /* renamed from: a */
    protected LoginClient m10286a() {
        return new LoginClient(this);
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroy() {
        this.f2199b.m10317f();
        super.onDestroy();
    }

    @Override // android.support.p008v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(m10282b(), viewGroup, false);
        final View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        this.f2199b.m10331a(new LoginClient.InterfaceC1017a() { // from class: com.facebook.login.LoginFragment.2
            @Override // com.facebook.login.LoginClient.InterfaceC1017a
            /* renamed from: a */
            public void mo10279a() {
                findViewById.setVisibility(0);
            }

            @Override // com.facebook.login.LoginClient.InterfaceC1017a
            /* renamed from: b */
            public void mo10278b() {
                findViewById.setVisibility(8);
            }
        });
        return inflate;
    }

    @LayoutRes
    /* renamed from: b */
    protected int m10282b() {
        return R.layout.com_facebook_login_fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10284a(LoginClient.Result result) {
        this.f2200c = null;
        int i = result.f2190a == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f2198a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        this.f2199b.m10333a(this.f2200c);
    }

    @Override // android.support.p008v4.app.Fragment
    public void onPause() {
        super.onPause();
        View findViewById = getView() == null ? null : getView().findViewById(R.id.com_facebook_login_fragment_progress_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f2199b.m10335a(i, i2, intent);
    }

    @Override // android.support.p008v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.f2199b);
    }

    /* renamed from: a */
    private void m10285a(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return;
        }
        this.f2198a = callingActivity.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public LoginClient m10281c() {
        return this.f2199b;
    }
}
