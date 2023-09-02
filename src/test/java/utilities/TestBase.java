package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public  class TestBase {

    protected WebDriver driver;
    protected Select select;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        // driver.close();
    }

    //HARD WAIT
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Dropdown Select Index
    public void selectVisible(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //Select Index DDM
    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //visibleText
    public void visibleText(WebElement webElement, String text) {
        select = new Select(webElement);
        select.selectByVisibleText(text);
    }

    public WebElement xpathElementOlustur(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    public List<WebElement> xpathElementListOlustur(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    //dropDown select String
    public void selectValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public Select selectValueOlustur(WebElement element) {
        select = new Select(element);

        return select;
    }
  public void ddmVisibleText(WebElement ddm,String secenek){
            Select select=new Select(ddm);
            select.selectByVisibleText(secenek);
  }

public void ddmIndex(WebElement ddm,int index){
      Select select=new Select(ddm);
        select.selectByIndex(index);
}
public void ddmValue(WebElement ddm,String value){
        Select select=new Select(ddm);
        select.selectByValue(value);
}
    public void uploadFilePath(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    public void tumSayfaEkranGoruntusu() {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File kaydet = new File("target/ekranGoruntusu/tumSayfa.jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya, kaydet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }}