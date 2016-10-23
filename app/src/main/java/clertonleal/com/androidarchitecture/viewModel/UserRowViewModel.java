package clertonleal.com.androidarchitecture.viewModel;

import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.ListUserView;

public class UserRowViewModel {

    private ListUserView listUserView;
    private User user;

    public UserRowViewModel(ListUserView listUserView) {
        this.listUserView = listUserView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void onUserClick(User user) {
        listUserView.onUserClick(user);
    }
}
