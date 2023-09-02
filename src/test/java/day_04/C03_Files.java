package day_04;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Files {
    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


    @Test
    public void test01() {

        // Desktop(masaustu)'da bir text dosyası olusturun
                      //"C:\Users\Lenovo\Desktop\text.txt"

    String farkliKisim=System.getProperty("user.home");//C:\Users\Lenovo
    String ortakKisim="\\Desktop\\text.txt";
    String dosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
