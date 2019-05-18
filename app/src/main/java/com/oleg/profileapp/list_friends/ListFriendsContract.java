package com.oleg.profileapp.list_friends;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.Model.Friend;

public class ListFriendsContract {
    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showListFriends();

        void showFriendDetailUI(String friend_id);
    }

    interface Presenter extends BasePresenter {
        void loadListFriends();

        void addNewFriend();

        void openDetailFriendDetail(Friend requestedFriend);
    }
}
