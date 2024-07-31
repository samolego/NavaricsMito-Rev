package com.twitter.sdk.android.tweetcomposer.internal.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class ObservableScrollView extends ScrollView {

    /* renamed from: a */
    InterfaceC2638a f8915a;

    /* renamed from: com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2638a {
        /* renamed from: a */
        void mo8643a(int i);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        InterfaceC2638a interfaceC2638a = this.f8915a;
        if (interfaceC2638a != null) {
            interfaceC2638a.mo8643a(i2);
        }
    }

    public void setScrollViewListener(InterfaceC2638a interfaceC2638a) {
        this.f8915a = interfaceC2638a;
    }
}