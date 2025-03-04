package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage 
{
	WebDriver driver;
	public CreatingNewContactPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateEdt;
	
	
	
	
	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
