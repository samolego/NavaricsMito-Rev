package com.facebook.share.internal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* renamed from: com.facebook.share.internal.d */
/* loaded from: classes.dex */
public class LikeDialog extends FacebookDialogBase<LikeContent, Object> {

    /* renamed from: b */
    private static final int f2379b = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();

    @Deprecated
    /* renamed from: e */
    public static boolean m10068e() {
        return false;
    }

    @Deprecated
    /* renamed from: f */
    public static boolean m10067f() {
        return false;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    @Deprecated
    /* renamed from: a */
    public void mo10070b(LikeContent likeContent) {
    }

    /* renamed from: g */
    static /* synthetic */ DialogFeature m10066g() {
        return m10065h();
    }

    @Deprecated
    public LikeDialog(Activity activity) {
        super(activity, f2379b);
    }

    @Deprecated
    public LikeDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, f2379b);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: d */
    protected AppCall mo9678d() {
        return new AppCall(m10723a());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: c */
    protected List<FacebookDialogBase<LikeContent, Object>.AbstractC0951a> mo9680c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1074a());
        arrayList.add(new C1076b());
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: a */
    protected void mo9685a(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Object> facebookCallback) {
        final ResultProcessor resultProcessor = facebookCallback == null ? null : new ResultProcessor(facebookCallback) { // from class: com.facebook.share.internal.d.1
        };
        callbackManagerImpl.m10819b(m10723a(), new CallbackManagerImpl.InterfaceC0921a() { // from class: com.facebook.share.internal.d.2
        });
    }

    /* compiled from: LikeDialog.java */
    /* renamed from: com.facebook.share.internal.d$a */
    /* loaded from: classes.dex */
    private class C1074a extends FacebookDialogBase<LikeContent, Object>.AbstractC0951a {
        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(LikeContent likeContent, boolean z) {
            return false;
        }

        private C1074a() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(final LikeContent likeContent) {
            AppCall mo9678d = LikeDialog.this.mo9678d();
            DialogPresenter.m10731a(mo9678d, new DialogPresenter.InterfaceC0950a() { // from class: com.facebook.share.internal.d.a.1
                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: a */
                public Bundle mo9672a() {
                    return LikeDialog.m10069c(likeContent);
                }

                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: b */
                public Bundle mo9671b() {
                    Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
                    return new Bundle();
                }
            }, LikeDialog.m10066g());
            return mo9678d;
        }
    }

    /* compiled from: LikeDialog.java */
    /* renamed from: com.facebook.share.internal.d$b */
    /* loaded from: classes.dex */
    private class C1076b extends FacebookDialogBase<LikeContent, Object>.AbstractC0951a {
        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(LikeContent likeContent, boolean z) {
            return false;
        }

        private C1076b() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(LikeContent likeContent) {
            AppCall mo9678d = LikeDialog.this.mo9678d();
            DialogPresenter.m10733a(mo9678d, LikeDialog.m10069c(likeContent), LikeDialog.m10066g());
            return mo9678d;
        }
    }

    /* renamed from: h */
    private static DialogFeature m10065h() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m10069c(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.m10178a());
        bundle.putString("object_type", likeContent.m10177b());
        return bundle;
    }
}
