package mycompany;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportProviderB {
    private static final int PROPERTY_ID = 0;
    private static final int PRICE = 2;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter file name:");
        String inputFileName = in.nextLine();

        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int totalNumberOfProperty = 0;
        double totalPropertyValue = 0;
        ArrayList<String> propertyIds = new ArrayList<String>();

        String line;
        while ((line = bufferedReader.readLine())!= null){
            String[] words = line.split(" +");
            totalNumberOfProperty++;
            totalPropertyValue += Double.parseDouble(words[PRICE]);
            propertyIds.add( words[PROPERTY_ID] );
        }

        bufferedReader.close();

        FileWriter fileWriter = new FileWriter("overview.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            bufferedWriter.write("Total properties listed: "+totalNumberOfProperty+"\n");
            bufferedWriter.write("Total value of properties listed: "+totalPropertyValue+"\n\n");

            for (String propertyId: propertyIds){
                bufferedWriter.write(propertyId+"\n");
            }
        } finally {
            bufferedWriter.close();
        }
    }

    private static String getWord(String line,int numberOfWord){
        return line.split(" +")[numberOfWord];
    }
}
