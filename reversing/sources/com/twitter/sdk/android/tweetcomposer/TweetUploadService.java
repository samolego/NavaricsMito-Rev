package com.twitter.sdk.android.tweetcomposer;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Media;
import com.twitter.sdk.android.core.models.Tweet;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public class TweetUploadService extends IntentService {

    /* renamed from: a */
    C2708a f8849a;

    /* renamed from: b */
    Intent f8850b;

    public TweetUploadService() {
        this(new C2708a());
    }

    TweetUploadService(C2708a c2708a) {
        super("TweetUploadService");
        this.f8849a = c2708a;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        this.f8850b = intent;
        m4205a(new TwitterSession((TwitterAuthToken) intent.getParcelableExtra("EXTRA_USER_TOKEN"), -1L, ""), intent.getStringExtra("EXTRA_TWEET_TEXT"), (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI"));
    }

    /* renamed from: a */
    void m4205a(final TwitterSession twitterSession, final String str, Uri uri) {
        if (uri != null) {
            m4206a(twitterSession, uri, new AbstractC2641c<Media>() { // from class: com.twitter.sdk.android.tweetcomposer.TweetUploadService.1
                @Override // com.twitter.sdk.android.core.AbstractC2641c
                /* renamed from: a */
                public void mo3867a(Result<Media> result) {
                    TweetUploadService.this.m4204a(twitterSession, str, result.f8688a.f8716a);
                }

                @Override // com.twitter.sdk.android.core.AbstractC2641c
                /* renamed from: a */
                public void mo3868a(TwitterException twitterException) {
                    TweetUploadService.this.m4207a(twitterException);
                }
            });
        } else {
            m4204a(twitterSession, str, (String) null);
        }
    }

    /* renamed from: a */
    void m4204a(TwitterSession twitterSession, String str, String str2) {
        this.f8849a.m4203a(twitterSession).m4238c().update(str, null, null, null, null, null, null, true, str2).mo140a(new AbstractC2641c<Tweet>() { // from class: com.twitter.sdk.android.tweetcomposer.TweetUploadService.2
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<Tweet> result) {
                TweetUploadService.this.m4209a(result.f8688a.m4247a());
                TweetUploadService.this.stopSelf();
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                TweetUploadService.this.m4207a(twitterException);
            }
        });
    }

    /* renamed from: a */
    void m4206a(TwitterSession twitterSession, Uri uri, AbstractC2641c<Media> abstractC2641c) {
        TwitterApiClient m4203a = this.f8849a.m4203a(twitterSession);
        String m4185a = FileUtils.m4185a(this, uri);
        if (m4185a == null) {
            m4207a(new TwitterException("Uri file path resolved to null"));
            return;
        }
        File file = new File(m4185a);
        m4203a.m4237d().upload(RequestBody.m3039a(MediaType.m2418b(FileUtils.m4182a(file)), file), null, null).mo140a(abstractC2641c);
    }

    /* renamed from: a */
    void m4207a(TwitterException twitterException) {
        m4208a(this.f8850b);
        Twitter.m4253h().mo4556c("TweetUploadService", "Post Tweet failed", twitterException);
        stopSelf();
    }

    /* renamed from: a */
    void m4209a(long j) {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS");
        intent.putExtra("EXTRA_TWEET_ID", j);
        intent.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent);
    }

    /* renamed from: a */
    void m4208a(Intent intent) {
        Intent intent2 = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_FAILURE");
        intent2.putExtra("EXTRA_RETRY_INTENT", intent);
        intent2.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.tweetcomposer.TweetUploadService$a */
    /* loaded from: classes2.dex */
    public static class C2708a {
        C2708a() {
        }

        /* renamed from: a */
        TwitterApiClient m4203a(TwitterSession twitterSession) {
            return TwitterCore.m4230a().m4229a(twitterSession);
        }
    }
}
