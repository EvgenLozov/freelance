package parserexel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 16.03.13
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class TestExelApi   {
    public static void main(String[] args) throws BiffException, IOException {
        Workbook workbook = Workbook.getWorkbook(new File("d:\\Other\\pechat\\TDB_Dealers_08-02-2013.xls"));
        Sheet sheet = workbook.getSheet(0);
        int startRow = 20;
        int finishRow = 50;
        for (int i = startRow; i<finishRow; i++){
            Cell[] column = sheet.getRow(i);
            if (column[2].getContents() == column[3].getContents()){
                System.out.println("New category: "+ column[2].getContents());
            }
            else {
                for (Cell call: column ){
                    System.out.print(call.getContents()+"  ");
                }
                System.out.print("\n");

            }
        }
    }

}

