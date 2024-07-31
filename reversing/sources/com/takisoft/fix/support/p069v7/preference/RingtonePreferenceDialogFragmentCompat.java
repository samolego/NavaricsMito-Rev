package com.takisoft.fix.support.p069v7.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.media.MediaScannerConnection;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p008v4.content.ContextCompat;
import android.support.p011v7.app.AlertDialog;
import android.support.p011v7.appcompat.C0425R;
import android.support.p011v7.preference.PreferenceDialogFragmentCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.takisoft.fix.support.p069v7.preference.ringtone.C2387R;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat */
/* loaded from: classes2.dex */
public class RingtonePreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String CURSOR_DEFAULT_ID = "-2";
    private static final String CURSOR_NONE_ID = "-1";
    private static final String TAG = "RingtonePrefDialog";
    private Cursor cursor;
    private Ringtone defaultRingtone;
    private RingtoneManager ringtoneManager;
    private int selectedIndex = -1;

    public static RingtonePreferenceDialogFragmentCompat newInstance(String str) {
        RingtonePreferenceDialogFragmentCompat ringtonePreferenceDialogFragmentCompat = new RingtonePreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        ringtonePreferenceDialogFragmentCompat.setArguments(bundle);
        return ringtonePreferenceDialogFragmentCompat;
    }

    private RingtonePreference getRingtonePreference() {
        return (RingtonePreference) getPreference();
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.support.p008v4.app.Fragment
    public void onPause() {
        super.onPause();
        stopPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPlaying() {
        Ringtone ringtone = this.defaultRingtone;
        if (ringtone != null && ringtone.isPlaying()) {
            this.defaultRingtone.stop();
        }
        RingtoneManager ringtoneManager = this.ringtoneManager;
        if (ringtoneManager != null) {
            ringtoneManager.stopPreviousRingtone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.preference.PreferenceDialogFragmentCompat
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        RingtonePreference ringtonePreference = getRingtonePreference();
        createCursor(ringtonePreference.getRingtone());
        final Context context = getContext();
        int ringtoneType = ringtonePreference.getRingtoneType();
        final boolean showDefault = ringtonePreference.getShowDefault();
        final boolean showSilent = ringtonePreference.getShowSilent();
        final Uri defaultUri = showDefault ? RingtoneManager.getDefaultUri(ringtoneType) : null;
        String[] strArr = new String[this.cursor.getCount()];
        if (this.cursor.moveToFirst()) {
            do {
                strArr[this.cursor.getPosition()] = this.cursor.getString(1);
            } while (this.cursor.moveToNext());
            builder.setSingleChoiceItems(buildAdapter(context, this.cursor), this.selectedIndex, new DialogInterface.OnClickListener() { // from class: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i < RingtonePreferenceDialogFragmentCompat.this.cursor.getCount()) {
                        RingtonePreferenceDialogFragmentCompat.this.selectedIndex = i;
                        int i2 = (i - (showDefault ? 1 : 0)) - (showSilent ? 1 : 0);
                        RingtonePreferenceDialogFragmentCompat.this.stopPlaying();
                        if (showDefault && i == 0) {
                            if (RingtonePreferenceDialogFragmentCompat.this.defaultRingtone != null) {
                                RingtonePreferenceDialogFragmentCompat.this.defaultRingtone.play();
                                return;
                            }
                            RingtonePreferenceDialogFragmentCompat.this.defaultRingtone = RingtoneManager.getRingtone(context, defaultUri);
                            if (RingtonePreferenceDialogFragmentCompat.this.defaultRingtone != null) {
                                RingtonePreferenceDialogFragmentCompat.this.defaultRingtone.play();
                                return;
                            }
                            return;
                        } else if (((showDefault && i == 1) || (!showDefault && i == 0)) && showSilent) {
                            RingtonePreferenceDialogFragmentCompat.this.ringtoneManager.stopPreviousRingtone();
                            return;
                        } else {
                            RingtonePreferenceDialogFragmentCompat.this.ringtoneManager.getRingtone(i2).play();
                            return;
                        }
                    }
                    RingtonePreferenceDialogFragmentCompat.this.newRingtone();
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (RingtonePreferenceDialogFragmentCompat.this.defaultRingtone != null) {
                        RingtonePreferenceDialogFragmentCompat.this.defaultRingtone.stop();
                    }
                    RingtonePreferenceDialogFragmentCompat.this.onDismiss(dialogInterface);
                }
            }).setNegativeButton(17039360, this).setPositiveButton(17039370, this);
        }
        builder.setSingleChoiceItems(buildAdapter(context, this.cursor), this.selectedIndex, new DialogInterface.OnClickListener() { // from class: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i < RingtonePreferenceDialogFragmentCompat.this.cursor.getCount()) {
                    RingtonePreferenceDialogFragmentCompat.this.selectedIndex = i;
                    int i2 = (i - (showDefault ? 1 : 0)) - (showSilent ? 1 : 0);
                    RingtonePreferenceDialogFragmentCompat.this.stopPlaying();
                    if (showDefault && i == 0) {
                        if (RingtonePreferenceDialogFragmentCompat.this.defaultRingtone != null) {
                            RingtonePreferenceDialogFragmentCompat.this.defaultRingtone.play();
                            return;
                        }
                        RingtonePreferenceDialogFragmentCompat.this.defaultRingtone = RingtoneManager.getRingtone(context, defaultUri);
                        if (RingtonePreferenceDialogFragmentCompat.this.defaultRingtone != null) {
                            RingtonePreferenceDialogFragmentCompat.this.defaultRingtone.play();
                            return;
                        }
                        return;
                    } else if (((showDefault && i == 1) || (!showDefault && i == 0)) && showSilent) {
                        RingtonePreferenceDialogFragmentCompat.this.ringtoneManager.stopPreviousRingtone();
                        return;
                    } else {
                        RingtonePreferenceDialogFragmentCompat.this.ringtoneManager.getRingtone(i2).play();
                        return;
                    }
                }
                RingtonePreferenceDialogFragmentCompat.this.newRingtone();
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (RingtonePreferenceDialogFragmentCompat.this.defaultRingtone != null) {
                    RingtonePreferenceDialogFragmentCompat.this.defaultRingtone.stop();
                }
                RingtonePreferenceDialogFragmentCompat.this.onDismiss(dialogInterface);
            }
        }).setNegativeButton(17039360, this).setPositiveButton(17039370, this);
    }

    @Override // android.support.p011v7.preference.PreferenceDialogFragmentCompat, android.support.p008v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = (AlertDialog) super.onCreateDialog(bundle);
        if (getRingtonePreference().shouldShowAdd()) {
            ListView listView = alertDialog.getListView();
            listView.addFooterView(LayoutInflater.from(listView.getContext()).inflate(C2387R.layout.add_ringtone_item, (ViewGroup) listView, false));
        }
        return alertDialog;
    }

    @Override // android.support.p011v7.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        int i;
        stopPlaying();
        Uri uri = null;
        this.defaultRingtone = null;
        RingtonePreference ringtonePreference = getRingtonePreference();
        boolean showDefault = ringtonePreference.getShowDefault();
        boolean showSilent = ringtonePreference.getShowSilent();
        if (!z || (i = this.selectedIndex) < 0) {
            return;
        }
        if (showDefault && i == 0) {
            uri = RingtoneManager.getDefaultUri(ringtonePreference.getRingtoneType());
        } else if (((!showDefault || this.selectedIndex != 1) && (showDefault || this.selectedIndex != 0)) || !showSilent) {
            uri = this.ringtoneManager.getRingtoneUri((this.selectedIndex - (showDefault ? 1 : 0)) - (showSilent ? 1 : 0));
        }
        if (ringtonePreference.callChangeListener(uri)) {
            ringtonePreference.setRingtone(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Cursor createCursor(Uri uri) {
        RingtonePreference ringtonePreference = getRingtonePreference();
        this.ringtoneManager = new RingtoneManager(getContext());
        this.ringtoneManager.setType(ringtonePreference.getRingtoneType());
        this.ringtoneManager.setStopPreviousRingtone(true);
        Cursor cursor = this.ringtoneManager.getCursor();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{cursor.getColumnName(0), cursor.getColumnName(1)});
        int ringtoneType = ringtonePreference.getRingtoneType();
        boolean showDefault = ringtonePreference.getShowDefault();
        boolean showSilent = ringtonePreference.getShowSilent();
        if (showDefault) {
            if (ringtoneType == 2) {
                matrixCursor.addRow(new String[]{CURSOR_DEFAULT_ID, getString(C2387R.string.notification_sound_default)});
            } else if (ringtoneType != 4) {
                matrixCursor.addRow(new String[]{CURSOR_DEFAULT_ID, getString(C2387R.string.ringtone_default)});
            } else {
                matrixCursor.addRow(new String[]{CURSOR_DEFAULT_ID, getString(C2387R.string.alarm_sound_default)});
            }
        }
        if (showSilent) {
            matrixCursor.addRow(new String[]{CURSOR_NONE_ID, getString(C2387R.string.ringtone_silent)});
        }
        this.selectedIndex = this.ringtoneManager.getRingtonePosition(uri);
        int i = this.selectedIndex;
        if (i >= 0) {
            this.selectedIndex = i + (showDefault ? 1 : 0) + (showSilent ? 1 : 0);
        }
        if (this.selectedIndex < 0 && showDefault && RingtoneManager.getDefaultType(uri) != -1) {
            this.selectedIndex = 0;
        }
        if (this.selectedIndex < 0 && showSilent) {
            this.selectedIndex = showDefault ? 1 : 0;
        }
        MergeCursor mergeCursor = new MergeCursor(new Cursor[]{matrixCursor, cursor});
        this.cursor = mergeCursor;
        return mergeCursor;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != getRingtonePreference().getCustomRingtoneRequestCode()) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            Uri data = intent.getData();
            final Context context = getContext();
            final int ringtoneType = getRingtonePreference().getRingtoneType();
            new AsyncTask<Uri, Void, Cursor>() { // from class: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Cursor doInBackground(Uri... uriArr) {
                    try {
                        return RingtonePreferenceDialogFragmentCompat.this.createCursor(RingtonePreferenceDialogFragmentCompat.addCustomExternalRingtone(context, uriArr[0], ringtoneType));
                    } catch (IOException | IllegalArgumentException e) {
                        Log.e(RingtonePreferenceDialogFragmentCompat.TAG, "Unable to add new ringtone: ", e);
                        return null;
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Cursor cursor) {
                    if (cursor != null) {
                        ListView listView = ((AlertDialog) RingtonePreferenceDialogFragmentCompat.this.getDialog()).getListView();
                        listView.setAdapter((ListAdapter) RingtonePreferenceDialogFragmentCompat.this.buildAdapter(context, cursor));
                        listView.setItemChecked(RingtonePreferenceDialogFragmentCompat.this.selectedIndex, true);
                        listView.setSelection(RingtonePreferenceDialogFragmentCompat.this.selectedIndex);
                        listView.clearFocus();
                        return;
                    }
                    Toast.makeText(context, RingtonePreferenceDialogFragmentCompat.this.getString(C2387R.string.unable_to_add_ringtone), 0).show();
                }
            }.execute(data);
        } else {
            ((AlertDialog) getDialog()).getListView().setItemChecked(this.selectedIndex, true);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == getRingtonePreference().getPermissionRequestCode() && iArr[0] == 0) {
            newRingtone();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void newRingtone() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("audio/*");
            if (Build.VERSION.SDK_INT >= 19) {
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"audio/*", "application/ogg"});
            }
            startActivityForResult(intent, getRingtonePreference().getCustomRingtoneRequestCode());
            return;
        }
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, getRingtonePreference().getPermissionRequestCode());
    }

    @WorkerThread
    public static Uri addCustomExternalRingtone(Context context, @NonNull Uri uri, int i) throws IOException {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            throw new IOException("External storage is not mounted. Unable to install ringtones.");
        }
        if ("file".equals(uri.getScheme())) {
            uri = Uri.fromFile(new File(uri.getPath()));
        }
        String type = context.getContentResolver().getType(uri);
        if (type == null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
        }
        if (type == null || (!type.startsWith("audio/") && !type.equals("application/ogg"))) {
            throw new IllegalArgumentException("Ringtone file must have MIME type \"audio/*\". Given file has MIME type \"" + type + "\"");
        }
        File uniqueExternalFile = getUniqueExternalFile(context, getDirForType(i), getFileDisplayNameFromUri(context, uri), type);
        NewRingtoneScanner newRingtoneScanner = null;
        if (uniqueExternalFile == null) {
            return null;
        }
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        FileOutputStream fileOutputStream = new FileOutputStream(uniqueExternalFile);
        if (openInputStream != null) {
            byte[] bArr = new byte[10240];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            openInputStream.close();
        }
        fileOutputStream.close();
        try {
            try {
                NewRingtoneScanner newRingtoneScanner2 = new NewRingtoneScanner(context, uniqueExternalFile);
                try {
                    Uri take = newRingtoneScanner2.take();
                    newRingtoneScanner2.close();
                    return take;
                } catch (InterruptedException e) {
                    e = e;
                    newRingtoneScanner = newRingtoneScanner2;
                    throw new IOException("Audio file failed to scan as a ringtone", e);
                } catch (Throwable th) {
                    th = th;
                    newRingtoneScanner = newRingtoneScanner2;
                    if (newRingtoneScanner != null) {
                        newRingtoneScanner.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (InterruptedException e2) {
            e = e2;
        }
    }

    private static String getDirForType(int i) {
        if (i != 4) {
            if (i != 7) {
                switch (i) {
                    case 1:
                        break;
                    case 2:
                        return Environment.DIRECTORY_NOTIFICATIONS;
                    default:
                        throw new IllegalArgumentException("Unsupported ringtone type: " + i);
                }
            }
            return Environment.DIRECTORY_RINGTONES;
        }
        return Environment.DIRECTORY_ALARMS;
    }

    private static String getFileDisplayNameFromUri(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            return uri.getLastPathSegment();
        }
        if ("content".equals(scheme)) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    return cursor.getString(cursor.getColumnIndex("_display_name"));
                }
                if (cursor != null) {
                    cursor.close();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return uri.toString();
    }

    @Nullable
    private static File getUniqueExternalFile(Context context, String str, String str2, String str3) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
        externalStoragePublicDirectory.mkdirs();
        try {
            return buildUniqueFile(externalStoragePublicDirectory, str3, str2);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Unable to get a unique file name: " + e);
            return null;
        }
    }

    @NonNull
    private static File buildUniqueFile(File file, String str, String str2) throws FileNotFoundException {
        String str3;
        String[] splitFileName = splitFileName(str, str2);
        int i = 0;
        String str4 = splitFileName[0];
        if (splitFileName[1] != null) {
            str3 = "." + splitFileName[1];
        } else {
            str3 = "";
        }
        File file2 = new File(file, str4 + str3);
        SecureRandom secureRandom = new SecureRandom();
        while (file2.exists()) {
            i = i >= 32 ? secureRandom.nextInt() : i + 1;
            file2 = new File(file, str4 + " (" + i + ")" + str3);
        }
        return file2;
    }

    @NonNull
    public static String[] splitFileName(String str, String str2) {
        String str3;
        String str4;
        int lastIndexOf = str2.lastIndexOf(46);
        String str5 = null;
        if (lastIndexOf >= 0) {
            String substring = str2.substring(0, lastIndexOf);
            str4 = str2.substring(lastIndexOf + 1);
            str3 = substring;
            str5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str4.toLowerCase());
        } else {
            str3 = str2;
            str4 = null;
        }
        if (str5 == null) {
            str5 = "application/octet-stream";
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (TextUtils.equals(str, str5) || TextUtils.equals(str4, extensionFromMimeType)) {
            str2 = str3;
        } else {
            str4 = extensionFromMimeType;
        }
        if (str4 == null) {
            str4 = "";
        }
        return new String[]{str2, str4};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CheckedItemAdapter buildAdapter(Context context, Cursor cursor) {
        String[] strArr = new String[cursor.getCount()];
        if (cursor.moveToFirst()) {
            do {
                strArr[cursor.getPosition()] = cursor.getString(1);
            } while (cursor.moveToNext());
            return new CheckedItemAdapter(context, context.obtainStyledAttributes(null, C0425R.styleable.AlertDialog, C0425R.attr.alertDialogStyle, 0).getResourceId(C0425R.styleable.AlertDialog_singleChoiceItemLayout, 0), 16908308, strArr);
        }
        return new CheckedItemAdapter(context, context.obtainStyledAttributes(null, C0425R.styleable.AlertDialog, C0425R.attr.alertDialogStyle, 0).getResourceId(C0425R.styleable.AlertDialog_singleChoiceItemLayout, 0), 16908308, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat$NewRingtoneScanner */
    /* loaded from: classes2.dex */
    public static class NewRingtoneScanner implements MediaScannerConnection.MediaScannerConnectionClient, Closeable {
        private File mFile;
        private MediaScannerConnection mMediaScannerConnection;
        private LinkedBlockingQueue<Uri> mQueue;

        private NewRingtoneScanner(Context context, File file) {
            this.mQueue = new LinkedBlockingQueue<>(1);
            this.mFile = file;
            this.mMediaScannerConnection = new MediaScannerConnection(context, this);
            this.mMediaScannerConnection.connect();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mMediaScannerConnection.disconnect();
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            this.mMediaScannerConnection.scanFile(this.mFile.getAbsolutePath(), null);
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            if (uri == null) {
                this.mFile.delete();
                return;
            }
            try {
                this.mQueue.put(uri);
            } catch (InterruptedException e) {
                Log.e(RingtonePreferenceDialogFragmentCompat.TAG, "Unable to put new ringtone Uri in queue", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Uri take() throws InterruptedException {
            return this.mQueue.take();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.takisoft.fix.support.v7.preference.RingtonePreferenceDialogFragmentCompat$CheckedItemAdapter */
    /* loaded from: classes2.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
