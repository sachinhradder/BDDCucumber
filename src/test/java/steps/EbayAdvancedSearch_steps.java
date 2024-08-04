package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Actions;

public class EbayAdvancedSearch_steps {
	
	Common_Actions common_actions;
	EbayAdvancedSearch_Actions ebayadvancedsearch_actions;
	
	public EbayAdvancedSearch_steps(Common_Actions common_actions, EbayAdvancedSearch_Actions ebayadvancedsearch_actions) {
		this.common_actions = common_actions;
		this.ebayadvancedsearch_actions = ebayadvancedsearch_actions;
		
	}

	@Given("I am on Ebay Advanced Search Page")
	public void i_am_on_ebay_advanced_search_page() {
		common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
		//driver.get("https://www.ebay.com/sch/ebayadvsearch");
	}

	@When("I click on Ebay Logo")
	public void i_click_on_ebay_logo() {
		//driver.findElement(By.xpath("//a[@id='gh-la']//*[name()='svg']")).click();
		ebayadvancedsearch_actions.clickOnEbayLogo();
	}

	@Then("I am navigated to Ebay Home Page")
	public void i_am_navigated_to_ebay_home_page() {
	   String expurl = "https://www.ebay.com/";
	   String acturl = common_actions.getCurrentPageUrl();
	   if(!expurl.equals(acturl)){
		   
		   fail("page doesn't navigated to ebay home page");
	   }
	}	
	
	@When("I advanced Search an iterm")
	public void i_advanced_search_an_iterm(DataTable dataTable) throws InterruptedException { 
	  // driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
		ebayadvancedsearch_actions.enterSearchString(dataTable.cell(1, 0));
//	   driver.findElement(By.xpath("((//input[@id='_ex_kw']")).click();
	   //driver.findElement(By.xpath("((//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
		ebayadvancedsearch_actions.enterExcludeString(dataTable.cell(1, 1));
	  // driver.findElement(By.xpath("//*[text()='Min price']")).sendKeys(dataTable.cell(1, 2));
		ebayadvancedsearch_actions.enterMinPrice((dataTable.cell(1, 2)));
	   //driver.findElement(By.xpath("//*[text()='Max price']")).sendKeys(dataTable.cell(1, 3));
		ebayadvancedsearch_actions.enterMaxPrice(dataTable.cell(1, 3));
	   //driver.findElement(By.xpath("//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']")).click();
		ebayadvancedsearch_actions.clickOnSearchButton();
	   Thread.sleep(3000);
	}

}
