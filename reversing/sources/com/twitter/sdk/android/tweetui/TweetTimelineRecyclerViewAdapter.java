package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.support.p011v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;

/* loaded from: classes2.dex */
public class TweetTimelineRecyclerViewAdapter extends RecyclerView.Adapter<TweetViewHolder> {

    /* renamed from: a */
    protected final Context f8910a;

    /* renamed from: b */
    protected final TimelineDelegate<Tweet> f8911b;

    /* renamed from: c */
    protected AbstractC2641c<Tweet> f8912c;

    /* renamed from: d */
    protected final int f8913d;

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public TweetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CompactTweetView compactTweetView = new CompactTweetView(this.f8910a, new TweetBuilder().m4246a(), this.f8913d);
        compactTweetView.setOnActionCallback(this.f8912c);
        return new TweetViewHolder(compactTweetView);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(TweetViewHolder tweetViewHolder, int i) {
        ((CompactTweetView) tweetViewHolder.itemView).setTweet(this.f8911b.m3896a(i));
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f8911b.m3894b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class TweetViewHolder extends RecyclerView.ViewHolder {
        public TweetViewHolder(CompactTweetView compactTweetView) {
            super(compactTweetView);
        }
    }
}
