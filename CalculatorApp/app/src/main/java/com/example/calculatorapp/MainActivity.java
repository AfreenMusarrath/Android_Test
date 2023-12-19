package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1,editTextNumber2;
    private Spinner spinnerOperation;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber1=findViewById(R.id.editTextNumber1);
        editTextNumber2=findViewById(R.id.editTextNumber2);
        spinnerOperation = findViewById(R.id.spinnerOperation);
        buttonCalculate=findViewById(R.id.buttonCalculate);
        textViewResult=findViewById(R.id.textViewResult);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(
                this,
                R.array.operations_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerOperation.setAdapter(adapter);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }
    private void calculate(){
        double number1=Double.parseDouble(editTextNumber1.getText().toString());
        double number2=Double.parseDouble(editTextNumber2.getText().toString());
        String selectedOperation=spinnerOperation.getSelectedItem().toString();
        double result= 0;
        switch (selectedOperation){
            case "+":
                result=number1+number2;
                break;
            case "-":
                 result=number1-number2;
                 break;
            case "*":
                  result=number1*number2;
                  break;
            case "/":
                 if(number2!=0)
                 {
                     result=number1/number2;
                 }
                 else {

                 }
                 break;
        }
        textViewResult.setText("Result :"+result);
    }
}