package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSVReportValidationSteps {
	WebDriver driver;
	@Given("User is on Applicants report page")
	public void user_is_on_Applicants_report_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");
	}

	@Given("cvs report is generated")
	public void cvs_report_is_generated() {
	    
	}

	@Then("data in ui and csv report should match")
	public void data_in_ui_and_csv_report_should_match() {
	   
	}

}
