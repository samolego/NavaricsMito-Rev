package com.bumptech.glide.load.resource.p027b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.util.List;

/* renamed from: com.bumptech.glide.load.resource.b.d */
/* loaded from: classes.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: a */
    private final Context f1011a;

    public ResourceDrawableDecoder(Context context) {
        this.f1011a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull Uri uri, @NonNull Options options) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Resource<Drawable> mo11820a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        int m11995a = m11995a(uri);
        String authority = uri.getAuthority();
        return NonOwnedDrawableResource.m11996a(DrawableDecoderCompat.m12001a(this.f1011a, authority.equals(this.f1011a.getPackageName()) ? this.f1011a : m11992a(uri, authority), m11995a));
    }

    @NonNull
    /* renamed from: a */
    private Context m11992a(Uri uri, String str) {
        try {
            return this.f1011a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    @DrawableRes
    /* renamed from: a */
    private int m11995a(Uri uri) {
        Integer valueOf;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            valueOf = Integer.valueOf(this.f1011a.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    valueOf = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            valueOf = null;
        }
        if (valueOf == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        } else if (valueOf.intValue() == 0) {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        } else {
            return valueOf.intValue();
        }
    }
}
