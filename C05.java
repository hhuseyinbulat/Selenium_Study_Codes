package selenium_study;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C05 extends TestBase {
    @Test
    public void day09_Challenge() {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site
        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> emojies = driver.findElements(By.xpath("//div[@id='nature']//img"));
        emojies.forEach(WebElement::click);
        // ana iframe'e geri dön
        driver.switchTo().parentFrame();
        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> blanks = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> words = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","k","l"));
        for (int i = 0; i < blanks.size(); i++) {
            blanks.get(i).sendKeys(words.get(i));
        }

        // uygula butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
    }
}
