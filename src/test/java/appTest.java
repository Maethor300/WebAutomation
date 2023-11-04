import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class appTest {
    WebDriver driver = null;
   @Test
    public void testAutomation(){
     String driverPath = "src/Utiles/chromedriver.exe";
     System.setProperty("webdriver.chrome.driver" , driverPath);
     driver = new ChromeDriver();
     driver.get("https://wikipedia.org");
     driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
     WebElement searchInput = driver.findElement(By.id("searchInput"));
     String palabra = "Microsoft";
       for (int i = 0; i < palabra.length(); i++) {
           char verbum = palabra.charAt(i);
           String verbumToString = Character.toString(verbum);
           searchInput.sendKeys(verbumToString);
           try {
               Thread.sleep(300);
           } catch (InterruptedException e) {

               e.printStackTrace();
           }
       }
     WebElement searchButton = driver.findElement(By.className("pure-button-primary-progressive"));
       searchButton.click();
     WebElement titulo = driver.findElement(By.className("mw-page-title-main"));
       assertEquals(titulo.getText(), "Microsoft");
     WebElement bodyContent = driver.findElement(By.className("ve-init-mw-desktopArticleTarget-targetContainer"));
        List<WebElement> aLinks = driver.findElements(By.tagName("a"));
       for (WebElement a: aLinks
            ) {
           System.out.println(a.getText());
       }


   }
}
