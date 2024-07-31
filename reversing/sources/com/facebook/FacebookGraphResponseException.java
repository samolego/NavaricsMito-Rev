package com.facebook;

/* loaded from: classes.dex */
public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        GraphResponse graphResponse = this.graphResponse;
        FacebookRequestError m10831a = graphResponse != null ? graphResponse.m10831a() : null;
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (m10831a != null) {
            sb.append("httpResponseCode: ");
            sb.append(m10831a.m11410a());
            sb.append(", facebookErrorCode: ");
            sb.append(m10831a.m11408b());
            sb.append(", facebookErrorType: ");
            sb.append(m10831a.m11406d());
            sb.append(", message: ");
            sb.append(m10831a.m11405e());
            sb.append("}");
        }
        return sb.toString();
    }
}
