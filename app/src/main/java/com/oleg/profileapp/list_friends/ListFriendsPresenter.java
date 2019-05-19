package com.oleg.profileapp.list_friends;

import android.content.Intent;
import android.net.Uri;
import android.widget.FrameLayout;

import com.oleg.profileapp.model.Friend;
import com.oleg.profileapp.repo.Repository;

import java.util.ArrayList;
import java.util.List;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

public class ListFriendsPresenter implements ListFriendsContract.Presenter {

    private final ListFriendsContract.View mView;

    private final FrameLayout frameLayout;

    private boolean mFirstLoad = true;

    private ArrayList<Friend> repository = new ArrayList<>();


    ListFriendsPresenter(FrameLayout frameLayout,ListFriendsContract.View mView) {
        this.frameLayout = frameLayout;
        this.mView = mView;
        this.mView.setPresenter(this);
    }


    @Override
    public void start() {
        loadListFriends(false);
    }

    @Override
    public void loadListFriends(boolean forceUpdate) {
        loadListFriends(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadListFriends(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mView.setLoadingIndicator(true);
        }

        if (forceUpdate) {
            repository.clear();
            repository.addAll(Repository.getFriendsData());
        }

        if (showLoadingUI) {
            mView.setLoadingIndicator(false);
        }

        processListFriends(repository);

    }

    private void processListFriends(List<Friend> friends) {
        mView.showListFriends(friends);
    }


    @Override
    public void addNewFriend() {

    }

    @Override
    public void openDetailFriendDetail(List<Friend> friends, Friend requestedFriend, int index) {
        mView.showFriendDetailUI(friends, requestedFriend, index);
    }

    @Override
    public void onDeleteFriend(final Friend friend) {
        repository.remove(friend);
        mView.showListFriends(repository);
        mView.showMessage("Data Berhasil Dihapus");
    }

    @Override
    public void onEditFriend(Friend friend, List<Friend> friends, int index) {
        friends.set(index, friend);
        mView.showListFriends(friends);
    }

    @Override
    public void onCallFriend(Friend friend) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+friend.getTelepon()));
        mView.callFriend(callIntent);
    }
}
