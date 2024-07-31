package com.bumptech.glide.load.p018a;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.m */
/* loaded from: classes.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p018a.AssetPathFetcher
    /* renamed from: b */
    public InputStream mo12393a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p018a.AssetPathFetcher
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo12391a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo7366a() {
        return InputStream.class;
    }
}
