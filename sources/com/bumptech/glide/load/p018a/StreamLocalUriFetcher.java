package com.bumptech.glide.load.p018a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.n */
/* loaded from: classes.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {

    /* renamed from: a */
    private static final UriMatcher f592a = new UriMatcher(-1);

    static {
        f592a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f592a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f592a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f592a.addURI("com.android.contacts", "contacts/#", 3);
        f592a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f592a.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p018a.LocalUriFetcher
    /* renamed from: a */
    public InputStream mo12385b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream m12384c = m12384c(uri, contentResolver);
        if (m12384c != null) {
            return m12384c;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    /* renamed from: c */
    private InputStream m12384c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f592a.match(uri);
        if (match != 1) {
            if (match == 3) {
                return m12389a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return m12389a(contentResolver, lookupContact);
    }

    /* renamed from: a */
    private InputStream m12389a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p018a.LocalUriFetcher
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo12386a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo7366a() {
        return InputStream.class;
    }
}
