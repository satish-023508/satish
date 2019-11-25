package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_simple_POM {
	
    private WebDriver driver; 
   
	public UNF_simple_POM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement Username;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	private WebElement Verifythedashboardtext;
	
	@FindBy(id="catalog")
	private WebElement Catalog;
	
	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(xpath="//h1[text()='Products']")
	private WebElement Verifytheproducttext;
	
	@FindBy(id="input-name")
	private WebElement Productname;
	
	@FindBy(id="button-filter")
	private WebElement FilterBtn;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement DeleteBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement Deletesuccessmsg;
	
	@FindBy(id="reports")
	private WebElement Reports;
	
	@FindBy(linkText="Sales")
	private WebElement sales;
	
	@FindBy(linkText="Orders")
	private WebElement orders;
	
	// @FindBy(xpath="//i[@class='fa fa-calendar']")
	// private WebElement Selectcal;
	
	// @FindBy(xpath="//th[@class='prev']")
	// private WebElement prevmonth;
	
	// @FindBy(xpath="//td[text()='10']")
	// private WebElement Startdate;
	
	   @FindBy(id="input-date-start")
	   private WebElement Startdate;
	   
	   @FindBy(id="input-date-end")
	   private WebElement Enddate;
	   
	   @FindBy(xpath="//i[@class='fa fa-search']")
		private WebElement Btnfilter;
	   
	   @FindBy(id="input-group")
	   private WebElement GroupBy;
	   
	   @FindBy(id="input-status")
	   private WebElement OrderStatus;
	   
	   @FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[2]/td[1]/input[@type='checkbox']")
		private WebElement select2ndcheckbox;
	   
	   @FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[3]/td[1]/input[@type='checkbox']")
		private WebElement select3rdcheckbox;
	   
	   @FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[4]/td[1]/input[@type='checkbox']")
		private WebElement select4thcheckbox;
	   
	   @FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[2]/td[6]/span[@class='label label-success']")
		private WebElement gettheqty;
	   
	   @FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[2]/td[8]/a")
		private WebElement select2ndeditbtn;
	   
	   @FindBy(linkText="Data")
	   private WebElement datatab;
	   
	   @FindBy(id="input-quantity")
		private WebElement inputqty;
	   
	   @FindBy(xpath="//i[@class='fa fa-save']")
		private WebElement SaveBtn;
	   
	   @FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']")
		private WebElement CartBtn;
	   
	   @FindBy(linkText="Orders")
		private WebElement Orders;
	   
	   @FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[8]/td[8]/a")
		private WebElement selectViewbtn;
	   
	   @FindBy(id="button-invoice")
		private WebElement InvoiceBtn;
	   
	   @FindBy(id="invoice")
		private WebElement InvoiceTxt;
	   
	
	
	public void sendUserName(String Username) {
		this.Username.clear();
		this.Username.sendKeys(Username);
	}
	
	public void sendPassword(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password); 
	}
	
	public void clickLoginBtn() {
		this.LoginBtn.click(); 
	}
	
	public void Verifyingdashboardtext() {
	if (this.Verifythedashboardtext.getText().equals("Dashboard")) {
		System.out.println("U are on Dashboard page");
	} else {
		System.out.println("U are NOT on Dashboard page");
	}
	}
	
	public void clickProducts() {
		Actions act = new Actions(driver);
		act.moveToElement(Catalog).build().perform();
		this.products.click();
		if (this.Verifytheproducttext.getText().equals("Products")) {
			System.out.println("U are on Products page");
		} else {
			System.out.println("U are NOT on Products page");
		}
	}
	
	public void enterproductname(String Productname) {
		this.Productname.clear();
		this.Productname.sendKeys(Productname);
	}
	
	public void clickfilterbtn() {
		this.FilterBtn.click();
	}
	
	public void countitems() {
		List<WebElement> Countitems = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
		int n = Countitems.size();
		System.out.println("no of records found"+" = "+n);
	}
	
	public void deleteProduct() throws InterruptedException {
	 List<WebElement> Selectcheckbox1 = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
	 int n1 = Selectcheckbox1.size();
	System.out.println("no of records before delete"+" = "+n1);
	this.select2ndcheckbox.click();	
	 this.DeleteBtn.click();
		Thread.sleep(5000);
		if (driver.switchTo().alert().getText().equals("Are you sure?")) 
		{
			System.out.println("The delete pop up window has correct text");
            driver.switchTo().alert().accept();
		} else {
    			System.out.println("U are NOT on delete pop up window");
    		}
		System.out.println(this.Deletesuccessmsg.getText());
		List<WebElement> Selectcheckbox2 = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
		int n2 = Selectcheckbox2.size();
		System.out.println("no of records after delete"+" = "+n2);
		}                    
	
	public void clickorders() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(Reports).build().perform();
		this.sales.click();
		this.orders.click();
	}

	public void startdate (String Startdate) {
		this.Startdate.clear();
		this.Startdate.sendKeys(Startdate);
	}
	
	public void enddate (String Enddate) {
		this.Enddate.clear();
		this.Enddate.sendKeys(Enddate);
	}
	
	public void filterbtn() {
		this.Btnfilter.click();
	}
	
	public void itemscount() {
		List<WebElement> Itemscount = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
		int n3 = Itemscount.size();
		System.out.println("no of records found"+" = "+n3);
	}

	public void selectgroup() {
		Select groupby = new Select(GroupBy);
		groupby.selectByValue("week");
	}
	
    public void selectorderstatus() {
    	Select orderstatus = new Select(OrderStatus);
    	orderstatus.selectByValue("5");
	}
    
    public void GetQty() {
    	System.out.println("Qty before editing"+" = "+ this.gettheqty.getText());
	}
    
    public void clickeditbtn() {
		this.select2ndeditbtn.click();
	}
	
    public void editqty(String Qty) {
		this.datatab.click();
		this.inputqty.clear();
		this.inputqty.sendKeys(Qty);
	}
    
    public void SaveandCheck() {
    	this.SaveBtn.click();
    	System.out.println(this.Deletesuccessmsg.getText());
    }
    
    public void GetQtyAfter() {
    	System.out.println("Qty after editing"+" = "+ this.gettheqty.getText());
	}
    
    public void deleteMultiProd() throws InterruptedException {
   	 List<WebElement> Selectcheckbox1 = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
   	 int n1 = Selectcheckbox1.size();
   	System.out.println("no of records before delete"+" = "+n1);
   	this.select3rdcheckbox.click();	
   	this.select4thcheckbox.click();	
   	this.DeleteBtn.click();
   		Thread.sleep(5000);
   		if (driver.switchTo().alert().getText().equals("Are you sure?")) 
   		{
   			System.out.println("The delete pop up window has correct text");
               driver.switchTo().alert().accept();
   		} else {
       			System.out.println("U are NOT on delete pop up window");
       		}
   		System.out.println(this.Deletesuccessmsg.getText());
   		List<WebElement> Selectcheckbox2 = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
   		int n2 = Selectcheckbox2.size();
   		System.out.println("no of records after delete"+" = "+n2); 
   		}       
    
    public void clickCartorders() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(CartBtn).build().perform();
		this.Orders.click();
	}
    
    public void generateInvNum() throws InterruptedException {
		this.selectViewbtn.click();
		this.InvoiceBtn.click();
		Thread.sleep(5000);
		System.out.println("the invoice number generated"+" = "+this.InvoiceTxt.getText());
	}
    
}  	

     


