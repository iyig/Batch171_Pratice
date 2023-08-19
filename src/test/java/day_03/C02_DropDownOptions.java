package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownOptions extends TestBase {
    @Test
    public void test01() {

// https://www.amazon.com/

        driver.get("https://www.amazon.com/");


        //dropdowndan "Baby secenegini s
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        ddmVisibleText(ddm,"Baby");

        //sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());


        //dropdowndaki optionlarin toplam sayısının 28'e esit oldugunu test edin
     List<WebElement> optionlarList=select.getOptions();
     int expectedOptionsSayisi=28;
       int actualOptionsSayisi=optionlarList.size();

     Assert.assertEquals(expectedOptionsSayisi,actualOptionsSayisi);

     //dropdowndaki optionların tamamnını yazdırın


        for (WebElement w:optionlarList
             ) {
            System.out.println(w.getText());
        }
    }
}
