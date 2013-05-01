package com.example.second;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PolynomialFunction polynomialFunction = new PolynomialFunction();

        ArrayList<Double> coefficients = new ArrayList<Double>();
        coefficients.add(-9.0);
        coefficients.add(15.3);
        coefficients.add(1.3);
        coefficients.add(13.8);
        coefficients.add(7.6);
        coefficients.add(-1.5);
        coefficients.add(0.1);
        polynomialFunction.setCoefficients(coefficients);

        BoltzmannAnnealingSimulation simulation = new BoltzmannAnnealingSimulation(polynomialFunction);
        simulation.setMaxIteration( 1000000 );
        simulation.setStartingTemperature( 100 );


        double decision = simulation.search();

        System.out.println(decision);
    }
}
