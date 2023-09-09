package day_09;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {

// Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız


    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız

        Map<String,String> ulkelerMap = new LinkedHashMap<>();


        FileInputStream fis = new FileInputStream("src/resources/ulkeler (1).xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        //  getLastRowNum() son satır numarasını index olarak verir.


        for (int i = 0; i <=sonSatirIndex ; i++) {

            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();


            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();


            ulkelerMap.put(key,value + "\n");

        }

        System.out.println(ulkelerMap);


    }
}
