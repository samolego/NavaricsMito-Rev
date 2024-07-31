package com.google.zxing.aztec;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;

/* loaded from: classes.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[LOOP:0: B:33:0x005d->B:34:0x005f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    @Override // com.google.zxing.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap r13, java.util.Map<com.google.zxing.DecodeHintType, ?> r14) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r12 = this;
            com.google.zxing.aztec.detector.Detector r0 = new com.google.zxing.aztec.detector.Detector
            com.google.zxing.common.BitMatrix r13 = r13.getBlackMatrix()
            r0.<init>(r13)
            r13 = 0
            r1 = 0
            com.google.zxing.aztec.AztecDetectorResult r2 = r0.detect(r13)     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L2b
            com.google.zxing.ResultPoint[] r3 = r2.getPoints()     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L2b
            com.google.zxing.aztec.decoder.Decoder r4 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r4.<init>()     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            com.google.zxing.common.DecoderResult r2 = r4.decode(r2)     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L2f
        L21:
            r2 = move-exception
            goto L27
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r1
        L27:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L2f
        L2b:
            r2 = move-exception
            r3 = r1
        L2d:
            r4 = r3
            r3 = r1
        L2f:
            if (r1 != 0) goto L4f
            r1 = 1
            com.google.zxing.aztec.AztecDetectorResult r0 = r0.detect(r1)     // Catch: com.google.zxing.FormatException -> L45 com.google.zxing.NotFoundException -> L47
            com.google.zxing.ResultPoint[] r4 = r0.getPoints()     // Catch: com.google.zxing.FormatException -> L45 com.google.zxing.NotFoundException -> L47
            com.google.zxing.aztec.decoder.Decoder r1 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L45 com.google.zxing.NotFoundException -> L47
            r1.<init>()     // Catch: com.google.zxing.FormatException -> L45 com.google.zxing.NotFoundException -> L47
            com.google.zxing.common.DecoderResult r1 = r1.decode(r0)     // Catch: com.google.zxing.FormatException -> L45 com.google.zxing.NotFoundException -> L47
            r8 = r4
            goto L50
        L45:
            r13 = move-exception
            goto L48
        L47:
            r13 = move-exception
        L48:
            if (r2 != 0) goto L4e
            if (r3 == 0) goto L4d
            throw r3
        L4d:
            throw r13
        L4e:
            throw r2
        L4f:
            r8 = r4
        L50:
            if (r14 == 0) goto L67
            com.google.zxing.DecodeHintType r0 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r14 = r14.get(r0)
            com.google.zxing.ResultPointCallback r14 = (com.google.zxing.ResultPointCallback) r14
            if (r14 == 0) goto L67
            int r0 = r8.length
        L5d:
            if (r13 >= r0) goto L67
            r2 = r8[r13]
            r14.foundPossibleResultPoint(r2)
            int r13 = r13 + 1
            goto L5d
        L67:
            com.google.zxing.Result r13 = new com.google.zxing.Result
            java.lang.String r5 = r1.getText()
            byte[] r6 = r1.getRawBytes()
            int r7 = r1.getNumBits()
            com.google.zxing.BarcodeFormat r9 = com.google.zxing.BarcodeFormat.AZTEC
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            java.util.List r14 = r1.getByteSegments()
            if (r14 == 0) goto L8a
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            r13.putMetadata(r0, r14)
        L8a:
            java.lang.String r14 = r1.getECLevel()
            if (r14 == 0) goto L95
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r13.putMetadata(r0, r14)
        L95:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecReader.decode(com.google.zxing.BinaryBitmap, java.util.Map):com.google.zxing.Result");
    }
}
