package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.util.concurrent.TimeUnit;
import java.util.List;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
    ChromeDriver driver;
    public WindowHandles(){
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

    public void windowHandles() throws IOException{
        // Navigate to URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

         //Switch to the iframe containing the "Try it" button
        driver.switchTo().frame("iframeResult");

        // Click on "Try it" button Using Locator "XPath" //button[text()="Try it"] | click()

        WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();

        String originalWindow = driver.getWindowHandle();

        // Get the handles of all open windows Set<String> windowHandles = driver.getWindowHandles()
          Set<String> windowHandles = driver.getWindowHandles();
        // Now switch to the new window   String handle = driver.getWindownHandles()
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        // Get the URL of the new window  driver.getCurrentUrl()
        String currentUrl = driver.getCurrentUrl();
           
        // Get the title  driver.getTitle()
         String title = driver.getTitle();
        // take screenshot of the page  takeScreenshot()

        // String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

        // AShot ashot = new AShot();

        // Screenshot screenshot = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
          
        //   ImageIO.write(screenshot.getImage(), "PNG", new File("D:\\Crio\\selenium_starter-master\\src\\Screenshots\\Screenshot_"+ timestamp + ".png"));

        //   System.out.println("Full page screenshot cature and saved at: Screenshot_"+ timestamp + ".png");

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        AShot ashot = new AShot();
        Screenshot screenshot = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String filename = "Screenshot " + timeStamp + ".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File("D:\\Crio\\selenium_starter-master\\src\\Screenshots\\Screenshot_"+ timeStamp + ".png"));
            System.out.println("Full page screenshot capture and saved at: " + filename);


        // Now close the new window  driver.close()
        driver.close();
        // "Switch back to the original window by using the window handle  driver.switchTo().window()"
        driver.switchTo().window(originalWindow);
    }
    
}

