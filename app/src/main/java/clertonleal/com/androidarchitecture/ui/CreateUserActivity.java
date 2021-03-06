package clertonleal.com.androidarchitecture.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;

public class CreateUserActivity extends AppCompatActivity {

    private EditText firstNameText;
    private EditText lastNameText;
    private EditText rgText;
    private EditText cpfText;
    private EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
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
                if (isFormFilled()) {
                    User user = new User();
                    user.setFirstName(firstNameText.getText().toString());
                    user.setLastName(lastNameText.getText().toString());
                    user.setRg(rgText.getText().toString());
                    user.setCpf(cpfText.getText().toString());
                    user.setEmail(emailText.getText().toString());

                    Intent intentResult = new Intent();
                    intentResult.putExtra(MainActivity.USER_KEY, user);
                    setResult(RESULT_OK, intentResult);
                    finish();
                }
            }
        };
    }

    private boolean isFormFilled() {
        if (firstNameText.getText().toString().isEmpty()) {
            firstNameText.setError(getString(R.string.mandatory_field));
            return false;
        } else if (lastNameText.getText().toString().isEmpty()) {
            lastNameText.setError(getString(R.string.mandatory_field));
            return false;
        } else if (rgText.getText().toString().isEmpty()) {
            rgText.setError(getString(R.string.mandatory_field));
            return false;
        } else if (cpfText.getText().toString().isEmpty()) {
            cpfText.setError(getString(R.string.mandatory_field));
            return false;
        } else if (emailText.getText().toString().isEmpty()) {
            emailText.setError(getString(R.string.mandatory_field));
            return false;
        }

        return true;
    }

}
