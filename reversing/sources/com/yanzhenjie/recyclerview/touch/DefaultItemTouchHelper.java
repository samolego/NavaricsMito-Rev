package com.yanzhenjie.recyclerview.touch;

import android.support.p011v7.widget.helper.ItemTouchHelper;

/* loaded from: classes2.dex */
public class DefaultItemTouchHelper extends ItemTouchHelper {

    /* renamed from: a */
    private ItemTouchHelperCallback f9256a;

    public DefaultItemTouchHelper() {
        this(new ItemTouchHelperCallback());
    }

    private DefaultItemTouchHelper(ItemTouchHelperCallback itemTouchHelperCallback) {
        super(itemTouchHelperCallback);
        this.f9256a = itemTouchHelperCallback;
    }

    public void setOnItemMoveListener(OnItemMoveListener onItemMoveListener) {
        this.f9256a.setOnItemMoveListener(onItemMoveListener);
    }

    public void setOnItemMovementListener(OnItemMovementListener onItemMovementListener) {
        this.f9256a.setOnItemMovementListener(onItemMovementListener);
    }

    /* renamed from: a */
    public void m3781a(boolean z) {
        this.f9256a.m3779a(z);
    }

    /* renamed from: b */
    public void m3780b(boolean z) {
        this.f9256a.m3778b(z);
    }

    public void setOnItemStateChangedListener(OnItemStateChangedListener onItemStateChangedListener) {
        this.f9256a.setOnItemStateChangedListener(onItemStateChangedListener);
    }
}
