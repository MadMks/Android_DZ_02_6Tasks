package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLLayout;
    private CheckBox checkBoxRed;
    private CheckBox checkBoxGreen;
    private CheckBox checkBoxBlue;

//    private CheckedChangeListener checkedChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLLayout = findViewById(R.id.mainLLayout);

        checkBoxRed = findViewById(R.id.cbRed);
        checkBoxGreen = findViewById(R.id.cbGreen);
        checkBoxBlue = findViewById(R.id.cbBlue);

//        checkedChangeListener = new CheckedChangeListener(mainLLayout);
    }

    public void ClickCheckBox(View view) {
        int layoutColor;
        int red = 0;
        int green = 0;
        int blue = 0;

        if (checkBoxRed.isChecked()) red = 255;
        if (checkBoxGreen.isChecked()) green = 255;
        if (checkBoxBlue.isChecked()) blue = 255;

        layoutColor = Color.rgb(red, green, blue);

        mainLLayout.setBackgroundColor(layoutColor);
        checkBoxRed.setTextColor(layoutColor);
    }
}
