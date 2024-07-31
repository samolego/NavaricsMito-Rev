package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.p008v4.util.SparseArrayCompat;
import android.support.p011v7.widget.GridLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.support.p011v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.yanzhenjie.recyclerview.a */
/* loaded from: classes2.dex */
public class AdapterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private SparseArrayCompat<View> f9221a = new SparseArrayCompat<>();

    /* renamed from: b */
    private SparseArrayCompat<View> f9222b = new SparseArrayCompat<>();

    /* renamed from: c */
    private RecyclerView.Adapter f9223c;

    /* renamed from: d */
    private LayoutInflater f9224d;

    /* renamed from: e */
    private SwipeMenuCreator f9225e;

    /* renamed from: f */
    private OnItemMenuClickListener f9226f;

    /* renamed from: g */
    private OnItemClickListener f9227g;

    /* renamed from: h */
    private OnItemLongClickListener f9228h;

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterWrapper(Context context, RecyclerView.Adapter adapter) {
        this.f9224d = LayoutInflater.from(context);
        this.f9223c = adapter;
    }

    /* renamed from: a */
    public RecyclerView.Adapter m3829a() {
        return this.f9223c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3824a(SwipeMenuCreator swipeMenuCreator) {
        this.f9225e = swipeMenuCreator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnItemMenuClickListener(OnItemMenuClickListener onItemMenuClickListener) {
        this.f9226f = onItemMenuClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f9227g = onItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.f9228h = onItemLongClickListener;
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return m3822b() + m3816d() + m3818c();
    }

    /* renamed from: d */
    private int m3816d() {
        return this.f9223c.getItemCount();
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (m3821b(i)) {
            return this.f9221a.keyAt(i);
        }
        if (m3817c(i)) {
            return this.f9222b.keyAt((i - m3822b()) - m3816d());
        }
        return this.f9223c.getItemViewType(i - m3822b());
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = this.f9221a.get(i);
        if (view != null) {
            return new C2797a(view);
        }
        View view2 = this.f9222b.get(i);
        if (view2 != null) {
            return new C2797a(view2);
        }
        final RecyclerView.ViewHolder onCreateViewHolder = this.f9223c.onCreateViewHolder(viewGroup, i);
        if (this.f9227g != null) {
            onCreateViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yanzhenjie.recyclerview.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AdapterWrapper.this.f9227g.mo3808a(view3, onCreateViewHolder.getAdapterPosition());
                }
            });
        }
        if (this.f9228h != null) {
            onCreateViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yanzhenjie.recyclerview.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    AdapterWrapper.this.f9228h.mo3807a(view3, onCreateViewHolder.getAdapterPosition());
                    return true;
                }
            });
        }
        if (this.f9225e == null) {
            return onCreateViewHolder;
        }
        View inflate = this.f9224d.inflate(R.layout.support_recycler_view_item, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.swipe_content)).addView(onCreateViewHolder.itemView);
        try {
            Field declaredField = m3823a(onCreateViewHolder.getClass()).getDeclaredField("itemView");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(onCreateViewHolder, inflate);
        } catch (Exception unused) {
        }
        return onCreateViewHolder;
    }

    /* renamed from: a */
    private Class<?> m3823a(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == null || superclass.equals(Object.class)) ? cls : m3823a(superclass);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
        if (m3827a(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        int m3822b = i - m3822b();
        if ((view instanceof SwipeMenuLayout) && this.f9225e != null) {
            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
            SwipeMenu swipeMenu = new SwipeMenu(swipeMenuLayout);
            SwipeMenu swipeMenu2 = new SwipeMenu(swipeMenuLayout);
            this.f9225e.mo3798a(swipeMenu, swipeMenu2, m3822b);
            SwipeMenuView swipeMenuView = (SwipeMenuView) swipeMenuLayout.getChildAt(0);
            if (swipeMenu.m3858c()) {
                swipeMenuView.setOrientation(swipeMenu.m3861a());
                swipeMenuView.m3839a(viewHolder, swipeMenu, swipeMenuLayout, 1, this.f9226f);
            } else if (swipeMenuView.getChildCount() > 0) {
                swipeMenuView.removeAllViews();
            }
            SwipeMenuView swipeMenuView2 = (SwipeMenuView) swipeMenuLayout.getChildAt(2);
            if (swipeMenu2.m3858c()) {
                swipeMenuView2.setOrientation(swipeMenu2.m3861a());
                swipeMenuView2.m3839a(viewHolder, swipeMenu2, swipeMenuLayout, -1, this.f9226f);
            } else if (swipeMenuView2.getChildCount() > 0) {
                swipeMenuView2.removeAllViews();
            }
        }
        this.f9223c.onBindViewHolder(viewHolder, m3822b, list);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f9223c.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.yanzhenjie.recyclerview.a.3
                @Override // android.support.p011v7.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (AdapterWrapper.this.m3828a(i)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i);
                    }
                    return 1;
                }
            });
        }
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (m3827a(viewHolder)) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
                return;
            }
            return;
        }
        this.f9223c.onViewAttachedToWindow(viewHolder);
    }

    /* renamed from: a */
    public boolean m3827a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof C2797a) {
            return true;
        }
        return m3828a(viewHolder.getAdapterPosition());
    }

    /* renamed from: a */
    public boolean m3828a(int i) {
        return m3821b(i) || m3817c(i);
    }

    /* renamed from: b */
    public boolean m3821b(int i) {
        return i >= 0 && i < m3822b();
    }

    /* renamed from: c */
    public boolean m3817c(int i) {
        return i >= m3822b() + m3816d();
    }

    /* renamed from: a */
    public void m3826a(View view) {
        this.f9221a.put(m3822b() + 100000, view);
    }

    /* renamed from: b */
    public void m3820b(View view) {
        this.f9222b.put(m3818c() + 200000, view);
    }

    /* renamed from: b */
    public int m3822b() {
        return this.f9221a.size();
    }

    /* renamed from: c */
    public int m3818c() {
        return this.f9222b.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterWrapper.java */
    /* renamed from: com.yanzhenjie.recyclerview.a$a */
    /* loaded from: classes2.dex */
    public static class C2797a extends RecyclerView.ViewHolder {
        public C2797a(View view) {
            super(view);
        }
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (m3828a(i)) {
            return (-i) - 1;
        }
        return this.f9223c.getItemId(i - m3822b());
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (m3827a(viewHolder)) {
            return;
        }
        this.f9223c.onViewRecycled(viewHolder);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (m3827a(viewHolder)) {
            return false;
        }
        return this.f9223c.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (m3827a(viewHolder)) {
            return;
        }
        this.f9223c.onViewDetachedFromWindow(viewHolder);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f9223c.onDetachedFromRecyclerView(recyclerView);
    }
}
