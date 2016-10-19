package clertonleal.com.androidarchitecture.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import clertonleal.com.androidarchitecture.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public LinearLayout container;

    public UserViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.user_name);
        container = (LinearLayout) itemView.findViewById(R.id.user_row_container);
    }
}
