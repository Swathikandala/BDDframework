package com.ui.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.util.ReusableMethods;

public class ResultsPage extends BasePage {

	public ResultsPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Web page performance test result for']")
	WebElement resultsPageIdentifier;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;

	public boolean verifyResultsPageIdentifier() {

		boolean flag = false;
		ReusableMethods.explicitlyWait(driver, prop.getProperty("explicitWait"), resultsPageIdentifier);
		flag = resultsPageIdentifier.isDisplayed();
		return flag;
	}

	public String ResultsPageURL() {
		return driver.getCurrentUrl();
	}

	public void captureScreenshotOfResults() {
		try {
			ReusableMethods.captureScreenshot(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
