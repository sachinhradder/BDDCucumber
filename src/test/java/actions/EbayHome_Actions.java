package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.EbayHome_Elements;
import steps.Common_steps;

public class EbayHome_Actions {

	
	private WebDriver driver;
	
	EbayHome_Elements ebayhome_elements;
	
	public EbayHome_Actions(Common_steps common_steps) {
		this.driver = common_steps.getDriver();
		ebayhome_elements = new EbayHome_Elements(driver);
	}
	
	public void clickAdvancedlink() {
		ebayhome_elements.advancedLink.click();
	}
	
	public void searchAnItem(String srchString) {
		ebayhome_elements.searchBox.sendKeys(srchString);
	}
	
	public void clickSearchButton() {
		ebayhome_elements.searchButton.click();
	}
	
	public int getSearchItemsCount() {
		String itemcount = ebayhome_elements.numOfItems.getText().trim();
		String itemcount2 = itemcount.replace(",", "");
		int itemCountInt  = Integer.parseInt(itemcount2);
		return itemCountInt;
	}
	
	public void selectCategoryOptions(String option) {
		List<WebElement> cat = ebayhome_elements.catOptions;
		for(WebElement x: cat) {
			if(x.getText().trim().toLowerCase().equals(option.toLowerCase())) {
				x.click();
				break;
	}
	}
	}
	
	public void clickOnLinkByText(String Text) {
		driver.findElement(By.linkText(Text)).click();
	}
}
