package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLLayout;

    private CheckedChangeListener checkedChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLLayout = findViewById(R.id.mainLLayout);

        checkedChangeListener = new CheckedChangeListener(mainLLayout);
    }
}
