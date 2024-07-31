package com.senseplay.sdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.SPKeyMap;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.SPVehicle;
import com.senseplay.sdk.video.VideoPlay;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class VideoActivity extends Activity {
    LinearLayout ll_layout;
    SurfaceView mVideo0Surface;
    SPUsb spUsb;
    SPVehicle spVehicle;
    Timer timer;
    TextView txt_angle;
    TextView txt_car;
    TextView txt_info;
    TextView txt_speed;
    VideoPlay videoPlay;
    DecimalFormat fnum = new DecimalFormat("##0.000");
    Handler myHandler = new Handler() { // from class: com.senseplay.sdk.activity.VideoActivity.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            String str = (String) message.obj;
            if (str != null) {
                String[] split = str.split(",");
                String format = String.format("%1$.2f", Float.valueOf(Float.parseFloat(split[0])));
                String format2 = String.format("%1$.2f", Float.valueOf(Float.parseFloat(split[1])));
                TextView textView = VideoActivity.this.txt_info;
                textView.setText("bitrate0: " + format + " Mbpsbitrate1: " + format2 + " Mbps");
            }
        }
    };
    private boolean isHidden = true;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2189R.layout.video_activity);
        initView();
        initUsb();
    }

    private void initView() {
        this.mVideo0Surface = (SurfaceView) findViewById(C2189R.C2191id.video0_surface);
        this.txt_info = (TextView) findViewById(C2189R.C2191id.txt_info);
        this.ll_layout = (LinearLayout) findViewById(C2189R.C2191id.ll_layout);
        this.txt_car = (TextView) findViewById(C2189R.C2191id.txt_car);
        this.txt_speed = (TextView) findViewById(C2189R.C2191id.txt_speed);
        this.txt_angle = (TextView) findViewById(C2189R.C2191id.txt_angle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initUsb() {
        if (this.spUsb == null) {
            this.spUsb = SPUsb.getInstance();
            this.spUsb.setUsbType(0);
            this.spUsb.registerUsbReceiver(this, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.VideoActivity.1
                @Override // com.senseplay.mframe.client.MCallBack
                public void onResult(Boolean bool) {
                    if (bool.booleanValue()) {
                        VideoActivity.this.initUsb();
                    }
                }
            });
        }
        this.spUsb.openUsb(new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.VideoActivity.2
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(Boolean bool) {
                if (bool.booleanValue()) {
                    VideoActivity.this.initVideoPlay();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initVideoPlay() {
        if (this.spUsb.checkUsb()) {
            if (this.videoPlay == null) {
                this.videoPlay = new VideoPlay();
                this.videoPlay.play(this.mVideo0Surface.getHolder().getSurface());
            }
            getBtrate();
        }
    }

    private void getBtrate() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() { // from class: com.senseplay.sdk.activity.VideoActivity.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                float f;
                float f2 = 0.0f;
                if (VideoActivity.this.videoPlay != null) {
                    f2 = VideoActivity.this.videoPlay.getBtrate0();
                    f = VideoActivity.this.videoPlay.getBtrate1();
                } else {
                    f = 0.0f;
                }
                Message message = new Message();
                message.what = 1;
                message.obj = f2 + "," + f;
                VideoActivity.this.myHandler.sendMessage(message);
            }
        }, 1000L, 1000L);
    }

    private void setGear(String str) {
        this.spVehicle.setGear(str);
    }

    private void writeKeyMap(String str) {
        if (this.spUsb.checkUsb()) {
            SPKeyMap.getInstance().writeKeyMap(str, new MCallBack<Boolean>() { // from class: com.senseplay.sdk.activity.VideoActivity.5
                @Override // com.senseplay.mframe.client.MCallBack
                public void onResult(Boolean bool) {
                    if (bool.booleanValue()) {
                        Toast.makeText(VideoActivity.this, "write succ", 0).show();
                    } else {
                        Toast.makeText(VideoActivity.this, "write fail", 0).show();
                    }
                }
            });
        }
    }

    public void toHiddenView(View view) {
        if (this.isHidden) {
            this.isHidden = false;
            this.ll_layout.setVisibility(8);
            return;
        }
        this.isHidden = true;
        this.ll_layout.setVisibility(0);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        closeUsb();
        finish();
    }

    private void closeUsb() {
        VideoPlay videoPlay = this.videoPlay;
        if (videoPlay != null) {
            videoPlay.stop();
            this.videoPlay = null;
        }
        SPUsb sPUsb = this.spUsb;
        if (sPUsb != null) {
            sPUsb.unregisterUsbReceiver(this);
            this.spUsb.release();
        }
        SPManager.exit();
    }
}
