package com.twitter.sdk.android.tweetcomposer.internal.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class ObservableScrollView extends ScrollView {

    /* renamed from: a */
    InterfaceC2715a f8875a;

    /* renamed from: com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2715a {
        /* renamed from: a */
        void mo4165a(int i);
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
        InterfaceC2715a interfaceC2715a = this.f8875a;
        if (interfaceC2715a != null) {
            interfaceC2715a.mo4165a(i2);
        }
    }

    public void setScrollViewListener(InterfaceC2715a interfaceC2715a) {
        this.f8875a = interfaceC2715a;
    }
}
