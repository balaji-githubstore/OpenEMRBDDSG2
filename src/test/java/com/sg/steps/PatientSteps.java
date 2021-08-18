package com.sg.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sg.base.WebDriverWrapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {	
	//setup webdriverwrapper driver details to use in the class
	private static WebDriver driver=WebDriverWrapper.driver;
	
	private static String actualAlert;
	
	@When("I mouseover on patient-client")
	public void i_mouseover_on_patient_client() {
	    
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();
	    
	}
	@When("I click on patients")
	public void i_click_on_patients() {
	    driver.findElement(By.xpath("//div[text()='Patients']")).click();
	    
	}
	@When("I click on add new patients")
	public void i_click_on_add_new_patients() {
	    driver.switchTo().frame("fin");
	    driver.findElement(By.id("create_patient_btn1")).click();
	    driver.switchTo().defaultContent();
	    
	}
	@When("I fill the patient details")
	public void i_fill_the_patient_details(io.cucumber.datatable.DataTable dataTable) {
	    
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		 List<Map<String, String>> ls=  dataTable.asMaps();
		 
		 driver.switchTo().frame("pat");
		 driver.findElement(By.id("form_fname")).sendKeys(ls.get(0).get("firstname"));
		 driver.findElement(By.id("form_lname")).sendKeys(ls.get(0).get("lastname"));
		 driver.findElement(By.id("form_DOB")).sendKeys(ls.get(0).get("dob"));
		 Select select=new Select(driver.findElement(By.id("form_sex")));
		 select.selectByVisibleText(ls.get(0).get("gender"));
		 
		 
	}
	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
	    driver.findElement(By.id("create")).click();
	    driver.switchTo().defaultContent();
	    
	}
	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() {
	    driver.switchTo().frame("modalframe");
	    driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
	    driver.switchTo().defaultContent();
	}
	@When("I handle the alert")
	public void i_handle_the_alert() { 

		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.alertIsPresent());
		
		actualAlert=driver.switchTo().alert().getText();	
		driver.switchTo().alert().accept();
	}
	@When("I close the happy birthday popup")
	public void i_close_the_happy_birthday_popup() {
	    
		if(driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size()>0)
		{
			driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		}
	}
	@Then("I should get the alert message as {string}")
	public void i_should_get_the_alert_message_as(String expectedAlert) {
	    
	    Assert.assertTrue(actualAlert.contains(expectedAlert)); //on false - it will be fail and abort
	}
	@Then("I should get the added patient detail as {string}")
	public void i_should_get_the_added_patient_detail_as(String expectedpatientName) {
	    
		driver.switchTo().frame("pat");
		Assert.assertEquals(expectedpatientName, driver.findElement(By.tagName("h2")).getText());
	    driver.switchTo().defaultContent();
	}

}






