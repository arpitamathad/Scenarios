package pack1;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//1.how to take screenshot of a particular element

public class Scenario1 {

	@Test
	public void test1() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		WebElement ele = driver.findElement(By.id("hplogo"));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshotAs);
		Point location = ele.getLocation();
		int width = ele.getSize().getWidth();
		int height = ele.getSize().getHeight();
		BufferedImage eleScreenShot = fullImg.getSubimage(location.getX(), location.getY(), width, height);
		ImageIO.write(eleScreenShot, "png", screenshotAs);
		File screenshotLocation = new File("./photos/GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshotAs, screenshotLocation);
		driver.close();
		
	}
}
