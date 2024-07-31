package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public final class Version {
    private static final Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    private Version(int i, int i2, int i3, int i4, int i5, ECBlocks eCBlocks) {
        this.versionNumber = i;
        this.symbolSizeRows = i2;
        this.symbolSizeColumns = i3;
        this.dataRegionSizeRows = i4;
        this.dataRegionSizeColumns = i5;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int i6 = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            i6 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = i6;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public static Version getVersionForDimensions(int i, int i2) throws FormatException {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (Version version : VERSIONS) {
            if (version.symbolSizeRows == i && version.symbolSizeColumns == i2) {
                return version;
            }
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewords;

        private ECBlocks(int i, ECB ecb) {
            this.ecCodewords = i;
            this.ecBlocks = new ECB[]{ecb};
        }

        private ECBlocks(int i, ECB ecb, ECB ecb2) {
            this.ecCodewords = i;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getECCodewords() {
            return this.ecCodewords;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ECB {
        private final int count;
        private final int dataCodewords;

        private ECB(int i, int i2) {
            this.count = i;
            this.dataCodewords = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getDataCodewords() {
            return this.dataCodewords;
        }
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }

    private static Version[] buildVersions() {
        int i = 1;
        int i2 = 5;
        int i3 = 8;
        int i4 = 7;
        Version version = new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(i, i3)));
        int i5 = 2;
        int i6 = 12;
        int i7 = 18;
        Version version2 = new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(i, 18)));
        int i8 = 4;
        Version version3 = new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(i, 30)));
        int i9 = 6;
        ECB ecb = new ECB(i, 36);
        ECB ecb2 = new ECB(i, 44);
        ECB ecb3 = new ECB(i, 62);
        ECB ecb4 = new ECB(i, 86);
        ECB ecb5 = new ECB(i, 114);
        ECB ecb6 = new ECB(i, IjkMediaMeta.FF_PROFILE_H264_HIGH_444);
        int i10 = 56;
        ECB ecb7 = new ECB(i, 174);
        Version version4 = new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(i5, 102)));
        ECB ecb8 = new ECB(i8, 92);
        ECB ecb9 = new ECB(i8, 114);
        ECB ecb10 = new ECB(i8, 174);
        ECB ecb11 = new ECB(i9, 175);
        return new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(i2, new ECB(i, 3))), new Version(2, 12, 12, 10, 10, new ECBlocks(i4, new ECB(i, i2))), version, new Version(4, 16, 16, 14, 14, new ECBlocks(i6, new ECB(i, i6))), version2, new Version(6, 20, 20, 18, 18, new ECBlocks(i7, new ECB(i, 22))), version3, new Version(8, 24, 24, 22, 22, new ECBlocks(24, ecb)), new Version(9, 26, 26, 24, 24, new ECBlocks(28, ecb2)), new Version(10, 32, 32, 14, 14, new ECBlocks(36, ecb3)), new Version(11, 36, 36, 16, 16, new ECBlocks(42, ecb4)), new Version(12, 40, 40, 18, 18, new ECBlocks(48, ecb5)), new Version(13, 44, 44, 20, 20, new ECBlocks(56, ecb6)), new Version(14, 48, 48, 22, 22, new ECBlocks(68, ecb7)), version4, new Version(16, 64, 64, 14, 14, new ECBlocks(i10, new ECB(i5, 140))), new Version(17, 72, 72, 16, 16, new ECBlocks(36, ecb8)), new Version(18, 80, 80, 18, 18, new ECBlocks(48, ecb9)), new Version(19, 88, 88, 20, 20, new ECBlocks(i10, new ECB(i8, IjkMediaMeta.FF_PROFILE_H264_HIGH_444))), new Version(20, 96, 96, 22, 22, new ECBlocks(68, ecb10)), new Version(21, 104, 104, 24, 24, new ECBlocks(i10, new ECB(i9, 136))), new Version(22, 120, 120, 18, 18, new ECBlocks(68, ecb11)), new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(i3, 163))), new Version(24, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 22, 22, new ECBlocks(62, new ECB(i3, 156), new ECB(i5, 155))), new Version(25, 8, 18, 6, 16, new ECBlocks(i4, new ECB(i, i2))), new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(i, 10))), new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(i, 16))), new Version(28, 12, 36, 10, 16, new ECBlocks(i7, new ECB(i, 22))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(i, 32))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(i, 49)))};
    }
}