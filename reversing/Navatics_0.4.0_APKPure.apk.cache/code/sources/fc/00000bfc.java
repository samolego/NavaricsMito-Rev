package com.common;

import com.adapt.SPM_Rc;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CAM_ATTRIBUTE {
    public byte brightness;
    public byte camID;
    public byte contrastRatio;
    public byte[] customAtt0 = new byte[2];
    public byte[] customAtt1 = new byte[4];
    public byte lensType;
    public byte resoluteion;
    public byte shutterType;
    public byte specialEffects;
    public byte videoRecordType;
    public byte whiteBalance;

    public void fill(byte[] bArr) {
        if (bArr.length < 15) {
            return;
        }
        this.camID = bArr[0];
        this.shutterType = bArr[1];
        this.videoRecordType = bArr[2];
        this.lensType = bArr[3];
        this.brightness = bArr[4];
        this.resoluteion = bArr[5];
        this.contrastRatio = bArr[6];
        this.whiteBalance = bArr[7];
        this.specialEffects = bArr[8];
        byte[] bArr2 = this.customAtt0;
        bArr2[0] = bArr[9];
        bArr2[1] = bArr[10];
        byte[] bArr3 = this.customAtt1;
        bArr3[0] = bArr[11];
        bArr3[1] = bArr[12];
        bArr3[2] = bArr[13];
        bArr3[3] = bArr[14];
    }

    public static byte[] getBytes(CAM_ATTRIBUTE cam_attribute) {
        byte[] bArr = cam_attribute.customAtt0;
        byte[] bArr2 = cam_attribute.customAtt1;
        return new byte[]{cam_attribute.camID, cam_attribute.shutterType, cam_attribute.videoRecordType, cam_attribute.lensType, cam_attribute.brightness, cam_attribute.resoluteion, cam_attribute.contrastRatio, cam_attribute.whiteBalance, cam_attribute.specialEffects, bArr[0], bArr[1], bArr2[0], bArr2[1], bArr2[2], bArr2[3]};
    }

    public String toString() {
        return "CAM_ATTRIBUTE{camID=" + ((int) this.camID) + ", shutterType=" + ((int) this.shutterType) + ", videoRecordType=" + ((int) this.videoRecordType) + ", lensType=" + ((int) this.lensType) + ", brightness=" + ((int) this.brightness) + ", resoluteion=" + ((int) this.resoluteion) + ", contrastRatio=" + ((int) this.contrastRatio) + ", whiteBalance=" + ((int) this.whiteBalance) + ", specialEffects=" + ((int) this.specialEffects) + ", customAtt0=" + Arrays.toString(this.customAtt0) + ", customAtt1=" + Arrays.toString(this.customAtt1) + '}';
    }

    public void setParam(int i, int i2, int i3, WhiteBalance whiteBalance) throws Exception {
        if (i == 1920 && i2 == 1080 && i3 == 30) {
            this.resoluteion = SPM_Rc.VIBRATION_MODE.PLAY_ONCE;
        } else if (i == 1920 && i2 == 1080 && i3 == 25) {
            this.resoluteion = (byte) 17;
        } else if (i == 1280 && i2 == 720 && i3 == 60) {
            this.resoluteion = (byte) 32;
        } else if (i == 1280 && i2 == 720 && i3 == 50) {
            this.resoluteion = (byte) 33;
        } else if (i == 1280 && i2 == 720 && i3 == 30) {
            this.resoluteion = (byte) 34;
        } else if (i == 1280 && i2 == 720 && i3 == 25) {
            this.resoluteion = (byte) 35;
        } else {
            throw new Exception("camera config parap err ");
        }
        switch (whiteBalance) {
            case Auto:
                this.whiteBalance = (byte) 0;
                break;
            case _5000K:
                this.whiteBalance = (byte) 1;
                break;
            case _6500K:
                this.whiteBalance = (byte) 2;
                break;
            case _75000K:
                this.whiteBalance = (byte) 3;
                break;
            default:
                throw new Exception("camera config parap err ");
        }
        this.camID = (byte) 1;
    }
}