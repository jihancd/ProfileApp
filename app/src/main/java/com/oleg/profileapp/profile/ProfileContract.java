package com.oleg.profileapp.profile;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.Model.Profile;

import java.util.List;

public class ProfileContract {

    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showProfile(List<Profile> profile);
    }

    interface Presenter extends BasePresenter {
        void loadProfile(boolean forceUpdate);
    }
}
