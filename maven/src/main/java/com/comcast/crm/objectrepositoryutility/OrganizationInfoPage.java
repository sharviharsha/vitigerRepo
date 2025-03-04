package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(className = "dvHeaderText")
    private WebElement headerMsg;
	
	@FindBy(id="dtlview_Phone")
    private WebElement actphone;
	
	@FindBy(id="mouseArea_Industry")
    private WebElement actIndustry;
	
	@FindBy(id="mouseArea_Type")
    private WebElement actType;
	
	public WebElement getActType() {
		return actType;
	}



	public WebElement getActIndustry() {
		return actIndustry;
	}



	public WebElement getActphone() {
		return actphone;
	}



	public WebElement getHeaderMsg()
	{
		return headerMsg;
	}
	
	
}
