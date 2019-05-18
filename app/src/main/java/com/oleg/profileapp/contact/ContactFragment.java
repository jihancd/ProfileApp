package com.oleg.profileapp.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.R;

import java.util.List;

public class ContactFragment extends Fragment implements ContactContract.View {
    private ProgressBar progressBar;
    private ContactContract.Presenter mPresenter;
    private TextView telepon,email,instagram,twitter,facebook;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ContactPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contact, container, false);
        telepon = view.findViewById(R.id.tv_contact_telepon);
        email = view.findViewById(R.id.tv_contact_email);
        instagram = view.findViewById(R.id.tv_contact_instagram);
        twitter = view.findViewById(R.id.tv_contact_twitter);
        facebook = view.findViewById(R.id.tv_contact_facebook);

        progressBar = view.findViewById(R.id.pb_contact);

        return view;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active){
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public void showContact(List<Friend> friends) {
        telepon.setText(friends.get(0).getTelepon());
        email.setText(friends.get(0).getEmail());
        instagram.setText(friends.get(0).getInstagram());
        twitter.setText(friends.get(0).getTwitter());
        facebook.setText(friends.get(0).getFacebook());
    }

    @Override
    public void setPresenter(ContactContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
