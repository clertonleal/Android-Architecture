package clertonleal.com.androidarchitecture.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.databinding.CreateUserBinding;
import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.CreateUserView;
import clertonleal.com.androidarchitecture.viewModel.CreateUserViewModel;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CreateUserBinding createUserBinding = DataBindingUtil.setContentView(this, R.layout.create_user);
        createUserBinding.setViewModel(new CreateUserViewModel(getCreateUserView()));
        setTitle(R.string.create_user);
    }

    @NonNull
    private CreateUserView getCreateUserView() {
        return new CreateUserView() {
            @Override
            public void onUserCreated(User user) {
                Intent intentResult = new Intent();
                intentResult.putExtra(MainActivity.USER_KEY, user);
                setResult(RESULT_OK, intentResult);
                finish();
            }

            @Override
            public String getString(@StringRes int resource) {
                return CreateUserActivity.this.getString(resource);
            }
        };
    }
}
