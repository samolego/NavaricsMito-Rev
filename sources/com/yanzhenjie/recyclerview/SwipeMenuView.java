package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.p008v4.view.ViewCompat;
import android.support.p008v4.widget.TextViewCompat;
import android.support.p011v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes2.dex */
public class SwipeMenuView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private RecyclerView.ViewHolder f9184a;

    /* renamed from: b */
    private OnItemMenuClickListener f9185b;

    public SwipeMenuView(Context context) {
        this(context, null);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGravity(16);
    }

    /* renamed from: a */
    public void m3839a(RecyclerView.ViewHolder viewHolder, SwipeMenu swipeMenu, Controller controller, int i, OnItemMenuClickListener onItemMenuClickListener) {
        removeAllViews();
        this.f9184a = viewHolder;
        this.f9185b = onItemMenuClickListener;
        List<SwipeMenuItem> m3859b = swipeMenu.m3859b();
        for (int i2 = 0; i2 < m3859b.size(); i2++) {
            SwipeMenuItem swipeMenuItem = m3859b.get(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(swipeMenuItem.m3784h(), swipeMenuItem.m3783i());
            layoutParams.weight = swipeMenuItem.m3782j();
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(i2);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            ViewCompat.setBackground(linearLayout, swipeMenuItem.m3797a());
            linearLayout.setOnClickListener(this);
            addView(linearLayout);
            linearLayout.setTag(new SwipeMenuBridge(controller, i, i2));
            if (swipeMenuItem.m3794b() != null) {
                linearLayout.addView(m3838a(swipeMenuItem));
            }
            if (!TextUtils.isEmpty(swipeMenuItem.m3791c())) {
                linearLayout.addView(m3837b(swipeMenuItem));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemMenuClickListener onItemMenuClickListener = this.f9185b;
        if (onItemMenuClickListener != null) {
            onItemMenuClickListener.mo3806a((SwipeMenuBridge) view.getTag(), this.f9184a.getAdapterPosition());
        }
    }

    /* renamed from: a */
    private ImageView m3838a(SwipeMenuItem swipeMenuItem) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(swipeMenuItem.m3794b());
        return imageView;
    }

    /* renamed from: b */
    private TextView m3837b(SwipeMenuItem swipeMenuItem) {
        TextView textView = new TextView(getContext());
        textView.setText(swipeMenuItem.m3791c());
        textView.setGravity(17);
        int m3787e = swipeMenuItem.m3787e();
        if (m3787e > 0) {
            textView.setTextSize(2, m3787e);
        }
        ColorStateList m3789d = swipeMenuItem.m3789d();
        if (m3789d != null) {
            textView.setTextColor(m3789d);
        }
        int m3786f = swipeMenuItem.m3786f();
        if (m3786f != 0) {
            TextViewCompat.setTextAppearance(textView, m3786f);
        }
        Typeface m3785g = swipeMenuItem.m3785g();
        if (m3785g != null) {
            textView.setTypeface(m3785g);
        }
        return textView;
    }
}
