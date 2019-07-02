package com.example.testproject;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick (View view) {
        EditText text_from_user = (EditText) findViewById(R.id.editText);
        TextView result = (TextView) findViewById(R.id.result_filed);
        String text = text_from_user.getText().toString();
        if (!text.equals(""))
        {
            float num = Float.parseFloat(text);
            num *= 1.61;
            result.setText(Float.toString(num));
        } else result.setText("Введите число");
    }
}
