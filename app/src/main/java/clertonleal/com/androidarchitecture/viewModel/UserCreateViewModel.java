package clertonleal.com.androidarchitecture.viewModel;


import android.databinding.ObservableField;
import android.text.TextUtils;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.CreateUserView;

public class UserCreateViewModel {

    private User user = new User();
    private CreateUserView createUserView;

    public ObservableField<String> firstNameError = new ObservableField<>();
    public ObservableField<String> lastNameError = new ObservableField<>();
    public ObservableField<String> rgError = new ObservableField<>();
    public ObservableField<String> cpfError = new ObservableField<>();
    public ObservableField<String> emailError = new ObservableField<>();

    public UserCreateViewModel(CreateUserView createUserView) {
        this.createUserView = createUserView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void userCreated(User user) {
        if (isFormFilled(user)) {
            createUserView.onUserCreated(user);
        }
    }

    private boolean isFormFilled(User user) {
        if (TextUtils.isEmpty(user.getFirstName())) {
            firstNameError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (TextUtils.isEmpty(user.getLastName())) {
            lastNameError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (TextUtils.isEmpty(user.getRg())) {
            rgError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (TextUtils.isEmpty(user.getCpf())) {
            cpfError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (TextUtils.isEmpty(user.getEmail())) {
            emailError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        }

        return true;
    }
}
