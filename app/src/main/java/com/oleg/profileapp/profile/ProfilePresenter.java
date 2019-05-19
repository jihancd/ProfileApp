package com.oleg.profileapp.profile;

import com.oleg.profileapp.model.Profile;
import com.oleg.profileapp.repo.Repository;

import java.util.ArrayList;
import java.util.List;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

public class ProfilePresenter implements ProfileContract.Presenter {

    private final ProfileContract.View mProfileView;

    private boolean mFirstLoad = true;

    private ArrayList<Profile> repository = new ArrayList<>();

    ProfilePresenter(ProfileContract.View mProfileView) {

        this.mProfileView = mProfileView;

        this.mProfileView.setPresenter(this);
    }

    @Override
    public void start() {
        loadProfile(true);
    }

    @Override
    public void loadProfile(boolean forceUpdate) {
        loadProfile(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadProfile(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mProfileView.setLoadingIndicator(true);
        }

        if (forceUpdate) {
            repository.clear();
            repository.addAll(Repository.getProfileData());
        }

        if (showLoadingUI) {
            mProfileView.setLoadingIndicator(false);
        }

        processProfile(repository);
    }

    private void processProfile(List<Profile> profiles) {
        mProfileView.showProfile(profiles);
    }
}
