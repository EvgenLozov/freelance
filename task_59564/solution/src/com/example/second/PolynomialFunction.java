package com.example.second;

import java.util.ArrayList;
import java.util.List;

public class PolynomialFunction implements SingleVariableFunction {

    private List<Double> coefficients = new ArrayList<Double>();

    @Override
    public double evaluate(double argument) {
        double value = 0;

        for (int i = 0; i<coefficients.size()-1; i++){
            value += coefficients.get(i)*Math.pow(argument,i);
        }

        return value;
    }

    public List<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }
}
