package com.example.cjc12.exampleapp;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnFragmentInteractionListener, FavoritesFragment.OnFragmentInteractionListener, ChecklistFragment.OnFragmentInteractionListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                   selectedFragment = FavoritesFragment.newInstance("","");
                   transaction.replace(R.id.content, selectedFragment);
                   transaction.commit();
                   return true;
                case R.id.navigation_dashboard:
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = SearchFragment.newInstance("","");
                    transaction2.replace(R.id.content, selectedFragment);
                    transaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = SearchFragment.newInstance("","");
                    transaction3.replace(R.id.content, selectedFragment);
                    transaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, SearchFragment.newInstance("",""));
        transaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
