package com.facebook.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

/* renamed from: com.facebook.share.a */
/* loaded from: classes.dex */
public class DeviceShareDialog extends FacebookDialogBase<ShareContent, Object> {

    /* renamed from: b */
    private static final int f2255b = CallbackManagerImpl.RequestCodeOffset.DeviceShare.toRequestCode();

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: c */
    protected List<FacebookDialogBase<ShareContent, Object>.AbstractC0951a> mo9680c() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: d */
    protected AppCall mo9678d() {
        return null;
    }

    public DeviceShareDialog(Activity activity) {
        super(activity, f2255b);
    }

    public DeviceShareDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), f2255b);
    }

    public DeviceShareDialog(android.support.p008v4.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), f2255b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo10203a(ShareContent shareContent, Object obj) {
        return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo10201b(ShareContent shareContent, Object obj) {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (!(shareContent instanceof ShareLinkContent) && !(shareContent instanceof ShareOpenGraphContent)) {
            throw new FacebookException(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
        }
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.m10869h(), FacebookActivity.class);
        intent.setAction("DeviceShareDialogFragment");
        intent.putExtra("content", shareContent);
        m10722a(intent, m10723a());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: a */
    protected void mo9685a(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Object> facebookCallback) {
        callbackManagerImpl.m10819b(m10723a(), new CallbackManagerImpl.InterfaceC0921a() { // from class: com.facebook.share.a.1
        });
    }
}
