package clertonleal.com.androidarchitecture.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        setTitle(R.string.show_user);

        User user = getIntent().getParcelableExtra(MainActivity.USER_KEY);
        bindView(user);
    }

    private void bindView(User user) {
        TextView firstNameText = (TextView) findViewById(R.id.first_name);
        TextView lastNameText = (TextView) findViewById(R.id.last_name);
        TextView rgText = (TextView) findViewById(R.id.rg);
        TextView cpfText = (TextView) findViewById(R.id.cpf);
        TextView emailText = (TextView) findViewById(R.id.email);

        firstNameText.setText(user.getFirstName());
        lastNameText.setText(user.getLastName());
        rgText.setText(user.getRg());
        cpfText.setText(user.getCpf());
        emailText.setText(user.getEmail());
    }
}
