package com.example.task4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final static int MAX_TRY_COUNT = 10;
    private final static int SYMBOLS_IN_WORD = 5;

    private String[] words =
            {
                    "Apple", "Lemon", "Hello", "World", "Board", "House", "Horse",
                    "April", "Woman", "Table", "River", "Dream", "Green", "Stone",
                    "Water", "Rover", "Width", "Drive", "Pause"
            };

    private String word;
    private String curWord;
    private int count;

    private TextView tvTryCount;
    private TextView[] tvSymbols = new TextView[MainActivity.SYMBOLS_IN_WORD];
    private int[] tvSymbolsId =
            {
                    R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5
            };
    private EditText edtMain;


    private final static String BUNDLE_KEY_WORD =
            "keyWord";
    private final static String BUNDLE_KEY_CURWORD =
            "keyCurWord";
    private final static String BUNDLE_KEY_COUNT =
            "keyCount";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(MainActivity.
                BUNDLE_KEY_WORD, this.word);
        outState.putString(MainActivity.
                BUNDLE_KEY_CURWORD, this.curWord);
        outState.putInt(MainActivity.
                BUNDLE_KEY_COUNT, this.count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ----- Инициализация полей относящихся к виджетам --------------------
        this.tvTryCount = (TextView) this.findViewById(R.id.tvTryCount);
        this.edtMain = (EditText) this.findViewById(R.id.edtMain);

        for (int i = 0; i < this.tvSymbols.length; i++) {
            this.tvSymbols[i] = (TextView) this.findViewById(this.tvSymbolsId[i]);
        }

        //-- Проверка, нужно ли восстановить игру
        //-- или начать заново -------
        if (savedInstanceState != null) {
        //-- Состояние игры было сохранено -
        //-- восстанавливаем его -------------------------
            this.word = savedInstanceState.
                    getString(MainActivity.BUNDLE_KEY_WORD);
            this.curWord = savedInstanceState.
                    getString(MainActivity.BUNDLE_KEY_CURWORD);
            this.count = savedInstanceState.
                    getInt(MainActivity.BUNDLE_KEY_COUNT);
        //-- Отображаем текущее состояние игры -----------
            this.showGame();
        } else {
        //-- Инициализация игры --------------------------
            this.initGame();
        }
    }

    private void initGame() {
        // ----- Вывод Тоста с сообщением -------------------------------------
        Toast.makeText(this, "Новая игра", Toast.LENGTH_SHORT).show();

        // ----- Получение случайного слова из массива предустановленных слов -
        this.word = this.words[(int) (Math.random() * this.words.length)];

        // ----- Текущее отгадываемое слово - все буквы из звездочек ----------
        this.curWord = "*****";

        // ----- Количество попыток на отгадываение равно начальному количеству
        this.count = MainActivity.MAX_TRY_COUNT;

        // ----- Очищаем поле ввода буквы или слова ---------------------------
        this.edtMain.setText("");

        // ----- Отображение внешнего вида состояния игры ----------------------
        this.showGame();
    }

    private void showGame() {
        // ----- Вывод количества оставшихся попыток --------------------------
        this.tvTryCount.setText(String.valueOf(this.count));

        // ----- Вывод состояния отгадываемого слова в поля tv1-tv5 -----------
        for (int i = 0; i < this.curWord.length(); i++) {
            this.tvSymbols[i].setText(this.curWord.substring(i, i + 1));
        }
    }

    public void btnClick(View v) {
        // ----- Проверка на начало новой игры ---------------------------------
        if (this.count == 0) {
            this.initGame();
            return;
        }

        // ----- Читаем значение текстового поля edtMain -----------------------
        String S = this.edtMain.getText().toString().toLowerCase();

        // ----- Проверка на пустое поле ---------------------------------------
        if (S.isEmpty()) {
            Toast.makeText(this, "Вы ничего не ввели", Toast.LENGTH_SHORT).show();
            return;
        }

        // ----- Уменьшаем счетчик оставшихся попыток --------------------------
        this.count--;

        // ----- Идентифицируем кнопку -----------------------------------------
        if (v.getId() == R.id.btnSymbol) {
            // ----- Пользователь нажал на кнопку "Угадать букву" ------------------

            S = S.substring(0, 1);
            if (this.word.toLowerCase().contains(S)) {
                Toast.makeText(this, "Есть такая буква", Toast.LENGTH_SHORT).show();

                // ----- Открываем отгаданную букву в загаданном слове -----------------
                for (int i = 0; i < this.tvSymbols.length; i++) {
                    String symbol = this.word.substring(i, i + 1);
                    if (symbol.toLowerCase().equals(S)) {
                        this.curWord = this.curWord.substring(0, i) + symbol + this.curWord.substring(i + 1);
                    }
                }

                // ----- Проверяем, что все буквы отгаданы -----------------------------
                if (this.curWord.equals(this.word)) {
                    this.count = 0;
                    Toast.makeText(this, "Вы угадали!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Нет такой буквы", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btnWord) {
            // ----- Пользователь нажал на кнопку "Угадать слово" ------------------
            if (S.equals(this.word.toLowerCase())) {
                // ----- Пользователь угадал слово -------------------------------------
                this.count = 0;
                Toast.makeText(this, "Вы угадали!", Toast.LENGTH_SHORT).show();

                // ----- Открываем угаданное слово -------------------------------------
                this.curWord = this.word;
            } else {
                Toast.makeText(this, "Слово не угадано", Toast.LENGTH_SHORT).show();
            }
        }

        // ----- Очищаем значение текстового поля edtMain ----------------------
        this.edtMain.setText("");

        // ----- Отображаем текущее состояние игры -----------------------------
        this.showGame();

        // ----- Если количество попыток исчерпано, то сообщаем о конце игры ---
        if (this.count == 0) {
            Toast.makeText(this, "Игра завершена.\nНажмите любую кнопку для новой игры.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
