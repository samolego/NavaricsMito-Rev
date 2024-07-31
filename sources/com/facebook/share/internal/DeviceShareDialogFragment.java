package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.DialogFragment;
import android.support.p008v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.common.R;
import com.facebook.internal.Validate;
import com.facebook.p037a.p038a.DeviceRequestsHelper;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public class DeviceShareDialogFragment extends DialogFragment {

    /* renamed from: f */
    private static ScheduledThreadPoolExecutor f2259f;

    /* renamed from: a */
    private ProgressBar f2260a;

    /* renamed from: b */
    private TextView f2261b;

    /* renamed from: c */
    private Dialog f2262c;

    /* renamed from: d */
    private volatile RequestState f2263d;

    /* renamed from: e */
    private volatile ScheduledFuture f2264e;

    /* renamed from: g */
    private ShareContent f2265g;

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            m10197a(requestState);
        }
        return onCreateView;
    }

    @Override // android.support.p008v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.f2262c = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.f2260a = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f2261b = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceShareDialogFragment.this.f2262c.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        this.f2262c.setContentView(inflate);
        m10191c();
        return this.f2262c;
    }

    @Override // android.support.p008v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f2264e != null) {
            this.f2264e.cancel(true);
        }
        m10199a(-1, new Intent());
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f2263d != null) {
            bundle.putParcelable("request_state", this.f2263d);
        }
    }

    /* renamed from: a */
    private void m10199a(int i, Intent intent) {
        if (this.f2263d != null) {
            DeviceRequestsHelper.m11300c(this.f2263d.m10189a());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.m11405e(), 0).show();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    /* renamed from: a */
    private void m10200a() {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    /* renamed from: a */
    public void m10193a(ShareContent shareContent) {
        this.f2265g = shareContent;
    }

    /* renamed from: b */
    private Bundle m10192b() {
        ShareContent shareContent = this.f2265g;
        if (shareContent == null) {
            return null;
        }
        if (shareContent instanceof ShareLinkContent) {
            return WebDialogParameters.m9928a((ShareLinkContent) shareContent);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            return WebDialogParameters.m9927a((ShareOpenGraphContent) shareContent);
        }
        return null;
    }

    /* renamed from: c */
    private void m10191c() {
        Bundle m10192b = m10192b();
        if (m10192b == null || m10192b.size() == 0) {
            m10198a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        m10192b.putString("access_token", Validate.m10466b() + "|" + Validate.m10462c());
        m10192b.putString("device_info", DeviceRequestsHelper.m11304a());
        new GraphRequest(null, "device/share", m10192b, HttpMethod.POST, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.2
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                FacebookRequestError m10831a = graphResponse.m10831a();
                if (m10831a != null) {
                    DeviceShareDialogFragment.this.m10198a(m10831a);
                    return;
                }
                JSONObject m10824b = graphResponse.m10824b();
                RequestState requestState = new RequestState();
                try {
                    requestState.m10187a(m10824b.getString("user_code"));
                    requestState.m10188a(m10824b.getLong("expires_in"));
                    DeviceShareDialogFragment.this.m10197a(requestState);
                } catch (JSONException unused) {
                    DeviceShareDialogFragment.this.m10198a(new FacebookRequestError(0, "", "Malformed server response"));
                }
            }
        }).m11348j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10198a(FacebookRequestError facebookRequestError) {
        m10200a();
        Intent intent = new Intent();
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, facebookRequestError);
        m10199a(-1, intent);
    }

    /* renamed from: d */
    private static synchronized ScheduledThreadPoolExecutor m10190d() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (f2259f == null) {
                f2259f = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f2259f;
        }
        return scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10197a(RequestState requestState) {
        this.f2263d = requestState;
        this.f2261b.setText(requestState.m10189a());
        this.f2261b.setVisibility(0);
        this.f2260a.setVisibility(8);
        this.f2264e = m10190d().schedule(new Runnable() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.3
            @Override // java.lang.Runnable
            public void run() {
                DeviceShareDialogFragment.this.f2262c.dismiss();
            }
        }, requestState.m10186b(), TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() { // from class: com.facebook.share.internal.DeviceShareDialogFragment.RequestState.1
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
        private String f2269a;

        /* renamed from: b */
        private long f2270b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        RequestState() {
        }

        /* renamed from: a */
        public String m10189a() {
            return this.f2269a;
        }

        /* renamed from: a */
        public void m10187a(String str) {
            this.f2269a = str;
        }

        /* renamed from: b */
        public long m10186b() {
            return this.f2270b;
        }

        /* renamed from: a */
        public void m10188a(long j) {
            this.f2270b = j;
        }

        protected RequestState(Parcel parcel) {
            this.f2269a = parcel.readString();
            this.f2270b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2269a);
            parcel.writeLong(this.f2270b);
        }
    }
}
