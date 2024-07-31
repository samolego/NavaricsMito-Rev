package com.yanzhenjie.recyclerview.touch;

import android.graphics.Canvas;
import android.support.p011v7.widget.GridLayoutManager;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.support.p011v7.widget.helper.ItemTouchHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.yanzhenjie.recyclerview.touch.a */
/* loaded from: classes2.dex */
public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    /* renamed from: a */
    private OnItemMovementListener f9257a;

    /* renamed from: b */
    private OnItemMoveListener f9258b;

    /* renamed from: c */
    private OnItemStateChangedListener f9259c;

    /* renamed from: d */
    private boolean f9260d;

    /* renamed from: e */
    private boolean f9261e;

    /* renamed from: a */
    public void m3779a(boolean z) {
        this.f9261e = z;
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return this.f9261e;
    }

    /* renamed from: b */
    public void m3778b(boolean z) {
        this.f9260d = z;
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return this.f9260d;
    }

    public void setOnItemMoveListener(OnItemMoveListener onItemMoveListener) {
        this.f9258b = onItemMoveListener;
    }

    public void setOnItemMovementListener(OnItemMovementListener onItemMovementListener) {
        this.f9257a = onItemMovementListener;
    }

    public void setOnItemStateChangedListener(OnItemStateChangedListener onItemStateChangedListener) {
        this.f9259c = onItemStateChangedListener;
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        OnItemMovementListener onItemMovementListener = this.f9257a;
        if (onItemMovementListener != null) {
            return makeMovementFlags(onItemMovementListener.m3775a(recyclerView, viewHolder), this.f9257a.m3774b(recyclerView, viewHolder));
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 0) {
                return makeMovementFlags(15, 3);
            }
            return makeMovementFlags(15, 12);
        } else if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 0) {
                return makeMovementFlags(12, 3);
            }
            return makeMovementFlags(3, 12);
        } else {
            return makeMovementFlags(0, 0);
        }
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i == 1) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            float f3 = 1.0f;
            if (layoutManager instanceof LinearLayoutManager) {
                int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
                if (orientation == 0) {
                    f3 = 1.0f - (Math.abs(f2) / viewHolder.itemView.getHeight());
                } else if (orientation == 1) {
                    f3 = 1.0f - (Math.abs(f) / viewHolder.itemView.getWidth());
                }
            }
            viewHolder.itemView.setAlpha(f3);
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        OnItemMoveListener onItemMoveListener = this.f9258b;
        if (onItemMoveListener != null) {
            return onItemMoveListener.m3776a(viewHolder, viewHolder2);
        }
        return false;
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        OnItemMoveListener onItemMoveListener = this.f9258b;
        if (onItemMoveListener != null) {
            onItemMoveListener.m3777a(viewHolder);
        }
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
        OnItemStateChangedListener onItemStateChangedListener = this.f9259c;
        if (onItemStateChangedListener == null || i == 0) {
            return;
        }
        onItemStateChangedListener.m3773a(viewHolder, i);
    }

    @Override // android.support.p011v7.widget.helper.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        OnItemStateChangedListener onItemStateChangedListener = this.f9259c;
        if (onItemStateChangedListener != null) {
            onItemStateChangedListener.m3773a(viewHolder, 0);
        }
    }
}
