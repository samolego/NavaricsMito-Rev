package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.support.p011v7.widget.GridLayoutManager;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.support.p011v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.yanzhenjie.recyclerview.touch.DefaultItemTouchHelper;
import com.yanzhenjie.recyclerview.touch.OnItemMoveListener;
import com.yanzhenjie.recyclerview.touch.OnItemMovementListener;
import com.yanzhenjie.recyclerview.touch.OnItemStateChangedListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SwipeRecyclerView extends RecyclerView {

    /* renamed from: a */
    protected int f9186a;

    /* renamed from: b */
    protected SwipeMenuLayout f9187b;

    /* renamed from: c */
    protected int f9188c;

    /* renamed from: d */
    private int f9189d;

    /* renamed from: e */
    private int f9190e;

    /* renamed from: f */
    private boolean f9191f;

    /* renamed from: g */
    private DefaultItemTouchHelper f9192g;

    /* renamed from: h */
    private SwipeMenuCreator f9193h;

    /* renamed from: i */
    private OnItemMenuClickListener f9194i;

    /* renamed from: j */
    private OnItemClickListener f9195j;

    /* renamed from: k */
    private OnItemLongClickListener f9196k;

    /* renamed from: l */
    private AdapterWrapper f9197l;

    /* renamed from: m */
    private boolean f9198m;

    /* renamed from: n */
    private List<Integer> f9199n;

    /* renamed from: o */
    private RecyclerView.AdapterDataObserver f9200o;

    /* renamed from: p */
    private List<View> f9201p;

    /* renamed from: q */
    private List<View> f9202q;

    /* renamed from: r */
    private int f9203r;

    /* renamed from: s */
    private boolean f9204s;

    /* renamed from: t */
    private boolean f9205t;

    /* renamed from: u */
    private boolean f9206u;

    /* renamed from: v */
    private boolean f9207v;

    /* renamed from: w */
    private boolean f9208w;

    /* renamed from: x */
    private InterfaceC2793e f9209x;

    /* renamed from: y */
    private InterfaceC2792d f9210y;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DirectionMode {
    }

    /* renamed from: com.yanzhenjie.recyclerview.SwipeRecyclerView$d */
    /* loaded from: classes2.dex */
    public interface InterfaceC2792d {
        /* renamed from: a */
        void m3830a();
    }

    /* renamed from: com.yanzhenjie.recyclerview.SwipeRecyclerView$e */
    /* loaded from: classes2.dex */
    public interface InterfaceC2793e {
        /* renamed from: a */
        void mo3762a();

        /* renamed from: a */
        void mo3761a(InterfaceC2792d interfaceC2792d);
    }

    public SwipeRecyclerView(Context context) {
        this(context, null);
    }

    public SwipeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9188c = -1;
        this.f9198m = true;
        this.f9199n = new ArrayList();
        this.f9200o = new RecyclerView.AdapterDataObserver() { // from class: com.yanzhenjie.recyclerview.SwipeRecyclerView.2
            @Override // android.support.p011v7.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                SwipeRecyclerView.this.f9197l.notifyDataSetChanged();
            }

            @Override // android.support.p011v7.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i3) {
                SwipeRecyclerView.this.f9197l.notifyItemRangeChanged(i2 + SwipeRecyclerView.this.getHeaderCount(), i3);
            }

            @Override // android.support.p011v7.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i3, Object obj) {
                SwipeRecyclerView.this.f9197l.notifyItemRangeChanged(i2 + SwipeRecyclerView.this.getHeaderCount(), i3, obj);
            }

            @Override // android.support.p011v7.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i2, int i3) {
                SwipeRecyclerView.this.f9197l.notifyItemRangeInserted(i2 + SwipeRecyclerView.this.getHeaderCount(), i3);
            }

            @Override // android.support.p011v7.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i2, int i3) {
                SwipeRecyclerView.this.f9197l.notifyItemRangeRemoved(i2 + SwipeRecyclerView.this.getHeaderCount(), i3);
            }

            @Override // android.support.p011v7.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i2, int i3, int i4) {
                SwipeRecyclerView.this.f9197l.notifyItemMoved(i2 + SwipeRecyclerView.this.getHeaderCount(), i3 + SwipeRecyclerView.this.getHeaderCount());
            }
        };
        this.f9201p = new ArrayList();
        this.f9202q = new ArrayList();
        this.f9203r = -1;
        this.f9204s = false;
        this.f9205t = true;
        this.f9206u = false;
        this.f9207v = true;
        this.f9208w = false;
        this.f9186a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* renamed from: a */
    private void m3836a() {
        if (this.f9192g == null) {
            this.f9192g = new DefaultItemTouchHelper();
            this.f9192g.attachToRecyclerView(this);
        }
    }

    public void setOnItemMoveListener(OnItemMoveListener onItemMoveListener) {
        m3836a();
        this.f9192g.setOnItemMoveListener(onItemMoveListener);
    }

    public void setOnItemMovementListener(OnItemMovementListener onItemMovementListener) {
        m3836a();
        this.f9192g.setOnItemMovementListener(onItemMovementListener);
    }

    public void setOnItemStateChangedListener(OnItemStateChangedListener onItemStateChangedListener) {
        m3836a();
        this.f9192g.setOnItemStateChangedListener(onItemStateChangedListener);
    }

    public void setSwipeItemMenuEnabled(boolean z) {
        this.f9198m = z;
    }

    public void setLongPressDragEnabled(boolean z) {
        m3836a();
        this.f9192g.m3781a(z);
    }

    public void setItemViewSwipeEnabled(boolean z) {
        m3836a();
        this.f9191f = z;
        this.f9192g.m3780b(z);
    }

    /* renamed from: a */
    private void m3832a(String str) {
        if (this.f9197l != null) {
            throw new IllegalStateException(str);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            return;
        }
        m3832a("Cannot set item click listener, setAdapter has already been called.");
        this.f9195j = new C2789a(this, onItemClickListener);
    }

    /* renamed from: com.yanzhenjie.recyclerview.SwipeRecyclerView$a */
    /* loaded from: classes2.dex */
    private static class C2789a implements OnItemClickListener {

        /* renamed from: a */
        private SwipeRecyclerView f9215a;

        /* renamed from: b */
        private OnItemClickListener f9216b;

        public C2789a(SwipeRecyclerView swipeRecyclerView, OnItemClickListener onItemClickListener) {
            this.f9215a = swipeRecyclerView;
            this.f9216b = onItemClickListener;
        }

        @Override // com.yanzhenjie.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo3808a(View view, int i) {
            int headerCount = i - this.f9215a.getHeaderCount();
            if (headerCount >= 0) {
                this.f9216b.mo3808a(view, headerCount);
            }
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            return;
        }
        m3832a("Cannot set item long click listener, setAdapter has already been called.");
        this.f9196k = new C2790b(this, onItemLongClickListener);
    }

    /* renamed from: com.yanzhenjie.recyclerview.SwipeRecyclerView$b */
    /* loaded from: classes2.dex */
    private static class C2790b implements OnItemLongClickListener {

        /* renamed from: a */
        private SwipeRecyclerView f9217a;

        /* renamed from: b */
        private OnItemLongClickListener f9218b;

        public C2790b(SwipeRecyclerView swipeRecyclerView, OnItemLongClickListener onItemLongClickListener) {
            this.f9217a = swipeRecyclerView;
            this.f9218b = onItemLongClickListener;
        }

        @Override // com.yanzhenjie.recyclerview.OnItemLongClickListener
        /* renamed from: a */
        public void mo3807a(View view, int i) {
            int headerCount = i - this.f9217a.getHeaderCount();
            if (headerCount >= 0) {
                this.f9218b.mo3807a(view, headerCount);
            }
        }
    }

    public void setSwipeMenuCreator(SwipeMenuCreator swipeMenuCreator) {
        if (swipeMenuCreator == null) {
            return;
        }
        m3832a("Cannot set menu creator, setAdapter has already been called.");
        this.f9193h = swipeMenuCreator;
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener onItemMenuClickListener) {
        if (onItemMenuClickListener == null) {
            return;
        }
        m3832a("Cannot set menu item click listener, setAdapter has already been called.");
        this.f9194i = new C2791c(this, onItemMenuClickListener);
    }

    /* renamed from: com.yanzhenjie.recyclerview.SwipeRecyclerView$c */
    /* loaded from: classes2.dex */
    private static class C2791c implements OnItemMenuClickListener {

        /* renamed from: a */
        private SwipeRecyclerView f9219a;

        /* renamed from: b */
        private OnItemMenuClickListener f9220b;

        public C2791c(SwipeRecyclerView swipeRecyclerView, OnItemMenuClickListener onItemMenuClickListener) {
            this.f9219a = swipeRecyclerView;
            this.f9220b = onItemMenuClickListener;
        }

        @Override // com.yanzhenjie.recyclerview.OnItemMenuClickListener
        /* renamed from: a */
        public void mo3806a(SwipeMenuBridge swipeMenuBridge, int i) {
            int headerCount = i - this.f9219a.getHeaderCount();
            if (headerCount >= 0) {
                this.f9220b.mo3806a(swipeMenuBridge, headerCount);
            }
        }
    }

    @Override // android.support.p011v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.yanzhenjie.recyclerview.SwipeRecyclerView.1
                @Override // android.support.p011v7.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (SwipeRecyclerView.this.f9197l.m3821b(i) || SwipeRecyclerView.this.f9197l.m3817c(i)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i - SwipeRecyclerView.this.getHeaderCount());
                    }
                    return 1;
                }
            });
        }
        super.setLayoutManager(layoutManager);
    }

    public RecyclerView.Adapter getOriginAdapter() {
        AdapterWrapper adapterWrapper = this.f9197l;
        if (adapterWrapper == null) {
            return null;
        }
        return adapterWrapper.m3829a();
    }

    @Override // android.support.p011v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        AdapterWrapper adapterWrapper = this.f9197l;
        if (adapterWrapper != null) {
            adapterWrapper.m3829a().unregisterAdapterDataObserver(this.f9200o);
        }
        if (adapter == null) {
            this.f9197l = null;
        } else {
            adapter.registerAdapterDataObserver(this.f9200o);
            this.f9197l = new AdapterWrapper(getContext(), adapter);
            this.f9197l.setOnItemClickListener(this.f9195j);
            this.f9197l.setOnItemLongClickListener(this.f9196k);
            this.f9197l.m3824a(this.f9193h);
            this.f9197l.setOnItemMenuClickListener(this.f9194i);
            if (this.f9201p.size() > 0) {
                for (View view : this.f9201p) {
                    this.f9197l.m3826a(view);
                }
            }
            if (this.f9202q.size() > 0) {
                for (View view2 : this.f9202q) {
                    this.f9197l.m3820b(view2);
                }
            }
        }
        super.setAdapter(this.f9197l);
    }

    public int getHeaderCount() {
        AdapterWrapper adapterWrapper = this.f9197l;
        if (adapterWrapper == null) {
            return 0;
        }
        return adapterWrapper.m3822b();
    }

    public int getFooterCount() {
        AdapterWrapper adapterWrapper = this.f9197l;
        if (adapterWrapper == null) {
            return 0;
        }
        return adapterWrapper.m3818c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    @Override // android.support.p011v7.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.recyclerview.SwipeRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private boolean m3835a(int i, int i2, boolean z) {
        int i3 = this.f9189d - i;
        int i4 = this.f9190e - i2;
        if (Math.abs(i3) <= this.f9186a || Math.abs(i3) <= Math.abs(i4)) {
            if (Math.abs(i4) >= this.f9186a || Math.abs(i3) >= this.f9186a) {
                return z;
            }
            return false;
        }
        return false;
    }

    @Override // android.support.p011v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 2:
                SwipeMenuLayout swipeMenuLayout = this.f9187b;
                if (swipeMenuLayout != null && swipeMenuLayout.m3849d()) {
                    this.f9187b.m3840m();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private View m3834a(View view) {
        if (view instanceof SwipeMenuLayout) {
            return view;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (!arrayList.isEmpty()) {
            View view2 = (View) arrayList.remove(0);
            if (view2 instanceof ViewGroup) {
                if (view2 instanceof SwipeMenuLayout) {
                    return view2;
                }
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayList.add(viewGroup.getChildAt(i));
                }
            }
        }
        return view;
    }

    @Override // android.support.p011v7.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        this.f9203r = i;
    }

    @Override // android.support.p011v7.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int itemCount = layoutManager.getItemCount();
            if (itemCount > 0 && itemCount == linearLayoutManager.findLastVisibleItemPosition() + 1) {
                int i3 = this.f9203r;
                if (i3 == 1 || i3 == 2) {
                    m3831b();
                }
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int itemCount2 = layoutManager.getItemCount();
            if (itemCount2 <= 0) {
                return;
            }
            int[] findLastCompletelyVisibleItemPositions = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null);
            if (itemCount2 == findLastCompletelyVisibleItemPositions[findLastCompletelyVisibleItemPositions.length - 1] + 1) {
                int i4 = this.f9203r;
                if (i4 == 1 || i4 == 2) {
                    m3831b();
                }
            }
        }
    }

    /* renamed from: b */
    private void m3831b() {
        if (this.f9206u) {
            return;
        }
        if (!this.f9205t) {
            InterfaceC2793e interfaceC2793e = this.f9209x;
            if (interfaceC2793e != null) {
                interfaceC2793e.mo3761a(this.f9210y);
            }
        } else if (this.f9204s || this.f9207v || !this.f9208w) {
        } else {
            this.f9204s = true;
            InterfaceC2793e interfaceC2793e2 = this.f9209x;
            if (interfaceC2793e2 != null) {
                interfaceC2793e2.mo3762a();
            }
            InterfaceC2792d interfaceC2792d = this.f9210y;
            if (interfaceC2792d != null) {
                interfaceC2792d.m3830a();
            }
        }
    }

    public void setLoadMoreView(InterfaceC2793e interfaceC2793e) {
        this.f9209x = interfaceC2793e;
    }

    public void setLoadMoreListener(InterfaceC2792d interfaceC2792d) {
        this.f9210y = interfaceC2792d;
    }

    public void setAutoLoadMore(boolean z) {
        this.f9205t = z;
    }
}
