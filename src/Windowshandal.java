import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windowshandal {

	public static void main(String[] args)throws InterruptedException, IOException {
		
        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Switching windows
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handel= driver.getWindowHandles();
	     
	    Iterator<String> W= handel.iterator();
	    
	    String parentID=  W.next();
	    String ChildeId=  W.next();
	    driver.switchTo().window(ChildeId);
	    
	    driver.get("https://rahulshettyacademy.com/");
	    Thread.sleep(3000);
	    String New=  driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
	    driver.switchTo().window(parentID);
	    
	    WebElement name= driver.findElement(By.cssSelector("[name*='name']"));
	    name.sendKeys(New);
	    //ScreenShort
	    
	    File F= name.getScreenshotAs(OutputType.FILE);	      
	    FileUtils.copyFile(F, new File("new1.png"));
	    
	    //GEt Height & Width
	    
	   System.out.println(name.getRect().getDimension().getHeight());
	   System.out.println(name.getRect().getWidth());
	    
	   // driver.quit();

	}

}
