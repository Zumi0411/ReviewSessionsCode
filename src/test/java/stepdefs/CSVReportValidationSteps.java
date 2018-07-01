package stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSVReportValidationSteps {

	Map<Integer, Map<String, String>> UIDataMap = new HashMap<>();
	
	Map<Integer, Map<String, String>> CSVDataMap = new HashMap<>();

	WebDriver driver;

	@Given("User is on Applicants report page")
	public void user_is_on_Applicants_report_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
	}

	@Given("User can read applicants data from table")
	public void user_can_read_applicants_data_from_table() throws InterruptedException {
		// select 100 records per page
		Select perPage = new Select(driver.findElement(By.id("recPerPage")));
		perPage.selectByIndex(perPage.getOptions().size() - 1);
		// wait for 100 records to show up
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='reportTab']/tbody/tr"), 10));

		// find out total#Of Records
		// int totalRecords =
		// Integer.parseInt(driver.findElement(By.id("total")).getText());

		// Map<Integer,Map<String,String>> UIDataMap = new HashMap<>();

		int rowsOnPage = driver.findElements(By.xpath("//table[@id='reportTab']/tbody/tr")).size();

		for (int row = 1; row <= rowsOnPage; row++) {

			Integer empID = null;
			Map<String, String> empMap = new HashMap<>();

			for (int cell = 1; cell <= 5; cell++) {
				String cellValue = driver
						.findElement(By.xpath("//table[@id='reportTab']/tbody/tr[" + row + "]/td[" + cell + "]"))
						.getText().trim();
				switch (cell) {
				case 1:
					empID = Integer.valueOf(cellValue);
					break;
				case 2:
					empMap.put("Full name", cellValue);
					break;
				case 3:
					empMap.put("Email", cellValue);
					break;
				case 4:
					empMap.put("Phone", cellValue);
					break;
				case 5:
					empMap.put("Current Annual Salary", cellValue);
					break;
				}
			}

			UIDataMap.put(empID, empMap);
		}

		System.out.println(UIDataMap.toString());

	}

	@Given("cvs report is generated")
	public void cvs_report_is_generated() throws IOException {
		//CSVReader csvReader = new CSVReader(new FileReader("applicants.csv"));
		CSVReader csvReader = new CSVReaderBuilder(
									new FileReader("applicants.csv"))
									.withSkipLines(1)
									.build();

		List<String[]> csvDataList = csvReader.readAll();

		for (String[] rowData : csvDataList) {
			Integer empID = null;
			Map<String, String> empMap = new HashMap<>();

			for (int cell = 0; cell < rowData.length; cell++) {
				String cellValue = rowData[cell];
				switch (cell) {
				case 0:
					empID = Integer.valueOf(cellValue);
					break;
				case 1:
					empMap.put("Full name", cellValue);
					break;
				case 2:
					empMap.put("Email", cellValue);
					break;
				case 3:
					empMap.put("Phone", cellValue);
					break;
				case 4:
					empMap.put("Current Annual Salary", cellValue);
					break;
				}
			}
			
			CSVDataMap.put(empID, empMap);
			
		}
		
		System.out.println("CSV---------");
		System.out.println(CSVDataMap.toString());
		
	}

	
	/*
	 * Map<Integer, Map<String, String>> UIDataMap = new HashMap<>();
	   Map<Integer, Map<String, String>> CSVDataMap = new HashMap<>();
	 * 
	 */
	@Then("data in ui and csv report should match")
	public void data_in_ui_and_csv_report_should_match() throws IOException {
		for (Integer empID : CSVDataMap.keySet()) {
			
			if(UIDataMap.containsKey(empID)) {
				assertEquals(CSVDataMap.get(empID) , UIDataMap.get(empID));
			}else {
				fail("Employee data:" + empID +" is not found in UI");
			}
		}
	}

}
