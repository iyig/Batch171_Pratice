package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");


        // Kaynak Kodlarini konsola yazdiriniz
        String sayfaKaynakKodlari = driver.getPageSource();
        System.out.println(sayfaKaynakKodlari);


        // Kaynak Kodlarinda "window" yazdigini test edin

        if (sayfaKaynakKodlari.contains("window")) {
            System.out.println("Kaynak Kodlarında window Yazıyor");
        } else {
            System.out.println("Kaynak Kodlarında window Yazmıyor");
        }


        // sayfayi kapatiniz
        driver.close();


    }
}