package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        Actions actions=new Actions(driver);
        WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target=driver.findElement(By.xpath("//div[@id='droptarget']"));
        String beforeDragText=target.getText();
        String expectedBefore="Drag the small circle here.";
        Assert.assertEquals(beforeDragText,expectedBefore,"Expected and actual is not matching.");
        actions.dragAndDrop(source,target).perform();
        target=driver.findElement(By.xpath("//div[@id='droptarget']"));
        String afterDragText=target.getText();
        String expectedText="You did great!";
        Assert.assertEquals(afterDragText,expectedText);



    }
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target=driver.findElement(By.xpath("//div[@id='droptarget']"));
        actions.clickAndHold(source).moveToElement(target).perform();
        actions.release().perform();

    }
}
