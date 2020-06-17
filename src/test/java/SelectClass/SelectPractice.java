package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectPractice {
   public static WebDriver driver;

    @Test
    public static void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("file:///C:/Users/Administrator.DESKTOP-DMM2MC9/Documents/HTML/Techtorial%20(2).html");
        WebElement dropDown=driver.findElement(By.xpath("//tr//select[@name='country']"));
        dropDown.sendKeys("MEXICO");
    }
    @Test
    public static void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("file:///C:/Users/Administrator.DESKTOP-DMM2MC9/Documents/HTML/Techtorial%20(2).html");
        WebElement dropDown=driver.findElement(By.xpath("//tr//select[@name='country']"));
        //select constructor require one parameter as webelement of select tag
        Select select=new Select(dropDown);
        select.selectByVisibleText("KYRGYZSTAN");
        Thread.sleep(2000);
        select.selectByIndex(55);
        Thread.sleep(2000);
        select.selectByValue("235");
    }
    @Test(priority = 0)
    public static void test3(){
        WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("file:///C:/Users/Administrator.DESKTOP-DMM2MC9/Documents/HTML/Techtorial%20(2).html");
        WebElement dropDown=driver.findElement(By.xpath("//tr//select[@name='country']"));
        Select select=new Select(dropDown);
        WebElement defaultOption=select.getFirstSelectedOption();
        String actualResult=defaultOption.getText().trim();
        String expectedResult="BULGARIA";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public static void test4(){
        WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        //driver.get("file:///C:/Users/Administrator.DESKTOP-DMM2MC9/Documents/HTML/Techtorial%20(2).html");
        WebElement dropDown=driver.findElement(By.xpath("//tr//select[@name='country']"));
        Select select=new Select(dropDown);
        List<WebElement> options = select.getOptions();

        int count=0;
        for(WebElement option:options){
            count++;
            System.out.println(option.getText());
        }
        System.out.println("Amount of countries: "+count);
        int countryNumber=options.size();
        int expectedCountryNumber=264;
        Assert.assertTrue(countryNumber==expectedCountryNumber);
    }

}
