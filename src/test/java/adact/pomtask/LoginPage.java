package adact.pomtask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.pomtask.BaseClass;

public class LoginPage extends BaseClass {

public LoginPage() {
	PageFactory.initElements(driver, this);
}
	
	
@FindBy(id="username")
private WebElement txtUserName;

@FindBy(id="password")
private WebElement txtPassword;

@FindBy(id="login")
private WebElement txtBtnLogin;

public WebElement getTxtUserName() {
	return txtUserName;
}

public WebElement getTxtPassword() {
	return txtPassword;
}

public WebElement getTxtBtnLogin() {
	return txtBtnLogin;
}

public void login(String userName, String password) {
	
	passingText(getTxtUserName(), userName);
	passingText(getTxtPassword(), password);
	click(getTxtBtnLogin());
	
}





}
