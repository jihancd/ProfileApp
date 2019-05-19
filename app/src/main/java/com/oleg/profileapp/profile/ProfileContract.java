package com.oleg.profileapp.profile;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.model.Profile;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

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
