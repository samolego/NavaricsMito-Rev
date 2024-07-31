package org.mp4parser.streaming.input.h264;

import org.mp4parser.streaming.SampleExtension;
import org.mp4parser.streaming.input.h264.spspps.SliceHeader;

/* renamed from: org.mp4parser.streaming.input.h264.e */
/* loaded from: classes2.dex */
class PictureOrderCountType0SampleExtension implements SampleExtension {

    /* renamed from: a */
    int f12223a;

    /* renamed from: b */
    int f12224b;

    public PictureOrderCountType0SampleExtension(SliceHeader sliceHeader, PictureOrderCountType0SampleExtension pictureOrderCountType0SampleExtension) {
        int i;
        int i2;
        if (pictureOrderCountType0SampleExtension != null) {
            i2 = pictureOrderCountType0SampleExtension.f12224b;
            i = pictureOrderCountType0SampleExtension.f12223a;
        } else {
            i = 0;
            i2 = 0;
        }
        int i3 = 1 << (sliceHeader.f12238n.f12324k + 4);
        this.f12224b = sliceHeader.f12233i;
        this.f12223a = 0;
        int i4 = this.f12224b;
        if (i4 < i2 && i2 - i4 >= i3 / 2) {
            this.f12223a = i + i3;
            return;
        }
        int i5 = this.f12224b;
        if (i5 > i2 && i5 - i2 > i3 / 2) {
            this.f12223a = i - i3;
        } else {
            this.f12223a = i;
        }
    }

    /* renamed from: a */
    public int m431a() {
        return this.f12223a + this.f12224b;
    }

    public String toString() {
        return "picOrderCntMsb=" + this.f12223a + ", picOrderCountLsb=" + this.f12224b;
    }
}
