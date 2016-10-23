package clertonleal.com.androidarchitecture.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.databinding.DetailsBinding;
import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.viewModel.UserDetailViewModel;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DetailsBinding detailsBinding = DataBindingUtil.setContentView(this, R.layout.details);
        setTitle(R.string.show_user);

        User user = getIntent().getParcelableExtra(MainActivity.USER_KEY);
        detailsBinding.setViewModel(new UserDetailViewModel());
        detailsBinding.getViewModel().setUser(user);
    }
}
