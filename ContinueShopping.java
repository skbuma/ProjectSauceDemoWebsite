package saucedemoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ContinueShopping {
  
	private WebDriver driver;
      
    private By continueShoppingBtn = By.xpath("//button[@id='continue-shopping']");
    private By addTshirt = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    private By addJacket = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']");
    private By checkoutBtn = By.xpath("//button[@id='checkout']");
    private By checkFinalPageBtn = By.xpath("//*[contains(text(),'Thank you for your order!')]");
    
    public ContinueShopping(WebDriver driver) {
        this.driver = driver;
    }
	
		
    @Test(priority=1)
	public void ClickContinueShopping() throws InterruptedException
	{
		System.out.println("Start ContinueShopping");
		
		driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		Thread.sleep(1000);
		driver.findElement(addTshirt).click();
        Thread.sleep(1000);
           
        driver.findElement(addJacket).click();
        Thread.sleep(1000);
             
        System.out.println("End ContinueShopping");
		
		
	}
	
	
    @Test(priority=2)
     public void moveToCheckoutScreen() throws InterruptedException
     {
    	 WebElement cart = driver.findElement(shoppingCart);
    	 String cartValue = cart.getText();
    	 System.out.println("cartValue   " + cartValue);
    	 Thread.sleep(1000);    	 
    	 cart.click();
    	 Thread.sleep(5000); 
     } 
	
    @Test(priority=3)
    public void clickCheckoutButton() throws InterruptedException
    {
	   	 WebElement checkOutButton = driver.findElement(checkoutBtn);
	   	 checkOutButton.click();
	   	 Thread.sleep(3000);    	 
	   	 
    } 
	
    
    @Test(priority=4)
    public void checkFinalPage() throws InterruptedException
    {
	   	 WebElement finalPageBtn = driver.findElement(checkFinalPageBtn);
	   	 finalPageBtn.click();
	   	 Thread.sleep(3000);    	 
	   	 
    } 
    
    
}
