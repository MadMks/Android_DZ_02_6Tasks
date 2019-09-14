package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLLayout;
    private TextView tvHeader;
    private CheckBox checkBoxRed;
    private CheckBox checkBoxGreen;
    private CheckBox checkBoxBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLLayout = findViewById(R.id.mainLLayout);
        tvHeader = findViewById(R.id.tvHeader);
        checkBoxRed = findViewById(R.id.cbRed);
        checkBoxGreen = findViewById(R.id.cbGreen);
        checkBoxBlue = findViewById(R.id.cbBlue);
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
        SetProgramTextColor(InvertColor(red, green, blue));
    }

    private int InvertColor(int red, int green, int blue) {

        red = red == 255 ? 0 : 255;
        green = green == 255 ? 0 : 255;
        blue = blue == 255 ? 0 : 255;

        int invertColor = Color.rgb(red, green, blue);

        return invertColor;
    }

    private void SetProgramTextColor(int layoutColor) {

        tvHeader.setTextColor(layoutColor);

        checkBoxRed.setTextColor(layoutColor);
        checkBoxGreen.setTextColor(layoutColor);
        checkBoxBlue.setTextColor(layoutColor);
    }
}
