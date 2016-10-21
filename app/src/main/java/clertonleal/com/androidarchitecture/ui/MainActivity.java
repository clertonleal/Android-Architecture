package clertonleal.com.androidarchitecture.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.adapter.UsersAdapter;
import clertonleal.com.androidarchitecture.model.User;

public class MainActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";
    public static final int CREATE_USER = 1;

    private UsersAdapter usersAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list_user);
        usersAdapter = new UsersAdapter();
        usersAdapter.setUserClickListener(getUserClickListener());
        recyclerView.setAdapter(usersAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.create_user) {
            Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
            startActivityForResult(intent, CREATE_USER);
            return true;
        }

        return false;
    }

    @NonNull
    private UsersAdapter.UserClickListener getUserClickListener() {
        return new UsersAdapter.UserClickListener() {
            @Override
            public void onClick(User user) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(USER_KEY, user);
                startActivity(intent);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_USER && resultCode == RESULT_OK) {
            User user = data.getParcelableExtra(USER_KEY);
            usersAdapter.addUser(user);
            recyclerView.setAdapter(usersAdapter);
        }
    }
}
