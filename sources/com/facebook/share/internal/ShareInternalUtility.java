package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.facebook.share.internal.k */
/* loaded from: classes.dex */
public final class ShareInternalUtility {
    /* renamed from: a */
    public static void m9957a(final int i) {
        CallbackManagerImpl.m10820a(i, new CallbackManagerImpl.InterfaceC0921a() { // from class: com.facebook.share.internal.k.3
        });
    }

    /* renamed from: a */
    public static void m9956a(final int i, CallbackManager callbackManager, final FacebookCallback<Object> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).m10819b(i, new CallbackManagerImpl.InterfaceC0921a() { // from class: com.facebook.share.internal.k.4
        });
    }

    /* renamed from: a */
    public static List<String> m9949a(SharePhotoContent sharePhotoContent, final UUID uuid) {
        List<SharePhoto> m9781a;
        if (sharePhotoContent == null || (m9781a = sharePhotoContent.m9781a()) == null) {
            return null;
        }
        List m10519a = Utility.m10519a((List) m9781a, (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<SharePhoto, NativeAppCallAttachmentStore.C0971a>() { // from class: com.facebook.share.internal.k.5
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public NativeAppCallAttachmentStore.C0971a mo9923a(SharePhoto sharePhoto) {
                return ShareInternalUtility.m9938b(uuid, sharePhoto);
            }
        });
        List<String> m10519a2 = Utility.m10519a(m10519a, (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<NativeAppCallAttachmentStore.C0971a, String>() { // from class: com.facebook.share.internal.k.6
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public String mo9923a(NativeAppCallAttachmentStore.C0971a c0971a) {
                return c0971a.m10613a();
            }
        });
        NativeAppCallAttachmentStore.m10621a(m10519a);
        return m10519a2;
    }

    /* renamed from: a */
    public static String m9947a(ShareVideoContent shareVideoContent, UUID uuid) {
        if (shareVideoContent == null || shareVideoContent.m9751d() == null) {
            return null;
        }
        NativeAppCallAttachmentStore.C0971a m10619a = NativeAppCallAttachmentStore.m10619a(uuid, shareVideoContent.m9751d().m9763c());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(m10619a);
        NativeAppCallAttachmentStore.m10621a(arrayList);
        return m10619a.m10613a();
    }

    /* renamed from: a */
    public static List<Bundle> m9951a(ShareMediaContent shareMediaContent, final UUID uuid) {
        List<ShareMedia> m9855a;
        if (shareMediaContent == null || (m9855a = shareMediaContent.m9855a()) == null) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        List<Bundle> m10519a = Utility.m10519a((List) m9855a, (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<ShareMedia, Bundle>() { // from class: com.facebook.share.internal.k.7
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public Bundle mo9923a(ShareMedia shareMedia) {
                NativeAppCallAttachmentStore.C0971a m9938b = ShareInternalUtility.m9938b(uuid, shareMedia);
                arrayList.add(m9938b);
                Bundle bundle = new Bundle();
                bundle.putString(IjkMediaMeta.IJKM_KEY_TYPE, shareMedia.mo9764b().name());
                bundle.putString("uri", m9938b.m10613a());
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.m10621a(arrayList);
        return m10519a;
    }

    /* renamed from: a */
    public static Bundle m9952a(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        CameraEffectTextures m9895c;
        if (shareCameraEffectContent == null || (m9895c = shareCameraEffectContent.m9895c()) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : m9895c.m9909a()) {
            NativeAppCallAttachmentStore.C0971a m9944a = m9944a(uuid, m9895c.m9906b(str), m9895c.m9907a(str));
            arrayList.add(m9944a);
            bundle.putString(str, m9944a.m10613a());
        }
        NativeAppCallAttachmentStore.m10621a(arrayList);
        return bundle;
    }

    /* renamed from: a */
    public static JSONObject m9942a(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        Set m10495c;
        ShareOpenGraphAction m9815a = shareOpenGraphContent.m9815a();
        final ArrayList arrayList = new ArrayList();
        JSONObject m10025a = OpenGraphJSONUtility.m10025a(m9815a, new OpenGraphJSONUtility.InterfaceC1078a() { // from class: com.facebook.share.internal.k.8
            @Override // com.facebook.share.internal.OpenGraphJSONUtility.InterfaceC1078a
            /* renamed from: a */
            public JSONObject mo9931a(SharePhoto sharePhoto) {
                NativeAppCallAttachmentStore.C0971a m9938b = ShareInternalUtility.m9938b(uuid, sharePhoto);
                if (m9938b == null) {
                    return null;
                }
                arrayList.add(m9938b);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", m9938b.m10613a());
                    if (sharePhoto.m9800e()) {
                        jSONObject.put("user_generated", true);
                    }
                    return jSONObject;
                } catch (JSONException e) {
                    throw new FacebookException("Unable to attach images", e);
                }
            }
        });
        NativeAppCallAttachmentStore.m10621a(arrayList);
        if (shareOpenGraphContent.m9889j() != null && Utility.m10530a(m10025a.optString("place"))) {
            m10025a.put("place", shareOpenGraphContent.m9889j());
        }
        if (shareOpenGraphContent.m9890i() != null) {
            JSONArray optJSONArray = m10025a.optJSONArray("tags");
            if (optJSONArray == null) {
                m10495c = new HashSet();
            } else {
                m10495c = Utility.m10495c(optJSONArray);
            }
            for (String str : shareOpenGraphContent.m9890i()) {
                m10495c.add(str);
            }
            m10025a.put("tags", new JSONArray((Collection) m10495c));
        }
        return m10025a;
    }

    /* renamed from: a */
    public static JSONObject m9950a(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return OpenGraphJSONUtility.m10025a(shareOpenGraphContent.m9815a(), new OpenGraphJSONUtility.InterfaceC1078a() { // from class: com.facebook.share.internal.k.9
            @Override // com.facebook.share.internal.OpenGraphJSONUtility.InterfaceC1078a
            /* renamed from: a */
            public JSONObject mo9931a(SharePhoto sharePhoto) {
                Uri m9801d = sharePhoto.m9801d();
                if (!Utility.m10507b(m9801d)) {
                    throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", m9801d.toString());
                    return jSONObject;
                } catch (JSONException e) {
                    throw new FacebookException("Unable to attach images", e);
                }
            }
        });
    }

    /* renamed from: a */
    public static JSONArray m9941a(JSONArray jSONArray, boolean z) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = m9941a((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = m9940a((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        return jSONArray2;
    }

    /* renamed from: a */
    public static JSONObject m9940a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = m9940a((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    obj = m9941a((JSONArray) obj, true);
                }
                Pair<String, String> m9945a = m9945a(string);
                String str = (String) m9945a.first;
                String str2 = (String) m9945a.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject2.put(string, obj);
                    } else {
                        if (str != null && !str.equals("og")) {
                            jSONObject3.put(str2, obj);
                        }
                        jSONObject2.put(str2, obj);
                    }
                } else if (str != null && str.equals("fb")) {
                    jSONObject2.put(string, obj);
                } else {
                    jSONObject2.put(str2, obj);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    /* renamed from: a */
    public static Pair<String, String> m9945a(String str) {
        String str2;
        int i;
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || str.length() <= (i = indexOf + 1)) {
            str2 = null;
        } else {
            str2 = str.substring(0, indexOf);
            str = str.substring(i);
        }
        return new Pair<>(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static NativeAppCallAttachmentStore.C0971a m9938b(UUID uuid, ShareMedia shareMedia) {
        Uri m9763c;
        Bitmap bitmap = null;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.m9802c();
            m9763c = sharePhoto.m9801d();
        } else {
            m9763c = shareMedia instanceof ShareVideo ? ((ShareVideo) shareMedia).m9763c() : null;
        }
        return m9944a(uuid, m9763c, bitmap);
    }

    /* renamed from: a */
    private static NativeAppCallAttachmentStore.C0971a m9944a(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.m10620a(uuid, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.m10619a(uuid, uri);
        }
        return null;
    }

    /* renamed from: a */
    public static GraphRequest m9953a(AccessToken accessToken, File file, GraphRequest.InterfaceC0829b interfaceC0829b) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, interfaceC0829b);
    }

    /* renamed from: a */
    public static GraphRequest m9954a(AccessToken accessToken, Uri uri, GraphRequest.InterfaceC0829b interfaceC0829b) throws FileNotFoundException {
        if (Utility.m10491d(uri)) {
            return m9953a(accessToken, new File(uri.getPath()), interfaceC0829b);
        }
        if (!Utility.m10498c(uri)) {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        }
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, interfaceC0829b);
    }

    @Nullable
    /* renamed from: a */
    public static LikeView.ObjectType m9946a(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        if (objectType == LikeView.ObjectType.UNKNOWN) {
            return objectType2;
        }
        if (objectType2 == LikeView.ObjectType.UNKNOWN) {
            return objectType;
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    public static Bundle m9948a(ShareStoryContent shareStoryContent, final UUID uuid) {
        if (shareStoryContent == null || shareStoryContent.m9769b() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.m9769b());
        List m10519a = Utility.m10519a((List) arrayList, (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<SharePhoto, NativeAppCallAttachmentStore.C0971a>() { // from class: com.facebook.share.internal.k.10
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public NativeAppCallAttachmentStore.C0971a mo9923a(SharePhoto sharePhoto) {
                return ShareInternalUtility.m9938b(uuid, sharePhoto);
            }
        });
        List m10519a2 = Utility.m10519a(m10519a, (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<NativeAppCallAttachmentStore.C0971a, Bundle>() { // from class: com.facebook.share.internal.k.1
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public Bundle mo9923a(NativeAppCallAttachmentStore.C0971a c0971a) {
                Bundle bundle = new Bundle();
                bundle.putString("uri", c0971a.m10613a());
                String m9955a = ShareInternalUtility.m9955a(c0971a.m10611b());
                if (m9955a != null) {
                    Utility.m10543a(bundle, "extension", m9955a);
                }
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.m10621a(m10519a);
        return (Bundle) m10519a2.get(0);
    }

    @Nullable
    /* renamed from: b */
    public static Bundle m9939b(ShareStoryContent shareStoryContent, final UUID uuid) {
        if (shareStoryContent == null || shareStoryContent.m9771a() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.m9771a());
        final ArrayList arrayList2 = new ArrayList();
        List m10519a = Utility.m10519a((List) arrayList, (Utility.InterfaceC0985b) new Utility.InterfaceC0985b<ShareMedia, Bundle>() { // from class: com.facebook.share.internal.k.2
            @Override // com.facebook.internal.Utility.InterfaceC0985b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public Bundle mo9923a(ShareMedia shareMedia) {
                NativeAppCallAttachmentStore.C0971a m9938b = ShareInternalUtility.m9938b(uuid, shareMedia);
                arrayList2.add(m9938b);
                Bundle bundle = new Bundle();
                bundle.putString(IjkMediaMeta.IJKM_KEY_TYPE, shareMedia.mo9764b().name());
                bundle.putString("uri", m9938b.m10613a());
                String m9955a = ShareInternalUtility.m9955a(m9938b.m10611b());
                if (m9955a != null) {
                    Utility.m10543a(bundle, "extension", m9955a);
                }
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.m10621a(arrayList2);
        return (Bundle) m10519a.get(0);
    }

    @Nullable
    /* renamed from: a */
    public static String m9955a(Uri uri) {
        String uri2;
        int lastIndexOf;
        if (uri == null || (lastIndexOf = (uri2 = uri.toString()).lastIndexOf(46)) == -1) {
            return null;
        }
        return uri2.substring(lastIndexOf);
    }
}
