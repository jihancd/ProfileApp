package com.oleg.profileapp.contact;

import com.oleg.profileapp.BasePresenter;
import com.oleg.profileapp.BaseView;
import com.oleg.profileapp.model.Friend;

import java.util.List;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

public interface ContactContract {
    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showContact(List<Friend> friends);
    }

    interface Presenter extends BasePresenter {
        void loadContact(Boolean forceUpdate);
    }
}
