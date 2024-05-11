package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        String message = "I want to be the best and good QA Engineer!";
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd']//input[@type='text']")).sendKeys("Ayushi");
        driver.findElement(By.xpath("//textarea[@aria-label='Your answer']")).sendKeys(message);
        //add scroll into view
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,700)", "");
        driver.findElement(By.xpath("//div[@id='i16']//div[@class='AB7Lab Id5V1']")).click();
        //select Selenium check boc
        driver.findElement(By.id("i30")).click();
        driver.findElement(By.id("i33")).click();
        driver.findElement(By.id("i39")).click();
        //select ms from slidbar
        driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")).click();
        js.executeScript("window.scrollBy(50,0)");
        driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Ms']")).click();
       //select date current date -  7 days
       js.executeScript("window.scrollBy(100,0)");
        LocalDate date = LocalDate.now();  
        LocalDate newDate = date.minusDays(7); 
        System.out.println("Current date minus 7 days: "+ newDate);
        //***************************************************************** */
       String[] erDate = newDate.toString().split("-");
       String frDate =  erDate[1]+erDate[2]+erDate[0];
       driver.findElement(By.xpath("//input[@type='date']")).sendKeys(frDate);
      
        // select pm/am
        driver.findElement(By.xpath("//input[@aria-label='Hour']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@aria-label='Minute']")).sendKeys("00");

        driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
        System.out.println("end Test case: testCase02");
    }


}
