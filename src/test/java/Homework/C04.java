package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {

// amazon git
// arama kutusunun tagName'inin 'input oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin  'field_keywords'oldugunu test edin


    @Test
    public void test01() {

    driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        String actualTagName= aramaKutusu.getTagName();
        String expectedTagName="input";
        Assert.assertTrue(actualTagName.equals(expectedTagName));
        // arama kutusunun, name attribute'nun degerinin  'field_keywords'oldugunu test edin
        String actualNameDegeri=aramaKutusu.getAttribute("name");
        String expectedNameDegeri="field_keyword";

        Assert.assertTrue(actualNameDegeri.equals(expectedNameDegeri));
    }
}
