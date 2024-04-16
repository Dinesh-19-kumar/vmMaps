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
import pageElements.RegisterPageElements;

/**
 * 
 */
public class RegisterPageEvents extends BaseTest {

	public void selectRegister() {

		WebElement el = driver.findElement(By.xpath(RegisterPageElements.register));

		el.click();

		WebElement ele = driver.findElement(By.xpath(RegisterPageElements.registerButton));

		Assert.assertNotNull(ele,"HomePage Not Loaded");
	}

	public void correctUser() {

		WebElement name = driver.findElement(By.xpath(RegisterPageElements.name));

		name.sendKeys("mr xxxxxxx xxxxx");

		WebElement email = driver.findElement(By.xpath(RegisterPageElements.email));

		email.sendKeys("rule@gmail.com");

		WebElement mobile = driver.findElement(By.xpath(RegisterPageElements.mobile));

		mobile.sendKeys("9876543210");

		WebElement password1 = driver.findElement(By.xpath(RegisterPageElements.password));

		password1.sendKeys("abc@1234");

		WebElement password2 = driver.findElement(By.xpath(RegisterPageElements.confirmPassword));

		password2.sendKeys("abc@1234");

		WebElement check1 = driver.findElement(By.xpath(RegisterPageElements.checkBox1));

		check1.click();

		WebElement check2 = driver.findElement(By.xpath(RegisterPageElements.checkBox2));

		check2.click();

		WebElement button = driver.findElement(By.xpath(RegisterPageElements.registerButton));

		button.click();

		WebElement el = driver.findElement(By.xpath(RegisterPageElements.verify));

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

	public void randomInput() {

		WebElement name = driver.findElement(By.xpath(RegisterPageElements.name));

		WebElement email = driver.findElement(By.xpath(RegisterPageElements.email));

		WebElement mobile = driver.findElement(By.xpath(RegisterPageElements.mobile));

		WebElement password1 = driver.findElement(By.xpath(RegisterPageElements.password));

		WebElement password2 = driver.findElement(By.xpath(RegisterPageElements.confirmPassword));

		WebElement check1 = driver.findElement(By.xpath(RegisterPageElements.checkBox1));

		WebElement check2 = driver.findElement(By.xpath(RegisterPageElements.checkBox2));

		WebElement button = driver.findElement(By.xpath(RegisterPageElements.registerButton));

		String randomUsername = generateRandomString(8);
		String randomEmail = generateRandomEmail();
		String randomMobileNumber = generateRandomMobileNumber();
		String randomPassword = generateRandomString(8);

		name.sendKeys(randomUsername);
		email.sendKeys(randomEmail);
		mobile.sendKeys(randomMobileNumber);
		password1.sendKeys(randomPassword);
		password2.sendKeys(randomPassword);
		check1.click();
		check2.click();
		button.click();

		WebElement el = driver.findElement(By.xpath(RegisterPageElements.verify));
		Assert.assertNotNull(el, "registration unsuccessfulll");

	}
	
	//---------------------------------------------------------------------------------------//

	private static String generateRandomMobileNumber() {
		StringBuilder mobileNumber = new StringBuilder();
		Random random = new Random();
		mobileNumber.append(random.nextInt(9) + 1); 
		for (int i = 1; i < 10; i++) {
			mobileNumber.append(random.nextInt(10));
		}
		return mobileNumber.toString();
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

	//---------------------------------------------------------------------------------------//

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
		WebElement element = driver.findElement(By.xpath(RegisterPageElements.register));
		element.click();
	}

}
