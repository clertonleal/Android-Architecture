package clertonleal.com.androidarchitecture.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;

public class MainActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";

    private EditText firstNameText;
    private EditText lastNameText;
    private EditText rgText;
    private EditText cpfText;
    private EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Create user");
        bindView();
    }

    private void bindView() {
        firstNameText = (EditText) findViewById(R.id.first_name);
        lastNameText = (EditText) findViewById(R.id.last_name);
        rgText = (EditText) findViewById(R.id.rg);
        cpfText = (EditText) findViewById(R.id.cpf);
        emailText = (EditText) findViewById(R.id.email);
        findViewById(R.id.create_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setFirstName(firstNameText.getText().toString());
                user.setLastName(lastNameText.getText().toString());
                user.setRg(rgText.getText().toString());
                user.setCpf(cpfText.getText().toString());
                user.setEmail(emailText.getText().toString());

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(USER_KEY, user);
                startActivity(intent);
            }
        });
    }
}
