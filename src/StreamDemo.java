import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
	     // click on column
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capture all webelements into list
		
        List<WebElement> firstlist=	driver.findElements(By.xpath("//tr/td[1]"));
        
        // capture all text in original list
        
           List<String> originalllist=  firstlist.stream().map(s->s.getText()).collect(Collectors.toList());
        
        // sort the original list
        
          List<String> sortedlist = originalllist.stream().sorted().collect(Collectors.toList());
        
          // compare original to sorted list
          
          Assert.assertTrue(originalllist.equals(sortedlist));
          
          //scan the name of price in second list and get text "Beans" and print price
         List<String> price;
         do
         {
         List<WebElement> first= driver.findElements(By.xpath("//tr/td[1]"));
         price = first.stream().filter(s->s.getText().contains("Rice")).map(s->getprice(s)).collect(Collectors.toList());
         price.forEach(v->System.out.println(v));  
         
         if(price.size()<1)
         {
        	 driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
         }
         }while(price.size()<1);
	
	}

	private static String getprice(WebElement s) {
	    String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
