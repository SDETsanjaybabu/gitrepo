package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

@FindBy(name = "accountname")
private WebElement organisationNameEdt;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name = "industry")
private WebElement indusDropDown;

@FindBy(name = "accounttype")
private WebElement typeDropDown;

public OrganisationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getOrganisationNameEdt() {
	return organisationNameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getIndusDropDown() {
	return indusDropDown;
}


public WebElement getTypeDropDown() {
	return typeDropDown;
}

public void enterOrganisationNameEdt(String orgName)
{ 
	organisationNameEdt.sendKeys(orgName);
	saveBtn.click();
}

public void enterOrgNameEdt(String orgname) {
	organisationNameEdt.sendKeys(orgname);
}
public void enterIndDrop() {
	indusDropDown.sendKeys("Education");
}
public void enterTypeDrop() {
	typeDropDown.sendKeys("Partner");
	saveBtn.click();
}
}
