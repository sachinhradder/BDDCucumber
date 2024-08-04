package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.Common_Actions;
import actions.EbayHome_Actions;
import elements.EbayHome_Elements;

public class Ebay_Home_steps {
	
	EbayHome_Actions ebayhome_actions;
	Common_Actions common_actions;
	
	public Ebay_Home_steps(EbayHome_Actions ebayhome_actions, Common_Actions common_actions) {
		this.common_actions = common_actions;
		this.ebayhome_actions = ebayhome_actions;
	}
	
	@Given("I am on Ebay Home Page")
	public void i_am_on_ebay_home_page() {
		//driver.get("https://www.ebay.com/");
		common_actions.goToUrl("https://www.ebay.com/");
	}

	@When("I click on Advanced Link")
	public void i_click_on_advanced_link() {
		//driver.findElement(By.xpath("//a[@id='gh-as-a']")).click(); 
		ebayhome_actions.clickAdvancedlink();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_advanced_search_page() {
		String expectedurl = "https://www.ebay.com/sch/ebayadvsearch";
		String actualurl = common_actions.getCurrentPageUrl();
		if(!expectedurl.equals(actualurl)){
		fail("Page doesn't navigated to expected page");	
	}
}
	@Given("I am on Ebay Home Page for iphone search")
	public void i_am_on_ebay_home_page_for_iphone_search() {
//		driver = new ChromeDriver();
//		driver.get("https://www.ebay.com/");
		common_actions.goToUrl("https://www.ebay.com/");
	}
	
	@When("I search for {string}")
	public void i_search_for_iphone(String str1) throws InterruptedException{
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
		ebayhome_actions.searchAnItem(str1);
		//driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}

	@Then("I validate atlease {int} search itmes present")
	public void i_validate_atlease_search_itmes_present(int count){
		int itemcount = ebayhome_actions.getSearchItemsCount();
		if(!(itemcount>count))
		{
			fail("Less than 1000 results shown");
		}
	}
	
	@When("I search for {string} in {string} category")
	public void i_search_for_in_category(String string, String string2) throws InterruptedException {
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
		ebayhome_actions.searchAnItem(string);
		ebayhome_actions.selectCategoryOptions(string2);
		ebayhome_actions.clickSearchButton();
//		driver.findElement(By.xpath("//select[@id='gh-cat']")).click();
//		List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
//		for(WebElement x: cat) {
//			if(x.getText().trim().toLowerCase().equals(string2.toLowerCase())) {
//				x.click();
//				break;
//			}
//		}
//		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(1000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) throws InterruptedException {
		//driver.findElement(By.linkText(string)).click();
		ebayhome_actions.clickOnLinkByText(string);
	   Thread.sleep(2000);
	}

	@Then("I validate that page navigates to {string} and titile contains {string}")
	public void i_validate_that_page_navigates_to_and_titile_contains(String url, String title) {
		String actualurl = common_actions.getCurrentPageUrl();
		String actualtitle = common_actions.getCurrentPageTitle();
		if (!actualurl.equals(url)) {
			fail("Page does not navigate to expected url: "+ url);
		}
		if(!actualtitle.contains(actualtitle))
		{
			fail("title mismatch");
		}
	    
	}

}









