package commonRepository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonMethods {

	protected static Select dropdown;

	public static void dropDownSelection(WebElement p_DropDownElementName,
			WebElement p_DropDownSelectionWebElementName,
			String p_DropDownSelectionClassName, String p_DropDownOptionName) throws InterruptedException {
		p_DropDownElementName.click();
		Thread.sleep(3000);
		List<WebElement> dropdownObj = p_DropDownSelectionWebElementName
				.findElements(By.className(p_DropDownSelectionClassName));
		for (WebElement dropDownValue : dropdownObj) // For each value retrieved
			// check if it matches
			// with our expected
			// value to be clicked
			// 'organizationTypeValue'
		{
			if (dropDownValue.getText().equals(p_DropDownOptionName)) {
				Thread.sleep(2000);
				dropDownValue.click();
				break;
			}
		}

	}

	public static void selectAnOptionFromOptionList(WebElement p_WebElement, String p_OptionValue) throws InterruptedException{
		dropdown = new Select(p_WebElement);		
		dropdown.selectByVisibleText(p_OptionValue);
		Thread.sleep(3000);
	}

	public static void selectElementFromList(List<WebElement> p_list, String p_WebelementName) throws InterruptedException{
		Iterator<WebElement> itr = p_list.iterator();
		while(itr.hasNext()){
			WebElement itemList = itr.next();
			//System.out.println("itr.next() " + itemList.getText());
			if((itemList.getText().toUpperCase().trim()).contains(p_WebelementName.toUpperCase().trim())){
				Thread.sleep(2000);
				itemList.click();
				Thread.sleep(4000);
				break;				
			}

		}
	}

	public static void waitWhileElementHasAttributeValue(WebDriver driver, String locator, String attribute, String value) {
		while(!driver.findElement(commonMethods.getLocatorMethod(locator)).getAttribute(attribute).contains(value)) {
			int timeout = 10;
			if(timeout > 0) {
				timeout--;
				try {
					//System.out.println(attribute + "\t" + value);
					Thread.sleep(1000);
				} catch(Exception e) {

				}
			}
		}
	}

	public static By getLocatorMethod(String locatorMethod) {
		String locator = locatorMethod.split("=", 2)[1];

		if (locatorMethod.startsWith("id")) {
			return By.id(locator);
		} else if (locatorMethod.startsWith("name")) {
			return By.name(locator);
		} else if (locatorMethod.startsWith("css")) {
			return By.cssSelector(locator);
		} else if (locatorMethod.startsWith("xpath")) {
			return By.xpath(locator);
		} else if (locatorMethod.startsWith("class")) {
			return By.className(locator);
		} else if (locatorMethod.startsWith("linkText")) {
			return By.linkText(locator);
		} else if (locatorMethod.startsWith("partialLinkText")) {
			return By.partialLinkText(locator);
		} else if (locatorMethod.startsWith("tagName")) {
			return By.tagName(locator);
		} else {
			return null;
		}

	}


}
