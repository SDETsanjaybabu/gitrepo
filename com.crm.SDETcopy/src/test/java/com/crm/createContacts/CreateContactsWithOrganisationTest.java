package com.crm.createContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsWithOrganisationTest extends BaseClass{
@Test
	public void createContactsWithOrganisationTest() throws Throwable {
		
			//To get random number
		    int randNum = jLib.getRandomNumber();
			
			//Fetching the firstName from excelSheet
		    String FirstName = eLib.readDataFromExcel("Sheet1", 7, 2)+randNum;

			//fetching the lastname from excelSheet
		    String LastName = eLib.readDataFromExcel("Sheet1", 8, 2)+randNum;
		    
			//click on contacts link
			HomePage hpage=new HomePage(driver);
			hpage.getContactsLnk().click();
			
			//click on create contacts icon
			ContactsPage cpgae=new ContactsPage(driver);
			cpgae.clickOnCreateCtctLkImg();
			
			//enter the first name
			CreateContactsPage cgpage=new CreateContactsPage(driver);
			cgpage.enterContactInfo(driver, FirstName, LastName);
			
			//verify whether the contact is created or not
			ContactsInfoPage cipage=new ContactsInfoPage(driver);
			String presentContactName = cipage.getCnctHeaderTxt().getText();
			SoftAssert soft=new SoftAssert();
			soft.assertTrue(presentContactName.contains(LastName));
			System.out.println("Test case passed");
			soft.assertAll();
			
//			if(presentContactName.contains(LastName))
//			{
//			System.out.println("Contact with organisation is created");
//			}else {
//			System.out.println("Contacts with organisation is not created");
//			}	
	}
}