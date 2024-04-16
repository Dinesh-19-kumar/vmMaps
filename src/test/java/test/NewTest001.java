package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ForgtPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageEvents.RegisterPageEvents;

public class NewTest001 extends BaseTest {

	HomePageEvents homePage = new HomePageEvents();
	RegisterPageEvents registerPage = new RegisterPageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	ForgtPageEvents forgotPage = new ForgtPageEvents();


	@Test
	public void RegisterPageTest() {
		homePage.homePageLoaded();
		registerPage.selectRegister();
		registerPage.correctUser();


	}
	@Test
	public void RandomInputTest() {

		homePage.homePageLoaded();
		registerPage.selectRegister();
		registerPage.randomInput();


	}
	@Test(threadPoolSize = 5, invocationCount = 5)
	public void ConcurrencyTest() {

		homePage.homePageLoaded();
		registerPage.selectRegister();
		registerPage.randomInput();
	}
	@Test
	public void SessionIntruption() {

		homePage.homePageLoaded();
		registerPage.selectRegister();
		registerPage.sessionIntruption();

		Thread.onSpinWait();
	}
	@Test
	public void LoginPageTest() {
		homePage.homePageLoaded();
		loginPage.correctUser();

		Thread.onSpinWait();

	}
	@Test
	public void LoginRandomInputTest() {

		homePage.homePageLoaded();
		loginPage.randomInputs();

		Thread.onSpinWait();

	}
	@Test(threadPoolSize = 5, invocationCount = 5)
	public void LoginConcurrencyTest() {

		homePage.homePageLoaded();
		loginPage.randomInputs();
	}

	@Test
	public void LoginSessionIntruption() {

		homePage.homePageLoaded();
		loginPage.sessionIntruption();

		Thread.onSpinWait();
	}

	@Test
	public void Forgot() {

		homePage.homePageLoaded();
		forgotPage.forgot();

	}
}

