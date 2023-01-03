package selenium_study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C04 extends TestBase {
    @Test
    public void day09_Challenge2() {
        //       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //       ilk pencereyi al
        String window1 = driver.getWindowHandle();
        //       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[@href='../articles_popup.php']")).click();
        //       setteki tüm pencereyi al
        Set<String> handels = driver.getWindowHandles();
        //       diğer pencereye geç
        for (String w : handels){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }
        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@*='emailid']")).sendKeys("somepne@gmail.com");
        //       Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String text = driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",text);
        //       Tekrar ilk pencereye geç
        driver.switchTo().window(window1);
        //       İlk pencerede olduğunu doğrula
        String sonWindow1 = driver.getWindowHandle();
        Assert.assertEquals(sonWindow1,window1);
    }
}
