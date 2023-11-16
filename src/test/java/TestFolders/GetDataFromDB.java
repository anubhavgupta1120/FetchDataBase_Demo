package TestFolders;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Resources.JDBC_Connector;

public class GetDataFromDB {
	WebDriver driver;

	@Test(dataProvider = "getData")
	public void Test(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIntoApplication(username, password);
//		Thread.sleep(5000);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://crio-qkart-frontend-qa.vercel.app/login");
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws SQLException {
		return JDBC_Connector.connect("TDQKart");
	}

}
