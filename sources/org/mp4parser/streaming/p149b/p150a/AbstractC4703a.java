package org.mp4parser.streaming.p149b.p150a;

import java.util.LinkedList;
import org.mp4parser.InterfaceC3117b;
import org.mp4parser.boxes.iso14496.p146a.DataEntryUrlBox;
import org.mp4parser.boxes.iso14496.p146a.DataInformationBox;
import org.mp4parser.boxes.iso14496.p146a.DataReferenceBox;
import org.mp4parser.boxes.iso14496.p146a.FileTypeBox;
import org.mp4parser.boxes.iso14496.p146a.HandlerBox;
import org.mp4parser.boxes.iso14496.p146a.HintMediaHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.MediaBox;
import org.mp4parser.boxes.iso14496.p146a.MediaInformationBox;
import org.mp4parser.boxes.iso14496.p146a.NullMediaHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.SampleSizeBox;
import org.mp4parser.boxes.iso14496.p146a.SampleTableBox;
import org.mp4parser.boxes.iso14496.p146a.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.p146a.SoundMediaHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.StaticChunkOffsetBox;
import org.mp4parser.boxes.iso14496.p146a.SubtitleMediaHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.p146a.TrackBox;
import org.mp4parser.boxes.iso14496.p146a.TrackHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.VideoMediaHeaderBox;
import org.mp4parser.streaming.StreamingTrack;
import org.mp4parser.streaming.p148a.DimensionTrackExtension;
import org.mp4parser.streaming.p148a.TrackIdTrackExtension;

/* renamed from: org.mp4parser.streaming.b.a.a */
/* loaded from: classes2.dex */
public abstract class DefaultBoxes {
    /* renamed from: b */
    protected abstract InterfaceC3117b mo462b();

    /* renamed from: c */
    protected abstract InterfaceC3117b mo461c(StreamingTrack streamingTrack);

    /* renamed from: a */
    public InterfaceC3117b m496a() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add("avc1");
        linkedList.add("iso6");
        linkedList.add("mp41");
        return new FileTypeBox("isom", 512L, linkedList);
    }

    /* renamed from: a */
    protected InterfaceC3117b m495a(StreamingTrack streamingTrack) {
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.m596a(streamingTrack.mo439b());
        return handlerBox;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public InterfaceC3117b m494b(StreamingTrack streamingTrack) {
        MediaBox mediaBox = new MediaBox();
        mediaBox.m746a(mo461c(streamingTrack));
        mediaBox.m746a(m495a(streamingTrack));
        mediaBox.m746a(m492d(streamingTrack));
        return mediaBox;
    }

    /* renamed from: d */
    protected InterfaceC3117b m492d(StreamingTrack streamingTrack) {
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (streamingTrack.mo439b().equals("vide")) {
            mediaInformationBox.m746a(new VideoMediaHeaderBox());
        } else if (streamingTrack.mo439b().equals("soun")) {
            mediaInformationBox.m746a(new SoundMediaHeaderBox());
        } else if (streamingTrack.mo439b().equals("text")) {
            mediaInformationBox.m746a(new NullMediaHeaderBox());
        } else if (streamingTrack.mo439b().equals("subt")) {
            mediaInformationBox.m746a(new SubtitleMediaHeaderBox());
        } else if (streamingTrack.mo439b().equals("hint")) {
            mediaInformationBox.m746a(new HintMediaHeaderBox());
        } else if (streamingTrack.mo439b().equals("sbtl")) {
            mediaInformationBox.m746a(new NullMediaHeaderBox());
        }
        mediaInformationBox.m746a(m493c());
        mediaInformationBox.m746a(m491e(streamingTrack));
        return mediaInformationBox;
    }

    /* renamed from: e */
    protected InterfaceC3117b m491e(StreamingTrack streamingTrack) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        sampleTableBox.m746a(streamingTrack.mo435d());
        sampleTableBox.m746a(new TimeToSampleBox());
        sampleTableBox.m746a(new SampleToChunkBox());
        sampleTableBox.m746a(new SampleSizeBox());
        sampleTableBox.m746a(new StaticChunkOffsetBox());
        return sampleTableBox;
    }

    /* renamed from: c */
    protected DataInformationBox m493c() {
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.m746a(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.m397c(1);
        dataReferenceBox.m746a(dataEntryUrlBox);
        return dataInformationBox;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public InterfaceC3117b m490f(StreamingTrack streamingTrack) {
        TrackBox trackBox = new TrackBox();
        trackBox.m746a(m489g(streamingTrack));
        trackBox.m746a(m494b(streamingTrack));
        return trackBox;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public InterfaceC3117b m489g(StreamingTrack streamingTrack) {
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.m647a(((TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class)).m497a());
        DimensionTrackExtension dimensionTrackExtension = (DimensionTrackExtension) streamingTrack.mo456a(DimensionTrackExtension.class);
        if (dimensionTrackExtension != null) {
            trackHeaderBox.m646b(dimensionTrackExtension.m509b());
            trackHeaderBox.m648a(dimensionTrackExtension.m510a());
        }
        return trackHeaderBox;
    }
}
