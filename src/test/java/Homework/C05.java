package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;

public class C05 extends TestBase {

// https://www.google.com/ adresine gidin
// sayfa baslıgının "Google" kelimesini icerdigini test edin
// arama cubuguna "Nutella" yazıp aratın
// bulunan sonuc sayısını yazdırın



    @Test
    public void test01() {

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
    String sayfaBaslıgı= driver.getTitle();
        Assert.assertTrue(sayfaBaslıgı.contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın
        WebElement aramaKutusu=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // bulunan sonuc sayısını yazdırın

        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());
String arr[]=sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(arr));
        String sonuc=arr[1];
        System.out.println(sonuc);


        // sonuc sayısının 100000000  fazla oldugunu test edin

       String sonucc= sonuc.replaceAll("\\D", "");
        System.out.println(sonucc);
        Assert.assertTrue(Integer.parseInt(sonucc)>100000000);
    }
}
