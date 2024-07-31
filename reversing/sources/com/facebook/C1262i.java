package com.facebook;

import android.util.Log;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.i */
/* loaded from: classes.dex */
public class GraphResponse {

    /* renamed from: a */
    private static final String f1873a = "i";

    /* renamed from: b */
    private final HttpURLConnection f1874b;

    /* renamed from: c */
    private final JSONObject f1875c;

    /* renamed from: d */
    private final JSONArray f1876d;

    /* renamed from: e */
    private final FacebookRequestError f1877e;

    /* renamed from: f */
    private final String f1878f;

    /* renamed from: g */
    private final GraphRequest f1879g;

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.f1879g = graphRequest;
        this.f1874b = httpURLConnection;
        this.f1878f = str;
        this.f1875c = jSONObject;
        this.f1876d = jSONArray;
        this.f1877e = facebookRequestError;
    }

    /* renamed from: a */
    public final FacebookRequestError m10831a() {
        return this.f1877e;
    }

    /* renamed from: b */
    public final JSONObject m10824b() {
        return this.f1875c;
    }

    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f1874b != null ? this.f1874b.getResponseCode() : 200);
            str = String.format(locale, "%d", objArr);
        } catch (IOException unused) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.f1875c + ", error: " + this.f1877e + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<GraphResponse> m10827a(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        InputStream inputStream;
        try {
            try {
                if (!FacebookSdk.m10879b()) {
                    Log.e(f1873a, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                    throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
                }
                if (httpURLConnection.getResponseCode() >= 400) {
                    inputStream = httpURLConnection.getErrorStream();
                } else {
                    inputStream = httpURLConnection.getInputStream();
                }
                List<GraphResponse> m10829a = m10829a(inputStream, httpURLConnection, graphRequestBatch);
                Utility.m10538a((Closeable) inputStream);
                return m10829a;
            } catch (FacebookException e) {
                Logger.m10633a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e);
                List<GraphResponse> m10825a = m10825a(graphRequestBatch, httpURLConnection, e);
                Utility.m10538a((Closeable) null);
                return m10825a;
            } catch (Exception e2) {
                Logger.m10633a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e2);
                List<GraphResponse> m10825a2 = m10825a(graphRequestBatch, httpURLConnection, new FacebookException(e2));
                Utility.m10538a((Closeable) null);
                return m10825a2;
            }
        } catch (Throwable th) {
            Utility.m10538a((Closeable) null);
            throw th;
        }
    }

    /* renamed from: a */
    static List<GraphResponse> m10829a(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        String m10536a = Utility.m10536a(inputStream);
        Logger.m10633a(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(m10536a.length()), m10536a);
        return m10828a(m10536a, httpURLConnection, graphRequestBatch);
    }

    /* renamed from: a */
    static List<GraphResponse> m10828a(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        List<GraphResponse> m10826a = m10826a(httpURLConnection, graphRequestBatch, new JSONTokener(str).nextValue());
        Logger.m10633a(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.m10843b(), Integer.valueOf(str.length()), m10826a);
        return m10826a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.facebook.GraphResponse> m10826a(java.net.HttpURLConnection r7, java.util.List<com.facebook.GraphRequest> r8, java.lang.Object r9) throws com.facebook.FacebookException, org.json.JSONException {
        /*
            int r0 = r8.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L51
            java.lang.Object r3 = r8.get(r2)
            com.facebook.GraphRequest r3 = (com.facebook.GraphRequest) r3
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            r4.<init>()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            java.lang.String r5 = "body"
            r4.put(r5, r9)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            if (r7 == 0) goto L24
            int r5 = r7.getResponseCode()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            goto L26
        L24:
            r5 = 200(0xc8, float:2.8E-43)
        L26:
            java.lang.String r6 = "code"
            r4.put(r6, r5)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            r5.<init>()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            r5.put(r4)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            goto L52
        L34:
            r4 = move-exception
            com.facebook.i r5 = new com.facebook.i
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r4)
            r5.<init>(r3, r7, r6)
            r1.add(r5)
            goto L51
        L43:
            r4 = move-exception
            com.facebook.i r5 = new com.facebook.i
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r4)
            r5.<init>(r3, r7, r6)
            r1.add(r5)
        L51:
            r5 = r9
        L52:
            boolean r3 = r5 instanceof org.json.JSONArray
            if (r3 == 0) goto L97
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r3 = r5.length()
            if (r3 != r0) goto L97
        L5e:
            int r0 = r5.length()
            if (r2 >= r0) goto L96
            java.lang.Object r0 = r8.get(r2)
            com.facebook.GraphRequest r0 = (com.facebook.GraphRequest) r0
            java.lang.Object r3 = r5.get(r2)     // Catch: com.facebook.FacebookException -> L76 org.json.JSONException -> L85
            com.facebook.i r3 = m10830a(r0, r7, r3, r9)     // Catch: com.facebook.FacebookException -> L76 org.json.JSONException -> L85
            r1.add(r3)     // Catch: com.facebook.FacebookException -> L76 org.json.JSONException -> L85
            goto L93
        L76:
            r3 = move-exception
            com.facebook.i r4 = new com.facebook.i
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r3)
            r4.<init>(r0, r7, r6)
            r1.add(r4)
            goto L93
        L85:
            r3 = move-exception
            com.facebook.i r4 = new com.facebook.i
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r3)
            r4.<init>(r0, r7, r6)
            r1.add(r4)
        L93:
            int r2 = r2 + 1
            goto L5e
        L96:
            return r1
        L97:
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r8 = "Unexpected number of results"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.m10826a(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
    }

    /* renamed from: a */
    private static GraphResponse m10830a(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError m11409a = FacebookRequestError.m11409a(jSONObject, obj2, httpURLConnection);
            if (m11409a != null) {
                Log.e(f1873a, m11409a.toString());
                if (m11409a.m11408b() == 190 && Utility.m10539a(graphRequest.m11355f())) {
                    if (m11409a.m11407c() != 493) {
                        AccessToken.m11454a((AccessToken) null);
                    } else if (!AccessToken.m11457a().m11438n()) {
                        AccessToken.m11449c();
                    }
                }
                return new GraphResponse(graphRequest, httpURLConnection, m11409a);
            }
            Object m10512a = Utility.m10512a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (m10512a instanceof JSONObject) {
                return new GraphResponse(graphRequest, httpURLConnection, m10512a.toString(), (JSONObject) m10512a);
            }
            if (m10512a instanceof JSONArray) {
                return new GraphResponse(graphRequest, httpURLConnection, m10512a.toString(), (JSONArray) m10512a);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<GraphResponse> m10825a(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new GraphResponse(list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }
}
