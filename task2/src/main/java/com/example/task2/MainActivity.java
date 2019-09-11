package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // Главный контейнер.
        LinearLayout mainLL = new LinearLayout(this);
        //LayoutParams
        LinearLayout.LayoutParams mainLLParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        mainLL.setLayoutParams(mainLLParams);

        mainLL.setOrientation(LinearLayout.VERTICAL);
        // test
        mainLL.setBackgroundColor(Color.GREEN);
        // TODO margin

        // Назначем Активности главный контейнер.
        this.setContentView(mainLL);
    }
}
