package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.NotificationCompat;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class ShareDialog extends FacebookDialogBase<ShareContent, Object> {

    /* renamed from: b */
    private static final String f2541b = "ShareDialog";

    /* renamed from: c */
    private static final int f2542c = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();

    /* renamed from: d */
    private boolean f2543d;

    /* renamed from: e */
    private boolean f2544e;

    /* loaded from: classes.dex */
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m9703c(Class<? extends ShareContent> cls) {
        DialogFeature m9700e = m9700e(cls);
        return m9700e != null && DialogPresenter.m10728a(m9700e);
    }

    /* renamed from: d */
    private static boolean m9702d(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.m11451b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m9707b(ShareContent shareContent) {
        if (m9702d(shareContent.getClass())) {
            if (shareContent instanceof ShareOpenGraphContent) {
                try {
                    ShareInternalUtility.m9950a((ShareOpenGraphContent) shareContent);
                    return true;
                } catch (Exception e) {
                    Utility.m10525a(f2541b, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", e);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public ShareDialog(Activity activity) {
        super(activity, f2542c);
        this.f2543d = false;
        this.f2544e = true;
        ShareInternalUtility.m9957a(f2542c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareDialog(Activity activity, int i) {
        super(activity, i);
        this.f2543d = false;
        this.f2544e = true;
        ShareInternalUtility.m9957a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareDialog(android.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    private ShareDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        this.f2543d = false;
        this.f2544e = true;
        ShareInternalUtility.m9957a(i);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: a */
    protected void mo9685a(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Object> facebookCallback) {
        ShareInternalUtility.m9956a(m10723a(), callbackManagerImpl, facebookCallback);
    }

    /* renamed from: e */
    public boolean m9701e() {
        return this.f2543d;
    }

    /* renamed from: a */
    public void m9711a(ShareContent shareContent, Mode mode) {
        this.f2544e = mode == Mode.AUTOMATIC;
        Mode mode2 = mode;
        if (this.f2544e) {
            mode2 = f1940a;
        }
        mo10201b(shareContent, mode2);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: d */
    protected AppCall mo9678d() {
        return new AppCall(m10723a());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: c */
    protected List<FacebookDialogBase<ShareContent, Object>.AbstractC0951a> mo9680c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1137c());
        arrayList.add(new C1136b());
        arrayList.add(new C1141e());
        arrayList.add(new C1134a());
        arrayList.add(new C1139d());
        return arrayList;
    }

    /* renamed from: com.facebook.share.widget.ShareDialog$c */
    /* loaded from: classes.dex */
    private class C1137c extends FacebookDialogBase<ShareContent, Object>.AbstractC0951a {
        private C1137c() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a */
        public Object mo9691a() {
            return Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(ShareContent shareContent, boolean z) {
            boolean z2;
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                return false;
            }
            if (z) {
                z2 = true;
            } else {
                z2 = shareContent.m9886m() != null ? DialogPresenter.m10728a(ShareDialogFeature.HASHTAG) : true;
                if ((shareContent instanceof ShareLinkContent) && !Utility.m10530a(((ShareLinkContent) shareContent).m9862d())) {
                    z2 &= DialogPresenter.m10728a(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            }
            return z2 && ShareDialog.m9703c((Class<? extends ShareContent>) shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(final ShareContent shareContent) {
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.m9713a(shareDialog.m10719b(), shareContent, Mode.NATIVE);
            ShareContentValidation.m9995b(shareContent);
            final AppCall mo9678d = ShareDialog.this.mo9678d();
            final boolean m9701e = ShareDialog.this.m9701e();
            DialogPresenter.m10731a(mo9678d, new DialogPresenter.InterfaceC0950a() { // from class: com.facebook.share.widget.ShareDialog.c.1
                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: a */
                public Bundle mo9672a() {
                    return NativeDialogParameters.m10026a(mo9678d.m10788c(), shareContent, m9701e);
                }

                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: b */
                public Bundle mo9671b() {
                    return LegacyNativeDialogParameters.m10153a(mo9678d.m10788c(), shareContent, m9701e);
                }
            }, ShareDialog.m9700e(shareContent.getClass()));
            return mo9678d;
        }
    }

    /* renamed from: com.facebook.share.widget.ShareDialog$e */
    /* loaded from: classes.dex */
    private class C1141e extends FacebookDialogBase<ShareContent, Object>.AbstractC0951a {
        private C1141e() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a */
        public Object mo9691a() {
            return Mode.WEB;
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(ShareContent shareContent, boolean z) {
            return shareContent != null && ShareDialog.m9707b(shareContent);
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(ShareContent shareContent) {
            Bundle m9927a;
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.m9713a(shareDialog.m10719b(), shareContent, Mode.WEB);
            AppCall mo9678d = ShareDialog.this.mo9678d();
            ShareContentValidation.m9979c(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                m9927a = WebDialogParameters.m9928a((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                m9927a = WebDialogParameters.m9926a(m9688a((SharePhotoContent) shareContent, mo9678d.m10788c()));
            } else {
                m9927a = WebDialogParameters.m9927a((ShareOpenGraphContent) shareContent);
            }
            DialogPresenter.m10729a(mo9678d, m9687b(shareContent), m9927a);
            return mo9678d;
        }

        /* renamed from: b */
        private String m9687b(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }

        /* renamed from: a */
        private SharePhotoContent m9688a(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.C1121a mo9777a = new SharePhotoContent.C1121a().mo9777a(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < sharePhotoContent.m9781a().size(); i++) {
                SharePhoto sharePhoto = sharePhotoContent.m9781a().get(i);
                Bitmap m9802c = sharePhoto.m9802c();
                if (m9802c != null) {
                    NativeAppCallAttachmentStore.C0971a m10620a = NativeAppCallAttachmentStore.m10620a(uuid, m9802c);
                    sharePhoto = new SharePhoto.C1119a().mo9758a(sharePhoto).m9794a(Uri.parse(m10620a.m10613a())).m9795a((Bitmap) null).m9785c();
                    arrayList2.add(m10620a);
                }
                arrayList.add(sharePhoto);
            }
            mo9777a.m9772c(arrayList);
            NativeAppCallAttachmentStore.m10621a(arrayList2);
            return mo9777a.m9778a();
        }
    }

    /* renamed from: com.facebook.share.widget.ShareDialog$b */
    /* loaded from: classes.dex */
    private class C1136b extends FacebookDialogBase<ShareContent, Object>.AbstractC0951a {
        private C1136b() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a */
        public Object mo9691a() {
            return Mode.FEED;
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(ShareContent shareContent) {
            Bundle m9930a;
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.m9713a(shareDialog.m10719b(), shareContent, Mode.FEED);
            AppCall mo9678d = ShareDialog.this.mo9678d();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                ShareContentValidation.m9979c(shareLinkContent);
                m9930a = WebDialogParameters.m9925b(shareLinkContent);
            } else {
                m9930a = WebDialogParameters.m9930a((ShareFeedContent) shareContent);
            }
            DialogPresenter.m10729a(mo9678d, "feed", m9930a);
            return mo9678d;
        }
    }

    /* renamed from: com.facebook.share.widget.ShareDialog$a */
    /* loaded from: classes.dex */
    private class C1134a extends FacebookDialogBase<ShareContent, Object>.AbstractC0951a {
        private C1134a() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a */
        public Object mo9691a() {
            return Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareCameraEffectContent) && ShareDialog.m9703c((Class<? extends ShareContent>) shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(final ShareContent shareContent) {
            ShareContentValidation.m9995b(shareContent);
            final AppCall mo9678d = ShareDialog.this.mo9678d();
            final boolean m9701e = ShareDialog.this.m9701e();
            DialogPresenter.m10731a(mo9678d, new DialogPresenter.InterfaceC0950a() { // from class: com.facebook.share.widget.ShareDialog.a.1
                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: a */
                public Bundle mo9672a() {
                    return NativeDialogParameters.m10026a(mo9678d.m10788c(), shareContent, m9701e);
                }

                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: b */
                public Bundle mo9671b() {
                    return LegacyNativeDialogParameters.m10153a(mo9678d.m10788c(), shareContent, m9701e);
                }
            }, ShareDialog.m9700e(shareContent.getClass()));
            return mo9678d;
        }
    }

    /* renamed from: com.facebook.share.widget.ShareDialog$d */
    /* loaded from: classes.dex */
    private class C1139d extends FacebookDialogBase<ShareContent, Object>.AbstractC0951a {
        private C1139d() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a */
        public Object mo9691a() {
            return Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareStoryContent) && ShareDialog.m9703c((Class<? extends ShareContent>) shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(final ShareContent shareContent) {
            ShareContentValidation.m9977d(shareContent);
            final AppCall mo9678d = ShareDialog.this.mo9678d();
            final boolean m9701e = ShareDialog.this.m9701e();
            DialogPresenter.m10731a(mo9678d, new DialogPresenter.InterfaceC0950a() { // from class: com.facebook.share.widget.ShareDialog.d.1
                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: a */
                public Bundle mo9672a() {
                    return NativeDialogParameters.m10026a(mo9678d.m10788c(), shareContent, m9701e);
                }

                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: b */
                public Bundle mo9671b() {
                    return LegacyNativeDialogParameters.m10153a(mo9678d.m10788c(), shareContent, m9701e);
                }
            }, ShareDialog.m9700e(shareContent.getClass()));
            return mo9678d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static DialogFeature m9700e(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            return CameraEffectFeature.SHARE_CAMERA_EFFECT;
        }
        if (ShareStoryContent.class.isAssignableFrom(cls)) {
            return ShareStoryFeature.SHARE_STORY_ASSET;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9713a(Context context, ShareContent shareContent, Mode mode) {
        String str;
        String str2;
        if (this.f2544e) {
            mode = Mode.AUTOMATIC;
        }
        switch (mode) {
            case AUTOMATIC:
                str = "automatic";
                break;
            case WEB:
                str = "web";
                break;
            case NATIVE:
                str = "native";
                break;
            default:
                str = "unknown";
                break;
        }
        DialogFeature m9700e = m9700e(shareContent.getClass());
        if (m9700e == ShareDialogFeature.SHARE_DIALOG) {
            str2 = NotificationCompat.CATEGORY_STATUS;
        } else if (m9700e == ShareDialogFeature.PHOTOS) {
            str2 = "photo";
        } else if (m9700e == ShareDialogFeature.VIDEO) {
            str2 = "video";
        } else {
            str2 = m9700e == OpenGraphActionDialogFeature.OG_ACTION_DIALOG ? "open_graph" : "unknown";
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString("fb_share_dialog_content_type", str2);
        internalAppEventsLogger.m11053b("fb_share_dialog_show", bundle);
    }
}
