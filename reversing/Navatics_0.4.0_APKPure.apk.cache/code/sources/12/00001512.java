package com.hwfit.artosyn;

import com.adapt.SPM_Rc;
import java.util.Arrays;

/* loaded from: classes.dex */
public class RfMsg {
    public int IT_channel;
    public int afterErr;
    public int channelBandWidth;
    public String codeRate;
    public int encStatus;
    public int encoderBitrate;
    public int errCnt;
    public int errCnt2;
    public int harqCount;
    public int in_Debug;
    public int ldpcError;
    public int lockStatus;
    public int mcs;
    public int messageID;
    public String modulationMode;
    public int nrLock;
    public int optChannel;
    public int paramLen;
    public int rcLock;
    public String rc_codeRate;
    public String rc_modulationMode;
    public float skySNR;
    public float[] snrValue = new float[2];
    public short[] sweepEnergy = new short[168];
    public int[] agcValue = new int[4];
    public int[] width = new int[2];
    public int[] height = new int[2];
    public int[] frameRate = new int[2];
    public int[] encBitrate = new int[2];
    public int[] skyAgcVal = new int[4];

    public static RfMsg fill(byte[] bArr) {
        RfMsg rfMsg = new RfMsg();
        rfMsg.messageID = ((bArr[3] & 255) << 8) + (bArr[2] & 255);
        rfMsg.paramLen = ((bArr[7] & 255) << 8) + (bArr[6] & 255);
        for (int i = 0; i < 2; i++) {
            float[] fArr = rfMsg.snrValue;
            int i2 = i * 2;
            fArr[i] = ((bArr[11 + i2] & 255) << 8) + (bArr[10 + i2] & 255);
            fArr[i] = (float) ((Math.log(fArr[i] / 64.0f) / Math.log(10.0d)) * 10.0d);
        }
        rfMsg.afterErr = ((bArr[15] & 255) << 8) + (bArr[14] & 255);
        rfMsg.optChannel = bArr[16] & 255;
        rfMsg.mcs = bArr[17] & 255;
        for (int i3 = 0; i3 < 168; i3++) {
            int i4 = i3 * 2;
            rfMsg.sweepEnergy[i3] = (short) (((bArr[19 + i4] & 255) << 8) + (bArr[i4 + 18] & 255));
        }
        rfMsg.ldpcError = ((bArr[355] & 255) << 8) + (bArr[354] & 255);
        for (int i5 = 0; i5 < 4; i5++) {
            rfMsg.agcValue[i5] = bArr[356 + i5] & 255;
        }
        rfMsg.harqCount = bArr[360] & SPM_Rc.VIBRATION_MODE.MAX_VOLUME;
        switch (bArr[361] & 255) {
            case 0:
                rfMsg.modulationMode = "BPSK ";
                break;
            case 1:
                rfMsg.modulationMode = "QPSK ";
                break;
            case 2:
                rfMsg.modulationMode = "16QAM ";
                break;
            case 3:
                rfMsg.modulationMode = "64QAM ";
                break;
        }
        rfMsg.channelBandWidth = bArr[362] & 255;
        switch (bArr[363] & 255) {
            case 0:
                rfMsg.codeRate = "1/2";
                break;
            case 1:
                rfMsg.codeRate = "2/3";
                break;
        }
        rfMsg.IT_channel = bArr[365] & 255;
        rfMsg.lockStatus = bArr[369] & 1;
        int[] iArr = rfMsg.width;
        iArr[0] = ((bArr[371] & 255) << 8) + (bArr[370] & 255);
        iArr[1] = ((bArr[373] & 255) << 8) + (bArr[372] & 255);
        int[] iArr2 = rfMsg.height;
        iArr2[0] = ((bArr[375] & 255) << 8) + (bArr[374] & 255);
        iArr2[1] = ((bArr[377] & 255) << 8) + (bArr[376] & 255);
        int[] iArr3 = rfMsg.frameRate;
        iArr3[0] = bArr[378] & 255;
        iArr3[1] = bArr[379] & 255;
        int[] iArr4 = rfMsg.encBitrate;
        iArr4[0] = bArr[380] & 255;
        iArr4[1] = bArr[381] & 255;
        switch (bArr[382] & 255) {
            case 0:
                rfMsg.rc_modulationMode = "BPSK ";
                break;
            case 1:
                rfMsg.rc_modulationMode = "QPSK ";
                break;
            case 2:
                rfMsg.rc_modulationMode = "16QAM ";
                break;
            case 3:
                rfMsg.rc_modulationMode = "64QAM ";
                break;
        }
        switch (bArr[383] & 255) {
            case 0:
                rfMsg.rc_codeRate = "1/2";
                break;
            case 1:
                rfMsg.rc_codeRate = "2/3";
                break;
        }
        rfMsg.encStatus = bArr[384] & 255;
        rfMsg.errCnt = bArr[385] & 255;
        rfMsg.errCnt2 = bArr[386] & 255;
        rfMsg.rcLock = bArr[387] & 255;
        rfMsg.nrLock = bArr[388] & 255;
        for (int i6 = 0; i6 < 4; i6++) {
            rfMsg.skyAgcVal[i6] = bArr[389 + i6] & 255;
        }
        rfMsg.skySNR = ((bArr[399] & 255) << 8) + (bArr[398] & 255);
        rfMsg.skySNR = (float) ((Math.log(rfMsg.skySNR / 64.0f) / Math.log(10.0d)) * 10.0d);
        return rfMsg;
    }

    public String toString() {
        return "RfMsg{  \nmessageID=" + this.messageID + ", \nparamLen=" + this.paramLen + ", \nsnrValue=" + Arrays.toString(this.snrValue) + ", \nafterErr=" + this.afterErr + ", \noptChannel=" + this.optChannel + ", \nmcs=" + this.mcs + ", \nsweepEnergy=" + Arrays.toString(this.sweepEnergy) + ", \nldpcError=" + this.ldpcError + ", \nagcValue=" + Arrays.toString(this.agcValue) + ", \nharqCount=" + this.harqCount + ", \nmodulationMode=" + this.modulationMode + ", \nchannelBandWidth=" + this.channelBandWidth + ", \ncodeRate=" + this.codeRate + ", \nIT_channel=" + this.IT_channel + ", \nin_Debug=" + this.in_Debug + ", \nlockStatus=" + this.lockStatus + ", \nwidth=" + Arrays.toString(this.width) + ", \nheight=" + Arrays.toString(this.height) + ", \nframeRate=" + Arrays.toString(this.frameRate) + ", \nencBitrate=" + Arrays.toString(this.encBitrate) + ", \nrc_modulationMode=" + this.rc_modulationMode + ", \nrc_codeRate=" + this.rc_codeRate + ", \nencStatus=" + this.encStatus + ", \nerrCnt=" + this.errCnt + ", \nerrCnt2=" + this.errCnt2 + ", \nrcLock=" + this.rcLock + ", \nnrLock=" + this.nrLock + ", \nskyAgcVal=" + Arrays.toString(this.skyAgcVal) + ", \nskySNR=" + this.skySNR + ", \nencoderBitrate=" + this.encoderBitrate + "  }";
    }
}