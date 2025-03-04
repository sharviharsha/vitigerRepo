package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
   @FindBy(linkText = "Organizations")
   private WebElement orgLink;
   
   @FindBy(linkText = "Contacts")
   private WebElement contactLink;
   
   @FindBy(linkText = "Campaigns")
   private WebElement campaignsLink;
   
   @FindBy(linkText = "More")
   private WebElement moreLink;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminImg;
   
   @FindBy(linkText = "Sign Out")
   private WebElement signOutLink;
  
   public WebElement getOrgLink() {
	return orgLink;
   }

   public WebElement getContactLink() {
	return contactLink;
   }

    public WebElement getCampaignsLink() {
	return campaignsLink;
   }
    
    public WebElement getMoreLink() {
		return moreLink;
	}
  
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void navigateToCampaignPage()
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(moreLink).perform();
    	campaignsLink.click();
    }
	
	public void logout()
	{
		//Actions acn=new Actions(driver);
		//acn.moveToElement(adminImg).perform();
		adminImg.click();
        signOutLink.click();
	}
   
}
