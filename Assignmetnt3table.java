package week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignmetnt3table {
	
	/*1. Launch the URL https://html.com/tags/table/
		2. You have to print the respective values based on given Library
		(hint: if the library was absolute usage, then print all its value)
		Assignment4:
		============
		http://testleaf.herokuapp.com/pages/table.html*/
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();;
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://html.com/tags/table/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    List<WebElement> rowsList=driver.findElements(By.xpath("//div[@class='render']//tr"));
	    for (int i = 1; i < rowsList.size(); i++) {
	    	String rowitem =driver.findElement(By.xpath("//div[@class='render']//tr["+i+"]/td[1]")).getText();	    	
	    	System.out.println(rowitem);
	    	
	    	}
	}

}
