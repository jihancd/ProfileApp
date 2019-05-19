package com.oleg.profileapp.list_friends;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ListFriendsFragment extends Fragment implements ListFriendsContract.View {

    private ListFriendsContract.Presenter mPresenter;
    private List<Friend> friendList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button btnEdit;

    TextView nim, nama, kelas, email, telepon, instagram, facebook, twitter;
    LinearLayout linearLayout;


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
        View view = inflater.inflate(R.layout.fragment_list_friends, container, false);
        recyclerView = view.findViewById(R.id.rv_listFriends);

        setHasOptionsMenu(true);
//        nim = view.findViewById(R.id.tv_friend_detail_nim);
//        nama = view.findViewById(R.id.tv_friend_detail_nama);
//        kelas = view.findViewById(R.id.tv_friend_detail_kelas);
//        email = view.findViewById(R.id.tv_friend_detail_email);
//        telepon = view.findViewById(R.id.tv_friend_detail_telepon);
//        instagram = view.findViewById(R.id.tv_friend_detail_instagram);
//        twitter = view.findViewById(R.id.tv_friend_detail_twitter);
//        facebook = view.findViewById(R.id.tv_friend_detail_facebook);

//        linearLayout = view.findViewById(R.id.linear_friend_detail);
//        linearLayout.setVisibility(View.GONE);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ListFriendsAdapter(friendList, mItemListener);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                1);
        recyclerView.addItemDecoration(mDividerItemDecoration);

        recyclerView.setAdapter(mAdapter);
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
    public void showFriendDetailUI(List<Friend> friends, Friend friend, int index) {
        // intent ke friend detail
//        Intent intent = new Intent(getActivity(), FriendDetailActivity.class);
//        intent.putExtra(Util.intentParcelable,friend);
//
//        ArrayList<Friend> friends = new ArrayList<>(friendList);
//        intent.putParcelableArrayListExtra(Util.intentParcelableList,friends);
//        startActivity(intent);
//        recyclerView.setVisibility(View.GONE);
//        linearLayout.setVisibility(View.VISIBLE);
//        nim.setText(friend.getNim());
//        nama.setText(friend.getNama());
//        kelas.setText(friend.getKelas());
//        email.setText(friend.getEmail());
//        telepon.setText(friend.getTelepon());
//        instagram.setText(friend.getInstagram());
//        twitter.setText(friend.getTwitter());
//        facebook.setText(friend.getFacebook());

        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setContentView(R.layout.activity_friend_detail);
        dialog.setTitle("My Dialog");

        nim = dialog.findViewById(R.id.tv_friend_detail_nim);
        nama = dialog.findViewById(R.id.tv_friend_detail_nama);
        kelas = dialog.findViewById(R.id.tv_friend_detail_kelas);
        email = dialog.findViewById(R.id.tv_friend_detail_email);
        telepon = dialog.findViewById(R.id.tv_friend_detail_telepon);
        instagram = dialog.findViewById(R.id.tv_friend_detail_instagram);
        twitter = dialog.findViewById(R.id.tv_friend_detail_twitter);
        facebook = dialog.findViewById(R.id.tv_friend_detail_facebook);

        btnEdit = dialog.findViewById(R.id.btn_edit);

        nim.setText(friend.getNim());
        nama.setText(friend.getNama());
        kelas.setText(friend.getKelas());
        email.setText(friend.getEmail());
        telepon.setText(friend.getTelepon());
        instagram.setText(friend.getInstagram());
        twitter.setText(friend.getTwitter());
        facebook.setText(friend.getFacebook());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friend.setNim(nim.getText().toString());
                friend.setNama(nama.getText().toString());
                friend.setKelas(kelas.getText().toString());
                friend.setEmail(email.getText().toString());
                friend.setTelepon(telepon.getText().toString());
                friend.setInstagram(instagram.getText().toString());
                friend.setTwitter(twitter.getText().toString());
                friend.setFacebook(facebook.getText().toString());
//                mPresenter.onEditFriend(friend, friendList, index);
                friends.set(index,friend);
                friends.add(friend);
                mAdapter = new ListFriendsAdapter(friends,mItemListener);
                recyclerView.setAdapter(mAdapter);
                dialog.dismiss();
            }
        });

        dialog.show();
        Window window = dialog.getWindow();
        assert window != null;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

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
        public void onListFriendClick(List<Friend> friends, Friend clickedListFriend, int index) {
            mPresenter.openDetailFriendDetail(friends, clickedListFriend, index);

        }

        @Override
        public void onBtnDeleteClick(Friend clickedListFriend) {
            mPresenter.onDeleteFriend(clickedListFriend);
        }
    };

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.list_friend_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
           case R.id.tambah_teman:
               final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
               dialog.setContentView(R.layout.activity_friend_detail);
               dialog.setTitle("Tambah Teman");
               nim = dialog.findViewById(R.id.tv_friend_detail_nim);
               nama = dialog.findViewById(R.id.tv_friend_detail_nama);
               kelas = dialog.findViewById(R.id.tv_friend_detail_kelas);
               email = dialog.findViewById(R.id.tv_friend_detail_email);
               telepon = dialog.findViewById(R.id.tv_friend_detail_telepon);
               instagram = dialog.findViewById(R.id.tv_friend_detail_instagram);
               twitter = dialog.findViewById(R.id.tv_friend_detail_twitter);
               facebook = dialog.findViewById(R.id.tv_friend_detail_facebook);

               btnEdit = dialog.findViewById(R.id.btn_edit);
               btnEdit.setText("Tambah");

               Friend friend = new Friend();

               nim.setText(friend.getNim());
               nama.setText(friend.getNama());
               kelas.setText(friend.getKelas());
               email.setText(friend.getEmail());
               telepon.setText(friend.getTelepon());
               instagram.setText(friend.getInstagram());
               twitter.setText(friend.getTwitter());
               facebook.setText(friend.getFacebook());

               btnEdit.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       friend.setNim(nim.getText().toString());
                       friend.setNama(nama.getText().toString());
                       friend.setKelas(kelas.getText().toString());
                       friend.setEmail(email.getText().toString());
                       friend.setTelepon(telepon.getText().toString());
                       friend.setInstagram(instagram.getText().toString());
                       friend.setTwitter(twitter.getText().toString());
                       friend.setFacebook(facebook.getText().toString());
                       friendList.add(friend);
                       mAdapter = new ListFriendsAdapter(friendList,mItemListener);
                       recyclerView.setAdapter(mAdapter);
                       dialog.dismiss();
                   }
               });

               dialog.show();
               Window window = dialog.getWindow();
               assert window != null;
               window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        return super.onOptionsItemSelected(item);

    }

    interface ListFriendsListener {
        void onListFriendClick(List<Friend> friends, Friend clickedListFriend, int index);

        void onBtnDeleteClick(Friend clickedListFriend);
    }
}
