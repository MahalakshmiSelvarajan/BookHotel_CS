package pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ReadData;
import base.TestBase;

public class PersonalDetails extends TestBase {
	
//----------------------Locators---------------------------------------

//----------------------Personal Details Section------------------------------	
	@FindBy(xpath="//th[contains(text(),'Personal')]") WebElement personalDetails;
	@FindBy(id="txtFirstName") WebElement txtFirstName;
	@FindBy(id="txtLastName") WebElement txtLastName;
	@FindBy(id="txtEmail") WebElement txtEmail;
	@FindBy(id="txtPhone") WebElement txtPhone;
	@FindBy(xpath="//textarea[@rows='5']") WebElement txtAddress;
	@FindBy(xpath="//select[@name='city']") WebElement drpCity;
	@FindBy(xpath="//select[@name='state']") WebElement drpState;
	@FindBy(xpath="//select[@name='persons']") WebElement drpPersons;
	@FindBy(id="rooms") WebElement roomsCount;
	
//-----------------------Payment Detail Section---------------------------------
	
	@FindBy(xpath="//th[contains(text(),'Payment')]") WebElement paymentDetails;
	
	@FindBy(id="txtCardholderName") WebElement txtCardholderName;
	@FindBy(id="txtDebit") WebElement txtDebit;
	@FindBy(id="txtCvv") WebElement txtCvv;
	@FindBy(id="txtMonth") WebElement txtMonth;
	@FindBy(id="txtYear") WebElement txtYear;
	
//----------------------Confirm Booking--------------------------------------------
	
	@FindBy(id="btnPayment") WebElement btnPayment;
	@FindBy(xpath="//h1[@align='center']") WebElement msgSuccess;
	
//------------------------Actions--------------------------------------------------
	
	ReadData readdata = new ReadData();
	
	public PersonalDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ConfirmBtn()
	{
		btnPayment.click();
	}
	
	public void Firstname() throws IOException
	{
		txtFirstName.sendKeys(readdata.readData("FirstName"));
	}
	
	public void Lastname() throws IOException
	{
		txtLastName.sendKeys(readdata.readData("LastName"));
	}
	
	public void Email() throws IOException
	{
		txtEmail.sendKeys(readdata.readData("Email"));
	}
	public void Invalidphoneno() throws IOException
	{
		txtPhone.sendKeys("8");
		
	}
	public void Validphoneno() throws IOException, InterruptedException
	{
		txtPhone.clear();
		Thread.sleep(1000);
		txtPhone.sendKeys("987654321");
	}
	public void Address() throws IOException
	{
		txtAddress.sendKeys(readdata.readData("Address"));
	}
	public void City() throws IOException
	{
		Select drpcity=new Select(drpCity);
		drpcity.selectByValue("Chennai");
	}
	public void State() throws IOException
	{
		Select drpstate=new Select(drpState);
		drpstate.selectByValue("Tamilnadu");
	}
	public void Persons() throws IOException
	{
		Select drppersons=new Select(drpPersons);
		drppersons.selectByIndex(2);
	}
	public void CardHolderName() throws IOException
	{
		txtCardholderName.sendKeys(readdata.readData("CardHolderName"));
	}
	public void Debit() throws IOException
	{
		txtDebit.sendKeys("9876543212345678");
	}
	public void CVV() throws IOException
	{
		txtCvv.sendKeys("111");
	}
	public void ExpiryMonth() throws IOException
	{
		txtMonth.sendKeys(readdata.readData("ExpiryMonth"));
	}
	public void ExpiryYear() throws IOException
	{
		txtYear.sendKeys("2025");
	}
	public void Alert()
	{
		Alert alert =driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	}
	public String MsgSuccess()
	{
		return msgSuccess.getText();
	}
	
	

}
