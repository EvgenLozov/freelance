package mycompany;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ReportProviderA {
    private static Scanner in = new Scanner(System.in);
    private static File inputFile;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter name for input file: ");
        String inputFileName = in.nextLine();
        inputFile = new File(inputFileName);

       createAgentReport(getPropertyType(), getTotalPropertyListedOfAgents());

    }

    public static Set<String> getPropertyType() throws FileNotFoundException {
        Scanner in = new Scanner(inputFile);

        Set<String> setOfPropertyType = new TreeSet<String>();
        while(in.hasNext()){
            setOfPropertyType.add(getWord(in.nextLine(),1).toUpperCase());
        }
        in.close();

        return setOfPropertyType;
    }

    public static Map<Integer,Double> getTotalPropertyListedOfAgents() throws FileNotFoundException {
        Scanner in = new Scanner(inputFile);

        Map<Integer,Double> totalAssetsOfAgent = new TreeMap<Integer, Double>();
        while (in.hasNext()){
            String line = in.nextLine();
            Integer agentId = Integer.parseInt(getWord(line,3));
            Double  priceObject = Double.parseDouble(getWord(line,2));

            if (totalAssetsOfAgent.containsKey(agentId)){
                totalAssetsOfAgent.put(agentId,totalAssetsOfAgent.get(agentId)+priceObject);
            }else{
                totalAssetsOfAgent.put(agentId,priceObject);
            }
        }
        in.close();

        return totalAssetsOfAgent;
    }

    public static void createAgentReport(Set<String> set, Map<Integer, Double> map) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("agentreport.txt ");

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()){
            printWriter.println(itr.next());
        }

        printWriter.println("\n");

        for (Integer key: map.keySet()){
            printWriter.println(key+"   "+map.get(key));
        }
        printWriter.close();

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
