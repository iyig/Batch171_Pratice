package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FilesUploadRobot extends TestBase {


    // https://www.ilovepdf.com/compress_pdf adrese gidelim

    // Dosya yuklemek icin robot class'ını kullanalım


    @Test
    public void testo1() {
driver.get("https://www.ilovepdf.com/compress_pdf");

        // Dosya sec butonuna tıklayalım
        WebElement dosyaSec=driver.findElement(By.xpath("//span[text()='Select PDF files']"));
        dosyaSec.click();
         // Dosya yuklemek icin robot class'ını kullanalım
        //"C:\Users\Lenovo\Desktop\2023 07 31 Soydan Tekin - Lächeln-Makeover.pdf"


        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\2023 07 31 Soydan Tekin - Lächeln-Makeover.pdf";

        String dosyaYolu= farkliKisim+ortakKisim;
         uploadFilePath(dosyaYolu);

    }
}
