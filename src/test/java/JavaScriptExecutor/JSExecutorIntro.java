package JavaScriptExecutor;

import Tests.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class JSExecutorIntro extends TestBase {
    @Test
            public void test1(){
    driver.get("http://www.techtorialacademy.com/");
    JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
    String title=javascriptExecutor.executeScript("return document.title;").toString();
    System.out.println(title);
        WebElement browseCourse=driver.findElement(By.xpath("//a[.='Browse Course']"));
        javascriptExecutor.executeScript("arguments[0].click()",browseCourse);
        title=javascriptExecutor.executeScript("return document.title;").toString();
        System.out.println(title);
        javascriptExecutor.executeScript("alert('Techtorial Academy JSExecutor Test')");
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement getStarted=driver.findElement(By.xpath("//h4[.='On-Campus Course']/following-sibling::div/a"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",getStarted);


    }
    @Test
    public void test2(){
        driver.get("http://www.techtorialacademy.com/");
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("history.go(0)");//refresh the page
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");//scroll to the bottom of the page
        WebElement onlineCourse= driver.findElement(By.xpath("//a[.='Online Course']"));
        Point point=onlineCourse.getLocation();//get location
        int xCoordinate=point.getX();//get x axis coordinate
        int yCoordinate=point.getY();//get y axis coordinate
        je.executeScript("window.scrollTo("+xCoordinate+","+yCoordinate+")");
        je.executeScript("window.scrollBy(0,600)");
        je.executeScript("arguments[0].setAttribute('style','background:indigo,border:3px solid red');",onlineCourse);

    }
}
