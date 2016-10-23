package clertonleal.com.androidarchitecture.adapter;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import clertonleal.com.androidarchitecture.R;
import clertonleal.com.androidarchitecture.databinding.UserRowBinding;
import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.ListUserView;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> users = new ArrayList<>();
    private ListUserView listUserView;

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_row, parent, false);
        return new UserViewHolder(binding, listUserView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = users.get(position);
        holder.binding.getViewModel().setUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void addUser(User user) {
        users.add(user);
        notifyDataSetChanged();
    }

    public void setListUserView(ListUserView listUserView) {
        this.listUserView = listUserView;
    }

}
