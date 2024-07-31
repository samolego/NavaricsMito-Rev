package com.bumptech.glide.load.resource.p027b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p008v4.content.ContextCompat;
import android.support.p008v4.content.res.ResourcesCompat;
import android.support.p011v7.content.res.AppCompatResources;
import android.support.p011v7.view.ContextThemeWrapper;

/* renamed from: com.bumptech.glide.load.resource.b.a */
/* loaded from: classes.dex */
public final class DrawableDecoderCompat {

    /* renamed from: a */
    private static volatile boolean f1009a = true;

    /* renamed from: a */
    public static Drawable m12001a(Context context, Context context2, @DrawableRes int i) {
        return m12000a(context, context2, i, null);
    }

    /* renamed from: a */
    public static Drawable m12002a(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return m12000a(context, context, i, theme);
    }

    /* renamed from: a */
    private static Drawable m12000a(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (f1009a) {
                return m11999b(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            f1009a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return m11998c(context2, i, theme);
    }

    /* renamed from: b */
    private static Drawable m11999b(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i);
    }

    /* renamed from: c */
    private static Drawable m11998c(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }
}
