package com.oleg.profileapp.friend_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.R;
import com.oleg.profileapp.util.Util;

import java.util.ArrayList;

public class FriendDetailActivity extends AppCompatActivity  implements FriendDetailContract.View{
    FriendDetailContract.Presenter mPresenter;
    TextView nim,nama,kelas,email,telepon,instagram,facebook,twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);
        Intent intent = getIntent();
        nim = findViewById(R.id.tv_friend_detail_nim);
        nama = findViewById(R.id.tv_friend_detail_nama);
        kelas = findViewById(R.id.tv_friend_detail_kelas);
        email = findViewById(R.id.tv_friend_detail_email);
        telepon = findViewById(R.id.tv_friend_detail_telepon);
        instagram = findViewById(R.id.tv_friend_detail_instagram);
        twitter = findViewById(R.id.tv_friend_detail_twitter);
        facebook = findViewById(R.id.tv_friend_detail_facebook);

        Friend f = intent.getParcelableExtra(Util.intentParcelable);
        mPresenter = new FriendDetailPresenter(this,f);

        ArrayList<Friend> friends = intent.getParcelableArrayListExtra(Util.intentParcelableList);
        Log.d("CEK", "onCreate: "+friends.get(0).getNama());
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void setPresenter(FriendDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showFriend(Friend friend) {
        nim.setText(friend.getNim());
        nama.setText(friend.getNama());
        kelas.setText(friend.getKelas());
        email.setText(friend.getEmail());
        telepon.setText(friend.getTelepon());
        instagram.setText(friend.getInstagram());
        twitter.setText(friend.getTwitter());
        facebook.setText(friend.getFacebook());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
