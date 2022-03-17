package adact.pomtask;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.pomtask.BaseClass;

public class AdactRun extends BaseClass {
	
@BeforeClass

public static void beforeClass() {
		getDriver();
		goToUrl("https://adactinhotelapp.com/");
		maximize();

}

@AfterClass
public static void afterClass() {
closeAllWindows();
}

@Test
public void adactAllTest() throws IOException, InterruptedException {
	
	// Loginpage
	
LoginPage loginpage = new LoginPage();

String userName = getData("sheet1", 1, 0);

String password = getData("sheet1", 1, 1);

loginpage.login(userName, password);

	// search Hotels

SearchHotelPage searchHotel = new SearchHotelPage();

String location = getData("sheet1", 1, 2);
String hotels = getData("sheet1", 1, 3);
String roomType = getData("sheet1", 1, 4);
String roomNos = getData("sheet1", 1, 5);
String checkInDate = getData("sheet1", 1, 6);
String checkOutDate = getData("sheet1", 1, 7);
String adultsPerRoom = getData("sheet1", 1, 8);
String childPerRoom = getData("sheet1", 1, 9);


searchHotel.searchHotel(location, hotels, roomType, roomNos, checkInDate, checkOutDate, adultsPerRoom, childPerRoom);


// Select Hotel

SelectHotelPage selectHotel = new SelectHotelPage();

selectHotel.selectHotel();

// Book Hotel

BookHotelPage bookHotel = new BookHotelPage();

String firstName = getData("sheet1", 1, 10);
String lastName = getData("sheet1", 1, 11);
String address = getData("sheet1", 1, 12);
String ccNum = getData("sheet1", 1, 13);
String ccType = getData("sheet1", 1, 14);
String expMonth = getData("sheet1", 1, 15);
String expYear = getData("sheet1", 1, 16);
String cvv = getData("sheet1", 1, 17);


bookHotel.bookHotel(firstName, lastName, address, ccNum, ccType, expMonth, expYear, cvv);

// booking Confirmation page

ConfirmBookingPage confirmBook = new ConfirmBookingPage();



confirmBook.confirmBooking();

// Cancel Booking page

CancelHotelPage cancelHotel = new CancelHotelPage();

cancelHotel.CancelHotel();


System.out.println("Test purpose");

}


}
