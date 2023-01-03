package selenium_study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
  1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
  2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
  3-Option3 ü seçin.
  4-Option3 ün seçili olduğunu doğrulayın.
  */
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void test01() {
        boolean dropDownIsDisplayed = driver.findElement(By.xpath("//*[text()='Dropdown Example']")).isDisplayed();
        Assert.assertTrue(dropDownIsDisplayed);
    }

    @Test
    public void test02() {
        driver.findElement(By.id("checkBoxOption3")).click();
        boolean option3IsSelected = driver.findElement(By.id("checkBoxOption3")).isSelected();
        Assert.assertTrue(option3IsSelected);
     }

    @AfterClass
    public static void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}


