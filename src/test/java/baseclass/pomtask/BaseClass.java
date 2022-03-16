package baseclass.pomtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
	
	// 1. Launch Browser
	
	public static void getDriver() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();	
		
	}
	
	// 2. Go to url
	
	public static void goToUrl(String url) {
		
		driver.get(url);
	}
	
	//3. Get Current URL 
	
	public String getCurrentUrl() {
		
		String currentUrl = driver.getCurrentUrl();
		
		return currentUrl;
	}
	//4. get Title
	
	public String getTitle() {
		
		String title = driver.getTitle();
		
		return title;		

	
	}
	
	
	// 5. get Text
	
	public String getText(WebElement element) {
	
		String text = element.getText();
		
		return text;

	}
	
	// 6. Get Atttribute
	
	public String getAttribute(WebElement element) {
		
		String attribute = element.getAttribute("value");
		
		return attribute;

	}
	
	// 7. get attribute by passing value also
	
	public String getAttribute(WebElement element, String attributeName) {
		
		String attribute = element.getAttribute(attributeName);
		
		return attribute;
	}
	
	
	// 8. To get Web Element by id 
	
	public WebElement findElementById(String idAttribute) {
		WebElement element = driver.findElement(By.id(idAttribute));
		
		return element;

	}
	
	// 9. To get Web Element by Name
	
	public WebElement findElementByName(String nameAttribute) {
		
			WebElement element = driver.findElement(By.name(nameAttribute));
			
			return element;
	}
	
	// 10. To get WebEleemt by ClassName 
	
	public WebElement findElementByClassName(String classAttribute) {
		
		WebElement element = driver.findElement(By.className(classAttribute));
		
		return element;
}
	
	// 11. TO get Webelement by Xpath
	
	public WebElement findElementByXpath(String xpathAttribute) {
		
		WebElement element = driver.findElement(By.xpath(xpathAttribute));
		
		return element;

	}
	
	// 12. Maximize
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	// 13. passing text using sendkeys
	
	public void passingText(WebElement element, String text ) {
			element.sendKeys(text);
	}
	
	// 14. click
	
	public void click(WebElement element) {
		element.click();
}
	
	// 15. Dropdown select by text
	
	public void selectOptionbyText(WebElement element, String text) {

		Select select = new Select(element);
		
		select.selectByVisibleText(text);
	}	
	
	// 15. Dropdown select by Index
	
		public void selectOptionbyText(WebElement element, int index ) {

			Select select = new Select(element);
			
			select.selectByIndex(index);
		}	
	
	// 15. Dropdown select by value
		
		public void selectOptionbyValue(WebElement element, String attributeValue ) {

			Select select = new Select(element);
				
			select.selectByValue(attributeValue);
			}
	
		// 16. Dropdown deselect by text
		
		public void deselectOptionbyText(WebElement element, String text) {

			Select select = new Select(element);
			
			select.deselectByVisibleText(text);
		}	
		
		// 17. Dropdown select by Index
		
			public void deselectOptionbyText(WebElement element, int index ) {

				Select select = new Select(element);
				
				select.deselectByIndex(index);
			}	
		
		// 18. Dropdown deselect by value
			
			public void deselectOptionbyValue(WebElement element, String attributeValue ) {

				Select select = new Select(element);
					
				select.deselectByValue(attributeValue);
	
			}
			
		// 19. Deselect all 
			
			public void deselectAll(WebElement element) {
				Select select = new Select(element);
				select.deselectAll();
				
			}
	
		// 20. TO get all dropdown options as list
			
			public List<WebElement> getOptions(WebElement element) {
				
				Select select = new Select(element);
				
				List<WebElement> options = select.getOptions();
				
				return options;

			}
			
		// 21. to Print all dropdown options
			
			public void printOptions(WebElement element) {
				
				Select select = new Select(element);
				
				List<WebElement> options = select.getOptions();
				
				for (int i = 0; i < options.size(); i++) {
					
					WebElement element2 = options.get(i);
					
					String text = element2.getText();
					
					System.out.println(text);
				}
			
				}

		// 22. Select all options using Index
			
			public void selectAll(WebElement element) {
				
			Select select = new Select(element);
			
			List<WebElement> options = select.getOptions();
			
			for (int i = 0; i < options.size(); i++) {
				
				select.selectByIndex(i);
			}

			}
			
			// 23. Select all options using text
			
			public void selectAllBytext(WebElement element) {
							
			Select select = new Select(element);
						
			List<WebElement> options2 = select.getOptions();
						
				for (WebElement webElement : options2) {
							
				String text = webElement.getText();
							
				select.selectByVisibleText(text);	
							
				}		
			}
			
			
	// 24. take screenshot
			
			public void takeScreenshot(String destination) throws IOException {
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				
				File s = screenshot.getScreenshotAs(OutputType.FILE);
				
				File d = new File(destination);
				
				FileUtils.copyFile(s, d);
				

			}
			
	// 25. Taking screenshot for particular locator or element
			
			public void takeScreenshotForElement(WebElement element, String destination) throws IOException {

				File s = element.getScreenshotAs(OutputType.FILE);
				
				File d = new File(destination);
				
				FileUtils.copyFile(s, d);
				
				
			}
	//26. create cell and insert the value by passing sheetName, rowNo, Cell no, as paramters
	
			public void writeData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
				

				File file = new File("C:\\Users\\KADHAR\\eclipse-workspace\\MavenTestProject6\\Book\\adact.xlsx");
				
				FileInputStream  stream = new FileInputStream(file);
				
				Workbook workbook = new XSSFWorkbook(stream);
				
				Sheet sheet = workbook.getSheet(sheetName);
				
				Row row = sheet.getRow(rowNum);
				
				Cell cell = row.createCell(cellNum);

				cell.setCellValue(data);
				
				FileOutputStream out = new FileOutputStream(file);
				
				workbook.write(out);
				
			}
					
			
	//27. update the cell value by passing sheet name, row no, cell no as parameters 		
			
public void updateData(String sheetName, int rowNum, int cellNum, String oldData, String newData) throws IOException {
				
				File file = new File("C:\\Users\\KADHAR\\eclipse-workspace\\MavenTestProject6\\Book\\adact.xlsx");
				
				FileInputStream  stream = new FileInputStream(file);
				
				Workbook workbook = new XSSFWorkbook(stream);
				
				Sheet sheet = workbook.getSheet(sheetName);
				
				Row row = sheet.getRow(rowNum);
				
				Cell cell = row.getCell(cellNum);
				
				String cellValue = cell.getStringCellValue();
			
				if (cellValue.equals(oldData)) {
					
					cell.setCellValue(newData);
							
				} else {
					
					System.out.println("Enter valid data");
				}
			FileOutputStream out = new FileOutputStream(file);
			
			workbook.write(out);

			}
			
//28. Get cell value as string by passing sheetName, rowNum, cellNum, as parameters

public String getData(String sheetName, int rowNum, int cellNum) throws IOException {
	
	String data = null;
			 
	File file = new File("C:\\Users\\KADHAR\\eclipse-workspace\\MavenTestProject6\\Book\\adact.xlsx");
	
	FileInputStream  stream = new FileInputStream(file);
	
	Workbook workbook = new XSSFWorkbook(stream);
	
	Sheet sheet = workbook.getSheet(sheetName);
	
	Row row = sheet.getRow(rowNum);
	
	Cell cell = row.getCell(cellNum);
	
	CellType cellType = cell.getCellType();
	
	//System.out.println(cellType);
	
	switch (cellType) {
	case STRING:
		data = cell.getStringCellValue();
		
		break;
		
		
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			
			Date dateCellValue = cell.getDateCellValue();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			
			data = dateFormat.format(dateCellValue);
			
			
		}
		else {
			
			double cellValue = cell.getNumericCellValue();
			
			data =new DecimalFormat("").format(cellValue).toString().replaceAll(",", "");;
			
			//System.out.println(data);
		
		}
		
		break;
	}
	
	return data;
				
	}
	
//29. Switch to frames by frame id

public void frameById(String frameId) {
	driver.switchTo().frame(frameId);

}

//30. Switch to frames by frame id

public void frameByName(String frameName) {
	driver.switchTo().frame(frameName);

}

//29. Switch to frames by webElement

public void frameByWebElement(WebElement element) {

	driver.switchTo().frame(element);

}

//30. Switch to frames by Index

public void frameByIndex(String frameId) {
	driver.switchTo().frame(frameId);

}

//31. To get frame count

public int frameCount(String frameName) {
	List<WebElement> findElements = driver.findElements(By.tagName(frameName));
	
	int frameCount = findElements.size();

	return frameCount;
}
			
// 32. TO return from frame

 public void returnFromFrame() {
	driver.switchTo().defaultContent();

}
 
 public void alert() {
	 
	Alert al = driver.switchTo().alert();
	al.accept();
 }
			
public static void closeAllWindows() {
driver.quit();
			}


// Window Handling

// get parent window id 

public String parentWindow() {
 String parent = driver.getWindowHandle();
 
 return parent;
}

// To get child window Id

public void childWindow() {
 
	Set<String> windowHandles = driver.getWindowHandles();
	String parentWindow = parentWindow();
	
	for (String allWindows : windowHandles) {
		if(!parentWindow.equals(allWindows)) {
			
			driver.switchTo().window(allWindows);
		}
		
	}
	
}
			
			
}
