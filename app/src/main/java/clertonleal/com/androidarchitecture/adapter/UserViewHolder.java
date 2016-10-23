package clertonleal.com.androidarchitecture.adapter;

import android.support.v7.widget.RecyclerView;

import clertonleal.com.androidarchitecture.databinding.UserRowBinding;
import clertonleal.com.androidarchitecture.ui.viewInterface.ListUserView;
import clertonleal.com.androidarchitecture.viewModel.UserRowViewModel;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public UserRowBinding binding;

    public UserViewHolder(UserRowBinding binding, ListUserView listUserView) {
        super(binding.getRoot());
        binding.setViewModel(new UserRowViewModel(listUserView));
        this.binding = binding;
    }
}
