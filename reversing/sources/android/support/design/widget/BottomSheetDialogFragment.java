package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.p011v7.app.AppCompatDialogFragment;

/* loaded from: classes.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    @Override // android.support.p011v7.app.AppCompatDialogFragment, android.support.p008v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
