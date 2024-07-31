package com.navatics.robot.utils.logging;

import android.util.Log;

/* compiled from: LogcatLogStrategy.java */
/* renamed from: com.navatics.robot.utils.a.f, reason: use source file name */
/* loaded from: classes2.dex */
public class LogcatLogStrategy implements LogStrategy {
    @Override // com.navatics.robot.utils.logging.LogStrategy
    /* renamed from: a */
    public void mo6911a(int i, String str, String str2) {
        Log.println(i, str, str2);
    }
}