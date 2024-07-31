package org.apache.ftpserver.ftplet;

/* loaded from: classes2.dex */
public enum Structure {
    FILE;

    public static Structure parseArgument(char c) {
        if (c == 'F' || c == 'f') {
            return FILE;
        }
        throw new IllegalArgumentException("Unknown structure: " + c);
    }
}
