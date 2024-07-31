package com.navatics.app.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.player.content.RecentMediaStorage;
import com.navatics.app.player.widget.media.AndroidMediaController;
import com.navatics.app.player.widget.media.IjkVideoView;
import com.navatics.app.widget.dialog.MiniLoadingDialog;
import org.apache.log4j.C3044k;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public class VideoPlayerActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final C3044k f3956a = C3044k.m1564a(VideoPlayerActivity.class);

    /* renamed from: b */
    private String f3957b;

    /* renamed from: c */
    private Uri f3958c;

    /* renamed from: d */
    private AndroidMediaController f3959d;

    /* renamed from: e */
    private boolean f3960e;

    /* renamed from: f */
    private MiniLoadingDialog f3961f;
    @BindView
    LinearLayout filterDeep;
    @BindView
    LinearLayout filterShallow;
    @BindView
    ImageView ivBack;
    @BindView
    ImageView ivDelete;
    @BindView
    ImageView ivEdit;
    @BindView
    ImageView ivOff;
    @BindView
    ImageView ivPause;
    @BindView
    ImageView ivSave;
    @BindView
    IjkVideoView mVideoView;
    @BindView
    RelativeLayout photoViewerEditorBar;
    @BindView
    RelativeLayout photoViewerNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_player);
        ButterKnife.m12805a(this);
        this.f3957b = getIntent().getStringExtra("videoPath");
        Intent intent = getIntent();
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if (action.equals("android.intent.action.VIEW")) {
                this.f3957b = intent.getDataString();
            } else if (action.equals("android.intent.action.SEND")) {
                this.f3958c = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                if (Build.VERSION.SDK_INT < 14) {
                    String scheme = this.f3958c.getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        f3956a.mo1504b((Object) "Null unknown scheme");
                        finish();
                        return;
                    } else if (scheme.equals("android.resource")) {
                        this.f3957b = this.f3958c.getPath();
                    } else if (scheme.equals("content")) {
                        f3956a.mo1504b((Object) "Can not resolve content below Android-ICS\n");
                        finish();
                        return;
                    } else {
                        C3044k c3044k = f3956a;
                        c3044k.mo1504b((Object) ("Unknown scheme " + scheme + "\n"));
                        finish();
                        return;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.f3957b)) {
            new RecentMediaStorage(this).m7648a(this.f3957b);
        }
        this.f3959d = new AndroidMediaController((Context) this, false);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        this.mVideoView.setMediaController(this.f3959d);
        String str = this.f3957b;
        if (str != null) {
            this.mVideoView.setVideoPath(str);
        } else {
            Uri uri = this.f3958c;
            if (uri != null) {
                this.mVideoView.setVideoURI(uri);
            } else {
                f3956a.mo1504b((Object) "Null Data Source\n");
                finish();
                return;
            }
        }
        this.mVideoView.setOnPlayerStatusListener(new IjkVideoView.InterfaceC1876a() { // from class: com.navatics.app.activities.VideoPlayerActivity.1
            @Override // com.navatics.app.player.widget.media.IjkVideoView.InterfaceC1876a
            /* renamed from: a */
            public void mo7579a() {
                VideoPlayerActivity.this.ivPause.setVisibility(8);
            }

            @Override // com.navatics.app.player.widget.media.IjkVideoView.InterfaceC1876a
            /* renamed from: b */
            public void mo7578b() {
                VideoPlayerActivity.this.ivPause.setVisibility(0);
            }
        });
        this.ivPause.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.VideoPlayerActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayerActivity.this.mVideoView.start();
            }
        });
        this.mVideoView.start();
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        this.f3960e = true;
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f3960e || !this.mVideoView.m7618c()) {
            this.mVideoView.m7633a();
            this.mVideoView.m7623a(true);
            this.mVideoView.m7612e();
        } else {
            this.mVideoView.m7615d();
        }
        IjkMediaPlayer.native_profileEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MiniLoadingDialog miniLoadingDialog = this.f3961f;
        if (miniLoadingDialog != null) {
            miniLoadingDialog.dismiss();
            this.f3961f = null;
        }
    }
}
