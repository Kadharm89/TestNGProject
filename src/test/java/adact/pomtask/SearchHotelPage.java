package adact.pomtask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.pomtask.BaseClass;

public class SearchHotelPage extends BaseClass {
	
public SearchHotelPage() {
	PageFactory.initElements(driver, this);
}
	
@FindBy(id="location")
private WebElement dDnLocation;

@FindBy(id="hotels")
private WebElement dDnHotels;

@FindBy(id="room_type")
private WebElement dDnRoomType;

@FindBy(id="room_nos")
private WebElement dDnRoomNos;

@FindBy(id="datepick_in")
private WebElement txtCheckInDate;

@FindBy(id="datepick_out")
private WebElement txtCheckOutDate;

@FindBy(id="adult_room")
private WebElement dDnAdultsPerRoom;


@FindBy(id="child_room")
private WebElement dDnChildrenPerRoom;

@FindBy(id="Submit")
private WebElement btnSubmit;

public WebElement getdDnLocation() {
	return dDnLocation;
}

public WebElement getdDnHotels() {
	return dDnHotels;
}

public WebElement getdDnRoomType() {
	return dDnRoomType;
}

public WebElement getdDnRoomNos() {
	return dDnRoomNos;
}

public WebElement getTxtCheckInDate() {
	return txtCheckInDate;
}

public WebElement getTxtCheckOutDate() {
	return txtCheckOutDate;
}

public WebElement getdDnAdultsPerRoom() {
	return dDnAdultsPerRoom;
}

public WebElement getdDnChildrenPerRoom() {
	return dDnChildrenPerRoom;
}

public WebElement getBtnSubmit() {
	return btnSubmit;
}


public void searchHotel(String location, String hotels, String roomType, String roomNos, String checkInDate, String checkOutDate, String adultsPerRoom, String childPerRoom) {
	
	selectOptionbyText(getdDnLocation(), location);
	selectOptionbyText(getdDnHotels(), hotels);
	selectOptionbyText(getdDnRoomType(), roomType);
	selectOptionbyValue(getdDnRoomNos(), roomNos);
	passingText(getTxtCheckInDate(), checkInDate);
	passingText(getTxtCheckOutDate(), checkOutDate);
	selectOptionbyValue(getdDnAdultsPerRoom(), adultsPerRoom );
	selectOptionbyValue(getdDnChildrenPerRoom(), childPerRoom );
	click(getBtnSubmit());
	
	
	

}







}
