/**
 * 
 */
package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;
import pageElements.HomePageElements;

/**
 * 
 */
public class HomePageEvents extends BaseTest {
	
	public void homePageLoaded() {
		
		WebElement ele = driver.findElement(By.xpath(HomePageElements.homePage));
		
		Assert.assertNotNull(ele,"HomePage Not Loaded");
	}
	
}
