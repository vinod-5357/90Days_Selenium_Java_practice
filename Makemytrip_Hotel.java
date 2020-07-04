package daily_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Makemytrip_Hotel {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//div[@class='loginModal displayBlock modalLogin dynHeight personal ']").click();

		driver.findElementByXPath("//span[text()='Hotels']").click();
		Thread.sleep(2000);
		driver.findElementById("city").sendKeys("goa", Keys.TAB);
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		driver.findElementByXPath("(//div[text()='19'])[2]").click();driver.findElementById("guest").click();
		driver.findElementByXPath("//li[@data-cy='adults-2']").click();
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();
		driver.findElementById("hsw_search_button").click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.doubleClick().perform();
		driver.findElementByXPath("//a[@class='mapCont']").click();
		driver.findElementByXPath("//span[@class='mapClose']").click(); WebDriverWait
		wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//label[text()='Baga']")));
		driver.findElementByXPath("//label[text()='Baga']").click(); WebDriverWait
		wait1= new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(By.
				xpath("//label[text()='3 & above (Good)']")));
		driver.findElementByXPath("//label[text()='3 & above (Good)']").click();
		WebDriverWait wait2= new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//span[text()='Popularity']")));
		driver.findElementByXPath("//span[text()='Popularity']").click();
		driver.findElementByXPath("//li[text()='Price - Low to High']").click();
		driver.manage().deleteAllCookies();
		driver.findElementByXPath("(//div[@class='flexOne appendLeft20'])[2]").click(
				);



		String currentWindow = driver.getWindowHandle(); Set<String>
		defaultAndSelected= driver.getWindowHandles();

		List<String> listHandles= new ArrayList<String>(defaultAndSelected); String
		SelectedHotel = listHandles.get(1);

		driver.switchTo().window(SelectedHotel); driver.manage().deleteAllCookies();
		driver.navigate().refresh();

		String hotelName = driver.findElementById("detpg_hotel_name").getText();
		System.out.println("Hotel Name :"+hotelName);
		driver.findElementById("detpg_multi_view_combo").click();
		driver.findElementById("detpg_book_combo_btn").click(); WebElement
		Comboprice= driver.findElementById("detpg_combo_price");
		wait.until(ExpectedConditions.visibilityOfAllElements(Comboprice)); String
		payableAmount = Comboprice.getText();
		System.out.println("Total payable amount :"+payableAmount);
		Thread.sleep(3000); driver.close();





	}

}
