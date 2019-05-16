package com.oleg.profileapp.profile;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;

public class ProfileContract {

    interface View extends BaseView<Presenter>{
        void setLoadingIndicator();
    }

    interface Presenter extends BasePresenter {
        void loadProfile();
    }
}
