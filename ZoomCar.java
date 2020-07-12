package daily_Practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ZoomCar {
	
	static ChromeDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().deleteAllCookies();  
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByLinkText("Start your wonderful journey").click();
		driver.findElementByXPath("(//div[@class='items'])[2]").click();
		driver.findElementByClassName("proceed").click();
		driver.findElementByXPath("(//div[@class='text'])[2]").click();
		driver.findElementByXPath("//span[text()='09:00']").click();
		driver.findElementByClassName("proceed").click();
		driver.findElementByClassName("show-more").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//li[@class='active low-price'])[1]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='18:00']").click();
		WebElement pickupTime= driver.findElementByXPath("(//div[@class='label time-label'])[1]");
		WebElement dropTime= driver.findElementByXPath("(//div[@class='label time-label'])[2]");
		WebElement ele= driver.findElementByXPath("//div[@class='breadcrumb']");
		
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("./snaps/zoomcar.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		 
		 if(pickupTime.getText().contains("09:00")&& dropTime.getText().contains("18:00")) {
			 
				//click done button
			  driver.findElementByTagName("button").click();
		 }
		 
		 Thread.sleep(2000);
		 
		 //sortprice low to high
		/* Actions action = new Actions(driver); */
		driver.findElementByXPath("(//div[@class='item'])[7]").click();
		/* action.moveToElement(sort).click().perform(); */
		 
		 List<WebElement> carDetails = driver.findElementsByXPath("//div[@class='details']//h3");
		 List<WebElement> carPrice = driver.findElementsByXPath("//div[@class='car-amount']//div");
		 
		 Map<String,String> map = new LinkedHashMap<String, String>();
		 for (int i = 0; i < carDetails.size()-1; i++) {
			
			 WebElement CarName = carDetails.get(i);
			 WebElement CarPrice = carPrice.get(i);
			 
			 map.put(CarName.getText(), CarPrice.getText().replaceAll("[^0-9.]", ""));
			 
		}
		 
		 Set<Entry<String, String>> entrySet = map.entrySet();
		 
		 for (Entry<String, String> entry : entrySet) {
			 
			 String name = entry.getKey();
			 String price = entry.getValue();
			 
			 System.out.println(name+"="+price);
			
		}
		 
		 //screenshot of highestPrice car
		 
		 WebElement highpriceCar= driver.findElementByXPath("(//div[@class='component-car-item'])[1]");
		 
		 
		 File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage  fullImg1 = ImageIO.read(screenshot);

			// Get the location of element on the page
			Point point1 = highpriceCar.getLocation();

			// Get width and height of the element
			int highpriceCarWidth = highpriceCar.getSize().getWidth();
			int highpriceCarHeight = highpriceCar.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage highpriceCarScreenshot= fullImg1.getSubimage(point1.getX(), point1.getY(),
					highpriceCarWidth, highpriceCarHeight);
			ImageIO.write(highpriceCarScreenshot, "png", screenshot1);

			// Copy the element screenshot to disk
			File screenshotLocation1 = new File("./snaps/zoomcar2.png");
			FileUtils.copyFile(screenshot1, screenshotLocation1);
		
		driver.findElementByXPath("(//div[@class='know-more-details'])[1]").click();
		String text = driver.findElementByXPath("(//div[@class='price-info'])[1]").getText();
		System.out.println("Price after free limit km "+text);
		
		

	}

}
