package com.facebook.share.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.g */
/* loaded from: classes.dex */
public class NativeDialogParameters {
    /* renamed from: a */
    public static Bundle m10026a(UUID uuid, ShareContent shareContent, boolean z) {
        Validate.m10469a(shareContent, "shareContent");
        Validate.m10469a(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return m10035a((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return m10029a(sharePhotoContent, ShareInternalUtility.m9949a(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return m10027a(shareVideoContent, ShareInternalUtility.m9947a(shareVideoContent, uuid), z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return m10030a(shareOpenGraphContent, ShareInternalUtility.m9940a(ShareInternalUtility.m9942a(uuid, shareOpenGraphContent), false), z);
            } catch (JSONException e) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            return m10034a(shareMediaContent, ShareInternalUtility.m9951a(shareMediaContent, uuid), z);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return m10037a(shareCameraEffectContent, ShareInternalUtility.m9952a(shareCameraEffectContent, uuid), z);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            return m10033a((ShareMessengerGenericTemplateContent) shareContent, z);
        } else {
            if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                return m10031a((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z);
            }
            if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                return m10032a((ShareMessengerMediaTemplateContent) shareContent, z);
            }
            if (shareContent instanceof ShareStoryContent) {
                ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
                return m10028a(shareStoryContent, ShareInternalUtility.m9939b(shareStoryContent, uuid), ShareInternalUtility.m9948a(shareStoryContent, uuid), z);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static Bundle m10037a(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z) {
        Bundle m10036a = m10036a(shareCameraEffectContent, z);
        Utility.m10543a(m10036a, "effect_id", shareCameraEffectContent.m9897a());
        if (bundle != null) {
            m10036a.putBundle("effect_textures", bundle);
        }
        try {
            JSONObject m10160a = CameraEffectJSONUtility.m10160a(shareCameraEffectContent.m9896b());
            if (m10160a != null) {
                Utility.m10543a(m10036a, "effect_arguments", m10160a.toString());
            }
            return m10036a;
        } catch (JSONException e) {
            throw new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + e.getMessage());
        }
    }

    /* renamed from: a */
    private static Bundle m10035a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle m10036a = m10036a((ShareContent) shareLinkContent, z);
        Utility.m10543a(m10036a, "TITLE", shareLinkContent.m9864b());
        Utility.m10543a(m10036a, "DESCRIPTION", shareLinkContent.m9865a());
        Utility.m10545a(m10036a, "IMAGE", shareLinkContent.m9863c());
        Utility.m10543a(m10036a, "QUOTE", shareLinkContent.m9862d());
        Utility.m10545a(m10036a, "MESSENGER_LINK", shareLinkContent.m9891h());
        Utility.m10545a(m10036a, "TARGET_DISPLAY", shareLinkContent.m9891h());
        return m10036a;
    }

    /* renamed from: a */
    private static Bundle m10029a(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle m10036a = m10036a(sharePhotoContent, z);
        m10036a.putStringArrayList("PHOTOS", new ArrayList<>(list));
        return m10036a;
    }

    /* renamed from: a */
    private static Bundle m10027a(ShareVideoContent shareVideoContent, String str, boolean z) {
        Bundle m10036a = m10036a(shareVideoContent, z);
        Utility.m10543a(m10036a, "TITLE", shareVideoContent.m9753b());
        Utility.m10543a(m10036a, "DESCRIPTION", shareVideoContent.m9754a());
        Utility.m10543a(m10036a, "VIDEO", str);
        return m10036a;
    }

    /* renamed from: a */
    private static Bundle m10034a(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        Bundle m10036a = m10036a(shareMediaContent, z);
        m10036a.putParcelableArrayList("MEDIA", new ArrayList<>(list));
        return m10036a;
    }

    /* renamed from: a */
    private static Bundle m10030a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle m10036a = m10036a(shareOpenGraphContent, z);
        Utility.m10543a(m10036a, "PREVIEW_PROPERTY_NAME", (String) ShareInternalUtility.m9945a(shareOpenGraphContent.m9814b()).second);
        Utility.m10543a(m10036a, "ACTION_TYPE", shareOpenGraphContent.m9815a().m9822a());
        Utility.m10543a(m10036a, "ACTION", jSONObject.toString());
        return m10036a;
    }

    /* renamed from: a */
    private static Bundle m10033a(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z) {
        Bundle m10036a = m10036a((ShareContent) shareMessengerGenericTemplateContent, z);
        try {
            MessengerShareContentUtility.m10057a(m10036a, shareMessengerGenericTemplateContent);
            return m10036a;
        } catch (JSONException e) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + e.getMessage());
        }
    }

    /* renamed from: a */
    private static Bundle m10031a(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z) {
        Bundle m10036a = m10036a((ShareContent) shareMessengerOpenGraphMusicTemplateContent, z);
        try {
            MessengerShareContentUtility.m10054a(m10036a, shareMessengerOpenGraphMusicTemplateContent);
            return m10036a;
        } catch (JSONException e) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + e.getMessage());
        }
    }

    /* renamed from: a */
    private static Bundle m10032a(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z) {
        Bundle m10036a = m10036a((ShareContent) shareMessengerMediaTemplateContent, z);
        try {
            MessengerShareContentUtility.m10055a(m10036a, shareMessengerMediaTemplateContent);
            return m10036a;
        } catch (JSONException e) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + e.getMessage());
        }
    }

    /* renamed from: a */
    private static Bundle m10028a(ShareStoryContent shareStoryContent, @Nullable Bundle bundle, @Nullable Bundle bundle2, boolean z) {
        Bundle m10036a = m10036a(shareStoryContent, z);
        if (bundle != null) {
            m10036a.putParcelable("bg_asset", bundle);
        }
        if (bundle2 != null) {
            m10036a.putParcelable("interactive_asset_uri", bundle2);
        }
        List<String> m9768c = shareStoryContent.m9768c();
        if (!Utility.m10520a(m9768c)) {
            m10036a.putStringArrayList("top_background_color_list", new ArrayList<>(m9768c));
        }
        Utility.m10543a(m10036a, "content_url", shareStoryContent.m9767d());
        return m10036a;
    }

    /* renamed from: a */
    private static Bundle m10036a(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility.m10545a(bundle, "LINK", shareContent.m9891h());
        Utility.m10543a(bundle, "PLACE", shareContent.m9889j());
        Utility.m10543a(bundle, "PAGE", shareContent.m9888k());
        Utility.m10543a(bundle, "REF", shareContent.m9887l());
        bundle.putBoolean("DATA_FAILURES_FATAL", z);
        List<String> m9890i = shareContent.m9890i();
        if (!Utility.m10520a(m9890i)) {
            bundle.putStringArrayList("FRIENDS", new ArrayList<>(m9890i));
        }
        ShareHashtag m9886m = shareContent.m9886m();
        if (m9886m != null) {
            Utility.m10543a(bundle, "HASHTAG", m9886m.m9873a());
        }
        return bundle;
    }
}
