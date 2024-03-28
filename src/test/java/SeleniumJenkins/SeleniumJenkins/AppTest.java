package SeleniumJenkins.SeleniumJenkins;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	@Test(dataProvider="testdata")
	public void validateLoginTC(String u,String p) {
		System.setProperty("webdriver.chrome.driver","G:\\worldline\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		WebElement ur = driver.findElement(By.name("user-name"));
		ur.sendKeys(u);
		WebElement ps = driver.findElement(By.name("password"));
		ps.sendKeys(p);
		WebElement l = driver.findElement(By.name("login-button"));
		l.click();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		driver.quit();
		
	}
	@DataProvider(name = "testdata")
	public Object[][] loginTC(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
		};
	}
}
