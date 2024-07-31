package com.hwfit.common;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CmdPool {
    private List<BytesData> list = new ArrayList();

    public byte[] FiFoRead() {
        synchronized (this) {
            if (this.list.size() == 0) {
                return null;
            }
            int i = 0;
            for (BytesData bytesData : this.list) {
                i += bytesData.len;
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (BytesData bytesData2 : this.list) {
                System.arraycopy(bytesData2.data, 0, bArr, i2, bytesData2.len);
                i2 += bytesData2.len;
            }
            this.list.clear();
            return bArr;
        }
    }

    public void FiFoWrite(BytesData bytesData) {
        synchronized (this) {
            this.list.add(bytesData);
        }
    }

    public int getActualSize() {
        int size;
        synchronized (this) {
            size = this.list.size();
        }
        return size;
    }

    public void reset() {
        synchronized (this) {
            this.list.clear();
        }
    }
}
