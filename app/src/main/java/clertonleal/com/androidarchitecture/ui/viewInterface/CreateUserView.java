package clertonleal.com.androidarchitecture.ui.viewInterface;


import clertonleal.com.androidarchitecture.model.User;

public interface CreateUserView {

    void onUserCreated(User user);
    void showError();

}
