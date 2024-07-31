package com.navatics.app.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.navatics.app.widget.PreviewRoot;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ShadowView extends View {

    /* renamed from: a */
    private static final C3044k f5510a = C3044k.m1564a(ShadowView.class);

    /* renamed from: b */
    private View f5511b;

    public ShadowView(Context context) {
        super(context);
    }

    public ShadowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShadowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setRenderView(View view) {
        this.f5511b = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        String str = ((PreviewRoot.C1954b) getLayoutParams()).f5476a == 1 ? "ShadowTop : " : "ShadowBottom : ";
        setMeasuredDimension(resolveSizeAndState(this.f5511b.getMeasuredWidth(), i, 0), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        C3044k c3044k = f5510a;
        c3044k.mo1511a((Object) (str + "measuredWidth " + measuredWidth + ", measuredHeight " + measuredHeight));
    }
}
