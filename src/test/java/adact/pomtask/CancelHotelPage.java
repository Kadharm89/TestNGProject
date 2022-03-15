package adact.pomtask;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.pomtask.BaseClass;

public class CancelHotelPage extends BaseClass {
	
	public CancelHotelPage() {

		PageFactory.initElements(driver, this);

	}
	
@FindBy(id="order_id_text")
private WebElement ordIdTxt;

@FindBy(id="search_hotel_id")
private WebElement srchBtn;

@FindBy(xpath="//input[contains(@value, 'Cancel')]")
private WebElement cancelBtn;


public WebElement getOrdIdTxt() {
	return ordIdTxt;
}

public WebElement getSrchBtn() {
	return srchBtn;
}


public WebElement getCancelBtn() {
	return cancelBtn;
}

public void CancelHotel() throws IOException {



String cancelOrdId = getData("sheet1", 1, 18);
passingText(getOrdIdTxt(), cancelOrdId);

click(getSrchBtn());

click(getCancelBtn());

alert();

System.out.println("The orderId"+ cancelOrdId +"cancelled successfully ");



}








}
