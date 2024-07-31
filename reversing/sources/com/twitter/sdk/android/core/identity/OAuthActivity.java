package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p008v4.app.NotificationCompat;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.identity.OAuthController;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;

/* loaded from: classes2.dex */
public class OAuthActivity extends Activity implements OAuthController.InterfaceC2650a {

    /* renamed from: a */
    OAuthController f8453a;

    /* renamed from: b */
    private ProgressBar f8454b;

    /* renamed from: c */
    private WebView f8455c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__activity_oauth);
        this.f8454b = (ProgressBar) findViewById(R.id.tw__spinner);
        this.f8455c = (WebView) findViewById(R.id.tw__web_view);
        this.f8454b.setVisibility(bundle != null ? bundle.getBoolean(NotificationCompat.CATEGORY_PROGRESS, false) : true ? 0 : 8);
        this.f8453a = new OAuthController(this.f8454b, this.f8455c, (TwitterAuthConfig) getIntent().getParcelableExtra("auth_config"), new OAuth1aService(TwitterCore.m4230a(), new TwitterApi()), this);
        this.f8453a.m4541a();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f8454b.getVisibility() == 0) {
            bundle.putBoolean(NotificationCompat.CATEGORY_PROGRESS, true);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f8453a.m4540a(0, new TwitterAuthException("Authorization failed, request was canceled."));
    }

    @Override // com.twitter.sdk.android.core.identity.OAuthController.InterfaceC2650a
    /* renamed from: a */
    public void mo4529a(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }
}
