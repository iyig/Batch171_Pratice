package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C03 extends TestBase {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        List<WebElement> programmingElement = driver.findElements(By.xpath("//select"));

        //Simple dropdown
        Select select0 = new Select(programmingElement.get(0));
        select0.selectByIndex(1);

        //Select your date of birth
        Select select1 = new Select(programmingElement.get(1));//year
        select1.selectByVisibleText("1987");

        Select select2 = new Select(programmingElement.get(2));//month
        select2.selectByIndex(0);

        Select select3 = new Select(programmingElement.get(3));//day
        select3.selectByIndex(24);


        //sadece seçili olan option'ları yani seçenekleri yazdıralim


        System.out.println(select0.getFirstSelectedOption().getText());     //Option 1
        System.out.println(select1.getFirstSelectedOption().getText());     //1987
        System.out.println(select2.getFirstSelectedOption().getText());     //January
        System.out.println(select3.getFirstSelectedOption().getText());     //25


        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım !!!!!!!!!!!!

        System.out.println(select0.getFirstSelectedOption().isSelected());  //true
        System.out.println(select1.getFirstSelectedOption().isSelected());  //true
        System.out.println(select2.getFirstSelectedOption().isSelected());  //true
        System.out.println(select3.getFirstSelectedOption().isSelected());  //true


        //Seçtiğimiz seçeneklerden ilkini yazdıralım
        System.out.println(select0.getOptions().get(0).getText());
        System.out.println(select1.getOptions().get(0).getText());
        System.out.println(select2.getOptions().get(0).getText());
        System.out.println(select3.getOptions().get(0).getText());


        //ilk seçeneğin Java olduğunu doğrulayalım
        Select select6 = new Select(programmingElement.get(5));
        String actualResult1 = select6.getOptions().get(0).getText();
        String expectedResult1 = "Java";

        Assert.assertEquals(expectedResult1, actualResult1);


        //Seçtiğimiz seçeneklerin hepsini kaldıralim
        select6.deselectAll();


        //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        visibleText(programmingElement.get(5), "C#");


    }

    public String asdf(WebElement asd){
        Select select = new Select(asd);
        return select.getFirstSelectedOption().getText();
    }



}
