package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.model.ShareContent;

/* loaded from: classes.dex */
public abstract class ShareButtonBase extends FacebookButtonBase {

    /* renamed from: a */
    private ShareContent f2537a;

    /* renamed from: b */
    private int f2538b;

    /* renamed from: c */
    private boolean f2539c;

    protected abstract FacebookDialogBase<ShareContent, Object> getDialog();

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareButtonBase(Context context, AttributeSet attributeSet, int i, String str, String str2) {
        super(context, attributeSet, i, 0, str, str2);
        this.f2538b = 0;
        this.f2539c = false;
        this.f2538b = isInEditMode() ? 0 : getDefaultRequestCode();
        m9714a(false);
    }

    public ShareContent getShareContent() {
        return this.f2537a;
    }

    public void setShareContent(ShareContent shareContent) {
        this.f2537a = shareContent;
        if (this.f2539c) {
            return;
        }
        m9714a(m9717a());
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2539c = true;
    }

    @Override // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.f2538b;
    }

    protected void setRequestCode(int i) {
        if (FacebookSdk.m10884a(i)) {
            throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.f2538b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    /* renamed from: a */
    public void mo9716a(Context context, AttributeSet attributeSet, int i, int i2) {
        super.mo9716a(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    /* renamed from: a */
    protected boolean m9717a() {
        return getDialog().m10720a(getShareContent());
    }

    protected View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() { // from class: com.facebook.share.widget.ShareButtonBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareButtonBase.this.m11422a(view);
                ShareButtonBase.this.getDialog().mo10070b(ShareButtonBase.this.getShareContent());
            }
        };
    }

    /* renamed from: a */
    private void m9714a(boolean z) {
        setEnabled(z);
        this.f2539c = false;
    }
}
