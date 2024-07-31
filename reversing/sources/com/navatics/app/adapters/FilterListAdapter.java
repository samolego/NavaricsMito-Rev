package com.navatics.app.adapters;

import android.content.Context;
import android.support.p011v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.p057cv.NavaticsCV;
import com.navatics.p057cv.NavaticsFilter;
import java.util.List;

/* loaded from: classes.dex */
public class FilterListAdapter extends RecyclerView.Adapter<C1705a> {

    /* renamed from: a */
    private List<NavaticsFilter> f4021a = NavaticsCV.m6860b();

    /* renamed from: b */
    private Context f4022b;

    /* renamed from: c */
    private InterfaceC1706b f4023c;

    /* renamed from: com.navatics.app.adapters.FilterListAdapter$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1706b {
        void onItemClicked(View view, int i);
    }

    public FilterListAdapter(Context context) {
        this.f4022b = context;
    }

    public void setOnItemClickedListener(InterfaceC1706b interfaceC1706b) {
        this.f4023c = interfaceC1706b;
    }

    /* renamed from: a */
    public NavaticsFilter m8840a(int i) {
        List<NavaticsFilter> list = this.f4021a;
        if (list == null || i >= list.size() || i < 0) {
            return null;
        }
        return this.f4021a.get(i);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public C1705a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C1705a(LayoutInflater.from(this.f4022b).inflate(R.layout.filter_list_item, viewGroup, false));
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(final C1705a c1705a, int i) {
        NavaticsFilter navaticsFilter = this.f4021a.get(i);
        if (navaticsFilter.getName().contains("deep")) {
            c1705a.f4027b.setText(R.string.filter_name_vivid_deep);
            c1705a.f4026a.setImageResource(R.drawable.filter1);
        } else if (navaticsFilter.getName().contains("shallow")) {
            c1705a.f4027b.setText(R.string.filter_name_vivid_shallow);
            c1705a.f4026a.setImageResource(R.drawable.filter2);
        }
        c1705a.f4026a.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.adapters.FilterListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FilterListAdapter.this.f4023c != null) {
                    FilterListAdapter.this.f4023c.onItemClicked(view, c1705a.getAdapterPosition());
                }
            }
        });
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<NavaticsFilter> list = this.f4021a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.adapters.FilterListAdapter$a */
    /* loaded from: classes.dex */
    public class C1705a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        ImageView f4026a;

        /* renamed from: b */
        TextView f4027b;

        C1705a(View view) {
            super(view);
            this.f4026a = (ImageView) view.findViewById(R.id.filterImage);
            this.f4027b = (TextView) view.findViewById(R.id.filterTitle);
        }
    }
}
