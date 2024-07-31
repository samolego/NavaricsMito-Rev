package com.navatics.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

/* renamed from: com.navatics.app.utils.f */
/* loaded from: classes.dex */
public class ImageLoader {

    /* renamed from: a */
    private static volatile ImageLoader f5127a;

    /* renamed from: a */
    public static ImageLoader m7398a() {
        if (f5127a == null) {
            synchronized (ImageLoader.class) {
                if (f5127a == null) {
                    f5127a = new ImageLoader();
                }
            }
        }
        return f5127a;
    }

    /* renamed from: a */
    public void m7394a(Context context, String str, ImageView imageView, RequestOptions requestOptions) {
        Glide.m12516b(context).mo8814a(str).mo8828a(requestOptions).m12449a(imageView);
    }

    /* renamed from: a */
    public void m7393a(Context context, String str, ImageView imageView, RequestOptions requestOptions, RequestListener requestListener) {
        Glide.m12516b(context).mo8814a(str).mo8828a(requestOptions).mo8829a((RequestListener<Drawable>) requestListener).m12449a(imageView);
    }

    /* renamed from: a */
    public void m7396a(Context context, String str, int i, int i2, int i3, ImageView imageView) {
        RequestOptions m7397a = m7397a(i3);
        m7397a.mo9551a(i).mo9542b(i2);
        m7394a(context, str, imageView, m7397a);
    }

    /* renamed from: a */
    public void m7395a(Context context, String str, int i, int i2, int i3, ImageView imageView, RequestListener<Drawable> requestListener) {
        RequestOptions m7397a = m7397a(i3);
        m7397a.mo9551a(i).mo9542b(i2);
        m7393a(context, str, imageView, m7397a, requestListener);
    }

    /* renamed from: a */
    public RequestOptions m7397a(int i) {
        return RequestOptions.m11676a((Transformation<Bitmap>) new MultiTransformation(new CenterCrop(), new RoundedCorners(i)));
    }
}
