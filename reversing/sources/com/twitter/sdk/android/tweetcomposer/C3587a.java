package com.twitter.sdk.android.tweetcomposer;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.twitter.Validator;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

/* renamed from: com.twitter.sdk.android.tweetcomposer.a */
/* loaded from: classes2.dex */
class ComposerController {

    /* renamed from: a */
    final ComposerView f8855a;

    /* renamed from: b */
    final TwitterSession f8856b;

    /* renamed from: c */
    final Uri f8857c;

    /* renamed from: d */
    final ComposerActivity.InterfaceC2696a f8858d;

    /* renamed from: e */
    final C2712c f8859e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComposerController.java */
    /* renamed from: com.twitter.sdk.android.tweetcomposer.a$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2710a {
        /* renamed from: a */
        void mo4193a();

        /* renamed from: a */
        void mo4192a(String str);

        /* renamed from: b */
        void mo4191b(String str);
    }

    /* renamed from: a */
    static int m4201a(int i) {
        return 140 - i;
    }

    /* renamed from: b */
    static boolean m4196b(int i) {
        return i > 0 && i <= 140;
    }

    /* renamed from: c */
    static boolean m4194c(int i) {
        return i > 140;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposerController(ComposerView composerView, TwitterSession twitterSession, Uri uri, String str, String str2, ComposerActivity.InterfaceC2696a interfaceC2696a) {
        this(composerView, twitterSession, uri, str, str2, interfaceC2696a, new C2712c());
    }

    ComposerController(ComposerView composerView, TwitterSession twitterSession, Uri uri, String str, String str2, ComposerActivity.InterfaceC2696a interfaceC2696a, C2712c c2712c) {
        this.f8855a = composerView;
        this.f8856b = twitterSession;
        this.f8857c = uri;
        this.f8858d = interfaceC2696a;
        this.f8859e = c2712c;
        composerView.setCallbacks(new C2711b());
        composerView.setTweetText(m4198a(str, str2));
        m4202a();
        m4200a(uri);
        c2712c.m4188b().mo4187a();
    }

    /* renamed from: a */
    String m4198a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    void m4202a() {
        this.f8859e.m4189a(this.f8856b).m4242a().verifyCredentials(false, true, false).mo140a(new AbstractC2641c<User>() { // from class: com.twitter.sdk.android.tweetcomposer.a.1
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<User> result) {
                ComposerController.this.f8855a.setProfilePhotoView(result.f8688a);
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                ComposerController.this.f8855a.setProfilePhotoView(null);
            }
        });
    }

    /* renamed from: a */
    void m4200a(Uri uri) {
        if (uri != null) {
            this.f8855a.setImageView(uri);
        }
    }

    /* compiled from: ComposerController.java */
    /* renamed from: com.twitter.sdk.android.tweetcomposer.a$b */
    /* loaded from: classes2.dex */
    class C2711b implements InterfaceC2710a {
        C2711b() {
        }

        @Override // com.twitter.sdk.android.tweetcomposer.ComposerController.InterfaceC2710a
        /* renamed from: a */
        public void mo4192a(String str) {
            int m4199a = ComposerController.this.m4199a(str);
            ComposerController.this.f8855a.setCharCount(ComposerController.m4201a(m4199a));
            if (ComposerController.m4194c(m4199a)) {
                ComposerController.this.f8855a.setCharCountTextStyle(R.style.tw__ComposerCharCountOverflow);
            } else {
                ComposerController.this.f8855a.setCharCountTextStyle(R.style.tw__ComposerCharCount);
            }
            ComposerController.this.f8855a.m4210a(ComposerController.m4196b(m4199a));
        }

        @Override // com.twitter.sdk.android.tweetcomposer.ComposerController.InterfaceC2710a
        /* renamed from: b */
        public void mo4191b(String str) {
            ComposerController.this.f8859e.m4188b().mo4186a("tweet");
            Intent intent = new Intent(ComposerController.this.f8855a.getContext(), TweetUploadService.class);
            intent.putExtra("EXTRA_USER_TOKEN", ComposerController.this.f8856b.m4270a());
            intent.putExtra("EXTRA_TWEET_TEXT", str);
            intent.putExtra("EXTRA_IMAGE_URI", ComposerController.this.f8857c);
            ComposerController.this.f8855a.getContext().startService(intent);
            ComposerController.this.f8858d.mo4213a();
        }

        @Override // com.twitter.sdk.android.tweetcomposer.ComposerController.InterfaceC2710a
        /* renamed from: a */
        public void mo4193a() {
            ComposerController.this.m4197b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m4197b() {
        this.f8859e.m4188b().mo4186a("cancel");
        m4195c();
        this.f8858d.mo4213a();
    }

    /* renamed from: a */
    int m4199a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.f8859e.m4190a().m4585a(str);
    }

    /* renamed from: c */
    void m4195c() {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.TWEET_COMPOSE_CANCEL");
        intent.setPackage(this.f8855a.getContext().getPackageName());
        this.f8855a.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComposerController.java */
    /* renamed from: com.twitter.sdk.android.tweetcomposer.a$c */
    /* loaded from: classes2.dex */
    public static class C2712c {

        /* renamed from: a */
        final Validator f8862a = new Validator();

        C2712c() {
        }

        /* renamed from: a */
        TwitterApiClient m4189a(TwitterSession twitterSession) {
            return TwitterCore.m4230a().m4229a(twitterSession);
        }

        /* renamed from: a */
        Validator m4190a() {
            return this.f8862a;
        }

        /* renamed from: b */
        ComposerScribeClient m4188b() {
            return new ComposerScribeClientImpl(TweetComposer.m4177a().m4174d());
        }
    }
}
