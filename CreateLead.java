package LearnTestngAssignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
	
@DataProvider(name="fetchdata")
	public String[][] SendData() {
String [] []data = new String[4][4];
	
	data[0][0]="TestLeaf";
	data[0][1] = "Sandhiya";
	data[0][2]="S";
	data[0][3]="91";
	
	data[1][0]="Tcs";
	data[1][1]="shruthi";
	data[1][2]="S";
	data[1][3]="99";
	
	
	data[2][0]="cts";
	data[2][1]="madhumitha";
	data[2][2]="s";
	data[2][3]="93";
	
	data[3][0]="Tcs";
	data[3][1]="haritha";
	data[3][2]="S";
	data[3][3]="92";
	
	return data;

	}
	
@Test(dataProvider="fetchdata")	
public void runCreateLead(String cname,String fname,String lname,String phno) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cname)) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		driver.close();
}
	

}



/*
 * testleaf sandhiya s 91
 * tcs shruthi s 99
 * cts madhu t 91
 * wipro priyanka t 92
*/
