package com.oleg.profileapp.friend_detail;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;

public class FriendDetailContract {

    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BasePresenter {

        void loadFriendProfile();

        void editFriendProfile();

        void deleteFriendProfile();
    }
}
