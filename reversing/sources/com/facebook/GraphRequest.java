package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public class GraphRequest {

    /* renamed from: a */
    public static final String f1476a = "GraphRequest";

    /* renamed from: b */
    private static final String f1477b;

    /* renamed from: c */
    private static String f1478c;

    /* renamed from: d */
    private static Pattern f1479d = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");

    /* renamed from: r */
    private static volatile String f1480r;
    @Nullable

    /* renamed from: e */
    private AccessToken f1481e;

    /* renamed from: f */
    private HttpMethod f1482f;

    /* renamed from: g */
    private String f1483g;

    /* renamed from: h */
    private JSONObject f1484h;

    /* renamed from: i */
    private String f1485i;

    /* renamed from: j */
    private String f1486j;

    /* renamed from: k */
    private boolean f1487k;

    /* renamed from: l */
    private Bundle f1488l;

    /* renamed from: m */
    private InterfaceC0829b f1489m;

    /* renamed from: n */
    private String f1490n;

    /* renamed from: o */
    private Object f1491o;

    /* renamed from: p */
    private String f1492p;

    /* renamed from: q */
    private boolean f1493q;

    /* renamed from: com.facebook.GraphRequest$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0829b {
        /* renamed from: a */
        void mo10080a(GraphResponse graphResponse);
    }

    /* renamed from: com.facebook.GraphRequest$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0830c {
        /* renamed from: a */
        void m11334a(JSONObject jSONObject, GraphResponse graphResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.GraphRequest$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0831d {
        /* renamed from: a */
        void mo11327a(String str, String str2) throws IOException;
    }

    /* renamed from: com.facebook.GraphRequest$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0832e extends InterfaceC0829b {
        /* renamed from: a */
        void m11333a(long j, long j2);
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        f1477b = sb.toString();
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, InterfaceC0829b interfaceC0829b) {
        this(accessToken, str, bundle, httpMethod, interfaceC0829b, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, InterfaceC0829b interfaceC0829b, String str2) {
        this.f1487k = true;
        this.f1493q = false;
        this.f1481e = accessToken;
        this.f1483g = str;
        this.f1492p = str2;
        m11393a(interfaceC0829b);
        m11390a(httpMethod);
        if (bundle != null) {
            this.f1488l = new Bundle(bundle);
        } else {
            this.f1488l = new Bundle();
        }
        if (this.f1492p == null) {
            this.f1492p = FacebookSdk.m10868i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.GraphRequest$1 */
    /* loaded from: classes.dex */
    public static class C08231 implements InterfaceC0829b {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0830c f1494a;

        @Override // com.facebook.GraphRequest.InterfaceC0829b
        /* renamed from: a */
        public void mo10080a(GraphResponse graphResponse) {
            InterfaceC0830c interfaceC0830c = this.f1494a;
            if (interfaceC0830c != null) {
                interfaceC0830c.m11334a(graphResponse.m10824b(), graphResponse);
            }
        }
    }

    /* renamed from: a */
    public static GraphRequest m11394a(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, InterfaceC0829b interfaceC0829b) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, interfaceC0829b);
        graphRequest.m11375a(jSONObject);
        return graphRequest;
    }

    /* renamed from: a */
    public static GraphRequest m11395a(@Nullable AccessToken accessToken, String str, InterfaceC0829b interfaceC0829b) {
        return new GraphRequest(accessToken, str, null, null, interfaceC0829b);
    }

    /* renamed from: a */
    public final JSONObject m11398a() {
        return this.f1484h;
    }

    /* renamed from: a */
    public final void m11375a(JSONObject jSONObject) {
        this.f1484h = jSONObject;
    }

    /* renamed from: b */
    public final String m11371b() {
        return this.f1483g;
    }

    /* renamed from: c */
    public final HttpMethod m11364c() {
        return this.f1482f;
    }

    /* renamed from: a */
    public final void m11390a(HttpMethod httpMethod) {
        if (this.f1490n != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.f1482f = httpMethod;
    }

    /* renamed from: d */
    public final String m11361d() {
        return this.f1492p;
    }

    /* renamed from: a */
    public final void m11384a(String str) {
        this.f1492p = str;
    }

    /* renamed from: a */
    public final void m11373a(boolean z) {
        this.f1493q = z;
    }

    /* renamed from: e */
    public final Bundle m11358e() {
        return this.f1488l;
    }

    /* renamed from: a */
    public final void m11397a(Bundle bundle) {
        this.f1488l = bundle;
    }

    @Nullable
    /* renamed from: f */
    public final AccessToken m11355f() {
        return this.f1481e;
    }

    /* renamed from: g */
    public final InterfaceC0829b m11352g() {
        return this.f1489m;
    }

    /* renamed from: a */
    public final void m11393a(final InterfaceC0829b interfaceC0829b) {
        if (FacebookSdk.m10880a(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.m10880a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.f1489m = new InterfaceC0829b() { // from class: com.facebook.GraphRequest.2
                @Override // com.facebook.GraphRequest.InterfaceC0829b
                /* renamed from: a */
                public void mo10080a(GraphResponse graphResponse) {
                    JSONObject m10824b = graphResponse.m10824b();
                    JSONObject optJSONObject = m10824b != null ? m10824b.optJSONObject("__debug__") : null;
                    JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("messages") : null;
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            String optString = optJSONObject2 != null ? optJSONObject2.optString("message") : null;
                            String optString2 = optJSONObject2 != null ? optJSONObject2.optString(IjkMediaMeta.IJKM_KEY_TYPE) : null;
                            String optString3 = optJSONObject2 != null ? optJSONObject2.optString("link") : null;
                            if (optString != null && optString2 != null) {
                                LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (optString2.equals("warning")) {
                                    loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!Utility.m10530a(optString3)) {
                                    optString = optString + " Link: " + optString3;
                                }
                                Logger.m10634a(loggingBehavior, GraphRequest.f1476a, optString);
                            }
                        }
                    }
                    InterfaceC0829b interfaceC0829b2 = interfaceC0829b;
                    if (interfaceC0829b2 != null) {
                        interfaceC0829b2.mo10080a(graphResponse);
                    }
                }
            };
        } else {
            this.f1489m = interfaceC0829b;
        }
    }

    /* renamed from: a */
    public final void m11385a(Object obj) {
        this.f1491o = obj;
    }

    /* renamed from: h */
    public final Object m11350h() {
        return this.f1491o;
    }

    /* renamed from: i */
    public final GraphResponse m11349i() {
        return m11391a(this);
    }

    /* renamed from: j */
    public final GraphRequestAsyncTask m11348j() {
        return m11365b(this);
    }

    /* renamed from: a */
    public static HttpURLConnection m11389a(GraphRequestBatch graphRequestBatch) {
        URL url;
        m11360d(graphRequestBatch);
        try {
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.get(0).m11346l());
            } else {
                url = new URL(ServerProtocol.m10554b());
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = m11379a(url);
                m11387a(graphRequestBatch, httpURLConnection);
                return httpURLConnection;
            } catch (IOException | JSONException e) {
                Utility.m10522a(httpURLConnection);
                throw new FacebookException("could not construct request body", e);
            }
        } catch (MalformedURLException e2) {
            throw new FacebookException("could not construct URL for request", e2);
        }
    }

    /* renamed from: a */
    public static GraphResponse m11391a(GraphRequest graphRequest) {
        List<GraphResponse> m11372a = m11372a(graphRequest);
        if (m11372a == null || m11372a.size() != 1) {
            throw new FacebookException("invalid state: expected a single response");
        }
        return m11372a.get(0);
    }

    /* renamed from: a */
    public static List<GraphResponse> m11372a(GraphRequest... graphRequestArr) {
        Validate.m10469a(graphRequestArr, "requests");
        return m11378a((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    /* renamed from: a */
    public static List<GraphResponse> m11378a(Collection<GraphRequest> collection) {
        return m11369b(new GraphRequestBatch(collection));
    }

    /* renamed from: b */
    public static List<GraphResponse> m11369b(GraphRequestBatch graphRequestBatch) {
        Validate.m10460c(graphRequestBatch, "requests");
        try {
            try {
                HttpURLConnection m11389a = m11389a(graphRequestBatch);
                List<GraphResponse> m11381a = m11381a(m11389a, graphRequestBatch);
                Utility.m10522a(m11389a);
                return m11381a;
            } catch (Exception e) {
                List<GraphResponse> m10825a = GraphResponse.m10825a(graphRequestBatch.m10839d(), (HttpURLConnection) null, new FacebookException(e));
                m11386a(graphRequestBatch, m10825a);
                Utility.m10522a((URLConnection) null);
                return m10825a;
            }
        } catch (Throwable th) {
            Utility.m10522a((URLConnection) null);
            throw th;
        }
    }

    /* renamed from: b */
    public static GraphRequestAsyncTask m11365b(GraphRequest... graphRequestArr) {
        Validate.m10469a(graphRequestArr, "requests");
        return m11366b((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    /* renamed from: b */
    public static GraphRequestAsyncTask m11366b(Collection<GraphRequest> collection) {
        return m11363c(new GraphRequestBatch(collection));
    }

    /* renamed from: c */
    public static GraphRequestAsyncTask m11363c(GraphRequestBatch graphRequestBatch) {
        Validate.m10460c(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.m10871f(), new Void[0]);
        return graphRequestAsyncTask;
    }

    /* renamed from: a */
    public static List<GraphResponse> m11381a(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> m10827a = GraphResponse.m10827a(httpURLConnection, graphRequestBatch);
        Utility.m10522a(httpURLConnection);
        int size = graphRequestBatch.size();
        if (size != m10827a.size()) {
            throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", Integer.valueOf(m10827a.size()), Integer.valueOf(size)));
        }
        m11386a(graphRequestBatch, m10827a);
        AccessTokenManager.m10905a().m10892e();
        return m10827a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.f1481e;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.f1483g);
        sb.append(", graphObject: ");
        sb.append(this.f1484h);
        sb.append(", httpMethod: ");
        sb.append(this.f1482f);
        sb.append(", parameters: ");
        sb.append(this.f1488l);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    static void m11386a(final GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        int size = graphRequestBatch.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            InterfaceC0829b interfaceC0829b = graphRequestBatch.get(i).f1489m;
            if (interfaceC0829b != null) {
                arrayList.add(new Pair(interfaceC0829b, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable runnable = new Runnable() { // from class: com.facebook.GraphRequest.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((InterfaceC0829b) pair.first).mo10080a((GraphResponse) pair.second);
                    }
                    for (GraphRequestBatch.InterfaceC0919a interfaceC0919a : graphRequestBatch.m10838e()) {
                        interfaceC0919a.mo10082a(graphRequestBatch);
                    }
                }
            };
            Handler m10840c = graphRequestBatch.m10840c();
            if (m10840c == null) {
                runnable.run();
            } else {
                m10840c.post(runnable);
            }
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m11379a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", m11341q());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    /* renamed from: n */
    private void m11344n() {
        if (this.f1481e != null) {
            if (!this.f1488l.containsKey("access_token")) {
                String m11448d = this.f1481e.m11448d();
                Logger.m10632a(m11448d);
                this.f1488l.putString("access_token", m11448d);
            }
        } else if (!this.f1493q && !this.f1488l.containsKey("access_token")) {
            String m10865l = FacebookSdk.m10865l();
            String m10863n = FacebookSdk.m10863n();
            if (!Utility.m10530a(m10865l) && !Utility.m10530a(m10863n)) {
                this.f1488l.putString("access_token", m10865l + "|" + m10863n);
            } else {
                Utility.m10505b(f1476a, "Warning: Request without access token missing application ID or client token.");
            }
        }
        this.f1488l.putString("sdk", "android");
        this.f1488l.putString(IjkMediaMeta.IJKM_KEY_FORMAT, "json");
        if (FacebookSdk.m10880a(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.f1488l.putString("debug", "info");
        } else if (FacebookSdk.m10880a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.f1488l.putString("debug", "warning");
        }
    }

    /* renamed from: a */
    private String m11383a(String str, Boolean bool) {
        if (bool.booleanValue() || this.f1482f != HttpMethod.POST) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (String str2 : this.f1488l.keySet()) {
                Object obj = this.f1488l.get(str2);
                if (obj == null) {
                    obj = "";
                }
                if (!m11356e(obj)) {
                    if (this.f1482f == HttpMethod.GET) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
                    }
                } else {
                    buildUpon.appendQueryParameter(str2, m11353f(obj).toString());
                }
            }
            return buildUpon.toString();
        }
        return str;
    }

    /* renamed from: k */
    final String m11347k() {
        if (this.f1490n != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String format = String.format("%s/%s", ServerProtocol.m10554b(), m11343o());
        m11344n();
        Uri parse = Uri.parse(m11383a(format, (Boolean) true));
        return String.format("%s?%s", parse.getPath(), parse.getQuery());
    }

    /* renamed from: l */
    final String m11346l() {
        String m10554b;
        String str;
        String str2 = this.f1490n;
        if (str2 != null) {
            return str2.toString();
        }
        if (m11364c() == HttpMethod.POST && (str = this.f1483g) != null && str.endsWith("/videos")) {
            m10554b = ServerProtocol.m10553c();
        } else {
            m10554b = ServerProtocol.m10554b();
        }
        String format = String.format("%s/%s", m10554b, m11343o());
        m11344n();
        return m11383a(format, (Boolean) false);
    }

    /* renamed from: o */
    private String m11343o() {
        return f1479d.matcher(this.f1483g).matches() ? this.f1483g : String.format("%s/%s", this.f1492p, this.f1483g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.GraphRequest$a */
    /* loaded from: classes.dex */
    public static class C0828a {

        /* renamed from: a */
        private final GraphRequest f1503a;

        /* renamed from: b */
        private final Object f1504b;

        public C0828a(GraphRequest graphRequest, Object obj) {
            this.f1503a = graphRequest;
            this.f1504b = obj;
        }

        /* renamed from: a */
        public GraphRequest m11336a() {
            return this.f1503a;
        }

        /* renamed from: b */
        public Object m11335b() {
            return this.f1504b;
        }
    }

    /* renamed from: a */
    private void m11376a(JSONArray jSONArray, Map<String, C0828a> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f1485i;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put("omit_response_on_success", this.f1487k);
        }
        String str2 = this.f1486j;
        if (str2 != null) {
            jSONObject.put("depends_on", str2);
        }
        String m11347k = m11347k();
        jSONObject.put("relative_url", m11347k);
        jSONObject.put("method", this.f1482f);
        AccessToken accessToken = this.f1481e;
        if (accessToken != null) {
            Logger.m10632a(accessToken.m11448d());
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.f1488l.keySet()) {
            Object obj = this.f1488l.get(str3);
            if (m11359d(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", "file", Integer.valueOf(map.size()));
                arrayList.add(format);
                map.put(format, new C0828a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.f1484h != null) {
            final ArrayList arrayList2 = new ArrayList();
            m11374a(this.f1484h, m11347k, new InterfaceC0831d() { // from class: com.facebook.GraphRequest.4
                @Override // com.facebook.GraphRequest.InterfaceC0831d
                /* renamed from: a */
                public void mo11327a(String str4, String str5) throws IOException {
                    arrayList2.add(String.format(Locale.US, "%s=%s", str4, URLEncoder.encode(str5, "UTF-8")));
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    /* renamed from: e */
    private static boolean m11357e(GraphRequestBatch graphRequestBatch) {
        for (GraphRequestBatch.InterfaceC0919a interfaceC0919a : graphRequestBatch.m10838e()) {
            if (interfaceC0919a instanceof GraphRequestBatch.InterfaceC0920b) {
                return true;
            }
        }
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            if (it.next().m11352g() instanceof InterfaceC0832e) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m11380a(HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        httpURLConnection.setRequestProperty("Content-Type", m11342p());
    }

    /* renamed from: f */
    private static boolean m11354f(GraphRequestBatch graphRequestBatch) {
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            for (String str : next.f1488l.keySet()) {
                if (m11359d(next.f1488l.get(str))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    static final boolean m11370b(GraphRequest graphRequest) {
        String m11361d = graphRequest.m11361d();
        if (Utility.m10530a(m11361d)) {
            return true;
        }
        if (m11361d.startsWith("v")) {
            m11361d = m11361d.substring(1);
        }
        String[] split = m11361d.split("\\.");
        if (split.length < 2 || Integer.parseInt(split[0]) <= 2) {
            return Integer.parseInt(split[0]) >= 2 && Integer.parseInt(split[1]) >= 4;
        }
        return true;
    }

    /* renamed from: d */
    static final void m11360d(GraphRequestBatch graphRequestBatch) {
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            if (HttpMethod.GET.equals(next.m11364c()) && m11370b(next)) {
                Bundle m11358e = next.m11358e();
                if (!m11358e.containsKey("fields") || Utility.m10530a(m11358e.getString("fields"))) {
                    Logger.m10635a(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", next.m11371b());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final void m11387a(com.facebook.GraphRequestBatch r13, java.net.HttpURLConnection r14) throws java.io.IOException, org.json.JSONException {
        /*
            com.facebook.internal.q r6 = new com.facebook.internal.q
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.REQUESTS
            java.lang.String r1 = "Request"
            r6.<init>(r0, r1)
            int r2 = r13.size()
            boolean r5 = m11354f(r13)
            r0 = 0
            r1 = 1
            if (r2 != r1) goto L1c
            com.facebook.GraphRequest r3 = r13.get(r0)
            com.facebook.HttpMethod r3 = r3.f1482f
            goto L1e
        L1c:
            com.facebook.HttpMethod r3 = com.facebook.HttpMethod.POST
        L1e:
            java.lang.String r4 = r3.name()
            r14.setRequestMethod(r4)
            m11380a(r14, r5)
            java.net.URL r4 = r14.getURL()
            java.lang.String r7 = "Request:\n"
            r6.m10626c(r7)
            java.lang.String r7 = "Id"
            java.lang.String r8 = r13.m10843b()
            r6.m10631a(r7, r8)
            java.lang.String r7 = "URL"
            r6.m10631a(r7, r4)
            java.lang.String r7 = "Method"
            java.lang.String r8 = r14.getRequestMethod()
            r6.m10631a(r7, r8)
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = "User-Agent"
            java.lang.String r8 = r14.getRequestProperty(r8)
            r6.m10631a(r7, r8)
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "Content-Type"
            java.lang.String r8 = r14.getRequestProperty(r8)
            r6.m10631a(r7, r8)
            int r7 = r13.m10849a()
            r14.setConnectTimeout(r7)
            int r7 = r13.m10849a()
            r14.setReadTimeout(r7)
            com.facebook.HttpMethod r7 = com.facebook.HttpMethod.POST
            if (r3 != r7) goto L71
            r0 = 1
        L71:
            if (r0 != 0) goto L77
            r6.m10637a()
            return
        L77:
            r14.setDoOutput(r1)
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> Lca
            java.io.OutputStream r14 = r14.getOutputStream()     // Catch: java.lang.Throwable -> Lca
            r1.<init>(r14)     // Catch: java.lang.Throwable -> Lca
            if (r5 == 0) goto L8f
            java.util.zip.GZIPOutputStream r14 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L8c
            r14.<init>(r1)     // Catch: java.lang.Throwable -> L8c
            goto L90
        L8c:
            r13 = move-exception
            r14 = r1
            goto Lcc
        L8f:
            r14 = r1
        L90:
            boolean r0 = m11357e(r13)     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto Lba
            com.facebook.m r0 = new com.facebook.m     // Catch: java.lang.Throwable -> Lc8
            android.os.Handler r1 = r13.m10840c()     // Catch: java.lang.Throwable -> Lc8
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lc8
            r8 = 0
            r7 = r13
            r9 = r2
            r10 = r4
            r11 = r0
            r12 = r5
            m11388a(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lc8
            int r1 = r0.m10235a()     // Catch: java.lang.Throwable -> Lc8
            java.util.Map r10 = r0.m10233b()     // Catch: java.lang.Throwable -> Lc8
            com.facebook.n r0 = new com.facebook.n     // Catch: java.lang.Throwable -> Lc8
            long r11 = (long) r1     // Catch: java.lang.Throwable -> Lc8
            r7 = r0
            r8 = r14
            r9 = r13
            r7.<init>(r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lc8
            r14 = r0
        Lba:
            r0 = r13
            r1 = r6
            r3 = r4
            r4 = r14
            m11388a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lc8
            r14.close()
            r6.m10637a()
            return
        Lc8:
            r13 = move-exception
            goto Lcc
        Lca:
            r13 = move-exception
            r14 = r0
        Lcc:
            if (r14 == 0) goto Ld1
            r14.close()
        Ld1:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.m11387a(com.facebook.h, java.net.HttpURLConnection):void");
    }

    /* renamed from: a */
    private static void m11388a(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) throws IOException, JSONException {
        C0833f c0833f = new C0833f(outputStream, logger, z);
        if (i == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap hashMap = new HashMap();
            for (String str : graphRequest.f1488l.keySet()) {
                Object obj = graphRequest.f1488l.get(str);
                if (m11359d(obj)) {
                    hashMap.put(str, new C0828a(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.m10626c("  Parameters:\n");
            }
            m11396a(graphRequest.f1488l, c0833f, graphRequest);
            if (logger != null) {
                logger.m10626c("  Attachments:\n");
            }
            m11377a(hashMap, c0833f);
            JSONObject jSONObject = graphRequest.f1484h;
            if (jSONObject != null) {
                m11374a(jSONObject, url.getPath(), c0833f);
                return;
            }
            return;
        }
        String m11351g = m11351g(graphRequestBatch);
        if (Utility.m10530a(m11351g)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }
        c0833f.mo11327a("batch_app_id", m11351g);
        HashMap hashMap2 = new HashMap();
        m11392a(c0833f, graphRequestBatch, hashMap2);
        if (logger != null) {
            logger.m10626c("  Attachments:\n");
        }
        m11377a(hashMap2, c0833f);
    }

    /* renamed from: b */
    private static boolean m11367b(String str) {
        Matcher matcher = f1479d.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str.startsWith("me/") || str.startsWith("/me/");
    }

    /* renamed from: a */
    private static void m11374a(JSONObject jSONObject, String str, InterfaceC0831d interfaceC0831d) throws IOException {
        boolean z;
        if (m11367b(str)) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf(LocationInfo.f11272NA);
            z = indexOf > 3 && (indexOf2 == -1 || indexOf < indexOf2);
        } else {
            z = false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            m11382a(next, jSONObject.opt(next), interfaceC0831d, z && next.equalsIgnoreCase("image"));
        }
    }

    /* renamed from: a */
    private static void m11382a(String str, Object obj, InterfaceC0831d interfaceC0831d, boolean z) throws IOException {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    m11382a(String.format("%s[%s]", str, next), jSONObject.opt(next), interfaceC0831d, z);
                }
            } else if (jSONObject.has("id")) {
                m11382a(str, jSONObject.optString("id"), interfaceC0831d, z);
            } else if (jSONObject.has("url")) {
                m11382a(str, jSONObject.optString("url"), interfaceC0831d, z);
            } else if (jSONObject.has("fbsdk:create_object")) {
                m11382a(str, jSONObject.toString(), interfaceC0831d, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                m11382a(String.format(Locale.ROOT, "%s[%d]", str, Integer.valueOf(i)), jSONArray.opt(i), interfaceC0831d, z);
            }
        } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            interfaceC0831d.mo11327a(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            interfaceC0831d.mo11327a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
        }
    }

    /* renamed from: a */
    private static void m11396a(Bundle bundle, C0833f c0833f, GraphRequest graphRequest) throws IOException {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m11356e(obj)) {
                c0833f.m11328a(str, obj, graphRequest);
            }
        }
    }

    /* renamed from: a */
    private static void m11377a(Map<String, C0828a> map, C0833f c0833f) throws IOException {
        for (String str : map.keySet()) {
            C0828a c0828a = map.get(str);
            if (m11359d(c0828a.m11335b())) {
                c0833f.m11328a(str, c0828a.m11335b(), c0828a.m11336a());
            }
        }
    }

    /* renamed from: a */
    private static void m11392a(C0833f c0833f, Collection<GraphRequest> collection, Map<String, C0828a> map) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest graphRequest : collection) {
            graphRequest.m11376a(jSONArray, map);
        }
        c0833f.m11325a("batch", jSONArray, collection);
    }

    /* renamed from: p */
    private static String m11342p() {
        return String.format("multipart/form-data; boundary=%s", f1477b);
    }

    /* renamed from: q */
    private static String m11341q() {
        if (f1480r == null) {
            f1480r = String.format("%s.%s", "FBAndroidSDK", "5.13.0");
            String m10644a = InternalSettings.m10644a();
            if (!Utility.m10530a(m10644a)) {
                f1480r = String.format(Locale.ROOT, "%s/%s", f1480r, m10644a);
            }
        }
        return f1480r;
    }

    /* renamed from: g */
    private static String m11351g(GraphRequestBatch graphRequestBatch) {
        String m11440l;
        if (!Utility.m10530a(graphRequestBatch.m10837f())) {
            return graphRequestBatch.m10837f();
        }
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = it.next().f1481e;
            if (accessToken != null && (m11440l = accessToken.m11440l()) != null) {
                return m11440l;
            }
        }
        if (!Utility.m10530a(f1478c)) {
            return f1478c;
        }
        return FacebookSdk.m10865l();
    }

    /* renamed from: d */
    private static boolean m11359d(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m11356e(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static String m11353f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.GraphRequest$f */
    /* loaded from: classes.dex */
    public static class C0833f implements InterfaceC0831d {

        /* renamed from: a */
        private final OutputStream f1505a;

        /* renamed from: b */
        private final Logger f1506b;

        /* renamed from: c */
        private boolean f1507c = true;

        /* renamed from: d */
        private boolean f1508d;

        public C0833f(OutputStream outputStream, Logger logger, boolean z) {
            this.f1508d = false;
            this.f1505a = outputStream;
            this.f1506b = logger;
            this.f1508d = z;
        }

        /* renamed from: a */
        public void m11328a(String str, Object obj, GraphRequest graphRequest) throws IOException {
            OutputStream outputStream = this.f1505a;
            if (outputStream instanceof RequestOutputStream) {
                ((RequestOutputStream) outputStream).mo10227a(graphRequest);
            }
            if (GraphRequest.m11356e(obj)) {
                mo11327a(str, GraphRequest.m11353f(obj));
            } else if (obj instanceof Bitmap) {
                m11331a(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                m11324a(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                m11330a(str, (Uri) obj, (String) null);
            } else if (obj instanceof ParcelFileDescriptor) {
                m11329a(str, (ParcelFileDescriptor) obj, (String) null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable m11339b = parcelableResourceWithMimeType.m11339b();
                String m11340a = parcelableResourceWithMimeType.m11340a();
                if (m11339b instanceof ParcelFileDescriptor) {
                    m11329a(str, (ParcelFileDescriptor) m11339b, m11340a);
                } else if (m11339b instanceof Uri) {
                    m11330a(str, (Uri) m11339b, m11340a);
                } else {
                    throw m11322b();
                }
            } else {
                throw m11322b();
            }
        }

        /* renamed from: b */
        private RuntimeException m11322b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        /* renamed from: a */
        public void m11325a(String str, JSONArray jSONArray, Collection<GraphRequest> collection) throws IOException, JSONException {
            OutputStream outputStream = this.f1505a;
            if (!(outputStream instanceof RequestOutputStream)) {
                mo11327a(str, jSONArray.toString());
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) outputStream;
            m11326a(str, (String) null, (String) null);
            m11323a("[", new Object[0]);
            int i = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                requestOutputStream.mo10227a(graphRequest);
                if (i > 0) {
                    m11323a(",%s", jSONObject.toString());
                } else {
                    m11323a("%s", jSONObject.toString());
                }
                i++;
            }
            m11323a("]", new Object[0]);
            Logger logger = this.f1506b;
            if (logger != null) {
                logger.m10631a("    " + str, (Object) jSONArray.toString());
            }
        }

        @Override // com.facebook.GraphRequest.InterfaceC0831d
        /* renamed from: a */
        public void mo11327a(String str, String str2) throws IOException {
            m11326a(str, (String) null, (String) null);
            m11321b("%s", str2);
            m11332a();
            Logger logger = this.f1506b;
            if (logger != null) {
                logger.m10631a("    " + str, (Object) str2);
            }
        }

        /* renamed from: a */
        public void m11331a(String str, Bitmap bitmap) throws IOException {
            m11326a(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.f1505a);
            m11321b("", new Object[0]);
            m11332a();
            Logger logger = this.f1506b;
            if (logger != null) {
                logger.m10631a("    " + str, (Object) "<Image>");
            }
        }

        /* renamed from: a */
        public void m11324a(String str, byte[] bArr) throws IOException {
            m11326a(str, str, "content/unknown");
            this.f1505a.write(bArr);
            m11321b("", new Object[0]);
            m11332a();
            Logger logger = this.f1506b;
            if (logger != null) {
                logger.m10631a("    " + str, (Object) String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(bArr.length)));
            }
        }

        /* renamed from: a */
        public void m11330a(String str, Uri uri, String str2) throws IOException {
            int m10535a;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            m11326a(str, str, str2);
            if (this.f1505a instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.f1505a).m10234a(Utility.m10487e(uri));
                m10535a = 0;
            } else {
                m10535a = Utility.m10535a(FacebookSdk.m10869h().getContentResolver().openInputStream(uri), this.f1505a) + 0;
            }
            m11321b("", new Object[0]);
            m11332a();
            Logger logger = this.f1506b;
            if (logger != null) {
                logger.m10631a("    " + str, (Object) String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(m10535a)));
            }
        }

        /* renamed from: a */
        public void m11329a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int m10535a;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            m11326a(str, str, str2);
            OutputStream outputStream = this.f1505a;
            if (outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream).m10234a(parcelFileDescriptor.getStatSize());
                m10535a = 0;
            } else {
                m10535a = Utility.m10535a((InputStream) new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.f1505a) + 0;
            }
            m11321b("", new Object[0]);
            m11332a();
            Logger logger = this.f1506b;
            if (logger != null) {
                logger.m10631a("    " + str, (Object) String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(m10535a)));
            }
        }

        /* renamed from: a */
        public void m11332a() throws IOException {
            if (this.f1508d) {
                this.f1505a.write("&".getBytes());
            } else {
                m11321b("--%s", GraphRequest.f1477b);
            }
        }

        /* renamed from: a */
        public void m11326a(String str, String str2, String str3) throws IOException {
            if (!this.f1508d) {
                m11323a("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    m11323a("; filename=\"%s\"", str2);
                }
                m11321b("", new Object[0]);
                if (str3 != null) {
                    m11321b("%s: %s", "Content-Type", str3);
                }
                m11321b("", new Object[0]);
                return;
            }
            this.f1505a.write(String.format("%s=", str).getBytes());
        }

        /* renamed from: a */
        public void m11323a(String str, Object... objArr) throws IOException {
            if (!this.f1508d) {
                if (this.f1507c) {
                    this.f1505a.write("--".getBytes());
                    this.f1505a.write(GraphRequest.f1477b.getBytes());
                    this.f1505a.write("\r\n".getBytes());
                    this.f1507c = false;
                }
                this.f1505a.write(String.format(str, objArr).getBytes());
                return;
            }
            this.f1505a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
        }

        /* renamed from: b */
        public void m11321b(String str, Object... objArr) throws IOException {
            m11323a(str, objArr);
            if (this.f1508d) {
                return;
            }
            m11323a("\r\n", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType>() { // from class: com.facebook.GraphRequest.ParcelableResourceWithMimeType.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel, (C08231) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ParcelableResourceWithMimeType[] newArray(int i) {
                return new ParcelableResourceWithMimeType[i];
            }
        };

        /* renamed from: a */
        private final String f1501a;

        /* renamed from: b */
        private final RESOURCE f1502b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, C08231 c08231) {
            this(parcel);
        }

        /* renamed from: a */
        public String m11340a() {
            return this.f1501a;
        }

        /* renamed from: b */
        public RESOURCE m11339b() {
            return this.f1502b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1501a);
            parcel.writeParcelable(this.f1502b, i);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.f1501a = str;
            this.f1502b = resource;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.f1501a = parcel.readString();
            this.f1502b = (RESOURCE) parcel.readParcelable(FacebookSdk.m10869h().getClassLoader());
        }
    }
}
