package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Tagged_Hooks {
	
	private WebDriver driver;
	
	@Before(value = "@setCookies", order = 1) // Scenario specific hook
	public void setCookies() {
		System.out.println("Scenario specific hook - setCookies executed");
	}
	
	@After(value = "@Test", order = 0)
	public void testafterhook() {
		System.out.println("Scenario specific hook - testAfterHook executed");
	}
	
	public Tagged_Hooks(Common_steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	

}
