package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public void initialization()
	{
		try {
			System.out.println("----------INITIALIZATION----------");
			
			prop = new Properties();
			String path=System.getProperty("user.dir") + "\\src\\test\\java\\com\\config\\config.properties";
			FileInputStream fis= new FileInputStream(path);
			prop.load(fis);
			
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
		String browser =prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
//			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			
			long waittime=Long.parseLong(prop.getProperty("implicitWait"));
			driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
			
		}else if (browser.equalsIgnoreCase("Firefox"))
		{
			
			//code to instantiate firefox driver comes here
		}
		
	}
	
	public void closedriver()
	{
		driver.quit();
	}
}
	
