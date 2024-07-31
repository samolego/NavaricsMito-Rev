package com.senseplay.sdk.model.pciture;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;
import com.senseplay.sdk.C2111R;

/* loaded from: classes2.dex */
public class PictureDialog extends Dialog {
    private Button btn_cancel;
    private Button btn_photo;
    private Button btn_picture;
    private PictureListener listener;

    /* loaded from: classes2.dex */
    public interface PictureListener {
        void clear();

        void takePhoto();

        void takePicture();
    }

    public PictureDialog(@NonNull Context context) {
        super(context, C2111R.style.alert_dialog);
    }

    public PictureDialog(@NonNull Context context, @StyleRes int i) {
        super(context, i);
    }

    protected PictureDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public void setPictureListener(PictureListener pictureListener) {
        this.listener = pictureListener;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2111R.layout.dialog_picture);
        initView();
        setParams();
    }

    private void initView() {
        setCanceledOnTouchOutside(false);
        this.btn_picture = (Button) findViewById(C2111R.id.btn_picture);
        this.btn_picture.setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.model.pciture.PictureDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PictureDialog.this.listener != null) {
                    PictureDialog.this.listener.takePicture();
                }
                PictureDialog.this.dismiss();
            }
        });
        this.btn_photo = (Button) findViewById(C2111R.id.btn_photo);
        this.btn_photo.setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.model.pciture.PictureDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PictureDialog.this.listener != null) {
                    PictureDialog.this.listener.takePhoto();
                }
                PictureDialog.this.dismiss();
            }
        });
        this.btn_cancel = (Button) findViewById(C2111R.id.btn_cancel);
        this.btn_cancel.setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.model.pciture.PictureDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PictureDialog.this.listener != null) {
                    PictureDialog.this.listener.clear();
                }
                PictureDialog.this.dismiss();
            }
        });
    }

    private void setParams() {
        getWindow().setGravity(80);
    }
}