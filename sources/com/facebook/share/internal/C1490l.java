package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.l */
/* loaded from: classes.dex */
public class WebDialogParameters {
    /* renamed from: a */
    public static Bundle m9928a(ShareLinkContent shareLinkContent) {
        Bundle m9929a = m9929a((ShareContent) shareLinkContent);
        Utility.m10545a(m9929a, "href", shareLinkContent.m9891h());
        Utility.m10543a(m9929a, "quote", shareLinkContent.m9862d());
        return m9929a;
    }

    /* renamed from: a */
    public static Bundle m9927a(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle m9929a = m9929a((ShareContent) shareOpenGraphContent);
        Utility.m10543a(m9929a, "action_type", shareOpenGraphContent.m9815a().m9822a());
        try {
            JSONObject m9940a = ShareInternalUtility.m9940a(ShareInternalUtility.m9950a(shareOpenGraphContent), false);
            if (m9940a != null) {
                Utility.m10543a(m9929a, "action_properties", m9940a.toString());
            }
            return m9929a;
        } catch (JSONException e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
        }
    }

    /* renamed from: a */
    public static Bundle m9926a(SharePhotoContent sharePhotoContent) {
        Bundle m9929a = m9929a((ShareContent) sharePhotoContent);
        String[] strArr = new String[sharePhotoContent.m9781a().size()];
        Utility.m10519a((List) sharePhotoContent.m9781a(), (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<SharePhoto, String>() { // from class: com.facebook.share.internal.l.1
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public String mo9923a(SharePhoto sharePhoto) {
                return sharePhoto.m9801d().toString();
            }
        }).toArray(strArr);
        m9929a.putStringArray("media", strArr);
        return m9929a;
    }

    /* renamed from: a */
    public static Bundle m9929a(ShareContent shareContent) {
        Bundle bundle = new Bundle();
        ShareHashtag m9886m = shareContent.m9886m();
        if (m9886m != null) {
            Utility.m10543a(bundle, "hashtag", m9886m.m9873a());
        }
        return bundle;
    }

    /* renamed from: b */
    public static Bundle m9925b(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        Utility.m10543a(bundle, "name", shareLinkContent.m9864b());
        Utility.m10543a(bundle, "description", shareLinkContent.m9865a());
        Utility.m10543a(bundle, "link", Utility.m10546a(shareLinkContent.m9891h()));
        Utility.m10543a(bundle, "picture", Utility.m10546a(shareLinkContent.m9863c()));
        Utility.m10543a(bundle, "quote", shareLinkContent.m9862d());
        if (shareLinkContent.m9886m() != null) {
            Utility.m10543a(bundle, "hashtag", shareLinkContent.m9886m().m9873a());
        }
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m9930a(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        Utility.m10543a(bundle, "to", shareFeedContent.m10169a());
        Utility.m10543a(bundle, "link", shareFeedContent.m10168b());
        Utility.m10543a(bundle, "picture", shareFeedContent.m10164f());
        Utility.m10543a(bundle, "source", shareFeedContent.m10163g());
        Utility.m10543a(bundle, "name", shareFeedContent.m10167c());
        Utility.m10543a(bundle, "caption", shareFeedContent.m10166d());
        Utility.m10543a(bundle, "description", shareFeedContent.m10165e());
        return bundle;
    }
}
