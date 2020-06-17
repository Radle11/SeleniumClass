package iFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingIFramesPractice {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(0);//switching to built in iframe by locating it wih index number
        WebElement textBox=driver.findElement(By.id("tinymce"));
        System.out.println(textBox.getText());
        driver.switchTo().defaultContent();//switches the driver to default html
        WebElement header=driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());
    }
    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");//parent frame
        driver.switchTo().frame("frame-middle");//child frame
        WebElement middle=driver.findElement(By.id("content"));
        System.out.println(middle.getText());
        driver.switchTo().parentFrame();//switches to parent frame if the frames are nested
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));//frame identified by WebElement
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(right.getText());

    }
    @Test
    public void test3(){
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame("Frame1");
        WebElement category2=driver.findElement(By.xpath("//a[@href='http://qavalidation.com/category/basicjava']"));
        category2.click();
        BrowserUtils.switchWindowByURL(driver,"basicjava");//called method which switches driver to the new window
        System.out.println(driver.getTitle());
        WebElement header=driver.findElement(By.xpath("//p[@class='site-description']"));
        System.out.println(header.getText());
        //driver.close();
        BrowserUtils.switchWindowByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
    }
    @Test
    public void test4(){
        driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='packageListFrame']")));
        List<WebElement> packageNames=driver.findElements(By.xpath("//a[@target='packageFrame']"));
        for (WebElement packageName:packageNames){
            System.out.println(packageName.getText());
        }

    }
    @AfterClass
    public void end(){
        driver.quit();
    }
}
