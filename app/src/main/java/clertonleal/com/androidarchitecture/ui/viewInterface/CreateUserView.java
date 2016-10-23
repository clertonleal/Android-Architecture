package clertonleal.com.androidarchitecture.ui.viewInterface;


import android.support.annotation.StringRes;

import clertonleal.com.androidarchitecture.model.User;

public interface CreateUserView {

    void onUserCreated(User user);
    String getString(@StringRes int resource);

}
