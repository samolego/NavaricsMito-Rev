package org.apache.commons.pool2.impl;

import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InterruptibleReentrantLock extends ReentrantLock {
    private static final long serialVersionUID = 1;

    public InterruptibleReentrantLock(boolean z) {
        super(z);
    }

    public void interruptWaiters(Condition condition) {
        Iterator<Thread> it = getWaitingThreads(condition).iterator();
        while (it.hasNext()) {
            it.next().interrupt();
        }
    }
}