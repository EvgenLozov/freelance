package com.example.second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter name for input file: ");
        String inputFileName = in.nextLine();

        Scanner in = new Scanner((new File(inputFileName)));

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
