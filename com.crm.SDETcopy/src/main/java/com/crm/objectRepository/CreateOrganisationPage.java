package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLkUpImg;
	
	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLkUpImg() {
		return createOrgLkUpImg;
	}
	
	public void clickOnCreateOrgLkUpImg() {
		createOrgLkUpImg.click();
	}
}
