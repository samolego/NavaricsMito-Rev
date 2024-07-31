package com.yanzhenjie.recyclerview.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.yanzhenjie.recyclerview.R;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes2.dex */
public class DefaultLoadMoreView extends LinearLayout implements View.OnClickListener, SwipeRecyclerView.InterfaceC2793e {

    /* renamed from: a */
    private ProgressBar f9270a;

    /* renamed from: b */
    private TextView f9271b;

    /* renamed from: c */
    private SwipeRecyclerView.InterfaceC2792d f9272c;

    public DefaultLoadMoreView(Context context) {
        this(context, null);
    }

    public DefaultLoadMoreView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setGravity(17);
        setVisibility(8);
        setMinimumHeight((int) ((getResources().getDisplayMetrics().density * 60.0f) + 0.5d));
        inflate(getContext(), R.layout.support_recycler_view_load_more, this);
        this.f9270a = (ProgressBar) findViewById(R.id.progress_bar);
        this.f9271b = (TextView) findViewById(R.id.tv_load_more_message);
        setOnClickListener(this);
    }

    @Override // com.yanzhenjie.recyclerview.SwipeRecyclerView.InterfaceC2793e
    /* renamed from: a */
    public void mo3762a() {
        setVisibility(0);
        this.f9270a.setVisibility(0);
        this.f9271b.setVisibility(0);
        this.f9271b.setText(R.string.support_recycler_load_more_message);
    }

    @Override // com.yanzhenjie.recyclerview.SwipeRecyclerView.InterfaceC2793e
    /* renamed from: a */
    public void mo3761a(SwipeRecyclerView.InterfaceC2792d interfaceC2792d) {
        this.f9272c = interfaceC2792d;
        setVisibility(0);
        this.f9270a.setVisibility(8);
        this.f9271b.setVisibility(0);
        this.f9271b.setText(R.string.support_recycler_click_load_more);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwipeRecyclerView.InterfaceC2792d interfaceC2792d = this.f9272c;
        if (interfaceC2792d != null) {
            interfaceC2792d.m3830a();
        }
    }
}
