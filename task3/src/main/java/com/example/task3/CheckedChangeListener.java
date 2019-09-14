package com.example.task3;

import android.graphics.Color;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.annotation.ColorLong;

public class CheckedChangeListener
        implements CompoundButton.OnCheckedChangeListener {

    private LinearLayout mainLLayout;
    private Color layoutColor;
    private Color textColor;

    private int lColor;

    public CheckedChangeListener(LinearLayout mainLLayout) {
        this.mainLLayout = mainLLayout;
        layoutColor = new Color();
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {

//        int red = mainLLayout.getBackground().

        switch (button.getId()){

            case R.id.cbRed:
//                layoutColor
//                        = Color
//                        .valueOf(
//                        255,
//                                layoutColor,
//                                layoutColor.blue())
                break;
            case R.id.cbGreen:
                break;
            case R.id.cbBlue:
                break;
        }

        lColor = Color.rgb(255, 0, 0);
        mainLLayout.setBackgroundColor(lColor);
    }
}
