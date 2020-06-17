package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionIntro {
    @Test
    public void rightClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);//Acctions constructor requires the driver
        actions.contextClick(box).perform();//will perform right click action in mouse
        //in Actions class we need to use the perform() method in order to see mouse action

    }
    @Test
    public void rightClick1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        //using Action interface
        Action action=actions.contextClick(box).build();//return type is Action
        action.perform();
    }
    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> avatarText=driver.findElements(By.xpath("//h5"));
        List<WebElement> avatars=driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        Actions actions=new Actions(driver);
        int i=0;
        for(WebElement avatar:avatars){
        Action action=actions.moveToElement(avatar).build();
        action.perform();
        System.out.println(avatarText.get(i).getText());
        Thread.sleep(1000);
        i++;
        }

    }
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        List<WebElement> clickOptions=driver.findElements(By.xpath("//div[contains(text(),'click')]"));
        Actions actions=new Actions(driver);
        for (WebElement clickOption:clickOptions){
            switch (clickOption.getText()){
                case "click":
                    actions.click(clickOption).perform();
            break;
                case "doubleclick":
                actions.doubleClick(clickOption).perform();
                break;
            }
        }
    }

}
