package com.common;

/* loaded from: classes.dex */
public class ARTOSYN_CMD_FRAME {
    public short ChkSum;
    public byte CurPktIdx;
    public short MesgId;
    public short MsgLen;
    public byte Preamble0;
    public byte Preamble1;
    public byte TotalPktCount;

    public static short computerChecksum(byte[] bArr) {
        if (bArr == null) {
            return (short) 0;
        }
        int i = 0;
        for (byte b : bArr) {
            i += b & 255;
        }
        return (short) (1048575 & i);
    }

    public static byte[] creatCmdFrame(ARTOSYN_CMD_FRAME artosyn_cmd_frame, byte[] bArr) {
        int length = (bArr == null ? 0 : bArr.length) + 10;
        short computerChecksum = computerChecksum(bArr);
        short length2 = bArr == null ? (short) 0 : (short) (bArr.length & 65535);
        byte[] bArr2 = new byte[length];
        bArr2[0] = artosyn_cmd_frame.Preamble0;
        bArr2[1] = artosyn_cmd_frame.Preamble1;
        short s = artosyn_cmd_frame.MesgId;
        bArr2[2] = (byte) (s & 255);
        bArr2[3] = (byte) ((s >> 8) & 255);
        bArr2[4] = artosyn_cmd_frame.TotalPktCount;
        bArr2[5] = artosyn_cmd_frame.CurPktIdx;
        bArr2[6] = (byte) (length2 & 255);
        bArr2[7] = (byte) ((length2 >> 8) & 255);
        bArr2[8] = (byte) (computerChecksum & 255);
        bArr2[9] = (byte) ((computerChecksum >> 8) & 255);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 10, bArr.length);
        }
        return bArr2;
    }

    public static byte[] shortFrame(short s) {
        ARTOSYN_CMD_FRAME artosyn_cmd_frame = new ARTOSYN_CMD_FRAME();
        artosyn_cmd_frame.Preamble0 = (byte) -1;
        artosyn_cmd_frame.Preamble1 = (byte) 90;
        artosyn_cmd_frame.TotalPktCount = (byte) 1;
        artosyn_cmd_frame.CurPktIdx = (byte) 0;
        artosyn_cmd_frame.MesgId = s;
        return creatCmdFrame(artosyn_cmd_frame, null);
    }
}
