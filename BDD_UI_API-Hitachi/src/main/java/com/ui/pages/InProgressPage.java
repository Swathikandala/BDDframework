package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class InProgressPage extends  BasePage{

	public InProgressPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Testing...']")
	WebElement inprogressPageIdentifier;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password;
	
	public String verifyInProgressPageTitle() {

		return driver.getTitle();

}
	
	public boolean verifyInProgPageIdentifier() {

		boolean flag=false;
		flag=inprogressPageIdentifier.isDisplayed();
		
		return flag;
	}
	
	
	
}
