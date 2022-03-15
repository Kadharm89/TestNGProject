package adact.pomtask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.pomtask.BaseClass;

public class SelectHotelPage extends BaseClass {
	
public SelectHotelPage() {
	
	PageFactory.initElements(driver, this);	
		
	}
	
@FindBy(id="radiobutton_0")
private WebElement radioElement;

@FindBy(id="continue")
private WebElement btnContinue;



public WebElement getRadioElement() {
	return radioElement;
}



public WebElement getBtnContinue() {
	return btnContinue;
}



public void selectHotel() {
	
	click(getRadioElement());
	
	click(getBtnContinue());
	
	
}



}
