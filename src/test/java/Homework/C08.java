package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C08 extends TestBase {

/*
        1.http://zero.webappsecurity.com/ Adresine gidin
            2.Sign in butonuna basin
    3.Login kutusuna “username” yazin
    4.Password kutusuna “password.” yazin
    5.Sign in tusuna basin(not: navigate.Back yapınız)
    6.Pay Bills sayfasina gidin
    7.“Purchase Foreign Currency” tusuna basin
    8.“Currency” drop down menusunden Eurozone’u secin
    9.“amount” kutusuna bir sayi girin
    10.“US Dollars” in secilmedigini test edin
    11.“Selected currency” butonunu secin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
         */

    @Test
    public void test01() {
      //  1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2.Sign in butonuna basin

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
 bekle(2);
       // 3.Login kutusuna “username” yazin
 driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //      4.Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        bekle(1);

       // 5.Sign in tusuna basin(not: navigate.Back yapınız)

        //      5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        //6.Pay Bills sayfasina gidin
    driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        bekle(1);
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

    //7.“Purchase Foreign Currency” tusuna basin

driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        bekle(2);

       // 8.“Currency” drop down menusunden Eurozone’u secin
        WebElement dropElement = driver.findElement(By.xpath("//select[@id='pc_currency'] "));

        Select select =new Select(dropElement);
        select.selectByIndex(6);

       // 9.“amount” kutusuna bir sayi girin

driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("99");


        //    10.“US Dollars” in secilmedigini test ed
        WebElement usDolarElement=driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        boolean result=usDolarElement.isSelected();
        Assert.assertFalse(result);
        //11.“Selected currency” butonunu secin

        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();



        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
bekle(1);
driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //      “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        String actualResult = driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
        String expectedResult = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedResult,actualResult);


    }
}
