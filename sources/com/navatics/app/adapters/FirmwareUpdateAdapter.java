package com.navatics.app.adapters;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.p011v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.framework.firmware.FirmwareUpdateInfo;
import com.navatics.app.widget.ExpandableTextView;
import com.navatics.app.widget.RotatingImageView;
import com.navatics.robot.utils.DpiUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FirmwareUpdateAdapter extends RecyclerView.Adapter<FrameHolder> {

    /* renamed from: a */
    private List<FirmwareUpdateInfo> f4029a = new ArrayList();

    /* renamed from: b */
    private Context f4030b;

    /* renamed from: c */
    private InterfaceC1709a f4031c;

    /* renamed from: com.navatics.app.adapters.FirmwareUpdateAdapter$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1709a {
        /* renamed from: a */
        void mo7469a(FirmwareUpdateInfo firmwareUpdateInfo);
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull FrameHolder frameHolder, int i) {
    }

    /* loaded from: classes.dex */
    public class FrameHolder_ViewBinding implements Unbinder {

        /* renamed from: b */
        private FrameHolder f4036b;

        @UiThread
        public FrameHolder_ViewBinding(FrameHolder frameHolder, View view) {
            this.f4036b = frameHolder;
            frameHolder.ivUpdate = (RotatingImageView) Utils.m12799a(view, R.id.iv_update, "field 'ivUpdate'", RotatingImageView.class);
            frameHolder.tvName = (TextView) Utils.m12799a(view, R.id.tv_name, "field 'tvName'", TextView.class);
            frameHolder.tvVersion = (TextView) Utils.m12799a(view, R.id.tv_version, "field 'tvVersion'", TextView.class);
            frameHolder.llIndicator = (LinearLayout) Utils.m12799a(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
            frameHolder.llDes = (LinearLayout) Utils.m12799a(view, R.id.ll_des, "field 'llDes'", LinearLayout.class);
            frameHolder.tvRight = (TextView) Utils.m12799a(view, R.id.tv_right, "field 'tvRight'", TextView.class);
            frameHolder.tvConnectHint = (TextView) Utils.m12799a(view, R.id.tv_connect_hint, "field 'tvConnectHint'", TextView.class);
            frameHolder.seekBar = (SeekBar) Utils.m12799a(view, R.id.seek_bar, "field 'seekBar'", SeekBar.class);
            frameHolder.expandableText = (TextView) Utils.m12799a(view, R.id.expandable_text, "field 'expandableText'", TextView.class);
            frameHolder.expandableTextView = (ExpandableTextView) Utils.m12799a(view, R.id.expandableTextView, "field 'expandableTextView'", ExpandableTextView.class);
            frameHolder.tvUpdate = (TextView) Utils.m12799a(view, R.id.tv_update, "field 'tvUpdate'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        /* renamed from: a */
        public void mo7436a() {
            FrameHolder frameHolder = this.f4036b;
            if (frameHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f4036b = null;
            frameHolder.ivUpdate = null;
            frameHolder.tvName = null;
            frameHolder.tvVersion = null;
            frameHolder.llIndicator = null;
            frameHolder.llDes = null;
            frameHolder.tvRight = null;
            frameHolder.tvConnectHint = null;
            frameHolder.seekBar = null;
            frameHolder.expandableText = null;
            frameHolder.expandableTextView = null;
            frameHolder.tvUpdate = null;
        }
    }

    public FirmwareUpdateAdapter(Context context) {
        this.f4030b = context;
    }

    /* renamed from: a */
    public void m8830a(List<FirmwareUpdateInfo> list) {
        this.f4029a = list;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m8831a(FirmwareUpdateInfo firmwareUpdateInfo) {
        for (int i = 0; i < this.f4029a.size(); i++) {
            if (this.f4029a.get(i).m8214h() == firmwareUpdateInfo.m8214h()) {
                if (this.f4029a.get(i).m8216f() == 1 && firmwareUpdateInfo.m8216f() == 0) {
                    return;
                }
                this.f4029a.get(i).m8228a(firmwareUpdateInfo);
                if (firmwareUpdateInfo.m8216f() == 1) {
                    notifyItemChanged(i, 0);
                    return;
                } else {
                    notifyItemChanged(i, null);
                    return;
                }
            }
        }
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: a */
    public FrameHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FrameHolder(LayoutInflater.from(this.f4030b).inflate(R.layout.frame_firmware_update, viewGroup, false));
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull FrameHolder frameHolder, int i, @NonNull List<Object> list) {
        List<FirmwareUpdateInfo> list2 = this.f4029a;
        if (list2 == null || list2.size() < 1) {
            return;
        }
        final FirmwareUpdateInfo firmwareUpdateInfo = this.f4029a.get(i);
        if (list.isEmpty()) {
            if (firmwareUpdateInfo.m8216f() != 3) {
                frameHolder.tvVersion.setText(firmwareUpdateInfo.m8230a());
                if (firmwareUpdateInfo.m8216f() != 1) {
                    frameHolder.expandableTextView.m7263a(frameHolder.expandableText, frameHolder.tvRight, frameHolder.llIndicator);
                    frameHolder.expandableTextView.setText(firmwareUpdateInfo.m8220d());
                    frameHolder.tvUpdate.setText(this.f4030b.getString(R.string.update));
                    frameHolder.tvVersion.setText(firmwareUpdateInfo.m8230a());
                    frameHolder.tvUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.adapters.FirmwareUpdateAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    });
                } else {
                    frameHolder.tvUpdate.setText(this.f4030b.getString(R.string.updating_setting));
                }
            }
            frameHolder.tvName.setText(firmwareUpdateInfo.m8226b());
            frameHolder.ivUpdate.setVisibility(0);
            frameHolder.llDes.setVisibility(0);
            frameHolder.tvConnectHint.setVisibility(8);
            frameHolder.tvRight.setText("");
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameHolder.tvRight.getLayoutParams();
            layoutParams.width = DpiUtils.m5887a(this.f4030b, 7.0f);
            layoutParams.height = DpiUtils.m5887a(this.f4030b, 13.0f);
            frameHolder.tvRight.setLayoutParams(layoutParams);
            if (firmwareUpdateInfo.m8216f() == 3) {
                frameHolder.ivUpdate.m7100c();
                frameHolder.llDes.setVisibility(8);
                frameHolder.tvRight.setBackgroundResource(0);
                layoutParams.height = -2;
                layoutParams.width = -2;
                frameHolder.tvRight.setLayoutParams(layoutParams);
                frameHolder.tvRight.setText(this.f4030b.getString(R.string.latest_version_setting));
                frameHolder.tvRight.setTextColor(this.f4030b.getResources().getColor(R.color.color_80000000));
            } else if (firmwareUpdateInfo.m8216f() == 2) {
                frameHolder.ivUpdate.m7101b();
                frameHolder.tvConnectHint.setVisibility(0);
                if (firmwareUpdateInfo.m8214h() == 0) {
                    frameHolder.tvConnectHint.setText(this.f4030b.getString(R.string.need_connect_mito));
                } else if (firmwareUpdateInfo.m8214h() == 1) {
                    frameHolder.tvConnectHint.setText(this.f4030b.getString(R.string.need_connect_controller));
                }
            } else if (firmwareUpdateInfo.m8216f() == 1) {
                frameHolder.seekBar.setProgress(firmwareUpdateInfo.m8215g());
                frameHolder.ivUpdate.m7102a(400).m7103a();
            } else if (firmwareUpdateInfo.m8216f() == 0) {
                frameHolder.seekBar.setProgress(0);
            } else if (firmwareUpdateInfo.m8216f() == 4) {
                frameHolder.ivUpdate.m7100c();
                frameHolder.llDes.setVisibility(8);
                frameHolder.tvRight.setBackgroundResource(0);
                layoutParams.height = -2;
                layoutParams.width = -2;
                frameHolder.tvRight.setLayoutParams(layoutParams);
                frameHolder.tvRight.setTextColor(this.f4030b.getResources().getColor(R.color.color_E74103));
                frameHolder.tvRight.setText(this.f4030b.getString(R.string.version_not_obtained));
            }
            frameHolder.tvUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.adapters.FirmwareUpdateAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FirmwareUpdateAdapter.this.f4031c != null) {
                        FirmwareUpdateAdapter.this.f4031c.mo7469a(firmwareUpdateInfo);
                    }
                }
            });
        } else if (((Integer) list.get(0)).intValue() != 0) {
        } else {
            frameHolder.ivUpdate.m7102a(400).m7103a();
            frameHolder.seekBar.setProgress(firmwareUpdateInfo.m8215g());
            frameHolder.tvUpdate.setText(this.f4030b.getString(R.string.updating_setting));
        }
    }

    @Override // android.support.p011v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f4029a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class FrameHolder extends RecyclerView.ViewHolder {
        @BindView
        TextView expandableText;
        @BindView
        ExpandableTextView expandableTextView;
        @BindView
        RotatingImageView ivUpdate;
        @BindView
        LinearLayout llDes;
        @BindView
        LinearLayout llIndicator;
        @BindView
        SeekBar seekBar;
        @BindView
        TextView tvConnectHint;
        @BindView
        TextView tvName;
        @BindView
        TextView tvRight;
        @BindView
        TextView tvUpdate;
        @BindView
        TextView tvVersion;

        public FrameHolder(View view) {
            super(view);
            ButterKnife.m12803a(this, view);
        }
    }

    /* renamed from: a */
    public void m8833a(InterfaceC1709a interfaceC1709a) {
        this.f4031c = interfaceC1709a;
    }
}
