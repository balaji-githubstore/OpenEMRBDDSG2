package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.sg.base.WebDriverWrapper;

import io.cucumber.java.en.When;

public class LoginPage {
//	private static By usernameLocator = By.id("authUser");
//	private static By passwordLocator = By.id("clearPass");
//	private static By languageLocator = By.name("languageChoice");
	
	@FindBy(id = "authUser")
	private static WebElement usernameElement;
	
	@FindBy(xpath = "//*[@id='clearPass']")
	private static WebElement passwordElement;
	
	@FindBy(how = How.NAME,using = "languageChoice")
	private static WebElement languageElement;
	
	
	private static By loginLocator = By.xpath("//button[@type='submit']");
	private static By ackLicCertiLocator = By.partialLinkText("Acknowledgments");
	private static By appDescriptionLocator = By.xpath("//p[contains(text(),'most')]");
	private static By errorLocator = By.xpath("//div[contains(text(),'Invalid')]");

	
	public static void enterUsername(String username) {
		usernameElement.sendKeys(username);
	}

	public static void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public static void selectLanguageByText(String language) {
		Select selectLang = new Select(languageElement);
		selectLang.selectByVisibleText(language);
	}

	public static void clickOnLogin() {
		WebDriverWrapper.driver.findElement(loginLocator).click();
	}

	public static void clickOnAckLicAndCertifi() {
		WebDriverWrapper.driver.findElement(ackLicCertiLocator).click();
	}

	public static String getApplicationDescription() {
		String desc = WebDriverWrapper.driver.findElement(appDescriptionLocator).getText().trim();
		return desc;
	}

	public static String getInvalidLoginErrorMessage() {
		return WebDriverWrapper.driver.findElement(errorLocator).getText().trim();
	}
	
}
