package com.oleg.profileapp.contact;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;

public interface ContactContract {
    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BasePresenter {
        void loadContact();
    }
}
