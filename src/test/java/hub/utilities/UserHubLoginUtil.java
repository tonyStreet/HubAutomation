package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import hub.library.FunctionReference;

import org.testng.Assert;

public class UserHubLoginUtil extends FunctionReference {
	
	private String[] input = null;
	private String testCase = "";
	
	public UserHubLoginUtil(String[] i) {
		input = i;
	}
	
	public UserHubLoginUtil() {
	}
	
	public void hubUiLogin() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));											 
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("Enter your property address or street name here.", getValue(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	public void testHubLoginSuccess() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));											 
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		} else {
			pass(testCase);
		}
	}
	
	public void testHubLoginEmpty() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(hubLoginError));
		try {
			Assert.assertTrue(isElementPresent(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	

		try {
			Assert.assertEquals(emptyErrorMessage, getText(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	
					
		if (resultcount != 0) {
			Assert.fail();
		} else {
			pass(testCase);
		}
	}

	public void testHubLoginFail() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(hubLoginError));
		try {
			Assert.assertTrue(isElementPresent(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	

		try {
			Assert.assertEquals(invalidErrorMessage, getText(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	
		
	
		if (resultcount != 0) {
			Assert.fail();
		} else {
			pass(testCase);
		}
	}
	
	public void smokeLogin () throws InterruptedException, IOException {
		resultcount = 0;
		
		driver.navigate().to(input[1]);		
		
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(userLoginButton));
		
		String username = "";
		String password = "";
		testCase = "RP Property Hub Login: " + input[0];
		username = input[2];
		password = input[3];

		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(userLoginButton));
	}
	
	private void hubLoginSetup () throws InterruptedException, IOException {
		resultcount = 0;
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(userLoginButton));
		
		String username = "";
		String password = "";
		if (input == null) {
			username = rxml.data("userUsername");
			password = rxml.data("userPassword");
		} else {
			testCase = "RP Property Hub Login: " + input[0];
			username = input[1];
			password = input[2];
		}
		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(userLoginButton));
	}

	public void smokeDeepLink() throws InterruptedException, IOException{
		resultcount = 0;
		
		driver.navigate().to(input[1] + input[10]);		
		
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(userLoginButton));
		
		String username = "";
		String password = "";
		testCase = "RP Property Hub Login: " + input[0];
		username = input[2];
		password = input[3];

		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(userLoginButton));
		Thread.sleep(3000);
	}
}

