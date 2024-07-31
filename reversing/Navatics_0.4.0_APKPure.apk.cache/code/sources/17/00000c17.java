package com.common;

/* loaded from: classes.dex */
public class SP_BATT_ATTRIBUTE implements SPRC_T {
    public static int size = 74;
    public short designCapacity;
    public short designVoltage;
    public byte[] materials = new byte[15];
    public byte[] productionDate = new byte[10];

    /* renamed from: sn */
    public byte[] f1314sn = new byte[15];
    public byte[] hwVer = new byte[15];
    public byte[] swVer = new byte[15];

    @Override // com.common.SPRC_T
    public int fill(byte[] bArr, int i) {
        this.designVoltage = SP_Util.byteArrayToShort(bArr, i);
        int i2 = i + 2;
        this.designCapacity = SP_Util.byteArrayToShort(bArr, i2);
        int i3 = i2 + 2;
        byte[] bArr2 = this.materials;
        System.arraycopy(bArr, i3, bArr2, 0, bArr2.length);
        int length = i3 + this.materials.length;
        byte[] bArr3 = this.productionDate;
        System.arraycopy(bArr, length, bArr3, 0, bArr3.length);
        int length2 = length + this.productionDate.length;
        byte[] bArr4 = this.f1314sn;
        System.arraycopy(bArr, length2, bArr4, 0, bArr4.length);
        int length3 = length2 + this.f1314sn.length;
        byte[] bArr5 = this.hwVer;
        System.arraycopy(bArr, length3, bArr5, 0, bArr5.length);
        int length4 = length3 + this.hwVer.length;
        byte[] bArr6 = this.swVer;
        System.arraycopy(bArr, length4, bArr6, 0, bArr6.length);
        return length4 + this.swVer.length;
    }
}