package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageTitleTest() {

		String title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void loginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageUrl();
		System.out.println("Login Page url is: " + actualUrl);
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
		
	}

	@Test(priority=3)
	public void forgotPasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority=4)
	public void registerLinkExist() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@Test(priority=5)
	public void loginTest() {
		Assert.assertTrue(loginPage
				.doLogin(prop.getProperty("username"), prop.getProperty("password"))
				   .isLogoutLinkExist());
	}
}
