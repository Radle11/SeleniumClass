package SwitchingWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeWork5 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    /*
    Navigate to "https://demos.telerik.com/kendoui/dragdrop/area"
    Click and hold the blue circle
    Move the circle left side of it
    Validate blue and orange box are displayed (Drop here) text
     */
    @Test
    public void test1(){
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(source).moveByOffset(-40,0).perform();
        WebElement blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualBlueTargetText=blueTarget.getText();
        String actualOrangeTargetText=orangeTarget.getText();
        String expectedHoldText="(Drop here)";
        Assert.assertTrue(actualBlueTargetText.equals(expectedHoldText)&&
                actualOrangeTargetText.equals(expectedHoldText),"Test1.Blue and orange target box text test is failed.");
    }
    /*
    Navigate to "https://demos.telerik.com/kendoui/dragdrop/area"
    Click and hold the blue circle
    Move the circle on top of Blue box
    Validate "Now you can drop it." text is displayed
    Validate Orange box has (Drop here) text
     */
    @Test
    public void test2(){
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(source).moveToElement(blueTarget).perform();
        blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueTargetText=blueTarget.getText();
        String expectedBlueTargetText="Now you can drop it.";
        WebElement orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeTargetText=orangeTarget.getText();
        String expectedOrangeTargetText="(Drop here)";
        //System.out.println("Blue"actualBlueTargetText+" "+actualOrangeTargetText);
        Assert.assertTrue((actualBlueTargetText.equals(expectedBlueTargetText))&&
                        (actualOrangeTargetText.equals(expectedOrangeTargetText)),
                "Test2.Blue and orange target box text test is failed. \nActual Blue Target Text: "
                        +actualBlueTargetText+ "\nExpected Blue Target Text: "+ expectedBlueTargetText+
                        "\nActual Orange Target Text: "+actualOrangeTargetText+"\nExpected Orange Target Text: "+expectedOrangeTargetText+"\n");
    }
    /*
    Navigate to "https://demos.telerik.com/kendoui/dragdrop/area"
    Click and hold the blue circle
    Move the circle on top of Orange box
    Validate "Now you can drop it." text is displayed in orange box
    Validate Blue box has (Drop here) text
     */
    @Test
    public void test3(){
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(source).moveToElement(orangeTarget).perform();
        orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeTargetText=orangeTarget.getText();
        String expectedOrangeTargetText="Now you can drop it.";
        WebElement blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueTargetText=blueTarget.getText();
        String expectedBlueTargetText="(Drop here)";
        Assert.assertTrue((actualBlueTargetText.equals(expectedBlueTargetText))&&
                        (actualOrangeTargetText.equals(expectedOrangeTargetText)),
                "Test3.Blue and orange target box text test is failed. \nActual Blue Target Text: "
                        +actualBlueTargetText+ "\nExpected Blue Target Text: "+ expectedBlueTargetText+
                        "\nActual Orange Target Text: "+actualOrangeTargetText+"\nExpected Orange Target Text: "+expectedOrangeTargetText+"\n");
    }
    /*
    Navigate to "http://demo.guru99.com/test/drag_drop.html"
    Click and hold the first -5000
    Validate "Please select another block" is displayed
    Drag and drop first 5000 to Debit side Amount
    Validate "Debit Movement 5000 Credit Movement 0"
    Drag and drop Second 5000 to Credit side Amount
    Validate "Debit Movement 5000 Credit Movement 5000"
    Drag and drop the "BANK" Debit side Account
    Validate BANK is displayed
    Drag and drop the "SALES" Credit side Account
    Validate SALES is displayed
     */
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement block1=driver.findElement(By.xpath("//li[@id='credit']//a"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(block1).moveByOffset(-30,-30).perform();
        WebElement popUpMessage=driver.findElement(By.xpath("//div[@class='e14']"));
       String actualPopUpMessageText=popUpMessage.getText();
        System.out.println(actualPopUpMessageText);
       String expectedPopUpMessageText="Please select another block";
       Assert.assertEquals(actualPopUpMessageText,expectedPopUpMessageText,"Pop up message test is failed");
       actions.release().perform();
       //#1
       WebElement block2=driver.findElement(By.xpath("(//ul//li[@id='fourth']//a)[1]"));
       WebElement debitAmount=driver.findElement(By.xpath("//ol[@id='amt7']"));
       new Actions(driver).dragAndDrop(block2,debitAmount).perform();
       WebElement debitMovement=driver.findElement(By.xpath("//td//div[@id='t7']"));
       String actualDebitMovement=debitMovement.getText();
       String expectedDebitMovement="5000";
       WebElement creditMovement=driver.findElement(By.xpath("//td//div[@id='t8']"));
       String actualCreditMovement=creditMovement.getText();
       String expectedCreditMovement="0";
       Assert.assertEquals(actualDebitMovement,expectedDebitMovement,"test4 #1. Debit movement test is failed.");
       Assert.assertEquals(actualCreditMovement,expectedCreditMovement,"test4 #1. Credit movement test is failed.");
       //#2
       WebElement block4=driver.findElement(By.xpath("(//ul//li[@id='fourth']//a)[2]"));
       WebElement creditAmount=driver.findElement(By.xpath("//ol[@id='amt8']"));
       new Actions(driver).dragAndDrop(block4,creditAmount).perform();
        Assert.assertEquals(actualDebitMovement,expectedDebitMovement,"test4 #2. Debit movement test is failed.");
        creditMovement=driver.findElement(By.xpath("//td//div[@id='t8']"));
        actualCreditMovement=creditMovement.getText();
       expectedCreditMovement="5000";
        Assert.assertEquals(actualCreditMovement,expectedCreditMovement,"test4 #2. Credit movement test is failed.");
        //#3
        WebElement block5Bank=driver.findElement(By.xpath("//ul//li[@id='credit2']//a"));
        WebElement debitAccount=driver.findElement(By.xpath("//ol[@id='bank']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,800)");
        new Actions(driver).dragAndDrop(block5Bank,debitAccount).perform();
        WebElement debitAccountText=driver.findElement(By.xpath("//ol[@id='bank']//li"));
        String actualDebitAccountText=debitAccountText.getText();
        String expectedDebitAccountText="BANK";
        Assert.assertEquals(actualDebitAccountText,expectedDebitAccountText,"test4 #3. Test is failed");
        //#4
        WebElement block6Sales=driver.findElement(By.xpath("//ul//li[@id='credit1']//a"));
        WebElement creditAccount=driver.findElement(By.xpath("//ol[@id='loan']"));
        new Actions(driver).dragAndDrop(block6Sales,creditAccount).perform();
        WebElement creditAccountText=driver.findElement(By.xpath("//ol[@id='loan']//li"));
        String actualCreditAccountText=creditAccountText.getText();
        String expectedCreditAccountText="SALES";
        Assert.assertEquals(actualCreditAccountText,expectedCreditAccountText,"test4 #4. Test is failed");
    }
    /*
    Navigate to "http://www.popuptest.com/popuptest4.html"
    Hover over to "Mouseover PopUp"
    Validate the size of opened window is equals to 3
    Validate new window titles are matching with today's date
    Validate new window url contains "popup9"
    Validate other new window url contains "popup10"
     */
    @Test
    public void test5(){
        driver.get("http://www.popuptest.com/popuptest4.html");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement mouseOverPopUp=driver.findElement(By.xpath("//a[@href='#']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(mouseOverPopUp).perform();
        String parentID=driver.getWindowHandle();
        Set<String> popUpIDs=driver.getWindowHandles();
        int actualOpenWindowAmount=popUpIDs.size();
        int expectedOpenWindowAmount=3;
        Assert.assertTrue(actualOpenWindowAmount==expectedOpenWindowAmount,"test5 #1.Test is failed.");
        //#2
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM, dd yyyy");
        LocalDate localDate = LocalDate.now();
        String currentDate=dtf.format(localDate);
        int count=0,contains=0;
        for (String popUpID:popUpIDs) {
            if (!popUpID.equals(parentID)){
                driver.switchTo().window(popUpID);
                if (driver.getTitle().contains(currentDate)){
                    count++;
                }
                if((driver.getCurrentUrl().contains("popup9"))||(driver.getCurrentUrl().contains("popup10"))){
                    contains++;
                }
            }
        }
        Assert.assertTrue(count==2,"test5 #2.Test is failed.");
        Assert.assertTrue(contains==2,"test5 #3 and #4. Test is failed. Doesnt contain 'popup9' or 'popup10'.");
    }
    /*
    Navigate to "http://seleniumpractise.blogspot.com/2017/"
    Click the text "Click here for Facebook" Test Link
    Enter First name "Techtorial"
    Enter Last name "Academy"
    Enter phone number "2223334455"
    Enter the password "techtorial123"
    Select "April" + "20" + "2002"
    Select Gender Custom
    NOTE:DO not click the Sign Up Button
    Close the facebook page
    Validate the title equals to "Selenium Practise: 2017"
     */
    @Test
    public void test6(){
    driver.get("http://seleniumpractise.blogspot.com/2017/");
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    String parentID=driver.getWindowHandle();
    WebElement facebookLink=driver.findElement(By.xpath("//a[@href='https://www.facebook.com']"));
    facebookLink.click();
    String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
    WebElement firstName=driver.findElement(By.xpath("//div//input[@name='firstname']"));
    firstName.sendKeys("Techtorial");
    WebElement lastName=driver.findElement(By.xpath("//div//input[@name='lastname']"));
    lastName.sendKeys("Academy");
    WebElement phoneNumber=driver.findElement(By.xpath("//div//input[@name='reg_email__']"));
    phoneNumber.sendKeys("2223334455");
    WebElement password=driver.findElement(By.xpath("//div//input[@name='reg_passwd__']"));
    password.sendKeys("techtorial123");
    WebElement birthMonth=driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select=new Select(birthMonth);
        select.selectByVisibleText("Apr");
    WebElement birthDay=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        new Select(birthDay).selectByValue("20");
    WebElement birthYear=driver.findElement(By.xpath("//select[@name='birthday_year']"));
        new Select(birthYear).selectByVisibleText("2002");
    driver.close();
    driver.switchTo().window(parentID);
    String actualTitle=driver.getTitle();
    String expectedTitle="Selenium Practise: 2017";
    Assert.assertEquals(actualTitle,expectedTitle);
    }
@AfterClass
    public void quitAll(){
        driver.quit();
}
}
