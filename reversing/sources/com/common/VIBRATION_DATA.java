package com.common;

/* loaded from: classes.dex */
public class VIBRATION_DATA {
    public int Duration;
    public byte MotorID;
    public boolean NeedAck;
    public byte Strength;
    public VIBRATION_MOTOR_TYPE Type;
    public byte WaveformFileIdx;

    public byte[] getBytes() {
        byte[] bArr = new byte[8];
        bArr[0] = (byte) this.Type.value();
        bArr[1] = this.MotorID;
        int i = 3;
        switch (this.Type) {
            case VIBRATION_MOTOR_FILE_DRIVE:
                bArr[2] = this.WaveformFileIdx;
                break;
            case VIBRATION_MOTOR_WAVEFORM_DRIVE:
                bArr[2] = this.Strength;
                break;
            default:
                i = 2;
                break;
        }
        System.arraycopy(SP_Util.intToByteArr(this.Duration), 0, bArr, i, 4);
        bArr[i + 4] = this.NeedAck;
        return bArr;
    }
}
