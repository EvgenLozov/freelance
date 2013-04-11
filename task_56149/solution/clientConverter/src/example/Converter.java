package example;

import com.CurrencyConverterServiceServiceLocator;
import com.CurrencyConverterService_PortType;

import java.io.*;
import java.nio.file.*;

public class Converter {

    enum Currency{USD, GBR, EUR}

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter1, bufferedWriter2;
    private static CurrencyConverterService_PortType service;

  public static void performConverting(File inputFile) {
      try {
          CurrencyConverterServiceServiceLocator locator = new CurrencyConverterServiceServiceLocator();
          service = locator.getCurrencyConverterService();

          bufferedReader = new BufferedReader(new FileReader(inputFile));

          Currency currencyFrom = Currency.valueOf(bufferedReader.readLine().toUpperCase());

          switch (currencyFrom){
              case USD:
                  convertUsd();
                  break;
              case EUR:
                  convertEur();
                  break;
              case GBR:
                  convertGbr();
                  break;
          }
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    private static void convertUsd() throws IOException {
        bufferedWriter1 = new BufferedWriter(new FileWriter("invoice_EUR.txt"));
        bufferedWriter1.write("EUR\r\n");
        bufferedWriter2 = new BufferedWriter(new FileWriter("invoice_GBR.txt"));
        bufferedWriter2.write("GBR\r\n");

        convertAllValuesFromFile(service.convert("usd/eur"), service.convert("usd/gbr"));
    }

    private static void convertEur() throws IOException {
        bufferedWriter1 = new BufferedWriter(new FileWriter("invoice_USD.txt"));
        bufferedWriter1.write("USD\r\n");
        bufferedWriter2 = new BufferedWriter(new FileWriter("invoice_GBR.txt"));
        bufferedWriter2.write("GBR\r\n");

        convertAllValuesFromFile(service.convert("eur/usd"),service.convert("eur/gbr"));
    }

    private static void convertGbr() throws IOException {
        bufferedWriter1 = new BufferedWriter(new FileWriter("invoice_EUR.txt"));
        bufferedWriter1.write("EUR\r\n");
        bufferedWriter2 = new BufferedWriter(new FileWriter("invoice_USD.txt"));
        bufferedWriter2.write("USD\r\n");

        convertAllValuesFromFile(service.convert("gbr/eur"), service.convert("gbr/usd"));
    }

    private static void convertAllValuesFromFile(double exchangeRate1, double exchangeRate2) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null){
            bufferedWriter1.write((Double.parseDouble(line)*exchangeRate1)+"\r\n");
            bufferedWriter2.write((Double.parseDouble(line)*exchangeRate2)+"\r\n");
        }
        bufferedWriter1.close();
        bufferedWriter2.close();

    }
}