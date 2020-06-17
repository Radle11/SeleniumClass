package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxPractice {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.xpath("//input[@class='nav-input' and @value='Go']")).submit();
        WebElement apple=driver.findElement(By.xpath("//li[@id='p_89/Apple']//i"));
        apple.click();
        apple=driver.findElement(By.xpath("//li[@id='p_89/Apple']//input"));
        Assert.assertTrue(apple.isSelected());
//isSelected() can be used for check box and radiobutton
    }

}
