package day_10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Waits extends TestBase {

// https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
// Textbox'in etkin olmadıgını(enable) test edin
// Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
// It's enable! mesajının goruntulendigini test edin
// Textbox'in etkin oldugunu(enable) test edin


    @Test
    public void test01() {
        // hCadresine gidiniz
driver.get("https://the-internet.herokuapp.com/dynamic_controls");



// Textbox'in etkin olmadıgını(enable) test edin

WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textBox.isEnabled());
    }
}
