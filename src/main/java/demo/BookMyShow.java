package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
    ChromeDriver driver;
    public BookMyShow(){
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

    public void hyperLink(){
    // Navigaten to url  https://in.bookmyshow.com/explore/home/chennai
    driver.get("https://in.bookmyshow.com/explore/home/chennai");
    // find the list of hyperlinks Using Locator "Tag Name" a
    List<WebElement> list = driver.findElements(By.tagName("a"));
    // count of  the hyperlinks Using Locator "Tag Name" size()
    //size()
    System.out.println("Count of the hyperlink is :" +list.size());
    
    }

    public void recommendedMovies(){
        // Navigate to Url  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Recommended Movies image URLs Using Locator "XPath" //*[@id="super-container"]/div[2]/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[1]//a | 
    
        List<WebElement> list = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div//div[contains(@class,'YeNog')]/div"));
        // Print Recommended Movies Image URLs  system.out.print(listofImagesUrl)
        for (WebElement movie : list) {
            String imageUrl = movie.findElement(By.xpath("//a//img")).getAttribute("src");
            System.out.println(imageUrl);
        }
        //System.out.print(list);
        // "Get Name  of the 2nd item

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        List<WebElement> premieres = driver.findElements(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div//div[contains(@class,'dDgeSF')]/div"));
        System.out.println("It has come to premieres");


        if (premieres.size() > 1) {
            WebElement secondPremiereMovie = premieres.get(1);
            String movieName = secondPremiereMovie.findElement(By.xpath("//h2[text()='Premieres']/../../../../div[2]/div/div/div[2]/child::a/div/div[3]/div[1]/div")).getText();
            String movieLanguage = secondPremiereMovie.findElement(By.xpath("//h2[text()='Premieres']/../../../../div[2]/div/div/div[2]/child::a/div/div[3]/div[2]/div")).getText();
            System.out.println("Movie Name: " + movieName);
            System.out.println("Movie Language: " + movieLanguage);
        } else {
            System.out.println("No second premiere movie found.");
        }
         

        // List<WebElement> secondPremiereMovie = driver.findElements(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div//div[contains(@class,'dDgeSF')]/div"));
        // for(WebElement premieres :secondPremiereMovie)
        // String name = premieres.findElement(By.xpath("//div[@class=\"sc-7o7nez-0 iHsoLV\" and text()=\"Somewhere in Queens\"]")).getText();
        // System.out.println(name);
        // WebElement language = secondPremiereMovie.findElement(By.xpath("//*[@id=\"https://in.bookmyshow.com/chennai/movies/somewhere-in-queens/ET00366830-1\"]/div/div[3]/div[2]/div"));
        // System.out.println(language.getText());


        //System.out.print(premieres);
        // in the “Premiere” list Using Locator ""ID"" system.out.print(listofImagesUrl.size())"
        // "Get Language of the 2nd item
        // in the “Premiere” list  //*[@id=""https://in.bookmyshow.com/chennai/movies/spiderman-across-the-spiderverse/ET00347275-1""]/div/div[3]/div[2]/div"
        // "Print Name & Language of the 2nd item in the “Premiere” list  System.out.print(secondItem.text())"
        
        }
    
}
