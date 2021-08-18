package com.sg.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	private WebDriver driver;
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("I have browser with openemr page")
	public void i_have_browser_with_openemr_page() {	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.openemr.io/b/openemr");
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		driver.findElement(By.id("authUser")).sendKeys(username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	@When("I select language as {string}")
	public void i_select_language_as(String langauage) {
		Select selectLang=new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText(langauage);
	}
	@When("I click on login")
	public void i_click_on_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedValue) {	
		String actualValue=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		Assert.assertEquals(expectedValue,actualValue);
	}
	
	@Then("I should access to the portal with title as {string}")
	public void i_should_access_to_the_portal_with_title_as(String expectedTitle) {
	   
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}

}









