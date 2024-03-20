package saucedemoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCart {
 
	private WebDriver driver;
    private LoginPage loginPage;
    
    private By addToCartbutton1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By addToCartbutton2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']");
    private By removeCartbutton1 = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private By removeCartbutton2 = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
    
        
    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }
    
       
    @Test(priority=1)       
    public void addToCartbutton() throws InterruptedException 
    {
    	System.out.println("Entered Add To cart");
    	
    	
        driver.findElement(addToCartbutton1).click();
        Thread.sleep(2000);
        System.out.println("addToCartbutton1 clicked");
        
        driver.findElement(addToCartbutton2).click();
        Thread.sleep(2000);
        System.out.println("addToCartbutton2 clicked");
        
     // Locate the shopping cart element
        WebElement cart = driver.findElement(shoppingCart);
        System.out.println("WebElement cart");
        Thread.sleep(2000);
        
        //Get the shopping cart value
        String cartValues = cart.getText();
        Thread.sleep(3000);
        System.out.println("cartValues  == " + cartValues); 
        
    }
    
    
    //empty the shopping cart
    @Test(priority=3)
     public void emptyShoppingCart() throws InterruptedException
     {
    	 WebElement cart = driver.findElement(shoppingCart);
    	 String cartValue = cart.getText();
    	 System.out.println("cartValue == " + cartValue);    	 
    	 Thread.sleep(1000);
    	 
    	 if (cartValue.isEmpty() == false) 
    	 {
    		 cart.click();
    		
    		 //Remove back-pack
    		 Thread.sleep(1000);
    		 driver.findElement(removeCartbutton1).click();
    		 System.out.println("back-pack Cleared ");
    		 Thread.sleep(3000);
    		 
    		//Remove bike-light
    		 driver.findElement(removeCartbutton2).click();
    		 System.out.println("bike-light Cleared ");
    		 Thread.sleep(1000);
    	 }
     } 
      
 }
