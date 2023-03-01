import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class findSdetInDice {



    @Test
    public void findSdet() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dice.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET", Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='card-title-link bold']"));
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='card-title-link bold']")).getText(),"SDET");

//        for (WebElement each: elements){
//            System.out.println(each.);
//        }



    }


}
