package daily_Practice;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AzureMicrosoft {


	public void verifyDowloadFile() {

		File filelocation1= new File("C:\\Users\\Techlab\\Downloads");
		File[] listFiles1 = filelocation1.listFiles();

		for (File file1 : listFiles1) {
			if(file1.getName().contentEquals("ExportedEstimate.xlsx")) {
				System.out.println("File is downlaoded");
				break;

			}


		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("navigation-pricing").click();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pricing calculator"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-event-property='containers']"))).click();
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("new-module-loc"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@aria-label='Region']")));
		WebElement region= driver.findElementByXPath("//select[@aria-label='Region']");
		Select regions= new Select(region);
		regions.selectByValue("south-india");
		driver.findElementByXPath("//input[@name='seconds']").sendKeys("",Keys.BACK_SPACE,Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElementByXPath("//input[@name='seconds']").sendKeys("180000");
		WebElement memory= driver.findElementByXPath("//select[@aria-label='Memory']");
		Select memories= new Select(memory);
		memories.selectByValue("4");
		driver.findElementById("devtest-toggler").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='select currency-dropdown']")));
		WebElement currency= driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select currencies=  new Select(currency);
		currencies.selectByValue("INR");
		String estimatedprice1 = driver.findElementByXPath("//section[@id='azure-calculator']/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/div[6]/div[1]/div[2]/div[2]/span[1]/span[1]").getText();
		System.out.println("Estimated price :"+estimatedprice1);

		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();

		AzureMicrosoft obj= new AzureMicrosoft();
		obj.verifyDowloadFile();


		//Navigate to Example Scenarios and Select CI/CD for Containers

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-bi-an='body'])[2]")));
		WebElement  ExampleScenarios= driver.findElementByXPath("(//a[@data-bi-an='body'])[2]");
		Actions action = new Actions(driver);
		action.moveToElement(ExampleScenarios).click().perform();

		driver.findElementByXPath("//span[text()='CI/CD for Containers']").click();
		driver.findElementByXPath("//button[contains(@class,'button button--secondary01')]").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='select currency-dropdown']")));
		WebElement currency1= driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select currencies1=  new Select(currency1);
		currencies1.selectByValue("INR");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-additional-property='msdn']")));
		WebElement toggle= driver.findElementByXPath("//button[@data-additional-property='msdn']");
		action.moveToElement(toggle).click().perform();
		String estPrice = driver.findElementByXPath("(//span[@class='numeric']//span)[2]").getText();
		System.out.println("Estimated price CI/CD for container :"+estPrice);
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();

		AzureMicrosoft obj1= new AzureMicrosoft();
		obj1.verifyDowloadFile();

	}



}
