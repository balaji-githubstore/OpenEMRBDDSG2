package com.sg.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("I have {string} browser with openemr page")
	public void i_have_browser_with_openemr_page(String browser) {
		WebDriverWrapper.launchBrowser(browser);
	}

	@Given("I have browser with openemr page")
	public void i_have_browser_with_openemr_page() {
		WebDriverWrapper.launchBrowser("ch");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		LoginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		LoginPage.enterPassword(password);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String langauage) {
		LoginPage.selectLanguageByText(langauage);
	}

	@When("I click on login")
	public void i_click_on_login() {
		LoginPage.clickOnAckLicAndCertifi();
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedValue) {
		String actualValue = LoginPage.getInvalidLoginErrorMessage();
		Assert.assertEquals(expectedValue, actualValue);
	}

	@Then("I should access to the portal with title as {string}")
	public void i_should_access_to_the_portal_with_title_as(String expectedTitle) {
		DashboardPage.waitForPresenceOfFlowBoard();
		Assert.assertEquals(expectedTitle, DashboardPage.getCurrentTitle());
	}

}
