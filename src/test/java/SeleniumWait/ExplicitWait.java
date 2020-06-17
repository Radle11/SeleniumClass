package SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWait {
    WebDriver driver;
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement addButton=driver.findElement(By.xpath("//button[.='Remove']"));
        addButton.click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement message=driver.findElement(By.id("message"));
        String actualMessage=message.getText();
        String expectedMessage="It's gone!";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement add=driver.findElement(By.xpath("//button[.='Add']"));
        add.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        String actualBackMessage= driver.findElement(By.id("message")).getText();
        String expectedBackMessage="It's back!";
      Assert.assertEquals(actualBackMessage,expectedBackMessage);

    }
}
