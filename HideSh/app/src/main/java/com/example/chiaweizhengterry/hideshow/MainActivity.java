package com.example.chiaweizhengterry.hideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button hideShowButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideShowButton = (Button) findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);

    }

    public void buttonClicked(View view) {
        if (textView.getVisibility() == View.VISIBLE) {
            textView.setVisibility(View.INVISIBLE);
            hideShowButton.setText("Show!");
        } else {
            textView.setVisibility(View.VISIBLE);
            hideShowButton.setText("Hide!");
        }
    }
}
