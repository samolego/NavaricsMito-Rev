package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.b */
/* loaded from: classes.dex */
public class LegacyNativeDialogParameters {
    /* renamed from: a */
    private static Bundle m10154a(ShareVideoContent shareVideoContent, boolean z) {
        return null;
    }

    /* renamed from: a */
    public static Bundle m10153a(UUID uuid, ShareContent shareContent, boolean z) {
        Validate.m10469a(shareContent, "shareContent");
        Validate.m10469a(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return m10157a((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return m10155a(sharePhotoContent, ShareInternalUtility.m9949a(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            return m10154a((ShareVideoContent) shareContent, z);
        } else {
            if (shareContent instanceof ShareOpenGraphContent) {
                ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
                try {
                    return m10156a(shareOpenGraphContent, ShareInternalUtility.m9942a(uuid, shareOpenGraphContent), z);
                } catch (JSONException e) {
                    throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    private static Bundle m10157a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle m10158a = m10158a((ShareContent) shareLinkContent, z);
        Utility.m10543a(m10158a, "com.facebook.platform.extra.TITLE", shareLinkContent.m9864b());
        Utility.m10543a(m10158a, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.m9865a());
        Utility.m10545a(m10158a, "com.facebook.platform.extra.IMAGE", shareLinkContent.m9863c());
        return m10158a;
    }

    /* renamed from: a */
    private static Bundle m10155a(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle m10158a = m10158a(sharePhotoContent, z);
        m10158a.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList<>(list));
        return m10158a;
    }

    /* renamed from: a */
    private static Bundle m10156a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle m10158a = m10158a(shareOpenGraphContent, z);
        Utility.m10543a(m10158a, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.m9814b());
        Utility.m10543a(m10158a, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.m9815a().m9822a());
        Utility.m10543a(m10158a, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return m10158a;
    }

    /* renamed from: a */
    private static Bundle m10158a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility.m10545a(bundle, "com.facebook.platform.extra.LINK", shareContent.m9891h());
        Utility.m10543a(bundle, "com.facebook.platform.extra.PLACE", shareContent.m9889j());
        Utility.m10543a(bundle, "com.facebook.platform.extra.REF", shareContent.m9887l());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
        List<String> m9890i = shareContent.m9890i();
        if (!Utility.m10520a(m9890i)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList<>(m9890i));
        }
        return bundle;
    }
}
