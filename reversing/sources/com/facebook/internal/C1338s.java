package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.facebook.internal.s */
/* loaded from: classes.dex */
public final class NativeProtocol {

    /* renamed from: a */
    private static final String f2034a = "com.facebook.internal.s";

    /* renamed from: b */
    private static final List<AbstractC0977e> f2035b = m10578e();

    /* renamed from: c */
    private static final List<AbstractC0977e> f2036c = m10576f();

    /* renamed from: d */
    private static final Map<String, List<AbstractC0977e>> f2037d = m10575g();

    /* renamed from: e */
    private static final AtomicBoolean f2038e = new AtomicBoolean(false);

    /* renamed from: f */
    private static final List<Integer> f2039f = Arrays.asList(20170417, 20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0977e {

        /* renamed from: a */
        private TreeSet<Integer> f2040a;

        /* renamed from: a */
        protected abstract String mo10566a();

        /* renamed from: b */
        protected abstract String mo10565b();

        private AbstractC0977e() {
        }

        /* renamed from: c */
        public TreeSet<Integer> m10572c() {
            TreeSet<Integer> treeSet = this.f2040a;
            if (treeSet == null || treeSet.isEmpty()) {
                m10573a(false);
            }
            return this.f2040a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
            if (r0.f2040a.isEmpty() == false) goto L4;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void m10573a(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto Lf
                java.util.TreeSet<java.lang.Integer> r1 = r0.f2040a     // Catch: java.lang.Throwable -> L17
                if (r1 == 0) goto Lf
                java.util.TreeSet<java.lang.Integer> r1 = r0.f2040a     // Catch: java.lang.Throwable -> L17
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L17
                if (r1 == 0) goto L15
            Lf:
                java.util.TreeSet r1 = com.facebook.internal.NativeProtocol.m10594a(r0)     // Catch: java.lang.Throwable -> L17
                r0.f2040a = r1     // Catch: java.lang.Throwable -> L17
            L15:
                monitor-exit(r0)
                return
            L17:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.AbstractC0977e.m10573a(boolean):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$c */
    /* loaded from: classes.dex */
    public static class C0975c extends AbstractC0977e {
        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: a */
        protected String mo10566a() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: b */
        protected String mo10565b() {
            return "com.facebook.katana.ProxyAuth";
        }

        private C0975c() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$d */
    /* loaded from: classes.dex */
    public static class C0976d extends AbstractC0977e {
        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: a */
        protected String mo10566a() {
            return "com.facebook.orca";
        }

        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: b */
        protected String mo10565b() {
            return null;
        }

        private C0976d() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$g */
    /* loaded from: classes.dex */
    public static class C0979g extends AbstractC0977e {
        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: a */
        protected String mo10566a() {
            return "com.facebook.wakizashi";
        }

        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: b */
        protected String mo10565b() {
            return "com.facebook.katana.ProxyAuth";
        }

        private C0979g() {
            super();
        }
    }

    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$b */
    /* loaded from: classes.dex */
    private static class C0974b extends AbstractC0977e {
        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: a */
        protected String mo10566a() {
            return "com.facebook.lite";
        }

        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: b */
        protected String mo10565b() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        private C0974b() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$a */
    /* loaded from: classes.dex */
    public static class C0973a extends AbstractC0977e {
        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: a */
        protected String mo10566a() {
            return "com.facebook.arstudio.player";
        }

        @Override // com.facebook.internal.NativeProtocol.AbstractC0977e
        /* renamed from: b */
        protected String mo10565b() {
            return null;
        }

        private C0973a() {
            super();
        }
    }

    /* renamed from: e */
    private static List<AbstractC0977e> m10578e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0975c());
        arrayList.add(new C0979g());
        return arrayList;
    }

    /* renamed from: f */
    private static List<AbstractC0977e> m10576f() {
        ArrayList arrayList = new ArrayList(m10578e());
        arrayList.add(0, new C0973a());
        return arrayList;
    }

    /* renamed from: g */
    private static Map<String, List<AbstractC0977e>> m10575g() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0976d());
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", f2035b);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", f2035b);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", f2035b);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", f2035b);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", f2036c);
        hashMap.put("com.facebook.platform.action.request.SHARE_STORY", f2035b);
        return hashMap;
    }

    /* renamed from: a */
    static Intent m10602a(Context context, Intent intent, AbstractC0977e abstractC0977e) {
        ResolveInfo resolveActivity;
        if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || !FacebookSignatureValidator.m10709a(context, resolveActivity.activityInfo.packageName)) {
            return null;
        }
        return intent;
    }

    /* renamed from: b */
    static Intent m10587b(Context context, Intent intent, AbstractC0977e abstractC0977e) {
        ResolveInfo resolveService;
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null || !FacebookSignatureValidator.m10709a(context, resolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }

    /* renamed from: a */
    public static Intent m10600a(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        C0974b c0974b = new C0974b();
        return m10602a(context, m10593a(c0974b, str, collection, str2, z, z2, defaultAudience, str3, str4), c0974b);
    }

    /* renamed from: a */
    private static Intent m10593a(AbstractC0977e abstractC0977e, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        String mo10565b = abstractC0977e.mo10565b();
        if (mo10565b == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(abstractC0977e.mo10566a(), mo10565b).putExtra("client_id", str);
        putExtra.putExtra("facebook_sdk_version", FacebookSdk.m10867j());
        if (!Utility.m10520a(collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.m10530a(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra("response_type", "token,signed_request");
        putExtra.putExtra("return_scopes", "true");
        if (z2) {
            putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra("legacy_override", FacebookSdk.m10868i());
        putExtra.putExtra("auth_type", str4);
        return putExtra;
    }

    /* renamed from: b */
    public static Intent m10586b(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        for (AbstractC0977e abstractC0977e : f2035b) {
            Intent m10602a = m10602a(context, m10593a(abstractC0977e, str, collection, str2, z, z2, defaultAudience, str3, str4), abstractC0977e);
            if (m10602a != null) {
                return m10602a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static final int m10605a() {
        return f2039f.get(0).intValue();
    }

    /* renamed from: a */
    public static boolean m10604a(int i) {
        return f2039f.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    /* renamed from: a */
    public static Intent m10601a(Context context, String str, String str2, C0978f c0978f, Bundle bundle) {
        AbstractC0977e abstractC0977e;
        Intent m10602a;
        if (c0978f == null || (abstractC0977e = c0978f.f2041a) == null || (m10602a = m10602a(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(abstractC0977e.mo10566a()).addCategory("android.intent.category.DEFAULT"), abstractC0977e)) == null) {
            return null;
        }
        m10597a(m10602a, str, str2, c0978f.f2042b, bundle);
        return m10602a;
    }

    /* renamed from: a */
    public static void m10597a(Intent intent, String str, String str2, int i, Bundle bundle) {
        String m10865l = FacebookSdk.m10865l();
        String m10864m = FacebookSdk.m10864m();
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", str2).putExtra("com.facebook.platform.extra.APPLICATION_ID", m10865l);
        if (m10604a(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.m10543a(bundle2, "app_name", m10864m);
            intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
            return;
        }
        intent.putExtra("com.facebook.platform.protocol.CALL_ID", str);
        if (!Utility.m10530a(m10864m)) {
            intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", m10864m);
        }
        intent.putExtras(bundle);
    }

    /* renamed from: a */
    public static Intent m10598a(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID m10585b = m10585b(intent);
        if (m10585b == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", m10599a(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", m10585b.toString());
        if (facebookException != null) {
            bundle2.putBundle(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, m10595a(facebookException));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle != null) {
            intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        }
        return intent2;
    }

    /* renamed from: a */
    public static Intent m10603a(Context context) {
        for (AbstractC0977e abstractC0977e : f2035b) {
            Intent m10587b = m10587b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(abstractC0977e.mo10566a()).addCategory("android.intent.category.DEFAULT"), abstractC0977e);
            if (m10587b != null) {
                return m10587b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m10599a(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    /* renamed from: b */
    public static UUID m10585b(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        if (m10604a(m10599a(intent))) {
            Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (stringExtra != null) {
            try {
                return UUID.fromString(stringExtra);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static Bundle m10582c(Intent intent) {
        if (m10604a(m10599a(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        }
        return null;
    }

    /* renamed from: d */
    public static Bundle m10579d(Intent intent) {
        if (!m10604a(m10599a(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    /* renamed from: e */
    public static boolean m10577e(Intent intent) {
        Bundle m10582c = m10582c(intent);
        if (m10582c != null) {
            return m10582c.containsKey(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
        }
        return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }

    /* renamed from: a */
    public static FacebookException m10596a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (string != null && string.equalsIgnoreCase("UserCanceled")) {
            return new FacebookOperationCanceledException(string2);
        }
        return new FacebookException(string2);
    }

    /* renamed from: a */
    public static Bundle m10595a(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString("error_type", "UserCanceled");
        }
        return bundle;
    }

    /* renamed from: b */
    public static int m10588b(int i) {
        return m10591a(f2035b, new int[]{i}).m10568b();
    }

    /* renamed from: a */
    public static C0978f m10592a(String str, int[] iArr) {
        return m10591a(f2037d.get(str), iArr);
    }

    /* renamed from: a */
    private static C0978f m10591a(List<AbstractC0977e> list, int[] iArr) {
        m10589b();
        if (list == null) {
            return C0978f.m10571a();
        }
        for (AbstractC0977e abstractC0977e : list) {
            int m10590a = m10590a(abstractC0977e.m10572c(), m10605a(), iArr);
            if (m10590a != -1) {
                return C0978f.m10570a(abstractC0977e, m10590a);
            }
        }
        return C0978f.m10571a();
    }

    /* renamed from: b */
    public static void m10589b() {
        if (f2038e.compareAndSet(false, true)) {
            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.internal.s.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        for (AbstractC0977e abstractC0977e : NativeProtocol.f2035b) {
                            abstractC0977e.m10573a(true);
                        }
                    } finally {
                        NativeProtocol.f2038e.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static TreeSet<Integer> m10584b(AbstractC0977e abstractC0977e) {
        ProviderInfo providerInfo;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ContentResolver contentResolver = FacebookSdk.m10869h().getContentResolver();
        String[] strArr = {"version"};
        Uri m10581c = m10581c(abstractC0977e);
        Cursor cursor = null;
        try {
            try {
                providerInfo = FacebookSdk.m10869h().getPackageManager().resolveContentProvider(abstractC0977e.mo10566a() + ".provider.PlatformProvider", 0);
            } catch (RuntimeException e) {
                Log.e(f2034a, "Failed to query content resolver.", e);
                providerInfo = null;
            }
            if (providerInfo != null) {
                try {
                    cursor = contentResolver.query(m10581c, strArr, null, null, null);
                } catch (IllegalArgumentException | NullPointerException | SecurityException unused) {
                    Log.e(f2034a, "Failed to query content resolver.");
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("version"))));
                    }
                }
            }
            return treeSet;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: a */
    public static int m10590a(TreeSet<Integer> treeSet, int i, int[] iArr) {
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int length = iArr.length - 1;
        int i2 = -1;
        while (descendingIterator.hasNext()) {
            int intValue = descendingIterator.next().intValue();
            i2 = Math.max(i2, intValue);
            while (length >= 0 && iArr[length] > intValue) {
                length--;
            }
            if (length < 0) {
                return -1;
            }
            if (iArr[length] == intValue) {
                if (length % 2 == 0) {
                    return Math.min(i2, i);
                }
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: c */
    private static Uri m10581c(AbstractC0977e abstractC0977e) {
        return Uri.parse("content://" + abstractC0977e.mo10566a() + ".provider.PlatformProvider/versions");
    }

    /* compiled from: NativeProtocol.java */
    /* renamed from: com.facebook.internal.s$f */
    /* loaded from: classes.dex */
    public static class C0978f {

        /* renamed from: a */
        private AbstractC0977e f2041a;

        /* renamed from: b */
        private int f2042b;

        /* renamed from: a */
        public static C0978f m10570a(AbstractC0977e abstractC0977e, int i) {
            C0978f c0978f = new C0978f();
            c0978f.f2041a = abstractC0977e;
            c0978f.f2042b = i;
            return c0978f;
        }

        /* renamed from: a */
        public static C0978f m10571a() {
            C0978f c0978f = new C0978f();
            c0978f.f2042b = -1;
            return c0978f;
        }

        private C0978f() {
        }

        /* renamed from: b */
        public int m10568b() {
            return this.f2042b;
        }
    }
}
