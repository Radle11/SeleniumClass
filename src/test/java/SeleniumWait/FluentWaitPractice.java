package SeleniumWait;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitPractice {
    WebDriver driver;
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        Wait <WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        WebElement message=wait.until(
                driver -> driver.findElement(By.id("message")));//lambda expression
        String actualMessage=message.getText();
        String expectedMessage="It's gone!";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement add=driver.findElement(By.xpath("//button[.='Add']"));
        add.click();
        message=wait.until(
                driver -> driver.findElement(By.id("message")));//lambda expression
        String actualBackMessage=message.getText();
        String expectedBackMessage="It's back!";
        Assert.assertEquals(actualBackMessage,expectedBackMessage);

    }
}
