package clertonleal.com.androidarchitecture.viewModel;


import android.support.annotation.Nullable;

import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.CreateUserView;

public class CreateUserViewModel {

    private User user = new User();
    private CreateUserView createUserView;

    public CreateUserViewModel(CreateUserView createUserView) {
        this.createUserView = createUserView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void onCreateUser(User user) {
        if (isFormFilled(user)) {
            createUserView.onUserCreated(user);
        }
    }

    private boolean isFormFilled(User user) {
        if (isEmpty(user.getFirstName())) {
            createUserView.showError();
            return false;
        } else if (isEmpty(user.getLastName())) {
            createUserView.showError();
            return false;
        } else if (isEmpty(user.getRg())) {
            createUserView.showError();
            return false;
        } else if (isEmpty(user.getCpf())) {
            createUserView.showError();
            return false;
        } else if (isEmpty(user.getEmail())) {
            createUserView.showError();
            return false;
        }

        return true;
    }

    public boolean isEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }
}
