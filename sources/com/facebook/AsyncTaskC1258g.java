package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import java.util.List;

/* renamed from: com.facebook.g */
/* loaded from: classes.dex */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {

    /* renamed from: a */
    private static final String f1862a = GraphRequestAsyncTask.class.getCanonicalName();

    /* renamed from: b */
    private final HttpURLConnection f1863b;

    /* renamed from: c */
    private final GraphRequestBatch f1864c;

    /* renamed from: d */
    private Exception f1865d;

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this(null, graphRequestBatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.f1864c = graphRequestBatch;
        this.f1863b = httpURLConnection;
    }

    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.f1863b + ", requests: " + this.f1864c + "}";
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Handler handler;
        super.onPreExecute();
        if (FacebookSdk.m10874d()) {
            Utility.m10505b(f1862a, String.format("execute async task: %s", this));
        }
        if (this.f1864c.m10840c() == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.f1864c.m10846a(handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(List<GraphResponse> list) {
        super.onPostExecute(list);
        Exception exc = this.f1865d;
        if (exc != null) {
            Utility.m10505b(f1862a, String.format("onPostExecute: exception encountered during request: %s", exc.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<GraphResponse> doInBackground(Void... voidArr) {
        try {
            if (this.f1863b == null) {
                return this.f1864c.m10836g();
            }
            return GraphRequest.m11381a(this.f1863b, this.f1864c);
        } catch (Exception e) {
            this.f1865d = e;
            return null;
        }
    }
}
