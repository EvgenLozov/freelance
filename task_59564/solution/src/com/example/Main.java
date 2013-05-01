package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner((new File(args[0])));

        PolynomialFunction polynomialFunction = new PolynomialFunction();

        String[] coefficients = in.nextLine().split(" ");
        for (int i=0; i<coefficients.length; i++){
           polynomialFunction.setNextCoefficient(Double.parseDouble(coefficients[i]));
        }

        BoltzmannAnnealingSimulation simulation = new BoltzmannAnnealingSimulation(polynomialFunction);
        simulation.setMaxIteration( Integer.parseInt(in.nextLine()) );
        simulation.setStartingTemperature( 1 );

        System.out.println("The optimum solution: "+simulation.search());
    }
}
