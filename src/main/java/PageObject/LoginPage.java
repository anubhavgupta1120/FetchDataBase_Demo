package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using = "username")
	private WebElement usernameElement;
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordElement;
	@FindBy(how = How.XPATH, using = "//button[text() = 'Login to QKart']")
	private WebElement login;
	
	
	public void loginIntoApplication(String username, String password) {
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		login.click();
	}
}
