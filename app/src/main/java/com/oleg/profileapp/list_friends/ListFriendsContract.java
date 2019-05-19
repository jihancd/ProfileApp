package com.oleg.profileapp.list_friends;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.Model.Friend;

import java.util.List;

public class ListFriendsContract {
    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showListFriends(List<Friend> friends);

        void showFriendDetailUI(List<Friend> friends,Friend friend, int index);
    }

    interface Presenter extends BasePresenter {
        void loadListFriends(boolean forceUpdate);

        void addNewFriend();

        void openDetailFriendDetail(List<Friend> friends,Friend requestedFriend, int index);

        void onDeleteFriend(Friend friend);

        void onEditFriend(Friend friend, List<Friend> friends, int index);
    }
}
