package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sg.base.WebDriverWrapper;

public class DashboardPage {
	private static By flowBoardLocator=By.xpath("//div[text()='Flow Board']");
	private static By aboutLocator=By.xpath("//div[text()='About']");
	private static By patient=By.xpath("//div[text()='Patients']");
	private static By patientClient=By.xpath("//div[text()='Patient/Client']");
	
	public static void waitForPresenceOfFlowBoard()
	{
		WebDriverWait wait = new WebDriverWait(WebDriverWrapper.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(flowBoardLocator));
	}
	
	public static String getCurrentTitle()
	{
		return WebDriverWrapper.driver.getTitle().trim();
	}
	
	public static void clickOnFlowBoard()
	{
		WebDriverWrapper.driver.findElement(flowBoardLocator).click();
	}
	
	public static void clickOnAbout()
	{
		WebDriverWrapper.driver.findElement(aboutLocator).click();
	}
	public static void mouseOverOnPatientClient()
	{
		Actions action=new Actions(WebDriverWrapper.driver);
		action.moveToElement(WebDriverWrapper.driver.findElement(patientClient)).perform();
	}
	
	public static void clickOnPatients()
	{
		WebDriverWrapper.driver.findElement(patient).click();
	}

}
