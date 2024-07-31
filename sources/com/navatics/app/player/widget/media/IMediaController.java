package com.navatics.app.player.widget.media;

import android.view.View;
import android.widget.MediaController;

/* renamed from: com.navatics.app.player.widget.media.b */
/* loaded from: classes.dex */
public interface IMediaController {
    void hide();

    boolean isShowing();

    void setAnchorView(View view);

    void setEnabled(boolean z);

    void setMediaPlayer(MediaController.MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);
}
