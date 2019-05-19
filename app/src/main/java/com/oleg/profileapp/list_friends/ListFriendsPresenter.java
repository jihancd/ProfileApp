package com.oleg.profileapp.list_friends;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.repo.Repository;

import java.util.ArrayList;
import java.util.List;

public class ListFriendsPresenter implements ListFriendsContract.Presenter {

    private final ListFriendsContract.View mView;

    private boolean mFirstLoad = true;

    private ArrayList<Friend> repository = new ArrayList<>();


    ListFriendsPresenter(ListFriendsContract.View mView) {
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
        Log.d("cek",friends.get(0).getFacebook());
    }


    @Override
    public void addNewFriend() {

    }

    @Override
    public void openDetailFriendDetail(List<Friend> friends, Friend requestedFriend, int index) {
        mView.showFriendDetailUI(friends,requestedFriend, index);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDeleteFriend(final Friend friend) {
//        repository.removeIf(n->(n.getNama().equals(friend.getNama())));
        repository.remove(friend);
        mView.showListFriends(repository);
    }

    @Override
    public void onEditFriend(Friend friend, List<Friend> friends, int index) {
        friends.set(index,friend);
        mView.showListFriends(friends);
    }
}
