package com.oleg.profileapp.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.oleg.profileapp.Model.Profile;
import com.oleg.profileapp.R;

import java.util.List;

public class ProfileFragment extends Fragment implements ProfileContract.View {

    private static final String TAG = "cek";
    private ProfileContract.Presenter mPresenter;
    private SwipeRefreshLayout swipeRefresh;
    private TextView nim, nama, kelas, deskripsi;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ProfilePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nim = view.findViewById(R.id.tvprofile_deskripsi);
        nama = view.findViewById(R.id.tvprofile_nama);
        kelas = view.findViewById(R.id.tvprofile_kelas);
        deskripsi = view.findViewById(R.id.tvprofile_deskripsi);

        swipeRefresh = view.findViewById(R.id.sr_profile);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadProfile(true);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        swipeRefresh.setRefreshing(active);
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProfile(List<Profile> profile) {
        nim.setText(profile.get(0).getNim());
        nama.setText(profile.get(0).getNama());
        kelas.setText(profile.get(0).getKelas());
        deskripsi.setText(profile.get(0).getDeskripsi());
    }
}
