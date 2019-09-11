package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        // === Главный контейнер.
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



        // ===
        // === === Верхний контейнер LinearLayout (boxLayout)
        LinearLayout boxLayoutOne = new LinearLayout(this);
        boxLayoutOne.setBackgroundColor(
                this.getResources().getColor(R.color.colorLightGreen)
        );
        boxLayoutOne.setGravity(Gravity.CENTER);
        // LayoutParams
        LinearLayout.LayoutParams boxOneLLParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        boxOneLLParams.weight = 1;
        mainLL.addView(boxLayoutOne, boxOneLLParams);


        // ===
        // === ===
        // === === === Верхний GridLayout
        GridLayout gridLayoutOne = new GridLayout(this);
        gridLayoutOne.setColumnCount(2);
        gridLayoutOne.setRowCount(2);

        // LayoutParams
        GridLayout.LayoutParams gridOneLLParams =
                new GridLayout.LayoutParams();
        gridOneLLParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        gridOneLLParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        gridOneLLParams.setGravity(Gravity.CENTER);

        // Добавляем верхний GridLayout в верхний LinearLayout (boxLayout)
        boxLayoutOne.addView(gridLayoutOne, gridOneLLParams);

        // Кнопки верхнего GridLayout
        for (int i = 1; i <= 4; i++) {
            Button button = new Button(this);
            button.setText(Integer.toString(i));
            gridLayoutOne.addView(button);
        }



        // ===
        // === === Нижний контейнер LinearLayout (boxLayout)
        LinearLayout boxLayoutTwo = new LinearLayout(this);
        boxLayoutTwo.setBackgroundColor(
                this.getResources().getColor(R.color.colorLightRed)
        );
        boxLayoutTwo.setGravity(Gravity.CENTER);
        // LayoutParams
        LinearLayout.LayoutParams boxTwoLLParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        boxTwoLLParams.weight = 1;
        mainLL.addView(boxLayoutTwo, boxTwoLLParams);


        // ===
        // === ===
        // === === === Нижний GridLayout
        GridLayout gridLayoutTwo = new GridLayout(this);
        gridLayoutTwo.setColumnCount(2);
        gridLayoutTwo.setRowCount(2);

        // LayoutParams
        GridLayout.LayoutParams gridTwoLLParams =
                new GridLayout.LayoutParams();
        gridTwoLLParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        gridTwoLLParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        gridTwoLLParams.setGravity(Gravity.CENTER);

        // Добавляем нижний GridLayout в нижний LinearLayout (boxLayout)
        boxLayoutTwo.addView(gridLayoutTwo, gridTwoLLParams);

        // Кнопки верхнего GridLayout
        for (int i = 1; i <= 4; i++) {
            Button button = new Button(this);
            button.setText(Integer.toString(i));
            gridLayoutTwo.addView(button);
        }


        // Назначем Активности главный контейнер.
        this.setContentView(mainLL);
    }
}
