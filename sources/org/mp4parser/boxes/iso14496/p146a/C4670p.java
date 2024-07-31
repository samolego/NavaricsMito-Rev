package org.mp4parser.boxes.iso14496.p146a;

import java.util.List;
import org.mp4parser.support.AbstractContainerBox;

/* renamed from: org.mp4parser.boxes.iso14496.a.p */
/* loaded from: classes2.dex */
public class MovieFragmentBox extends AbstractContainerBox {
    public MovieFragmentBox() {
        super("moof");
    }

    /* renamed from: c */
    public List<TrackRunBox> m578c() {
        return mo525a(TrackRunBox.class, true);
    }
}
