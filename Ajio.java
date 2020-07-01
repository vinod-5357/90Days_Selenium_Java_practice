package daily_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementByTagName("input").sendKeys("Bags");
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='higlighted-text'])[3]")));
		driver.findElementByXPath("(//span[@class='higlighted-text'])[3]").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("five-grid")));
		driver.findElementByClassName("five-grid").click();
		WebElement sortby= driver.findElementByTagName("select");
		Select sort= new Select(sortby);
		sort.selectByValue("newn");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='price']")));
		driver.findElementByXPath("//span[text()='price']").click();
		driver.findElementById("minPrice").sendKeys("2500");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='TOMMY HILFIGER Blue Slings & Satchels Sling Bag with Chain Strap']")));
		driver.findElementByXPath("//img[@alt='TOMMY HILFIGER Blue Slings & Satchels Sling Bag with Chain Strap']").click();
		//SWITCH WINDOW

		String currentWindow = driver.getWindowHandle(); 
		Set<String> defaultAndSelected= driver.getWindowHandles(); 

		List<String> listHandles= new ArrayList<String>(defaultAndSelected); String
		Window2 = listHandles.get(1); 
		driver.switchTo().window(Window2);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("prod-sp")));
		String defaultFare = driver.findElementByClassName("prod-sp").getText();
		String fare1= defaultFare.replaceAll("[-+.^:,]", "");
		String fare2 = fare1.replaceAll("[a-zA-Z]", "");
		String fare3= fare2.replaceAll("\\s", "");
		int Dfare = Integer.parseInt(fare3);

		if(Dfare>2890) {

			System.out.println("Coupon code is applicable");
			/*
			 * String promocode = driver.findElementByClassName("promo-title").getText();
			 * System.out.println("Promocode : "+promocode);
			 */
			String discountPrice= driver.findElementByXPath("//div[@class='promo-discounted-price']//span[1]").getText();
			System.out.println("Discounted fare :"+discountPrice);

		}

		else 

		{
			System.out.println("coupon code not applicable");
		}

		String discountPrice= driver.findElementByXPath("//div[@class='promo-discounted-price']//span[1]").getText();
		driver.findElementByClassName("pdp-toggle").click();
		String promocode = driver.findElementByXPath("(//div[@class='promo-title'])[1]").getText();
		String promo1= promocode.replaceAll("[a-z]", "");
		String promo2= promo1.replaceAll("\\s", "");
		String promo3= promo2.replaceAll("[U,C]", "");
		System.out.println(promo3);
		driver.findElementByXPath("//span[contains(@class,'edd-pincode-msg-details edd-pincode-msg-details-pointer')]").click();
		driver.findElementByName("pincode").sendKeys("580023");
		driver.findElementByClassName("edd-pincode-modal-submit-btn").click();
		//verify availability with pincode
		String availability= driver.findElementByXPath("//ul[@class='edd-message-success-details']//li[1]").getText();
		System.out.println(availability);
		if(availability.contains("Expected Delivery")) {

			System.out.println("Order available for this location");


		}else {

			System.out.println("Order not delivered for this location");
		}

		driver.findElementByClassName("ic-angle-down").click();
		String customerCare= driver.findElementByXPath("//div[@id='appContainer']/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/h2[1]/ul[1]/li[11]/span[3]").getText();
		System.out.println("Customer care address :"+customerCare);
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ic-cart")));
		WebElement cart= driver.findElementByClassName("ic-cart");
		Actions action= new Actions(driver);
		action.moveToElement(cart).perform();
		driver.findElementByClassName("mini-cart-btn").click();
		String fareBeforeDiscount= driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
		System.out.println("Fare before discount :"+fareBeforeDiscount);
		driver.findElementById("couponCodeInput").sendKeys(promo3);
		driver.findElementByXPath("(//button[contains(@class,'rilrtl-button button')])[2]").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='net-price best-price-strip']")));
		String discountedfare = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
		System.out.println("Discounted fare :"+discountedfare);

		if(discountedfare.contains(discountPrice)) {

			System.out.println("Discount price matches product price");
		}

		else
		{
			System.out.println("Discount price and product price unmatched");
		}

		driver.findElementByXPath("//span[@class='ic-delete navigation-icon']").click();

		System.out.println("completed");
	}

}
