package adact.pomtask;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.pomtask.BaseClass;

public class ConfirmBookingPage extends BaseClass {
	
	public ConfirmBookingPage() {
		
		PageFactory.initElements(driver, this);


	}
	
@FindBy(id="order_no")
private WebElement orderId; 

@FindBy(id="my_itinerary")
private WebElement myItinerary;

public WebElement getOrderId() {
	return orderId;
}

public WebElement getMyItinerary() {
	return myItinerary;
} 


public void confirmBooking() throws IOException, InterruptedException {
	
	Thread.sleep(6000);
	
	String ConfirmOrderId = getAttribute(getOrderId());
	
	System.out.println("The confirmed booking Id is "+ConfirmOrderId);
	
	writeData("sheet1", 1, 18, ConfirmOrderId);
	
	click(getMyItinerary());
	

}




}
