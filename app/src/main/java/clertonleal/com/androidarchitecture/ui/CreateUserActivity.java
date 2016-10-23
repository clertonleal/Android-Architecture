package clertonleal.com.androidarchitecture.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.presenter.CreateUserPresenter;
import clertonleal.com.androidarchitecture.presenter.CreateUserView;

public class CreateUserActivity extends AppCompatActivity implements CreateUserView {

    private EditText firstNameText;
    private EditText lastNameText;
    private EditText rgText;
    private EditText cpfText;
    private EditText emailText;

    private CreateUserPresenter createUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        createUserPresenter = new CreateUserPresenter(this);
        setTitle(R.string.create_user);
        bindView();
    }

    private void bindView() {
        firstNameText = (EditText) findViewById(R.id.first_name);
        lastNameText = (EditText) findViewById(R.id.last_name);
        rgText = (EditText) findViewById(R.id.rg);
        cpfText = (EditText) findViewById(R.id.cpf);
        emailText = (EditText) findViewById(R.id.email);
        findViewById(R.id.create_button).setOnClickListener(getCreateUserListener());
    }

    @NonNull
    private View.OnClickListener getCreateUserListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserPresenter.validateAndCreateUser();
            }
        };
    }

    @Override
    public void createUser(User user) {
        Intent intentResult = new Intent();
        intentResult.putExtra(MainActivity.USER_KEY, user);
        setResult(RESULT_OK, intentResult);
        finish();
    }

    @NonNull
    @Override
    public String getEmail() {
        return emailText.getText().toString();
    }

    @NonNull
    @Override
    public String getCpf() {
        return cpfText.getText().toString();
    }

    @NonNull
    @Override
    public String getRg() {
        return rgText.getText().toString();
    }

    @NonNull
    @Override
    public String getLastName() {
        return lastNameText.getText().toString();
    }

    @NonNull
    @Override
    public String getFirstName() {
        return firstNameText.getText().toString();
    }

    @Override
    public void setEmailError() {
        emailText.setError(getString(R.string.mandatory_field));
    }

    @Override
    public void setCpfError() {
        cpfText.setError(getString(R.string.mandatory_field));
    }

    @Override
    public void setRgError() {
        rgText.setError(getString(R.string.mandatory_field));
    }

    @Override
    public void setLastNameError() {
        lastNameText.setError(getString(R.string.mandatory_field));
    }

    @Override
    public void setFirstNameError() {
        firstNameText.setError(getString(R.string.mandatory_field));
    }

}
