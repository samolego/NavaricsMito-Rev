package com.common;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ARTOSYN_ACK_FRAME {
    public int ARQ_TotalPkts;
    public OTA_ACK_STATUS AckStatus;
    public short ChkSum;
    public byte CurPktIdx;
    public short MesgId;
    public short MsgLen;
    public byte Preamble0;
    public byte Preamble1;
    public byte Temp = 0;
    public byte TotalPktCount;
    private List<Integer> pkts;

    /* loaded from: classes.dex */
    public enum TYPE {
        IS_ERR,
        IS_OTA
    }

    public List<Integer> fill(byte[] bArr) {
        int i = 14;
        if (bArr.length < 14) {
            return null;
        }
        this.Preamble0 = bArr[0];
        this.Preamble1 = bArr[1];
        this.MesgId = (short) (bArr[3] & 255);
        this.MesgId = (short) (this.MesgId << 8);
        this.MesgId = (short) (this.MesgId | ((short) (bArr[2] & 255)));
        this.TotalPktCount = bArr[4];
        this.CurPktIdx = bArr[5];
        this.MsgLen = (short) (bArr[7] & 255);
        this.MsgLen = (short) (this.MsgLen << 8);
        this.MsgLen = (short) (((short) (bArr[6] & 255)) | this.MsgLen);
        this.ChkSum = (short) (bArr[9] & 255);
        this.ChkSum = (short) (this.ChkSum << 8);
        this.ChkSum = (short) (this.ChkSum | ((short) (bArr[8] & 255)));
        this.AckStatus = OTA_ACK_STATUS.valueT(bArr[10]);
        this.Temp = bArr[11];
        this.ARQ_TotalPkts = bArr[13] & 255;
        this.ARQ_TotalPkts <<= 8;
        this.ARQ_TotalPkts = (bArr[12] & 255) | this.ARQ_TotalPkts;
        if (this.pkts == null) {
            this.pkts = new ArrayList();
        }
        this.pkts.clear();
        if (this.ARQ_TotalPkts != 0) {
            for (int i2 = 0; i2 < this.ARQ_TotalPkts; i2++) {
                int i3 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
                i += 2;
                this.pkts.add(Integer.valueOf(i3));
            }
        }
        return this.pkts;
    }

    public List<Integer> getErrList() {
        return this.pkts;
    }

    public void print() {
        Log.v("OTA_SS", "Preamble0: " + ((int) this.Preamble0));
        Log.v("OTA_SS", "Preamble1: " + ((int) this.Preamble1));
        Log.v("OTA_SS", "MesgId: " + ((int) this.MesgId));
        Log.v("OTA_SS", "TotalPktCount: " + ((int) this.TotalPktCount));
        Log.v("OTA_SS", "CurPktIdx: " + ((int) this.CurPktIdx));
        Log.v("OTA_SS", "MsgLen: " + ((int) this.MsgLen));
        Log.v("OTA_SS", "ChkSum: " + ((int) this.ChkSum));
        Log.v("OTA_SS", "AckStatus: " + this.AckStatus);
        Log.v("OTA_SS", "Temp: " + ((int) this.Temp));
        Log.v("OTA_SS", "ARQ_TotalPkts: " + this.ARQ_TotalPkts);
        StringBuilder sb = new StringBuilder();
        List<Integer> list = this.pkts;
        if (list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sb.append(String.format("%d,", it.next()));
            }
            Log.v("OTA_SS", "ARQ_Idx: " + this.pkts.toString());
        }
    }

    public TYPE getFrameType() {
        if (-1 == this.Preamble0 && 90 == this.Preamble1) {
            return TYPE.IS_OTA;
        }
        return TYPE.IS_ERR;
    }
}