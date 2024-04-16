/**
 * 
 */
package pageEvents;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;
import pageElements.LoginPageElements;
import pageElements.RegisterPageElements;

/**
 * 
 */
public class LoginPageEvents extends BaseTest {

	public void correctUser() {

		WebElement email = driver.findElement(By.xpath(LoginPageElements.email));

		email.sendKeys("rule@gmail.com");

		WebElement password = driver.findElement(By.xpath(LoginPageElements.password));

		password.sendKeys("abc@1234");

		WebElement button = driver.findElement(By.xpath(LoginPageElements.button));

		button.click();

		WebElement el = driver.findElement(By.xpath(LoginPageElements.verify));

		Assert.assertNotNull(el, "verify button not loaded");

		WebElement firstOTPField = driver.findElement(By.id("firstOTP"));
		WebElement secondOTPField = driver.findElement(By.id("secondOTP"));
		WebElement thirdOTPField = driver.findElement(By.id("thirdOTP"));
		WebElement fourthOTPField = driver.findElement(By.id("fourthOTP"));
		WebElement fifthOTPField = driver.findElement(By.id("fifthOTP"));
		WebElement sixthOTPField = driver.findElement(By.id("sixthOTP"));

		String otpValue = generateOTP();

		firstOTPField.sendKeys(String.valueOf(otpValue.charAt(0)));
		secondOTPField.sendKeys(String.valueOf(otpValue.charAt(1)));
		thirdOTPField.sendKeys(String.valueOf(otpValue.charAt(2)));
		fourthOTPField.sendKeys(String.valueOf(otpValue.charAt(3)));
		fifthOTPField.sendKeys(String.valueOf(otpValue.charAt(4)));
		sixthOTPField.sendKeys(String.valueOf(otpValue.charAt(5)));

		WebElement Button = driver.findElement(By.xpath(RegisterPageElements.verify));
		Button.click();

	}

	public static String generateOTP() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return String.format("%06d", otp); 
	}

	public void randomInputs() {

		WebElement email = driver.findElement(By.xpath(LoginPageElements.email));

		WebElement password = driver.findElement(By.xpath(LoginPageElements.password));

		WebElement button = driver.findElement(By.xpath(LoginPageElements.button));

		String randomEmail = generateRandomEmail();
		String randomPassword = generateRandomString(8);

		email.sendKeys(randomEmail);
		password.sendKeys(randomPassword);
		button.click();
	}

	private static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder randomString = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			randomString.append(characters.charAt(random.nextInt(characters.length())));
		}
		return randomString.toString();
	}

	private static String generateRandomEmail() {
		String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
		return generateRandomString(8) + "@" + domains[new Random().nextInt(domains.length)];
	}
	
	public void sessionIntruption() {

		simulateRefresh();
		simulateNavigation();
		simulateInternetLoss();

	}

	//---------------------------------------------------------------------------------------//

	private static void simulateRefresh() {

		driver.navigate().refresh();
	}

	private static void simulateNavigation() {

		driver.get("http://meow.com");
		driver.navigate().back();
	}

	private static void simulateInternetLoss() {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(LoginPageElements.button));
		element.click();
	}

}
