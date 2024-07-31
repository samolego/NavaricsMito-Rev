package com.navatics.app.player.content;

import android.database.Cursor;
import android.support.p008v4.content.AsyncTaskLoader;
import java.io.File;

/* loaded from: classes.dex */
public class PathCursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: a */
    private File f4882a;

    @Override // android.support.p008v4.content.AsyncTaskLoader
    /* renamed from: a */
    public Cursor loadInBackground() {
        return new PathCursor(this.f4882a, this.f4882a.listFiles());
    }

    @Override // android.support.p008v4.content.Loader
    protected void onStartLoading() {
        forceLoad();
    }
}
