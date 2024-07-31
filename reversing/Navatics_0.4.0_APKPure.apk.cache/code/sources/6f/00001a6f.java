package com.navatics.app.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class TextHintDialog extends BaseDialog {

    /* renamed from: a */
    private TextView f5681a;

    /* renamed from: b */
    private TextView f5682b;

    public TextHintDialog(Context context, String str, String str2) {
        super(context, R.layout.dialog_common_layout);
        m5892b(str, str2);
    }

    /* renamed from: b */
    private void m5892b(String str, String str2) {
        this.f5681a = (TextView) findViewById(R.id.tv_title);
        this.f5682b = (TextView) findViewById(R.id.tv_center_btn);
        this.f5682b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.widget.dialog.TextHintDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextHintDialog.this.dismiss();
            }
        });
        m5893a(str, str2);
    }

    /* renamed from: a */
    public void m5893a(String str, String str2) {
        this.f5681a.setText(str);
        this.f5682b.setText(str2);
    }
}