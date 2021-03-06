package com.oleg.profileapp.list_friends;

import android.content.Intent;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.model.Friend;

import java.util.List;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

public class ListFriendsContract {
    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showListFriends(List<Friend> friends);

        void showFriendDetailUI(List<Friend> friends,Friend friend, int index);

        void showMessage(String message);

        void callFriend(Intent intent);
    }

    interface Presenter extends BasePresenter {
        void loadListFriends(boolean forceUpdate);

        void addNewFriend();

        void openDetailFriendDetail(List<Friend> friends,Friend requestedFriend, int index);

        void onDeleteFriend(Friend friend);

        void onCallFriend(Friend friend);

        void onEditFriend(Friend friend, List<Friend> friends, int index);
    }
}
