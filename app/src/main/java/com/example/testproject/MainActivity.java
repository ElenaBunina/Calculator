package com.example.testproject;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText text_from_user;
    private TextView result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClick();
    }

    public void onButtonClick() {
        text_from_user = findViewById(R.id.editText);
        result = findViewById(R.id.result_filed);
        button = findViewById(R.id.button_convert);

        //обработчик события - нажатие кнопки button = button_convert
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_from_user.getText().toString();
                if (!text.equals("")) {
                    float num = Float.parseFloat(text);
                    num *= 1.61;
                    result.setText(Float.toString(num));
                    button.setText("Готово");
                    //проверка позволяет ли версия изменить цвет кнопки c tint
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    } else button.setBackgroundColor(Color.GREEN);
                    //всплывающая подсказка
                } else Toast.makeText(MainActivity.this,
                        "Введите число",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
