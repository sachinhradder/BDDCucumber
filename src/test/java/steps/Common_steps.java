package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;

public class Common_steps {

	
	private WebDriver driver;
	
	@Before(order = 0) // these are  hooks in cucumber it works same as @before method in testNG.
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Global Before Hook Executed");
	}
	
	@After (order = 1)
	public void tearDown(Scenario scenario) throws InterruptedException {
		if(scenario.isFailed())
		{
			//Takes the screenshot
			final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
			//scenario.embed(scr, "image/png", scenario.getName());
 		}
		driver.quit();
		Thread.sleep(1000);
		System.out.println("Global After Hook Executed");
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
}


/* @Before hook gets executed before executing each scenario it is on global level, and after the execution of each scenario
the after hook will get executed.*/