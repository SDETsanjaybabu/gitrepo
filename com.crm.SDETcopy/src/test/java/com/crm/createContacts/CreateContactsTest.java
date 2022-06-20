package com.crm.createContacts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.google.common.io.Files;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest extends BaseClass{
	@Test
	public void createContactsTest() throws Throwable{

		//To generate random number 
		int randNum = jLib.getRandomNumber();
		
		//reading data from excel sheet
		String FirstName = eLib.readDataFromExcel("Sheet1", 7, 2)+randNum;

		//Fetch LastName from excelSheet
		String LastName = eLib.readDataFromExcel("Sheet1", 8, 2)+randNum;
		
		HomePage hpage = new HomePage(driver);
		hpage.getContactsLnk().click();
		
     	//click on create contacts icon
		ContactsPage cpage=new ContactsPage(driver);
		cpage.clickOnCreateCtctLkImg();
		
		//enter the first name
		CreateContactsPage cpg=new CreateContactsPage(driver);
		cpg.enterContactInfo(driver, FirstName, LastName);
		
		//verify whether the Contacts is created or not
		ContactsInfoPage cipage=new ContactsInfoPage(driver);
		String presentContactName=cipage.getCnctHeaderTxt().getText();
		Assert.assertTrue(presentContactName.contains(LastName));
//		if(presentContactName.contains(LastName))
//		{
//		System.out.println("Contact is created");
//		}else {
//		System.out.println("Contact is not created");
//		}
	}
}
