package com.tencent.p075mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.p075mm.opensdk.utils.C2524d;
import com.tencent.p075mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.opensdk.modelmsg.WXMediaMessage */
/* loaded from: classes2.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 65536;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    /* renamed from: com.tencent.mm.opensdk.modelmsg.WXMediaMessage$Builder */
    /* loaded from: classes2.dex */
    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            String pathOldToNew = pathOldToNew(bundle.getString(KEY_IDENTIFIER));
            if (pathOldToNew != null && pathOldToNew.length() > 0) {
                try {
                    wXMediaMessage.mediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
                    wXMediaMessage.mediaObject.unserialize(bundle);
                    return wXMediaMessage;
                } catch (Exception e) {
                    Log.m5000e(WXMediaMessage.TAG, "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e.getMessage());
                }
            }
            return wXMediaMessage;
        }

        private static String pathNewToOld(String str) {
            if (str == null || str.length() == 0) {
                Log.m5000e(WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
                return str;
            }
            return str.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
        }

        private static String pathOldToNew(String str) {
            Log.m4999i(WXMediaMessage.TAG, "pathOldToNew, oldPath = " + str);
            if (str == null || str.length() == 0) {
                Log.m5000e(WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
                return str;
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                return "com.tencent.mm.opensdk.modelmsg" + str.substring(lastIndexOf);
            }
            Log.m5000e(WXMediaMessage.TAG, "pathOldToNew fail, invalid pos, oldPath = " + str);
            return str;
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, pathNewToOld(wXMediaMessage.mediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            return bundle;
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelmsg.WXMediaMessage$IMediaObject */
    /* loaded from: classes2.dex */
    public interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_BUSINESS_CARD = 45;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_OPENSDK_APPBRAND_WEISHIVIDEO = 46;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        if (getType() == 8 && ((bArr3 = this.thumbData) == null || bArr3.length == 0)) {
            str = TAG;
            str2 = "checkArgs fail, thumbData should not be null when send emoji";
        } else if (C2524d.m4992c(getType()) && ((bArr2 = this.thumbData) == null || bArr2.length > 131072)) {
            str = TAG;
            str2 = "checkArgs fail, thumbData should not be null or exceed 128kb";
        } else if (C2524d.m4992c(getType()) || (bArr = this.thumbData) == null || bArr.length <= 65536) {
            String str3 = this.title;
            if (str3 == null || str3.length() <= 512) {
                String str4 = this.description;
                if (str4 != null && str4.length() > 1024) {
                    str = TAG;
                    str2 = "checkArgs fail, description is invalid";
                } else if (this.mediaObject == null) {
                    str = TAG;
                    str2 = "checkArgs fail, mediaObject is null";
                } else {
                    String str5 = this.mediaTagName;
                    if (str5 == null || str5.length() <= 64) {
                        String str6 = this.messageAction;
                        if (str6 == null || str6.length() <= 2048) {
                            String str7 = this.messageExt;
                            if (str7 == null || str7.length() <= 2048) {
                                return this.mediaObject.checkArgs();
                            }
                            str = TAG;
                            str2 = "checkArgs fail, messageExt is too long";
                        } else {
                            str = TAG;
                            str2 = "checkArgs fail, messageAction is too long";
                        }
                    } else {
                        str = TAG;
                        str2 = "checkArgs fail, mediaTagName is too long";
                    }
                }
            } else {
                str = TAG;
                str2 = "checkArgs fail, title is invalid";
            }
        } else {
            str = TAG;
            str2 = "checkArgs fail, thumbData is invalid";
        }
        Log.m5000e(str, str2);
        return false;
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            Log.m5000e(TAG, "setThumbImage exception:" + e.getMessage());
        }
    }
}
