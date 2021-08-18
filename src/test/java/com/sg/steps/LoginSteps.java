package com.sg.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sg.base.WebDriverWrapper;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@After
	public void tearDown()
	{
		WebDriverWrapper.driver.quit();
	}
	
	@Given("I have browser with openemr page")
	public void i_have_browser_with_openemr_page() {	
		WebDriverWrapper.launchBrowser();
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		WebDriverWrapper.driver.findElement(By.id("authUser")).sendKeys(username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		WebDriverWrapper.driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	@When("I select language as {string}")
	public void i_select_language_as(String langauage) {
		Select selectLang=new Select(WebDriverWrapper.driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText(langauage);
	}
	@When("I click on login")
	public void i_click_on_login() {
		WebDriverWrapper.driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedValue) {	
		String actualValue=WebDriverWrapper.driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		Assert.assertEquals(expectedValue,actualValue);
	}
	
	@Then("I should access to the portal with title as {string}")
	public void i_should_access_to_the_portal_with_title_as(String expectedTitle) {
	   
		WebDriverWait wait = new WebDriverWait(WebDriverWrapper.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		
		Assert.assertEquals(expectedTitle, WebDriverWrapper.driver.getTitle());
	}

}









