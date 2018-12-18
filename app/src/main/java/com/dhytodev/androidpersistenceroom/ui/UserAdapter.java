package com.dhytodev.androidpersistenceroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhytodev.androidpersistenceroom.R;
import com.dhytodev.androidpersistenceroom.data.User;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserViewHolder> {

    protected UserAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = getItem(position);
        if (user != null) {
            holder.bind(user);
        } else {
            holder.clear();
        }
    }

    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<User>() {
                @Override
                public boolean areItemsTheSame(User oldUser, User newUser) {
                    return oldUser.id == newUser.id;
                }

                @Override
                public boolean areContentsTheSame(User oldUser,
                                                  User newUser) {
                    return oldUser.equals(newUser);
                }
            };

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView userIdTextView;
        private TextView userNameTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTextView = itemView.findViewById(R.id.tv_user_id);
            userNameTextView = itemView.findViewById(R.id.tv_user_name);
        }

        public void bind(User user) {
            userIdTextView.setText(user.id);
            userNameTextView.setText(user.nama);
        }

        public void clear() {
            userIdTextView.setText(null);
            userNameTextView.setText(null);
        }
    }
}
