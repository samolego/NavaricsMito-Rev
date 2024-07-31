package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@ListenerClass
/* loaded from: classes.dex */
public @interface OnItemSelected {

    /* loaded from: classes.dex */
    public enum Callback {
        ITEM_SELECTED,
        NOTHING_SELECTED
    }
}
