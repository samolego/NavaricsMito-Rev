package com.yanzhenjie.recyclerview;

import android.support.p011v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import com.yanzhenjie.recyclerview.ExpandableAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ExpandableAdapter<VH extends ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a */
    private final SparseBooleanArray f9158a = new SparseBooleanArray();

    /* renamed from: b */
    private final List<Integer> f9159b = new ArrayList();

    /* loaded from: classes2.dex */
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
    }
}
