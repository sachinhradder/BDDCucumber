package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearch_Elements {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@id='gh-la']//*[name()='svg']") public WebElement ebayLogo;
	@FindBy(xpath = "//input[@id='_nkw']") public WebElement searchString;
	@FindBy(xpath = "//input[@id='_ex_kw']") public WebElement excludeString;
	@FindBy(xpath = "//*[text()='Min price']") public WebElement minPrice;
	@FindBy(xpath = "//*[text()='Max price']") public WebElement maxPrice;
	@FindBy(xpath = "//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']") public WebElement searchBtn;

	
	public EbayAdvancedSearch_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
