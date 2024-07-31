package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.NotificationCompat;
import com.facebook.FacebookCallback;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.share.widget.a */
/* loaded from: classes.dex */
public final class MessageDialog extends FacebookDialogBase<ShareContent, Object> {

    /* renamed from: b */
    private static final int f2564b = CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();

    /* renamed from: c */
    private boolean f2565c;

    /* renamed from: a */
    public static boolean m9683a(Class<? extends ShareContent> cls) {
        DialogFeature m9679c = m9679c(cls);
        return m9679c != null && DialogPresenter.m10728a(m9679c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageDialog(Activity activity, int i) {
        super(activity, i);
        this.f2565c = false;
        ShareInternalUtility.m9957a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageDialog(android.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    private MessageDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        this.f2565c = false;
        ShareInternalUtility.m9957a(i);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    /* renamed from: a */
    protected void mo9685a(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Object> facebookCallback) {
        ShareInternalUtility.m9956a(m10723a(), callbackManagerImpl, facebookCallback);
    }

    /* renamed from: e */
    public boolean m9677e() {
        return this.f2565c;
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
        arrayList.add(new C1143a());
        return arrayList;
    }

    /* compiled from: MessageDialog.java */
    /* renamed from: com.facebook.share.widget.a$a */
    /* loaded from: classes.dex */
    private class C1143a extends FacebookDialogBase<ShareContent, Object>.AbstractC0951a {
        private C1143a() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public boolean mo9673a(ShareContent shareContent, boolean z) {
            return shareContent != null && MessageDialog.m9683a((Class<? extends ShareContent>) shareContent.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.AbstractC0951a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AppCall mo9674a(final ShareContent shareContent) {
            ShareContentValidation.m10019a(shareContent);
            final AppCall mo9678d = MessageDialog.this.mo9678d();
            final boolean m9677e = MessageDialog.this.m9677e();
            MessageDialog.m9682b(MessageDialog.this.m10719b(), shareContent, mo9678d);
            DialogPresenter.m10731a(mo9678d, new DialogPresenter.InterfaceC0950a() { // from class: com.facebook.share.widget.a.a.1
                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: a */
                public Bundle mo9672a() {
                    return NativeDialogParameters.m10026a(mo9678d.m10788c(), shareContent, m9677e);
                }

                @Override // com.facebook.internal.DialogPresenter.InterfaceC0950a
                /* renamed from: b */
                public Bundle mo9671b() {
                    return LegacyNativeDialogParameters.m10153a(mo9678d.m10788c(), shareContent, m9677e);
                }
            }, MessageDialog.m9679c(shareContent.getClass()));
            return mo9678d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static DialogFeature m9679c(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (ShareMessengerGenericTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE;
        }
        if (ShareMessengerOpenGraphMusicTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE;
        }
        if (ShareMessengerMediaTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9682b(Context context, ShareContent shareContent, AppCall appCall) {
        String str;
        DialogFeature m9679c = m9679c(shareContent.getClass());
        if (m9679c == MessageDialogFeature.MESSAGE_DIALOG) {
            str = NotificationCompat.CATEGORY_STATUS;
        } else if (m9679c == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE) {
            str = "GenericTemplate";
        } else if (m9679c == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE) {
            str = "MediaTemplate";
        } else {
            str = m9679c == MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE ? "OpenGraphMusicTemplate" : "unknown";
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_content_type", str);
        bundle.putString("fb_share_dialog_content_uuid", appCall.m10788c().toString());
        bundle.putString("fb_share_dialog_content_page_id", shareContent.m9888k());
        internalAppEventsLogger.m11053b("fb_messenger_share_dialog_show", bundle);
    }
}
