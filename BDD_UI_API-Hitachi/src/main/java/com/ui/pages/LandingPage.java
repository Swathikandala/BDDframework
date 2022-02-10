package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.util.ReusableMethods;

public class LandingPage extends BasePage {
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "url")
	WebElement searchbox;

	@FindBy(xpath = "//button[contains(text(), 'Start Test')]")
	WebElement startTest_btn;

	@FindBy(id = "location")
	WebElement location_dropdown;

	
	@FindBy(id = "browser")
	WebElement browserdropdown;
	
	@FindBy(id = "connection")
	WebElement connection;
	
	@FindBy(id = "resolution")
	WebElement Desktop_Browser_Dimensions;
	
	@FindBy(id = "viewBoth")
	WebElement First_View_and_Repeat_View;
	
	@FindBy(id = "advanced_settings")
	WebElement advanced_settings;
	
	
	


	public String verifyLandingPageTitle() {

				return driver.getTitle();
		
	}
	
	public void selectInputOnPage()
	{
		ReusableMethods.enterValueInTextBox(searchbox, prop.getProperty("test_website"));
		ReusableMethods.selectDropdownOption(location_dropdown, prop.getProperty("Test_Location"));
		ReusableMethods.selectDropdownOption(browserdropdown, prop.getProperty("Test_Browser"));
		ReusableMethods.click(advanced_settings);
		ReusableMethods.selectDropdownOption(connection, prop.getProperty("Connection"));
		ReusableMethods.selectDropdownOption(Desktop_Browser_Dimensions, prop.getProperty("Desktop_Browser_Dimensions"));
		ReusableMethods.selectRadioButton(First_View_and_Repeat_View);
	}
	
	
	public InProgressPage clickStartTestBtn()
	{
		ReusableMethods.click(startTest_btn);
		
		return new InProgressPage();
	}
	
	
	
	
	
	
	
	
	
//	public HashMap<String, Object> navigateToMainMenu(String Mainmenu, String Submenu)
//	{
//		driver.switchTo().frame("mainpanel");
////		 Actions class
//		Actions actions = new Actions(driver);
//
//		//Hovering on main menu
//		actions.moveToElement(MainMenuTable.findElement(By.xpath("//a[text()='"+Mainmenu+"']")));
//
//		// Locating the element from Sub Menu
//		WebElement subMenu = MainMenuTable.findElement(By.xpath("//a[text()='"+Submenu+"']"));
//
//		//To mouseover on sub menu
//		actions.moveToElement(subMenu);
//
//		//build()- used to compile all the actions into a single step 
//		actions.click().build().perform();
//		
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		
//		map.put("Tasks", new InProgressPage());
//
//		return map;
//		
//		
//		
//	}
//	
//	public boolean returnLoggedInUser()
//	{
//		driver.switchTo().frame("mainpanel");
//		addBoxes.click();
//		return loggedinuser.isDisplayed();
//		
//	}
//		
		
		
	}

