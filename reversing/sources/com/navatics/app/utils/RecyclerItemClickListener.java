package com.navatics.app.utils;

import android.content.Context;
import android.support.p011v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a */
    GestureDetector f5119a;

    /* renamed from: b */
    private InterfaceC1910a f5120b;

    /* renamed from: com.navatics.app.utils.RecyclerItemClickListener$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1910a {
        /* renamed from: a */
        void mo7407a(View view, int i);

        /* renamed from: b */
        void mo7406b(View view, int i);
    }

    @Override // android.support.p011v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // android.support.p011v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, InterfaceC1910a interfaceC1910a) {
        this.f5120b = interfaceC1910a;
        this.f5119a = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.navatics.app.utils.RecyclerItemClickListener.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (findChildViewUnder == null || RecyclerItemClickListener.this.f5120b == null) {
                    return;
                }
                RecyclerItemClickListener.this.f5120b.mo7406b(findChildViewUnder, recyclerView.getChildAdapterPosition(findChildViewUnder));
            }
        });
    }

    @Override // android.support.p011v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder == null || this.f5120b == null || !this.f5119a.onTouchEvent(motionEvent)) {
            return false;
        }
        this.f5120b.mo7407a(findChildViewUnder, recyclerView.getChildAdapterPosition(findChildViewUnder));
        return true;
    }
}
