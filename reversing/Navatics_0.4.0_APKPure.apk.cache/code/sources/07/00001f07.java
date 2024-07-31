package com.stx.xhb.commontitlebar.p058a;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v7.appcompat.C0373R;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UIViewHelper.java */
/* renamed from: com.stx.xhb.commontitlebar.a.e, reason: use source file name */
/* loaded from: classes2.dex */
public class UIViewHelper {

    /* renamed from: a */
    private static final AtomicInteger f7130a = new AtomicInteger(1);

    /* renamed from: b */
    private static final int[] f7131b = {C0373R.attr.colorPrimary};

    @TargetApi(16)
    /* renamed from: a */
    public static void m7269a(View view, Drawable drawable) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    /* renamed from: a */
    public static void m7268a(View view, @ColorInt int i) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackgroundColor(i);
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    /* renamed from: a */
    public static void m7270a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a.m7271a(viewGroup, view, rect);
    }

    /* compiled from: UIViewHelper.java */
    /* renamed from: com.stx.xhb.commontitlebar.a.e$a */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a */
        private static final ThreadLocal<Matrix> f7132a = new ThreadLocal<>();

        /* renamed from: b */
        private static final ThreadLocal<RectF> f7133b = new ThreadLocal<>();

        /* renamed from: a */
        public static void m7271a(ViewGroup viewGroup, View view, Rect rect) {
            Matrix matrix = f7132a.get();
            if (matrix == null) {
                matrix = new Matrix();
                f7132a.set(matrix);
            } else {
                matrix.reset();
            }
            m7272a(viewGroup, view, matrix);
            RectF rectF = f7133b.get();
            if (rectF == null) {
                rectF = new RectF();
                f7133b.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }

        /* renamed from: a */
        static void m7272a(ViewParent viewParent, View view, Matrix matrix) {
            Object parent = view.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                m7272a(viewParent, (View) parent, matrix);
                matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
            }
            matrix.preTranslate(view.getLeft(), view.getTop());
            if (view.getMatrix().isIdentity()) {
                return;
            }
            matrix.preConcat(view.getMatrix());
        }
    }
}