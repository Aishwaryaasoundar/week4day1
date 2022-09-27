package week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	public static void main(String[] args) {
		
	

	/*1. Launch the URL https://html.com/tags/table/
		2. Get the count of number of rows
		3. Get the count of number of columns*/
	WebDriverManager.chromedriver().setup();;
    ChromeDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://html.com/tags/table/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    List<WebElement> rowsList=driver.findElements(By.xpath("//div[@class='render']//tr"));
    for (int i = 1; i < rowsList.size(); i++) {
    	System.out.println(rowsList.get(i).getText());
    	}
    }
}
