package com.swarmhraut.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.swarmhraut.base.TestBase;
import com.swarmhraut.utilities.TestUtil;

public class MyInfo extends TestBase {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	
	public  void myInfo(Hashtable<String,String> data) throws InterruptedException {
		
if(!data.get("runmode").equals("Y")){
			
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
Thread.sleep(1000);

click("EditProfile_XPATH");
Thread.sleep(3000);
clear("EditProfileEmail_XPATH");
Thread.sleep(3000);
type("email",data.get("email"));
Thread.sleep(3000);
clear("EditProfileMobile_XPATH");
Thread.sleep(3000);
type("mobile",data.get("mobile"));
Thread.sleep(3000);
click("EditProfileupdatebtn_XPATH");
Thread.sleep(3000);
click("UsernameDropdown_XPATH");
Thread.sleep(3000);
click("Logoutbtn_XPATH");
Thread.sleep(3000);






/*
 * driver.findElement(By.xpath(OR.getProperty("Username_XPATH"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(OR.getProperty("Username_XPATH"))).sendKeys(
 * username); log.debug("Username Entered!!!"); Thread.sleep(1000);
 * driver.findElement(By.xpath(OR.getProperty("Password_XPATH"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(OR.getProperty("Password_XPATH"))).sendKeys(
 * password); log.debug("Password Entered!!!"); Thread.sleep(1000);
 * driver.findElement(By.xpath(OR.getProperty("Loginbtn_XPATH"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(OR.getProperty("UsernameDropdown_XPATH"))).click(
 * ); Thread.sleep(1000);
 * driver.findElement(By.xpath(OR.getProperty("Logoutbtn_XPATH"))).click();
 * Thread.sleep(3000);
 */
		/*
		 * Thread.sleep(3000);
		 * 
		 * Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		 * Assert.assertTrue(alert.getText().contains(alerttext)); Thread.sleep(3000);
		 * alert.accept();
		 */
	
		}

	@DataProvider (name ="getdata")
	public Object[][] getData() {

		String sheetName = "MyInfo";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				// -2
			}
		}

		return data;

	}

}
