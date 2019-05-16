package com.oleg.profileapp.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oleg.profileapp.R;
import com.oleg.profileapp.contact.ContactFragment;
import com.oleg.profileapp.list_friends.ListFriendsFragment;
import com.oleg.profileapp.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.vp_main);

        bottomNavigationView = findViewById(R.id.bnv_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemProfile:
                        Toast.makeText(MainActivity.this, "asdsd", Toast.LENGTH_SHORT).show();
                    case R.id.itemContact:
                        Toast.makeText(MainActivity.this, "asdsd", Toast.LENGTH_SHORT).show();
                    case R.id.itemListFriends:
                        Toast.makeText(MainActivity.this, "asdsd", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        setupViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mPager.getCurrentItem() == 0){
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private void setupViewPager(ViewPager viewPager){
        pagerAdapter = new MainAdapter(getSupportFragmentManager());
        ((MainAdapter) pagerAdapter).addFragment(new ProfileFragment());
        ((MainAdapter) pagerAdapter).addFragment(new ContactFragment());
        ((MainAdapter) pagerAdapter).addFragment(new ListFriendsFragment());
        viewPager.setAdapter(pagerAdapter);
    }
}
