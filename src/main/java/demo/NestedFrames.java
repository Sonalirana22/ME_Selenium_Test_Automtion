package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
    ChromeDriver driver;
    public NestedFrames(){
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

    public void nestedFrames(){
    // Navigate to URL  https://the-internet.herokuapp.com/nested_frames
    driver.get("https://the-internet.herokuapp.com/nested_frames");
    // move to the top frame by its frame name  driver.switchTo().frame("frame-top")
    driver.switchTo().frame("frame-top");
    // move to the inner frame by its frame name  driver.switchTo().frame("frame-left")
    driver.switchTo().frame("frame-left");
    // "Now locate to the element present in the inner frame and  get the text  and print it Using Locator ""XPath"" driver.switchTo().frame(""frame-left"")"
    WebElement left = driver.findElement(By.xpath("//body"));
    String leftTxt= left.getText();
    System.out.println(leftTxt);
    // NOw move back to the top frame  driver.switchTo().parentFrame()
    driver.switchTo().parentFrame();
    // "Now again move to the inner middle frame by its frame name  driver.switchTo().frame(""frame-middle"")"
    driver.switchTo().frame("frame-middle");
    // "Now locate to the element present in the inner middle frame and get the text and print it Using Locator ""XPath"" System.out.println(//body | getText())"
    WebElement middle = driver.findElement(By.xpath("//body"));
    String middleTxt = middle.getText();
    System.out.println(middleTxt);
    // NOw move back to the top frame  driver.switchTo().parentFrame()
    driver.switchTo().parentFrame();
    // "Now again move to the inner right frame by its frame name  driver.switchTo().frame(""frame-right"")"
    driver.switchTo().frame("frame-right");
    // "Now locate to the element present in the inner right frame and get the text and print it Using Locator ""XPath"" System.out.println(//body | getText())"
    WebElement right = driver.findElement(By.xpath("//body"));
    String rightTxt = right.getText();
    System.out.println(rightTxt);
    // NOw move back to the top frame  driver.switchTo().defaultContent()
    driver.switchTo().defaultContent();
    // Now move to the bottom frame by its frame name  driver.switchTo().frame("frame-bottom")
    driver.switchTo().frame("frame-bottom");
    // "Now locate to the element present in the bottom frame and get the text and print it Using Locator ""XPath"" System.out.println(//body | getText())"
    WebElement bottom = driver.findElement(By.xpath("//body"));
    String bottomTxt = bottom.getText();
    System.out.println(bottomTxt);
    // Now move back to the default frame  driver.switchTo().defaultContent()
    driver.switchTo().defaultContent();

    }
    
}
