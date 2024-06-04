import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchHotelsTestCases {
	
	WebDriver driver= new ChromeDriver();
	String webUrl="https://global.almosafer.com/en";
	
	@BeforeTest
	public void Setup() {
		driver.manage().window().maximize();
		driver.get(webUrl);
		driver.findElement(By.cssSelector("body > div.js-modal-root > div > div.sc-bhlBdH.exRoue > div > div > div > button.sc-jTzLTM.hQpNle.cta__button.cta__continue.btn.btn-primary")).click();
		
	}
	
	@Test(priority = 1)
	public void navigateToHotels() {
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();
		
		
	}
	
	@Test(priority = 2)
	public void fillSearchFields() throws InterruptedException {
		driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']")).sendKeys("Jordan");
		driver.findElement(By.id("js-hotelsSearchBoxDatePickerCheckInDate")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@data-testid='HotelsSearchCalendar__2024-07-11']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='HotelsSearchBox__ToDateButton']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@data-testid='HotelsSearchCalendar__2024-08-08']")).click();
		
		WebElement element= driver.findElement(By.xpath("//select[@data-testid=\"HotelSearchBox__ReservationSelect_Select\"]"));
		Select selector=new Select(element);
		selector.selectByVisibleText("1 Room, 1 Adult, 0 Children");
		
		driver.findElement(By.xpath("//button[@data-testid=\"HotelSearchBox__SearchButton\"]")).click();
		Thread.sleep(10000);
	}
	
	@Test (priority = 3)
	public void chooseRandomHotelTest() {
		
		driver.findElement(By.xpath("//button[@data-testid=\"HotelSearchResult__Hotel20__CTA\"]")).click();
	
	}

}
