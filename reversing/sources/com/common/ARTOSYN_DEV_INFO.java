package com.common;

import android.util.Log;

/* loaded from: classes.dex */
public class ARTOSYN_DEV_INFO {
    public byte[] chipID;
    public byte[] rdId;
    public byte[] rsvl;
    public byte u8_endwrite;
    public byte[] u8_itRegs;
    public byte[] u8_rcRegs;
    public byte u8_startwrite;
    public byte[] vtid;
    public byte skyOrGnd = 0;
    public byte band = 0;
    public byte bandWidth = 0;
    public byte isHopMode = 0;
    public byte rcHopping = 0;
    public byte adapterBitrate = 0;
    public byte channel_1_On = 0;
    public byte channel_2_On = 0;
    public byte isDebug = 0;
    public byte QAM = 0;
    public byte codeRate = 0;
    public byte rcQAM = 0;
    public byte rcCodeRate = 0;
    public byte ch1Bitrates = 0;
    public byte ch2Bitrates = 0;
    public byte reserved = 0;
    public byte pureVtMode = 0;

    public static ARTOSYN_DEV_INFO fill(byte[] bArr) {
        if (bArr.length < 42) {
            return null;
        }
        ARTOSYN_DEV_INFO artosyn_dev_info = new ARTOSYN_DEV_INFO();
        artosyn_dev_info.skyOrGnd = bArr[0];
        artosyn_dev_info.band = bArr[1];
        artosyn_dev_info.bandWidth = bArr[2];
        artosyn_dev_info.isHopMode = bArr[3];
        artosyn_dev_info.rcHopping = bArr[4];
        artosyn_dev_info.adapterBitrate = bArr[5];
        artosyn_dev_info.channel_1_On = bArr[6];
        artosyn_dev_info.channel_2_On = bArr[7];
        artosyn_dev_info.isDebug = bArr[8];
        artosyn_dev_info.QAM = bArr[9];
        artosyn_dev_info.codeRate = bArr[10];
        artosyn_dev_info.rcQAM = bArr[11];
        artosyn_dev_info.rcCodeRate = bArr[12];
        artosyn_dev_info.ch1Bitrates = bArr[13];
        artosyn_dev_info.ch2Bitrates = bArr[14];
        artosyn_dev_info.reserved = bArr[15];
        artosyn_dev_info.u8_itRegs = new byte[4];
        byte[] bArr2 = artosyn_dev_info.u8_itRegs;
        bArr2[0] = bArr[16];
        bArr2[1] = bArr[17];
        bArr2[2] = bArr[18];
        bArr2[3] = bArr[19];
        artosyn_dev_info.u8_rcRegs = new byte[4];
        byte[] bArr3 = artosyn_dev_info.u8_rcRegs;
        bArr3[0] = bArr[20];
        bArr3[1] = bArr[21];
        bArr3[2] = bArr[22];
        bArr3[3] = bArr[23];
        artosyn_dev_info.pureVtMode = bArr[24];
        artosyn_dev_info.rdId = new byte[5];
        byte[] bArr4 = artosyn_dev_info.rdId;
        bArr4[0] = bArr[25];
        bArr4[1] = bArr[26];
        bArr4[2] = bArr[27];
        bArr4[3] = bArr[28];
        bArr4[4] = bArr[29];
        artosyn_dev_info.chipID = new byte[5];
        byte[] bArr5 = artosyn_dev_info.chipID;
        bArr5[0] = bArr[30];
        bArr5[1] = bArr[31];
        bArr5[2] = bArr[32];
        bArr5[3] = bArr[33];
        bArr5[4] = bArr[34];
        artosyn_dev_info.vtid = new byte[2];
        byte[] bArr6 = artosyn_dev_info.vtid;
        bArr6[0] = bArr[35];
        bArr6[1] = bArr[36];
        artosyn_dev_info.rsvl = new byte[3];
        byte[] bArr7 = artosyn_dev_info.rsvl;
        bArr7[0] = bArr[37];
        bArr7[1] = bArr[38];
        bArr7[2] = bArr[39];
        artosyn_dev_info.u8_startwrite = bArr[40];
        artosyn_dev_info.u8_endwrite = bArr[41];
        return artosyn_dev_info;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("is: ");
        sb.append(this.skyOrGnd == 0 ? " Sky" : " Gnd");
        Log.i("DEV_INFO", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("band: ");
        sb2.append(this.band == 1 ? " 2.4G" : " 5.8G");
        Log.i("DEV_INFO", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("bandWidth: ");
        sb3.append(this.bandWidth == 0 ? " 20M" : "10M");
        Log.i("DEV_INFO", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("图传:  ");
        sb4.append(this.isHopMode == 0 ? " 跳频" : " 定频");
        Log.i("DEV_INFO", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("遥控器:  ");
        sb5.append(this.rcHopping == 0 ? " 跳频" : " 定频");
        Log.i("DEV_INFO", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("自适应码流:  ");
        sb6.append(this.adapterBitrate == 0 ? " 开" : " 关");
        Log.i("DEV_INFO", sb6.toString());
        Log.i("DEV_INFO", "channel_1_On:  " + ((int) this.channel_1_On));
        Log.i("DEV_INFO", "channel_2_On:  " + ((int) this.channel_2_On));
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Debug:  ");
        sb7.append(this.isDebug == 0 ? " 关" : "开");
        Log.i("DEV_INFO", sb7.toString());
        Log.i("DEV_INFO", "QAM:  " + ((int) this.QAM));
        Log.i("DEV_INFO", "codeRate:  " + ((int) this.codeRate));
        Log.i("DEV_INFO", "rcQAM:  " + ((int) this.rcQAM));
        Log.i("DEV_INFO", "rcCodeRate:  " + ((int) this.rcCodeRate));
        Log.i("DEV_INFO", "ch1Bitrates:  " + ((int) this.ch1Bitrates));
        Log.i("DEV_INFO", "ch2Bitrates:  " + ((int) this.ch2Bitrates));
        Log.i("DEV_INFO", "pureVtMode:  " + ((int) this.pureVtMode));
    }
}
