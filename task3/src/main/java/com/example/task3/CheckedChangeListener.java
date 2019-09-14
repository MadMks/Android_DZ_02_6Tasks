package com.example.task3;

import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class CheckedChangeListener
        implements CompoundButton.OnCheckedChangeListener {

    private LinearLayout mainLLayout;

    public CheckedChangeListener(LinearLayout mainLLayout) {
        this.mainLLayout = mainLLayout;
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {

        switch (button.getId()){

            case R.id.cbRed:
                break;
            case R.id.cbGreen:
                break;
            case R.id.cbBlue:
                break;
        }

    }
}
