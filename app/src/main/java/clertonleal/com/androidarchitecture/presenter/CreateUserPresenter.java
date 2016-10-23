package clertonleal.com.androidarchitecture.presenter;


import clertonleal.com.androidarchitecture.model.User;

public class CreateUserPresenter {

    private CreateUserView createUserView;

    public CreateUserPresenter(CreateUserView createUserView) {
        this.createUserView = createUserView;
    }

    private boolean isFormFilled() {
        if (createUserView.getFirstName().isEmpty()) {
            createUserView.setFirstNameError();
            return false;
        } else if (createUserView.getLastName().isEmpty()) {
            createUserView.setLastNameError();
            return false;
        } else if (createUserView.getRg().isEmpty()) {
            createUserView.setRgError();
            return false;
        } else if (createUserView.getCpf().isEmpty()) {
            createUserView.setCpfError();
            return false;
        } else if (createUserView.getEmail().isEmpty()) {
            createUserView.setEmailError();
            return false;
        }

        return true;
    }

    public void validateAndCreateUser() {
        if (isFormFilled()) {
            User user = new User();
            user.setFirstName(createUserView.getFirstName());
            user.setLastName(createUserView.getLastName());
            user.setRg(createUserView.getRg());
            user.setCpf(createUserView.getCpf());
            user.setEmail(createUserView.getEmail());

            createUserView.createUser(user);
        }
    }
}
