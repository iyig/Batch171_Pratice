package day_07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_ActionsMoveToElement extends TestBase {

//https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
    //Change country/region butonuna basiniz
    //United States dropdown'undan 'Turkey (Türkiye) seciniz
    //Go to website butonuna tiklayınız
    //acilan yeni sayfadanın Title'nn Elektronik icerdigini test ediniz


    @Test
    public void name() {
     //https://amazon.com adresine gidiniz
     driver.get("https://amazon.com");
     String sayfa1Handle=driver.getWindowHandle();
        System.out.println("sayfa1Handle: "+sayfa1Handle);

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
         WebElement dilMenu= driver.findElement(By.xpath("//div[text()='EN']"));
         Actions actions=new Actions(driver);
         actions.moveToElement(dilMenu).perform();
         bekle(3);
        //Change country/region butonuna basiniz
       driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();




        //United States dropdown'undan 'Turkey (Türkiye) seciniz

        // WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        //  Select select=new Select(ddm);
       // select.selectByVisibleText("Turkey (Türkiye)");
        WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        ddmVisibleText(ddm,"Turkey (Türkiye)");

         //Go to website butonuna tiklayınız

       //Drop down option Listesi 'Go to website' butonuna basmamaıza engel oldugu icin
        //herhangi bir yere click yapıp drop down option listesinin toparlanmasını sagladık
        driver.findElement(By.xpath("//*[.='Changing country/region website']")).click();


        driver.findElement(By.xpath("//input[@class='a-button-input'")).click();// Go to website butonuna click yapar


        //acilan yeni sayfadanın Title'nn Elektronik icerdigini test ediniz

       Set<String> windowHandlesSeti= driver.getWindowHandles();
  String sayfa2Handle="";


       for(String each:windowHandlesSeti) {
           if (!each.equals(sayfa1Handle)) {
               sayfa2Handle = each;
           }
       }
          driver.switchTo().window(sayfa2Handle);
            bekle(3);
         String ikinciSayfaTitle= driver.getTitle();
          bekle(3);
         Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));
      }


    @Test
    public void test02() {

       //https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
        WebElement dilMenu= driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(dilMenu).perform();
        bekle(3);
        //Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();




        //United States dropdown'undan 'Turkey (Türkiye) seciniz

        // WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        //  Select select=new Select(ddm);
        // select.selectByVisibleText("Turkey (Türkiye)");
        WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        ddmVisibleText(ddm,"Turkey (Türkiye)");

        //Go to website butonuna tiklayınız

        //Drop down option Listesi 'Go to website' butonuna basmamaıza engel oldugu icin
        //herhangi bir yere click yapıp drop down option listesinin toparlanmasını sagladık
        driver.findElement(By.xpath("//*[.='Changing country/region website']")).click();


        driver.findElement(By.xpath("//input[@class='a-button-input'")).click();// Go to website butonuna click yapar


        //acilan yeni sayfadanın Title'nn Elektronik icerdigini test ediniz

       List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        bekle(3);
        String ikinciSayfaTitle= driver.getTitle();
        bekle(3);
        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));

    }

    @Test
    public void test03() {

        //https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
        WebElement dilMenu= driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(dilMenu).perform();
        bekle(3);
        //Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();




        //United States dropdown'undan 'Turkey (Türkiye) seciniz

        // WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        //  Select select=new Select(ddm);
        // select.selectByVisibleText("Turkey (Türkiye)");
        WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        ddmVisibleText(ddm,"Turkey (Türkiye)");

        //Go to website butonuna tiklayınız

        //Drop down option Listesi 'Go to website' butonuna basmamaıza engel oldugu icin
        //herhangi bir yere click yapıp drop down option listesinin toparlanmasını sagladık
        driver.findElement(By.xpath("//*[.='Changing country/region website']")).click();


        driver.findElement(By.xpath("//input[@class='a-button-input'")).click();// Go to website butonuna click yapar


        //acilan yeni sayfadanın Title'nn Elektronik icerdigini test ediniz

        //List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
       //  driver.switchTo().window(pencereler.get(1));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        bekle(3);

        String ikinciSayfaTitle= driver.getTitle();
        bekle(3);
        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));

    }

    }












