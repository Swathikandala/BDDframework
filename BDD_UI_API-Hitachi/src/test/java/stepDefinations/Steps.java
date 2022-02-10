package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payloads.Payload;
import resource.ConstructPayload;
import resource.Utils;
import resource.APIResources;
import static org.junit.Assert.*;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;


public class Steps {
	
	private static RequestSpecification request;
	private static ResponseSpecification responspec;
	private static Response response;

	
	@Given("Construct Input Payload with {string}  {string} {string}")
	public void add_Input_Payload(String name, String string2, String string3) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		request=given().spec(Utils.requestSpecification())
				.body(ConstructPayload.addPayLoad(name,string2,string3));
	}


	
	@When("I send the Request using {string} resources and {string} Method")
	public void i_send_the_Request_using_resources_and_Method(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI=APIResources.valueOf(string);
		System.out.println(resourceAPI.getResource());
		if(string2.equalsIgnoreCase("POST"))
		response =request.when().post(resourceAPI.getResource());
		
		responspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}


@Then("I verify the Status code as {int}")
public void i_verify_the_Status_code_as(String statuscode) {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(response.getStatusCode(),statuscode);
}



@Given("construct request using tag name as QueryParam {string}")
public void construct_request_using_tag_name_as_QueryParam(String string) {
    // Write code here that turns the phrase above into concrete actions
	request=given().queryParam("tagname", string);
}

@When("I send the Request using {string} resource and {string} Method")
public void i_send_the_Request_using_resource_and_Method(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
	
	APIResources resourceAPI=APIResources.valueOf(string);
	if(string2.equalsIgnoreCase("GET"))
	response =request.when().get(resourceAPI.getResource());
	responspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	
}

@Then("I verify the Status code for GET as {int}")
public void i_verify_the_Status_code_as(Integer int1) {
    // Write code here that turns the phrase above into concrete actions

	new ResponseSpecBuilder().expectStatusCode(int1).build();
	//We can also validate the results from using JsonPath, since we do not have complete info of the response so cannot 

}



}
