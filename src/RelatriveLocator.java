import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelatriveLocator {

	public static void main(String[] args) throws InterruptedException {
		
        ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement editbox = driver.findElement(By.cssSelector("[name='name']"));
		
	    System.out.println(	driver.findElement(with(By.tagName("label")).above(editbox)).getText());
	    
	    WebElement BOD=  driver.findElement(By.cssSelector("[for='dateofBirth']"));
	    
	    driver.findElement(with(By.tagName("input")).below(BOD)).click();
		
	    WebElement LEft=  driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
	    
	    driver.findElement(with(By.tagName("input")).toLeftOf(LEft)).click();
	    
	    WebElement Right= driver.findElement(By.id("inlineRadio1"));
	    
	    System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(Right)).getText());

	}

}
