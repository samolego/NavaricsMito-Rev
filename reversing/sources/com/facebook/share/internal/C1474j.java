package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.List;
import java.util.Locale;

/* renamed from: com.facebook.share.internal.j */
/* loaded from: classes.dex */
public class ShareContentValidation {

    /* renamed from: a */
    private static C1081b f2394a;

    /* renamed from: b */
    private static C1081b f2395b;

    /* renamed from: c */
    private static C1081b f2396c;

    /* renamed from: a */
    public static void m10019a(ShareContent shareContent) {
        m10018a(shareContent, m9997b());
    }

    /* renamed from: b */
    public static void m9995b(ShareContent shareContent) {
        m10018a(shareContent, m9997b());
    }

    /* renamed from: c */
    public static void m9979c(ShareContent shareContent) {
        m10018a(shareContent, m9980c());
    }

    /* renamed from: d */
    public static void m9977d(ShareContent shareContent) {
        m10018a(shareContent, m10021a());
    }

    /* renamed from: a */
    private static C1081b m10021a() {
        if (f2396c == null) {
            f2396c = new C1080a();
        }
        return f2396c;
    }

    /* renamed from: b */
    private static C1081b m9997b() {
        if (f2395b == null) {
            f2395b = new C1081b();
        }
        return f2395b;
    }

    /* renamed from: c */
    private static C1081b m9980c() {
        if (f2394a == null) {
            f2394a = new C1082c();
        }
        return f2394a;
    }

    /* renamed from: a */
    private static void m10018a(ShareContent shareContent, C1081b c1081b) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (shareContent instanceof ShareLinkContent) {
            c1081b.m9972a((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            c1081b.m9963a((SharePhotoContent) shareContent);
        } else if (shareContent instanceof ShareVideoContent) {
            c1081b.mo9958a((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            c1081b.m9966a((ShareOpenGraphContent) shareContent);
        } else if (shareContent instanceof ShareMediaContent) {
            c1081b.mo9960a((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            c1081b.m9973a((ShareCameraEffectContent) shareContent);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            c1081b.m9968a((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            c1081b.m9969a((ShareMessengerMediaTemplateContent) shareContent);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            c1081b.m9970a((ShareMessengerGenericTemplateContent) shareContent);
        } else if (shareContent instanceof ShareStoryContent) {
            c1081b.mo9962a((ShareStoryContent) shareContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9983b(ShareStoryContent shareStoryContent, C1081b c1081b) {
        if (shareStoryContent == null || (shareStoryContent.m9771a() == null && shareStoryContent.m9769b() == null)) {
            throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if (shareStoryContent.m9771a() != null) {
            c1081b.m9971a(shareStoryContent.m9771a());
        }
        if (shareStoryContent.m9769b() != null) {
            c1081b.mo9959a(shareStoryContent.m9769b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9994b(ShareLinkContent shareLinkContent, C1081b c1081b) {
        Uri m9863c = shareLinkContent.m9863c();
        if (m9863c != null && !Utility.m10507b(m9863c)) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9984b(SharePhotoContent sharePhotoContent, C1081b c1081b) {
        List<SharePhoto> m9781a = sharePhotoContent.m9781a();
        if (m9781a == null || m9781a.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        }
        if (m9781a.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
        }
        for (SharePhoto sharePhoto : m9781a) {
            c1081b.mo9959a(sharePhoto);
        }
    }

    /* renamed from: a */
    private static void m10005a(SharePhoto sharePhoto) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Bitmap m9802c = sharePhoto.m9802c();
        Uri m9801d = sharePhoto.m9801d();
        if (m9802c == null && m9801d == null) {
            throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
        }
    }

    /* renamed from: c */
    private static void m9978c(SharePhoto sharePhoto, C1081b c1081b) {
        m10005a(sharePhoto);
        Bitmap m9802c = sharePhoto.m9802c();
        Uri m9801d = sharePhoto.m9801d();
        if (m9802c == null && Utility.m10507b(m9801d) && !c1081b.m9974a()) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m9976d(SharePhoto sharePhoto, C1081b c1081b) {
        m9978c(sharePhoto, c1081b);
        if (sharePhoto.m9802c() == null && Utility.m10507b(sharePhoto.m9801d())) {
            return;
        }
        Validate.m10459d(FacebookSdk.m10869h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m9975e(SharePhoto sharePhoto, C1081b c1081b) {
        m10005a(sharePhoto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9981b(ShareVideoContent shareVideoContent, C1081b c1081b) {
        c1081b.m9961a(shareVideoContent.m9751d());
        SharePhoto m9752c = shareVideoContent.m9752c();
        if (m9752c != null) {
            c1081b.mo9959a(m9752c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9982b(ShareVideo shareVideo, C1081b c1081b) {
        if (shareVideo == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri m9763c = shareVideo.m9763c();
        if (m9763c == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        if (!Utility.m10498c(m9763c) && !Utility.m10491d(m9763c)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9993b(ShareMediaContent shareMediaContent, C1081b c1081b) {
        List<ShareMedia> m9855a = shareMediaContent.m9855a();
        if (m9855a == null || m9855a.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        }
        if (m9855a.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
        }
        for (ShareMedia shareMedia : m9855a) {
            c1081b.m9971a(shareMedia);
        }
    }

    /* renamed from: a */
    public static void m10016a(ShareMedia shareMedia, C1081b c1081b) {
        if (shareMedia instanceof SharePhoto) {
            c1081b.mo9959a((SharePhoto) shareMedia);
        } else if (shareMedia instanceof ShareVideo) {
            c1081b.m9961a((ShareVideo) shareMedia);
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", shareMedia.getClass().getSimpleName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9996b(ShareCameraEffectContent shareCameraEffectContent, C1081b c1081b) {
        if (Utility.m10530a(shareCameraEffectContent.m9897a())) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9988b(ShareOpenGraphContent shareOpenGraphContent, C1081b c1081b) {
        c1081b.m9967a(shareOpenGraphContent.m9815a());
        String m9814b = shareOpenGraphContent.m9814b();
        if (Utility.m10530a(m9814b)) {
            throw new FacebookException("Must specify a previewPropertyName.");
        }
        if (shareOpenGraphContent.m9815a().m9809a(m9814b) != null) {
            return;
        }
        throw new FacebookException("Property \"" + m9814b + "\" was not found on the action. The name of the preview property must match the name of an action property.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9989b(ShareOpenGraphAction shareOpenGraphAction, C1081b c1081b) {
        if (shareOpenGraphAction == null) {
            throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
        }
        if (Utility.m10530a(shareOpenGraphAction.m9822a())) {
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        }
        c1081b.m9964a(shareOpenGraphAction, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9987b(ShareOpenGraphObject shareOpenGraphObject, C1081b c1081b) {
        if (shareOpenGraphObject == null) {
            throw new FacebookException("Cannot share a null ShareOpenGraphObject");
        }
        c1081b.m9964a(shareOpenGraphObject, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9986b(ShareOpenGraphValueContainer shareOpenGraphValueContainer, C1081b c1081b, boolean z) {
        for (String str : shareOpenGraphValueContainer.m9806c()) {
            m9998a(str, z);
            Object m9809a = shareOpenGraphValueContainer.m9809a(str);
            if (m9809a instanceof List) {
                for (Object obj : (List) m9809a) {
                    if (obj == null) {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    m9999a(obj, c1081b);
                }
                continue;
            } else {
                m9999a(m9809a, c1081b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9990b(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        if (Utility.m10530a(shareMessengerOpenGraphMusicTemplateContent.m9888k())) {
            throw new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
        }
        if (shareMessengerOpenGraphMusicTemplateContent.m9833a() == null) {
            throw new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
        }
        m10014a(shareMessengerOpenGraphMusicTemplateContent.m9832b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9992b(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        if (Utility.m10530a(shareMessengerGenericTemplateContent.m9888k())) {
            throw new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
        }
        if (shareMessengerGenericTemplateContent.m9849c() == null) {
            throw new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
        }
        if (Utility.m10530a(shareMessengerGenericTemplateContent.m9849c().m9846a())) {
            throw new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
        }
        m10014a(shareMessengerGenericTemplateContent.m9849c().m9842e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9991b(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        if (Utility.m10530a(shareMessengerMediaTemplateContent.m9888k())) {
            throw new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
        }
        if (shareMessengerMediaTemplateContent.m9837c() == null && Utility.m10530a(shareMessengerMediaTemplateContent.m9838b())) {
            throw new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
        }
        m10014a(shareMessengerMediaTemplateContent.m9836d());
    }

    /* renamed from: a */
    private static void m10014a(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton == null) {
            return;
        }
        if (Utility.m10530a(shareMessengerActionButton.m9852a())) {
            throw new FacebookException("Must specify title for ShareMessengerActionButton");
        }
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            m10010a((ShareMessengerURLActionButton) shareMessengerActionButton);
        }
    }

    /* renamed from: a */
    private static void m10010a(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.m9829b() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* renamed from: a */
    private static void m9998a(String str, boolean z) {
        if (z) {
            String[] split = str.split(":");
            if (split.length < 2) {
                throw new FacebookException("Open Graph keys must be namespaced: %s", str);
            }
            for (String str2 : split) {
                if (str2.isEmpty()) {
                    throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m9999a(Object obj, C1081b c1081b) {
        if (obj instanceof ShareOpenGraphObject) {
            c1081b.m9965a((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            c1081b.mo9959a((SharePhoto) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareContentValidation.java */
    /* renamed from: com.facebook.share.internal.j$a */
    /* loaded from: classes.dex */
    public static class C1080a extends C1081b {
        private C1080a() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.C1081b
        /* renamed from: a */
        public void mo9962a(ShareStoryContent shareStoryContent) {
            ShareContentValidation.m9983b(shareStoryContent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareContentValidation.java */
    /* renamed from: com.facebook.share.internal.j$c */
    /* loaded from: classes.dex */
    public static class C1082c extends C1081b {
        private C1082c() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.C1081b
        /* renamed from: a */
        public void mo9958a(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.C1081b
        /* renamed from: a */
        public void mo9960a(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.C1081b
        /* renamed from: a */
        public void mo9959a(SharePhoto sharePhoto) {
            ShareContentValidation.m9975e(sharePhoto, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareContentValidation.java */
    /* renamed from: com.facebook.share.internal.j$b */
    /* loaded from: classes.dex */
    public static class C1081b {

        /* renamed from: a */
        private boolean f2397a;

        private C1081b() {
            this.f2397a = false;
        }

        /* renamed from: a */
        public void m9972a(ShareLinkContent shareLinkContent) {
            ShareContentValidation.m9994b(shareLinkContent, this);
        }

        /* renamed from: a */
        public void m9963a(SharePhotoContent sharePhotoContent) {
            ShareContentValidation.m9984b(sharePhotoContent, this);
        }

        /* renamed from: a */
        public void mo9958a(ShareVideoContent shareVideoContent) {
            ShareContentValidation.m9981b(shareVideoContent, this);
        }

        /* renamed from: a */
        public void mo9960a(ShareMediaContent shareMediaContent) {
            ShareContentValidation.m9993b(shareMediaContent, this);
        }

        /* renamed from: a */
        public void m9973a(ShareCameraEffectContent shareCameraEffectContent) {
            ShareContentValidation.m9996b(shareCameraEffectContent, this);
        }

        /* renamed from: a */
        public void m9966a(ShareOpenGraphContent shareOpenGraphContent) {
            this.f2397a = true;
            ShareContentValidation.m9988b(shareOpenGraphContent, this);
        }

        /* renamed from: a */
        public void m9967a(ShareOpenGraphAction shareOpenGraphAction) {
            ShareContentValidation.m9989b(shareOpenGraphAction, this);
        }

        /* renamed from: a */
        public void m9965a(ShareOpenGraphObject shareOpenGraphObject) {
            ShareContentValidation.m9987b(shareOpenGraphObject, this);
        }

        /* renamed from: a */
        public void m9964a(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            ShareContentValidation.m9986b(shareOpenGraphValueContainer, this, z);
        }

        /* renamed from: a */
        public void mo9959a(SharePhoto sharePhoto) {
            ShareContentValidation.m9976d(sharePhoto, this);
        }

        /* renamed from: a */
        public void m9961a(ShareVideo shareVideo) {
            ShareContentValidation.m9982b(shareVideo, this);
        }

        /* renamed from: a */
        public void m9971a(ShareMedia shareMedia) {
            ShareContentValidation.m10016a(shareMedia, this);
        }

        /* renamed from: a */
        public void m9968a(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            ShareContentValidation.m9990b(shareMessengerOpenGraphMusicTemplateContent);
        }

        /* renamed from: a */
        public void m9970a(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            ShareContentValidation.m9992b(shareMessengerGenericTemplateContent);
        }

        /* renamed from: a */
        public void m9969a(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            ShareContentValidation.m9991b(shareMessengerMediaTemplateContent);
        }

        /* renamed from: a */
        public void mo9962a(ShareStoryContent shareStoryContent) {
            ShareContentValidation.m9983b(shareStoryContent, this);
        }

        /* renamed from: a */
        public boolean m9974a() {
            return this.f2397a;
        }
    }
}
