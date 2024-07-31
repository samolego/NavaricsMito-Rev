package org.apache.ftpserver.ftplet;

/* loaded from: classes2.dex */
public enum DataType {
    BINARY,
    ASCII;

    public static DataType parseArgument(char c) {
        if (c != 'A') {
            if (c != 'I') {
                if (c != 'a') {
                    if (c != 'i') {
                        throw new IllegalArgumentException("Unknown data type: " + c);
                    }
                }
            }
            return BINARY;
        }
        return ASCII;
    }
}