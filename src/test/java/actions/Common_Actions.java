package actions;

import org.openqa.selenium.WebDriver;

import steps.Common_steps;

public class Common_Actions {
	
	 
	private WebDriver driver;
	
	public Common_Actions(Common_steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	public void goToUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	public void quitWebDriver() {
		driver.quit();
	}

}
