package com.retrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.retrofit.java.JavaFragment;
import com.retrofit.sample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // default display retrofit Java code version fragment
        JavaFragment fragment = new JavaFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.rl_fragment_container, fragment) // add
                .commit();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // TODO Nothing
        });
    }
}