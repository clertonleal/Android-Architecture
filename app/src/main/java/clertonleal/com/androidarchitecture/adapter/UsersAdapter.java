package clertonleal.com.androidarchitecture.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.model.User;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> users = new ArrayList<>();
    private UserClickListener userClickListener;

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = users.get(position);
        holder.title.setText(user.getFirstName() + " " + user.getLastName());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userClickListener != null) {
                    userClickListener.onClick(user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void addUser(User user) {
        users.add(user);
        notifyDataSetChanged();
    }

    public void setUserClickListener(UserClickListener userClickListener) {
        this.userClickListener = userClickListener;
    }

    public interface UserClickListener {
        void onClick(User user);
    }
}
