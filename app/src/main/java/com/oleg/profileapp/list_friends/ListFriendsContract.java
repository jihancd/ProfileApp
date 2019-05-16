package com.oleg.profileapp.list_friends;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;

public class ListFriendsContract {
    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BasePresenter {
        void loadListFriends();

        void addNewFriend();
    }
}
