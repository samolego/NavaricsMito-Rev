package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.ComposerController;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ComposerView extends LinearLayout {

    /* renamed from: a */
    ImageView f8833a;

    /* renamed from: b */
    ImageView f8834b;

    /* renamed from: c */
    EditText f8835c;

    /* renamed from: d */
    TextView f8836d;

    /* renamed from: e */
    Button f8837e;

    /* renamed from: f */
    ObservableScrollView f8838f;

    /* renamed from: g */
    View f8839g;

    /* renamed from: h */
    ColorDrawable f8840h;

    /* renamed from: i */
    ImageView f8841i;

    /* renamed from: j */
    ComposerController.InterfaceC2710a f8842j;

    /* renamed from: k */
    private Picasso f8843k;

    public ComposerView(Context context) {
        this(context, null);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4211a(context);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4211a(context);
    }

    /* renamed from: a */
    private void m4211a(Context context) {
        this.f8843k = Picasso.m5798a(getContext());
        this.f8840h = new ColorDrawable(context.getResources().getColor(R.color.tw__composer_light_gray));
        inflate(context, R.layout.tw__composer_view, this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        m4212a();
        this.f8834b.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetcomposer.ComposerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ComposerView.this.f8842j.mo4193a();
            }
        });
        this.f8837e.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetcomposer.ComposerView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ComposerView.this.f8842j.mo4191b(ComposerView.this.getTweetText());
            }
        });
        this.f8835c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.twitter.sdk.android.tweetcomposer.ComposerView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                ComposerView.this.f8842j.mo4191b(ComposerView.this.getTweetText());
                return true;
            }
        });
        this.f8835c.addTextChangedListener(new TextWatcher() { // from class: com.twitter.sdk.android.tweetcomposer.ComposerView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ComposerView.this.f8842j.mo4192a(ComposerView.this.getTweetText());
            }
        });
        this.f8838f.setScrollViewListener(new ObservableScrollView.InterfaceC2715a() { // from class: com.twitter.sdk.android.tweetcomposer.ComposerView.5
            @Override // com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView.InterfaceC2715a
            /* renamed from: a */
            public void mo4165a(int i) {
                if (i > 0) {
                    ComposerView.this.f8839g.setVisibility(0);
                } else {
                    ComposerView.this.f8839g.setVisibility(4);
                }
            }
        });
    }

    /* renamed from: a */
    void m4212a() {
        this.f8833a = (ImageView) findViewById(R.id.tw__author_avatar);
        this.f8834b = (ImageView) findViewById(R.id.tw__composer_close);
        this.f8835c = (EditText) findViewById(R.id.tw__edit_tweet);
        this.f8836d = (TextView) findViewById(R.id.tw__char_count);
        this.f8837e = (Button) findViewById(R.id.tw__post_tweet);
        this.f8838f = (ObservableScrollView) findViewById(R.id.tw__composer_scroll_view);
        this.f8839g = findViewById(R.id.tw__composer_profile_divider);
        this.f8841i = (ImageView) findViewById(R.id.tw__image_view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallbacks(ComposerController.InterfaceC2710a interfaceC2710a) {
        this.f8842j = interfaceC2710a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProfilePhotoView(User user) {
        String m4512a = UserUtils.m4512a(user, UserUtils.AvatarSize.REASONABLY_SMALL);
        Picasso picasso = this.f8843k;
        if (picasso != null) {
            picasso.m5787a(m4512a).m5654a(this.f8840h).m5653a(this.f8833a);
        }
    }

    String getTweetText() {
        return this.f8835c.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTweetText(String str) {
        this.f8835c.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCharCount(int i) {
        this.f8836d.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCharCountTextStyle(int i) {
        this.f8836d.setTextAppearance(getContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4210a(boolean z) {
        this.f8837e.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageView(Uri uri) {
        if (this.f8843k != null) {
            this.f8841i.setVisibility(0);
            this.f8843k.m5796a(uri).m5653a(this.f8841i);
        }
    }
}
