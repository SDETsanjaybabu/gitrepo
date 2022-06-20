package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
@FindBys({@FindBy(name = "user_name"),@FindBy(xpath = "//input[@type='text']")})
private WebElement usernameEdt;

@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type='passw']")})
private WebElement passwordEdt;

@FindBy(id = "submitButton")
private WebElement submitBtn;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



public WebElement getUsernameEdt() {
	return usernameEdt;
}
public WebElement getPasswordEdt() {
	return passwordEdt;
}
public WebElement getSubmitBtn() {
	return submitBtn;
}


public void loginToAppln(String username,String password) {
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	submitBtn.click();
}
}