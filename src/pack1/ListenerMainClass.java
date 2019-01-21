package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerMainClass {

	@Test
	public void  test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		EventCapture eCapture  = new EventCapture();
		//Registering with EventFiringWebDriver
        //Register method allows to register our implementation of WebDriverEventListner to listen to the WebDriver events
		eventHandler.register(eCapture); 
		//navigating to the webpage "www.softwaretestingmaterial.com"
		eventHandler.navigate().to("https://google.com"); 
//		eventHandler.findElement(By.id("email")).sendKeys("asdsadsa");
		//navigating to the webpage "www.softwaretestingmaterial.com/category/selenium/"
//		eventHandler.navigate().to("https://www.softwaretestingmaterial.com/agile-testing-interview-questions/"); 
		//navigating back to the first page
//		eventHandler.navigate().back();
//		eventHandler.quit();
        //Unregister allows to detach
//		eventHandler.unregister(eCapture);
//		System.out.println("End of Listners Class");
	}
}
