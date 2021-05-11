package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	By text_username = By.id("username");
	By text_password = By.id("password");
	By btn_loginbutton = By.xpath("//button[@class='radius']");
	
	By logged_message = By.id("flash");
	
	public LoginPage (WebDriver driver) { 	
		this.driver = driver; 	
	}  // constructor
	
	public void username_locate(String uname) {
		driver.findElement(text_username).sendKeys(uname);
	}
	
	public void password_locate(String passwd) {
		driver.findElement(text_password).sendKeys(passwd);
	}
	
	public void button_locate() {
		driver.findElement(btn_loginbutton).click();
		
	}
	
	public String login_displayed() {
		String actualString = driver.findElement(logged_message).getText();
		return actualString;
	} 


	/*
	public void loginValidate(String resultMessage) {
		
	} */
	
	
	} // end of LoginPage class Page class for auth web page
