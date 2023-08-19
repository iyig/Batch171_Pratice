package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {

    @Test
    public void test01() {
    // https://www.amazon.com/
        driver.get("https://www.amazon.com/");



        // drıpdowndan Books secenegini secin

         // Dropdown 3 adımda handle edilir
         //Dropdrown LOCATE edilmelidir
  WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
   // 2-Select obejesi olusturur

        Select select=new Select(ddm);
  //3-Optionlardan bir tanesi secilmelidir
       // select.selectByVisibleText("Books");
          //ddmVisibleText(ddm,"Books");
      //  select.selectByIndex(5);
          //ddmIndex(ddm,5);
   //select.selectByValue("search-stripbooks-intl-ship");
       // ddmValue(ddm,"search-stripbooks-intl-ship");



        // arama cubuguna "Java "a aratin

driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);



//arama sonuclarının Java icerdigini test edin

      WebElement aramaSocucElement=  driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSocucElement.getText().contains("Java"));

    }
}
