package com.crm.createOrganisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.objectRepository.CreateOrganisationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationPage;

import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListnerImplementationClass.class)
public class ToCreateOrganisationTest extends BaseClass{
@Test()
public void createOrgTest() throws Throwable 
{
	
	//To get random number
	int randNum = jLib.getRandomNumber();
	
	//Fetching data from excelSheet
	String orgName = eLib.readDataFromExcel("Sheet1", 4, 2)+randNum;
	
	HomePage hpage=new HomePage(driver);
	hpage.clickOnOrgLink();

	CreateOrganisationPage cpage=new CreateOrganisationPage(driver);
	cpage.clickOnCreateOrgLkUpImg();
	
	OrganisationPage opage=new OrganisationPage(driver);
	opage.enterOrganisationNameEdt(orgName);
	
	//verify whether the organisation is created or not
	OrganisationInfoPage ogpage=new OrganisationInfoPage(driver);
	String presentOrgName = ogpage.getOrgHeaderTxt().getText();
	Assert.assertTrue(presentOrgName.contains(orgName));
}
}