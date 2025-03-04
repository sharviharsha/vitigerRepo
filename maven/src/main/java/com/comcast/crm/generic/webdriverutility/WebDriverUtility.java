package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
 public void waitForPageToLoad(WebDriver driver)
 {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 
 }
 
 public void waitForElementPresent(WebDriver driver, WebElement element)
 {
	 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 
 }
 
 
 public void switchToTabOnURL(WebDriver driver , String partialURL)
 {
	 Set<String> set = driver.getWindowHandles();
	   Iterator<String> iter = set.iterator();
	   
	   while(iter.hasNext())
	   {
		   String windowId=iter.next();
		  driver.switchTo().window(windowId) ;
		  
		String acturl = driver.getCurrentUrl();
		if(acturl.contains(partialURL))
		{
			break;
		}
		  
	   }
 }
 
 public void switchToTabOnTitle(WebDriver driver , String partialTitle)
 {
	 Set<String> set = driver.getWindowHandles();
	   Iterator<String> iter = set.iterator();
	   
	   while(iter.hasNext())
	   {
		   String windowId=iter.next();
		  driver.switchTo().window(windowId) ;
		  
		String acturl = driver.getTitle();
		if(acturl.contains(partialTitle))
		{
			break;
		}
		  
	   }
 }
 public void switchToFrame(WebDriver driver, String nameID)
 {
	 driver.switchTo().frame(nameID);
 }
 
 public void switchToFrame(WebDriver driver, int index)
 {
	 driver.switchTo().frame(index);
 }
 public void switchToFrame(WebDriver driver, WebElement element)
 {
	 driver.switchTo().frame(element);
 }
 
 public void switchToAlertAndAccept(WebDriver driver)
 {
	 driver.switchTo().alert().accept();
 }
 public void switchToAlertAndCancel(WebDriver driver)
 {
	 driver.switchTo().alert().dismiss();
 }
 public void select(WebElement element,String text)
 {
	 Select sel=new Select(element);
	 sel.selectByVisibleText(text);
 }
 public void select(WebElement element,int index)
 {
	 Select sel=new Select(element);
	 sel.selectByIndex(index);
 }
public void mousemoveOnElement(WebDriver driver, WebElement element)
{
Actions act=new Actions(driver);
act.doubleClick(element).perform();
}
 
 public void waitForElementToBeClickable(WebDriver driver, WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
 }
 
 public void waitForElementToBeInvisible(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.invisibilityOf(element));
 }
 
 public void waitForElementToBeVisible(WebDriver driver, WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.visibilityOf(element));
 }
 
 public void doubleClick(WebDriver driver, WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.doubleClick(element).perform();
 }
 
 public void dragAndDrop(WebDriver driver, WebElement elementFrom, WebElement elementTo)
 {
	 Actions act=new Actions(driver);
	 act.dragAndDrop(elementFrom, elementTo).perform();
 }
 
 public void rightClick(WebDriver driver, WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.contextClick().perform();
 }
 public void scrollByAmount(WebDriver driver, int x,int y)
 {
	 Actions act=new Actions(driver);
	 act.scrollByAmount(x, y).perform();
 }
 
 public void scrollToElement(WebDriver driver,WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.scrollToElement(element).perform();
 }
 
 public void scrollToElementAndClick(WebDriver driver, WebElement element)
 {
	 Actions act=new Actions(driver);
	 act.scrollToElement(element).click();
 }
 
 public void sendKeysToElement(WebDriver driver, WebElement element, String keys)
 {
	 Actions act=new Actions(driver);
	 act.moveToElement(element).click().sendKeys(keys).perform();
 }
}
