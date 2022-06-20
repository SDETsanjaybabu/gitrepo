package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderTxt;
	
	
	public OrganisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getOrgHeaderTxt() {
		return orgHeaderTxt;
	}

	
	public void verifyOrgName(String orgName) {
		orgHeaderTxt.sendKeys(orgName);
	}
}