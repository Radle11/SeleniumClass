package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ActionsSummaryPractice {
    public WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        //implicit wait, takes 2 parameters (int value,TimeUnits)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebElement target1 = driver.findElement(By.className("test1"));
        WebElement target2 = driver.findElement(By.className("test2"));
        String actualText1 = target1.getText();
        String expectedText1 = "Drag the small circle here ...";
        Assert.assertEquals(actualText1, expectedText1, "Target1 Default text test is failed");
        String actualText2 = target2.getText();
        String expectedText2 = "... Or here.";
        Assert.assertEquals(actualText2, expectedText2, "Target2 Default text test is failed");
    }
    @Test
            public void test2() {
        WebDriverManager.chromedriver().setup();
        WebElement source = driver.findElement(By.xpath("//div[@data-role='draggable']"));
        WebElement target1 = driver.findElement(By.className("test1"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target1).perform();
        target1 = driver.findElement(By.className("test1"));
        String actualDragText1 = target1.getText();
        String expecteDragText1 = "You did great!";
        Assert.assertEquals(actualDragText1, expecteDragText1, "After dropping, Target1 Default text test is failed");
        WebElement target2 = driver.findElement(By.className("test2"));
        String actualText2 = target2.getText();
        String expectedText2 = "(Drop here)";
        Assert.assertEquals(actualText2, expectedText2, "Target2  text test is failed");
    }
    @Test
    public void test3(){
        WebDriverManager.chromedriver().setup();
        WebElement source = driver.findElement(By.xpath("//div[@data-role='draggable']"));
        WebElement target2 = driver.findElement(By.className("test2"));
        new Actions(driver).dragAndDrop(source,target2).perform();
        target2=driver.findElement(By.className("test2"));
         String actualDragText2=target2.getText();
         String expectedDragText2="You did great!";
        Assert.assertEquals(actualDragText2,expectedDragText2, "After dropping, Target2 text test is failed");
        WebElement target1 = driver.findElement(By.className("test1"));
        String actualText1 = target1.getText();
        String expectedText1 = "(Drop here)";
        Assert.assertEquals(actualText1, expectedText1, "Target1  text test is failed");
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}
