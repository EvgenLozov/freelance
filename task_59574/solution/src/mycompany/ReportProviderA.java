package mycompany;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ReportProviderA {
    private static final int PROPERTY_TYPE = 1;
    private static final int AGENT_ID = 3;
    private static final int PRICE = 2;

    private static final String REPORT_FILE_NAME = "agentreport.txt";

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter file name: ");
        String inputFileName = in.nextLine();
        File source = new File(inputFileName);

       createAgentReport(getPropertyType(source), getTotalPropertyListedOfAgents(source));

    }

    public static Set<String> getPropertyType(File source) throws FileNotFoundException {
        Scanner in = new Scanner(source);

        Set<String> setOfPropertyType;
        try {
            setOfPropertyType = new TreeSet<String>();
            while(in.hasNext()){
                setOfPropertyType.add(getWord(in.nextLine(),PROPERTY_TYPE).toUpperCase());
            }
        } finally {
            in.close();
        }

        return setOfPropertyType;
    }

    public static Map<Integer,Double> getTotalPropertyListedOfAgents(File source) throws FileNotFoundException {
        Scanner in = new Scanner(source);

        Map<Integer,Double> totalAssetsOfAgent;
        try {
            totalAssetsOfAgent = new TreeMap<Integer, Double>();
            while (in.hasNext()){
                String line = in.nextLine();
                Integer agentId = Integer.parseInt(getWord(line,AGENT_ID));
                Double  price = Double.parseDouble(getWord(line,PRICE));

                if (totalAssetsOfAgent.containsKey(agentId)){
                    totalAssetsOfAgent.put(agentId,totalAssetsOfAgent.get(agentId)+price);
                }else{
                    totalAssetsOfAgent.put(agentId,price);
                }
            }
        } finally {
            in.close();
        }

        return totalAssetsOfAgent;
    }

    public static void createAgentReport(Set<String> set, Map<Integer, Double> map) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter( REPORT_FILE_NAME );

        try {
            Iterator<String> itr = set.iterator();
            while (itr.hasNext()){
                printWriter.println(itr.next());
            }

            printWriter.println("\n");

            for (Integer key: map.keySet()){
                printWriter.println(key+"   "+map.get(key));
            }
        } finally {
            printWriter.close();
        }
    }

    private static String getWord(String line,int numberOfWord){
        return line.split(" +")[numberOfWord];
    }
}
