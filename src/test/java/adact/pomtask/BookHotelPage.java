package adact.pomtask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.pomtask.BaseClass;

public class BookHotelPage extends BaseClass {
	
public BookHotelPage() {	
	
	PageFactory.initElements(driver, this);
}
	
@FindBy(id="first_name")
private WebElement txtFirstName;

@FindBy(id="last_name")
private WebElement txtLastName;

@FindBy(id="address")
private WebElement txtAddress;

@FindBy(id="cc_num")
private WebElement txtCcNum;

@FindBy(id="cc_type")
private WebElement dDnCcType;

@FindBy(id="cc_exp_month")
private WebElement dDnExpMonth;

@FindBy(id="cc_exp_year")
private WebElement dDnExpYear;

@FindBy(id="cc_cvv")
private WebElement txtCvv;

@FindBy(id="book_now")
private WebElement btnBookNow;


public WebElement getTxtFirstName() {
	return txtFirstName;
}

public WebElement getTxtLastName() {
	return txtLastName;
}

public WebElement getTxtAddress() {
	return txtAddress;
}

public WebElement getTxtCcNum() {
	return txtCcNum;
}

public WebElement getdDnCcType() {
	return dDnCcType;
}

public WebElement getdDnExpMonth() {
	return dDnExpMonth;
}

public WebElement getdDnExpYear() {
	return dDnExpYear;
}

public WebElement getTxtCvv() {
	return txtCvv;
}

public WebElement getBtnBookNow() {
	return btnBookNow;
}




public void bookHotel(String firstName, String lastName, String address, String ccNum, String ccType, String expMonth, String expYear, String cvv) {
	
	passingText(getTxtFirstName(), firstName);
	passingText(getTxtLastName(), lastName);
	passingText(getTxtAddress(), address);
	passingText(getTxtCcNum(), ccNum);
	selectOptionbyValue(getdDnCcType(), ccType);
	selectOptionbyValue(getdDnExpMonth(), expMonth);
	selectOptionbyText(getdDnExpYear(), expYear);
	passingText(getTxtCvv(), cvv);
	click(getBtnBookNow());




	
	
}

}

