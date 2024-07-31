package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p008v4.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.DeviceAuthMethodHandler.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeviceAuthMethodHandler[] newArray(int i) {
            return new DeviceAuthMethodHandler[i];
        }
    };

    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f2163c;

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    String mo10256a() {
        return "device_auth";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.LoginMethodHandler
    /* renamed from: a */
    boolean mo10255a(LoginClient.Request request) {
        m10353b(request);
        return true;
    }

    /* renamed from: b */
    private void m10353b(LoginClient.Request request) {
        FragmentActivity m10326b = this.f2205b.m10326b();
        if (m10326b == null || m10326b.isFinishing()) {
            return;
        }
        DeviceAuthDialog m10350d_ = m10350d_();
        m10350d_.show(m10326b.getSupportFragmentManager(), "login_with_facebook");
        m10350d_.m10382a(request);
    }

    /* renamed from: d_ */
    protected DeviceAuthDialog m10350d_() {
        return new DeviceAuthDialog();
    }

    /* renamed from: c */
    public void m10352c() {
        this.f2205b.m10332a(LoginClient.Result.m10291a(this.f2205b.m10323c(), "User canceled log in."));
    }

    /* renamed from: a */
    public void m10355a(Exception exc) {
        this.f2205b.m10332a(LoginClient.Result.m10290a(this.f2205b.m10323c(), null, exc.getMessage()));
    }

    /* renamed from: a */
    public void m10354a(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        this.f2205b.m10332a(LoginClient.Result.m10292a(this.f2205b.m10323c(), new AccessToken(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3)));
    }

    /* renamed from: d */
    public static synchronized ScheduledThreadPoolExecutor m10351d() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (f2163c == null) {
                f2163c = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f2163c;
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
