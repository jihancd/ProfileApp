package com.oleg.profileapp.list_friends;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oleg.profileapp.model.Friend;
import com.oleg.profileapp.R;

import java.util.List;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

public class ListFriendsAdapter extends RecyclerView.Adapter<ListFriendsAdapter.ViewHolder> {

    private List<Friend> mDataSet;
    private ListFriendsFragment.ListFriendsListener listener;

    public ListFriendsAdapter(List<Friend> mDataSet,ListFriendsFragment.ListFriendsListener listener) {
        this.mDataSet = mDataSet;
        Log.d("cek", "ListFriendsAdapter: "+mDataSet.size());
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItem(mDataSet.get(position),listener, position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView btnDelete;
        ImageView btnCalling;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_friend_nama);
            btnDelete = itemView.findViewById(R.id.btn_friend_delete);
            btnCalling = itemView.findViewById(R.id.btnTelepon);
        }

        void bindItem(final Friend friend, final ListFriendsFragment.ListFriendsListener listener, int position){
            tvName.setText(friend.getNama());
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onBtnDeleteClick(friend);
                }
            });

            btnCalling.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onBtnCallClick(friend);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onListFriendClick(mDataSet,friend, position);
                }
            });


        }

    }
}
