package com.curso.android.app.practica.quadraticequationapp;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.curso.android.app.practica.quadraticequationapp.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    String a, b, c;
    ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MyEquation() {
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void SolveEquation(View view) {
        String answer;

        // convert the string to a double
        double aNum = Double.parseDouble(a);
        double bNum = Double.parseDouble(b);
        double cNum = Double.parseDouble(c);

        // calculate the discriminant
        double discriminant = bNum * bNum - 4 * aNum * cNum;

        if (discriminant < 0) {

            answer = "No real roots";
            binding.resultTv.setText(answer);

        } else if (discriminant == 0) {

            // calculate the root
            double root1 = -bNum / (2 * aNum);

            // convert the root to strings
            String root1String = String.valueOf(root1);

            answer = "There is one real root: " + root1String;
            binding.resultTv.setText(answer);


        } else {

            // calculate the roots
            double root1 = (-bNum + Math.sqrt(discriminant)) / (2 * aNum);
            double root2 = (-bNum - Math.sqrt(discriminant)) / (2 * aNum);

            // convert the roots to strings
            String root1String = String.valueOf(root1);
            String root2String = String.valueOf(root2);

            answer = "Root 1: " + root1String + " Root 2: " + root2String;
            binding.resultTv.setText(answer);
        }


    }
}
