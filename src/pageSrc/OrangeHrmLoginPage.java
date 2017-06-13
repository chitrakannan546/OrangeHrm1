package pageSrc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLoginPage {
	
		protected WebDriver driver;
		
		public OrangeHrmLoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);		
		}

		@FindBy(id="txtUsername")
		private WebElement w_EmailId;
		
		@FindBy(id="txtPassword")
		private WebElement w_Password;
		
		@FindBy(id="btnLogin")
		private WebElement w_Login_Btn;
		
		public void setEmailId(String p_EmailId) {
			this.w_EmailId.sendKeys(p_EmailId); ;
		}	
		
		public void setPassword(String p_Password) {
			this.w_Password.sendKeys(p_Password); ;
		}
		
		public void clickLoginBtn(){
			this.w_Login_Btn.click();
		}
		
		public void login(String p_EmailId, String p_Password) throws InterruptedException{
			this.setEmailId(p_EmailId); 
			this.setPassword(p_Password);
			Thread.sleep(2000);
			this.clickLoginBtn();
		}
		
	}