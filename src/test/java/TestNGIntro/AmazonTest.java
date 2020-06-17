package TestNGIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        WebElement searchButton=driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle="Amazon.com : iphone";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
