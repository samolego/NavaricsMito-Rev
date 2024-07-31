package com.senseplay.sdk.video.host;

import android.util.Log;

/* loaded from: classes2.dex */
public class ArlinkData {
    private static final int ARLINK_CTRL_CHECKSUM_POS = 10;
    private static final int ARLINK_CTRL_DATA = 0;
    private static final int ARLINK_CTRL_LEN_POS = 8;
    private static final int ARLINK_STREAM_CHECKSUM_POS = 16;
    private static final int ARLINK_STREAM_DATA = 1;
    private static final int ARLINK_STREAM_LEN_POS = 14;
    private static final int ARLINK_USR_DATA_MAX_LEN = 16384;
    private static final int ArlinkRxProtocolCheckSum = 2;
    private static final int ArlinkRxProtocolDataBuffer = 3;
    private static final int ArlinkRxProtocolDataLen = 1;
    private static final int ArlinkRxProtocolHEADER = 0;
    private static final String TAG = "ArlinkData";
    private byte[] headerCtrlData = {-1, 90};
    private byte[] headerStream = {-1, -91, 90, -1};
    ArlinkRxFiFo arlinkRxFiFo = new ArlinkRxFiFo();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ArlinkRxFiFoHeader {
        int findHeader = 0;
        int revingData = 0;
        int dataLenIndex = 0;
        int headerBufferIndex = 0;
        int rxState = 0;
        byte[] headerBuffer = new byte[16];
        int ArlinkPacketType = 0;
        int dataLen = 0;
        int dataBufferIndex = 0;
        int checkSum = 0;

        ArlinkRxFiFoHeader() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ArlinkRxFiFo {
        byte[] data = new byte[131072];
        ArlinkRxFiFoHeader headerIns;

        ArlinkRxFiFo() {
            this.headerIns = new ArlinkRxFiFoHeader();
        }

        private boolean ArraysEqual(byte[] bArr, byte[] bArr2, int i) {
            int i2 = 0;
            while (i2 < i && bArr[i2] == bArr2[i2]) {
                i2++;
            }
            return i2 == i;
        }
    }

    private boolean ArraysEqual(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        while (i2 < i && bArr[i2] == bArr2[i2]) {
            i2++;
        }
        return i2 == i;
    }

    private int arlinkProtocolFindHeader(byte b) {
        int i = 1;
        switch (this.arlinkRxFiFo.headerIns.rxState) {
            case 0:
                if (this.arlinkRxFiFo.headerIns.headerBufferIndex >= this.headerStream.length) {
                    Log.e(TAG, "ERROR in ArlinkRxProtocolHEADER !!!!!");
                    this.arlinkRxFiFo.headerIns.headerBufferIndex = 0;
                }
                byte[] bArr = this.arlinkRxFiFo.headerIns.headerBuffer;
                ArlinkRxFiFoHeader arlinkRxFiFoHeader = this.arlinkRxFiFo.headerIns;
                int i2 = arlinkRxFiFoHeader.headerBufferIndex;
                arlinkRxFiFoHeader.headerBufferIndex = i2 + 1;
                bArr[i2] = b;
                boolean ArraysEqual = ArraysEqual(this.arlinkRxFiFo.headerIns.headerBuffer, this.headerStream, this.arlinkRxFiFo.headerIns.headerBufferIndex);
                if (!ArraysEqual && this.arlinkRxFiFo.headerIns.headerBufferIndex <= this.headerCtrlData.length) {
                    ArraysEqual = ArraysEqual(this.arlinkRxFiFo.headerIns.headerBuffer, this.headerCtrlData, this.arlinkRxFiFo.headerIns.headerBufferIndex);
                }
                if (!ArraysEqual) {
                    for (int i3 = 1; i3 < this.arlinkRxFiFo.headerIns.headerBufferIndex; i3++) {
                        this.arlinkRxFiFo.headerIns.headerBuffer[i3 - 1] = this.arlinkRxFiFo.headerIns.headerBuffer[i3];
                    }
                    this.arlinkRxFiFo.headerIns.headerBufferIndex--;
                    return 0;
                } else if (this.arlinkRxFiFo.headerIns.headerBufferIndex == this.headerStream.length && ArraysEqual(this.arlinkRxFiFo.headerIns.headerBuffer, this.headerStream, this.arlinkRxFiFo.headerIns.headerBufferIndex)) {
                    this.arlinkRxFiFo.headerIns.rxState = 1;
                    this.arlinkRxFiFo.headerIns.dataLenIndex = 0;
                    this.arlinkRxFiFo.headerIns.ArlinkPacketType = 1;
                    break;
                } else if (this.arlinkRxFiFo.headerIns.headerBufferIndex == this.headerCtrlData.length && ArraysEqual(this.arlinkRxFiFo.headerIns.headerBuffer, this.headerCtrlData, this.arlinkRxFiFo.headerIns.headerBufferIndex)) {
                    this.arlinkRxFiFo.headerIns.rxState = 1;
                    this.arlinkRxFiFo.headerIns.dataLenIndex = 0;
                    this.arlinkRxFiFo.headerIns.ArlinkPacketType = 0;
                    break;
                }
                break;
            case 1:
                byte[] bArr2 = this.arlinkRxFiFo.headerIns.headerBuffer;
                ArlinkRxFiFoHeader arlinkRxFiFoHeader2 = this.arlinkRxFiFo.headerIns;
                int i4 = arlinkRxFiFoHeader2.headerBufferIndex;
                arlinkRxFiFoHeader2.headerBufferIndex = i4 + 1;
                bArr2[i4] = b;
                if (this.arlinkRxFiFo.headerIns.ArlinkPacketType == 0) {
                    if (this.arlinkRxFiFo.headerIns.headerBufferIndex == 8) {
                        this.arlinkRxFiFo.headerIns.rxState = 2;
                        this.arlinkRxFiFo.headerIns.dataLen = ((this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 1] & 255) << 8) + (this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 2] & 255);
                        int i5 = this.arlinkRxFiFo.headerIns.dataLen;
                        int i6 = this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 3] & 255;
                        int i7 = this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 4] & 255;
                        if (i5 > 600 || i6 > 1 || i7 > 1) {
                            this.arlinkRxFiFo.headerIns.rxState = 0;
                            this.arlinkRxFiFo.headerIns.headerBufferIndex = 0;
                            break;
                        }
                    }
                } else if (this.arlinkRxFiFo.headerIns.ArlinkPacketType == 1) {
                    if (this.arlinkRxFiFo.headerIns.headerBufferIndex == 14) {
                        this.arlinkRxFiFo.headerIns.rxState = 2;
                        this.arlinkRxFiFo.headerIns.dataLen = ((this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 1] & 255) << 8) + (this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 2] & 255);
                        break;
                    }
                } else {
                    Log.e(TAG, "ERROR in ArlinkRxProtocolDataLen !!!!!");
                    break;
                }
                break;
            case 2:
                byte[] bArr3 = this.arlinkRxFiFo.headerIns.headerBuffer;
                ArlinkRxFiFoHeader arlinkRxFiFoHeader3 = this.arlinkRxFiFo.headerIns;
                int i8 = arlinkRxFiFoHeader3.headerBufferIndex;
                arlinkRxFiFoHeader3.headerBufferIndex = i8 + 1;
                bArr3[i8] = b;
                if (this.arlinkRxFiFo.headerIns.ArlinkPacketType == 0) {
                    if (this.arlinkRxFiFo.headerIns.headerBufferIndex == 10) {
                        this.arlinkRxFiFo.headerIns.checkSum = ((this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 1] & 255) << 8) + (this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 2] & 255);
                        this.arlinkRxFiFo.headerIns.findHeader = 1;
                        this.arlinkRxFiFo.headerIns.dataBufferIndex = 0;
                        this.arlinkRxFiFo.headerIns.rxState = 0;
                        this.arlinkRxFiFo.headerIns.headerBufferIndex = 0;
                        return 1;
                    }
                } else if (this.arlinkRxFiFo.headerIns.ArlinkPacketType == 1) {
                    if (this.arlinkRxFiFo.headerIns.headerBufferIndex == 16) {
                        this.arlinkRxFiFo.headerIns.checkSum = ((this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 1] & 255) << 8) + (this.arlinkRxFiFo.headerIns.headerBuffer[this.arlinkRxFiFo.headerIns.headerBufferIndex - 2] & 255);
                        byte[] bArr4 = this.arlinkRxFiFo.headerIns.headerBuffer;
                        int i9 = 0;
                        for (int i10 = 0; i10 < bArr4.length - 2; i10++) {
                            i9 = (i9 + (bArr4[i10] & 255)) & 65535;
                        }
                        if (i9 == this.arlinkRxFiFo.headerIns.checkSum) {
                            this.arlinkRxFiFo.headerIns.findHeader = 1;
                            this.arlinkRxFiFo.headerIns.dataBufferIndex = 0;
                        } else {
                            Log.e(TAG, "ERROR in ArlinkRxProtocolCheckSum 0 !!!!!");
                            i = 0;
                        }
                        this.arlinkRxFiFo.headerIns.rxState = 0;
                        this.arlinkRxFiFo.headerIns.headerBufferIndex = 0;
                        return i;
                    }
                } else {
                    Log.e(TAG, "ERROR in ArlinkRxProtocolCheckSum !!!!!");
                    break;
                }
                break;
            default:
                this.arlinkRxFiFo.headerIns.rxState = 0;
                this.arlinkRxFiFo.headerIns.headerBufferIndex = 0;
                break;
        }
        return 0;
    }

    public void ArlinkRxPacketDataAnalyze(byte[] bArr, int i, PlayerThread playerThread) {
        ArlinkRxFiFoHeader arlinkRxFiFoHeader = this.arlinkRxFiFo.headerIns;
        int i2 = 0;
        while (i > 0) {
            int i3 = i2 + 1;
            byte b = bArr[i2];
            i--;
            if (arlinkRxFiFoHeader.findHeader == 1) {
                if (arlinkRxFiFoHeader.dataLen > 16384) {
                    Log.e(TAG, "Data length should not exceed: 16384");
                    arlinkRxFiFoHeader.dataBufferIndex = 0;
                    arlinkRxFiFoHeader.revingData = 0;
                    arlinkRxFiFoHeader.findHeader = 0;
                } else {
                    byte[] bArr2 = this.arlinkRxFiFo.data;
                    int i4 = arlinkRxFiFoHeader.dataBufferIndex;
                    arlinkRxFiFoHeader.dataBufferIndex = i4 + 1;
                    bArr2[i4] = b;
                    if (arlinkRxFiFoHeader.dataBufferIndex == arlinkRxFiFoHeader.dataLen) {
                        if (arlinkRxFiFoHeader.ArlinkPacketType == 0) {
                            int i5 = 0;
                            for (int i6 = 0; i6 < arlinkRxFiFoHeader.dataLen; i6++) {
                                i5 = (i5 + (this.arlinkRxFiFo.data[i6] & 255)) & 65535;
                            }
                            int i7 = arlinkRxFiFoHeader.checkSum;
                        } else if (arlinkRxFiFoHeader.ArlinkPacketType == 1) {
                            playerThread.AddData(this.arlinkRxFiFo.data, arlinkRxFiFoHeader.dataLen);
                        }
                        arlinkRxFiFoHeader.dataBufferIndex = 0;
                        arlinkRxFiFoHeader.revingData = 0;
                        arlinkRxFiFoHeader.findHeader = 0;
                    }
                }
            } else {
                arlinkProtocolFindHeader(b);
            }
            i2 = i3;
        }
    }
}
