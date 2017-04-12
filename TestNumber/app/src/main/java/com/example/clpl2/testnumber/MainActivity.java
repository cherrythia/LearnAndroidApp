package com.example.clpl2.testnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;

                triangularNumber = triangularNumber + x;
            }

            if (number == triangularNumber) {
                return true;
            } else {
                return false;
            }

        }

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {

        String message = "";

        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);

        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter a number.";
        } else {

            Number mynumber = new Number();

            mynumber.number = Integer.parseInt(usersNumber.getText().toString());

            Log.i("userNumbers",usersNumber.getText().toString());



            if(mynumber.isSquare()) {

                Log.i("Check","Number is a square number.");

                if (mynumber.isTriangular()) {
                    message = mynumber.number + " is a square + triangular number.";
                } else {
                    message = mynumber.number + " is square but not triangular number.";
                }

            } else {

                if (mynumber.isTriangular()) {
                    message = mynumber.number + " is not square but triangular number.";
                } else {
                    message = mynumber.number + " is neither square nor triangular number.";
                }

            }

        }

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
