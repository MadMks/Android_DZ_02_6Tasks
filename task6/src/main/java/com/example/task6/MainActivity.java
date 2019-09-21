package com.example.task6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Film[] films =
            {
                new Film("Интерселлар", "Фантастика", 2015),
                new Film("Человек-муравей", "Фэнтези", 2015),
                new Film("Выживший", "Драма", 2015),
                new Film("Рейд-2", "Боевик", 2014),
                new Film("Хоббит: Пустошь Смауга", "Фэнтези", 2013)
            };

    private EditText editTextTitle;
    private EditText editTextGenre;
    private EditText editTextYear;

    private SimpleAdapter filmAdapter;
    private ArrayList<Map<String, Object>> filmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerFilms = findViewById(R.id.spinnerFilms);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextGenre = findViewById(R.id.editTextGenre);
        editTextYear = findViewById(R.id.editTextYear);

        filmList = new ArrayList<>();

        for (int i = 0; i < films.length; i++)
        {
            HashMap<String, Object> filmItem = new HashMap<>();

            filmItem.put("Title", films[i].title);
            filmItem.put("Genre", films[i].genre);
            filmItem.put("Year", films[i].year);

            filmList.add(filmItem);
        }

        // Для адаптера
        String[] from = new String[] {
          "Title", "Genre", "Year"
        };
        int[] to = new int[] {
                R.id.tvTitle,
                R.id.tvGenre,
                R.id.tvYear
        };

        // Адаптер
        filmAdapter = new SimpleAdapter(
                this,
                filmList,
                R.layout.spiner_item,
                from,
                to
        );
        filmAdapter.setDropDownViewResource(R.layout.spiner_item);

        // Назначение списку spinnerFilms адаптера данных.
        spinnerFilms.setAdapter(filmAdapter);


    }

    public void addClick(View view) {

        String title = editTextTitle.getText().toString();
        String genre = editTextGenre.getText().toString();
        String year = editTextYear.getText().toString();

        if (title.isEmpty() || genre.isEmpty() || year.isEmpty()){

            Toast.makeText(this,
                    "Нужно заполнить все поля",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        else {
            // Добавление нового фильма в адаптер
            // TODO реализовать добавление фильма
            HashMap<String, Object> filmItem = new HashMap<>();
            filmItem.put("Title", title);
            filmItem.put("Genre", genre);
            filmItem.put("Year", year);
            filmList.add(filmItem);

            Toast.makeText(this,
                    "Фильм добавлен",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
