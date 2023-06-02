package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pagesPOM.AmazonHomePOM;
import utils.BrowserUtils;
import utils.DButils;
import utils.Driver;
import utils.dataReader;

public class AmazonSearch {

	AmazonHomePOM home = new AmazonHomePOM();
	BrowserUtils browser = new BrowserUtils();
	
	@Given("I am on Amazon website homepage")
	public void i_am_on_amazon_website_homepage() {
	   Driver.getDriver().get(dataReader.getData("amazonUrl"));
	}
	@And("I enter a search item {string} in the search field")
	public void i_enter_a_search_item_in_the_search_field(String item) {
		browser.waitUntilElementVisible(home.homeSearchBox);
	   home.homeSearchBox.sendKeys(item);
	   
	}
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		home.searchBtn.click();
	}
	
	@Then("I should see the search item {string} on the results page")
	public void i_should_see_the_search_item_on_the_results_page(String item) {
		String searchedItemText = home.searchedItemText.getText().substring(1, item.length()+1);
	   Assert.assertEquals(searchedItemText , item);
	}



}
