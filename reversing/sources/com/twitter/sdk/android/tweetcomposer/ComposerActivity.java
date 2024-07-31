package com.twitter.sdk.android.tweetcomposer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

/* loaded from: classes2.dex */
public class ComposerActivity extends Activity {

    /* renamed from: a */
    private ComposerController f8831a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.tweetcomposer.ComposerActivity$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2696a {
        /* renamed from: a */
        void mo4213a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("EXTRA_TEXT");
        String stringExtra2 = intent.getStringExtra("EXTRA_HASHTAGS");
        setTheme(intent.getIntExtra("EXTRA_THEME", R.style.ComposerLight));
        setContentView(R.layout.tw__activity_composer);
        this.f8831a = new ComposerController((ComposerView) findViewById(R.id.tw__composer_view), new TwitterSession((TwitterAuthToken) intent.getParcelableExtra("EXTRA_USER_TOKEN"), -1L, ""), (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI"), stringExtra, stringExtra2, new C2697b());
    }

    /* renamed from: com.twitter.sdk.android.tweetcomposer.ComposerActivity$b */
    /* loaded from: classes2.dex */
    class C2697b implements InterfaceC2696a {
        C2697b() {
        }

        @Override // com.twitter.sdk.android.tweetcomposer.ComposerActivity.InterfaceC2696a
        /* renamed from: a */
        public void mo4213a() {
            ComposerActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.f8831a.m4197b();
    }
}
