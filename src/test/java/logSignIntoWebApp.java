import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class logSignIntoWebApp {


    @Test
 public void SignLogToWerApp() throws InterruptedException {

        Faker faker = new Faker();
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = firstName.substring(0,1) + lastName + "@gmail.com";
        String password = faker.internet().password();

        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals(driver.getTitle(),"Welcome to Duotify!");

        driver.findElement(By.id("hideLogin")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys(firstName + lastName);
           Thread.sleep(1000);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
           Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
           Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(email);
           Thread.sleep(1000);
        driver.findElement(By.id("email2")).sendKeys(email);
           Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
           Thread.sleep(1000);
        driver.findElement(By.id("password2")).sendKeys(password);
           Thread.sleep(1000);
        driver.findElement(By.name("registerButton")).click();
           Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");
           Thread.sleep(1000);


        Assert.assertEquals(driver.findElement(By.id("nameFirstAndLast")).getText(),firstName +"\s"+ lastName);
        driver.findElement(By.id("nameFirstAndLast")).click();
           Thread.sleep(1000);
        WebElement h1Element = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/div[1]/div/h1"));
        Thread.sleep(1000);
        String h1Text = h1Element.getText();
        Thread.sleep(1000);
        Assert.assertEquals(h1Text,firstName +"\s"+ lastName);
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.cssSelector(".buttonItems #rafael "));
        Thread.sleep(1000);
        element.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Thread.sleep(1000);

        driver.findElement(By.id("loginUsername")).sendKeys(firstName + lastName);
        Thread.sleep(1000);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.name("loginButton")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.className("pageHeadingBig")).getText(),"You Might Also Like");
        Thread.sleep(1000);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.cssSelector(".buttonItems #rafael "));
        Thread.sleep(1000);
        element1.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        //driver.findElement(By.cssSelector("#mainContent. entityInfo. buttonItems. button")).click();


//        // Find the h1 element with ID "mainContent" and multiple classes
//        WebElement h1Element = driver.findElement(By.cssSelector("#buttonItems.entityInfo.centerSection.userInfo"));
//
//// Get the text of the h1 element
//        String h1Text = h1Element.getText();
//
//// Print the text of the h1 element
//        System.out.println(h1Text);














    }



}
