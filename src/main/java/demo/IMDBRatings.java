package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRatings {
    ChromeDriver driver;
    public IMDBRatings(){
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

    public void ratings() throws InterruptedException{
        // Navigate to URL    https://www.imdb.com/chart/top

        driver.get("https://www.imdb.com/chart/top");
        // Get the title of highest rated movie  Using Locator "XPath" //td[@class='titleColumn']/a | getText()
        String topMovieTitle = driver.findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
        System.out.println("The highest rated movie on IMDb is: " + topMovieTitle);
        // String topMovieRating = driver.findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/span/div/span/text()")).getText();
        // System.out.println("Rating: " + topMovieRating);
        // Find all movie rows in the table and get the size Using Locator "XPath" //tbody[@class='lister-list']//tr | size()
        List <WebElement> list =driver.findElements(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li"));
        int totalMovie = list.size();
        System.out.println("Total Movie count is:" + totalMovie);
        // "Find the element containing the title of the oldest movie

        WebElement dropDownElement = driver.findElement(By.xpath("//*[@id=\"sort-by-selector\"]"));  
        Select dropdown = new Select(dropDownElement); 
        dropdown.selectByVisibleText("Release date"); 
        WebElement sortBy =driver.findElement(By.xpath("//*[@id='swap-sort-order-button']"));
        sortBy.click();
        Thread.sleep(4000);
        String oldestMovie = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
        System.out.println("The Oldest Movie name is :" + oldestMovie);
        // and get the text Using Locator ""XPath"" //tbody[@class='lister-list']//tr | size()"
        // "Find the element containing the title of the most recent 
        sortBy.click();
        Thread.sleep(4000);
        String recentMovie = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
        System.out.println("The Recent MOvie name is :" + recentMovie);

        // movie and get the text Using Locator ""XPath"" //td[@class='titleColumn']/a | getText()"
        // Get the movie has most user ratings and get the count Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li/div[1]/div/div/div[2]/div[2]/text() | getText()
        //WebElement dropDownElement1 = driver.findElement(By.xpath("//*[@id=\"sort-by-selector\"]")); 
        Select dropdown1 = new Select(dropDownElement); 
        dropdown1.selectByVisibleText("Number of ratings"); 
        String mostUserRating = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
        System.out.println("The Most User Rating Movie is : " + mostUserRating);


    }
    
}
