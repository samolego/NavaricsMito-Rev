package com.navatics.app.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.navatics.app.framework.provider.PhotosProvider;

/* loaded from: classes.dex */
public class PhotoContainer {
    private int indexOfUri;
    private Cursor mCursor;
    private SparseArray<Photo> photoList = new SparseArray<>();

    public static PhotoContainer from(Cursor cursor) {
        return new PhotoContainer(cursor);
    }

    public static PhotoContainer emptyList() {
        return new PhotoContainer(null);
    }

    private PhotoContainer(Cursor cursor) {
        this.mCursor = cursor;
        if (cursor != null) {
            this.indexOfUri = cursor.getColumnIndex(PhotosProvider.C1843a.f4774a);
        }
    }

    public int size() {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Photo get(int i) {
        Cursor cursor;
        Photo photo = this.photoList.get(i);
        if (photo != null || (cursor = this.mCursor) == null || cursor.isClosed() || !this.mCursor.moveToPosition(i)) {
            return photo;
        }
        Photo photo2 = new Photo(this.mCursor.getString(this.indexOfUri));
        this.photoList.put(i, photo2);
        return photo2;
    }
}
