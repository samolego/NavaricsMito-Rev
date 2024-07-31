package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.facebook.share.internal.f */
/* loaded from: classes.dex */
public class MessengerShareContentUtility {

    /* renamed from: a */
    public static final Pattern f2389a = Pattern.compile("^(.+)\\.(facebook\\.com)$");

    /* renamed from: a */
    public static void m10057a(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        m10056a(bundle, shareMessengerGenericTemplateContent.m9849c());
        Utility.m10544a(bundle, "MESSENGER_PLATFORM_CONTENT", m10049a(shareMessengerGenericTemplateContent));
    }

    /* renamed from: a */
    public static void m10054a(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        m10040b(bundle, shareMessengerOpenGraphMusicTemplateContent);
        Utility.m10544a(bundle, "MESSENGER_PLATFORM_CONTENT", m10045a(shareMessengerOpenGraphMusicTemplateContent));
    }

    /* renamed from: a */
    public static void m10055a(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        m10041b(bundle, shareMessengerMediaTemplateContent);
        Utility.m10544a(bundle, "MESSENGER_PLATFORM_CONTENT", m10046a(shareMessengerMediaTemplateContent));
    }

    /* renamed from: a */
    private static void m10056a(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        if (shareMessengerGenericTemplateElement.m9842e() != null) {
            m10058a(bundle, shareMessengerGenericTemplateElement.m9842e(), false);
        } else if (shareMessengerGenericTemplateElement.m9843d() != null) {
            m10058a(bundle, shareMessengerGenericTemplateElement.m9843d(), true);
        }
        Utility.m10545a(bundle, "IMAGE", shareMessengerGenericTemplateElement.m9844c());
        Utility.m10543a(bundle, "PREVIEW_TYPE", "DEFAULT");
        Utility.m10543a(bundle, "TITLE", shareMessengerGenericTemplateElement.m9846a());
        Utility.m10543a(bundle, "SUBTITLE", shareMessengerGenericTemplateElement.m9845b());
    }

    /* renamed from: b */
    private static void m10040b(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        m10058a(bundle, shareMessengerOpenGraphMusicTemplateContent.m9832b(), false);
        Utility.m10543a(bundle, "PREVIEW_TYPE", "OPEN_GRAPH");
        Utility.m10545a(bundle, "OPEN_GRAPH_URL", shareMessengerOpenGraphMusicTemplateContent.m9833a());
    }

    /* renamed from: b */
    private static void m10041b(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        m10058a(bundle, shareMessengerMediaTemplateContent.m9836d(), false);
        Utility.m10543a(bundle, "PREVIEW_TYPE", "DEFAULT");
        Utility.m10543a(bundle, "ATTACHMENT_ID", shareMessengerMediaTemplateContent.m9838b());
        if (shareMessengerMediaTemplateContent.m9837c() != null) {
            Utility.m10545a(bundle, m10059a(shareMessengerMediaTemplateContent.m9837c()), shareMessengerMediaTemplateContent.m9837c());
        }
        Utility.m10543a(bundle, IjkMediaMeta.IJKM_KEY_TYPE, m10047a(shareMessengerMediaTemplateContent.m9839a()));
    }

    /* renamed from: a */
    private static void m10058a(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (shareMessengerActionButton != null && (shareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
            m10053a(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
    }

    /* renamed from: a */
    private static void m10053a(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        String str;
        if (z) {
            str = Utility.m10546a(shareMessengerURLActionButton.m9829b());
        } else {
            str = shareMessengerURLActionButton.m9852a() + " - " + Utility.m10546a(shareMessengerURLActionButton.m9829b());
        }
        Utility.m10543a(bundle, "TARGET_DISPLAY", str);
        Utility.m10545a(bundle, "ITEM_URL", shareMessengerURLActionButton.m9829b());
    }

    /* renamed from: a */
    private static JSONObject m10049a(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        return new JSONObject().put("attachment", new JSONObject().put(IjkMediaMeta.IJKM_KEY_TYPE, "template").put("payload", new JSONObject().put("template_type", "generic").put("sharable", shareMessengerGenericTemplateContent.m9851a()).put("image_aspect_ratio", m10050a(shareMessengerGenericTemplateContent.m9850b())).put("elements", new JSONArray().put(m10048a(shareMessengerGenericTemplateContent.m9849c())))));
    }

    /* renamed from: a */
    private static JSONObject m10045a(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        return new JSONObject().put("attachment", new JSONObject().put(IjkMediaMeta.IJKM_KEY_TYPE, "template").put("payload", new JSONObject().put("template_type", "open_graph").put("elements", new JSONArray().put(m10038b(shareMessengerOpenGraphMusicTemplateContent)))));
    }

    /* renamed from: a */
    private static JSONObject m10046a(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        return new JSONObject().put("attachment", new JSONObject().put(IjkMediaMeta.IJKM_KEY_TYPE, "template").put("payload", new JSONObject().put("template_type", "media").put("elements", new JSONArray().put(m10039b(shareMessengerMediaTemplateContent)))));
    }

    /* renamed from: a */
    private static JSONObject m10048a(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.m9846a()).put("subtitle", shareMessengerGenericTemplateElement.m9845b()).put("image_url", Utility.m10546a(shareMessengerGenericTemplateElement.m9844c()));
        if (shareMessengerGenericTemplateElement.m9842e() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m10052a(shareMessengerGenericTemplateElement.m9842e()));
            put.put("buttons", jSONArray);
        }
        if (shareMessengerGenericTemplateElement.m9843d() != null) {
            put.put("default_action", m10051a(shareMessengerGenericTemplateElement.m9843d(), true));
        }
        return put;
    }

    /* renamed from: b */
    private static JSONObject m10038b(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        JSONObject put = new JSONObject().put("url", Utility.m10546a(shareMessengerOpenGraphMusicTemplateContent.m9833a()));
        if (shareMessengerOpenGraphMusicTemplateContent.m9832b() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m10052a(shareMessengerOpenGraphMusicTemplateContent.m9832b()));
            put.put("buttons", jSONArray);
        }
        return put;
    }

    /* renamed from: b */
    private static JSONObject m10039b(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        JSONObject put = new JSONObject().put("attachment_id", shareMessengerMediaTemplateContent.m9838b()).put("url", Utility.m10546a(shareMessengerMediaTemplateContent.m9837c())).put("media_type", m10047a(shareMessengerMediaTemplateContent.m9839a()));
        if (shareMessengerMediaTemplateContent.m9836d() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m10052a(shareMessengerMediaTemplateContent.m9836d()));
            put.put("buttons", jSONArray);
        }
        return put;
    }

    /* renamed from: a */
    private static JSONObject m10052a(ShareMessengerActionButton shareMessengerActionButton) throws JSONException {
        return m10051a(shareMessengerActionButton, false);
    }

    /* renamed from: a */
    private static JSONObject m10051a(ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            return m10042a((ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
        return null;
    }

    /* renamed from: a */
    private static JSONObject m10042a(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        return new JSONObject().put(IjkMediaMeta.IJKM_KEY_TYPE, "web_url").put("title", z ? null : shareMessengerURLActionButton.m9852a()).put("url", Utility.m10546a(shareMessengerURLActionButton.m9829b())).put("webview_height_ratio", m10044a(shareMessengerURLActionButton.m9826e())).put("messenger_extensions", shareMessengerURLActionButton.m9828c()).put("fallback_url", Utility.m10546a(shareMessengerURLActionButton.m9827d())).put("webview_share_button", m10043a(shareMessengerURLActionButton));
    }

    /* renamed from: a */
    private static String m10059a(Uri uri) {
        String host = uri.getHost();
        return (Utility.m10530a(host) || !f2389a.matcher(host).matches()) ? "IMAGE" : "uri";
    }

    /* renamed from: a */
    private static String m10044a(ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio) {
        if (webviewHeightRatio == null) {
            return "full";
        }
        switch (webviewHeightRatio) {
            case WebviewHeightRatioCompact:
                return "compact";
            case WebviewHeightRatioTall:
                return "tall";
            default:
                return "full";
        }
    }

    /* renamed from: a */
    private static String m10050a(ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio) {
        return (imageAspectRatio != null && C10771.f2391b[imageAspectRatio.ordinal()] == 1) ? "square" : "horizontal";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessengerShareContentUtility.java */
    /* renamed from: com.facebook.share.internal.f$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C10771 {

        /* renamed from: b */
        static final /* synthetic */ int[] f2391b;

        /* renamed from: c */
        static final /* synthetic */ int[] f2392c = new int[ShareMessengerMediaTemplateContent.MediaType.values().length];

        static {
            try {
                f2392c[ShareMessengerMediaTemplateContent.MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f2391b = new int[ShareMessengerGenericTemplateContent.ImageAspectRatio.values().length];
            try {
                f2391b[ShareMessengerGenericTemplateContent.ImageAspectRatio.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            f2390a = new int[ShareMessengerURLActionButton.WebviewHeightRatio.values().length];
            try {
                f2390a[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioCompact.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2390a[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioTall.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a */
    private static String m10047a(ShareMessengerMediaTemplateContent.MediaType mediaType) {
        return (mediaType != null && C10771.f2392c[mediaType.ordinal()] == 1) ? "video" : "image";
    }

    /* renamed from: a */
    private static String m10043a(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.m9825f()) {
            return "hide";
        }
        return null;
    }
}
