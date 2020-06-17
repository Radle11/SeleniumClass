package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderAction {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        ;
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        //moveByOffset(x,y)->moves the ouse from current coordinate to the provided coordinate
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        actions.clickAndHold(slider).moveByOffset(20, 0).release().perform();
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));
        for (int i = -55; i <= 55; i += 5) {
            actions.clickAndHold(slider).moveByOffset(i, 0).release().perform();
        }

    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        ;
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        //moveByOffset(x,y)->moves the ouse from current coordinate to the provided coordinate
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));
        int xOffset = -55;
        while (!range.getText().equals("5")) {
            actions.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
            xOffset += 10;
        }

    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        Actions actions = new Actions(driver);
        //moving range without move method
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));
        actions.clickAndHold(slider);
        actions.sendKeys(Keys.HOME);
        while (!range.getText().equals("5")) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
    }
    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/slider/keyboard-navigation");
        WebElement first = driver.findElement(By.xpath("//div//a[@style='left: -8px;']"));
        WebElement second = driver.findElement(By.xpath("//div//a[@style='left: 190px;']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(first).moveByOffset(30, 0).release().perform();
        actions.clickAndHold(second).moveByOffset(-30, 0).release().perform();
    }
    @Test
    public void test5(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/keyboard-navigation");
        WebElement first=driver.findElement(By.xpath("//a[contains(@style,'left: -8px')]"));
        WebElement second=driver.findElement(By.xpath("//a[contains(@style,'left: 190px')]"));
        Point point = first.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        System.out.println(xcord);
        System.out.println(ycord);
        Point point2 = second.getLocation();
        System.out.println(point2.getX());
        System.out.println(point2.getY());
        // 740-542== 198
        Actions actions=new Actions(driver);
        // first element left to right
        actions.clickAndHold(first).moveByOffset(200,0).release().perform();
        // second element right to left
        actions.clickAndHold(second).moveByOffset(-200,0).release().perform();
    }
    @Test
    public void test6(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/angular");
        WebElement vertical=driver.findElement(By.xpath("//a[@style='bottom: -8px;']"));
        WebElement ten=driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='10']"));
        WebElement zero=driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='0']"));

        Point tenY=ten.getLocation();
        System.out.println(tenY.getY());
        Point zeroY=zero.getLocation();
        System.out.println(zeroY.getY());
        System.out.println(tenY.getY()-zeroY.getY());
        // 454-542=-88
        Actions actions=new Actions(driver);
        actions.clickAndHold(vertical).moveByOffset(0,-95).release().perform();
        actions.clickAndHold(vertical).moveByOffset(0,44).release().perform();
    }

}