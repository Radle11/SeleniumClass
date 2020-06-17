package SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice {
    WebDriver driver;
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //it will wait the page until it is loaded for 10 sec
        driver.get("https://www.expedia.com/");

    }
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement addButton=driver.findElement(By.xpath("//button[.='Remove']"));
        addButton.click();
        WebElement message=driver.findElement(By.id("message"));
        String actualMessage=message.getText();
        String expectedMessage="It's gone!";
        Assert.assertTrue(message.isDisplayed(),"validate if message is displayed");
        Assert.assertEquals(actualMessage, expectedMessage,"validating the message text");

    }
}
