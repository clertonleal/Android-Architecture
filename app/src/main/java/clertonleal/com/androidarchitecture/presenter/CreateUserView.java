package clertonleal.com.androidarchitecture.presenter;


import clertonleal.com.androidarchitecture.model.User;

public interface CreateUserView {

    void createUser(User user);

    String getEmail();
    String getCpf();
    String getRg();
    String getLastName();
    String getFirstName();

    void setEmailError();
    void setCpfError();
    void setRgError();
    void setLastNameError();
    void setFirstNameError();

}
