package TestFolders;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import Resources.JDBC_Connector;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class GetDataFromDB {
	WebDriver driver;
  @Test(dataProvider = "getData")
  public void Test(String username, String password) {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.loginIntoApplication(username, password);
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.manage().window().maximize();
	  driver.get("https://crio-qkart-frontend-qa.vercel.app/login");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] getData() throws SQLException {
	 return JDBC_Connector.connect("TDQKart");
  }

}
