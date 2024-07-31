package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.p011v7.widget.RecyclerView;
import android.view.View;

/* loaded from: classes2.dex */
public class BorderItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    static final /* synthetic */ boolean f9262a = !BorderItemDecoration.class.desiredAssertionStatus();

    /* renamed from: b */
    private final int f9263b;

    /* renamed from: c */
    private final int f9264c;

    /* renamed from: d */
    private final Drawer f9265d;

    @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int i = this.f9263b;
        int i2 = this.f9264c;
        rect.set(i, i2, i, i2);
    }

    @Override // android.support.p011v7.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        canvas.save();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!f9262a && layoutManager == null) {
            throw new AssertionError();
        }
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = layoutManager.getChildAt(i);
            this.f9265d.m3738a(childAt, canvas);
            this.f9265d.m3737b(childAt, canvas);
            this.f9265d.m3736c(childAt, canvas);
            this.f9265d.m3735d(childAt, canvas);
        }
        canvas.restore();
    }
}
