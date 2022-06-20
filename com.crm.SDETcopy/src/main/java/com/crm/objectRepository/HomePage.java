package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

@FindBy(linkText = "Organizations")
private WebElement organisationsLnk;

@FindBy(linkText = "Contacts")
private WebElement contactsLnk;

@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
private WebElement moreLnk;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorLnk;

@FindBy(linkText = "Sign Out")
private WebElement signOutLink;


public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getOrganisationsLnk() {
	return organisationsLnk;
}


public WebElement getContactsLnk() {
	return contactsLnk;
}


public WebElement getMoreLnk() {
	return moreLnk;
}


public WebElement getAdministratorLnk() {
	return administratorLnk;
}


public WebElement getSignOutLink() {
	return signOutLink;
}
	
public void clickOnOrgLink()
{
	organisationsLnk.click();
}

public void clickOnContactsLink()
{
	contactsLnk.click();
}

public void logout(WebDriver driver) {
	mouseOverAnElement(driver, administratorLnk);
	signOutLink.click();
}
}
