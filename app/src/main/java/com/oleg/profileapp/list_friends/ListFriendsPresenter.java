package com.oleg.profileapp.list_friends;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.repo.Repository;

import java.util.ArrayList;
import java.util.List;

public class ListFriendsPresenter implements ListFriendsContract.Presenter{

    private final ListFriendsContract.View mView;

    private boolean mFirstLoad = true;

    private ArrayList<Friend> repository = new ArrayList<>();


    ListFriendsPresenter(ListFriendsContract.View mView){
        this.mView = mView;
        this.mView.setPresenter(this);
    }


    @Override
    public void start() {
        loadListFriends(true);
    }

    @Override
    public void loadListFriends(boolean forceUpdate) {
        loadListFriends(forceUpdate||mFirstLoad,true);
        mFirstLoad = false;
    }

    private void loadListFriends(boolean forceUpdate,final boolean showLoadingUI){
        if (showLoadingUI){
            mView.setLoadingIndicator(true);
        }

        if (forceUpdate){
            repository.clear();
            repository.addAll(Repository.getFriendsData());
        }

        if (showLoadingUI){
            mView.setLoadingIndicator(false);
        }

        processListFriends(repository);

    }

    private void processListFriends(List<Friend> friends){
        mView.showListFriends(friends);
    }


    @Override
    public void addNewFriend() {

    }

    @Override
    public void openDetailFriendDetail(Friend requestedFriend) {

    }

}
