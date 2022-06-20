package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility{

	@FindBy(name = "firstname")
	private WebElement firstNameTxtEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTxtEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrgLkUpImg;
	
	@FindBy(id = "search_txt")
	private WebElement searchTxtEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[.='TYSS54']")
	private WebElement orgName;
		
	

	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void enterContactInfo(WebDriver driver,String firstname,String lastname) {
		firstNameTxtEdt.sendKeys(firstname);
		lastNameTxtEdt.sendKeys(lastname);
		selectOrgLkUpImg.click();
		switchToWindow(driver,"Accounts&action");
		searchTxtEdt.sendKeys("Tyss");
		searchBtn.click();
		orgName.click();
		switchToWindow(driver,"Contacts&action");
		saveBtn.click();
	}
}
