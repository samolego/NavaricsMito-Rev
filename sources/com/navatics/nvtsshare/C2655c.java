package com.navatics.nvtsshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.navatics.common.fileprovidercompat.FileProviderCompat;
import com.tencent.p075mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.p075mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p075mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p075mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p075mm.opensdk.openapi.IWXAPI;
import com.tencent.p075mm.opensdk.openapi.WXAPIFactory;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* renamed from: com.navatics.nvtsshare.c */
/* loaded from: classes.dex */
public class NvtsShare {

    /* renamed from: a */
    private static Context f6083a;

    /* renamed from: b */
    private static IWXAPI f6084b;

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$b */
    /* loaded from: classes.dex */
    public static class C2044b {

        /* renamed from: a */
        String f6086a;

        /* renamed from: b */
        String f6087b;

        /* renamed from: c */
        String f6088c;

        /* renamed from: a */
        public C2044b m6600a(String str) {
            this.f6086a = str;
            return this;
        }

        /* renamed from: b */
        public C2044b m6599b(String str) {
            this.f6087b = str;
            return this;
        }

        /* renamed from: c */
        public C2044b m6598c(String str) {
            this.f6088c = str;
            return this;
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2043a implements ISharePlatform {

        /* renamed from: a */
        private Activity f6085a;

        /* renamed from: a */
        public AbstractC2043a m6602a(Activity activity) {
            this.f6085a = activity;
            return this;
        }

        /* renamed from: b */
        public Activity m6601b() {
            return this.f6085a;
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$h */
    /* loaded from: classes.dex */
    private static class C2051h {

        /* renamed from: a */
        C2055l f6098a;

        C2051h(C2055l c2055l) {
            this.f6098a = c2055l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$g */
    /* loaded from: classes.dex */
    public static class C2050g implements ICanShareImage {

        /* renamed from: a */
        C2055l f6097a;

        C2050g(C2055l c2055l) {
            this.f6097a = c2055l;
        }

        /* renamed from: a */
        public ICanShareImage m6595a(String str) {
            if (this.f6097a.f6105c == null) {
                this.f6097a.f6105c = new C2056m(str);
                return this;
            }
            throw new RuntimeException("Already has image in it");
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$i */
    /* loaded from: classes.dex */
    private static class C2052i {

        /* renamed from: a */
        C2055l f6099a;

        C2052i(C2055l c2055l) {
            this.f6099a = c2055l;
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2045c extends AbstractC2043a implements ICanShareImage {

        /* renamed from: a */
        C2051h f6089a;

        /* renamed from: b */
        C2050g f6090b;

        AbstractC2045c(C2055l c2055l) {
            this.f6089a = new C2051h(c2055l);
            this.f6090b = new C2050g(c2055l);
        }

        /* renamed from: a */
        public AbstractC2045c m6597a(String str) {
            this.f6090b.m6595a(str);
            return this;
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2046d extends AbstractC2043a implements ICanShareImage {

        /* renamed from: a */
        C2052i f6091a;

        /* renamed from: b */
        C2050g f6092b;

        AbstractC2046d(C2055l c2055l) {
            this.f6091a = new C2052i(c2055l);
            this.f6092b = new C2050g(c2055l);
        }

        /* renamed from: a */
        public AbstractC2046d m6596a(String str) {
            this.f6092b.m6595a(str);
            return this;
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$k */
    /* loaded from: classes.dex */
    public static class C2054k extends AbstractC2045c {

        /* renamed from: c */
        C2055l f6101c;

        /* renamed from: d */
        int f6102d;

        C2054k(C2055l c2055l) {
            super(c2055l);
            this.f6102d = 0;
            this.f6101c = c2055l;
        }

        @Override // com.navatics.nvtsshare.ISharePlatform
        /* renamed from: a */
        public void mo6594a() {
            if (!NvtsShare.f6084b.isWXAppInstalled() && !NvtsShare.m6607b(NvtsShare.f6083a, "com.tencent.wechat") && !NvtsShare.m6608b(NvtsShare.f6083a)) {
                Toast.makeText(NvtsShare.f6083a, NvtsShare.f6083a.getString(R.string.wechat_not_installed), 0).show();
            } else if (C2057d.m6585a(this.f6101c.f6106d)) {
                if (this.f6101c.f6105c != null && this.f6101c.f6105c.m6586c()) {
                    String str = this.f6101c.f6105c.f6108a;
                    if (new File(str).exists()) {
                        WXImageObject wXImageObject = new WXImageObject();
                        wXImageObject.setImagePath(str);
                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                        wXMediaMessage.mediaObject = wXImageObject;
                        wXMediaMessage.thumbData = NvtsShare.m6605b(BitmapFactory.decodeFile(str), 32000);
                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        req.transaction = m6593b("img");
                        req.message = wXMediaMessage;
                        req.scene = this.f6102d;
                        NvtsShare.f6084b.sendReq(req);
                        return;
                    }
                    return;
                }
                WXTextObject wXTextObject = new WXTextObject();
                wXTextObject.text = this.f6101c.f6104b;
                WXMediaMessage wXMediaMessage2 = new WXMediaMessage();
                wXMediaMessage2.mediaObject = wXTextObject;
                wXMediaMessage2.description = this.f6101c.f6104b;
                SendMessageToWX.Req req2 = new SendMessageToWX.Req();
                req2.transaction = m6593b("text");
                req2.message = wXMediaMessage2;
                req2.scene = this.f6102d;
                NvtsShare.f6084b.sendReq(req2);
            }
        }

        /* renamed from: b */
        private String m6593b(String str) {
            if (str == null) {
                return String.valueOf(System.currentTimeMillis());
            }
            return str + System.currentTimeMillis();
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$j */
    /* loaded from: classes.dex */
    public static class C2053j extends AbstractC2045c {

        /* renamed from: c */
        C2055l f6100c;

        C2053j(C2055l c2055l) {
            super(c2055l);
            this.f6100c = c2055l;
        }

        @Override // com.navatics.nvtsshare.ISharePlatform
        /* renamed from: a */
        public void mo6594a() {
            if (!NvtsShare.m6607b(NvtsShare.f6083a, "com.twitter.android")) {
                Toast.makeText(NvtsShare.f6083a, "Twitter not installed", 0).show();
            } else if (C2057d.m6585a(this.f6100c.f6106d)) {
                if (this.f6100c.f6105c != null && this.f6100c.f6105c.m6586c()) {
                    TweetComposer.C2714a m4171a = new TweetComposer.C2714a(this.f6100c.f6103a).m4171a(this.f6100c.f6105c.m6588a().m6587b());
                    if (!C2057d.m6585a(this.f6100c.f6104b)) {
                        m4171a.m4170a(this.f6100c.f6104b);
                    }
                    m4171a.m4166d();
                    return;
                }
                try {
                    new TweetComposer.C2714a(this.f6100c.f6103a).m4169a(new URL("https://www.google.com/")).m4166d();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$f */
    /* loaded from: classes.dex */
    public static class C2049f extends AbstractC2046d {

        /* renamed from: c */
        C2055l f6096c;

        C2049f(C2055l c2055l) {
            super(c2055l);
            this.f6096c = c2055l;
        }

        @Override // com.navatics.nvtsshare.ISharePlatform
        /* renamed from: a */
        public void mo6594a() {
            if (!NvtsShare.m6607b(NvtsShare.f6083a, "com.instagram.android")) {
                Toast.makeText(NvtsShare.f6083a, "Instagram not installed", 0).show();
            } else if (!C2057d.m6585a(this.f6096c.f6106d)) {
                NvtsShare.m6603d(this.f6096c.f6103a, "video/*", this.f6096c.f6106d);
            } else if (this.f6096c.f6105c == null || !this.f6096c.f6105c.m6586c()) {
            } else {
                NvtsShare.m6604c(this.f6096c.f6103a, "image/*", this.f6096c.f6105c.f6108a);
            }
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$e */
    /* loaded from: classes.dex */
    public static class C2047e extends AbstractC2046d {

        /* renamed from: c */
        C2055l f6093c;

        C2047e(C2055l c2055l) {
            super(c2055l);
            this.f6093c = c2055l;
        }

        @Override // com.navatics.nvtsshare.ISharePlatform
        /* renamed from: a */
        public void mo6594a() {
            if (!NvtsShare.m6607b(NvtsShare.f6083a, "com.facebook.katana")) {
                Toast.makeText(NvtsShare.f6083a, "Facebook not installed", 0).show();
            } else if (C2057d.m6585a(this.f6093c.f6106d) && this.f6093c.f6105c != null && this.f6093c.f6105c.m6586c()) {
                final Activity b = m6601b();
                if (b == null) {
                    Toast.makeText(NvtsShare.f6083a, "Internal error : no activity", 0).show();
                    return;
                }
                String str = this.f6093c.f6105c.f6108a;
                if (new File(str).exists()) {
                    SharePhotoContent m9778a = new SharePhotoContent.C1121a().m9776a(new SharePhoto.C1119a().m9795a(BitmapFactory.decodeFile(str)).m9785c()).m9778a();
                    ShareDialog shareDialog = new ShareDialog(b);
                    if (!shareDialog.m10720a((ShareDialog) m9778a)) {
                        Toast.makeText(b, "Internal Error : canShow", 0).show();
                        return;
                    }
                    shareDialog.m10721a(CallbackManager.C0912a.m10886a(), (FacebookCallback) new FacebookCallback<Object>() { // from class: com.navatics.nvtsshare.c.e.1
                    });
                    shareDialog.m9711a((ShareContent) m9778a, ShareDialog.Mode.AUTOMATIC);
                }
            }
        }
    }

    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$l */
    /* loaded from: classes.dex */
    public static class C2055l {

        /* renamed from: a */
        Context f6103a;

        /* renamed from: b */
        String f6104b;

        /* renamed from: c */
        C2056m f6105c;

        /* renamed from: d */
        String f6106d;

        /* renamed from: e */
        ISharePlatform f6107e;

        C2055l(Context context) {
            this.f6103a = context;
        }

        /* renamed from: a */
        public C2054k m6592a() {
            this.f6107e = new C2054k(this);
            return (C2054k) this.f6107e;
        }

        /* renamed from: b */
        public C2053j m6591b() {
            this.f6107e = new C2053j(this);
            return (C2053j) this.f6107e;
        }

        /* renamed from: c */
        public C2049f m6590c() {
            this.f6107e = new C2049f(this);
            return (C2049f) this.f6107e;
        }

        /* renamed from: d */
        public C2047e m6589d() {
            this.f6107e = new C2047e(this);
            return (C2047e) this.f6107e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvtsShare.java */
    /* renamed from: com.navatics.nvtsshare.c$m */
    /* loaded from: classes.dex */
    public static class C2056m {

        /* renamed from: a */
        String f6108a;

        /* renamed from: b */
        Uri f6109b;

        /* renamed from: c */
        Bitmap f6110c;

        /* renamed from: a */
        C2056m m6588a() {
            return this;
        }

        C2056m(String str) {
            this.f6108a = str;
        }

        /* renamed from: b */
        Uri m6587b() {
            return FileProviderCompat.m6871a(NvtsShare.f6083a, new File(this.f6108a));
        }

        /* renamed from: c */
        boolean m6586c() {
            return (C2057d.m6585a(this.f6108a) && this.f6109b == null && this.f6110c == null) ? false : true;
        }
    }

    /* renamed from: a */
    public static synchronized void m6613a(Context context, C2044b c2044b) {
        synchronized (NvtsShare.class) {
            f6083a = context;
            Twitter.m4262a(new TwitterConfig.C2693a(context).m4232a(new DefaultLogger(5)).m4233a(new TwitterAuthConfig(c2044b.f6087b, c2044b.f6088c)).m4231a(true).m4234a());
            f6084b = WXAPIFactory.createWXAPI(context, c2044b.f6086a, false);
            f6084b.registerApp(c2044b.f6086a);
        }
    }

    /* renamed from: a */
    public static C2055l m6614a(Context context) {
        return new C2055l(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m6604c(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.setType(str);
        intent.putExtra("android.intent.extra.STREAM", FileProviderCompat.m6871a(context, new File(str2)));
        intent.setPackage("com.instagram.android");
        context.startActivity(Intent.createChooser(intent, "Share to"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m6603d(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.setType(str);
        intent.putExtra("android.intent.extra.STREAM", FileProviderCompat.m6871a(context, new File(str2)));
        intent.setPackage("com.instagram.android");
        context.startActivity(Intent.createChooser(intent, "Share to"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m6607b(Context context, String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("pm list package -3").getInputStream()));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return false;
                }
            } while (!str.equals(readLine.substring(8, readLine.length())));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m6608b(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m6605b(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        for (int i2 = 100; byteArrayOutputStream.toByteArray().length > i && i2 != 10; i2 -= 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        }
        bitmap.recycle();
        return byteArrayOutputStream.toByteArray();
    }
}
