package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.SauceDemoPOM;
import utils.Driver;
import utils.dataReader;

public class SauceLogin {

	SauceDemoPOM sauce = new SauceDemoPOM();
	
	

	@Given("user navigates to SauceDemo website")
	public void user_navigates_to_sauce_demo_website() {
	 Driver.getDriver().get(dataReader.getData("sauceDemoUrl"));
	}
	@When("user enters a valid username {string} in the username field")
	public void user_enters_a_valid_username_in_the_username_field(String string) {
		 sauce.usernameField.sendKeys("standard_user");

	}
	@When("user enters a valid password {string} in the password field")
	public void user_enters_a_valid_password_in_the_password_field(String string) {
	   sauce.passwordField.sendKeys("secret_sauce");
	}
	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
	   sauce.loginBtn.click();
	}
	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	  Assert.assertTrue(sauce.productsText.isDisplayed());
	}

	@When("user enters an invalid username {string} in the username field")
	public void user_enters_an_invalid_username_in_the_username_field(String string) {
		sauce.usernameField.sendKeys("standard_user1");
	}
	
	@Then("user should not log in")
	public void user_should_not_log_in() {
	   Assert.assertTrue(sauce.loginBtn.isDisplayed());
	}
	@Then("user should get the message “Epic sadface: Username and password do not match any user in this service”")
	public void user_should_get_the_message_epic_sadface_username_and_password_do_not_match_any_user_in_this_service() {
	   Assert.assertTrue(sauce.credentialsDontMatchError.isDisplayed());
	}


	@When("user enters a locked out username {string} in the username field")
	public void user_enters_a_locked_out_username_in_the_username_field(String string) {
		sauce.usernameField.sendKeys("locked_out_user");
	}
	
	@Then("user should get the message  “Epic sadface: Sorry, this user has been locked out.”")
	public void user_should_get_the_message_epic_sadface_sorry_this_user_has_been_locked_out() {
		   Assert.assertTrue(sauce.lockedOutUserError.isDisplayed());

	}




}
