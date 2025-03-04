package ProjectImplementationInBaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClassTest;
//@Listeners(com.crm.comcast.listenerUtility.LisImpClass.class)
public class RealPrjctCreateOrgTest extends BaseClassTest {
	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		// read test script data from excel file
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
		
		// Step 2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();

		// Step 3: click on "create organization " button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, " createa new  Org ");
		CreatingNewOrganization cnop = new CreatingNewOrganization(driver);
		
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+" ===>createa new  Org ");
		
		// verify header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		System.out.println("=====verification====");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(orgName, actOrgName);
		//soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNum() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
		String Phone = eLib.getDataFromExcel("Sheet1", 7, 3);
		
		// Step 2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();

		// Step 3: click on "create organization " button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, " createa new  new phone number ");
		CreatingNewOrganization cnop = new CreatingNewOrganization(driver);
		cnop.createOrg(orgName);
		
		cnop.getPhoneEdt().sendKeys(Phone);
		UtilityClassObject.getTest().log(Status.INFO, Phone+" ===>createa new  phone number ");

		// verify header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actphone = oip.getActphone().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(Phone, actphone);
	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustries() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
		String Industry = eLib.getDataFromExcel("Sheet1", 4, 3);
		String Type = eLib.getDataFromExcel("Sheet1", 4, 4);
		
		// Step 2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();

		// Step 3: click on "create organization " button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: enter all the details & create new industries
		UtilityClassObject.getTest().log(Status.INFO, " createa new  industries ");
		CreatingNewOrganization cnop = new CreatingNewOrganization(driver);
		
		cnop.createOrg(orgName, Industry, Type);
		UtilityClassObject.getTest().log(Status.INFO, Industry+" ===>createa new  industries ");

		// verify industry name Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustry = oip.getActIndustry().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(Industry, actIndustry);

		// verify industry name Expected Result
		OrganizationInfoPage oip1 = new OrganizationInfoPage(driver);
		String actType = oip1.getActType().getText();
		SoftAssert soft1=new SoftAssert();
		soft1.assertEquals(Type, actType);

	}
}
