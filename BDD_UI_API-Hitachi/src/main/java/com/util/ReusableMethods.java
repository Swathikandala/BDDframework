package com.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ReusableMethods {

	// reusablemethod
	public static void selectDropdownOption(WebElement we, String option) {
		Select s = new Select(we);
		s.selectByVisibleText(option);

	}

	public static void click(WebElement we) {
		we.click();
	}

	public static void selectRadioButton(WebElement we) {

		we.click();
	}

	public static void enterValueInTextBox(WebElement we, String value) {
		we.sendKeys(value);
	}

	public static void captureScreenshot(WebDriver driver) throws IOException {
		// TODO Auto-generated method stub

		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") + "\\screenshots\\results.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
//		
//		
//		TakesScreenshot scnshot = (TakesScreenshot) driver;
//
//		File src = scnshot.getScreenshotAs(OutputType.FILE);
//
//		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\screenshots\\results.png"));

	}

	public static void explicitlyWait(WebDriver driver, String string, WebElement we) {

		long waittime=Long.parseLong(string);
//		System.out.println(waittime+ " wait time-------++");
		WebDriverWait wait= new WebDriverWait(driver, waittime);
		wait.until(ExpectedConditions.visibilityOf(we));
				
		
		
	}
	
	

}
