package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.R;
import com.facebook.share.model.ShareContent;

/* loaded from: classes.dex */
public final class DeviceShareButton extends FacebookButtonBase {

    /* renamed from: a */
    private ShareContent f2505a;

    /* renamed from: b */
    private int f2506b;

    /* renamed from: c */
    private boolean f2507c;

    /* renamed from: d */
    private DeviceShareDialog f2508d;

    public DeviceShareButton(Context context) {
        this(context, null, 0);
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DeviceShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.f2506b = 0;
        this.f2507c = false;
        this.f2508d = null;
        this.f2506b = isInEditMode() ? 0 : getDefaultRequestCode();
        m9745a(false);
    }

    public ShareContent getShareContent() {
        return this.f2505a;
    }

    public void setShareContent(ShareContent shareContent) {
        this.f2505a = shareContent;
        if (this.f2507c) {
            return;
        }
        m9745a(m9748a());
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f2507c = true;
    }

    @Override // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.f2506b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    /* renamed from: a */
    public void mo9716a(Context context, AttributeSet attributeSet, int i, int i2) {
        super.mo9716a(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return R.style.com_facebook_button_share;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    protected View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() { // from class: com.facebook.share.widget.DeviceShareButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceShareButton.this.m11422a(view);
                DeviceShareButton.this.getDialog().mo10070b(DeviceShareButton.this.getShareContent());
            }
        };
    }

    /* renamed from: a */
    private void m9745a(boolean z) {
        setEnabled(z);
        this.f2507c = false;
    }

    private void setRequestCode(int i) {
        if (FacebookSdk.m10884a(i)) {
            throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.f2506b = i;
    }

    /* renamed from: a */
    private boolean m9748a() {
        return new DeviceShareDialog(getActivity()).m10720a(getShareContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceShareDialog getDialog() {
        DeviceShareDialog deviceShareDialog = this.f2508d;
        if (deviceShareDialog != null) {
            return deviceShareDialog;
        }
        if (getFragment() != null) {
            this.f2508d = new DeviceShareDialog(getFragment());
        } else if (getNativeFragment() != null) {
            this.f2508d = new DeviceShareDialog(getNativeFragment());
        } else {
            this.f2508d = new DeviceShareDialog(getActivity());
        }
        return this.f2508d;
    }
}
