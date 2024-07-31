package com.takisoft.fix.support.p069v7.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.p008v4.view.ViewCompat;
import android.support.p011v7.preference.PreferenceGroup;
import android.support.p011v7.preference.PreferenceViewHolder;
import android.support.p011v7.preference.PreferenceViewHolderProxy;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.takisoft.fix.support.v7.preference.PreferenceGroupAdapter */
/* loaded from: classes2.dex */
class PreferenceGroupAdapter extends android.support.p011v7.preference.PreferenceGroupAdapter {
    protected Field fieldResId;
    protected Field fieldWidgetResId;
    protected List mPreferenceLayouts;

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        super(preferenceGroup);
        try {
            Field declaredField = android.support.p011v7.preference.PreferenceGroupAdapter.class.getDeclaredField("mPreferenceLayouts");
            declaredField.setAccessible(true);
            this.mPreferenceLayouts = (List) declaredField.get(this);
            getReflectionFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getReflectionFields() {
        try {
            Class<?> cls = Class.forName("android.support.v7.preference.PreferenceGroupAdapter$PreferenceLayout");
            this.fieldResId = cls.getDeclaredField("mResId");
            this.fieldWidgetResId = cls.getDeclaredField("mWidgetResId");
            this.fieldResId.setAccessible(true);
            this.fieldWidgetResId.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private int[] getReflectedIds(Object obj) {
        int[] iArr = new int[2];
        if (this.fieldResId == null || this.fieldWidgetResId == null) {
            getReflectionFields();
        }
        try {
            iArr[0] = ((Integer) this.fieldResId.get(obj)).intValue();
            iArr[1] = ((Integer) this.fieldWidgetResId.get(obj)).intValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException unused) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.support.p011v7.preference.PreferenceGroupAdapter, android.support.p011v7.widget.RecyclerView.Adapter
    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.onCreateViewHolder(viewGroup, i);
        }
        int[] reflectedIds = getReflectedIds(this.mPreferenceLayouts.get(i));
        if (reflectedIds[0] == 0 && reflectedIds[1] == 0) {
            return super.onCreateViewHolder(viewGroup, i);
        }
        int i2 = reflectedIds[0];
        int i3 = reflectedIds[1];
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, C2380R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(C2380R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = viewGroup.getContext().getResources().getDrawable(17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(i2, viewGroup, false);
        if (inflate.getBackground() == null) {
            int[] iArr = {ViewCompat.getPaddingStart(inflate), inflate.getPaddingTop(), ViewCompat.getPaddingEnd(inflate), inflate.getPaddingBottom()};
            if (Build.VERSION.SDK_INT < 16) {
                inflate.setBackgroundDrawable(drawable);
            } else {
                inflate.setBackground(drawable);
            }
            ViewCompat.setPaddingRelative(inflate, iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (i3 != 0) {
                from.inflate(i3, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolderProxy(inflate);
    }
}
