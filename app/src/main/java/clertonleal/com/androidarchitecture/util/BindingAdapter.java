package clertonleal.com.androidarchitecture.util;

import android.widget.EditText;

public class BindingAdapter {

    @android.databinding.BindingAdapter("app:fillError")
    public static void setErrorToEditText(EditText editText, String error) {
        editText.setError(error);
    }

}
