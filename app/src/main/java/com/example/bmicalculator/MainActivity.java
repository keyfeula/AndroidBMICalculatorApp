package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.Observable;
import java.util.Observer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

    private ModelBMI modelBMI;
    private Button calcBMIButton;
    private TextView BMITextView;
    private EditText heightEditText;
    private EditText weightEditText;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BMITextView = (TextView) findViewById(R.id.BMITextView);
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);

        calcBMIButton = (Button) findViewById(R.id.calcBMIButton);
        calcBMIButton.setOnClickListener(this);

        modelBMI = new ModelBMI();

    }

    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.calcBMIButton:
                    modelBMI.setHeight(Integer.parseInt(heightEditText.getText().toString()));
                    modelBMI.setWeight(Integer.parseInt(weightEditText.getText().toString()));
                    float BMINum = modelBMI.calculateBMI();
                    String message = modelBMI.getStatus();
                    int color = modelBMI.getColor();
                    messageTextView.setText("You are " + message);
                    messageTextView.setTextColor(color);
                    BMITextView.setText("BMI: " + BMINum);

            }
    }
}