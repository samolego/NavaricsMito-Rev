package com.common;

import com.misc.C1514util;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SPRC_INFO {
    public SPRC_CATEGORY Category;
    public int FirmwareVersion;
    public String FirmwareVersionStr;
    public int HardwareVersion;
    public String HardwareVersionStr;
    public SP_DATE ManufactureDate = new SP_DATE();
    public int ManufacturerID;
    public int ModelID;
    public byte[] SerialNo;
    public byte Version;

    public int fill(byte[] bArr, int i, byte b) {
        byte[] bArr2 = new byte[32];
        byte[] bArr3 = new byte[32];
        if (b == 0) {
            this.Category = SPRC_CATEGORY.getVal(SP_Util.byteArrayToInt(bArr, 0));
            i += 4;
        } else if (b == 1) {
            this.Category = SPRC_CATEGORY.getVal(bArr[i]);
            i++;
        }
        this.ManufacturerID = SP_Util.byteArrayToInt(bArr, i);
        int i2 = i + 4;
        this.ModelID = SP_Util.byteArrayToInt(bArr, i2);
        int fill = this.ManufactureDate.fill(bArr, SP_Util.arryCp(bArr, bArr2, i2 + 4));
        this.Version = b;
        byte b2 = this.Version;
        if (b2 == 0) {
            this.HardwareVersion = SP_Util.byteArrayToInt(bArr, fill);
            fill += 4;
            this.FirmwareVersion = SP_Util.byteArrayToInt(bArr, fill);
        } else if (b2 == 1) {
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(bArr, fill, bArr3, 0, bArr3.length);
            fill += bArr3.length;
            this.HardwareVersionStr = new String(C1514util.getValidBytes(bArr3));
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(bArr, fill, bArr3, 0, bArr3.length);
            this.FirmwareVersionStr = new String(C1514util.getValidBytes(bArr3));
        }
        this.SerialNo = C1514util.getValidBytes(bArr2);
        return fill;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Category: " + this.Category + "\n");
        sb.append("ManufacturerID: " + this.ManufacturerID + "\n");
        sb.append("ModelID: " + this.ModelID + "\n");
        sb.append("SerialNo: " + SP_Util.byte2str(this.SerialNo) + "\n");
        sb.append("Category: " + this.Category + "\n");
        sb.append("Date: " + this.ManufactureDate.toString() + "\n");
        sb.append("HardwareVersion: " + this.HardwareVersion + "\n");
        sb.append("FirmwareVersion: " + this.FirmwareVersion + "\n");
        sb.append("HardwareVersionStr: " + this.HardwareVersionStr + "\n");
        sb.append("FirmwareVersionStr: " + this.FirmwareVersionStr + "\n");
        return sb.toString();
    }
}
