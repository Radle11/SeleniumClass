package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.wikipedia.com");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1=new FirefoxDriver();
        driver1.get("https://www.techtorialacademy.com/");

    }
}
