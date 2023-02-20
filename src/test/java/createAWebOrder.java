import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class createAWebOrder {




    @Test
    public void WebOrder() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
        Thread.sleep(1000);
        //System.out.println(driver.getCurrentUrl().);
        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
        Thread.sleep(1000);

        int random = (int)(1 + (Math.random()*101));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(String.valueOf(random));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).click();
        Thread.sleep(1000);
        Faker faker = new Faker();
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();

        String rNum1 = "123456789";
        String random2 = "";

        for (int i = 0; i < 5; i++){
            int index = (int)(Math.random() * rNum1.length());
            random2 += rNum1.charAt(index);
        }


        String zip = random2;
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(firstName + "\s" + lastName);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(address);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);

        Thread.sleep(1000);

        List<WebElement> list = driver.findElements(By.name("ctl00$MainContent$fmwOrder$cardList"));
        String value = list.get(new Random().nextInt(list.size())).getAttribute("value");

        String rNum = "0123456789";
        String random1 = "";

        for (int i = 0; i < 14; i++){
            int index = (int)(Math.random() * rNum.length());
            random1 += rNum.charAt(index);
        }




        if (value.equalsIgnoreCase("American Express")){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3" + random1 );
        }else if (value.equalsIgnoreCase("MasterCard")){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("51" + random1 );
        }else if (value.equalsIgnoreCase("Visa")) {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("41" + random1);
        }

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("03/23");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        Thread.sleep(1000);

       // System.out.println(driver.findElement(By.tagName("strong")));

       Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText(),"New order has been successfully added.");


       Thread.sleep(1000);

       driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();
       Thread.sleep(1000);


        String expectedNum[] = {"3"+ random1,"51" + random1, "41" + random1};
        List<String> expectedNumList = Arrays.asList(expectedNum);




        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]")).getText(),firstName +"\s"+ lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[3]")).getText(),"MyMoney");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[4]")).getText(),String.valueOf(random));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[6]")).getText(),address);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[7]")).getText(),city);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[8]")).getText(),state);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[9]")).getText(),zip);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[10]")).getText(),value);


        Assert.assertTrue(expectedNumList.contains(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[11]")).getText()));

        Thread.sleep(1000);



        driver.findElement(By.id("ctl00_logout")).click();

        driver.quit();





    }






}
