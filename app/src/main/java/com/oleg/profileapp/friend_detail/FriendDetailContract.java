package com.oleg.profileapp.friend_detail;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.Model.Friend;

public class FriendDetailContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showFriend(Friend friend);

    }

    interface Presenter extends BasePresenter {

        void onShowFriend(Friend friend);

        void loadFriendProfile();

        void editFriendProfile();

    }
}
