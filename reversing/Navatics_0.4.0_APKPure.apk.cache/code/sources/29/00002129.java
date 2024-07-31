package com.twitter.sdk.android.core.identity;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

/* compiled from: OAuthWebChromeClient.java */
/* renamed from: com.twitter.sdk.android.core.identity.e, reason: use source file name */
/* loaded from: classes2.dex */
class OAuthWebChromeClient extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }
}