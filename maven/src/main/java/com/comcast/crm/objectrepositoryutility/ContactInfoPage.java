package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(className = "dvHeaderText")
    private WebElement lastnameinfo;
	
	@FindBy(id = "dtlview_Support Start Date")
    private WebElement startDateinfo;
	
	@FindBy(id = "dtlview_Support End Date")
    private WebElement endDateinfo;
	
	
	
	public WebElement getStartDateinfo() {
		return startDateinfo;
	}



	public WebElement getEndDateinfo() {
		return endDateinfo;
	}



	public WebElement getLastnameinfo() {
		return lastnameinfo;
	}
	
	
	
}
