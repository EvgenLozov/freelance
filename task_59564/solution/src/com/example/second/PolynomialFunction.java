package com.example.second;

import java.util.ArrayList;
import java.util.List;

public class PolynomialFunction implements SingleVariableFunction {

    private List<Double> coefficients = new ArrayList<Double>();

    @Override
    public double evaluate(double argument) {
        double value = 0;
        int exponent = 0;

        for (double coefficient: coefficients){
            value += coefficient*Math.pow(argument,exponent);
            exponent++;
        }

        return value;
    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public void setNextCoefficient(double coefficient){
        coefficients.add(coefficient);
    }
}
