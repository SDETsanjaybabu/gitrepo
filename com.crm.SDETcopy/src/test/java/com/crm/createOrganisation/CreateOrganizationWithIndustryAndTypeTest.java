package com.crm.createOrganisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectRepository.CreateOrganisationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass{
	@Test
	public void createOrgWithIndType() throws Throwable
	{
		//String value=System.getProperty("key");
		//System.out.println(System.getProperty("PARAMETER_KEY"));
		//To get random number
		int randNum = jLib.getRandomNumber();
		
		//Fetching data from excelSheet
		String orgName = eLib.readDataFromExcel("Sheet1", 4, 2)+randNum;
	
		HomePage hpage = new HomePage(driver);
		hpage.clickOnOrgLink();
		
		CreateOrganisationPage cpage = new CreateOrganisationPage(driver);
		cpage.clickOnCreateOrgLkUpImg();
		
		OrganisationPage opage = new OrganisationPage(driver);
		opage.enterOrgNameEdt(orgName);
		
	
		//select the industry from industry drop down
		OrganisationPage ogpage=new OrganisationPage(driver);
		ogpage.enterOrgNameEdt(orgName);
		ogpage.enterIndDrop();
		ogpage.enterTypeDrop();
		
		//verify whether the organisation is created or not
		OrganisationInfoPage oipage=new OrganisationInfoPage(driver);
		String presentOrgName = oipage.getOrgHeaderTxt().getText();
		Assert.assertTrue(presentOrgName.contains(orgName));
	}
}
