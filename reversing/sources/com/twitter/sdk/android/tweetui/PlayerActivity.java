package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class PlayerActivity extends Activity {

    /* renamed from: a */
    static final VideoScribeClient f8898a = new VideoScribeClientImpl(TweetUi.m4100a());

    /* renamed from: b */
    PlayerController f8899b;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__player_activity);
        this.f8899b = new PlayerController(findViewById(16908290), new SwipeToDismissTouchListener.InterfaceC2759a() { // from class: com.twitter.sdk.android.tweetui.PlayerActivity.1
            @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.InterfaceC2759a
            /* renamed from: a */
            public void mo3931a(float f) {
            }

            @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.InterfaceC2759a
            /* renamed from: a */
            public void mo3932a() {
                PlayerActivity.this.finish();
                PlayerActivity.this.overridePendingTransition(0, R.anim.tw__slide_out);
            }
        });
        this.f8899b.m3913a((PlayerItem) getIntent().getSerializableExtra("PLAYER_ITEM"));
        m4150a((ScribeItem) getIntent().getSerializableExtra("SCRIBE_ITEM"));
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f8899b.m3914a();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f8899b.m3910b();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f8899b.m3908c();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    /* renamed from: a */
    private void m4150a(ScribeItem scribeItem) {
        f8898a.mo4077b(scribeItem);
    }

    /* loaded from: classes2.dex */
    public static class PlayerItem implements Serializable {
        public final String callToActionText;
        public final String callToActionUrl;
        public final boolean looping;
        public final boolean showVideoControls;
        public final String url;

        public PlayerItem(String str, boolean z, boolean z2, String str2, String str3) {
            this.url = str;
            this.looping = z;
            this.showVideoControls = z2;
            this.callToActionText = str2;
            this.callToActionUrl = str3;
        }
    }
}
