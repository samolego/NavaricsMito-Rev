package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {

    /* renamed from: AL */
    private static final int f3429AL = 28;

    /* renamed from: AS */
    private static final int f3430AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;

    /* renamed from: LL */
    private static final int f3431LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;

    /* renamed from: ML */
    private static final int f3432ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;

    /* renamed from: PL */
    private static final int f3433PL = 25;

    /* renamed from: PS */
    private static final int f3434PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
            i++;
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.common.DecoderResult decode(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            com.google.zxing.pdf417.PDF417ResultMetadata r3 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L28:
            int r2 = decodeMacroBlock(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = numericCompaction(r6, r4, r0)
            goto L60
        L4e:
            int r2 = byteCompaction(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            com.google.zxing.common.DecoderResult r6 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.setOther(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = i;
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i2];
            i3++;
            i2++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int textCompaction = textCompaction(iArr, i2, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i4 = iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? textCompaction + 1 : -1;
        while (textCompaction < iArr[0]) {
            switch (iArr[textCompaction]) {
                case MACRO_PDF417_TERMINATOR /* 922 */:
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                    break;
                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                    int i5 = textCompaction + 1;
                    switch (iArr[i5]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i5 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            continue;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            continue;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            continue;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i5 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            continue;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i5 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            continue;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            continue;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i5 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            continue;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                default:
                    throw FormatException.getFormatInstance();
            }
        }
        if (i4 != -1) {
            int i6 = textCompaction - i4;
            if (pDF417ResultMetadata.isLastSegment()) {
                i6--;
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i6 + i4));
        }
        return textCompaction;
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
                i = i3;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            i = i3;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i4) {
                                case MACRO_PDF417_TERMINATOR /* 922 */:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        char c;
        Mode mode = Mode.ALPHA;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            switch (mode3) {
                case ALPHA:
                    if (i3 < 26) {
                        c = (char) (i3 + 65);
                        break;
                    } else {
                        if (i3 != 900) {
                            if (i3 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                switch (i3) {
                                    case 26:
                                        c = ' ';
                                        break;
                                    case 27:
                                        mode3 = Mode.LOWER;
                                        c = 0;
                                        break;
                                    case 28:
                                        mode3 = Mode.MIXED;
                                        c = 0;
                                        break;
                                    case 29:
                                        c = 0;
                                        mode2 = mode3;
                                        mode3 = Mode.PUNCT_SHIFT;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr2[i2]);
                                c = 0;
                                break;
                            }
                        } else {
                            mode3 = Mode.ALPHA;
                        }
                        c = 0;
                        break;
                    }
                case LOWER:
                    if (i3 < 26) {
                        c = (char) (i3 + 97);
                        break;
                    } else {
                        if (i3 != 900) {
                            if (i3 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                switch (i3) {
                                    case 26:
                                        c = ' ';
                                        break;
                                    case 27:
                                        c = 0;
                                        mode2 = mode3;
                                        mode3 = Mode.ALPHA_SHIFT;
                                        break;
                                    case 28:
                                        mode3 = Mode.MIXED;
                                        c = 0;
                                        break;
                                    case 29:
                                        c = 0;
                                        mode2 = mode3;
                                        mode3 = Mode.PUNCT_SHIFT;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr2[i2]);
                                c = 0;
                                break;
                            }
                        } else {
                            mode3 = Mode.ALPHA;
                        }
                        c = 0;
                        break;
                    }
                case MIXED:
                    if (i3 < 25) {
                        c = MIXED_CHARS[i3];
                        break;
                    } else {
                        if (i3 != 900) {
                            if (i3 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                switch (i3) {
                                    case 25:
                                        mode3 = Mode.PUNCT;
                                        c = 0;
                                        break;
                                    case 26:
                                        c = ' ';
                                        break;
                                    case 27:
                                        mode3 = Mode.LOWER;
                                        c = 0;
                                        break;
                                    case 28:
                                        mode3 = Mode.ALPHA;
                                        c = 0;
                                        break;
                                    case 29:
                                        c = 0;
                                        mode2 = mode3;
                                        mode3 = Mode.PUNCT_SHIFT;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr2[i2]);
                                c = 0;
                                break;
                            }
                        } else {
                            mode3 = Mode.ALPHA;
                        }
                        c = 0;
                        break;
                    }
                case PUNCT:
                    if (i3 < 29) {
                        c = PUNCT_CHARS[i3];
                        break;
                    } else if (i3 != 29) {
                        if (i3 != 900) {
                            if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i2]);
                                c = 0;
                                break;
                            }
                        } else {
                            mode3 = Mode.ALPHA;
                        }
                        c = 0;
                        break;
                    } else {
                        mode3 = Mode.ALPHA;
                        c = 0;
                        break;
                    }
                case ALPHA_SHIFT:
                    if (i3 < 26) {
                        c = (char) (i3 + 65);
                        mode3 = mode2;
                        break;
                    } else if (i3 != 26) {
                        mode3 = i3 != 900 ? mode2 : Mode.ALPHA;
                        c = 0;
                        break;
                    } else {
                        mode3 = mode2;
                        c = ' ';
                        break;
                    }
                case PUNCT_SHIFT:
                    if (i3 < 29) {
                        c = PUNCT_CHARS[i3];
                        mode3 = mode2;
                        break;
                    } else if (i3 != 29) {
                        if (i3 != 900) {
                            if (i3 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i2]);
                            }
                            mode3 = mode2;
                            c = 0;
                            break;
                        } else {
                            mode3 = Mode.ALPHA;
                            c = 0;
                            break;
                        }
                    } else {
                        mode3 = Mode.ALPHA;
                        c = 0;
                        break;
                    }
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j = 900;
        int i4 = 6;
        if (i == 901) {
            int[] iArr2 = new int[6];
            int i5 = i2 + 1;
            int i6 = iArr[i2];
            boolean z = false;
            int i7 = 0;
            long j2 = 0;
            while (i5 < iArr[0] && !z) {
                int i8 = i7 + 1;
                iArr2[i7] = i6;
                j2 = (j2 * j) + i6;
                int i9 = i5 + 1;
                i6 = iArr[i5];
                if (i6 != 928) {
                    switch (i6) {
                        case 900:
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i6) {
                                case MACRO_PDF417_TERMINATOR /* 922 */:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                    break;
                                default:
                                    if (i8 % 5 != 0 || i8 <= 0) {
                                        z = z;
                                        i5 = i9;
                                        i7 = i8;
                                        j = 900;
                                        i4 = 6;
                                        continue;
                                        continue;
                                    } else {
                                        int i10 = 0;
                                        while (i10 < i4) {
                                            byteArrayOutputStream.write((byte) (j2 >> ((5 - i10) * 8)));
                                            i10++;
                                            i4 = 6;
                                            z = z;
                                        }
                                        i5 = i9;
                                        j = 900;
                                        i7 = 0;
                                        j2 = 0;
                                    }
                                    break;
                            }
                    }
                }
                i5 = i9 - 1;
                i7 = i8;
                j = 900;
                i4 = 6;
                z = true;
            }
            if (i5 == iArr[0] && i6 < 900) {
                iArr2[i7] = i6;
                i7++;
            }
            for (int i11 = 0; i11 < i7; i11++) {
                byteArrayOutputStream.write((byte) iArr2[i11]);
            }
            i3 = i5;
        } else if (i != BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
        } else {
            i3 = i2;
            boolean z2 = false;
            int i12 = 0;
            long j3 = 0;
            while (i3 < iArr[0] && !z2) {
                int i13 = i3 + 1;
                int i14 = iArr[i3];
                if (i14 < 900) {
                    i12++;
                    j3 = (j3 * 900) + i14;
                    i3 = i13;
                } else {
                    if (i14 != 928) {
                        switch (i14) {
                            default:
                                switch (i14) {
                                    case MACRO_PDF417_TERMINATOR /* 922 */:
                                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                    case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                        break;
                                    default:
                                        i3 = i13;
                                        break;
                                }
                            case 900:
                            case 901:
                            case 902:
                                i3 = i13 - 1;
                                z2 = true;
                                break;
                        }
                    }
                    i3 = i13 - 1;
                    z2 = true;
                }
                if (i12 % 5 == 0 && i12 > 0) {
                    for (int i15 = 0; i15 < 6; i15++) {
                        byteArrayOutputStream.write((byte) (j3 >> ((5 - i15) * 8)));
                    }
                    i12 = 0;
                    j3 = 0;
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else {
                if (i4 != 928) {
                    switch (i4) {
                        default:
                            switch (i4) {
                            }
                        case 900:
                        case 901:
                            i3--;
                            z = true;
                            break;
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return bigInteger2.substring(1);
    }
}
