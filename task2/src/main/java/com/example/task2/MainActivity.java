package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        // Главный контейнер.
        LinearLayout mainLL = new LinearLayout(this);
        mainLL.setOrientation(LinearLayout.VERTICAL);
        mainLL.setPadding(
                (int)this.getResources().getDimension(R.dimen.mainLL_padding),
                (int)this.getResources().getDimension(R.dimen.mainLL_padding),
                (int)this.getResources().getDimension(R.dimen.mainLL_padding),
                (int)this.getResources().getDimension(R.dimen.mainLL_padding)
        );

        //LayoutParams
        LinearLayout.LayoutParams mainLLParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        mainLL.setLayoutParams(mainLLParams);



        // Верхний контейнер FrameLayout
        FrameLayout frameLayoutOne = new FrameLayout(this);
        frameLayoutOne.setBackgroundColor(
                this.getResources().getColor(R.color.colorLightGreen)
        );
        // LayoutParams
        LinearLayout.LayoutParams frameOneLLParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        frameOneLLParams.weight = 1;
        mainLL.addView(frameLayoutOne, frameOneLLParams);


        // Нижний контейнер FrameLayout
        FrameLayout frameLayoutTwo = new FrameLayout(this);
        frameLayoutTwo.setBackgroundColor(
                this.getResources().getColor(R.color.colorLightRed)
        );
        // LayoutParams
        LinearLayout.LayoutParams frameTwoLLParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        frameTwoLLParams.weight = 1;
        mainLL.addView(frameLayoutTwo, frameTwoLLParams);


        // Назначем Активности главный контейнер.
        this.setContentView(mainLL);
    }
}
