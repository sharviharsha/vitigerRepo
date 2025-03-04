package ProjectImplementationInBaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.crm.generic.baseUtility.BaseClassTest;
//@Listeners(com.crm.comcast.listenerUtility.LisImpClass.class)
public class RealPrjctCreateContactTest extends BaseClassTest {
	@Test(groups = "smokeTest")

	public void createContact() throws Throwable {
		// read data from excel file
		//UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String lastName = eLib.getDataFromExcel("Sheet2", 1, 2) + jLib.getRandomNumber();

		// navigate to contact module
		//UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact Page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create contact Button
		//UtilityClassObject.getTest().log(Status.INFO, "navigate to create Contact Page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		// enter all the deatail and create new contact
		//UtilityClassObject.getTest().log(Status.INFO, " createa new  Org ");
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);

		ccp.getLastnameEdt().sendKeys(lastName);
		//UtilityClassObject.getTest().log(Status.INFO, lastName + " ===>createa new  Contact ");
		ccp.getSaveBtn().click();

		// verify last name Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actlastName = cip.getLastnameinfo().getText();
		System.out.println("=====verification====");
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(lastName, actlastName);
		// assertObj.assertAll();

	}

	@Test(groups = "regressionTest")
	public void createContactSupportDate() throws Throwable {
		// read data from excel file
		//UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String lastName = eLib.getDataFromExcel("Sheet2", 1, 2) + jLib.getRandomNumber();

		// Step 2: navigate to contact module
		//UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact Page");
		HomePage hm = new HomePage(driver);
		hm.getContactLink().click();

		// Step 3: click on "create contact " button
		//UtilityClassObject.getTest().log(Status.INFO, "navigate to create Contact Page");
		ContactPage conp = new ContactPage(driver);
		conp.getCreateContactBtn().click();

		// Step 4: enter all the details & create new contact
		//UtilityClassObject.getTest().log(Status.INFO, " createa new  Contact ");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnameEdt().sendKeys(lastName);
		String supportStartDate = jLib.getSystemDateYYYYDDMM();
		String supportEndDate = jLib.getRequiredDateYYYYDDMM(30);
		cncp.getStartDateEdt().clear();
		cncp.getStartDateEdt().sendKeys(supportStartDate);
		cncp.getEndDateEdt().clear();

		cncp.getEndDateEdt().sendKeys(supportEndDate);
		//UtilityClassObject.getTest().log(Status.INFO, lastName + " ===>createa new  Contact ");
		cncp.getSaveBtn().click();

		// verify start date Expected Result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actstartDate = cip.getStartDateinfo().getText();
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(supportStartDate, actstartDate);
		assertObj.assertAll();

		// verify end date Expected Result

		cip = new ContactInfoPage(driver);
		String actendtDate = cip.getEndDateinfo().getText();
		SoftAssert assertObj1 = new SoftAssert();
		assertObj1.assertEquals(supportEndDate, actendtDate);
		assertObj1.assertAll();

	}
}
