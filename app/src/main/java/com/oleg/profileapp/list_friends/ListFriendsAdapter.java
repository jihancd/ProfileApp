package com.oleg.profileapp.list_friends;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.R;

import java.util.List;

public class ListFriendsAdapter extends RecyclerView.Adapter<ListFriendsAdapter.ViewHolder> {

    private List<Friend> mDataSet;

    public ListFriendsAdapter(List<Friend> mDataSet) {
        this.mDataSet = mDataSet;
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
        holder.tvName.setText(mDataSet.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        Log.d("cek", "getItemCount: "+mDataSet.size());
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_friend_nama);
        }
    }
}
