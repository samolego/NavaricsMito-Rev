package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p011v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.p057cv.GLES3JNIView;

/* loaded from: classes.dex */
public class PhotoEditor_ViewBinding implements Unbinder {

    /* renamed from: b */
    private PhotoEditor f3697b;

    @UiThread
    public PhotoEditor_ViewBinding(PhotoEditor photoEditor, View view) {
        this.f3697b = photoEditor;
        photoEditor.mPhotoViewBackground = (ViewGroup) Utils.m12799a(view, R.id.photoViewBackground, "field 'mPhotoViewBackground'", ViewGroup.class);
        photoEditor.mPhotoViewerEditorBar = (ViewGroup) Utils.m12799a(view, R.id.photoViewerEditorBar, "field 'mPhotoViewerEditorBar'", ViewGroup.class);
        photoEditor.mPhotoViewFilterBar = (ViewGroup) Utils.m12799a(view, R.id.photoViewFilterBar, "field 'mPhotoViewFilterBar'", ViewGroup.class);
        photoEditor.glImageContent = (GLES3JNIView) Utils.m12799a(view, R.id.glImageContent, "field 'glImageContent'", GLES3JNIView.class);
        photoEditor.ivImageContent = (ImageView) Utils.m12799a(view, R.id.ivImageContent, "field 'ivImageContent'", ImageView.class);
        photoEditor.ivBack_Editor = (ImageView) Utils.m12799a(view, R.id.ivOff, "field 'ivBack_Editor'", ImageView.class);
        photoEditor.ivRotate_Editor = (ImageView) Utils.m12799a(view, R.id.ivRotation, "field 'ivRotate_Editor'", ImageView.class);
        photoEditor.ivFilter_Editor = (ImageView) Utils.m12799a(view, R.id.ivFilter, "field 'ivFilter_Editor'", ImageView.class);
        photoEditor.ivSave_Editor = (ImageView) Utils.m12799a(view, R.id.ivSave, "field 'ivSave_Editor'", ImageView.class);
        photoEditor.ivOff_Filter = (ImageView) Utils.m12799a(view, R.id.ivFilterOff, "field 'ivOff_Filter'", ImageView.class);
        photoEditor.ivSave_Filter = (ImageView) Utils.m12799a(view, R.id.ivFilterSave, "field 'ivSave_Filter'", ImageView.class);
        photoEditor.mFilterList = (RecyclerView) Utils.m12799a(view, R.id.filterList, "field 'mFilterList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        PhotoEditor photoEditor = this.f3697b;
        if (photoEditor == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3697b = null;
        photoEditor.mPhotoViewBackground = null;
        photoEditor.mPhotoViewerEditorBar = null;
        photoEditor.mPhotoViewFilterBar = null;
        photoEditor.glImageContent = null;
        photoEditor.ivImageContent = null;
        photoEditor.ivBack_Editor = null;
        photoEditor.ivRotate_Editor = null;
        photoEditor.ivFilter_Editor = null;
        photoEditor.ivSave_Editor = null;
        photoEditor.ivOff_Filter = null;
        photoEditor.ivSave_Filter = null;
        photoEditor.mFilterList = null;
    }
}
