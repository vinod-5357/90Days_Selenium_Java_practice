package daily_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zalando {

	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.zalando.com/");
		/* driver.manage().window().maximize(); */
		/* driver.manage().deleteAllCookies(); */ 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println("Alert text :"+text);
			alert.accept();
		} catch (Exception e) {

			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav_link nav_link-gb']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Women'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'z-text z-navicat-header_categoryListLinkText')])[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='cat_link-mTK6o'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='uc-btn uc-btn-primary']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-label='Material']/following-sibling::span[1]"))).click();
		driver.findElementByXPath("(//span[@class='cat_label-3NBdm cat_ellipsis-MujnT'])[4]").click();
		driver.findElementByXPath("//button[contains(@class,'cat_save-3v2Gl cat_button-3q7je')]").click();
		Thread.sleep(3000);
		WebElement lenght= driver.findElementByXPath("//span[@data-label='Length']/following-sibling::span[1]");
		Actions action= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lenght));
		action.moveToElement(lenght).click().perform();
		driver.findElementByXPath("(//span[@class='cat_label-3NBdm cat_ellipsis-MujnT'])[2]").click();
		driver.findElementByXPath("//button[contains(@class,'cat_save-3v2Gl cat_button-3q7je')]").click();
		
		  wait.until(ExpectedConditions.elementToBeClickable(By.
		  xpath("//div[text()='JUNAROSE - by VERO MODA']")));
		 
		WebElement product=driver.findElementByXPath("(//div[@class='cat_brandName-2XZRz cat_ellipsis-MujnT'])[1]");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", product);
		product.click();
		/* action.moveToElement(product).click().perform(); */
		driver.findElementById("picker-trigger").click();
		driver.findElementByXPath("(//span[@class='HWFFx9'])[2]").click();
		driver.findElementByXPath("(//div[contains(@class,'UyCaZm _2TPICz')])[2]").click();
		String Sdelivery = driver.findElementByXPath("(//span[@class='AtOZbZ'])[2]").getText();
		System.out.println(Sdelivery);
		if (Sdelivery.equals("Free")) {

			driver.findElementByXPath("//span[text()='Add to bag']").click();

		}
		WebElement yourBag= driver.findElementByXPath("//span[text()='Your bag']");
		action.moveToElement(yourBag).click();
		driver.findElementByClassName("z-1-button__content").click();
		String estmDate = driver.findElementByXPath("(//span[contains(@class,'z-2-text z-2-text-body')])[1]").getText();
		System.out.println("Estimated date "+estmDate);
		driver.findElementByXPath("(//div[@class='z-1-button__content'])[3]").click();
		driver.findElementById("login.email").sendKeys("vinodnk4771@gmail.com");
		driver.findElementByXPath("//span[contains(@class,'_avtKm XQCmZ9')]").click();
		String loginError= driver.findElementByXPath("//span[contains(@class,'C5k6gw gQjacQ')]").getText();
		System.out.println("Login error when password not entered :"+loginError);
	}

}
