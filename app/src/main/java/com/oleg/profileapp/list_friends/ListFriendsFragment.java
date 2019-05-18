package com.oleg.profileapp.list_friends;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.R;
import com.oleg.profileapp.profile.ProfileContract;

import java.util.ArrayList;
import java.util.List;


public class ListFriendsFragment extends Fragment implements ListFriendsContract.View {

    private ListFriendsContract.Presenter mPresenter;
    private List<Friend> friendList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public ListFriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ListFriendsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list_friends, container, false);
        recyclerView = view.findViewById(R.id.rv_listFriends);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ListFriendsAdapter(friendList);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                1);
        recyclerView.addItemDecoration(mDividerItemDecoration);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showListFriends(List<Friend> friends) {
        friendList.clear();
        friendList.addAll(friends);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFriendDetailUI(String friend_id) {
        // intent ke friend detail
    }

    @Override
    public void setPresenter(ListFriendsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    // Saat salah satu item pada list di klik
    ListFriendsListener mItemListener = new ListFriendsListener() {
        @Override
        public void onListFriendClick(Friend clickedListFriend) {
           mPresenter.openDetailFriendDetail(clickedListFriend);
        }
    };

    interface ListFriendsListener {
        void onListFriendClick(Friend clickedListFriend);
    }
}
