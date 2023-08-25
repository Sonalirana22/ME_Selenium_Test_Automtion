package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {
    ChromeDriver driver;
    public AmazonSearch(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void searchAmazon(){
        // Navigate to Url  https://www.google.com/
        driver.get("https://www.google.com/");
        // Enter "amazone" to the search box Using Locator "ID" APjFqb | sendKeys("amazone")
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("amazon");
        // press Enter using keyborad Using Locator "ID" APjFqb | sendKeys(keys.RETURN)
        // APjFqb | sendKeys(keys.RETURN)
        search.sendKeys(Keys.RETURN);
        // validate that amazon.in or amazon.com present in the page Using Locator "XPath" //span[text()='Amazon.in' or text()='Amazon.com']
        boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']")).isDisplayed();
        System.out.println("Amazon is displayed in the result :"  +  result);
    }

    
}
