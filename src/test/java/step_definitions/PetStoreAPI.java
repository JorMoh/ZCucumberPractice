package step_definitions;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStoreAPI {

	Response response;
	int petID;
	
	
	@Given("the base url is: https:\\/\\/petstore.swagger.io\\/v2")
	public void the_base_url_is_https_petstore_swagger_io_v2() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	@Given("you create a pet with id3465XXX and you give the pet a name booboo in the request body status is available")
	public void you_create_a_pet_with_id3465xxx_and_you_give_the_pet_a_name_booboo_in_the_request_body_status_is_available() {
		File requestBody = new File("./src/test/resources/TestData/JSonTestData/homeworkPost.json");
		 
		 Response response = RestAssured
		 .given().accept(ContentType.JSON).contentType("application/json")
		 .when().body(requestBody).post("/pet");
		 this.response = response;
		 
		 
	}
	@Then("verify status code is200 and the content type is application\\/json.")
	public void verify_status_code_is200_and_the_content_type_is_application_json() {
		response.then()
		 .assertThat().statusCode(200)
		 .and().contentType("application/json");
		 petID = response.body().path("id");
		 System.out.println("dgdfgdfgdfgdfg"+ petID);
	}

	
	@Given("you perform a get request to retrieve the pest you created in the former scenario")
	public void you_perform_a_get_request_to_retrieve_the_pest_you_created_in_the_former_scenario() {
		File requestBody = new File("./src/test/resources/TestData/JSonTestData/homeworkPost.json");
		 
		 Response response = RestAssured
		 .given().accept(ContentType.JSON).contentType("application/json")
		 .when().body(requestBody).post("/pet");
		 this.response = response;
		 
	    Response response1 = RestAssured
	    		.given().accept(ContentType.JSON)
	    		.when().get("/pet"+petID);
	    this.response = response;
	    
	}
	
	@Then("verify status code is200, content type is json and status is: available.")
	public void verify_status_code_is200_content_type_is_json_and_status_is_available() {
	    response.then().assertThat().statusCode(200)
	    .and().contentType("application/json");
	}

	
	@Given("you perform a get request to find a pet with ID7867864")
	public void you_perform_a_get_request_to_find_a_pet_with_id7867864() {
		 Response response = RestAssured
				  .given().accept(ContentType.JSON)
				  .when().get("/pet/7867864");
		 this.response = response;
	}
	@Then("verify status code is404, content type is json and message is Pet not found.")
	public void verify_status_code_is404_content_type_is_json_and_message_is_pet_not_found() {
		 response.then()
		  .assertThat().statusCode(404)
		  .and().contentType("application/json")
		  .and().body("message", equalTo("Pet not found"));
	}












	





	
	




}
