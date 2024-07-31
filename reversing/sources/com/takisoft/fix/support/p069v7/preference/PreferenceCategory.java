package com.takisoft.fix.support.p069v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.p008v4.content.res.TypedArrayUtils;
import android.support.p011v7.preference.PreferenceViewHolder;
import android.support.p011v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: com.takisoft.fix.support.v7.preference.PreferenceCategory */
/* loaded from: classes2.dex */
public class PreferenceCategory extends android.support.p011v7.preference.PreferenceCategory {
    private static final int[] CATEGORY_ATTRS = {C2380R.attr.colorAccent, C2380R.attr.preferenceCategory_marginBottom};
    protected int color;
    protected View itemView;

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2380R.styleable.PreferenceCategory, i, 0);
        this.color = obtainStyledAttributes.getColor(C2380R.styleable.PreferenceCategory_pref_categoryColor, 0);
        obtainStyledAttributes.recycle();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, C2380R.attr.preferenceCategoryStyle, 16842892));
    }

    public PreferenceCategory(Context context) {
        this(context, null);
    }

    private void setTitleVisibility(View view, boolean z) {
        RecyclerView.LayoutParams layoutParams;
        if (view == null) {
            return;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        boolean z2 = view.getTag() != null && layoutParams2.width == 0;
        if (view.getTag() == null) {
            layoutParams = new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams2);
            view.setTag(layoutParams);
        } else {
            layoutParams = (RecyclerView.LayoutParams) view.getTag();
        }
        if (z) {
            if (view.getVisibility() == 8 || z2) {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                layoutParams2.bottomMargin = layoutParams.bottomMargin;
                view.setVisibility(0);
            }
        } else if (view.getVisibility() == 0 || !z2) {
            layoutParams2.width = 0;
            layoutParams2.height = 0;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            view.setVisibility(8);
        }
    }

    @Override // android.support.p011v7.preference.Preference
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        setTitleVisibility(this.itemView, !TextUtils.isEmpty(getTitle()));
    }

    public void setColor(@ColorInt int i) {
        this.color = i;
    }

    public void setColorResource(@ColorRes int i) {
        int color;
        if (Build.VERSION.SDK_INT < 23) {
            color = getContext().getResources().getColor(i);
        } else {
            color = getContext().getColor(i);
        }
        setColor(color);
    }

    @Override // android.support.p011v7.preference.PreferenceCategory, android.support.p011v7.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        int dimensionPixelSize;
        super.onBindViewHolder(preferenceViewHolder);
        this.itemView = preferenceViewHolder.itemView;
        TextView textView = (TextView) preferenceViewHolder.findViewById(16908310);
        if (textView != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(CATEGORY_ATTRS);
            if (obtainStyledAttributes.length() > 0 && obtainStyledAttributes.getIndexCount() > 0) {
                int color = obtainStyledAttributes.getColor(obtainStyledAttributes.getIndex(0), 16728193);
                int i = this.color;
                if (i != 0) {
                    color = i;
                }
                textView.setTextColor(color);
                int index = obtainStyledAttributes.getIndex(1);
                TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                if (obtainStyledAttributes.hasValue(index) && peekValue != null && peekValue.type == 5 && (dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, -1)) > -1) {
                    ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).bottomMargin = dimensionPixelSize;
                }
            }
            obtainStyledAttributes.recycle();
        }
        setTitleVisibility(preferenceViewHolder.itemView, !TextUtils.isEmpty(getTitle()));
    }
}
