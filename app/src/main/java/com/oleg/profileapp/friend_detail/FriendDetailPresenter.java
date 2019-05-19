package com.oleg.profileapp.friend_detail;

import com.oleg.profileapp.model.Friend;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

public class FriendDetailPresenter implements FriendDetailContract.Presenter {
    private Friend repository = new Friend();
    private final FriendDetailContract.View friendDetailView;

    FriendDetailPresenter(FriendDetailContract.View friendDetailView,
                          Friend friend) {

        this.friendDetailView = friendDetailView;
        this.repository = friend;
    }


    @Override
    public void start() {
        onShowFriend(repository);
    }

    @Override
    public void onShowFriend(Friend friend) {
        friendDetailView.showFriend(friend);
    }


    @Override
    public void loadFriendProfile() {

    }

    @Override
    public void editFriendProfile() {

    }


}
