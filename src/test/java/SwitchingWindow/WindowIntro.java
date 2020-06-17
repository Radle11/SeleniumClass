package SwitchingWindow;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowIntro {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();


    }
    @Test
    public void test1(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement clickHere=driver.findElement(By.xpath("//div[@id='content']//div//a[@target='_blank']"));
        clickHere.click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        String parentPageId=driver.getWindowHandle();//will return String for page ID
        System.out.println(parentPageId);
        Set<String> pageIDs=driver.getWindowHandles();//Set<String>
        //switchTo() and window(PageId)
        for (String id:pageIDs) {
            if (!id.equals(parentPageId)){
                driver.switchTo().window(id);
            }
        }
        System.out.println("After switching title: "+driver.getTitle());
        System.out.println("After switching URL: "+driver.getCurrentUrl());
        //if you dont switch to new window, you can not use the parent window
        //once you switch to the new window, you can not use the parent window
        //ynless you switch back to the parent window
        driver.switchTo().window(parentPageId);
        clickHere.click();
    }
    @Test
    public void test2(){
        driver.get("http://www.popuptest.com/popuptest12.html");
        String currentPageId=driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();
        System.out.println(ids);
        for (String id:ids) {
            if (!id.equals(currentPageId)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(currentPageId);
        //switch back to the parent page, even if you closed the new windows, the driver is still pointing to the
        //previous page.
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void test3(){
        driver.get("http://www.popuptest.com/popuptest1.html");
        String parentId=driver.getWindowHandle();
        BrowserUtils.closeWindows(driver,parentId);


    }
}
