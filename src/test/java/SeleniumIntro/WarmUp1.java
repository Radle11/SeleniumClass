package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class WarmUp1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.className("gLFyf"));
        searchBox.sendKeys("Selenium");
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']"));
        searchButton.click();
        List<WebElement> heads = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        for(WebElement head:heads){
            String hd=head.getText();
            if(!hd.equals("")){
                if(hd.contains("Selenium") || hd.contains("selenium")){
                    System.out.println("Includes selenium");
                }else{
                    System.out.println("Doesn't include selenium");
                }
            }
        }
    }
}