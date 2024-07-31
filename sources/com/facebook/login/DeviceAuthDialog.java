package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.p037a.p038a.DeviceRequestsHelper;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceAuthDialog extends DialogFragment {

    /* renamed from: a */
    private View f2131a;

    /* renamed from: b */
    private TextView f2132b;

    /* renamed from: c */
    private TextView f2133c;

    /* renamed from: d */
    private DeviceAuthMethodHandler f2134d;

    /* renamed from: f */
    private volatile GraphRequestAsyncTask f2136f;

    /* renamed from: g */
    private volatile ScheduledFuture f2137g;

    /* renamed from: h */
    private volatile RequestState f2138h;

    /* renamed from: i */
    private Dialog f2139i;

    /* renamed from: e */
    private AtomicBoolean f2135e = new AtomicBoolean();

    /* renamed from: j */
    private boolean f2140j = false;

    /* renamed from: k */
    private boolean f2141k = false;

    /* renamed from: l */
    private LoginClient.Request f2142l = null;

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f2134d = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).m11428b()).m10281c().m10316g();
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            m10389a(requestState);
        }
        return onCreateView;
    }

    @Override // android.support.p008v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.f2139i = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        this.f2139i.setContentView(m10378a(DeviceRequestsHelper.m11302b() && !this.f2141k));
        return this.f2139i;
    }

    @Override // android.support.p008v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f2140j) {
            return;
        }
        m10391a();
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f2138h != null) {
            bundle.putParcelable("request_state", this.f2138h);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroy() {
        this.f2140j = true;
        this.f2135e.set(true);
        super.onDestroy();
        if (this.f2136f != null) {
            this.f2136f.cancel(true);
        }
        if (this.f2137g != null) {
            this.f2137g.cancel(true);
        }
    }

    /* renamed from: a */
    public void m10382a(LoginClient.Request request) {
        this.f2142l = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.m10305a()));
        String m10298g = request.m10298g();
        if (m10298g != null) {
            bundle.putString("redirect_uri", m10298g);
        }
        String m10297h = request.m10297h();
        if (m10297h != null) {
            bundle.putString("target_user_id", m10297h);
        }
        bundle.putString("access_token", Validate.m10466b() + "|" + Validate.m10462c());
        bundle.putString("device_info", DeviceRequestsHelper.m11304a());
        new GraphRequest(null, "device/login", bundle, HttpMethod.POST, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.login.DeviceAuthDialog.1
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                if (DeviceAuthDialog.this.f2140j) {
                    return;
                }
                if (graphResponse.m10831a() != null) {
                    DeviceAuthDialog.this.m10390a(graphResponse.m10831a().m11403g());
                    return;
                }
                JSONObject m10824b = graphResponse.m10824b();
                RequestState requestState = new RequestState();
                try {
                    requestState.m10364a(m10824b.getString("user_code"));
                    requestState.m10361b(m10824b.getString("code"));
                    requestState.m10365a(m10824b.getLong("interval"));
                    DeviceAuthDialog.this.m10389a(requestState);
                } catch (JSONException e) {
                    DeviceAuthDialog.this.m10390a(new FacebookException(e));
                }
            }
        }).m11348j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10389a(RequestState requestState) {
        this.f2138h = requestState;
        this.f2132b.setText(requestState.m10363b());
        this.f2133c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), DeviceRequestsHelper.m11301b(requestState.m10366a())), (Drawable) null, (Drawable) null);
        this.f2132b.setVisibility(0);
        this.f2131a.setVisibility(8);
        if (!this.f2141k && DeviceRequestsHelper.m11303a(requestState.m10363b())) {
            new InternalAppEventsLogger(getContext()).m11062a("fb_smart_login_service");
        }
        if (requestState.m10358e()) {
            m10374c();
        } else {
            m10377b();
        }
    }

    /* renamed from: a */
    protected View m10378a(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(m10375b(z), (ViewGroup) null);
        this.f2131a = inflate.findViewById(R.id.progress_bar);
        this.f2132b = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.DeviceAuthDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceAuthDialog.this.m10391a();
            }
        });
        this.f2133c = (TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions);
        this.f2133c.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        return inflate;
    }

    @LayoutRes
    /* renamed from: b */
    protected int m10375b(boolean z) {
        return z ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10377b() {
        this.f2138h.m10362b(new Date().getTime());
        this.f2136f = m10372d().m11348j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10374c() {
        this.f2137g = DeviceAuthMethodHandler.m10351d().schedule(new Runnable() { // from class: com.facebook.login.DeviceAuthDialog.3
            @Override // java.lang.Runnable
            public void run() {
                DeviceAuthDialog.this.m10377b();
            }
        }, this.f2138h.m10359d(), TimeUnit.SECONDS);
    }

    /* renamed from: d */
    private GraphRequest m10372d() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.f2138h.m10360c());
        return new GraphRequest(null, "device/login_status", bundle, HttpMethod.POST, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.login.DeviceAuthDialog.4
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                if (DeviceAuthDialog.this.f2135e.get()) {
                    return;
                }
                FacebookRequestError m10831a = graphResponse.m10831a();
                if (m10831a != null) {
                    int m11407c = m10831a.m11407c();
                    if (m11407c != 1349152) {
                        switch (m11407c) {
                            case 1349172:
                            case 1349174:
                                DeviceAuthDialog.this.m10374c();
                                return;
                            case 1349173:
                                DeviceAuthDialog.this.m10391a();
                                return;
                            default:
                                DeviceAuthDialog.this.m10390a(graphResponse.m10831a().m11403g());
                                return;
                        }
                    }
                    if (DeviceAuthDialog.this.f2138h != null) {
                        DeviceRequestsHelper.m11300c(DeviceAuthDialog.this.f2138h.m10363b());
                    }
                    if (DeviceAuthDialog.this.f2142l != null) {
                        DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                        deviceAuthDialog.m10382a(deviceAuthDialog.f2142l);
                        return;
                    }
                    DeviceAuthDialog.this.m10391a();
                    return;
                }
                try {
                    JSONObject m10824b = graphResponse.m10824b();
                    DeviceAuthDialog.this.m10379a(m10824b.getString("access_token"), Long.valueOf(m10824b.getLong("expires_in")), Long.valueOf(m10824b.optLong("data_access_expiration_time")));
                } catch (JSONException e) {
                    DeviceAuthDialog.this.m10390a(new FacebookException(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10381a(final String str, final Utility.C0986c c0986c, final String str2, String str3, final Date date, final Date date2) {
        String string = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
        String string3 = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
        String format = String.format(string2, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() { // from class: com.facebook.login.DeviceAuthDialog.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.this.m10380a(str, c0986c, str2, date, date2);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.facebook.login.DeviceAuthDialog.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.this.f2139i.setContentView(DeviceAuthDialog.this.m10378a(false));
                DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                deviceAuthDialog.m10382a(deviceAuthDialog.f2142l);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10379a(final String str, Long l, Long l2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        final Date date = null;
        final Date date2 = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        if (l2.longValue() != 0 && l2 != null) {
            date = new Date(l2.longValue() * 1000);
        }
        new GraphRequest(new AccessToken(str, FacebookSdk.m10865l(), "0", null, null, null, null, date2, null, date), "me", bundle, HttpMethod.GET, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.login.DeviceAuthDialog.7
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                if (DeviceAuthDialog.this.f2135e.get()) {
                    return;
                }
                if (graphResponse.m10831a() != null) {
                    DeviceAuthDialog.this.m10390a(graphResponse.m10831a().m11403g());
                    return;
                }
                try {
                    JSONObject m10824b = graphResponse.m10824b();
                    String string = m10824b.getString("id");
                    Utility.C0986c m10503b = Utility.m10503b(m10824b);
                    String string2 = m10824b.getString("name");
                    DeviceRequestsHelper.m11300c(DeviceAuthDialog.this.f2138h.m10363b());
                    if (!FetchedAppSettingsManager.m10808a(FacebookSdk.m10865l()).m10688d().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.f2141k) {
                        DeviceAuthDialog.this.m10380a(string, m10503b, str, date2, date);
                        return;
                    }
                    DeviceAuthDialog.this.f2141k = true;
                    DeviceAuthDialog.this.m10381a(string, m10503b, str, string2, date2, date);
                } catch (JSONException e) {
                    DeviceAuthDialog.this.m10390a(new FacebookException(e));
                }
            }
        }).m11348j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10380a(String str, Utility.C0986c c0986c, String str2, Date date, Date date2) {
        this.f2134d.m10354a(str2, FacebookSdk.m10865l(), str, c0986c.m10475a(), c0986c.m10474b(), c0986c.m10473c(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.f2139i.dismiss();
    }

    /* renamed from: a */
    protected void m10390a(FacebookException facebookException) {
        if (this.f2135e.compareAndSet(false, true)) {
            if (this.f2138h != null) {
                DeviceRequestsHelper.m11300c(this.f2138h.m10363b());
            }
            this.f2134d.m10355a(facebookException);
            this.f2139i.dismiss();
        }
    }

    /* renamed from: a */
    protected void m10391a() {
        if (this.f2135e.compareAndSet(false, true)) {
            if (this.f2138h != null) {
                DeviceRequestsHelper.m11300c(this.f2138h.m10363b());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.f2134d;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.m10352c();
            }
            this.f2139i.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() { // from class: com.facebook.login.DeviceAuthDialog.RequestState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };

        /* renamed from: a */
        private String f2158a;

        /* renamed from: b */
        private String f2159b;

        /* renamed from: c */
        private String f2160c;

        /* renamed from: d */
        private long f2161d;

        /* renamed from: e */
        private long f2162e;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        RequestState() {
        }

        /* renamed from: a */
        public String m10366a() {
            return this.f2158a;
        }

        /* renamed from: b */
        public String m10363b() {
            return this.f2159b;
        }

        /* renamed from: a */
        public void m10364a(String str) {
            this.f2159b = str;
            this.f2158a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", str);
        }

        /* renamed from: c */
        public String m10360c() {
            return this.f2160c;
        }

        /* renamed from: b */
        public void m10361b(String str) {
            this.f2160c = str;
        }

        /* renamed from: d */
        public long m10359d() {
            return this.f2161d;
        }

        /* renamed from: a */
        public void m10365a(long j) {
            this.f2161d = j;
        }

        /* renamed from: b */
        public void m10362b(long j) {
            this.f2162e = j;
        }

        protected RequestState(Parcel parcel) {
            this.f2158a = parcel.readString();
            this.f2159b = parcel.readString();
            this.f2160c = parcel.readString();
            this.f2161d = parcel.readLong();
            this.f2162e = parcel.readLong();
        }

        /* renamed from: e */
        public boolean m10358e() {
            return this.f2162e != 0 && (new Date().getTime() - this.f2162e) - (this.f2161d * 1000) < 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2158a);
            parcel.writeString(this.f2159b);
            parcel.writeString(this.f2160c);
            parcel.writeLong(this.f2161d);
            parcel.writeLong(this.f2162e);
        }
    }
}
