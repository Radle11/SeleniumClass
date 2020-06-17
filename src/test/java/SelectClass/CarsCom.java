package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class CarsCom {
    @Test
    public void newUsedSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        WebElement newUsed=driver.findElement(By.xpath("//select[@aria-label='Select a stock type']"));
        Select select=new Select(newUsed);
        select.selectByVisibleText("Certified Cars");
        Thread.sleep(1500);
        select.selectByIndex(2);
        Thread.sleep(1500);
        select.selectByValue("0");
        Iterator<WebElement> options=select.getOptions().iterator();
        while(options.hasNext()){
            System.out.println(options.next().getText());
        }
        select.selectByIndex(2);
        driver.findElement(By.className("NZE2g")).submit();
        Thread.sleep(1500);
        WebElement header=driver.findElement(By.xpath("//h1[@class='srp-header']"));
        String actualHeader=header.getText();
        String expectedHeader="Used Vehicles for Sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.cars.com/for-sale/searchresults.action/?rd=20&searchSource=QUICK_FORM&stkTypId=28881&zc=60056";
        Assert.assertEquals(actualURL,expectedURL);
        List <WebElement> radioButtons=driver.findElements(By.xpath("//form//li[@id='stkTypId']/ul/li//input[@type='radio']"));
        boolean isSelected=false;
        for(WebElement radioButton:radioButtons){
                if((radioButton.isSelected()==true)&&radioButton.getAttribute("value").equals("28881")){
                   isSelected=true;
                }
        }
        Assert.assertTrue(isSelected==true);
    }

}
