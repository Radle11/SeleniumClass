package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class KeyBoardFunctions {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        Actions actions=new Actions(driver);
        driver.get("https://www.google.com/");
        WebElement searchInput=driver.findElement(By.name("q"));
        //to be able to click shift button we need to use key down method
        //Keys is Enum.
        actions.moveToElement(searchInput)
                .click()
                .keyDown(searchInput, Keys.SHIFT)
                .sendKeys("selenium")
                .keyUp(Keys.SHIFT)
                .doubleClick(searchInput)
                .contextClick(searchInput)
                .perform();
        //keys are working with actions class and webelement
        //for web element we need to send a key with Keys. parameter
        searchInput.sendKeys(Keys.ARROW_DOWN);//send key is coming from webelement interface of selenium
        searchInput.sendKeys(Keys.ARROW_DOWN);//Keys  is a enum of selenium
        searchInput.sendKeys(Keys.ARROW_DOWN);//select selenium foods
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getTitle().startsWith("selenium foods"));
        //evaluate the expression
    }
    @Test
    public void test2(){

    }
}
