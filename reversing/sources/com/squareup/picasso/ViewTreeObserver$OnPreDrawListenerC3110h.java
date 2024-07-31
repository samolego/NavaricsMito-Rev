package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.h */
/* loaded from: classes2.dex */
public class DeferredRequestCreator implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final RequestCreator f6930a;

    /* renamed from: b */
    final WeakReference<ImageView> f6931b;

    /* renamed from: c */
    Callback f6932c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView, Callback callback) {
        this.f6930a = requestCreator;
        this.f6931b = new WeakReference<>(imageView);
        this.f6932c = callback;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f6931b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width <= 0 || height <= 0) {
                return true;
            }
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f6930a.m5650b().m5656a(width, height).m5652a(imageView, this.f6932c);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5714a() {
        this.f6932c = null;
        ImageView imageView = this.f6931b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }
}
