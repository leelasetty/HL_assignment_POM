package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginAuthStep_pom {

	WebDriver driver = null;
	LoginPage login;
	
	@Given("user given with brower open and auth page lunched")
	public void user_given_with_brower_open_and_auth_page_lunched() {
	  	System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Desktop\\job\\selenium2021\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/login");
		
		
	}
	@When("user enter username tomsmith and password SuperSecretPassword!")
	public void user_enter_username_tomsmith_and_password_super_secret_password() {
		System.out.println("--------- When ----------");
		login = new LoginPage(driver);
		login.username_locate("tomsmith");
		login.password_locate("SuperSecretPassword!");
		login.button_locate();
	
	}
	@Then("user logins with message You logged into a secure area!")
	public void user_logins_or_fails_with_message_you_logged_into_a_secure_area() {		
		String outputMessage = "You logged into a secure area!";
		String actualStr = login.login_displayed();
		System.out.println("actual = " + actualStr);
		System.out.println("expected string = " + outputMessage);	
		
		// code to overcome space and * found at the end of actual_string
		String modActualString = actualStr.substring(0,(actualStr.length()-2));
		Assert.assertEquals(outputMessage,modActualString);
		driver.quit();
	}
	
	@When("user enter username wronguser and password wrongpassword")
	public void user_enter_username_wronguser_and_password_wrongpassword() {
		login = new LoginPage(driver);
		login.username_locate("wrongadmin");
		login.password_locate("wrongpasswd");
		login.button_locate();
	
	}

	@Then("user logins or fails with message Your username is invalid!")
	public void user_logins_or_fails_with_message_your_username_is_invalid() {
		String outputMessage = "Your username is invalid!";
		String actualStr = login.login_displayed();
		System.out.println("actual = " + actualStr);
		System.out.println("expected string = " + outputMessage);	
		
		// code to overcome space and * found at the end of actual_string
		String modActualString = actualStr.substring(0,(actualStr.length()-2));
		Assert.assertEquals(outputMessage,modActualString);
		driver.quit();
	}

	@When("user enter username wronguser and password SuperSecretPassword!")
	public void user_enter_username_wronguse_and_password_super_secret_password() {
		System.out.println("--------- When 3----------");
		login = new LoginPage(driver);
		login.username_locate("wrongadmin");
		login.password_locate("SuperSecretPassword!");
		login.button_locate();
	    
	}

	@When("user enter username tomsmith and password wrongpassword")
	public void user_enter_username_tomsmith_and_password_wrongpassword() {
	
		login = new LoginPage(driver);
		login.username_locate("tomsmith");
		login.password_locate("wrongpassword");
		login.button_locate();
	}

	@Then("user logins or fails with message Your password is invalid!")
	public void user_logins_or_fails_with_message_your_password_is_invalid() {
		String outputMessage = "Your password is invalid!";
		String actualStr = login.login_displayed();
		System.out.println("actual = " + actualStr);
		System.out.println("expected string = " + outputMessage);	
		
		// code to overcome space and * found at the end of actual_string
		String modActualString = actualStr.substring(0,(actualStr.length()-2));
		Assert.assertEquals(outputMessage,modActualString);
		driver.quit();;
	   
	} 

}
