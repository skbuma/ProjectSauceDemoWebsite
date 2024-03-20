package saucedemoproject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ProjectTest{
	
	/*Login Page of saucedemo website
	 * Declaring the fields in this class globally
	 * Identifying the locators and placing here globally
	 * (so that even if we have to change the locators in future
	 * change in this file is enough. No need to change or touch any other files)
	 * This is called PageObjectModel
	 */
	
	
	WebDriver driver;
	
	
	By UsernameField=By.xpath("//input[@id='user-name']");
	By PasswordField=By.xpath("//input[@id='password']");
	By LoginButton=By.xpath("//input[@name='login-button']");
	By Products=By.xpath("//*[contains(text(),'Products')]");
	By AddtoCart=By.xpath("(//button[text()='Add to cart'])[1]");
	By ShoppingCart=By.xpath("//a[@class='shopping_cart_link']");
	By Checkout=By.xpath("//button[text()='Checkout']");
	By CheckoutInfo=By.xpath("//span[contains(text(),'Your Information')]");
     
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

  //TS3: Fill UserName Textbox with Input
  	public void type_Username(String uname) throws InterruptedException
  	{
  		driver.findElement(UsernameField).sendKeys(uname);
  		Thread.sleep(1000);
  	}
  			
  	//TS4: Fill Password Textbox with Input
  	public void type_Password(String pwd) throws InterruptedException
  	{
  	
  			driver.findElement(PasswordField).sendKeys(pwd);
  			Thread.sleep(1000);
  	}
  	
  	
  			//TS5: Click on Login Button
  	public void click_Login() throws InterruptedException
  	{
  			driver.findElement(LoginButton).click();
  			Thread.sleep(1000);
  	}
    
  	public String captureProductsText() {
  	    String s = driver.findElement(By.xpath("//*[contains(text(),'Products')]")).getText();
  	    System.out.println("captureProductsText = " + s);
  	    return s;
  	}
	
	public void click_AddtoCart() throws InterruptedException
	{
		driver.findElement(AddtoCart).click();
		Thread.sleep(1000);
	}
	public void click_ShoppingCart() throws InterruptedException
	{
		driver.findElement(ShoppingCart).click();
		Thread.sleep(1000);
	}
	public void click_Checkout() throws InterruptedException
	{
		driver.findElement(Checkout).click();
		Thread.sleep(1000);
	}
	public String capture_Checkoutinfo()
	{
		return driver.findElement(CheckoutInfo).getText();
	}
         
  
}
