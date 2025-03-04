package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganization
{
	WebDriver driver;
	public CreatingNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="phone")
	private WebElement phoneEdt;
	
	
	
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName,String Industry, String Type)
	{
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDropDown);
		sel.selectByVisibleText(Industry);
		Select sel1=new Select(typeDropDown);
		sel1.selectByVisibleText(Type);
	    saveBtn.click();
	}
}
