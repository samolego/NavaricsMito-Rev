package com.navatics.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.divelog.dao.entity.CommandCard;
import com.google.gson.JsonObject;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.p052d.DiveLogBuildHelper;
import com.navatics.app.utils.CurrentDiveLogHolder;
import io.reactivex.p096b.Consumer;
import java.io.IOException;
import java.util.Date;

/* loaded from: classes.dex */
public class AddDiveNoteActivity extends NvBaseActivity {
    @BindView
    ImageView btnBack;
    @BindView
    Button btnSave;
    @BindView
    EditText etNote;

    public static /* synthetic */ void lambda$W6CR4CEMTzRugFnDVEGC__vH2ZU(AddDiveNoteActivity addDiveNoteActivity, View view) {
        addDiveNoteActivity.m9488a(view);
    }

    public static /* synthetic */ void lambda$aWeRPtYKrkgbJ1CudftASgFnT0E(AddDiveNoteActivity addDiveNoteActivity, View view) {
        addDiveNoteActivity.m9486b(view);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_note);
        ButterKnife.m12805a(this);
        DiveLog m7403a = CurrentDiveLogHolder.m7403a();
        if (m7403a != null && m7403a.getComment() != null) {
            this.etNote.setText(m7403a.getComment());
        }
        this.btnSave.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$AddDiveNoteActivity$aWeRPtYKrkgbJ1CudftASgFnT0E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddDiveNoteActivity.lambda$aWeRPtYKrkgbJ1CudftASgFnT0E(AddDiveNoteActivity.this, view);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$AddDiveNoteActivity$W6CR4CEMTzRugFnDVEGC__vH2ZU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddDiveNoteActivity.lambda$W6CR4CEMTzRugFnDVEGC__vH2ZU(AddDiveNoteActivity.this, view);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m9486b(View view) {
        DiveLog m7403a = CurrentDiveLogHolder.m7403a();
        if (m7403a != null) {
            m7403a.setComment(this.etNote.getText().toString());
            m7403a.save();
            try {
                m9487a(m7403a);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finish();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9488a(View view) {
        finish();
    }

    /* renamed from: a */
    private void m9487a(DiveLog diveLog) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("comment", this.etNote.getText().toString());
        CommandCard filedName = CommandCard.builder().setCommand(CommandCard.UPDATE).setFiledName("comment");
        DiveLogBuildHelper.m8553a(diveLog, filedName.setStartTime(diveLog.getStartTime() + "").setCreateTime(new Date()).setJson(jsonObject.toString())).m3107a(new Consumer<Boolean>() { // from class: com.navatics.app.activities.AddDiveNoteActivity.1
            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(Boolean bool) throws Exception {
            }

            {
                AddDiveNoteActivity.this = this;
            }
        }, new Consumer<Throwable>() { // from class: com.navatics.app.activities.AddDiveNoteActivity.2
            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
            }

            {
                AddDiveNoteActivity.this = this;
            }
        });
    }
}
