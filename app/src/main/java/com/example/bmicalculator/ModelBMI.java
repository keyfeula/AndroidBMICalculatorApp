package com.example.bmicalculator;

import android.graphics.Color;
import java.util.Observable;

public class ModelBMI extends Observable
{
    private float height = 0;
    private float weight = 0;
    private float BMI = 0;
    private String status = null;
    private int color = 0;


    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public float getHeight()
    {
        return height;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setHeight(float ht)
    {
        height = ht;
        setChanged();
        notifyObservers();
    }

    public void setWeight(float wt)
    {
        weight = wt;
        setChanged();
        notifyObservers();
    }

    public float calculateBMI()
    {
        BMI = (weight/(height * height))*703;

        if (BMI < 18)
        {
            color = Color.BLUE;
            status = "underweight";
        }
        else if (BMI >= 18 && BMI < 25)
        {
            color = Color.GREEN;
            status = "normal";
        }
        else if (BMI >= 25 && BMI <= 30)
        {
            color = Color.parseColor("#800080");
            status = "pre-obese";
        }
        else
        {
            color = Color.RED;
            status = "obese";
        }
        setChanged();
        notifyObservers();
        return BMI;
    }
}
