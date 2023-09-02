package day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // amazon git
        driver.get("https://amazon.com");

        // arama kutusunun tagName'inin 'input oldugunu test ediniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";
        Assert.assertTrue(expectedTagName.equals(actualTagName));


        // arama kutusunun, name attribute'nun degerinin  'field_keywords'oldugunu test edin

        String actualNameDegeri = aramaKutusu.getAttribute("name");
        String expectedNameDegeri = "field-keywords";

        // Assert.assertTrue(expectedNameDegeri.equals(actuelNameDegeri));
        Assert.assertEquals(expectedNameDegeri, actualNameDegeri);
    }

}