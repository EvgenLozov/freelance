package matva;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 27.03.13
 * Time: 13:22
 * To change this template use File | Settings | File Templates.
 */
public class DataProvider {
    private static List<Double> previosValue = new ArrayList<Double>();
    private static int countDatchik;

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {

        //setCountDatchik(Integer.parseInt(args[0]));
        setCountDatchik(5);
        setNullData();
        DBManager dbManager = new DBManager();

        int timer = 30;
        while (timer>0){
            for (Integer i = 0;i<countDatchik;i++){
                String nameTable = "datchik_"+i.toString();
                long timeLabel = System.currentTimeMillis();
                double value = getNextValue(previosValue.get(i));
                dbManager.addNextValue(nameTable,timeLabel,value);
            }
            timer--;
            Thread.sleep(2000);
        }
    }

    private static void setNullData(){
        for (int i = 0; i<countDatchik;i++){
            previosValue.add(100000D);
        }

    }

    public static double getNextValue(double prevValue){
        double nextValue;
        if (prevValue<100000)
            nextValue = prevValue + 1500;
        else
            nextValue = prevValue - 1500;

        Random r = new Random();
        double ver = r.nextDouble();
        if (ver <= 0.01)
            nextValue = prevValue + (r.nextDouble()*1000-500);
        else
            nextValue = prevValue - (r.nextDouble()*2000-1000);

        return nextValue;
    }

    public static void setCountDatchik(int countDatchikl) {
        countDatchik = countDatchikl;
    }
}
