package com.ui.stepDefinations;

import org.junit.Assert;

import com.base.BasePage;
import com.ui.pages.InProgressPage;
import com.ui.pages.LandingPage;
import com.ui.pages.ResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations extends BasePage {
	
	LandingPage lpage;
	InProgressPage inpage;
	ResultsPage rspage;

@Given("I Launch the browser and enter the application URL")
public void i_hit_this_application_URL() {
		initialization();
		
}

@When("I enter the input details and hit start test")
public void i_enter_the_input_details_as() {

	lpage = new LandingPage();
	lpage.selectInputOnPage();
	lpage.clickStartTestBtn();
}

@Then("I verify the InProgress Page")
public void i_verify_the_InProgress_Page() {
	
	inpage = new InProgressPage();
	inpage.verifyInProgressPageTitle();
	Assert.assertTrue(inpage.verifyInProgressPageTitle().contains("Running"));
	Assert.assertTrue(inpage.verifyInProgPageIdentifier());
	
}

@Then("I verify the Results in ResultPage")
public void i_verify_the_Results_in_ResultPage() {

	rspage = new ResultsPage();
	Assert.assertTrue(rspage.ResultsPageURL().contains("result"));
	Assert.assertTrue(rspage.verifyResultsPageIdentifier());
	
	
}
@Then("I Take the screenshot of ResultPage")
public void i_Take_the_screenshot_of_ResultPage() {
    // Write code here that turns the phrase above into concrete actions
	rspage.captureScreenshotOfResults();
}

@Then("I Close the Driver")
public void i_Close_the_Driver() {
    // Write code here that turns the phrase above into concrete actions
    closedriver();
}

	
	

}
