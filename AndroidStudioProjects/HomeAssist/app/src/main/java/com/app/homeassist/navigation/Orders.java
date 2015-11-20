package com.app.homeassist.navigation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.app.homeassist.R;

/**
 * Created by prateek on 16/11/15.
 */
public class Orders extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders);

        ActionBar ac= getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);

    }
}
