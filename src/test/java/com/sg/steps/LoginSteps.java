package com.sg.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("I have browser with openemr page")
	public void i_have_browser_with_openemr_page() {
	    System.out.println("given");
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String string) {
		System.out.println("when");
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
		System.out.println("when");
	}
	@When("I select language as {string}")
	public void i_select_language_as(String string) {
		System.out.println("when");
	}
	@When("I click on login")
	public void i_click_on_login() {
		System.out.println("when");
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String string) {
		System.out.println("then");
	}
}
