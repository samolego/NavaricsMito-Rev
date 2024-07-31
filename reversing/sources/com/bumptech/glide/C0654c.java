package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.navatics.app.GlideRequests;

/* renamed from: com.bumptech.glide.c */
/* loaded from: classes.dex */
final class GeneratedRequestManagerFactory implements RequestManagerRetriever.InterfaceC0773a {
    @Override // com.bumptech.glide.manager.RequestManagerRetriever.InterfaceC0773a
    @NonNull
    /* renamed from: a */
    public RequestManager mo11769a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        return new GlideRequests(glide, lifecycle, requestManagerTreeNode, context);
    }
}
