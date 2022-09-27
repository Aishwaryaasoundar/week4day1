package week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stockmarket {
	public static void main(String[] args) {
		
		/*Assignment1:
			============
			1. Launch the URL https://www.chittorgarh.com/
			2. Click on stock market
			3. Click on NSE bulk Deals
			4. Get all the Security names
			5. Ensure whether there are duplicate Security names*/
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.chittorgarh.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("navbtn_stockmarket")).click();
        //driver.findElement(By.linkText("NSE Bulk Deals")).click();
        //Select dropdown = new Select(driver.findElement(By.xpath("//a[@href='/newportal/stock-nse-bulk-deals.asp']")));  
        driver.findElement(By.xpath("//a[@href='/report/nse_sme_share_prices_live/9/']/following-sibling::a[1]")).click();
        //dropdown.selectByVisibleText("NSE Bulk Deals");
        List<WebElement> bulkdeals = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]//tr"));    
        //List<WebElement> bulkdeals = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table')]//tr"));	
        List<String> SecurityNameList =new ArrayList<String>();
        for (int i = 1; i < bulkdeals.size(); i++) {
        	String SecurityName = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]//tr["+i+"]/td[3]")).getText();
        	System.out.println(SecurityName);
        	SecurityNameList.add(SecurityName);
		}
        Set<String> SecurityNameSet  =new HashSet<String>(SecurityNameList);
        
        if(SecurityNameSet.size() == SecurityNameList.size())
        {
        	System.out.println("No Duplicate present");//No Duplicate	
        }
        else
        {
        	System.out.println(" Duplicate present");//Duplicate
        }
          

	}

}
