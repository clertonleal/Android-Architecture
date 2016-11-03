package clertonleal.com.androidarchitecture.viewModel;


import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.CreateUserView;

public class CreateUserViewModel {

    private User user = new User();
    private CreateUserView createUserView;

    public ObservableField<String> firstNameError = new ObservableField<>();
    public ObservableField<String> lastNameError = new ObservableField<>();
    public ObservableField<String> rgError = new ObservableField<>();
    public ObservableField<String> cpfError = new ObservableField<>();
    public ObservableField<String> emailError = new ObservableField<>();

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
            firstNameError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (isEmpty(user.getLastName())) {
            lastNameError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (isEmpty(user.getRg())) {
            rgError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (isEmpty(user.getCpf())) {
            cpfError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        } else if (isEmpty(user.getEmail())) {
            emailError.set(createUserView.getString(R.string.mandatory_field));
            return false;
        }

        return true;
    }

    public boolean isEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }
}
