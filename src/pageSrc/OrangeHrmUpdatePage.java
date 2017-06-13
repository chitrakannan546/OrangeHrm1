package pageSrc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import commonRepository.commonMethods;
import pageSrc.OrangeHrmLoginPage;

public class OrangeHrmUpdatePage {

	protected WebDriver driver;
	WebDriverWait wait;
	
	public OrangeHrmUpdatePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Personal Details")
	private WebElement w_PersonalDetails;
	
	@FindBy(id="personal_txtEmpFirstName")
	private WebElement w_EmpFirstName;
	
	@FindBy(id="personal_txtEmpMiddleName")
	private WebElement w_EmpMiddleName;
	
	@FindBy(id="personal_txtEmpLastName")
	private WebElement w_EmpLastName;
	
	@FindBy(id="personal_txtOtherID")
	private WebElement w_OtherID;
	
	@FindBy(id="personal_txtLicExpDate")
	private WebElement w_LicExpDate;
	
	@FindBy(id="personal_cmbMarital")
	private WebElement w_Marital_DropDown;
	
	@FindBy(xpath="//form[@id='frmEmpPersonalDetails']/fieldset/ol[3]/li[2]/select")
	private WebElement w_Marital_DropDown_Option;
	
	@FindBy(id="personal_optGender_1")
	private WebElement w_Gender_1_Male;
	
	@FindBy(id="personal_optGender_2")
	private WebElement w_Gender_2_Female;
	
	@FindBy(id="personal_cmbNation")
	private WebElement w_Nation_DropDown;
	
	@FindBy(xpath="//form[@id='frmEmpPersonalDetails']/fieldset/ol[3]/li[3]/select")
	private WebElement w_Nation_DropDown_Option;
		
	@FindBy(id="btnSave")
	private WebElement w_SaveBtn;	
	
	
		
		
	public void clickPersonalDetails(){
		this.w_PersonalDetails.click();
	}
	
	/*public void setEmpFirstName(String p_EmpFirstName){
		this.w_EmpFirstName.sendKeys(p_EmpFirstName);
	}*/
	
	public void setEmpMiddleName(String p_EmpMiddleName){
		this.w_EmpMiddleName.sendKeys(p_EmpMiddleName);
	}
	
	/*public void setEmpLastName(String p_EmpLastName){
		this.w_EmpFirstName.sendKeys(p_EmpLastName);
	}*/
	
	public void setOtherID(String p_OtherID){
		this.w_OtherID.sendKeys(p_OtherID);
	}
	
	public void setLicExpDate(String p_LicExpDate){
		this.w_LicExpDate.sendKeys(p_LicExpDate);
	}
	
	/*public void setMale(String p_Gender_1_Male){
		this.w_Gender_1_Male.sendKeys(p_Gender_1_Male);
	}*/
	
	/*public void setFemale(String p_Gender_2_Female){
		this.w_Gender_2_Female.sendKeys(p_Gender_2_Female);
	}*/
	
	
		
	public void selectMaritalDropdownOption(String p_Marital_DropDown) throws InterruptedException {		
		 WebDriverWait wait = new WebDriverWait(driver, 120);
		    /* Wait for one element to be available
		    wait.until(new Predicate<WebDriver>() {
		        @Override public boolean apply(WebDriver driver) {
		            return driver.findElements(By.xpath("//form[@id='frmEmpPersonalDetails']/fieldset/ol[3]/li[2]/select")).size() > 0;
		        }
		    }); */  
		
		commonMethods.dropDownSelection(w_Marital_DropDown,
				w_Marital_DropDown_Option, "active-result",
				p_Marital_DropDown);
	}
	
	
	public void selectNationDropDownOption(String p_Nation_DropDown) throws InterruptedException {		
		 WebDriverWait wait = new WebDriverWait(driver, 120);
		    /* Wait for one element to be available
		    wait.until(new Predicate<WebDriver>() {
		        @Override public boolean apply(WebDriver driver) {
		            return driver.findElements(By.xpath("//form[@id='frmEmpPersonalDetails']/fieldset/ol[3]/li[3]/select")).size() > 0;
		        }
		    });  */ 
		
		commonMethods.dropDownSelection(w_Nation_DropDown,
				w_Nation_DropDown_Option, "active-result",
				p_Nation_DropDown);
	}
	
	
	public void clickSaveChangesBtn(){
		this.w_SaveBtn.click();
	}
		
	
	
	
}
