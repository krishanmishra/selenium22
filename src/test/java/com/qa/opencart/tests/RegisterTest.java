package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterTest extends BaseTest {

	@BeforeClass
	public void registerSetup() {
		registerPage = loginPage.registerUser();
	}

	@Test
	public void registrationUserTest() throws InterruptedException {

		Assert.assertTrue(registerPage.registerUser("krisna", "kulka","krishan1@gmail.com", "8907788990","Delhi",
				"Delhi","12345","India","Delhi","Pass@123", "Yes"));
	}

}
