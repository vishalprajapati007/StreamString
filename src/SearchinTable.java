import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SearchinTable {

	public static void main(String[] args) throws InterruptedException {
	
        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
	     List<WebElement> name= driver.findElements(By.xpath("//tr/td[1]"));
	    
	     List<WebElement> list=  name.stream().filter(xyz->xyz.getText().contains("Rice")).collect(Collectors.toList());
	     
	     Assert.assertEquals(name.size(), list.size());
	    

	}

}
