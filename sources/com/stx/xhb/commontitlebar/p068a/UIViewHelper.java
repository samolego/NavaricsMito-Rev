package com.stx.xhb.commontitlebar.p068a;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.p011v7.appcompat.C0425R;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.stx.xhb.commontitlebar.a.e */
/* loaded from: classes2.dex */
public class UIViewHelper {

    /* renamed from: a */
    private static final AtomicInteger f7096a = new AtomicInteger(1);

    /* renamed from: b */
    private static final int[] f7097b = {C0425R.attr.colorPrimary};

    @TargetApi(16)
    /* renamed from: a */
    public static void m5584a(View view, Drawable drawable) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    /* renamed from: a */
    public static void m5585a(View view, @ColorInt int i) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackgroundColor(i);
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    /* renamed from: a */
    public static void m5583a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        C2378a.m5582a(viewGroup, view, rect);
    }

    /* compiled from: UIViewHelper.java */
    /* renamed from: com.stx.xhb.commontitlebar.a.e$a */
    /* loaded from: classes2.dex */
    private static class C2378a {

        /* renamed from: a */
        private static final ThreadLocal<Matrix> f7098a = new ThreadLocal<>();

        /* renamed from: b */
        private static final ThreadLocal<RectF> f7099b = new ThreadLocal<>();

        /* renamed from: a */
        public static void m5582a(ViewGroup viewGroup, View view, Rect rect) {
            Matrix matrix = f7098a.get();
            if (matrix == null) {
                matrix = new Matrix();
                f7098a.set(matrix);
            } else {
                matrix.reset();
            }
            m5581a(viewGroup, view, matrix);
            RectF rectF = f7099b.get();
            if (rectF == null) {
                rectF = new RectF();
                f7099b.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }

        /* renamed from: a */
        static void m5581a(ViewParent viewParent, View view, Matrix matrix) {
            ViewParent parent = view.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                View view2 = (View) parent;
                m5581a(viewParent, view2, matrix);
                matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
            }
            matrix.preTranslate(view.getLeft(), view.getTop());
            if (view.getMatrix().isIdentity()) {
                return;
            }
            matrix.preConcat(view.getMatrix());
        }
    }
}
