package saucedemoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckoutPage {
	
	private WebDriver driver;
    
    private By addFirstName = By.xpath("//input[@id='first-name']");
    private By addLastName = By.xpath("//input[@id='last-name']");
    private By addPostalCode = By.xpath("//input[@id='postal-code']");
    private By checkoutBtn = By.xpath("//input[@id='continue']");
    private By finishBtn = By.xpath("//button[@id='finish']");
    private By finishPage = By.xpath("//*[contains(text(),'Thank you for your order!')]");
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    @Test(priority=1)
   	public void ClickCheckoutPageBtn() throws InterruptedException
   	{
   		System.out.println("Start ClickCheckoutPageBtn");
   		
		driver.findElement(addFirstName).sendKeys("Uma Maheswari");
		Thread.sleep(1000);
		driver.findElement(addLastName).sendKeys("Sivaramu Kannan");
		Thread.sleep(1000);	      
		
		driver.findElement(addPostalCode).sendKeys("530022");
		Thread.sleep(1000);
		
		driver.findElement(checkoutBtn).click();
		Thread.sleep(1000);
		        
		System.out.println("End ClickCheckoutPageBtn");
   	}
    
    
    @Test(priority=2)
   	public void ClickFinishBtn() throws InterruptedException
   	{
   		System.out.println("Start ClickFinishBtn");
   		
		driver.findElement(finishBtn).click();
		Thread.sleep(5000);
		
		System.out.println("End ClickFinishBtn");
		   		
   		
   	}
    
    @Test(priority=3)
   	public void checkFinalPage() throws InterruptedException
   	{
   		System.out.println("Start checkFinalPage");
   		
		String finalPageMsg = driver.findElement(finishPage).getText();
		Thread.sleep(3000);
		System.out.println("finalPageMsg  == : " + finalPageMsg);
		
		if (finalPageMsg.equalsIgnoreCase("Thank you for your order!"))
		{
			System.out.println("Order Placed Successfully");
		}
		else
		{
			System.out.println("Order Not Placed Successfully");
		}
		Thread.sleep(3000);   		
		System.out.println("End checkFinalPage");
   	}
	
  
}
