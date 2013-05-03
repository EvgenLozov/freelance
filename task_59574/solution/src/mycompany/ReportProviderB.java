package mycompany;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportProviderB {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("Enter name for input file: ");
        String inputFileName = in.nextLine();

        FileReader fileReader = new FileReader(inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int totalNumberOfProperty = 0;
        double totalPropertyValue = 0;
        ArrayList<Integer> propertyIds = new ArrayList<Integer>();

        String line;
        while ((line = bufferedReader.readLine())!= null){
            totalNumberOfProperty++;
            totalPropertyValue += Double.parseDouble(getWord(line, 2));
            propertyIds.add(Integer.parseInt(getWord(line, 0)));
        }

        bufferedReader.close();

        FileWriter fileWriter = new FileWriter("overview.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Total properties listed: "+totalNumberOfProperty+"\n");
        bufferedWriter.write("Total value of properties listed: "+totalPropertyValue+"\n\n");

        for (Integer propertyId: propertyIds){
            bufferedWriter.write(propertyId+"\n");
        }

        bufferedWriter.close();
    }

    private static String getWord(String line,int numberOfWord){
        String[] words = line.split(" ");
        int positionWord = -1;
        for (int i=0; i<words.length; i++){
            if (!words[i].equals("")){
                positionWord++;
                if (positionWord == numberOfWord){
                    return words[i];
                }
            }
        }

        return "";
    }
}
