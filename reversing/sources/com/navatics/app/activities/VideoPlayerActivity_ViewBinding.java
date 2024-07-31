package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.player.widget.media.IjkVideoView;

/* loaded from: classes.dex */
public class VideoPlayerActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private VideoPlayerActivity f3964b;

    @UiThread
    public VideoPlayerActivity_ViewBinding(VideoPlayerActivity videoPlayerActivity, View view) {
        this.f3964b = videoPlayerActivity;
        videoPlayerActivity.ivBack = (ImageView) Utils.m12799a(view, R.id.ivBack, "field 'ivBack'", ImageView.class);
        videoPlayerActivity.ivDelete = (ImageView) Utils.m12799a(view, R.id.ivDelete, "field 'ivDelete'", ImageView.class);
        videoPlayerActivity.ivEdit = (ImageView) Utils.m12799a(view, R.id.ivEdit, "field 'ivEdit'", ImageView.class);
        videoPlayerActivity.photoViewerNavigationBar = (RelativeLayout) Utils.m12799a(view, R.id.photoViewerNavigationBar, "field 'photoViewerNavigationBar'", RelativeLayout.class);
        videoPlayerActivity.ivOff = (ImageView) Utils.m12799a(view, R.id.ivOff, "field 'ivOff'", ImageView.class);
        videoPlayerActivity.ivSave = (ImageView) Utils.m12799a(view, R.id.ivSave, "field 'ivSave'", ImageView.class);
        videoPlayerActivity.photoViewerEditorBar = (RelativeLayout) Utils.m12799a(view, R.id.photoViewerEditorBar, "field 'photoViewerEditorBar'", RelativeLayout.class);
        videoPlayerActivity.ivPause = (ImageView) Utils.m12799a(view, R.id.iv_pause, "field 'ivPause'", ImageView.class);
        videoPlayerActivity.mVideoView = (IjkVideoView) Utils.m12799a(view, R.id.video_view, "field 'mVideoView'", IjkVideoView.class);
        videoPlayerActivity.filterShallow = (LinearLayout) Utils.m12799a(view, R.id.filter_shallow, "field 'filterShallow'", LinearLayout.class);
        videoPlayerActivity.filterDeep = (LinearLayout) Utils.m12799a(view, R.id.filter_deep, "field 'filterDeep'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        VideoPlayerActivity videoPlayerActivity = this.f3964b;
        if (videoPlayerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3964b = null;
        videoPlayerActivity.ivBack = null;
        videoPlayerActivity.ivDelete = null;
        videoPlayerActivity.ivEdit = null;
        videoPlayerActivity.photoViewerNavigationBar = null;
        videoPlayerActivity.ivOff = null;
        videoPlayerActivity.ivSave = null;
        videoPlayerActivity.photoViewerEditorBar = null;
        videoPlayerActivity.ivPause = null;
        videoPlayerActivity.mVideoView = null;
        videoPlayerActivity.filterShallow = null;
        videoPlayerActivity.filterDeep = null;
    }
}
