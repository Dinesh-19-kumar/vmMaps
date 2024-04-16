/**
 * 
 */
package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageElements.ForgtPageElements;
import pageElements.LoginPageElements;

/**
 * 
 */
public class ForgtPageEvents extends BaseTest {

	public void forgot() {

		WebElement email = driver.findElement(By.xpath(LoginPageElements.email));

		email.sendKeys("rule@gmail.com");

		WebElement password = driver.findElement(By.xpath(LoginPageElements.password));

		password.sendKeys("abc@1234");

		WebElement frgt = driver.findElement(By.xpath(ForgtPageElements.forgt));

		frgt.click();

		WebElement alert = driver.findElement(By.xpath(ForgtPageElements.alert));

		alert.getText();

		WebElement alert1 = driver.findElement(By.xpath(ForgtPageElements.alert1));

		alert1.getText();

		WebElement alert2 = driver.findElement(By.xpath(ForgtPageElements.alert2));

		alert2.getText();
	}
}
