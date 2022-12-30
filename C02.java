package selenium_study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02 extends TestBase {


    @Test
    public void day08_ChallengeTest() {
        //  1) go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //2) "Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.xpath("//*[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //3) Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //4) "Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //5) Alert'ü kapatın
        driver.switchTo().alert().accept();

        //6) "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        //7) Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //8) Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        String actualResult = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        Assert.assertTrue(actualResult.contains("TechProEducation"));
        //9) finally print on console this mesaaje "Hello TechproEducation How are you today"
        System.out.println(actualResult);
    }
}
