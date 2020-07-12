package daily_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket {

	public static ChromeDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.manage().deleteAllCookies();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement category= driver.findElementByXPath("//a[@qa='categoryDD']");
		action= new Actions(driver);
		action.moveToElement(category).perform();
		WebElement beverages= driver.findElementByXPath("(//a[@qa='catL1'])[4]");
		action.moveToElement(beverages).perform();
		WebElement fruitsAndDrinks=driver.findElementByLinkText("Fruit Juices & Drinks");
		action.moveToElement(fruitsAndDrinks).perform();
		WebElement juices= driver.findElementByXPath("(//a[@ng-bind='l3.name'])[5]");
		action.moveToElement(juices).click().perform();
		wait=  new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Tropicana'])[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@qa='pageName']")));
		String TjuicesCount = driver.findElementByXPath("//input[@value='35']").getText();
		System.out.println("Tropicana Juice count :"+TjuicesCount);
		driver.findElementByLinkText("Clear all").click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Real'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[@class='ng-binding'])[3]")));
		String RjuiceCount = driver.findElementByXPath("(//h2[@class='ng-binding'])[3]").getText();
		System.out.println("Real count :"+RjuiceCount);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Tropicana'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//h2[@class='ng-binding'])[3]")));
		String TandRcount = driver.findElementByXPath("(//h2[@class='ng-binding'])[3]").getText();
		System.out.println("Tropicana and real juice count :"+TandRcount);
		
		//Add basket
		driver.findElementByXPath("(//button[@qa='add'])[1]").click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='col-md-6']//a)[1]")));
		driver.findElementByXPath("(//div[@class='col-md-6']//a)[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys("600002",Keys.ENTER);
		driver.findElementByXPath("//button[@name='continue']").click();
		WebElement myBasket= driver.findElementByXPath("//span[@class='basket-content']");
		action.moveToElement(myBasket).perform();
		String productName = driver.findElementByXPath("//a[@qa='prodNameMB']").getText();
		System.out.println("Added product name :"+productName);
		String productPrice = driver.findElementByXPath("(//span[text()='110.00'])[1]").getText();
		System.out.println("Product price :"+productPrice);
		driver.findElementByXPath("//button[@qa='viewBasketMB']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//button[@class='close'])[1]").click();
		Thread.sleep(3000);
		driver.close();

	}

}
