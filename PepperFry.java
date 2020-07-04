package daily_Practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PepperFry {
	
	static ChromeDriver driver;
	
	public void getScreenshot() throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/pepperOrderSummary.png");
		FileUtils.copyFile(source, target);
	}

	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions action= new Actions(driver);
		WebElement popup= driver.findElementByXPath("(//a[@class='popup-close'])[6]");
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(popup));
		action.moveToElement(popup).click().perform();
		
		//offerinframe
		WebElement OffInFrame= driver.findElementById("webklipper-publisher-widget-container-notification-frame");
		driver.switchTo().frame(OffInFrame);
		WebElement offerInFrame= driver.findElementByXPath("//span[@class='wewidgeticon we_close icon-large']");
		wait.until(ExpectedConditions.elementToBeClickable(offerInFrame)).click();
		driver.switchTo().defaultContent();
		
		
		//office chair
		WebElement furnture= driver.findElementByLinkText("Furniture");
		action.moveToElement(furnture).perform();
		driver.findElementByXPath("//div[@id='meta-furniture']/div[1]/div[3]/div[2]/div[12]/a[1]").click();
		driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").clear();
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys("50",Keys.ENTER);
		WebElement OffInFrame1= driver.findElementById("webklipper-publisher-widget-container-notification-frame");
		wait.until(ExpectedConditions.visibilityOfAllElements(OffInFrame1));
		driver.switchTo().frame(OffInFrame1);
		WebElement offerInFrameinC= driver.findElementByXPath("//span[@class='wewidgeticon we_close icon-large']");
		wait.until(ExpectedConditions.elementToBeClickable(offerInFrameinC)).click();
		driver.switchTo().defaultContent();
		WebElement poiseChair= driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour']");
		wait.until(ExpectedConditions.elementToBeClickable(poiseChair)).click();
		
		
		//office table
		
		WebElement furnitures= driver.findElementByLinkText("Furniture");
		action.moveToElement(furnitures).perform();
		driver.findElementByLinkText("Office Tables").click();
		driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
		driver.findElementByXPath("//label[@for='price20000-40000']").click();
		try {
			WebElement OffInFrame2= driver.findElementById("webklipper-publisher-widget-container-notification-frame");
			wait.until(ExpectedConditions.visibilityOfAllElements(OffInFrame2));
			driver.switchTo().frame(OffInFrame2);
			WebElement offerInFrameinT= driver.findElementByXPath("//span[@class='wewidgeticon we_close icon-large']");
			wait.until(ExpectedConditions.elementToBeClickable(offerInFrameinT)).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		WebElement ExecTable= driver.findElementById("clip_wishlist_");
		wait.until(ExpectedConditions.elementToBeClickable(ExecTable)).click();
		driver.findElementByXPath("//a[contains(@class,'pf-icon pf-icon-heart')]").click();
		
		//verifyWishlist
		String itemsInWishlist = driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
		System.out.println("Number of items in Wishlist :"+itemsInWishlist);
		String offPrice= driver.findElementByXPath("(//span[@class='txt-green'])[1]").getText();
		System.out.println("Offer price of Executive Office Table in Brown Color :"+offPrice);
		String coupon = driver.findElementByXPath("( //p[@class='pf-border pf-border-lighter-grey-50 pf-border-style-dashed pf-center pf-padding-tiny font-14 pf-italic-txt pf-text-grey pf-margin-top use-coupon']/strong)[1]").getText();
		System.out.println("Coupon Code for Executive Office Table in Brown Color :"+coupon);
		driver.findElementByXPath("//a[@data-tooltip='Add to Cart']").click();
		WebElement pincode= driver.findElementByClassName("srvc_pin_text");
		wait.until(ExpectedConditions.visibilityOfAllElements(pincode));
		pincode.sendKeys("600002");
		driver.findElementByClassName("check_available").click();
		
		
		if(driver.findElementByClassName("qty_input").isDisplayed()) {
			
			System.out.println("Product deliverable to entered pin");
		}

		else {
			
			System.out.println("Product not deliverable to entered pin");
		}
	
		
		driver.findElementByClassName("proceed_cta").click();
		
		WebElement enterCoupon= driver.findElementById("coupon_code");
		wait.until(ExpectedConditions.visibilityOfAllElements(enterCoupon));
		enterCoupon.sendKeys(coupon);
		driver.findElementById("cpn_check_btn").click();
		driver.findElementByLinkText("PLACE ORDER").click();
		
		PepperFry obj= new PepperFry();
		obj.getScreenshot();
		
		
		
		
	}

}
